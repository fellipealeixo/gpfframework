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
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationModelUtil {

	private MappingRelationships mappingRelationships;
	private Resource configurationResource;
	private ConfigurationFactory configurationFactory = ConfigurationPackageImpl.init().getConfigurationFactory();
	private GenarchProjectConfigurationFile genarchProjectConfigurationFile;

	public ConfigurationModelUtil(IProject project) {
		init(project);
	}

	private void init(IProject project) {
		genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		IFile configurationModelFile = project.getFile(genarchProjectConfigurationFile.getConfigurationModelPath());
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString());

		ResourceSet configurationResourceSet = new ResourceSetImpl();
		this.configurationResource = configurationResourceSet.getResource(configurationFileURI, true);

		Configuration configuration = (Configuration)configurationResource.getContents().get(0);
		this.mappingRelationships = configuration.getMappingRelationships();

	}

	public void addMappingElement(MappingEntity element) {
		String containerName = new Path(element.getPath()).segment(0).toString();
		EObject container = getContainer(containerName);

		if ( container != null ) {
			if ( container instanceof ConfigurationResourcesContainer ) {
				addResourceMappingElement(element);
			} else if ( container instanceof ConfigurationContainer ) {
				addSourceMappingElement(element);
			} else if ( container instanceof ConfigurationFragmentContainer ) {
				addFragmentMappingElement(element);
			}
		}
	}
	
	private void addFragmentMappingElement(MappingEntity element) {
		
		if ( mappingElement(element.getPath()) != null ) {
			return;
		}
		
		String containerName = new Path(element.getPath()).segment(0).toString();
		ConfigurationFragmentContainer fragmentContainer = (ConfigurationFragmentContainer)getContainer(containerName);
		
		fragmentContainer.getFragments().add(element);
	}

	private void addResourceMappingElement(MappingEntity element) {

		if ( mappingElement(element.getPath()) != null ) {
			return;
		}

		Path iPath = new Path(element.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2) {
			ConfigurationResourcesContainer container = resourcesContainer(iPath.segment(0));

			if ( container != null ) {
				if ( element instanceof ConfigurationFolder ) {
					container.getFolders().add(element);
				} else if ( element instanceof ConfigurationFile ) {
					container.getFiles().add(element);
				} else if ( element instanceof ConfigurationTemplate ) {
					container.getTemplates().add(element);
				}
			} else {
				container = configurationFactory.createConfigurationResourcesContainer();
				container.setName(iPath.segment(0));
				if ( element instanceof ConfigurationFolder ) {
					container.getFolders().add(element);
				} else if ( element instanceof ConfigurationFile ) {
					container.getFiles().add(element);
				} else if ( element instanceof ConfigurationTemplate ) {
					container.getTemplates().add(element);
				}
				this.mappingRelationships.getResourcesContainers().add(container);
			}
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ConfigurationFolder parent = (ConfigurationFolder)mappingElement(parentPath);

			if ( parent == null ) {
				parent = addFolder(parentPath);
			} 

			if ( element instanceof ConfigurationTemplate ) {
				parent.getTemplates().add(element);
			} else if ( element instanceof ConfigurationFile ) {
				parent.getFiles().add(element);
			} else if ( element instanceof ConfigurationFolder ) {
				parent.getSubFolders().add(element);
			}
		}
	}

	private ConfigurationFolder addFolder(String folderPath) {
		ConfigurationFolder folder = configurationFactory.createConfigurationFolder();

		Path iPath = new Path(folderPath);
		int segmentCount = iPath.segmentCount();

		if ( segmentCount == 2 ) {	    
			folder.setName(iPath.segment(1));
			folder.setPath(folderPath);

			ConfigurationResourcesContainer container = resourcesContainer(iPath.segment(0));

			if ( container != null ) {
				container.getFolders().add(folder);
			} else {
				container = configurationFactory.createConfigurationResourcesContainer();
				container.setName(iPath.segment(0));
				container.getFolders().add(folder);
				this.mappingRelationships.getResourcesContainers().add(container);
			}	    	   
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ConfigurationFolder parent = (ConfigurationFolder)mappingElement(parentPath);

			if ( parent == null ) {
				parent = addFolder(parentPath);
			}

			folder.setName(iPath.lastSegment());
			folder.setPath(folderPath);
			parent.getSubFolders().add(folder);
		}

		return folder;
	}

	private void addSourceMappingElement(MappingEntity element) {

		if ( mappingElement(element.getPath()) != null ) {
			return;
		}

		Path iPath = new Path(element.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2) {
			ConfigurationContainer container = container(iPath.segment(0));

			if ( container != null ) {
				container.getComponents().add(element);
			} else {
				container = configurationFactory.createConfigurationContainer();
				container.setName(iPath.segment(0));
				container.getComponents().add(element);
				this.mappingRelationships.getContainers().add(container);
			}
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ConfigurationComponent parent = (ConfigurationComponent)mappingElement(parentPath);

			if ( parent == null ) {
				parent = addComponent(parentPath);
			} 

			if ( element instanceof ConfigurationClass ) {	  
				parent.getClasses().add(element);
			} else if ( element instanceof ConfigurationAspect ) {
				parent.getAspects().add(element);
			} else if ( element instanceof ConfigurationTemplate ) {
				parent.getTemplates().add(element);
			} else if ( element instanceof ConfigurationFile ) {
				parent.getFiles().add(element);
			} else if ( element instanceof ConfigurationComponent ) {
				parent.getSubComponents().add(element);
			}
		}
	}

	private ConfigurationComponent addComponent(String componentPath) {
		ConfigurationComponent component = configurationFactory.createConfigurationComponent();

		Path iPath = new Path(componentPath);
		int segmentCount = iPath.segmentCount();

		if ( segmentCount == 2 ) {	    
			component.setName(iPath.segment(1));
			component.setPath(componentPath);

			ConfigurationContainer container = container(iPath.segment(0));

			if ( container != null ) {
				container.getComponents().add(component);
			} else {
				container = configurationFactory.createConfigurationContainer();
				container.setName(iPath.segment(0));
				container.getComponents().add(component);
				this.mappingRelationships.getContainers().add(container);
			}	    	   
		} else {
			String parentPath = iPath.removeLastSegments(1).toString();
			ConfigurationComponent parent = (ConfigurationComponent)mappingElement(parentPath);

			if ( parent == null ) {
				parent = addComponent(parentPath);
			}

			component.setName(iPath.lastSegment());
			component.setPath(componentPath);
			parent.getSubComponents().add(component);
		}

		return component;
	}
	
	public void addFragment(ConfigurationFragment fragment,String containerName) {
		ConfigurationFragmentContainer fragmentContainer = getFragmentContainer(containerName);		
		
		if ( fragmentContainer == null ) {
			fragmentContainer = this.configurationFactory.createConfigurationFragmentContainer();
			fragmentContainer.setName(containerName);
			this.mappingRelationships.getFragmentsContainer().add(fragmentContainer);
		}
		
		fragmentContainer.getFragments().add(fragment);
	}
	
	private ConfigurationFragmentContainer getFragmentContainer(String name) {
		EList containers = this.mappingRelationships.getFragmentsContainer();

		for ( int x = 0; x < containers.size(); x++ ) {
			ConfigurationFragmentContainer container = (ConfigurationFragmentContainer)containers.get(x);
			if ( container.getName().equals(name) ) {
				return container;
			}
		}

		return null;
	}

	private EObject getContainer(String name) {
		TreeIterator iterator = this.configurationResource.getAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();
			if ( o instanceof ConfigurationContainer ) {
				ConfigurationContainer c = (ConfigurationContainer)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationResourcesContainer ) {
				ConfigurationResourcesContainer c = (ConfigurationResourcesContainer)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationFragmentContainer ) {
				ConfigurationFragmentContainer c = (ConfigurationFragmentContainer)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			}
		}

		return null;
	}

	private ConfigurationContainer container(String name) {
		EList containers = this.mappingRelationships.getContainers();

		for ( int x = 0; x < containers.size(); x++ ) {
			ConfigurationContainer container = (ConfigurationContainer)containers.get(x);
			if ( container.getName().equals(name) ) {
				return container;
			}
		}

		return null;
	}

	private ConfigurationResourcesContainer resourcesContainer(String name) {
		EList containers = this.mappingRelationships.getResourcesContainers();

		for ( int x = 0; x < containers.size(); x++ ) {
			ConfigurationResourcesContainer container = (ConfigurationResourcesContainer)containers.get(x);
			if ( container.getName().equals(name) ) {
				return container;
			}
		}

		return null;
	}

	public void removeMappingElement(String elementPath) {
		String containerName = new Path(elementPath).segment(0).toString();
		EObject container = getContainer(containerName);

		if ( container != null ) {
			if ( container instanceof ConfigurationResourcesContainer ) {
				removeResourceMappingElement(elementPath);
			} else if ( container instanceof ConfigurationContainer ) {
				removeSourceMappingElement(elementPath);
			}
		}
	}

	private void removeResourceMappingElement(String elementPath) {
		MappingEntity element = mappingElement(elementPath);

		if ( element == null ) {
			return;
		}

		Path iPath = new Path(elementPath);	
		int segmentCount = iPath.segmentCount();
		ConfigurationFolder parent = (ConfigurationFolder)mappingElement(iPath.removeLastSegments(1).toString());

		if ( element instanceof ConfigurationFolder ) {
			if ( segmentCount == 2 ) {
				ConfigurationResourcesContainer container = (ConfigurationResourcesContainer)getContainer(iPath.segment(0));
				if ( container != null ) {
					container.getFolders().remove(element);
				}
			} else {			    
				parent.getSubFolders().remove(element);
			}
		} 

		if ( element instanceof ConfigurationTemplate ) {
			parent.getTemplates().remove(element);
		} else if ( element instanceof ConfigurationFile ) {
			parent.getFiles().remove(element);
		}

		removeFolder(parent.getPath());
	}

	private void removeFolder(String path) {
		EObject o = mappingElement(path);

		if ( o == null ) {
			return;
		}

		if ( o instanceof ConfigurationFolder ) {
			ConfigurationFolder c = (ConfigurationFolder)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount();

			if ( !c.eContents().isEmpty() ) {
				return;
			}

			if ( segmentCount == 2 ) {
				ConfigurationResourcesContainer container = (ConfigurationResourcesContainer)getContainer(iPath.segment(0));
				if ( container != null ) {
					container.getFolders().remove(c);
				}
			} else {
				String parentPath = iPath.removeLastSegments(1).toString();
				ConfigurationFolder parent = (ConfigurationFolder)mappingElement(parentPath);	    
				parent.getSubFolders().remove(c);
				removeFolder(parent.getPath());
			}
		} 
	}

	private void removeSourceMappingElement(String elementPath) {	
		MappingEntity element = mappingElement(elementPath);

		if ( element == null ) {
			return;
		}

		Path iPath = new Path(elementPath);	
		int segmentCount = iPath.segmentCount();
		ConfigurationComponent parent = (ConfigurationComponent)mappingElement(iPath.removeLastSegments(1).toString());

		if ( element instanceof ConfigurationComponent ) {
			if ( segmentCount == 2 ) {
				ConfigurationContainer container = container(iPath.segment(0));
				if ( container != null ) {
					container.getComponents().remove(element);
				}
			} else {			    
				parent.getSubComponents().remove(element);
			}
		} 

		if ( element instanceof ConfigurationClass ) {	  
			parent.getClasses().remove(element);
		} else if ( element instanceof ConfigurationAspect ) {
			parent.getAspects().remove(element);
		} else if ( element instanceof ConfigurationTemplate ) {
			parent.getTemplates().remove(element);
		} else if ( element instanceof ConfigurationFile ) {
			parent.getFiles().remove(element);
		}

		removeComponent(parent.getPath());
	}

	private void removeComponent(String path) {
		EObject o = mappingElement(path);

		if ( o == null ) {
			return;
		}

		if ( o instanceof ConfigurationComponent ) {
			ConfigurationComponent c = (ConfigurationComponent)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount();

			if ( !c.eContents().isEmpty() ) {
				return;
			}

			if ( segmentCount == 2 ) {
				ConfigurationContainer container = container(iPath.segment(0));
				if ( container != null ) {
					container.getComponents().remove(c);
				}
			} else {
				String parentPath = iPath.removeLastSegments(1).toString();
				ConfigurationComponent parent = (ConfigurationComponent)mappingElement(parentPath);	    
				parent.getSubComponents().remove(c);
				removeComponent(parent.getPath());
			}
		} 
	}

	public MappingEntity mappingElement(String path) {
		TreeIterator iterator = mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof MappingEntity ) {
				MappingEntity c = (MappingEntity)o;
				if ( c.getPath().equals(path) ) {
					return c;
				}
			}	   
		}
		
		return null;
	}
	
	public ConfigurationFragment fragment(String name) {
		TreeIterator iterator = mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof ConfigurationFragment ) {
				ConfigurationFragment c = (ConfigurationFragment)o;
				if ( c.getName().equals(name) ) {
					return c;
				}
			}	   
		}

		return null;
	}
	
	public List<MappingEntity> mappingElements() {
		List<MappingEntity> entities = new ArrayList<MappingEntity>();
		TreeIterator iterator = mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof MappingEntity ) {
				MappingEntity c = (MappingEntity)o;
				entities.add(c);
			}	   
		}

		return null;
	}
	
	

	public MappingRelationships getMappingRelationships() {
		return mappingRelationships;
	}

	public void saveModel() {
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		try {
			configurationResource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}
}
