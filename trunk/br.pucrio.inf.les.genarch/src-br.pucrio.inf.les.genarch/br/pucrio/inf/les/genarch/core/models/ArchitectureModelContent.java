package br.pucrio.inf.les.genarch.core.models;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureModelContent {
	
    private ArchitecturePackage architecturePackage;
    private ArchitectureFactory architectureFactory;
    private Architecture architecture;
    
    public ArchitectureModelContent() {
	init();
	this.architecture = this.architectureFactory.createArchitecture();	
    }
    
    public ArchitectureModelContent(Architecture architecture) {
	init();
	this.architecture = architecture;	
    }
    
    private void init() {
	ArchitecturePackageImpl.init();
	this.architecturePackage = ArchitecturePackage.eINSTANCE;
	this.architectureFactory = this.architecturePackage.getArchitectureFactory();	
    }
    
    public ArchitectureContainer addContainer(String name) {
	ArchitectureContainer container = this.architectureFactory.createArchitectureContainer();
	container.setName(name);
	this.architecture.getContainers().add(container);
	return container;
    }
    
    public ArchitectureResourcesContainer addResourceContainer(String name) {
	ArchitectureResourcesContainer container = this.architectureFactory.createArchitectureResourcesContainer();
	container.setName(name);
	this.architecture.getResourcesContainer().add(container);
	return container;
    }

    public ArchitectureComponent addComponent(String name,ArchitectureContainer architectureContainer,String path) {
	ArchitectureComponent architectureComponent = this.architectureFactory.createArchitectureComponent();
	architectureComponent.setName(name);
	architectureComponent.setPath(path);
	architectureContainer.getComponents().add(architectureComponent);
	return architectureComponent;
    }

    public ArchitectureComponent addSubComponent(String name,String path,ArchitectureComponent architectureComponent) {
	ArchitectureComponent architectureSubComponent = this.architectureFactory.createArchitectureComponent();
	architectureSubComponent.setName(name);
	architectureSubComponent.setPath(path);
	architectureComponent.getSubComponents().add(architectureSubComponent);
	return architectureSubComponent;				
    }

    public void addClass(String name,String path,ArchitectureComponent architectureComponent) {	
	ArchitectureClass architectureClass = this.architectureFactory.createArchitectureClass();
	architectureClass.setName(name);
	architectureClass.setPath(path);
	architectureComponent.getClasses().add(architectureClass);
    }
    /**
     * 
     * Por Wanderson...
     * @param name
     * @param path
     * @param architectureComponent
     */
    public void addEPFFile(String name,String path,ArchitectureComponent architectureComponent) {	
	ArchitectureClass architectureClass = this.architectureFactory.createArchitectureClass();
	architectureClass.setName(name);
	architectureClass.setPath(path);
	architectureComponent.getClasses().add(architectureClass);
    }

    public void addAspect(String name,String path,ArchitectureComponent architectureComponent) {
	ArchitectureAspect architectureAspect = this.architectureFactory.createArchitectureAspect();
	architectureAspect.setName(name);
	architectureAspect.setPath(path);
	architectureComponent.getAspects().add(architectureAspect);
    }

    public void addTemplate(String name,String path,String generationPath,ArchitectureComponent architectureComponent) {
	ArchitectureTemplate architectureTemplate = this.architectureFactory.createArchitectureTemplate();
	architectureTemplate.setName(name);
	architectureTemplate.setPath(path);
	architectureTemplate.setGenerationPath(generationPath);
	architectureComponent.getTemplates().add(architectureTemplate);		
    }
    
    public void addTemplate(String name,String path,String generationPath,ArchitectureFolder architectureFolder) {
	ArchitectureTemplate architectureTemplate = this.architectureFactory.createArchitectureTemplate();
	architectureTemplate.setName(name);
	architectureTemplate.setPath(path);
	architectureTemplate.setGenerationPath(generationPath);
	architectureFolder.getTemplates().add(architectureTemplate);		
    }

    public void addFile(String name,String path,ArchitectureComponent architectureComponent) {
	ArchitectureFile architectureFile = this.architectureFactory.createArchitectureFile();
	architectureFile.setName(name);
	architectureFile.setPath(path);
	architectureComponent.getFiles().add(architectureFile);		
    }
    
    public void addFile(String name,String path,ArchitectureResourcesContainer architectureResourcesContainer) {
	ArchitectureFile architectureFile = this.architectureFactory.createArchitectureFile();
	architectureFile.setName(name);
	architectureFile.setPath(path);
	architectureResourcesContainer.getFiles().add(architectureFile);		
    }
    
    public void addFile(String name,String path,ArchitectureFolder architectureFolder) {
	ArchitectureFile architectureFile = this.architectureFactory.createArchitectureFile();
	architectureFile.setName(name);
	architectureFile.setPath(path);
	architectureFolder.getFiles().add(architectureFile);		
    }
    
    public void addFolder(String name,String path,ArchitectureResourcesContainer architectureResourcesContainer) {
	ArchitectureFolder architectureFolder = this.architectureFactory.createArchitectureFolder();
	architectureFolder.setName(name);
	architectureFolder.setPath(path);
	architectureResourcesContainer.getFolders().add(architectureFolder);
    }
    
    public void addSubFolder(String name,String path,ArchitectureFolder architectureResourcesFolder) {
	ArchitectureFolder architectureFolder = this.architectureFactory.createArchitectureFolder();
	architectureFolder.setName(name);
	architectureFolder.setPath(path);
	architectureResourcesFolder.getSubFolders().add(architectureFolder);
    }
        
    public ArchitectureContainer getContainer(String name) {
	EList containers = this.architecture.getContainers();
	
	for ( int x = 0; x < containers.size(); x++ ) {
	    ArchitectureContainer container = (ArchitectureContainer)containers.get(x);
	    if ( container.getName().equals(name) ) {
		return container;
	    }
	}
	
	return null;
    }
   
    public EObject getElementByPath(String path) {
	TreeIterator iterator = this.architecture.eAllContents();

	while ( iterator.hasNext() ) {
	    EObject o = (EObject)iterator.next();
	    
	    if ( o instanceof ArchitectureContainer ) {
		ArchitectureContainer c = (ArchitectureContainer)o;
		if ( c.getName().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureResourcesContainer ) {
		ArchitectureResourcesContainer c = (ArchitectureResourcesContainer)o;
		if ( c.getName().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureComponent ) {
		ArchitectureComponent c = (ArchitectureComponent)o;				
		if ( c.getPath().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureClass ) {
		ArchitectureClass c = (ArchitectureClass)o;
		if ( c.getPath().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureAspect ) {
		ArchitectureAspect c = (ArchitectureAspect)o;
		if ( c.getPath().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureTemplate ) {
		ArchitectureTemplate c = (ArchitectureTemplate)o;
		if ( c.getPath().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureFile ) {
		ArchitectureFile c = (ArchitectureFile)o;
		if ( c.getPath().equals(path) ) {
		    return c;
		}
	    } else if ( o instanceof ArchitectureFolder ) {
		ArchitectureFolder c = (ArchitectureFolder)o;
		if ( c.getPath().equals(path) ) {
		    return c;
		}
	    }
	}

	return null;
    }

    public Architecture getArchitecture() {
	return this.architecture;
    }

    public void setArchitecture(Architecture architecture) {
	this.architecture = architecture;
    }
}
