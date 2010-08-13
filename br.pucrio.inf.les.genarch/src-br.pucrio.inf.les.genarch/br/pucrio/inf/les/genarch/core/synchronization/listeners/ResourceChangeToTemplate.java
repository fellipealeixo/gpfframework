package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.models.dsl.ArchitectureModelUtil;
import br.pucrio.inf.les.genarch.core.models.dsl.ConfigurationModelUtil;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationAspectVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.VariabilityAspectVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.VariabilityClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItemDescription;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItemDescription.ItemType;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;
import br.pucrio.inf.les.genarch.core.templates.AbstractAspectJTemplate;
import br.pucrio.inf.les.genarch.core.templates.AbstractClassTemplate;
import br.pucrio.inf.les.genarch.core.templates.InterfaceTemplate;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ResourceChangeToTemplate {

	public void resourceChanged(ResourcesEventData eventData, int eventType) {
		IResource res = eventData.getResource();

		if ( eventData.getEventType() == IResourceDelta.CHANGED || eventData.getEventType() == IResourceDelta.ADDED ) {	
			VariabilityItem variabilityItem = null;
			List<FeatureItem> featuresItem = new ArrayList<FeatureItem>();

			if ( "java".equals(res.getFileExtension()) ) {
				variabilityItem = JavaAnnotationUtil.variabilityAnnotation((IFile)res);
				if ( variabilityItem != null )  {
					variabilityItem.setItemDescription(makeClassVariabilityItemDescription(res));
				}								
			} else if ( "aj".equals(res.getFileExtension()) ) {
				variabilityItem = AspectAnnotationUtil.variabilityAnnotation((IFile)res);
				if ( variabilityItem != null ) {
					variabilityItem.setItemDescription(makeAspectVariabilityItemDescription(res));
				}								
			}

			if ( variabilityItem != null ) {
				String content = "";
				VariabilityItemDescription itemDescription = variabilityItem.getItemDescription();

				if ( itemDescription.getType() == ItemType.abstractClassType ) {
					AbstractClassTemplate abstractClassTemplate = new AbstractClassTemplate();
					content = abstractClassTemplate.generate(itemDescription);
				} else if ( itemDescription.getType() == ItemType.interfaceType ) {
					InterfaceTemplate interfaceTemplate = new InterfaceTemplate();
					content = interfaceTemplate.generate(itemDescription);
				} else if ( itemDescription.getType() == ItemType.aspectType ) {
					AbstractAspectJTemplate abstractAspectJTemplate = new AbstractAspectJTemplate();
					content = abstractAspectJTemplate.generate(itemDescription);
				}

				ByteArrayInputStream stream = new ByteArrayInputStream(content.getBytes());						
				IFile templateTFile = ResourcesPlugin.getWorkspace().getRoot().getFile(itemDescription.getFullPath());

				try {
					if ( templateTFile.exists() ) {
						templateTFile.setContents(stream, true, true, new NullProgressMonitor());
					} else {
						templateTFile.create(stream, true, new NullProgressMonitor());
					}
				} catch (CoreException e) {
					e.printStackTrace();
					GenarchEMFPlugin.INSTANCE.log(e);
				}
				
				ArchitectureModelUtil architectureModelUtil = new ArchitectureModelUtil(res.getProject());
				
				ArchitectureTemplate architectureTemplate = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureTemplate();				
				architectureTemplate.setName(templateTFile.getName());
				architectureTemplate.setPath(templateTFile.getProjectRelativePath().toString());
				architectureTemplate.setGenerationPath(templateTFile.getProjectRelativePath().toString());
				
				architectureModelUtil.addElement(architectureTemplate);
				
				architectureModelUtil.saveModel();
				
				ConfigurationModelUtil configurationModelUtil = new ConfigurationModelUtil(res.getProject());
				
				ConfigurationTemplate configurationTemplate = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createConfigurationTemplate();
				configurationTemplate.setName(templateTFile.getName());
				configurationTemplate.setPath(templateTFile.getProjectRelativePath().toString());
				
				MappingEntity entity = configurationModelUtil.mappingElement(res.getProjectRelativePath().toString());
				
				FeatureExpression featureExpression = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createFeatureExpression();
				featureExpression.setExpression(entity.getFeatureExpression().getExpression());
				
				configurationTemplate.setFeatureExpression(featureExpression);
				
				configurationModelUtil.addMappingElement(configurationTemplate);
				
				configurationModelUtil.saveModel();			
			}
		}
	}

	private VariabilityItemDescription makeAspectVariabilityItemDescription(IResource resource) {
		IFile file = (IFile)resource;

		try {
			InputStream fileContents = file.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
			StringBuffer sb = new StringBuffer();

			while ( reader.ready() ) {
				sb.append(reader.readLine());
			}

			org.aspectj.org.eclipse.jdt.core.dom.ASTParser astParser = org.aspectj.org.eclipse.jdt.core.dom.ASTParser.newParser(org.aspectj.org.eclipse.jdt.core.dom.AST.JLS3);
			astParser.setCompilerOptions(new HashMap());
			astParser.setSource(sb.toString().toCharArray());
			astParser.setKind(org.aspectj.org.eclipse.jdt.core.dom.ASTParser.K_COMPILATION_UNIT);
			astParser.setResolveBindings(true);
			org.aspectj.org.eclipse.jdt.core.dom.ASTNode rootNode = astParser.createAST(new NullProgressMonitor()); 

			AnnotationAspectVisitor visitor = new AnnotationAspectVisitor();
			rootNode.accept(visitor);

			for ( final org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation annotation : visitor.getNormalAnnotations() ) {		
				if ( annotation.getTypeName().getFullyQualifiedName().equals("Variability") ) {
					VariabilityAspectVisitor variabilityVisitor = new VariabilityAspectVisitor();
					rootNode.accept(variabilityVisitor);

					IPath typeName = resource.getFullPath();
					typeName = typeName.removeFileExtension();
					typeName = typeName.removeFirstSegments(typeName.segmentCount() - 1);

					VariabilityItemDescription variabilityItemDescription = new VariabilityItemDescription();
					variabilityItemDescription.setName(typeName.toString());
					variabilityItemDescription.setPackageName(file.getProjectRelativePath().removeLastSegments(1).toString().replace('/', '.'));

					IPath fullPath = file.getFullPath().removeLastSegments(1);
					String templateName = typeName.toString() + "Template.xpt";
					fullPath = fullPath.append(templateName);

					variabilityItemDescription.setFullPath(fullPath);
					variabilityItemDescription.setType(ItemType.aspectType);

					List<org.aspectj.org.eclipse.jdt.core.dom.PointcutDeclaration> pointcutsDeclaration = variabilityVisitor.getAbstractPointcutsDeclaration();

					for ( org.aspectj.org.eclipse.jdt.core.dom.PointcutDeclaration pointcutDeclaration : pointcutsDeclaration) {
						boolean isAbstract = false;

						List modifiers = pointcutDeclaration.modifiers();						
						List newModifiers = new ArrayList();

						for ( int x = 0; x < modifiers.size(); x++ ) {
							Modifier modifier = (Modifier)modifiers.get(x);
							String keyword = modifier.getKeyword().toString(); 
							if ( keyword.equals("abstract") ) {
								isAbstract = true;
							} else {
								newModifiers.add(modifier);
							}
						}

						if ( isAbstract ) {							
							StringBuilder pointcutDescription = new StringBuilder();

							for ( int x = 0; x < newModifiers.size(); x++ ) {
								Modifier modifier = (Modifier)newModifiers.get(x);
								pointcutDescription.append(modifier.getKeyword());
								pointcutDescription.append(" ");								
							}

							pointcutDescription.append("pointcut ");
							pointcutDescription.append(pointcutDeclaration.getName());
							pointcutDescription.append("():");							

							variabilityItemDescription.getAbstractDeclarations().add(pointcutDescription.toString());
						}							
					}

					List<org.aspectj.org.eclipse.jdt.core.dom.MethodDeclaration> methodsDeclaration = variabilityVisitor.getAbstractMethodsDeclaration();

					for ( org.aspectj.org.eclipse.jdt.core.dom.MethodDeclaration methodDeclaration : methodsDeclaration ) {										
						String methodDescription = methodDeclaration.toString();

						if ( methodDescription.indexOf("abstract") != -1 ) {
							String first = methodDescription.substring(0,methodDescription.indexOf("abstract"));
							String last = methodDescription.substring(methodDescription.indexOf("abstract")+8,methodDescription.length()-2);
							methodDescription = first + last + "{}";
							variabilityItemDescription.getAbstractDeclarations().add(methodDescription);
						}
					}

					return variabilityItemDescription;
				}		
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return null;
	}

	private VariabilityItemDescription makeClassVariabilityItemDescription(IResource resource) { 				
		IFile file = (IFile)resource;
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);

		try {
			InputStream fileContents = file.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
			StringBuffer sb = new StringBuffer();

			while ( reader.ready() ) {
				sb.append(reader.readLine());
			}

			ASTParser astParser = ASTParser.newParser(AST.JLS3);
			astParser.setSource(compilationUnit);
			astParser.setKind(ASTParser.K_COMPILATION_UNIT);			
			astParser.setResolveBindings(true);
			ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

			AnnotationClassVisitor visitor = new AnnotationClassVisitor();
			rootNode.accept(visitor);

			for ( NormalAnnotation annotation : visitor.getNormalAnnotations() ) {
				IAnnotationBinding binding = annotation.resolveAnnotationBinding();

				if (binding == null ) {
					continue;
				}

				if ( "Variability".equals(binding.getName()) ) {
					VariabilityClassVisitor variabilityVisitor = new VariabilityClassVisitor();
					rootNode.accept(variabilityVisitor);

					List<MethodDeclaration> methodsDeclaration = variabilityVisitor.getAbstractMethodsDeclaration();

					IType type = compilationUnit.getTypes()[0];

					VariabilityItemDescription variabilityItemDescription = new VariabilityItemDescription();
					variabilityItemDescription.setName(type.getElementName());
					variabilityItemDescription.setPackageName(file.getFullPath().removeFirstSegments(2).removeLastSegments(1).toString().replace('/', '.'));

					IPath fullPath = file.getFullPath().removeLastSegments(1);
					String templateName = type.getElementName() + "Template.xpt";
					fullPath = fullPath.append(templateName);

					variabilityItemDescription.setFullPath(fullPath);

					if ( type.isClass() ) {
						variabilityItemDescription.setType(ItemType.abstractClassType);

						for ( MethodDeclaration methodDeclaration : methodsDeclaration ) {
							String methodDescription = methodDeclaration.toString();

							if ( methodDescription.indexOf("abstract") != -1 ) {							
								String first = methodDescription.substring(0,methodDescription.indexOf("abstract"));
								String last = methodDescription.substring(methodDescription.indexOf("abstract")+8,methodDescription.length()-2);
								methodDescription = first + last + "{}";
								variabilityItemDescription.getAbstractDeclarations().add(methodDescription);
							}							
						}

					} else if ( type.isInterface() ) {
						variabilityItemDescription.setType(ItemType.interfaceType);

						for ( MethodDeclaration methodDeclaration : methodsDeclaration ) {
							String methodDescription = methodDeclaration.toString();
							methodDescription = methodDescription.substring(0,methodDescription.length()-2);
							methodDescription = methodDescription + "{}";
							variabilityItemDescription.getAbstractDeclarations().add(methodDescription);
						}

					} else {
						variabilityItemDescription.setType(ItemType.aspectType);
					}					

					return variabilityItemDescription;
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return null;
	}
}
