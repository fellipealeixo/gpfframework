package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;

public class ArchitectureResourcesContainerBuilder {
	
	private ArchitectureResourcesContainer architectureResourcesContainer;
	
	private ArchitectureResourcesContainerBuilder() {
		this.architectureResourcesContainer = ArchitectureFactory.eINSTANCE.createArchitectureResourcesContainer();
	}
	
	public static ArchitectureResourcesContainerBuilder architectureResourcesContainer() {
		return new ArchitectureResourcesContainerBuilder();
	}
	
	public ArchitectureResourcesContainer build() {
		return architectureResourcesContainer;
	}
	
	public ArchitectureResourcesContainerBuilder name(String name) {
		this.architectureResourcesContainer.setName(name);
		return this;
	}
	
	public ArchitectureResourcesContainerBuilder addFolder(ArchitectureFolder architectureFolder) {
		this.architectureResourcesContainer.getFolders().add(architectureFolder);
		return this;
	}
	
	public ArchitectureResourcesContainerBuilder addFile(ArchitectureFile architectureFile) {
		this.architectureResourcesContainer.getFiles().add(architectureFile);
		return this;
	}

}
