package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;

public class ArchitectureFragmentContainerBuilder {
	
	private ArchitectureFragmentContainer architectureFragmentContainer;
	
	private ArchitectureFragmentContainerBuilder() {
		this.architectureFragmentContainer = ArchitecturePackage.eINSTANCE.getArchitectureFactory().createArchitectureFragmentContainer();
	}
	
	public static ArchitectureFragmentContainerBuilder implementationFragmentContainer() {
		return new ArchitectureFragmentContainerBuilder();
	}
	
	public ArchitectureFragmentContainer build() {
		return architectureFragmentContainer;
	}
	
	public ArchitectureFragmentContainerBuilder name(String name) {
		this.architectureFragmentContainer.setName(name);
		return this;
	}
	
	public ArchitectureFragmentContainerBuilder addFragment(ArchitectureFragment fragment) {
		this.architectureFragmentContainer.getFragments().add(fragment);
		return this;
	}
}
