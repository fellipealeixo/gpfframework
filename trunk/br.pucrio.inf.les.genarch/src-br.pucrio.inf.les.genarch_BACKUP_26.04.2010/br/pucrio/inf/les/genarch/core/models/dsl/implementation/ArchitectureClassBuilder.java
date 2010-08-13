package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureClassBuilder {
	
	private final ArchitectureClass architectureClass;
		
	private ArchitectureClassBuilder() {
		architectureClass = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureClass();
	}
	
	public ArchitectureClass build() {
		return architectureClass;
	}
	
	public static ArchitectureClassBuilder architectureClass() {		
		return new ArchitectureClassBuilder();
	}
	
	public ArchitectureClassBuilder name(String name) {
		architectureClass.setName(name);
		return this;
	}
	
	public ArchitectureClassBuilder path (String path) {
		architectureClass.setPath(path);
		return this;
	}

}
