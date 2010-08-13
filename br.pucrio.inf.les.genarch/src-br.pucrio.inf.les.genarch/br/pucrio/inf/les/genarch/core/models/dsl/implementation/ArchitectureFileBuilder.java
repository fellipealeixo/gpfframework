package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureFileBuilder {
	
	private ArchitectureFile architectureFile;
	
	private ArchitectureFileBuilder() {
		this.architectureFile = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureFile();
	}
	
	public ArchitectureFile build() {
		return architectureFile;
	}
	
	public static ArchitectureFileBuilder create() {
		return new ArchitectureFileBuilder();
	}
	
	public ArchitectureFileBuilder name(String name) {
		this.architectureFile.setName(name);
		return this;
	}
	
	public ArchitectureFileBuilder path(String path) {
		this.architectureFile.setPath(path);
		return this;
	}

}
