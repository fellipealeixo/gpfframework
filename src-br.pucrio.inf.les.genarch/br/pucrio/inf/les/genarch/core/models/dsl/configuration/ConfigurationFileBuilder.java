package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationFileBuilder {
	
	private ConfigurationFile configurationFile;
	
	private ConfigurationFileBuilder() {
		this.configurationFile = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createConfigurationFile();
	}
	
	public ConfigurationFile build() {
		return configurationFile;
	}
	
	public static ConfigurationFileBuilder configurationFile() {
		return new ConfigurationFileBuilder();
	}
	
	public ConfigurationFileBuilder name(String name) {
		this.configurationFile.setName(name);
		return this;
	}
	
	public ConfigurationFileBuilder path(String path) {
		this.configurationFile.setPath(path);
		return this;
	}

}
