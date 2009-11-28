package br.pucrio.inf.les.genarch.core.operations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.templates.GenerateXPandTemplates;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.FeatureElements;
import br.pucrio.inf.les.genarch.models.instance.FeatureInstance;
import br.pucrio.inf.les.genarch.models.instance.Instance;
import br.pucrio.inf.les.genarch.models.instance.InstanceFactory;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;
import br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class DerivateAsBuildFileOperation {
	private IProject project;
	private IProgressMonitor monitor;
	private int featureModelInstance;
	private String featureModelConfigurationName;

	private InstanceFactory instanceFactory = InstancePackage.eINSTANCE.getInstanceFactory();	
	private MappingRelationships mappingRelationships;

	private List<DerivationInstance> derivationInstances = new ArrayList<DerivationInstance>();
	private List<ArchitectureTemplate> architectureTemplates = new ArrayList<ArchitectureTemplate>();

	private String buildFilesFolderPath;

	public DerivateAsBuildFileOperation(IProject project,String buildFilesFolderPath,IProgressMonitor monitor) {		
		this.project = project;
		this.monitor = monitor;
		this.featureModelConfigurationName = featureModelConfigurationName;
		this.featureModelInstance = featureModelInstance;
		this.buildFilesFolderPath = buildFilesFolderPath;
	}

	public void derivate() {
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		String architectureModelFileName = genarchProjectConfigurationFile.getArchitectureModelPath();
		String configurationModelFileName = genarchProjectConfigurationFile.getConfigurationModelPath();
		String featureModelFileName = genarchProjectConfigurationFile.getFeatureModelPath();

		IFile architectureModelFile = project.getFile(architectureModelFileName);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());

		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);

		Architecture architecture = (Architecture)architectureResource.getContents().get(0);

		IFile configurationModelFile = project.getFile(configurationModelFileName);
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString());

		ResourceSet configurationResourceSet = new ResourceSetImpl();
		Resource configurationResource = configurationResourceSet.getResource(configurationFileURI, true);

		Configuration configuration = (Configuration)configurationResource.getContents().get(0);
		this.mappingRelationships = configuration.getMappingRelationships();

		IFile fmpModelFile = project.getFile(featureModelFileName);

		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);					
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();

		InstancePackageImpl.init();
		Instance instance = instanceFactory.createInstance();

		readFeatureModelConfigurations(fmpProject);

		for ( DerivationInstance derivationInstance : derivationInstances ) {
			br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration = derivationInstance.getFeatureConfiguration();

			instance.setFeatureInstance(derivationInstance.getFeatureInstance());

			ArchitectureInstance architectureInstance = instanceFactory.createArchitectureInstance();

			instance.setArchitecture(architectureInstance);		

			architectureTemplates.clear();

			EList containers = architecture.getContainers();

			for ( int y = 0; y < containers.size(); y++ ) {
				ArchitectureContainer container = (ArchitectureContainer)containers.get(y);
				EList components = container.getComponents();

				for (int x = 0; x < components.size(); x++) {
					ArchitectureComponent component = (ArchitectureComponent)components.get(x);	    
					ConfigurationComponent configurationComponent = (ConfigurationComponent)this.findConfigurationElementByPath(component.getPath());

					if ( configurationComponent != null ) {
						boolean status = this.evalFeatureConfiguration(configurationComponent,featureConfiguration);
						if (status) {
							createComponent(component,architectureInstance,featureConfiguration);   
						}
					} else {
						createComponent(component,architectureInstance,featureConfiguration);
					}		
				}
			}

			EList resourcesContainers = architecture.getResourcesContainer();

			for ( int y = 0; y < resourcesContainers.size(); y++ ) {
				ArchitectureResourcesContainer container = (ArchitectureResourcesContainer)resourcesContainers.get(y);
				EList folders = container.getFolders();

				for (int x = 0; x < folders.size(); x++) {
					ArchitectureFolder folder = (ArchitectureFolder)folders.get(x);	    
					ConfigurationFolder configurationFolder = (ConfigurationFolder)this.findConfigurationElementByPath(folder.getPath());

					if ( configurationFolder != null ) {
						boolean status = this.evalFeatureConfiguration(configurationFolder,featureConfiguration);
						if (status) {
							createFolder(folder,architectureInstance,featureConfiguration);
						}
					} else {
						createFolder(folder,architectureInstance,featureConfiguration);
					}		
				}

				EList templates = container.getTemplates();

				for ( int templatesCount = 0; templatesCount < templates.size(); templatesCount++ ) {
					ArchitectureTemplate template = (ArchitectureTemplate)templates.get(templatesCount);
					ConfigurationTemplate configurationTemplate = (ConfigurationTemplate)this.findConfigurationElementByPath(template.getPath());

					if ( configurationTemplate != null ) {
						boolean status = this.evalFeatureConfiguration(configurationTemplate,featureConfiguration);
						if ( status ) {				
							architectureTemplates.add(template);
						}
					} else {
						architectureTemplates.add(template);
					}
				}

				EList files = container.getFiles();

				for ( int filesCount = 0; filesCount < files.size(); filesCount++ ) {
					ArchitectureFile file = (ArchitectureFile)files.get(filesCount);
					ConfigurationFile configurationFile = (ConfigurationFile)this.findConfigurationElementByPath(file.getPath());

					if ( configurationFile != null ) {
						boolean status = this.evalFeatureConfiguration(configurationFile,featureConfiguration);
						if (status) {
							br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
							fileInstanceTwo.setName(file.getName());
							fileInstanceTwo.setPath(file.getPath());

							architectureInstance.getFiles().add(fileInstanceTwo);
						}
					} else {
						br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
						fileInstanceTwo.setName(file.getName());
						fileInstanceTwo.setPath(file.getPath());

						architectureInstance.getFiles().add(fileInstanceTwo);
					}
				}
			}

			EList fragmentContainer = architecture.getFragmentsContainer();

			for ( int y = 0; y < fragmentContainer.size(); y++ ) {

				EList fragments = ((ArchitectureFragmentContainer)fragmentContainer.get(y)).getFragments();

				br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer fragmentContainerOne = instanceFactory.createArchitectureFragmentContainer();
				fragmentContainerOne.setName(((ArchitectureFragmentContainer)fragmentContainer.get(y)).getName());

				for ( int fragmentCount = 0; fragmentCount < fragments.size(); fragmentCount++ ) {
					ArchitectureFragment fragment = (ArchitectureFragment)fragments.get(fragmentCount);
					ConfigurationFragment configurationFragment = this.findFragmentByName(fragment.getName());

					if ( configurationFragment != null ) {
						boolean status = this.evalFeatureConfiguration(configurationFragment,featureConfiguration);
						if (status) {
							br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceTwo = instanceFactory.createArchitectureFragment();
							fragmentInstanceTwo.setName(fragment.getName());
							fragmentInstanceTwo.setContent(fragment.getContent());

							br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceThree = instanceFactory.createArchitectureFragment();
							fragmentInstanceThree.setName(fragment.getName());
							fragmentInstanceThree.setContent(fragment.getContent());

							architectureInstance.getFragments().add(fragmentInstanceTwo);
							fragmentContainerOne.getFragments().add(fragmentInstanceThree);
						}
					} else {
						br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceTwo = instanceFactory.createArchitectureFragment();
						fragmentInstanceTwo.setName(fragment.getName());
						fragmentInstanceTwo.setContent(fragment.getContent());

						br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceThree = instanceFactory.createArchitectureFragment();
						fragmentInstanceThree.setName(fragment.getName());
						fragmentInstanceThree.setContent(fragment.getContent());

						architectureInstance.getFragments().add(fragmentInstanceTwo);
						fragmentContainerOne.getFragments().add(fragmentInstanceThree);
					}

					architectureInstance.getFragmentContainers().add(fragmentContainerOne);
				}
			}

			for ( ArchitectureTemplate template : architectureTemplates ) {
				processTemplate(template,instance);
			}
			
			IFolder subComponentFolder = this.project.getFolder(new Path(buildFilesFolderPath + "/" + derivationInstance.getFeatureConfiguration().getName()));

			if ( !subComponentFolder.exists() ) {
				try {
					subComponentFolder.create(false, true, null);
				} catch (CoreException e) {
					e.printStackTrace();
					GenarchEMFPlugin.INSTANCE.log(e);
				}
			}

			for ( String buildFile : genarchProjectConfigurationFile.getBuildFiles() ) {
				IPath buildFilePath = new Path(buildFile);
				ArchitectureTemplate architectureTemplate = ArchitecturePackage.eINSTANCE.getArchitectureFactory().createArchitectureTemplate();
				architectureTemplate.setName(buildFilePath.lastSegment());
				architectureTemplate.setPath(buildFile);
				architectureTemplate.setGenerationPath(buildFilesFolderPath + "/" + derivationInstance.getFeatureConfiguration().getName());

				processTemplate(architectureTemplate,instance);
			}
		}
	}

	private void readFeatureModelConfigurations(Project fmpProject) {
		Feature model = fmpProject.getModel();

		EList modelChildren = model.getChildren();

		for ( int x = 0; x < modelChildren.size(); x++ ) {
			Feature modelChild = (Feature)modelChildren.get(x);
			EList modelChildConfs = modelChild.getConfs();

			for ( int y = 0; y < modelChildConfs.size(); y++ ) {
				Feature childConf = (Feature)modelChildConfs.get(y);

				DerivationInstance derivationInstance = new DerivationInstance();				
				FeatureInstance featureInstance = instanceFactory.createFeatureInstance();	

				featureInstance.setName(childConf.getName());
				
				if ( childConf.getTypedValue() != null ) {
					featureInstance.setAttribute(childConf.getTypedValue().getStringValue());
				}
				
				for ( Object child : childConf.getChildren() ) {
					Feature fmpFeature = (Feature)child;

					boolean checked = false;

					if ( fmpFeature.isOptional() ) {			
						if ( (fmpFeature.getState().getValue() == 1) || (fmpFeature.getState().getValue() == 3) ) {
							checked = true;				
						}
					} else {
						checked = checkParent(fmpFeature);
					}

					if ( checked ) {
						//featureInstance.getFeatures().add(toFeature((Feature)child));
					}														
				}

				derivationInstance.setFeatureInstance(featureInstance);

				br.pucrio.inf.les.genarch.models.instance.Feature rootFeatureInstance = toFeature(childConf);							
				derivationInstance.setFeatureConfiguration(rootFeatureInstance);

				this.derivationInstances.add(derivationInstance);	
			}
		}
	}

	private br.pucrio.inf.les.genarch.models.instance.Feature toFeature(Feature fmpFeature) {
		String name = fmpFeature.getName();
		String value = "";

		if ( fmpFeature.getTypedValue() != null ) {
			value = fmpFeature.getTypedValue().getValueToString();
		}

		int max = fmpFeature.getMax();
		int min = fmpFeature.getMin();

		br.pucrio.inf.les.genarch.models.instance.Feature newFeature = br.pucrio.inf.les.genarch.models.instance.InstanceFactory.eINSTANCE.createFeature();
		newFeature.setName(name);
		newFeature.setAttribute(value);
		newFeature.setMax(max);
		newFeature.setMin(min);
		newFeature.setIsSelected(true);

		for ( Object child : fmpFeature.getChildren() ) {
			if ( child instanceof FeatureGroup ) {
				FeatureGroup group = (FeatureGroup)child;				
				for ( Object childGroup : group.getChildren() ) {
					this.toFeatureChild((Feature)childGroup,newFeature);
				}
			} else {
				this.toFeatureChild((Feature)child,newFeature);
			}			
		}

		return newFeature;		
	}

	private void toFeatureChild(Feature fmpFeature,br.pucrio.inf.les.genarch.models.instance.Feature parentFeature) {
		boolean optional = false;

		if ( fmpFeature.isOptional() ) {			
			if ( (fmpFeature.getState().getValue() == 1) || (fmpFeature.getState().getValue() == 3) ) {
				optional = true;				
			}
		} else {
			optional = checkParent(fmpFeature);
		}

		if ( optional ) {
			String name = fmpFeature.getName();
			String value = "";

			if ( fmpFeature.getTypedValue() != null ) {
				value = fmpFeature.getTypedValue().getValueToString();
			}

			int max = fmpFeature.getMax();
			int min = fmpFeature.getMin();

			br.pucrio.inf.les.genarch.models.instance.Feature newFeature = br.pucrio.inf.les.genarch.models.instance.InstanceFactory.eINSTANCE.createFeature();
			newFeature.setName(name);
			newFeature.setAttribute(value);
			newFeature.setMax(max);
			newFeature.setMin(min);
			newFeature.setIsSelected(optional); 

			for ( Object child : fmpFeature.getChildren() ) {
				if ( child instanceof FeatureGroup ) {
					FeatureGroup group = (FeatureGroup)child;				
					for ( Object childGroup : group.getChildren() ) {
						this.toFeatureChild((Feature)childGroup,newFeature);
					}
				} else {
					this.toFeatureChild((Feature)child,newFeature);
				}			
			}

			parentFeature.getFeatures().add(newFeature);
		}				
	}

	private boolean checkParent(Feature fmpFeature) {
		Object parent = fmpFeature.eContainer();

		if ( parent != null ) {
			Feature fmpParent = null;

			if ( parent instanceof Feature ) {
				fmpParent = (Feature)parent;
			} else if ( parent instanceof FeatureGroup ) {
				fmpParent = ((Feature)((FeatureGroup)parent).eContainer());
			}

			if ( fmpParent != null ) {
				if ( fmpParent.isOptional() ) {
					if ( (fmpParent.getState().getValue() == 1) || (fmpParent.getState().getValue() == 3) ) {
						return true;
					} else {
						return false;
					}
				} else {
					return checkParent(fmpParent);
				}
			}

			return true;
		} else {
			return true;
		}
	}

	private br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder createFolder(ArchitectureFolder folder,ArchitectureInstance architectureInstance,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {

		br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder folderInstance = instanceFactory.createArchitectureFolder();
		folderInstance.setName(folder.getName());
		folderInstance.setPath(folder.getPath());

		EList templates = folder.getTemplates();

		for ( int templatesCount = 0; templatesCount < templates.size(); templatesCount++ ) {
			ArchitectureTemplate template = (ArchitectureTemplate)templates.get(templatesCount);
			ConfigurationTemplate configurationTemplate = (ConfigurationTemplate)this.findConfigurationElementByPath(template.getPath());

			if ( configurationTemplate != null ) {
				boolean status = this.evalFeatureConfiguration(configurationTemplate,featureConfiguration);
				if ( status ) {				
					architectureTemplates.add(template);
				}
			} else {
				architectureTemplates.add(template);
			}
		}

		EList files = folder.getFiles();

		for ( int filesCount = 0; filesCount < files.size(); filesCount++ ) {
			ArchitectureFile file = (ArchitectureFile)files.get(filesCount);
			ConfigurationFile configurationFile = (ConfigurationFile)this.findConfigurationElementByPath(file.getPath());

			if ( configurationFile != null ) {
				boolean status = this.evalFeatureConfiguration(configurationFile,featureConfiguration);
				if (status) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
					fileInstanceOne.setName(file.getName());
					fileInstanceOne.setPath(file.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
					fileInstanceTwo.setName(file.getName());
					fileInstanceTwo.setPath(file.getPath());

					folderInstance.getFiles().add(fileInstanceOne);
					architectureInstance.getFiles().add(fileInstanceTwo);
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
				fileInstanceOne.setName(file.getName());
				fileInstanceOne.setPath(file.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
				fileInstanceTwo.setName(file.getName());
				fileInstanceTwo.setPath(file.getPath());

				folderInstance.getFiles().add(fileInstanceOne);
				architectureInstance.getFiles().add(fileInstanceTwo);
			}
		}

		EList subFolders = folder.getSubFolders();

		for ( int subFoldersCount = 0; subFoldersCount < subFolders.size(); subFoldersCount++ ) {
			ArchitectureFolder subFolder = (ArchitectureFolder)subFolders.get(subFoldersCount);
			ConfigurationFolder configurationSubFolder = (ConfigurationFolder)this.findConfigurationElementByPath(subFolder.getPath());

			if ( configurationSubFolder != null ) {
				boolean status = this.evalFeatureConfiguration(configurationSubFolder,featureConfiguration);
				if ( status ) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder subFolderInstance = createFolder(subFolder,architectureInstance,featureConfiguration);
					if ( subFolderInstance.eAllContents().hasNext() ) {
						architectureInstance.getFolders().add(subFolderInstance);
						folderInstance.getSubFolders().add(subFolderInstance);
					}
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder subFolderInstance = createFolder(subFolder,architectureInstance,featureConfiguration);
				if ( subFolderInstance.eAllContents().hasNext() ) {
					architectureInstance.getFolders().add(subFolderInstance);
					folderInstance.getSubFolders().add(subFolderInstance);
				}
			}
		}

		if ( folderInstance.eAllContents().hasNext() ) {
			architectureInstance.getFolders().add(folderInstance);
		}

		return folderInstance;
	}

	private br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent createComponent(ArchitectureComponent component,ArchitectureInstance architectureInstance,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {		
		br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent componentInstance = instanceFactory.createArchitectureComponent();
		componentInstance.setName(component.getName());
		componentInstance.setPath(component.getPath());

		EList classes = component.getClasses();

		for ( int classesCount = 0; classesCount < classes.size(); classesCount++ ) {
			ArchitectureClass clazz = (ArchitectureClass)classes.get(classesCount);
			ConfigurationClass configurationClass = (ConfigurationClass)this.findConfigurationElementByPath(clazz.getPath());

			if ( configurationClass != null ) {
				boolean status = this.evalFeatureConfiguration(configurationClass,featureConfiguration);
				if (status) {					
					br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceOne = instanceFactory.createArchitectureClass();
					classInstanceOne.setName(clazz.getName());
					classInstanceOne.setPath(clazz.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceTwo = instanceFactory.createArchitectureClass();
					classInstanceTwo.setName(clazz.getName());
					classInstanceTwo.setPath(clazz.getPath());

					componentInstance.getClasses().add(classInstanceOne);
					architectureInstance.getClasses().add(classInstanceTwo);
				}		
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceOne = instanceFactory.createArchitectureClass();
				classInstanceOne.setName(clazz.getName());
				classInstanceOne.setPath(clazz.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceTwo = instanceFactory.createArchitectureClass();
				classInstanceTwo.setName(clazz.getName());
				classInstanceTwo.setPath(clazz.getPath());

				componentInstance.getClasses().add(classInstanceOne);
				architectureInstance.getClasses().add(classInstanceTwo);
			}
		}

		EList aspects = component.getAspects();

		for ( int aspectsCount = 0; aspectsCount < aspects.size(); aspectsCount++ ) {
			ArchitectureAspect aspect = (ArchitectureAspect)aspects.get(aspectsCount);
			ConfigurationAspect configurationAspect = (ConfigurationAspect)findConfigurationElementByPath(aspect.getPath());

			if ( configurationAspect != null ) {
				boolean status = this.evalFeatureConfiguration(configurationAspect,featureConfiguration);
				if (status) {					
					br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceOne = instanceFactory.createArchitectureAspect();
					aspectInstanceOne.setName(aspect.getName());
					aspectInstanceOne.setPath(aspect.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceTwo = instanceFactory.createArchitectureAspect();
					aspectInstanceTwo.setName(aspect.getName());
					aspectInstanceTwo.setPath(aspect.getPath());

					architectureInstance.getAspects().add(aspectInstanceOne);
					componentInstance.getAspects().add(aspectInstanceTwo);
				}							
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceOne = instanceFactory.createArchitectureAspect();
				aspectInstanceOne.setName(aspect.getName());
				aspectInstanceOne.setPath(aspect.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceTwo = instanceFactory.createArchitectureAspect();
				aspectInstanceTwo.setName(aspect.getName());
				aspectInstanceTwo.setPath(aspect.getPath());

				architectureInstance.getAspects().add(aspectInstanceOne);
				componentInstance.getAspects().add(aspectInstanceTwo);
			}
		}

		EList templates = component.getTemplates();

		for ( int templatesCount = 0; templatesCount < templates.size(); templatesCount++ ) {
			ArchitectureTemplate template = (ArchitectureTemplate)templates.get(templatesCount);
			ConfigurationTemplate configurationTemplate = (ConfigurationTemplate)this.findConfigurationElementByPath(template.getPath());

			if ( configurationTemplate != null ) {
				boolean status = this.evalFeatureConfiguration(configurationTemplate,featureConfiguration);
				if ( status ) {				
					architectureTemplates.add(template);
				}
			} else {
				architectureTemplates.add(template);
			}
		}

		EList files = component.getFiles();

		for ( int filesCount = 0; filesCount < files.size(); filesCount++ ) {
			ArchitectureFile file = (ArchitectureFile)files.get(filesCount);
			ConfigurationFile configurationFile = (ConfigurationFile)this.findConfigurationElementByPath(file.getPath());

			if ( configurationFile != null ) {
				boolean status = this.evalFeatureConfiguration(configurationFile,featureConfiguration);
				if (status) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
					fileInstanceOne.setName(file.getName());
					fileInstanceOne.setPath(file.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
					fileInstanceTwo.setName(file.getName());
					fileInstanceTwo.setPath(file.getPath());

					componentInstance.getFiles().add(fileInstanceOne);
					architectureInstance.getFiles().add(fileInstanceTwo);
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
				fileInstanceOne.setName(file.getName());
				fileInstanceOne.setPath(file.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
				fileInstanceTwo.setName(file.getName());
				fileInstanceTwo.setPath(file.getPath());

				componentInstance.getFiles().add(fileInstanceOne);
				architectureInstance.getFiles().add(fileInstanceTwo);
			}
		}

		EList subComponents = component.getSubComponents();

		for ( int subComponentCount = 0; subComponentCount < subComponents.size(); subComponentCount++ ) {
			ArchitectureComponent subComponent = (ArchitectureComponent)subComponents.get(subComponentCount);
			ConfigurationComponent configurationSubComponent = (ConfigurationComponent)this.findConfigurationElementByPath(subComponent.getPath());

			if ( configurationSubComponent != null ) {
				boolean status = this.evalFeatureConfiguration(configurationSubComponent,featureConfiguration);
				if ( status ) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent subComponentInstance = createComponent(subComponent,architectureInstance,featureConfiguration);
					if ( subComponentInstance.eAllContents().hasNext() ) {
						architectureInstance.getComponents().add(subComponentInstance);
						componentInstance.getSubComponents().add(subComponentInstance);
					}
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent subComponentInstance = createComponent(subComponent,architectureInstance,featureConfiguration);
				if ( subComponentInstance.eAllContents().hasNext() ) {
					architectureInstance.getComponents().add(subComponentInstance);
					componentInstance.getSubComponents().add(subComponentInstance);
				}
			}
		}

		if ( componentInstance.eAllContents().hasNext() ) {
			architectureInstance.getComponents().add(componentInstance);
		}

		return componentInstance;
	}

	private void processTemplate(ArchitectureTemplate template,Instance instance) {
		monitor.subTask("Processing Template \"" + template.getPath() + "\"");

		IPath filePath = new Path(template.getPath());
		IResource entityResource = this.project.getFile(filePath);

		IPath resourcePath = entityResource.getProjectRelativePath();

		IPath instantiationPath = project.getLocation().append(template.getGenerationPath());

		if ( filePath.getFileExtension().equals("xpt") ) {
			IPath templatePath = project.getFile(template.getPath()).getFullPath();

			String xPandPath = resourcePath.removeFirstSegments(1).removeFileExtension().toString().replace("/", "::") + "::Main";
			GenerateXPandTemplates.getInstance().generate(instantiationPath,templatePath,xPandPath,instance,InstancePackage.eINSTANCE);
		}

		monitor.worked(1);
	}

	private boolean evalFeatureConfiguration(MappingEntity entity,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
		if ( entity.getFeatureExpression() != null ) {
			return Logic.eval(entity.getFeatureExpression().getExpression(),featureConfiguration);
		} else {
			return true;
		}
	}

	private boolean evalFeatureConfiguration(ConfigurationFragment entity,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
		if ( entity.getFeatureExpression() != null ) {
			return Logic.eval(entity.getFeatureExpression().getExpression(),featureConfiguration);
		} else {
			return true;
		}
	}

	private EObject findConfigurationElementByPath(String path) {	
		TreeIterator configurationContents = mappingRelationships.eAllContents();

		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();
			if ( o instanceof MappingEntity ) {
				MappingEntity entity = (MappingEntity)o;

				if ( entity.getPath().equals(path) ) {
					return entity;
				}
			}
		}

		return null;
	}

	private ConfigurationFragment findFragmentByName(String name) {
		TreeIterator configurationContents = mappingRelationships.eAllContents();

		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();
			if ( o instanceof ConfigurationFragment ) {
				ConfigurationFragment fragment = (ConfigurationFragment)o;

				if ( fragment.getName().equals(name) ) {
					return fragment;
				}
			}
		}

		return null;
	}
	
	class DerivationInstance {
		
		private FeatureInstance featureInstance;
		private FeatureElements featureElements;
		private br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration;
		
		public FeatureInstance getFeatureInstance() {
			return featureInstance;
		}
		
		public void setFeatureInstance(FeatureInstance featureInstance) {
			this.featureInstance = featureInstance;
		}
		
		public FeatureElements getFeatureElements() {
			return featureElements;
		}
		
		public void setFeatureElements(FeatureElements featureElements) {
			this.featureElements = featureElements;
		}

		public br.pucrio.inf.les.genarch.models.instance.Feature getFeatureConfiguration() {
			return featureConfiguration;
		}

		public void setFeatureConfiguration(br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
			this.featureConfiguration = featureConfiguration;
		}
	}
}
