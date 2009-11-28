package br.pucrio.inf.les.genarch.core.util;

import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.AST;
import org.aspectj.org.eclipse.jdt.core.dom.ASTNode;
import org.aspectj.org.eclipse.jdt.core.dom.ArrayInitializer;
import org.aspectj.org.eclipse.jdt.core.dom.BodyDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit;
import org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation;
import org.aspectj.org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnit;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnitManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.resources.dsl.AJDTASTUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class AspecJResourceUtil {

	public static void configureAspectElement(IFile resource,String featureExpression) {
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(resource.getProject());
		
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(resource.getProject().getFile(genarchProjectConfigurationFile.getFeatureModelPath()));					
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();
		ModelNavigation fmpNavigation = ModelNavigation.INSTANCE;
		Node model = fmpProject.getModel();
		
		AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(resource);
		ASTNode node = AJDTASTUtil.astNode(resource,ajCompilationUnit);
		AST ast = node.getAST();
		IDocument document = AJDTASTUtil.createDocument(ajCompilationUnit);

		CompilationUnit unit = (CompilationUnit)node;
		unit.recordModifications();

		BodyDeclaration bodyDeclaration = AJDTASTUtil.bodyDeclaration(unit);

		SingleMemberAnnotation oldFeaturesAnnotation = (SingleMemberAnnotation)AspectAnnotationUtil.annotation(bodyDeclaration, "Features");
		if ( oldFeaturesAnnotation != null ) {
			AspectAnnotationUtil.removeAnnotation(bodyDeclaration, oldFeaturesAnnotation);
		}

		NormalAnnotation oldFeatureAnnotation = (NormalAnnotation)AspectAnnotationUtil.annotation(bodyDeclaration, "Feature");
		if ( oldFeatureAnnotation != null ) {
			AspectAnnotationUtil.removeAnnotation(bodyDeclaration, oldFeatureAnnotation);
		}

		List<String> features = Logic.toFeatures(featureExpression);

		//TODO Adinionar nova anotation				
		if ( features.size() > 1 ) {
			SingleMemberAnnotation featuresAnnotation = AspectAnnotationUtil.newSingleMemberAnnotation(ast, "Features");
			ArrayInitializer arrayInitializer = ast.newArrayInitializer();

			for ( String feature : features ) {
				//TODO para cada feature, buscar a feature no modelo de caracter�stica e obter as informa��es para montar a anota��o
				Node fmpFeature = fmpNavigation.findNodeWithName(model, feature);	   

				if ( fmpFeature instanceof Feature ) {
					Feature aux = (Feature)fmpFeature;
					NormalAnnotation normalAnnoation = AspectAnnotationUtil.newNormalAnnotation(ast, "Feature");
					AspectAnnotationUtil.addLiteralMemberValuePair(normalAnnoation, "name", aux.getName());
					
					Feature featureParent;

					if ( fmpFeature.eContainer() instanceof FeatureGroup ) {
						featureParent = (Feature)fmpFeature.eContainer().eContainer();
					} else {
						featureParent = (Feature)fmpFeature.eContainer();
					}
					
					AspectAnnotationUtil.addLiteralMemberValuePair(normalAnnoation, "parent", featureParent.getName());

					if (aux.isOptional() ) {
						AspectAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnoation, "type", "FeatureType", "optional");
					} else {
						AspectAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnoation, "type", "FeatureType", "mandatory");
					}
					
					AspectAnnotationUtil.addExpressionToArrayInitializer(arrayInitializer, normalAnnoation);
				}
			}

			featuresAnnotation.setValue(arrayInitializer);
			AspectAnnotationUtil.addAnnotation(bodyDeclaration, featuresAnnotation);
		} else if ( features.size() == 1 ) {
			Node fmpFeature = fmpNavigation.findNodeWithName(model, features.get(0));

			if ( fmpFeature instanceof Feature ) {
				Feature aux = (Feature)fmpFeature;
				NormalAnnotation normalAnnoation = AspectAnnotationUtil.newNormalAnnotation(ast, "Feature");
				AspectAnnotationUtil.addLiteralMemberValuePair(normalAnnoation, "name", aux.getName());
				
				Feature featureParent;

				if ( fmpFeature.eContainer() instanceof FeatureGroup ) {
					featureParent = (Feature)fmpFeature.eContainer().eContainer();
				} else {
					featureParent = (Feature)fmpFeature.eContainer();
				}
				
				AspectAnnotationUtil.addLiteralMemberValuePair(normalAnnoation, "parent", featureParent.getName());

				if (aux.isOptional() ) {
					AspectAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnoation, "type", "FeatureType", "optional");
				} else {
					AspectAnnotationUtil.addQualifiedNameMemberValuePair(normalAnnoation, "type", "FeatureType", "mandatory");
				}
			
				AspectAnnotationUtil.addAnnotation(bodyDeclaration, normalAnnoation);		    
			}
		}

		TextEdit textEdit = unit.rewrite(document, JavaCore.create(resource.getProject()).getOptions(true));

		try {
			textEdit.apply(document);
		} catch (MalformedTreeException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		String newSource = document.get();


		try {
			ajCompilationUnit.getBuffer().setContents(newSource); 
			ajCompilationUnit.save(new NullProgressMonitor(),true);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

	}

}
