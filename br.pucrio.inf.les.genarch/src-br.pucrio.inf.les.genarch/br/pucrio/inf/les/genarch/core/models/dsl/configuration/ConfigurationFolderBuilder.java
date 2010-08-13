package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationFolderBuilder {
	
	private ConfigurationFolder configurationFolder;
	
	private ConfigurationFolderBuilder() {
		this.configurationFolder = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createConfigurationFolder();	
	}
	
	public static ConfigurationFolderBuilder configurationFolder() {
		return new ConfigurationFolderBuilder();		
	}
	
	public ConfigurationFolder build() {
		return configurationFolder;
	}
	
	public ConfigurationFolderBuilder name(String name) {
		this.configurationFolder.setName(name);
		return this;
	}
	
	public ConfigurationFolderBuilder path(String path) {
		this.configurationFolder.setPath(path);
		return this;
	}
	
	public ConfigurationFolderBuilder addFile(ArchitectureFile architectureFile) {
		this.configurationFolder.getFiles().add(architectureFile);
		return this;
	}
	
	public ConfigurationFolderBuilder addTemplate(ArchitectureTemplate architectureTemplate) {
		this.configurationFolder.getTemplates().add(architectureTemplate);
		return this;
	}
	
	public ConfigurationFolderBuilder addSubFolder(ArchitectureFolder architectureFolder) {
		this.configurationFolder.getSubFolders().add(architectureFolder);
		return this;
	}

}
