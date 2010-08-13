package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureComponentBuilder {
	
	private ArchitectureComponent architectureComponent;
	
	private ArchitectureComponentBuilder() {
		this.architectureComponent = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureComponent();
	}
	
	public ArchitectureComponent build() {
		return this.architectureComponent;
	}
	
	public static ArchitectureComponentBuilder architectureComponent() {
		return new ArchitectureComponentBuilder();
	}
	
	public ArchitectureComponentBuilder name(String name) {
		this.architectureComponent.setName(name);
		return this;
	}
	
	public ArchitectureComponentBuilder path(String path) {
		this.architectureComponent.setPath(path);
		return this;
	}
	
	public ArchitectureComponentBuilder addClass(ArchitectureClass architectureClass) {
		this.architectureComponent.getClasses().add(architectureClass);
		return this;
	}
	
	public ArchitectureComponentBuilder addAspect(ArchitectureAspect architectureAspect) {
		this.architectureComponent.getAspects().add(architectureAspect);
		return this;
	}
	
	public ArchitectureComponentBuilder addFile(ArchitectureFile architectureFile) {
		this.architectureComponent.getFiles().add(architectureFile);
		return this;
	}
	
	public ArchitectureComponentBuilder addTemplate(ArchitectureTemplate architectureTemplate) {
		this.architectureComponent.getTemplates().add(architectureTemplate);
		return this;
	}
	
	public ArchitectureComponentBuilder addSubComponents(ArchitectureComponent architectureComponent) {
		this.architectureComponent.getSubComponents().add(architectureComponent);
		return this;
	}

}
