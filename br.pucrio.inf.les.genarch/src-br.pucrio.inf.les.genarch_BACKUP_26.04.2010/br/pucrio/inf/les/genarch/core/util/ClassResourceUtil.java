package br.pucrio.inf.les.genarch.core.util;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.resources.dsl.JDTASTUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class ClassResourceUtil {
	
	public static void configureClassElement(IFile resource,String featureExpression) {	
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(resource.getProject());
		
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(resource.getProject().getFile(genarchProjectConfigurationFile.getFeatureModelPath()));					
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();
		ModelNavigation fmpNavigation = ModelNavigation.INSTANCE;
		Node model = fmpProject.getModel();
		
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(resource);
		ASTNode node = JDTASTUtil.astNode(resource,compilationUnit);
		AST ast = node.getAST();
		IDocument document = JDTASTUtil.createDocument(compilationUnit);

		CompilationUnit unit = (CompilationUnit)node;
		unit.recordModifications();

		BodyDeclaration bodyDeclaration = JDTASTUtil.bodyDeclaration(unit);

		SingleMemberAnnotation oldFeaturesAnnotation = (SingleMemberAnnotation)JavaAnnotationUtil.annotation(bodyDeclaration, "Features");
		if ( oldFeaturesAnnotation != null ) {
			JavaAnnotationUtil.removeAnnotation(bodyDeclaration, oldFeaturesAnnotation);	   
		}

		NormalAnnotation oldFeatureAnnotation = (NormalAnnotation)JavaAnnotationUtil.annotation(bodyDeclaration, "Feature");
		if ( oldFeatureAnnotation != null ) {
			JavaAnnotationUtil.removeAnnotation(bodyDeclaration, oldFeatureAnnotation);
		}

		List<String> features = Logic.toFeatures(featureExpression);

		//Create new annotation in the element				
		if ( features.size() > 1 ) {
			SingleMemberAnnotation featuresAnnotation = JavaAnnotationUtil.newSingleMemberAnnotation(ast, "Features");
			ArrayInitializer arrayInitializer = ast.newArrayInitializer();

			//For each feature, get the informations on the feature model
			for ( String feature : features ) { 
				Node fmpFeature = fmpNavigation.findNodeWithName(model, feature);	   

				if ( fmpFeature instanceof Feature ) {
					Feature aux = (Feature)fmpFeature;
					NormalAnnotation normalAnnotation = JavaAnnotationUtil.newNormalAnnotation(ast, "Feature");
					JavaAnnotationUtil.addLiteralMemberValuePair(normalAnnotation, "name", aux.getName());

					Feature featureParent;

					if ( fmpFeature.eContainer() instanceof FeatureGroup ) {
						featureParent = (Feature)fmpFeature.eContainer().eContainer();
					} else {
						featureParent = (Feature)fmpFeature.eContainer();
					}

					JavaAnnotationUtil.addLiteralMemberValuePair(normalAnnotation, "parent", featureParent.getName());

					if (aux.isOptional() ) {
						JavaAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnotation, "type", "FeatureType", "optional");
					} else {
						JavaAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnotation, "type", "FeatureType", "mandatory");
					}
					
					JavaAnnotationUtil.addExpressionToArrayInitializer(arrayInitializer, normalAnnotation);
				}
			}

			featuresAnnotation.setValue(arrayInitializer);
			JavaAnnotationUtil.addAnnotation(bodyDeclaration, featuresAnnotation);
		} else if ( features.size() == 1 ) {
			Node fmpFeature = fmpNavigation.findNodeWithName(model, features.get(0));

			if ( fmpFeature instanceof Feature ) {
				Feature aux = (Feature)fmpFeature;
				NormalAnnotation normalAnnoation = JavaAnnotationUtil.newNormalAnnotation(ast, "Feature");
				JavaAnnotationUtil.addLiteralMemberValuePair(normalAnnoation, "name", aux.getName());

				Feature featureParent;

				if ( fmpFeature.eContainer() instanceof FeatureGroup ) {
					featureParent = (Feature)fmpFeature.eContainer().eContainer();
				} else {
					featureParent = (Feature)fmpFeature.eContainer();
				}

				JavaAnnotationUtil.addLiteralMemberValuePair(normalAnnoation, "parent", featureParent.getName());

				if (aux.isOptional() ) {
					JavaAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnoation, "type", "FeatureType", "optional");
				} else {
					JavaAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnoation, "type", "FeatureType", "mandatory");
				}

				JavaAnnotationUtil.addAnnotation(bodyDeclaration, normalAnnoation);		    
			}
		}

		TextEdit textEdit = unit.rewrite(document, compilationUnit.getJavaProject().getOptions(true));

		try {
			textEdit.apply(document);
		} catch (MalformedTreeException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		String newSource = document.get();

		try {
			compilationUnit.getBuffer().setContents(newSource); 
			compilationUnit.save(new NullProgressMonitor(),true);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

}
