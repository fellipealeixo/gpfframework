package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;

public class ArchitectureFragmentBuilder {
	
	private ArchitectureFragment architectureFragment;
	
	private ArchitectureFragmentBuilder() {
		this.architectureFragment = ArchitecturePackage.eINSTANCE.getArchitectureFactory().createArchitectureFragment();
	}
	
	public ArchitectureFragment build() {
		return this.architectureFragment;
	}
	
	public static ArchitectureFragmentBuilder implementationFragment() {
		return new ArchitectureFragmentBuilder();
	}
	
	public ArchitectureFragmentBuilder name(String name) {
		this.architectureFragment.setName(name);
		return this;
	}
	
	public ArchitectureFragmentBuilder content(String content) {
		this.architectureFragment.setContent(content);
		return this;
	}
	
	public ArchitectureFragmentBuilder path(String path) {
		this.architectureFragment.setPath(path);
		return this;
	}

}
