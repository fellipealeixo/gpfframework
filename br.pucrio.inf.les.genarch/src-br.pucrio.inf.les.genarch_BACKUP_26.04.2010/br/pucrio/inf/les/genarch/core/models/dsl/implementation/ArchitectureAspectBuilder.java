package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class ArchitectureAspectBuilder {
		
	private ArchitectureAspect architectureAspect;
	
	private ArchitectureAspectBuilder() {
		architectureAspect = ArchitecturePackageImpl.eINSTANCE.getArchitectureFactory().createArchitectureAspect();
	}
	
	public ArchitectureAspect build() {
		return architectureAspect;
	}
	
	public static ArchitectureAspectBuilder architectureAspect() {
		return new ArchitectureAspectBuilder();
	}
	
	public ArchitectureAspectBuilder name(String name) {
		architectureAspect.setName(name);
		return this;
	}
	
	public ArchitectureAspectBuilder path(String path) {
		architectureAspect.setPath(path);
		return this;
	}	
}
