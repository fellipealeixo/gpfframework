package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
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
import br.pucrio.inf.les.genarch.core.models.TemplateContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationAspectVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.VariabilityAspectVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.VariabilityClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItemDescription;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItemDescription.ItemType;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;

public class TemplateResourceVisitor implements ResourceClient {

	private TemplateContent variabilityContent;

	public TemplateResourceVisitor() {
		this.variabilityContent = new TemplateContent();
	}

	public void visit(IResource resource) {		
		if ( resource.getType() == IResource.FILE ) {  		
			if ( resource.getFileExtension().equals("java") ) {	
				VariabilityItem variabilityItem = JavaAnnotationUtil.variabilityAnnotation((IFile)resource);
				if ( variabilityItem != null ) {
					variabilityItem.setItemDescription(makeClassVariabilityItemDescription(resource));
					this.variabilityContent.getVariabilities().add(variabilityItem);
				}		
			} else if ( resource.getFileExtension().equals("aj") ) {
				VariabilityItem variabilityItem = AspectAnnotationUtil.variabilityAnnotation((IFile)resource);
				if ( variabilityItem != null ) {
					variabilityItem.setItemDescription(makeAspectVariabilityItemDescription(resource));
					this.variabilityContent.getVariabilities().add(variabilityItem);
				}	
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
					variabilityItemDescription.setPackageName(file.getProjectRelativePath().removeFirstSegments(1).removeLastSegments(1).toString().replace('/', '.'));

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public TemplateContent getVariabilityContent() {
		return this.variabilityContent;
	}
}
