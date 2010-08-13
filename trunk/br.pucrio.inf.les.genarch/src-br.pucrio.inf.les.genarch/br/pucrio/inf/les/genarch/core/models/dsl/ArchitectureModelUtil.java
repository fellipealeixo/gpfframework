package br.pucrio.inf.les.genarch.core.models.dsl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;

public class ArchitectureModelUtil {

	private Architecture architecture;
	private Resource architectureResource;
	private ArchitectureFactory architectureFactory = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory();
	private List<String> sourceContainers;
	private List<String> resourceContainers;

	public ArchitectureModelUtil(IProject project) {
		init(project);
	}

	private void init(IProject project) {		
		GenarchProjectConfigurationFile configuration = GenarchProjectConfigurationFile.open(project);
		
		sourceContainers = configuration.getSourceContainers();
		resourceContainers = configuration.getResourceContainers();

		IFile architectureModelFile = project.getFile(configuration.getArchitectureModelPath());
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());

		ResourceSet architectureResourceSet = new ResourceSetImpl();
		this.architectureResource = architectureResourceSet.getResource(architectureFileURI, true);

		this.architecture = (Architecture)architectureResource.getContents().get(0);
	}

	public void addElement(ArchitectureEntity element) {
		String containerName = new Path(element.getPath()).segment(0).toString();
		EObject container = getContainer(containerName);

		if ( container != null ) {
			if ( container instanceof ArchitectureResourcesContainer ) {
				addResourceElement(element);
			} else if ( container instanceof ArchitectureContainer ) {
				addSourceElement(element);
			}
		} else {
			if ( sourceContainers.contains(containerName) ) {
				ArchitectureContainer sourceContaier = architectureFactory.createArchitectureContainer();
				sourceContaier.setName(containerName);
				this.architecture.getContainers().add(sourceContaier);
				
				addSourceElement(element);
			} else if ( resourceContainers.contains(containerName) ) {
				ArchitectureResourcesContainer resourceContainer = architectureFactory.createArchitectureResourcesContainer();
				resourceContainer.setName(containerName);
				this.architecture.getResourcesContainer().add(resourceContainer);
				
				addResourceElement(element);
			}
		}
	}
	
	private void addResourceElement(ArchitectureEntity element) {

		if ( element(element.getPath()) != null ) {
			return;
		}

		Path iPath = new Path(element.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2 ) {
			ArchitectureResourcesContainer container = resourcesContainer(iPath.segment(0));

			if ( container != null ) {
				if ( element instanceof ConfigurationFolder ) {
					container.getFolders().add(element);
				} else if ( element instanceof ConfigurationFile ) {
					container.getFiles().add(element);
				} else if ( element instanceof ConfigurationTemplate ) {
					container.getTemplates().add(element);
				}
			} else {
				container = architectureFactory.createArchitectureResourcesContainer();
				container.setName(iPath.segment(0));
				if ( element instanceof ConfigurationFolder ) {
					container.getFolders().add(element);
				} else if ( element instanceof ConfigurationFile ) {
					container.getFiles().add(element);
				} else if ( element instanceof ConfigurationTemplate ) {
					container.getTemplates().add(element);
				}
				this.architecture.getResourcesContainer().add(container);
			}
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ArchitectureFolder parent = (ArchitectureFolder)element(parentPath);

			if ( parent == null ) {
				parent = addFolder(parentPath);
			} 

			if ( element instanceof ArchitectureTemplate ) {
				parent.getTemplates().add(element);
			} else if ( element instanceof ArchitectureFile ) {
				parent.getFiles().add(element); 
			} else if ( element instanceof ArchitectureFolder ) {
				parent.getSubFolders().add(element);
			}
		}
	}

	private ArchitectureFolder addFolder(String folderPath) {
		ArchitectureFolder folder = this.architectureFactory.createArchitectureFolder();

		Path iPath = new Path(folderPath);
		int segmentCount = iPath.segmentCount();

		if ( segmentCount == 2 ) {	    
			folder.setName(iPath.segment(1));
			folder.setPath(folderPath);

			ArchitectureResourcesContainer container = resourcesContainer(iPath.segment(0));

			if ( container != null ) {
				container.getFolders().add(folder);
			} else {
				container = this.architectureFactory.createArchitectureResourcesContainer();
				container.setName(iPath.segment(0));
				container.getFolders().add(folder);
				this.architecture.getResourcesContainer().add(container);
			}	    	   
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ArchitectureFolder parent = (ArchitectureFolder)element(parentPath);

			if ( parent == null ) {
				parent = addFolder(parentPath);
			}

			folder.setName(iPath.lastSegment());
			folder.setPath(folderPath);
			parent.getSubFolders().add(folder);
		}

		return folder;
	}

	private void addSourceElement(ArchitectureEntity element) {

		if ( element(element.getPath()) != null ) {
			return;
		}

		Path iPath = new Path(element.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2 ) {
			ArchitectureContainer container = sourceContaier(iPath.segment(0));

			if ( container != null ) {
				container.getComponents().add(element);
			} else {
				container = ArchitecturePackage.eINSTANCE.getArchitectureFactory().createArchitectureContainer();
				container.setName(iPath.segment(1));
				container.getComponents().add(element);
				this.architecture.getContainers().add(container);
			}	    
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ArchitectureComponent parent = (ArchitectureComponent)element(parentPath);

			if ( parent == null ) {
				parent = addComponent(parentPath);
			} 

			if ( element instanceof ArchitectureClass ) {	  
				parent.getClasses().add(element);
			} else if ( element instanceof ArchitectureAspect ) {
				parent.getAspects().add(element);
			} else if ( element instanceof ArchitectureTemplate ) {
				parent.getTemplates().add(element);
			} else if ( element instanceof ArchitectureFile ) {
				parent.getFiles().add(element); 
			} else if ( element instanceof ArchitectureComponent ) {
				parent.getSubComponents().add(element);
			}	      
		}
	}

	private ArchitectureComponent addComponent(String containerPath) {
		ArchitectureComponent c = this.architectureFactory.createArchitectureComponent();

		Path iPath = new Path(containerPath);
		int segmentCount = iPath.segmentCount();

		if ( segmentCount == 2 ) {
			ArchitectureContainer container = sourceContaier(iPath.segment(0));

			if ( container != null ) {
				container.getComponents().add(c);
			} else {
				container = ArchitecturePackage.eINSTANCE.getArchitectureFactory().createArchitectureContainer();
				container.setName(iPath.segment(1));
				container.getComponents().add(c);
				this.architecture.getContainers().add(container);
			}
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ArchitectureComponent parent = (ArchitectureComponent)element(parentPath);

			if ( parent == null ) {
				parent = addComponent(parentPath);
			} 

			parent.getSubComponents().add(c);

		}

		return c;
	}

	private EObject getContainer(String name) {
		TreeIterator iterator = this.architecture.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();
			if ( o instanceof ArchitectureContainer ) {
				ArchitectureContainer c = (ArchitectureContainer)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ArchitectureResourcesContainer ) {
				ArchitectureResourcesContainer c = (ArchitectureResourcesContainer)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			}
		}

		return null;
	}

	private ArchitectureResourcesContainer resourcesContainer(String name) {
		EList containers = this.architecture.getResourcesContainer();

		for ( int x = 0; x < containers.size(); x++ ) {
			ArchitectureResourcesContainer container = (ArchitectureResourcesContainer)containers.get(x);
			if ( container.getName().equals(name) ) {
				return container;
			}
		}

		return null;
	}

	private ArchitectureContainer sourceContaier(String name) {
		EList containers = this.architecture.getContainers();

		for ( int x = 0; x < containers.size(); x++ ) {
			ArchitectureContainer container = (ArchitectureContainer)containers.get(x);
			if ( container.getName().equals(name) ) {
				return container;
			}
		}

		return null;
	}

	public void removeElement(String elementPath) {
		String containerName = new Path(elementPath).segment(0).toString();
		EObject container = getContainer(containerName);

		if ( container != null ) {
			if ( container instanceof ArchitectureResourcesContainer ) {
				removeResourceElement(elementPath);
			} else if ( container instanceof ArchitectureContainer ) {
				removeSourceElement(elementPath);
			}
		}
	}

	private void removeResourceElement(String elementPath) {
		ArchitectureEntity element = element(elementPath);

		if ( element == null ) {
			return;
		}

		Path iPath = new Path(elementPath);	
		int segmentCount = iPath.segmentCount();
		ArchitectureFolder parent = (ArchitectureFolder)element(iPath.removeLastSegments(1).toString());

		if ( element instanceof ArchitectureFolder ) {
			if ( segmentCount == 2 ) {
				ArchitectureResourcesContainer container = (ArchitectureResourcesContainer)sourceContaier(iPath.segment(0));
				container.getFolders().remove(element);
			} else {			    
				parent.getSubFolders().remove(element);
			}
		} 

		if ( element instanceof ArchitectureTemplate ) {
			parent.getTemplates().remove(element);
		} else if ( element instanceof ArchitectureFile ) {
			parent.getFiles().remove(element);
		}

		removeFolder(parent.getPath());
	}

	private void removeFolder(String path) {
		EObject o = element(path);

		if ( o == null ) {
			return;
		}

		if ( o instanceof ArchitectureFolder ) {
			ArchitectureFolder c = (ArchitectureFolder)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount();

			if ( !c.eContents().isEmpty() ) {
				return;
			}

			if ( segmentCount == 2 ) {
				ArchitectureResourcesContainer container = resourcesContainer(iPath.segment(0));
				container.getFolders().remove(c);
			} else {
				String parentPath = iPath.removeLastSegments(1).toString();
				ArchitectureFolder parent = (ArchitectureFolder)element(parentPath);	    
				parent.getSubFolders().remove(c);
				removeFolder(parent.getPath());
			}
		} 
	}

	private void removeSourceElement(String elementPath) {	
		ArchitectureEntity element = element(elementPath);

		if ( element == null ) {
			return;
		}

		Path iPath = new Path(elementPath);	
		int segmentCount = iPath.segmentCount();
		ArchitectureComponent parent = (ArchitectureComponent)element(iPath.removeLastSegments(1).toString());

		if ( element instanceof ArchitectureComponent ) {
			if ( segmentCount == 2 ) {
				ArchitectureContainer container = sourceContaier(iPath.segment(0));
				container.getComponents().remove(element);
			} else {			    
				parent.getSubComponents().remove(element);
			}
		} 

		if ( element instanceof ArchitectureClass ) {	  
			parent.getClasses().remove(element);
		} else if ( element instanceof ArchitectureAspect ) {
			parent.getAspects().remove(element);
		} else if ( element instanceof ArchitectureTemplate ) {
			parent.getTemplates().remove(element);
		} else if ( element instanceof ArchitectureFile ) {
			parent.getFiles().remove(element);
		}

		removeComponent(parent.getPath());
	}

	private void removeComponent(String path) {
		EObject o = element(path);

		if ( o == null ) {
			return;
		}

		if ( o instanceof ArchitectureComponent ) {
			ArchitectureComponent c = (ArchitectureComponent)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount();

			if ( !c.eContents().isEmpty() ) {
				return;
			}

			if ( segmentCount == 2 ) {
				ArchitectureContainer container = sourceContaier(iPath.segment(0));
				container.getComponents().remove(c);
			} else {
				String parentPath = iPath.removeLastSegments(1).toString();
				ArchitectureComponent parent = (ArchitectureComponent)element(parentPath);	    
				parent.getSubComponents().remove(c);
				removeComponent(parent.getPath());
			}
		} 
	}

	public ArchitectureEntity element(String path) {
		TreeIterator iterator = architecture.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof ArchitectureEntity ) {
				ArchitectureEntity c = (ArchitectureEntity)o;
				if ( c.getPath().equals(path) ) {
					return c;
				}
			}	   
		}

		return null;
	}
	
	public List<ArchitectureEntity> elements() {
		List<ArchitectureEntity> entities = new ArrayList<ArchitectureEntity>();
		TreeIterator iterator = architecture.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof ArchitectureEntity ) {
				ArchitectureEntity c = (ArchitectureEntity)o;
				entities.add(c);
			}	   
		}
		
		return entities;
	}
		
	public void saveModel() {
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		try {
			architectureResource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}
}
