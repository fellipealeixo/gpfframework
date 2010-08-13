package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;

import br.pucrio.inf.les.genarch.core.models.ArchitectureModelContent;
import br.pucrio.inf.les.genarch.core.project.navigation.NavigationUtil;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;

public class ArchitectureModelResourceVisitor implements ResourceClient {
	
    private ArchitectureModelContent architectureContent;	

    public ArchitectureModelResourceVisitor() {
    	this.architectureContent = new ArchitectureModelContent();
    }

    public void visit(IResource resource) {
	String resourceName = resource.getName();
	
	String resourceNameTestando = null;
	
	String resourcePath = resource.getProjectRelativePath().removeFirstSegments(1).toString();
	String resourcePhysicalPath = resource.getProjectRelativePath().toString();
	
	if ( resource.getProjectRelativePath().segmentCount() == 1 ) {
	    if ( JavaCore.create(resource) instanceof IPackageFragmentRoot ) {
		this.architectureContent.addContainer(resource.getName());
	    } else if ( resource instanceof IFolder ) {
		this.architectureContent.addResourceContainer(resource.getName());
	    }
	} else if ( resource.getType() == IResource.FOLDER ) {
	    IFolder component = (IFolder)resource;
	    String parentPath = NavigationUtil.getParentByPath(component.getProjectRelativePath().toString());
	    EObject parent = this.architectureContent.getElementByPath(parentPath);
	    
	    if ( parent instanceof ArchitectureContainer ) {	
	    	this.architectureContent.addComponent(resource.getName(),(ArchitectureContainer)parent,resourcePhysicalPath);	    	
	    } else if ( parent instanceof ArchitectureComponent ){
		this.architectureContent.addSubComponent(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
	    } else if ( parent instanceof ArchitectureResourcesContainer ) {
		this.architectureContent.addFolder(resourceName,resourcePhysicalPath,(ArchitectureResourcesContainer)parent);
	    } else if ( parent instanceof ArchitectureFolder ) {
		this.architectureContent.addSubFolder(resourceName,resourcePhysicalPath,(ArchitectureFolder)parent);
	    }
	} else if ( resource.getType() == IResource.FILE ) {
	    IFile file = (IFile)resource;
	    String componentParentPath = NavigationUtil.getParentByPath(file.getProjectRelativePath().toString());
	    EObject parent = architectureContent.getElementByPath(componentParentPath);
	    
	    if ( file.getFileExtension().equals("java") ) {
		this.architectureContent.addClass(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
	    } else if ( file.getFileExtension().equals("aj") ) {
		this.architectureContent.addAspect(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
		
		
		//-- Por wanderson 
	    } else if ( file.getFileExtension().equals("xmi") ) {
	    	//by wanderson
			JOptionPane.showMessageDialog(null, file.getName().substring( 0,file.getName().length()-4 ) );
	    	this.architectureContent.addClass( file.getName().substring( 0,file.getName().length()-4 ),resourcePhysicalPath,(ArchitectureComponent)parent);
	    
	    
	    } else if ( resource.getFileExtension().equals("xpt") ) {
		String genPath = resource.getProjectRelativePath().removeLastSegments(1).toString();
		if ( parent instanceof ArchitectureComponent ) {
		    this.architectureContent.addTemplate(resourceName,resourcePhysicalPath,genPath,(ArchitectureComponent)parent);
		} else if ( parent instanceof ArchitectureFolder ) {
		    this.architectureContent.addTemplate(resourceName,resourcePhysicalPath,genPath,(ArchitectureFolder)parent);
		}			
	    } else if ( resource.getFileExtension().equals("mvel") ) {
		String toPath = resource.getProjectRelativePath().removeLastSegments(1).toString();
		this.architectureContent.addTemplate(resourceName,resourcePhysicalPath,toPath,(ArchitectureComponent)parent);
	    } else {
		if ( parent instanceof ArchitectureResourcesContainer ) {
		    this.architectureContent.addFile(resourceName,resourcePhysicalPath,(ArchitectureResourcesContainer)parent);
		} else if ( parent instanceof ArchitectureComponent ) {
		    this.architectureContent.addFile(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
		} else if ( parent instanceof ArchitectureFolder ) {
		    this.architectureContent.addFile(resourceName,resourcePhysicalPath,(ArchitectureFolder)parent);
		}
		
	    }
	}
    }

    public ArchitectureModelContent getArchitectureContent() {
	return this.architectureContent;
    }	
}
