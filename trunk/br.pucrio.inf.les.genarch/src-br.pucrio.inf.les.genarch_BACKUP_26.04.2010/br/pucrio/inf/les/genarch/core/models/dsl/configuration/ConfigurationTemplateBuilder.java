package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationTemplateBuilder {
	
	private ConfigurationTemplate configurationTemplate;
	
	private ConfigurationTemplateBuilder() {
		this.configurationTemplate = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createConfigurationTemplate();
	}
	
	public static ConfigurationTemplateBuilder create() {
		return new ConfigurationTemplateBuilder();
	}
	
	public ConfigurationTemplate build() {
		return this.configurationTemplate;
	}
	
	public ConfigurationTemplateBuilder name(String name) {
		this.configurationTemplate.setName(name);
		return this;
	}
	
	public ConfigurationTemplateBuilder path(String path) {
		this.configurationTemplate.setPath(path);
		return this;
	}	
}
