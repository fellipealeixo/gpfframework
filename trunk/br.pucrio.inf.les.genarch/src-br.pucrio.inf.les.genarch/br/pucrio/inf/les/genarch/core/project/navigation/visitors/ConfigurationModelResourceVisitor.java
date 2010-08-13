package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.models.ConfigurationModelContent;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.EpfCommentedUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;

public class ConfigurationModelResourceVisitor implements ResourceClient {

	private ConfigurationModelContent configurationContent;

	public ConfigurationModelResourceVisitor() {
		this.configurationContent = new ConfigurationModelContent();		
	}

	public void visit(IResource resource) {
		List<FeatureItem> featuresItem = new ArrayList<FeatureItem>();
		List<String> featuresNames = new ArrayList<String>();
		VariabilityItem variabiliyItem;

		String componentPath = resource.getProjectRelativePath().removeLastSegments(1).toString();
		String resourceName = resource.getName();
		
		String resourceNameTestando = null;
		
		String resourcePhysicalPath = resource.getProjectRelativePath().toString();

		if ( resource.getProjectRelativePath().segmentCount() == 1 ) {	    
			if ( JavaCore.create(resource) instanceof IPackageFragmentRoot ) {
				this.configurationContent.addSourceContainer(resource.getName());
			} else if ( resource instanceof IFolder ) {
				this.configurationContent.addResourcesContainer(resource.getName());
			}
		} else if ( resource.getType() == IResource.FILE ) {

			if ( resource.getFileExtension().equals("java") ) {
				featuresItem = JavaAnnotationUtil.featureAnnotations((IFile)resource);		

				for ( FeatureItem featureItem: featuresItem ) {					
					featuresNames.add(featureItem.getName());
				}

				if ( featuresNames.size() > 0 ) {
					String expression = Logic.makeExpression(featuresNames);
					this.configurationContent.addClass(resourceName,resourcePhysicalPath,expression,componentPath);		    
				}

				variabiliyItem = JavaAnnotationUtil.variabilityAnnotation((IFile)resource);

				if ( variabiliyItem != null ) {
					String templateName =  (new Path(resourceName)).removeFileExtension().toString() + "Template.xpt";
					String templatePath = new Path(componentPath).append(templateName).toString();
					this.configurationContent.addTemplate(templateName,templatePath,variabiliyItem.getFeature(),componentPath);
				}

			} else if ( resource.getFileExtension().equals("aj") ) {
				featuresItem = AspectAnnotationUtil.featuresAnnotations((IFile)resource);

				for ( FeatureItem featureItem: featuresItem ) {					
					featuresNames.add(featureItem.getName());
				}
				
				if ( featuresNames.size() > 0 ) {
					String expression = Logic.makeExpression(featuresNames);
					this.configurationContent.addAspect(resourceName,resourcePhysicalPath,expression,componentPath);
				}
				
				variabiliyItem = AspectAnnotationUtil.variabilityAnnotation((IFile)resource);
				
				if ( variabiliyItem != null ) {
					String templateName =  (new Path(resourceName)).removeFileExtension().toString() + "Template.xpt";
					String templatePath = new Path(componentPath).append(templateName).toString();
					this.configurationContent.addTemplate(templateName,templatePath,variabiliyItem.getFeature(),componentPath);
				}
			//por wanderson
			} else if ( resource.getFileExtension().equals("xmi") ) {
				
				featuresItem = EpfCommentedUtil.featureComments((IFile)resource);		
				
				for ( FeatureItem featureItem: featuresItem ) {
					//by wanderson
					//JOptionPane.showMessageDialog(null,resourceName);
					featuresNames.add(featureItem.getName());
					resourceNameTestando = featureItem.getName();
				}

				if ( featuresNames.size() > 0 ) {
					String expression = Logic.makeExpression(featuresNames);
					// novo
					this.configurationContent.addClass(resourceNameTestando,resourcePhysicalPath,expression,componentPath);
					// antigo
					// this.configurationContent.addClass(resourceName,resourcePhysicalPath,expression,componentPath);		    
				}

				/*variabiliyItem = JavaAnnotationUtil.variabilityAnnotation((IFile)resource);

				if ( variabiliyItem != null ) {
					String templateName =  (new Path(resourceName)).removeFileExtension().toString() + "Template.xpt";
					String templatePath = new Path(componentPath).append(templateName).toString();
					this.configurationContent.addTemplate(templateName,templatePath,variabiliyItem.getFeature(),componentPath);
				}*/
			}
		}	
	}

	public ConfigurationModelContent getConfigurationContent() {
		return this.configurationContent;
	}	
}
