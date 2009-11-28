package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationComponentBuilder {
	
	private ConfigurationComponent configurationComponent;
	
	private ConfigurationComponentBuilder() {
		this.configurationComponent = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createConfigurationComponent();
	}
	
	public ConfigurationComponent build() {
		return this.configurationComponent;
	}
	
	public static ConfigurationComponentBuilder configurationComponent() {
		return new ConfigurationComponentBuilder();
	}
	
	public ConfigurationComponentBuilder name(String name) {
		this.configurationComponent.setName(name);
		return this;
	}
	
	public ConfigurationComponentBuilder path(String path) {
		this.configurationComponent.setPath(path);
		return this;
	}
	
	public ConfigurationComponentBuilder addClass(ArchitectureClass architectureClass) {
		this.configurationComponent.getClasses().add(architectureClass);
		return this;
	}
	
	public ConfigurationComponentBuilder addAspect(ArchitectureAspect architectureAspect) {
		this.configurationComponent.getAspects().add(architectureAspect);
		return this;
	}
	
	public ConfigurationComponentBuilder addFile(ArchitectureFile architectureFile) {
		this.configurationComponent.getFiles().add(architectureFile);
		return this;
	}
	
	public ConfigurationComponentBuilder addTemplate(ArchitectureTemplate architectureTemplate) {
		this.configurationComponent.getTemplates().add(architectureTemplate);
		return this;
	}
	
	public ConfigurationComponentBuilder addSubComponents(ArchitectureComponent architectureComponent) {
		this.configurationComponent.getSubComponents().add(architectureComponent);
		return this;
	}

}
