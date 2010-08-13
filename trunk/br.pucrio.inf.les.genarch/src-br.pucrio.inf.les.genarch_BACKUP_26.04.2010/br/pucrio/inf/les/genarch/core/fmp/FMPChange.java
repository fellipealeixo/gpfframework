package br.pucrio.inf.les.genarch.core.fmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnit;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnitManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;
import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.models.dsl.ArchitectureModelUtil;
import br.pucrio.inf.les.genarch.core.models.dsl.ConfigurationModelUtil;
import br.pucrio.inf.les.genarch.core.models.dsl.FMPModelUitl;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.resources.dsl.AJDTASTUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JDTASTUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class FMPChange {

	private String featureModelPath;
	private String configurationModelPath;
	private String architectureModelPath;
	private IProject project;

	public void change(IProject project) {

		this.project = project;

		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		if ( genarchProjectConfigurationFile == null ) {
			return;
		}

		this.featureModelPath = genarchProjectConfigurationFile.getFeatureModelPath();
		this.configurationModelPath = genarchProjectConfigurationFile.getConfigurationModelPath();
		this.architectureModelPath = genarchProjectConfigurationFile.getArchitectureModelPath();

		IResource modelChangend = project.getFile(featureModelPath);

		if ( modelChangend != null ) {
			this.syncrhonizeFeatureModelConfigurationModel();
		}
	}

	private synchronized void syncrhonizeFeatureModelConfigurationModel() {		
		IFile fmpModelFile = project.getFile(new Path(featureModelPath));
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);					
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();
		ModelNavigation fmpNavigation = ModelNavigation.INSTANCE;

		ConfigurationFactory configurationFactory = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory();

		EList children = fmpProject.getModel().getChildren();
		Feature childold = (Feature)children.get(0);

		ConfigurationModelUtil configurationModelUtil = new ConfigurationModelUtil(project);
		ArchitectureModelUtil architectureModelUtil = new ArchitectureModelUtil(project);
		FMPModelUitl fmpModelUitl = new FMPModelUitl(project,new Path(featureModelPath));

		List<Feature> featureModelFeatures = new ArrayList<Feature>();

		getFeatureModelFeatures(childold, featureModelFeatures);

		MappingRelationships mappingRelationships = configurationModelUtil.getMappingRelationships();
		TreeIterator mappingRelationshipsContent = mappingRelationships.eAllContents();

		while ( mappingRelationshipsContent.hasNext() ) {
			EObject o = (EObject)mappingRelationshipsContent.next();

			if ( o instanceof MappingEntity ) {
				MappingEntity entity = (MappingEntity)o;
				FeatureExpression featureExpression = entity.getFeatureExpression();

				if ( featureExpression != null ) {

					String expression = featureExpression.getExpression();

					List<String> removeFeatures = new ArrayList<String>();
					List<String> expressionFeatures = Logic.toFeatures(expression);

					for ( String feature : expressionFeatures ) {
						boolean featureExist = false;

						for ( Feature featureInModel : featureModelFeatures ) {
							if (feature.equals(featureInModel.getName())) {
								featureExist = true;
								break;
							}
						}

						if ( !featureExist ) {
							removeFeatures.add(feature);
						}
					}

					if ( removeFeatures.size() > 0 ) {
						String[] newExpression = Logic.hotExpression(expression, removeFeatures);

						if ( newExpression.length == 0 ) {
							configurationModelUtil.removeMappingElement(entity.getPath());
						} else {
							StringBuilder ex = new StringBuilder();

							if ( newExpression.length > 1 ) {
								for ( int x = 0; x < newExpression.length-1; x++ ) {
									ex.append(newExpression[x] + " ");	   
								}

								ex.append(newExpression[newExpression.length-1]);			   
							} else {
								ex.append(newExpression[0]);
							}

							entity.getFeatureExpression().setExpression(ex.toString());			   
						}

						removeFeatureAnnotationFromElement(entity.getPath(),removeFeatures);			
					}		    		    	
				}
			}
		}	

		configurationModelUtil.saveModel();	
	}

	private void getFeatureModelFeatures(Node proj,List<Feature> features) {
		EList c = proj.getChildren();
		Iterator tree = c.iterator();

		while(tree.hasNext()) {
			Object o = tree.next();

			if ( o instanceof Feature ) {
				Feature child = (Feature)o;

				features.add(child);

				if ( child.getChildren() != null && child.getChildren().size() > 0 ) {
					getFeatureModelFeatures(child,features);
				}
			} else if ( o instanceof FeatureGroup ) {
				FeatureGroup child = (FeatureGroup)o;

				if ( child.getChildren() != null && child.getChildren().size() > 0 ) {
					getFeatureModelFeatures(child,features);
				}
			}
		}
	}

	private void removeFeatureAnnotationFromElement(String elementPath,List<String> removedFeatures) {
		IPath path = new Path(elementPath);
		IFile resource = project.getFile(elementPath);

		if ( "java".equals(path.getFileExtension()) ) {
			ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(resource);
			ASTNode node = JDTASTUtil.astNode(resource,compilationUnit);
			AST ast = node.getAST();
			IDocument document = JDTASTUtil.createDocument(compilationUnit);

			CompilationUnit unit = (CompilationUnit)node;
			unit.recordModifications();

			BodyDeclaration bodyDeclaration = JDTASTUtil.bodyDeclaration(unit);

			SingleMemberAnnotation featuresAnnotation = (SingleMemberAnnotation)JavaAnnotationUtil.annotation(bodyDeclaration, "Features");
			if ( featuresAnnotation != null ) {
				ArrayInitializer value = (ArrayInitializer)featuresAnnotation.getValue();
				List features = value.expressions();

				for ( String removedFeature : removedFeatures ) {
					for ( int x = 0; x < features.size(); x++ ) {
						NormalAnnotation feature = (NormalAnnotation)features.get(x);
						StringLiteral literalName = (StringLiteral)JavaAnnotationUtil.element(feature,"name");
						String nameValue = literalName.getLiteralValue();

						if ( nameValue.equals(removedFeature) ) {
							features.remove(x);
							break;
						}		    
					}					
				}

				if ( features.size() == 0 ) {
					JavaAnnotationUtil.removeAnnotation(bodyDeclaration, featuresAnnotation);
				} else if ( features.size() == 1 ) {
					NormalAnnotation xAnnotation = (NormalAnnotation)features.get(0);
					NormalAnnotation oneAnnotation = JavaAnnotationUtil.newNormalAnnotation(ast,"Feature");

					org.eclipse.jdt.core.dom.MemberValuePair valuePair = JavaAnnotationUtil.memberValuePair(xAnnotation, "name");
					if ( valuePair != null ) {
						StringLiteral nameValue = (StringLiteral)valuePair.getValue();
						JavaAnnotationUtil.addLiteralMemberValuePair(oneAnnotation,"name",nameValue.getLiteralValue());
					}

					valuePair = JavaAnnotationUtil.memberValuePair(xAnnotation,"parent");
					if ( valuePair != null ) {
						StringLiteral parentValue = (StringLiteral)valuePair.getValue();
						JavaAnnotationUtil.addLiteralMemberValuePair(oneAnnotation,"parent",parentValue.getLiteralValue());
					}

					valuePair = JavaAnnotationUtil.memberValuePair(xAnnotation,"type");
					if ( valuePair != null ) {
						QualifiedName typeValue = (QualifiedName)valuePair.getValue();
						JavaAnnotationUtil.addQualifiedNameMemberValuePair(oneAnnotation, "type", "FeatureType",typeValue.getName().getIdentifier());						
					}

					JavaAnnotationUtil.addAnnotation(bodyDeclaration,oneAnnotation);
					JavaAnnotationUtil.removeAnnotation(bodyDeclaration,featuresAnnotation);

					//TODO Remover o elemento import.
				}
			}

			NormalAnnotation featureAnnotation = (NormalAnnotation)JavaAnnotationUtil.annotation(bodyDeclaration, "Feature");
			if ( featureAnnotation != null ) {
				StringLiteral literalName = (StringLiteral)JavaAnnotationUtil.element(featureAnnotation, "name");
				String nameValue = literalName.getLiteralValue();

				if ( removedFeatures.contains(nameValue) ) {
					JavaAnnotationUtil.removeAnnotation(bodyDeclaration, featureAnnotation);
				}		
			}

			TextEdit textEdit = unit.rewrite(document, compilationUnit.getJavaProject().getOptions(true));

			try {
				textEdit.apply(document);
			} catch (MalformedTreeException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			} catch (BadLocationException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}

			String newSource = document.get();

			try {
				compilationUnit.getBuffer().setContents(newSource); 
				compilationUnit.save(new NullProgressMonitor(),true);
			} catch (JavaModelException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		} else if ( "aj".equals(path.getFileExtension()) ) {
			AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(resource);
			org.aspectj.org.eclipse.jdt.core.dom.ASTNode node = AJDTASTUtil.astNode(resource, ajCompilationUnit);
			org.aspectj.org.eclipse.jdt.core.dom.AST ast = node.getAST();
			IDocument document = AJDTASTUtil.createDocument(ajCompilationUnit);

			org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit unit = (org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit)node;
			unit.recordModifications();

			org.aspectj.org.eclipse.jdt.core.dom.BodyDeclaration bodyDeclaration = AJDTASTUtil.bodyDeclaration(unit);

			org.aspectj.org.eclipse.jdt.core.dom. SingleMemberAnnotation featuresAnnotation = (org.aspectj.org.eclipse.jdt.core.dom.SingleMemberAnnotation)AspectAnnotationUtil.annotation(bodyDeclaration, "Features");
			if ( featuresAnnotation != null ) {
				org.aspectj.org.eclipse.jdt.core.dom.ArrayInitializer value = (org.aspectj.org.eclipse.jdt.core.dom.ArrayInitializer)featuresAnnotation.getValue();

				List features = value.expressions();

				for ( String removedFeature : removedFeatures ) {
					for ( int x = 0; x < features.size(); x++ ) {
						org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation feature = (org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation)features.get(x);
						org.aspectj.org.eclipse.jdt.core.dom.StringLiteral literalName = (org.aspectj.org.eclipse.jdt.core.dom.StringLiteral)AspectAnnotationUtil.element(feature, "name");
						String nameValue = literalName.getLiteralValue();

						if ( removedFeature.equals(nameValue) ) {
							AspectAnnotationUtil.removeAnnotation(bodyDeclaration, feature);
							break;
						}		    
					}
				}

				if ( features.size() == 0 ) {
					AspectAnnotationUtil.removeAnnotation(bodyDeclaration, featuresAnnotation);
				} else if ( features.size() == 1 ) {
					org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation xAnnotation = (org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation)features.get(0);
					org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation oneAnnotation = AspectAnnotationUtil.newNormalAnnotation(ast,"Feature");

					MemberValuePair valuePair = AspectAnnotationUtil.memberValuePair(xAnnotation, "name");
					if ( valuePair != null ) {
						org.aspectj.org.eclipse.jdt.core.dom.StringLiteral nameValue = (org.aspectj.org.eclipse.jdt.core.dom.StringLiteral)valuePair.getValue();
						AspectAnnotationUtil.addLiteralMemberValuePair(oneAnnotation,"name",nameValue.getLiteralValue());
					}

					valuePair = AspectAnnotationUtil.memberValuePair(xAnnotation,"parent");
					if ( valuePair != null ) {
						org.aspectj.org.eclipse.jdt.core.dom.StringLiteral parentValue = (org.aspectj.org.eclipse.jdt.core.dom.StringLiteral)valuePair.getValue();
						AspectAnnotationUtil.addLiteralMemberValuePair(oneAnnotation,"parent",parentValue.getLiteralValue());
					}

					valuePair = AspectAnnotationUtil.memberValuePair(xAnnotation,"type");
					if ( valuePair != null ) {
						org.aspectj.org.eclipse.jdt.core.dom.QualifiedName typeValue = (org.aspectj.org.eclipse.jdt.core.dom.QualifiedName)valuePair.getValue();
						AspectAnnotationUtil.addQualifiedNameMemberValuePair(oneAnnotation, "type", "FeatureType",typeValue.getName().getIdentifier());						
					}

					AspectAnnotationUtil.addAnnotation(bodyDeclaration,oneAnnotation);
					AspectAnnotationUtil.removeAnnotation(bodyDeclaration,featuresAnnotation);

					//TODO Remover o elemento import.
				}
			}

			org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation featureAnnotation = (org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation)AspectAnnotationUtil.annotation(bodyDeclaration, "Feature");
			if ( featureAnnotation != null ) {
				org.aspectj.org.eclipse.jdt.core.dom.StringLiteral literalName = (org.aspectj.org.eclipse.jdt.core.dom.StringLiteral)AspectAnnotationUtil.element(featureAnnotation, "name");
				String nameValue = literalName.getLiteralValue();

				if ( removedFeatures.contains(nameValue) ) {
					AspectAnnotationUtil.removeAnnotation(bodyDeclaration, featureAnnotation);
				}		
			}

			TextEdit textEdit = unit.rewrite(document, ajCompilationUnit.getJavaProject().getOptions(true));

			try {
				textEdit.apply(document);
			} catch (MalformedTreeException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			} catch (BadLocationException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}

			String newSource = document.get();

			try {
				ajCompilationUnit.getBuffer().setContents(newSource); 
				ajCompilationUnit.save(new NullProgressMonitor(),true);
			} catch (JavaModelException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		}
	}
}
