package br.pucrio.inf.les.genarch.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.models.dsl.ConfigurationModelUtil;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.util.AspecJResourceUtil;
import br.pucrio.inf.les.genarch.core.util.ClassResourceUtil;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;

public class ConfigureElementWizard extends Wizard implements INewWizard {

	private ConfigureElementWizardPage page;
	private IProject project;
	private ArchitectureEntity element = null;
	private ArchitectureFragment fragment = null;
	private MappingRelationships mappingRelationships;
	private Architecture architecture;

	public ConfigureElementWizard(IProject project, EObject element) {
		super();
		this.setNeedsProgressMonitor(true);
		this.project = project;

		if ( element instanceof ArchitectureEntity ) {
			this.element = (ArchitectureEntity)element;
		}
	}

	@Override
	public void addPages() {
		this.page = new ConfigureElementWizardPage(project,element);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {

		final String featureExpression = this.page.getFeatureExpression();

		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(monitor,featureExpression);
				} catch (CoreException e) {
					GenarchEMFPlugin.INSTANCE.log(e);
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};

		try {
			this.getContainer().run(true, false, op);
		} catch (final InterruptedException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
			return false;
		} catch (final InvocationTargetException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(this.getShell(), "Error", realException.getMessage());
			return false;
		}

		return true;
	}

	private void doFinish(IProgressMonitor monitor,String featureExpression) throws CoreException {
		monitor.beginTask("Configuring element", 1);

		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(this.project);

		String architectureModelPath = genarchProjectConfigurationFile.getArchitectureModelPath();
		String configurationModelPath = genarchProjectConfigurationFile.getConfigurationModelPath();

		ArchitecturePackageImpl.init();	

		IFile architectureModelFile = this.project.getFile(architectureModelPath);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());

		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);

		architecture = (Architecture)architectureResource.getContents().get(0);

		ConfigurationModelUtil configurationModelUtil = new ConfigurationModelUtil(this.project);
		ConfigurationFactory configurationFactory = ConfigurationPackage.eINSTANCE.getConfigurationFactory();

		if ( element != null ) {
			String elementPath = element.getPath();

			MappingEntity configurationElement = configurationModelUtil.mappingElement(elementPath);  

			if ( configurationElement != null) {				
				MappingEntity entity = (MappingEntity)configurationElement;
				if ( entity.getFeatureExpression() != null ) {
					entity.getFeatureExpression().setExpression(featureExpression);
				} else {
					FeatureExpression feature = configurationFactory.createFeatureExpression();
					feature.setExpression(featureExpression);
					entity.setFeatureExpression(feature);
				}	    
			} else {
				MappingEntity entity;

				if ( element instanceof ArchitectureClass ) {
					entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationClass();		
				} else if ( element instanceof ArchitectureAspect ) {
					entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationAspect();
				} else if ( element instanceof ArchitectureTemplate ) {
					entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationTemplate();
				} else if ( element instanceof ArchitectureFile ) {
					entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationFile();
				} else if ( element instanceof ArchitectureFolder ) {
					entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationFolder();
				} else if ( element instanceof ArchitectureFragment ) {
						entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationFragment();
				} else {
					entity = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationComponent();
				}
				
				entity.setName(element.getName());
				entity.setPath(element.getPath());

				FeatureExpression feature = configurationFactory.createFeatureExpression();
				feature.setExpression(featureExpression);
				entity.setFeatureExpression(feature);

				configurationModelUtil.addMappingElement(entity);
			}

			IFile resource = project.getFile(element.getPath());

			if ( resource == null ) return;

			if ( "java".equals(resource.getFileExtension()) || "aj".equals(resource.getFileExtension())) {
				try {
					//Create annotation in the source code of the mapping element.
					if ( "java".equals(resource.getFileExtension()) ) {
						ClassResourceUtil.configureClassElement(resource, featureExpression);
					} else if ( "aj".equals(resource.getFileExtension()) ) {
						AspecJResourceUtil.configureAspectElement(resource, featureExpression);
					}
				} catch (Exception e) {
					GenarchEMFPlugin.INSTANCE.log(e);
					e.printStackTrace();
				}
			}
		}
		
		configurationModelUtil.saveModel();
		monitor.worked(1);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) { }
}