package br.pucrio.inf.les.genarch.core.resources.dsl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
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

import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;

public class EpfCommentedUtil {
	/**
	 * por wanderson
	 * 
	 * @param annotedFile
	 * @return
	 */
	public static List<FeatureItem> featureComments(IFile commentedFile) {

		if (commentedFile == null)
			return null;

		List<FeatureItem> annotations = new ArrayList<FeatureItem>();
		
		
		SAXBuilder parser = new SAXBuilder();
		File arquivo = new File( commentedFile.getLocation().toString() );

		try {
			
			Document doc = parser.build(arquivo);
			Filter filter = new ContentFilter(ContentFilter.COMMENT);
			List conteudo = doc.getContent(filter);
			for(Object ref : conteudo) {
				Comment comentario = (Comment) ref;
				StringTokenizer st = new StringTokenizer(comentario.getText());
				System.out.println(comentario.getText());				
				
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
							
							annotations.add(featuresItem);
							
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

		return annotations;
		
		/*for (NormalAnnotation annotation : visitor.getNormalAnnotations()) {
			IAnnotationBinding binding = annotation.resolveAnnotationBinding();

			if (binding == null) {
				continue;
			}

			if (binding.getName().equals("Feature")) {
				IMemberValuePairBinding[] membersValuePairBinding = binding
						.getDeclaredMemberValuePairs();
				FeatureItem featuresItem = new FeatureItem();
				for (IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding) {
					String name = memberValuePairBinding.getName();
					Object value = memberValuePairBinding.getValue();
					if ("name".equals(name)) {
						featuresItem.setName((String) value);
					} else if ("type".equals(name)) {
						IBinding variableBinding = (IBinding) value;
						FeatureType featureType = FeatureType
								.valueOf(new String(variableBinding.getName()));
						featuresItem.setType(featureType);
					} else if ("parent".equals(name)) {
						featuresItem.setParent((String) value);
					}
				}
				annotations.add(featuresItem);
			}
		}*/

	}

}
