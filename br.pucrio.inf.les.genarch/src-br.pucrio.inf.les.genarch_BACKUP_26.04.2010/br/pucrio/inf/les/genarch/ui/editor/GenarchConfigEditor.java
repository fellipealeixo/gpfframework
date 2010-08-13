package br.pucrio.inf.les.genarch.ui.editor;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;

public class GenarchConfigEditor extends FormEditor {

	private boolean bDirty = false;
	private GenarchConfigEditorPage page1;
	
	private GenarchProjectConfigurationFile configuration;

	@Override
	protected FormToolkit createToolkit(final Display display) {
		return new FormToolkit(new FormColors(display));
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);

		this.page1 = new GenarchConfigEditorPage(this,"GenarchConfigEditorPage1","Genarch Configuration Page");

		IAdaptable adaptable = this.getEditorInput();
		IResource resource = (IResource) adaptable.getAdapter(IResource.class);	

		this.configuration = GenarchProjectConfigurationFile.open(resource.getProject());
		
		if ( configuration != null ) {
			this.page1.setArchitectureModelFileName(configuration.getArchitectureModelPath());
			this.page1.setConfigurationModelFileName(configuration.getConfigurationModelPath());
			this.page1.setFeatureModelFileName(configuration.getFeatureModelPath());
			this.page1.setSourceContainers(configuration.getSourceContainers());
			this.page1.setResourceContainers(configuration.getResourceContainers());
			this.page1.setBuildersFiles(configuration.getBuildFiles());
		}		
	}

	@Override
	protected void addPages() {
		try {
			this.addPage(this.page1);
		} catch (PartInitException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		String architectureModelFileName = this.page1.getArchitectureModelFileName();
		String configurationModelFileName = this.page1.getConfigurationModelFileName();
		String featureModelFileName = this.page1.getFeatureModelFileName();
		List<String> sourceContainers = this.page1.getSourceContainers();
		List<String> resourceContainers = this.page1.getResourceContainers();
		List<String> buildFiles = this.page1.getBuildersFiles();
		
		IAdaptable adaptable = this.getEditorInput();
		IResource resource = (IResource)adaptable.getAdapter(IResource.class);
		
		if ( configuration == null ) {
			configuration = GenarchProjectConfigurationFile.open(resource.getProject());
		}

		configuration.setArchitectureModelPath(architectureModelFileName);
		configuration.setConfigurationModelPath(configurationModelFileName);
		configuration.setFeatureModelPath(featureModelFileName);
		configuration.setSourceContainers(sourceContainers);
		configuration.setResourceContainers(resourceContainers);
		configuration.setBuildFiles(buildFiles);
		
		configuration.save(monitor);

		this.editorDirtyStateChanged();				
	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean isDirty() {
		return this.bDirty;
	}


	@Override
	public void editorDirtyStateChanged() {
		this.bDirty = !this.bDirty;
		super.editorDirtyStateChanged();		
	}

}
