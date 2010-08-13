package br.pucrio.inf.les.genarch.core.project;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class GenarchProjectConfigurationFile {
		
	public static GenarchProjectConfigurationFile open(IProject project) {
		IFile configFile = project.getFile("genarch.gcf");
					
		try {
			XMLDecoder xmlDecoder = new XMLDecoder(configFile.getContents());
			GenarchProjectConfigurationFile genarchProjectConfigurationFile = (GenarchProjectConfigurationFile)xmlDecoder.readObject();
			genarchProjectConfigurationFile.setConfigurationFile(configFile);
			return genarchProjectConfigurationFile;
		} catch (CoreException e) {
			GenarchProjectConfigurationFile genarchProjectConfigurationFile = new GenarchProjectConfigurationFile();
			genarchProjectConfigurationFile.setConfigurationFile(configFile);
			return genarchProjectConfigurationFile;
		} catch (NoSuchElementException e) {
			GenarchProjectConfigurationFile genarchProjectConfigurationFile = new GenarchProjectConfigurationFile();
			genarchProjectConfigurationFile.setConfigurationFile(configFile);
			return genarchProjectConfigurationFile;
		}
	}
	
	public GenarchProjectConfigurationFile() {
		
	}
	
	private volatile IFile configurationFile;
	
	public void setConfigurationFile(IFile configurationFile) {
		this.configurationFile = configurationFile;
	}
	
	public void save(IProgressMonitor monitor) {
		monitor.beginTask("Saving Genarch Configuration File", 1);
		PipedOutputStream outStream = new PipedOutputStream();
		PipedInputStream inStream = new PipedInputStream();
		try {
			inStream.connect(outStream);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		XMLEncoder encoder = new XMLEncoder(outStream);
		encoder.writeObject(this);
		encoder.close();
		
		if ( configurationFile != null ) {
			try {
				if ( this.configurationFile.exists() ) {
					this.configurationFile.setContents(inStream, true, true, monitor);
				} else {					
					this.configurationFile.create(inStream, true, monitor);
				}
			} catch (CoreException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		}
		
		monitor.worked(1);
	}
	
	private String architectureModelPath;
	private String configurationModelPath;
	private String featureModelPath;
	private String classExtension = "java";
	private String interfaceExtension = "java";
	private String aspectExtension = "aj";
	private String templateExtension = "xpt";
	private List<String> sourceContainers = new ArrayList<String>();
	private List<String> resourceContainers = new ArrayList<String>();
	private List<String> buildFiles = new ArrayList<String>();
		
	public String getArchitectureModelPath() {
		return this.architectureModelPath;
	}

	public void setArchitectureModelPath(final String architectureModelFileName) {
		this.architectureModelPath = architectureModelFileName;
	}

	public String getConfigurationModelPath() {
		return this.configurationModelPath;
	}

	public void setConfigurationModelPath(final String configurationModelFileName) {
		this.configurationModelPath = configurationModelFileName;
	}

	public String getFeatureModelPath() {
		return this.featureModelPath;
	}

	public void setFeatureModelPath(final String featureModelFileName) {
		this.featureModelPath = featureModelFileName;
	}

	public String getAspectExtension() {
		return aspectExtension;
	}

	public void setAspectExtension(String aspectExtension) {
		this.aspectExtension = aspectExtension;
	}

	public String getClassExtension() {
		return classExtension;
	}

	public void setClassExtension(String classExtension) {
		this.classExtension = classExtension;
	}

	public String getInterfaceExtension() {
		return interfaceExtension;
	}

	public void setInterfaceExtension(String interfaceExtension) {
		this.interfaceExtension = interfaceExtension;
	}

	public String getTemplateExtension() {
		return templateExtension;
	}

	public void setTemplateExtension(String templateExtension) {
		this.templateExtension = templateExtension;
	}

	public List<String> getSourceContainers() {
		return sourceContainers;
	}

	public void setSourceContainers(List<String> container) {
		this.sourceContainers = container;
	}

	public List<String> getResourceContainers() {
		return resourceContainers;
	}

	public void setResourceContainers(List<String> resourceContainers) {
		this.resourceContainers = resourceContainers;
	}

	public List<String> getBuildFiles() {
		return buildFiles;
	}

	public void setBuildFiles(List<String> buildFiles) {
		this.buildFiles = buildFiles;
	}
}