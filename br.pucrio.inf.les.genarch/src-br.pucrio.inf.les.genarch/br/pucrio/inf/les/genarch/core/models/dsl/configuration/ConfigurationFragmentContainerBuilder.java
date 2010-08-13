package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;

public class ConfigurationFragmentContainerBuilder {
	
	private ConfigurationFragmentContainer fragmentContainer;
	
	private ConfigurationFragmentContainerBuilder() {
		this.fragmentContainer = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationFragmentContainer();
	}
	
	public ConfigurationFragmentContainer build() {
		return this.fragmentContainer;
	}
	
	public static ConfigurationFragmentContainerBuilder configurationFragmentContainer() {
		return new ConfigurationFragmentContainerBuilder();
	}
	
	public ConfigurationFragmentContainerBuilder name(String name) {
		this.fragmentContainer.setName(name);
		return this;
	}
	
	public ConfigurationFragmentContainerBuilder fragment(ConfigurationFragment fragment) {
		this.fragmentContainer.getFragments().add(fragment);
		return this;
	}

}
