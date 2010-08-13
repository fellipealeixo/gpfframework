package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import static br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationComponentBuilder.configurationComponent;
import static br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationFolderBuilder.configurationFolder;
import static br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationResourcesContainerBuilder.configurationResourcesContainer;
import static br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationSourceContainerBuilder.configurationSourceContainer;
import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractComponentParentPath;
import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractContainerName;
import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractElementNameByPath;

import org.eclipse.core.runtime.Path;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;

public class ConfigurationModelAddElement {

	private ConfigurationModelHandle configurationModelHandle;

	public ConfigurationModelAddElement(ConfigurationModelHandle configurationModelHandle) {
		this.configurationModelHandle = configurationModelHandle;
	}

	public ConfigurationModelAddElement component(ConfigurationComponent configurationComponent) {
		Path iPath = new Path(configurationComponent.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2) {
			ConfigurationContainer container = configurationModelHandle.get().sourceContainer(extractContainerName(configurationComponent.getPath()));

			if (container != null) {
				container.getComponents().add(configurationComponent);
			} else {
				container = configurationSourceContainer().name(extractContainerName(configurationComponent.getPath())).build();
				container.getComponents().add(configurationComponent);
				this.configurationModelHandle.getMappingRelationships().getContainers().add(container);
			}
		} else {
			ConfigurationComponent parent = configurationModelHandle.get().component(extractComponentParentPath(configurationComponent.getPath()));

			if (parent == null) {
				parent = configurationComponent().name(extractElementNameByPath(extractComponentParentPath(configurationComponent.getPath()))).path(extractComponentParentPath(configurationComponent.getPath())).build();
				component(parent);

			}

			parent.getSubComponents().add(configurationComponent);
		}
		return this;
	}

	public ConfigurationModelAddElement folder(ConfigurationFolder configurationFolder) {
		Path iPath = new Path(configurationFolder.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2) {
			ConfigurationResourcesContainer container = configurationModelHandle.get().resourceContainer(extractContainerName(configurationFolder.getPath()));

			if (container != null) {
				container.getFolders().add(configurationFolder);
			} else {
				this.configurationModelHandle.getMappingRelationships().getResourcesContainers().add(configurationResourcesContainer().name(extractContainerName(configurationFolder.getPath())));
			}
		} else {
			ConfigurationFolder parent = configurationModelHandle.get().folder(
					extractComponentParentPath(configurationFolder.getPath()));

			if (parent == null) {
				parent = configurationFolder().name(extractElementNameByPath(extractComponentParentPath(configurationFolder.getPath()))).path(extractComponentParentPath(configurationFolder.getPath())).build();
				folder(parent);

			}

			parent.getSubFolders().add(configurationFolder);
		}
		return this;
	}

	public ConfigurationModelAddElement clazz(ConfigurationClass configurationClass) {
		if (configurationModelHandle.get().clazz(configurationClass.getPath()) == null) {
			ConfigurationComponent parent = configurationModelHandle.get().component(extractComponentParentPath(configurationClass.getPath()));

			if (parent == null) {
				parent = configurationComponent().name(extractElementNameByPath(extractComponentParentPath(configurationClass.getPath()))).path(extractComponentParentPath(configurationClass.getPath())).build();
				component(parent);
			}

			parent.getClasses().add(configurationClass);
		}
		return this;
	}

	public ConfigurationModelAddElement aspect(ConfigurationAspect configurationAspect) {
		if (configurationModelHandle.get().aspect(configurationAspect.getPath()) == null) {
			ConfigurationComponent parent = configurationModelHandle.get().component(extractComponentParentPath(configurationAspect.getPath()));

			if (parent == null) {
				parent = configurationComponent().name(extractElementNameByPath(extractComponentParentPath(configurationAspect.getPath()))).path(extractComponentParentPath(configurationAspect.getPath())).build();
				component(parent);
			}

			parent.getAspects().add(configurationAspect);
		}
		return this;
	}

	public ConfigurationModelAddElement file(ConfigurationFile configurationFile) {
		if (configurationModelHandle.get().file(configurationFile.getPath()) == null) {
			Path iPath = new Path(configurationFile.getPath());
			int segmentCount = iPath.segmentCount();

			if (segmentCount == 2) {
				ConfigurationResourcesContainer container = configurationModelHandle.get().resourceContainer(extractContainerName(configurationFile.getPath()));

				if (container != null) {
					container.getFiles().add(configurationFile);
				} else {
					this.configurationModelHandle.getMappingRelationships().getResourcesContainers().add(configurationResourcesContainer().name(extractContainerName(configurationFile.getPath())));
				}
			} else {
				ConfigurationContainer sourceContainer = configurationModelHandle.get().sourceContainer(extractContainerName(configurationFile.getPath()));

				if (sourceContainer != null) {
					ConfigurationComponent parent = configurationModelHandle.get().component(extractComponentParentPath(configurationFile.getPath()));

					if (parent == null) {
						parent = configurationComponent().name(extractElementNameByPath(extractComponentParentPath(configurationFile.getPath()))).path(extractComponentParentPath(configurationFile.getPath())).build();
						component(parent);
					}

					parent.getFiles().add(configurationFile);
				} else {
					ConfigurationResourcesContainer resourcesContainer = configurationModelHandle.get().resourceContainer(extractContainerName(configurationFile.getPath()));

					if (resourcesContainer != null) {
						ConfigurationFolder parent = configurationModelHandle.get().folder(extractComponentParentPath(configurationFile.getPath()));

						if (parent == null) {
							parent = configurationFolder().name(extractElementNameByPath(extractComponentParentPath(configurationFile.getPath()))).path(extractComponentParentPath(configurationFile.getPath())).build();
							folder(parent);

						}

						parent.getFiles().add(configurationFile);
					}
				}
			}
		}
		return this;
	}

	public ConfigurationModelAddElement template(ConfigurationTemplate configurationTemplate) {
		if ( configurationModelHandle.get().file(configurationTemplate.getPath()) == null ) {
			ConfigurationComponent parent = configurationModelHandle.get().component(extractComponentParentPath(configurationTemplate.getPath()));

			if ( parent == null ) {
				parent = configurationComponent().name(extractElementNameByPath(extractComponentParentPath(configurationTemplate.getPath())))
				.path(extractComponentParentPath(configurationTemplate.getPath())).build();
				component(parent);
			}

			parent.getTemplates().add(configurationTemplate);
		}
		return this;
	}}
