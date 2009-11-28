package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureTemplateBuilder {
	
	private ArchitectureTemplate architectureTemplate;
	
	private ArchitectureTemplateBuilder() {
		this.architectureTemplate = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureTemplate();
	}
	
	public static ArchitectureTemplateBuilder create() {
		return new ArchitectureTemplateBuilder();
	}
	
	public ArchitectureTemplate build() {
		return this.architectureTemplate;
	}
	
	public ArchitectureTemplateBuilder name(String name) {
		this.architectureTemplate.setName(name);
		return this;
	}
	
	public ArchitectureTemplateBuilder path(String path) {
		this.architectureTemplate.setPath(path);
		return this;
	}
	
	public ArchitectureTemplateBuilder generationPath(String generationPath) {
		this.architectureTemplate.setGenerationPath(generationPath);
		return this;
	}

}
