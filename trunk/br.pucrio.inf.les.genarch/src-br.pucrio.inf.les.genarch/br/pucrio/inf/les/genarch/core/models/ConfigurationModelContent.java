package br.pucrio.inf.les.genarch.core.models;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationModelContent {

	private ConfigurationPackage configurationPackage;
	private ConfigurationFactory configurationFactory;
	private Configuration configuration;
	private MappingRelationships mappingRelationships;

	public ConfigurationModelContent() {
		init();
		this.configuration = this.configurationFactory.createConfiguration();
		this.mappingRelationships = this.configurationFactory.createMappingRelationships();
		this.configuration.setMappingRelationships(this.mappingRelationships);
	}

	public ConfigurationModelContent(Configuration configuration) {
		init();
		this.configuration = configuration;
		this.mappingRelationships = configuration.getMappingRelationships();
	}

	private void init() {
		ConfigurationPackageImpl.init();
		this.configurationPackage = ConfigurationPackage.eINSTANCE;
		this.configurationFactory = this.configurationPackage.getConfigurationFactory();	
	}

	public ConfigurationContainer addSourceContainer(String name) {
		ConfigurationContainer container = this.configurationFactory.createConfigurationContainer();
		container.setName(name);
		this.mappingRelationships.getContainers().add(container);
		return container;
	}

	public ConfigurationResourcesContainer addResourcesContainer(String name) {
		ConfigurationResourcesContainer container = this.configurationFactory.createConfigurationResourcesContainer();
		container.setName(name);
		this.mappingRelationships.getResourcesContainers().add(container);
		return container;
	}

	private ConfigurationComponent createComponent(String name,String path) {
		ConfigurationComponent component = this.configurationFactory.createConfigurationComponent();
		component.setName(name);
		component.setPath(path);
		return component;
	}

	private ConfigurationComponent addComponent(String componentPath) {
		IPath path = new Path(componentPath);

		ConfigurationComponent configurationComponent = this.createComponent(path.lastSegment(),path.toString());
		path = path.removeLastSegments(1);

		ConfigurationComponent componentAux = null;
		int segments = path.segmentCount();

		if ( segments > 1 ) {
			for ( int x = 0; x < segments; x++ ) {
				componentAux = this.getComponent(path.toString());

				if ( componentAux == null ) {
					componentAux = this.addComponent(path.toString());				
				} else {
					break;
				}
			}

			componentAux.getSubComponents().add(configurationComponent);
		} else {
			ConfigurationContainer container = this.getContaier(path.segment(0));
			if ( container != null ) {
				container.getComponents().add(configurationComponent);
			} else {
				container = addSourceContainer(path.segment(0));
				container.getComponents().add(configurationComponent);
			}	    
		}

		return configurationComponent;
	}

	public void addClass(String name,String path,String featureConfiguration,String componentPath) {
		if ( containsMappingEntity(path) ) return;	
		ConfigurationClass clazz = this.configurationFactory.createConfigurationClass();
		FeatureExpression feature = configurationFactory.createFeatureExpression();
		feature.setExpression(featureConfiguration);
		clazz.setName(name);
		clazz.setPath(path);
		clazz.setFeatureExpression(feature);

		ConfigurationComponent configurationComponent = this.getComponent(componentPath);

		if ( configurationComponent == null ) {
			configurationComponent = this.addComponent(componentPath);
		}

		configurationComponent.getClasses().add(clazz);
	}

	public void addAspect(String name,String path,String featureConfiguration,String componentPath) {
		if ( containsMappingEntity(path) ) return;
		ConfigurationAspect architectureAspect = this.configurationFactory.createConfigurationAspect();
		FeatureExpression feature = configurationFactory.createFeatureExpression();
		feature.setExpression(featureConfiguration);
		architectureAspect.setName(name);
		architectureAspect.setFeatureExpression(feature);
		architectureAspect.setPath(path);
		
		ConfigurationComponent configurationComponent = this.getComponent(componentPath);
		
		if ( configurationComponent == null ) {
			configurationComponent = this.addComponent(componentPath);
		}
		
		configurationComponent.getAspects().add(architectureAspect);
		
	}

	public void addTemplate(String name,String path,String featureConfiguration,String componentPath) {
		if ( containsMappingEntity(path) ) return;
		ConfigurationTemplate architectureTemplate = this.configurationFactory.createConfigurationTemplate();
		FeatureExpression feature = configurationFactory.createFeatureExpression();
		feature.setExpression(featureConfiguration);
		architectureTemplate.setName(name);
		architectureTemplate.setFeatureExpression(feature);
		architectureTemplate.setPath(path);

		ConfigurationComponent configurationComponent = this.getComponent(componentPath);

		if ( configurationComponent == null ) {
			configurationComponent = this.addComponent(componentPath);
		}

		configurationComponent.getTemplates().add(architectureTemplate);	
	}

	private ConfigurationContainer getContaier(String name) {
		EList containers = this.mappingRelationships.getContainers();

		for ( int x = 0; x < containers.size(); x++ ) {
			ConfigurationContainer container = (ConfigurationContainer)containers.get(x);
			if ( name.equals(container.getName()) ) {
				return container;
			}
		}

		return null;
	}

	private ConfigurationComponent getComponent(String path) {
		TreeIterator iterator = this.mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			final EObject o = (EObject)iterator.next();
			if ( o instanceof ConfigurationComponent ) {
				ConfigurationComponent c = (ConfigurationComponent)o;				
				if ( c.getPath().equals(path) ) {
					return c;
				}
			}
		}

		return null;
	}

	public boolean removeElementFromContainer(String containerName,String path) {

		EObject o = getElementByPath(path);

		if ( o == null ) {
			return false;
		}

		if ( o instanceof ConfigurationComponent ) {
			ConfigurationComponent c = (ConfigurationComponent)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount() - 1;

			if ( segmentCount == 1 ) {
				this.getContaier(containerName).getComponents().remove(c);
			} else {
				segmentCount--;
				String parentName = iPath.segment(segmentCount);
				ConfigurationComponent parent = (ConfigurationComponent)getElementByName(parentName);	    
				parent.getSubComponents().remove(c);
			}
		} else if ( o instanceof ConfigurationClass ) {
			ConfigurationClass c = (ConfigurationClass)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount() - 1;

			if ( segmentCount == 0 ) {
				return false;
			} else {
				segmentCount--;
				String parentName = iPath.segment(segmentCount);
				ConfigurationComponent parent = (ConfigurationComponent)getElementByName(parentName);	    
				parent.getClasses().remove(c);
			}	    
		} else if ( o instanceof ConfigurationAspect ) {
			ConfigurationAspect c = (ConfigurationAspect)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount() - 1;

			if ( segmentCount == 0 ) {
				return false;
			} else {
				segmentCount--;
				String parentName = iPath.segment(segmentCount);
				ConfigurationComponent parent = (ConfigurationComponent)getElementByName(parentName);	    
				parent.getAspects().remove(c);
			}
		} else if ( o instanceof ConfigurationTemplate ) {
			ConfigurationTemplate c = (ConfigurationTemplate)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount() - 1;

			if ( segmentCount == 0 ) {
				return false;
			} else {
				segmentCount--;
				String parentName = iPath.segment(segmentCount);
				ConfigurationComponent parent = (ConfigurationComponent)getElementByName(parentName);	    
				parent.getTemplates().remove(c);
			}
		} else if ( o instanceof ConfigurationFile ) {
			ConfigurationFile c = (ConfigurationFile)o;
			Path iPath = new Path(path);
			int segmentCount = iPath.segmentCount() - 1;

			if ( segmentCount == 0 ) {
				return false;
			} else {
				segmentCount--;
				String parentName = iPath.segment(segmentCount);
				ConfigurationComponent parent = (ConfigurationComponent)getElementByName(parentName);	    
				parent.getFiles().remove(c);
			}
		}

		return true;
	}

	public boolean containsMappingEntity(String path) {

		final TreeIterator iterator = this.mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			final EObject o = (EObject)iterator.next();

			if ( o instanceof ConfigurationComponent ) {
				ConfigurationComponent c = (ConfigurationComponent)o;				
				if ( c.getPath().equals(path) ) {
					return true;
				}
			} else if ( o instanceof ConfigurationClass ) {
				ConfigurationClass c = (ConfigurationClass)o;
				if ( c.getPath().equals(path) ) {
					return true;
				}
			} else if ( o instanceof ConfigurationAspect ) {
				ConfigurationAspect c = (ConfigurationAspect)o;
				if ( c.getPath().equals(path) ) {
					return true;
				}
			} else if ( o instanceof ConfigurationTemplate ) {
				ConfigurationTemplate c = (ConfigurationTemplate)o;
				if ( c.getPath().equals(path) ) {
					return true;
				}
			} else if ( o instanceof ConfigurationFile ) {
				ConfigurationFile c = (ConfigurationFile)o;
				if ( c.getPath().equals(path) ) {
					return true;
				}
			}
		}

		return false;
	}

	public EObject getElementByName(String name) {

		final TreeIterator iterator = this.mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			final EObject o = (EObject)iterator.next();

			if ( o instanceof ConfigurationComponent ) {
				ConfigurationComponent c = (ConfigurationComponent)o;				
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationClass ) {
				ConfigurationClass c = (ConfigurationClass)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationAspect ) {
				ConfigurationAspect c = (ConfigurationAspect)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationTemplate ) {
				ConfigurationTemplate c = (ConfigurationTemplate)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationFile ) {
				ConfigurationFile c = (ConfigurationFile)o;
				if ( c.getName().equals(name) ) {
					return o;
				}
			}
		}

		return null;	
	}

	public EObject getElementByPath(String path) {
		final TreeIterator iterator = this.mappingRelationships.eAllContents();

		while ( iterator.hasNext() ) {
			final EObject o = (EObject)iterator.next();

			if ( o instanceof ConfigurationComponent ) {
				ConfigurationComponent c = (ConfigurationComponent)o;				
				if ( c.getPath().equals(path) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationClass ) {
				ConfigurationClass c = (ConfigurationClass)o;
				if ( c.getPath().equals(path) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationAspect ) {
				ConfigurationAspect c = (ConfigurationAspect)o;
				if ( c.getPath().equals(path) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationTemplate ) {
				ConfigurationTemplate c = (ConfigurationTemplate)o;
				if ( c.getPath().equals(path) ) {
					return o;
				}
			} else if ( o instanceof ConfigurationFile ) {
				ConfigurationFile c = (ConfigurationFile)o;
				if ( c.getPath().equals(path) ) {
					return o;
				}
			}
		}

		return null;
	}
	
	public Configuration getConfiguration() {
		return this.configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
		this.mappingRelationships = configuration.getMappingRelationships();
	}
}
