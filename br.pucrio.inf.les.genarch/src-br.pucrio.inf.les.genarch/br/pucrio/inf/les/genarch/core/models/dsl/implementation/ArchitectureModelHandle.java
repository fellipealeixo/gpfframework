package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;

public class ArchitectureModelHandle {

	private Architecture architecture;
	private Resource architectureResource;

	private ArchitectureModelAddElement architectureModelAddElement;
	private ArchitectureModelGetElement architectureModelGetElement;

	private ArchitectureModelHandle(URI architectureFileURI) {
		ResourceSet architectureResourceSet = new ResourceSetImpl();
		this.architectureResource = architectureResourceSet.getResource(architectureFileURI, true);
		this.architecture = (Architecture)architectureResource.getContents().get(0);

		this.architectureModelAddElement = new ArchitectureModelAddElement(this);
		this.architectureModelGetElement = new ArchitectureModelGetElement(this);
	}

	public static ArchitectureModelHandle architectureModel(IProject project) {
		GenarchProjectConfigurationFile configurationFile = GenarchProjectConfigurationFile.open(project);

		IFile architectureModelFile = project.getFile(configurationFile.getArchitectureModelPath());
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString(),false);

		return new ArchitectureModelHandle(architectureFileURI);
	}

	public ArchitectureContainerGetter<ArchitectureResourcesContainer> resourceContainer() {
		return new ArchitectureContainerGetter<ArchitectureResourcesContainer>(this.architecture);
	}

	public ArchitectureModelGetElement get() {
		return this.architectureModelGetElement;
	}

	public ArchitectureModelAddElement add() {
		return this.architectureModelAddElement;
	}

	public void save() {
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		try {
			architectureResource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}

	protected Architecture getArchitecture() {
		return this.architecture;
	}
}
