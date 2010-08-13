package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;

public class ArchitectureSourceContainerBuilder {
	
	private ArchitectureContainer architectureContainer;
	
	private ArchitectureSourceContainerBuilder() {
		this.architectureContainer = ArchitectureFactory.eINSTANCE.createArchitectureContainer();
	}
	
	public static ArchitectureSourceContainerBuilder architectureSourceContainer() {
		return new ArchitectureSourceContainerBuilder();
	}
	
	public ArchitectureContainer build() {
		return this.architectureContainer;
	}
	
	public ArchitectureSourceContainerBuilder name(String name) {
		this.architectureContainer.setName(name);
		return this;
	}
	
	public ArchitectureSourceContainerBuilder addComponent(ArchitectureComponent architectureComponent) {
		this.architectureContainer.getComponents().add(architectureComponent);
		return this;
	}

}
