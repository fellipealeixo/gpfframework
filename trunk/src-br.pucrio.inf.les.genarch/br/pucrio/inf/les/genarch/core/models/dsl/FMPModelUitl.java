package br.pucrio.inf.les.genarch.core.models.dsl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import ca.uwaterloo.gp.fmp.ConfigState;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.ValueType;
import ca.uwaterloo.gp.fmp.provider.fmpEditPlugin;
import ca.uwaterloo.gp.fmp.system.MetaModel;
import ca.uwaterloo.gp.fmp.system.ModelManipulation;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.system.NodeIdDictionary;
import ca.uwaterloo.gp.fmp.system.RoleQuery;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class FMPModelUitl {

	private IPath featureModelPath;
	private IProject eclipseProject;
	private Project fmpProject;

	private List<FeatureItem> features;

	private ModelNavigation modelNavigation;

	private FmpExternalLoader externalLoader;
	private Resource fmpResource;

	public FMPModelUitl(IProject eclipseProject,IPath featureModelPath) {	
		this.featureModelPath = featureModelPath;
		this.eclipseProject = eclipseProject;
		init();
	}

	private void init() {
		modelNavigation = ModelNavigation.INSTANCE;

		IFile fmpModelFile = this.eclipseProject.getFile(featureModelPath);

		if ( fmpModelFile.exists() ) {
			externalLoader = new FmpExternalLoader();
			externalLoader.load(fmpModelFile);					
			EList resourceList = externalLoader.getResources();					
			FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
			fmpProject = (Project)fmpResource.getAllContents().next();	  
		}
	}

	public void create(FeatureModelContent featureModelContent,String fmpProjectName) {		
		IFile fmpModelFile = this.eclipseProject.getFile(featureModelPath);	

		if ( !fmpModelFile.exists() ) {
			ResourceSet resourceSet = new ResourceSetImpl();
			URI fileURI = URI.createPlatformResourceURI(fmpModelFile.getFullPath().toString());	    
			fmpResource = resourceSet.createResource(fileURI);

			this.features = featureModelContent.getFeatureItens();

			this.createModel(fmpModelFile,fmpResource,fmpProjectName);

			if ( fmpProject != null ) {			
				for ( FeatureItem featureItem : this.features ) {
					this.addFeature(featureItem,fmpProject);
				}
			}
		} else {
			update(featureModelContent);
		}
	}

	public void update(FeatureModelContent featureModelContent) {
		this.features = featureModelContent.getFeatureItens();

		if ( fmpProject != null ) {							
			for ( FeatureItem featureItem : this.features ) {
				Node feature = modelNavigation.findNodeWithName(fmpProject.getModel(), featureItem.getName());
				if ( feature == null ) {
					this.addFeature(featureItem,fmpProject);
				}
			}				
		}
		externalLoader.save(0);	
	}

	private void createModel(IFile fmpModelFile, Resource resource,String fmpProjectName) {
		try {
			fmpProject = MetaModel.makeProject();			
			if ( fmpProject != null) {				
				Feature model = fmpProject.getModel();
				String modelName = this.eclipseProject.getName() + " Feature Model";
				model.setName(modelName);
				model.setId(ModelManipulation.INSTANCE.getValidId(modelName));						

				Feature feature = MetaModel.createFeatureWithProperties(fmpProjectName,ModelManipulation.INSTANCE.getValidId(fmpProjectName), ConfigState.USER_SELECTED_LITERAL, ValueType.NONE_LITERAL,null, null, 0, 0, fmpProject.getMetaModel());
				model.getChildren().add(feature);
				configureFeature(feature,model,fmpProject.getMetaModel());		

				Feature metaModel = fmpProject.getMetaModel();
				Node nodeFeature = modelNavigation.findNodeWithName(metaModel, "Feature");
				Feature crosscuttingFeature = MetaModel.createFeatureWithProperties("Crosscutting", "crosscutting", ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, 0, 1, fmpProject.getMetaMetaModel());
				Feature joinpointFeature = MetaModel.createFeatureWithProperties("Joinpoint", "joinpoint", ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, 0, 1, fmpProject.getMetaMetaModel());
				nodeFeature.getChildren().add(crosscuttingFeature);
				nodeFeature.getChildren().add(joinpointFeature);

				resource.getContents().add(fmpProject);
			}	   
		}
		catch (Exception e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		}	
	}

	public void addFeature(FeatureItem featureItem) {
		addFeature(featureItem,fmpProject);
	}

	public void saveModel() {

		if ( fmpResource != null ) {
			Map options = new HashMap();
			options.put(XMLResource.OPTION_ENCODING, "ASCII");

			try {
				fmpResource.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if ( externalLoader != null ) {
			externalLoader.save(0);
		}
	}

	private Node addFeature(FeatureItem featureItem,Project fmpProject) {

		int max = 0;
		int min = 0;

		Node model = fmpProject.getModel();

		if ( (featureItem.getParent() == null) || featureItem.getParent().equals("") ) {
			Node feature = modelNavigation.findNodeWithName(model, featureItem.getName());

			if ( feature == null ) {

				Feature child = null;

				if ( featureItem.getType() == FeatureType.optional ) {
					max = 1;
					min = 0;
				} else if ( featureItem.getType() == FeatureType.mandatory ) {
					max = 1;
					min = 1;
				}

				Node parent = (Node)model.getChildren().get(0); 

				if ( featureItem.getType() == FeatureType.alternative ) {
					FeatureGroup childGroup = findFeatureGroup(parent);

					if ( childGroup == null ) {
						childGroup = MetaModel.createFeatureGroupWithProperties(parent.getId() + "Group", 1, 1, fmpProject.getMetaModel());
						parent.getChildren().add(childGroup);
						configureFeatureGroup(childGroup,model,fmpProject.getMetaModel());
					}

					child = MetaModel.createFeatureWithProperties(featureItem.getName(),ModelManipulation.INSTANCE.getValidId(featureItem.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, 0, 1, fmpProject.getMetaModel());
					childGroup.getChildren().add(child);
					configureFeature(child,childGroup,fmpProject.getMetaModel());		    		    		    		 
				} else {
					child = MetaModel.createFeatureWithProperties(featureItem.getName(),ModelManipulation.INSTANCE.getValidId(featureItem.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, min, max, fmpProject.getMetaModel());
					Node c = (Node)model.getChildren().get(0); 
					c.getChildren().add(child);
					configureFeature(child,model,fmpProject.getMetaModel());		    		    
				}

				Feature properties = child.getProperties();

				EList props = properties.getChildren();
				Feature crosscuttingProp = null;
				Feature joinpointProp = null;

				for ( int x = 0; x < props.size(); x++ ) {
					Object prop = props.get(x);

					if ( prop instanceof Feature ) {
						Feature featureProp = (Feature)prop;			    
						if ( "Crosscutting".equals(featureProp.getName()) ) {
							crosscuttingProp = featureProp;
						} else if ( "Joinpoint".equals(featureProp.getName()) ) {
							joinpointProp = featureProp;
						}
					}
				}

				return child;
			}

			return feature;
		} else {
			Node parent = modelNavigation.findNodeWithName(model,featureItem.getParent());

			if ( parent != null ) {						
				Node feature = modelNavigation.findNodeWithName(model, featureItem.getName());

				if ( feature == null ) {

					Feature child = null;

					if ( featureItem.getType() == FeatureType.optional ) {
						max = 1;
						min = 0;
					} else if ( featureItem.getType() == FeatureType.mandatory ) {
						max = 1;
						min = 1;
					}

					if ( featureItem.getType() == FeatureType.alternative ) {
						FeatureGroup childGroup = findFeatureGroup(parent);

						if ( childGroup == null ) {
							childGroup = MetaModel.createFeatureGroupWithProperties(parent.getId() + "Group", 1, 1, fmpProject.getMetaModel());
							parent.getChildren().add(childGroup);
							configureFeatureGroup(childGroup,parent,fmpProject.getMetaMetaModel());
						}

						child = MetaModel.createFeatureWithProperties(featureItem.getName(),ModelManipulation.INSTANCE.getValidId(featureItem.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, 0, 1, fmpProject.getMetaModel());
						childGroup.getChildren().add(child);
						configureFeature(child,childGroup,fmpProject.getMetaModel());			
					} else {			
						child = MetaModel.createFeatureWithProperties(featureItem.getName(),ModelManipulation.INSTANCE.getValidId(featureItem.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, min, max, fmpProject.getMetaModel());
						parent.getChildren().add(child);
						configureFeature(child,parent,fmpProject.getMetaModel());			
					}

					Feature properties = child.getProperties();

					EList props = properties.getChildren();
					Feature crosscuttingProp = null;
					Feature joinpointProp = null;

					for ( int x = 0; x < props.size(); x++ ) {
						Object prop = props.get(x);

						if ( prop instanceof Feature ) {
							Feature featureProp = (Feature)prop;			    
							if ( "Crosscutting".equals(featureProp.getName()) ) {
								crosscuttingProp = featureProp;
							} else if ( "Joinpoint".equals(featureProp.getName()) ) {
								joinpointProp = featureProp;
							}
						}
					}

					return child;
				}

				return feature;
			} else {										
				FeatureItem item = this.findFeaturesItem(featureItem.getParent());

				if ( item != null ) {											
					parent = this.addFeature(item,fmpProject);
				} else {
					//Como irei criar essa feature???
					parent = addDefaultFeature(featureItem.getParent(), model, fmpProject); 
				}

				Feature child = null;

				if ( featureItem.getType() == FeatureType.optional ) {
					max = 1;
					min = 0;
				} else if ( featureItem.getType() == FeatureType.mandatory ) {
					max = 1;
					min = 1;
				}

				if ( featureItem.getType() == FeatureType.alternative ) {
					FeatureGroup childGroup = findFeatureGroup(parent);

					if ( childGroup == null ) {
						childGroup = MetaModel.createFeatureGroupWithProperties(parent.getId() + "Group", 1, 1, fmpProject.getMetaModel());
						parent.getChildren().add(childGroup);		    
						configureFeatureGroup(childGroup,parent,fmpProject.getMetaModel());
					}

					child = MetaModel.createFeatureWithProperties(featureItem.getName(),ModelManipulation.INSTANCE.getValidId(featureItem.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, 0, 1, fmpProject.getMetaModel());
					childGroup.getChildren().add(child);
					configureFeature(child,childGroup,fmpProject.getMetaModel());		    		   
				} else {		    
					child = MetaModel.createFeatureWithProperties(featureItem.getName(),ModelManipulation.INSTANCE.getValidId(featureItem.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, min, max, fmpProject.getMetaModel());
					parent.getChildren().add(child);
					configureFeature(child,parent,fmpProject.getMetaModel());
				}

				Feature properties = child.getProperties();

				EList props = properties.getChildren();
				Feature crosscuttingProp = null;
				Feature joinpointProp = null;

				for ( int x = 0; x < props.size(); x++ ) {
					Object prop = props.get(x);

					if ( prop instanceof Feature ) {
						Feature featureProp = (Feature)prop;			    
						if ( "Crosscutting".equals(featureProp.getName()) ) {
							crosscuttingProp = featureProp;
						} else if ( "Joinpoint".equals(featureProp.getName()) ) {
							joinpointProp = featureProp;
						}
					}
				}

				return child;
			}
		}			
	}

	private Node addDefaultFeature(String name,Node parent,Project fmpProject) {
		int max = 1;
		int min = 1;

		Feature child = MetaModel.createFeatureWithProperties(name,ModelManipulation.INSTANCE.getValidId(name), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, min, max, fmpProject.getMetaModel());
		Node c = (Node)parent.getChildren().get(0);
		c.getChildren().add(child);
		configureFeature(child,parent,fmpProject.getMetaModel());

		return child;		
	}

	private FeatureItem findFeaturesItem(String name) {

		if ( features == null ) return null;

		for ( FeatureItem featuresItem : this.features ) {
			if ( featuresItem.getName().equals(name) ) {
				return featuresItem;
			}
		}

		return null;
	}

	private void configureFeature(Feature feature,Node owner, Feature metaModel) {
		Feature metaFeature;

		int i = 0;

		if (RoleQuery.INSTANCE.getLocationType((Node) owner) == RoleQuery.MODEL)
			metaFeature = (Feature) metaModel.getChildren().get(i);
		else if (RoleQuery.INSTANCE.getLocationType((Node) owner) == RoleQuery.METAMODEL)
			metaFeature = (Feature) metaModel.getChildren().get(i);
		else 
			metaFeature = null;

		if(metaFeature != null)
		{		
			NodeIdDictionary.INSTANCE.visit(feature.getProperties());
		}		
		NodeIdDictionary.INSTANCE.visit((Node)feature);

		if (feature instanceof Feature) {
			if (RoleQuery.INSTANCE.getNodeType((Node) feature) == RoleQuery.ROOT_FEATURE) {
				((Feature) feature).setMin(1);
				((Feature) feature).setMax(1);
			}
		}
	}

	private void configureFeatureGroup(FeatureGroup feature,Node owner, Feature metaModel) {
		Feature metaFeature;

		int i = 1;

		if (RoleQuery.INSTANCE.getLocationType((Node) owner) == RoleQuery.MODEL)
			metaFeature = (Feature) metaModel.getChildren().get(i);
		else if (RoleQuery.INSTANCE.getLocationType((Node) owner) == RoleQuery.METAMODEL)
			metaFeature = (Feature) metaModel.getChildren().get(i);
		else 
			metaFeature = null;

		if(metaFeature != null)
		{		
			NodeIdDictionary.INSTANCE.visit(feature.getProperties());
		}		
		NodeIdDictionary.INSTANCE.visit((Node)feature);

	}

	private FeatureGroup findFeatureGroup(Node parent) {
		EList children = parent.getChildren();

		for ( int x = 0; x < children.size(); x++ ) {
			Object child = children.get(x);

			if ( child instanceof FeatureGroup ) {
				return (FeatureGroup)child;
			}
		}

		return null;
	}

	public Project getFmpProject() {
		return fmpProject;
	}
}
