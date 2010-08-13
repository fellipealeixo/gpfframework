package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

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
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;

public class ConfigurationModelHandle {

	private Configuration configuration;
	private Resource configurationResource;
	
	private ConfigurationModelAddElement configurationModelAddElement;
	private ConfigurationModelGetElement configurationModelGetElement;

	private ConfigurationModelHandle(URI configurationFileURI) {
		ResourceSet configurationResourceSet = new ResourceSetImpl();
		this.configurationResource = configurationResourceSet.getResource(configurationFileURI, true);
		this.configuration = (Configuration)configurationResource.getContents().get(0);
		
		this.configurationModelAddElement = new ConfigurationModelAddElement(this);
		this.configurationModelGetElement = new ConfigurationModelGetElement(this);
	}

	public static ConfigurationModelHandle configurationModel(IProject project) {
		GenarchProjectConfigurationFile configurationFile = GenarchProjectConfigurationFile.open(project);

		IFile configurationModelFile = project.getFile(configurationFile.getConfigurationModelPath());
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString(),false);

		return new ConfigurationModelHandle(configurationFileURI);
	}
			
	public ConfigurationModelGetElement get() {
		return this.configurationModelGetElement;
	}
			
	public ConfigurationModelAddElement add() {
		return this.configurationModelAddElement;
	}
	
	public void save() {
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		try {
			configurationResource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}

	protected MappingRelationships getMappingRelationships() {
		return this.configuration.getMappingRelationships();
	}
}
