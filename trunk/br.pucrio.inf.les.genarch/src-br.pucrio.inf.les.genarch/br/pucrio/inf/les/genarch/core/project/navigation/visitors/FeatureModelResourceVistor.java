package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.aspectj.org.eclipse.jdt.core.dom.MemberValuePair;
import org.aspectj.org.eclipse.jdt.core.dom.QualifiedName;
import org.aspectj.org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnit;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnitManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.filter.ContentFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationAspectVisitor;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;

public class FeatureModelResourceVistor implements ResourceClient {

	private FeatureModelContent featuresContent;

	public FeatureModelResourceVistor() {
		//por wanderson
		//JOptionPane.showMessageDialog(null,"Construtor feature model resource visitor...");
		this.featuresContent = new FeatureModelContent();
	}

	public void visit(IResource resource) {
		if ( resource.getType() == IResource.FILE ) {  		
			if ( resource.getFileExtension().equals("java") ) {		
				//this.proccessClassAnnotations(resource);				
			} else if ( resource.getFileExtension().equals("aj") ) {
				//this.proccessAspectAnnotations(resource);
			} else if ( resource.getFileExtension().equals("xmi") ) {
				this.proccessXMIComments(resource);
			} 
		}
	}
	
	public void visit(IFile resource) {

	}
	
	private void proccessAspectAnnotations(IResource resource) {
		IFile file = (IFile)resource;
		
		try {
			AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(file);
			InputStream fileContents = file.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
			StringBuffer sb = new StringBuffer();

			while ( reader.ready() ) {
				sb.append(reader.readLine());
			}

			org.aspectj.org.eclipse.jdt.core.dom.ASTParser astParser = org.aspectj.org.eclipse.jdt.core.dom.ASTParser.newParser(org.aspectj.org.eclipse.jdt.core.dom.AST.JLS3);
			astParser.setCompilerOptions(new HashMap());
			ajCompilationUnit.requestOriginalContentMode();
			astParser.setSource(ajCompilationUnit.getBuffer().getCharacters());
			astParser.setSource(sb.toString().toCharArray());
			astParser.setKind(org.aspectj.org.eclipse.jdt.core.dom.ASTParser.K_COMPILATION_UNIT);
			astParser.setResolveBindings(true);
			org.aspectj.org.eclipse.jdt.core.dom.ASTNode rootNode = astParser.createAST(new NullProgressMonitor()); 

			AnnotationAspectVisitor visitor = new AnnotationAspectVisitor();
			rootNode.accept(visitor);
			
			for ( final org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation annotation : visitor.getNormalAnnotations() ) {
				if ( annotation.getTypeName().getFullyQualifiedName().equals("Feature") ) {
					List members = annotation.values();
					FeatureItem featuresItem = new FeatureItem();
					for ( int x = 0; x < members.size(); x++ ) {
						MemberValuePair valuePair = (MemberValuePair)members.get(x);
						final String name = valuePair.getName().getIdentifier();
						final Object value = valuePair.getValue();

						if ( "name".equals(name) ) {
							featuresItem.setName(((StringLiteral)value).getLiteralValue());
						} else if ( "type".equals(name) ) {
							QualifiedName variableBinding = (QualifiedName)value;									
							FeatureType featureType = FeatureType.valueOf(variableBinding.getName().getIdentifier());
							featuresItem.setType(featureType);
						} else if ("parent".equals(name) ) {
							featuresItem.setParent(((StringLiteral)value).getLiteralValue());
						}
					}
					this.featuresContent.getFeatureItens().add(featuresItem);
				}	
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}
	
	private void proccessClassAnnotations(IResource resource) {
		IFile file = (IFile)resource;

		//this.featuresContent.getFeatureItens().addAll(JavaAnnotationUtil.featureAnnotations(file));

		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);

		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource(compilationUnit);
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);			
		astParser.setResolveBindings(true);
		ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

		AnnotationClassVisitor visitor = new AnnotationClassVisitor();
		rootNode.accept(visitor);

		/*for ( NormalAnnotation annotation : visitor.getNormalAnnotations() ) {
			IAnnotationBinding binding = annotation.resolveAnnotationBinding();

			if ( binding == null ) {
				continue;
			}

			if ( binding.getName().equals("Feature") ) {
				IMemberValuePairBinding[] membersValuePairBinding = binding.getDeclaredMemberValuePairs();
				FeatureItem featuresItem = new FeatureItem();
				for ( IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding ) {								
					String name = memberValuePairBinding.getName();
					Object value = memberValuePairBinding.getValue();
					if ( "name".equals(name) ) {
						featuresItem.setName((String)value);
					} else if ( "type".equals(name) ) {
						IBinding variableBinding = (IBinding)value;									
						FeatureType featureType = FeatureType.valueOf(new String(variableBinding.getName()));
						featuresItem.setType(featureType);
					} else if ( "parent".equals(name) ) {
						featuresItem.setParent((String)value);
					}															
				}
				//this.featuresContent.getFeatureItens().add(featuresItem);
			}
		}*/
		
		FeatureItem featuresItem = new FeatureItem();
		featuresItem.setName("FeatureName");
		FeatureType featureType = FeatureType.valueOf("optional");
		featuresItem.setType(featureType);
		featuresItem.setParent("parent");
		
		this.featuresContent.getFeatureItens().add(featuresItem);
		
		/*
		
		IFile file = (IFile)resource;
		
		//this.featuresContent.getFeatureItens().addAll(JavaAnnotationUtil.featureAnnotations(file));
		
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
		
		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource(compilationUnit);
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);			
		astParser.setResolveBindings(true);
		ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

		AnnotationClassVisitor visitor = new AnnotationClassVisitor();
		rootNode.accept(visitor);

		for ( NormalAnnotation annotation : visitor.getNormalAnnotations() ) {
			IAnnotationBinding binding = annotation.resolveAnnotationBinding();

			if ( binding == null ) {
				continue;
			}

			if ( binding.getName().equals("Feature") ) {
				
				IMemberValuePairBinding[] membersValuePairBinding = binding.getDeclaredMemberValuePairs();
				
				FeatureItem featuresItem = new FeatureItem();
				
				for ( IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding ) {								
					String name = memberValuePairBinding.getName();
					Object value = memberValuePairBinding.getValue();
					if ( "name".equals(name) ) {
						featuresItem.setName((String)value);
					} else if ( "type".equals(name) ) {
						IBinding variableBinding = (IBinding)value;									
						FeatureType featureType = FeatureType.valueOf(new String(variableBinding.getName()));
						featuresItem.setType(featureType);
					} else if ( "parent".equals(name) ) {
						featuresItem.setParent((String)value);
					}															
				}
				this.featuresContent.getFeatureItens().add(featuresItem);
				/*for ( IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding ) {					
					
					featuresItem.setName("FeatureName");
					FeatureType featureType = FeatureType.valueOf("optional");
					featuresItem.setType(featureType);
					featuresItem.setParent("parent");
					
				}*/
				
				//this.featuresContent.getFeatureItens().add(featuresItem);
				
				/*########################################################*/
				/* MyConfiguration Gambiarretion */ 
				/*########################################################*/
				/*featuresItem.setName("Avaliar os Resultados");
				FeatureType featureType = FeatureType.valueOf(new String("optional"));
				featuresItem.setType(featureType);
				featuresItem.setParent("OpenUP");
				this.featuresContent.getFeatureItens().add(featuresItem);
				*/
				/*FeatureItem featuresItem2 = new FeatureItem();
				
				featuresItem2.setName("Gerenciar Iteracao");
				FeatureType featureType2 = FeatureType.valueOf(new String("optional"));
				featuresItem2.setType(featureType2);
				featuresItem2.setParent("parent");
				this.featuresContent.getFeatureItens().add(featuresItem2);
				/*
				FeatureItem featuresItem3 = new FeatureItem();
				
				featuresItem3.setName("Planejar Iteracao");
				FeatureType featureType3 = FeatureType.valueOf(new String("optional"));
				featuresItem3.setType(featureType3);
				featuresItem3.setParent("OpenUP");
				this.featuresContent.getFeatureItens().add(featuresItem3);
				
				FeatureItem featuresItem4 = new FeatureItem();
				
				featuresItem4.setName("Coordenar Iteração");
				FeatureType featureType4 = FeatureType.valueOf(new String("alternative"));
				featuresItem4.setType(featureType4);
				featuresItem4.setParent("OpenUP");
				this.featuresContent.getFeatureItens().add(featuresItem4);
				
				
				//this.featuresContent.getFeatureItens().add(featuresItem);
				//System.out.println("Adicionou");
			}
		}	*/	
	}
	/**
	 * Por Wanderson
	 * @param resource
	 */
	private void proccessXMIComments(IResource resource) {
		IFile file = (IFile)resource;
		//-- testando a saida xmi
		SAXBuilder parser = new SAXBuilder();
		File arquivo = new File( file.getLocation().toString() );
		try {
			Document doc = parser.build(arquivo);
			Filter filter = new ContentFilter(ContentFilter.COMMENT);
			List conteudo = doc.getContent(filter);
			for(Object ref : conteudo) {
				Comment comentario = (Comment) ref;
				StringTokenizer st = new StringTokenizer(comentario.getText());
				//System.out.println(comentario.getText());
				while(st.hasMoreTokens()) {
					//por wanderson
					//JOptionPane.showMessageDialog(null, "A!");
					String currentToken = st.nextToken("\\ , ,@,=,(,),\\,");
					if(currentToken.equals("Feature")){
						FeatureItem featuresItem = new FeatureItem();
						/*featuresItem.setName("FeatureNameção");
						FeatureType featureType = FeatureType.valueOf("optional");
						featuresItem.setType(featureType);
						featuresItem.setParent("parent");*/
						currentToken = st.nextToken("\\ , ,@,=,(,),\\,");
						if(currentToken.equals("name")){
							//JOptionPane.showMessageDialog(null, "Achou um name = " + currentToken);
							featuresItem.setName(st.nextToken("\\ , ,@,=,(,),\\,"));
							//-- getNext
							currentToken = st.nextToken("\\ , ,@,=,(,),\\,");
						}
						if(currentToken.equals("parent")){
							//JOptionPane.showMessageDialog(null, "Achou um parent = " + currentToken);
							featuresItem.setParent(st.nextToken("\\ , ,@,=,(,),\\,"));
							//-- getNext
							currentToken = st.nextToken("\\ , ,@,=,(,),\\,");
						}
						if(currentToken.equals("type")){
							//JOptionPane.showMessageDialog(null, "Achou um Type = " + currentToken);
							
							FeatureType featureType = FeatureType.valueOf(new String(st.nextToken("\\ , ,@,=,(,),\\,")));
							featuresItem.setType(featureType);
							
							//JOptionPane.showMessageDialog(null, featuresItem.getName() + featuresItem.getParent() + featuresItem.getType().toString());
							
							this.featuresContent.getFeatureItens().add(featuresItem);
							
							//currentToken = st.nextToken("\\ ,@,=,(,),\\,");
							
						}
						
						//this.featuresContent.getFeatureItens().add(featuresItem);
						//System.out.println("Inseriu um completo");
					}
					//JOptionPane.showMessageDialog(null, "Token = "+currentToken);
				}
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//-- JOptionPane.showMessageDialog(null, file.getLocation().toString());
		
	}
	
	public FeatureModelContent getFeaturesContent() {
		//por wanderson
		//JOptionPane.showMessageDialog(null,"Conteudo das features...");
		return this.featuresContent;
	}
}