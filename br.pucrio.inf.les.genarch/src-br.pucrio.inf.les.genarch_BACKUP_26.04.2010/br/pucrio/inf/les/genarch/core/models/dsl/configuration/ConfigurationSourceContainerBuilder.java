package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;

public class ConfigurationSourceContainerBuilder {
	
	private ConfigurationContainer configurationContainer;
	
	private ConfigurationSourceContainerBuilder() {
		this.configurationContainer = ConfigurationFactory.eINSTANCE.createConfigurationContainer();
	}
	
	public static ConfigurationSourceContainerBuilder configurationSourceContainer() {
		return new ConfigurationSourceContainerBuilder();
	}
	
	public ConfigurationContainer build() {
		return this.configurationContainer;
	}
	
	public ConfigurationSourceContainerBuilder name(String name) {
		this.configurationContainer.setName(name);
		return this;
	}
	
	public ConfigurationSourceContainerBuilder addComponent(ArchitectureComponent architectureComponent) {
		this.configurationContainer.getComponents().add(architectureComponent);
		return this;
	}

}
