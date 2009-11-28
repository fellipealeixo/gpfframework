package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureFolderBuilder {
	
	private ArchitectureFolder architectureFolder;
	
	private ArchitectureFolderBuilder() {
		this.architectureFolder = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureFolder();	
	}
	
	public static ArchitectureFolderBuilder architectureFolder() {
		return new ArchitectureFolderBuilder();		
	}
	
	public ArchitectureFolder build() {
		return architectureFolder;
	}
	
	public ArchitectureFolderBuilder name(String name) {
		this.architectureFolder.setName(name);
		return this;
	}
	
	public ArchitectureFolderBuilder path(String path) {
		this.architectureFolder.setPath(path);
		return this;
	}
	
	public ArchitectureFolderBuilder addFile(ArchitectureFile architectureFile) {
		this.architectureFolder.getFiles().add(architectureFile);
		return this;
	}
	
	public ArchitectureFolderBuilder addTemplate(ArchitectureTemplate architectureTemplate) {
		this.architectureFolder.getTemplates().add(architectureTemplate);
		return this;
	}
	
	public ArchitectureFolderBuilder addSubFolder(ArchitectureFolder architectureFolder) {
		this.architectureFolder.getSubFolders().add(architectureFolder);
		return this;
	}

}
