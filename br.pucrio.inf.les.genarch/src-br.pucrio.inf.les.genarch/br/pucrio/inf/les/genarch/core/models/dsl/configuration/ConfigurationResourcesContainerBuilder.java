package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer;

public class ConfigurationResourcesContainerBuilder {
	
	private ConfigurationResourcesContainer configurationResourcesContainer;
	
	private ConfigurationResourcesContainerBuilder() {
		this.configurationResourcesContainer = ConfigurationFactory.eINSTANCE.createConfigurationResourcesContainer();
	}
	
	public static ConfigurationResourcesContainerBuilder configurationResourcesContainer() {
		return new ConfigurationResourcesContainerBuilder();
	}
	
	public ConfigurationResourcesContainer build() {
		return configurationResourcesContainer;
	}
	
	public ConfigurationResourcesContainerBuilder name(String name) {
		this.configurationResourcesContainer.setName(name);
		return this;
	}
	
	public ConfigurationResourcesContainerBuilder addFolder(ConfigurationFolder configurationFolder) {
		this.configurationResourcesContainer.getFolders().add(configurationFolder);
		return this;
	}
	
	public ConfigurationResourcesContainerBuilder addFile(ConfigurationFile configurationFile) {
		this.configurationResourcesContainer.getFiles().add(configurationFile);
		return this;
	}

}
