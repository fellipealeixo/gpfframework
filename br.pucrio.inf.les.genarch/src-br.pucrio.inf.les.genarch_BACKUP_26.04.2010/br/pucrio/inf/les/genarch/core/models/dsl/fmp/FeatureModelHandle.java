package br.pucrio.inf.les.genarch.core.models.dsl.fmp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import ca.uwaterloo.gp.fmp.ConfigState;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.ValueType;
import ca.uwaterloo.gp.fmp.provider.fmpEditPlugin;
import ca.uwaterloo.gp.fmp.system.MetaModel;
import ca.uwaterloo.gp.fmp.system.ModelManipulation;
import ca.uwaterloo.gp.fmp.system.NodeIdDictionary;
import ca.uwaterloo.gp.fmp.system.RoleQuery;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class FeatureModelHandle {
	
	public static String DEFAULT_PATH = "models/FeatureModel.fmp";

	private IProject project;
	private Project fmpProject;

	private FeatureModelGetElement featureModelGetElement;
	private FeatureModelAddElement featureModelAddElement;	
	
	private FmpExternalLoader externalLoader;
	private Resource fmpResource;

	private FeatureModelHandle(IProject project) {
		this.project = project;	
				
		GenarchProjectConfigurationFile configurationFile = GenarchProjectConfigurationFile.open(project);
		IFile fmpModelFile = project.getFile(configurationFile.getFeatureModelPath());
		
		if ( fmpModelFile.exists() ) {
			this.externalLoader = new FmpExternalLoader();
			this.externalLoader.load(fmpModelFile);					
			EList resourceList = this.externalLoader.getResources();					
			FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
			this.fmpProject = (Project)fmpResource.getAllContents().next();	  
		}
		
		this.featureModelAddElement = new FeatureModelAddElement(this);
		this.featureModelGetElement = new FeatureModelGetElement(this);
		
	}
	
	public static FeatureModelHandle open(IProject project) {
		return new FeatureModelHandle(project);
	}
	
	public FeatureModelAddElement add() {
		return this.featureModelAddElement;
	}
	
	public FeatureModelGetElement get() {
		return this.featureModelGetElement;
	}

	public FeatureModelHandle create() {
		try {
			Project fmpProject = MetaModel.makeProject();			
			if ( fmpProject != null) {
				Feature model = fmpProject.getModel();
				String modelName =  this.project.getName() + " Feature Model";
				model.setName(modelName);
				model.setId(ModelManipulation.INSTANCE.getValidId(modelName));
								
				ca.uwaterloo.gp.fmp.Feature feature = MetaModel.createFeatureWithProperties(this.project.getName(),ModelManipulation.INSTANCE.getValidId(this.project.getName()), ConfigState.USER_SELECTED_LITERAL, ValueType.NONE_LITERAL,null, null, 0, 0, fmpProject.getMetaModel());
				model.getChildren().add(feature);
				configureFeature(feature,model,fmpProject.getMetaModel());		
				
				IFile fmpModelFile = project.getFile(DEFAULT_PATH);
				FmpExternalLoader externalLoader = new FmpExternalLoader();
				externalLoader.load(fmpModelFile);
				EList resourceList = externalLoader.getResources();
				FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
				fmpResource.getContents().add(fmpProject);
			}	   
		}
		catch (Exception e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		}
		
		return this;
	}
	
	private static void configureFeature(ca.uwaterloo.gp.fmp.Feature feature,Node owner,ca.uwaterloo.gp.fmp.Feature metaModel) {
		ca.uwaterloo.gp.fmp.Feature metaFeature;

		int i = 0;

		if (RoleQuery.INSTANCE.getLocationType((Node)owner) == RoleQuery.MODEL) {
			metaFeature = (ca.uwaterloo.gp.fmp.Feature) metaModel.getChildren().get(i);
		} else if (RoleQuery.INSTANCE.getLocationType((Node)owner) == RoleQuery.METAMODEL) {
			metaFeature = (ca.uwaterloo.gp.fmp.Feature) metaModel.getChildren().get(i);
		} else { 
			metaFeature = null;
		}

		if(metaFeature != null)	{		
			NodeIdDictionary.INSTANCE.visit(feature.getProperties());
		}
		
		NodeIdDictionary.INSTANCE.visit((Node)feature);

		if (feature instanceof Feature) {
			if (RoleQuery.INSTANCE.getNodeType((Node) feature) == RoleQuery.ROOT_FEATURE) {
				((ca.uwaterloo.gp.fmp.Feature)feature).setMin(1);
				((ca.uwaterloo.gp.fmp.Feature)feature).setMax(1);
			}
		}
	}
	
	public void save() {
		if ( fmpResource != null ) {
			Map options = new HashMap();
			options.put(XMLResource.OPTION_ENCODING, "ASCII");

			try {
				fmpResource.save(options);
			} catch (IOException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		} else if ( externalLoader != null ) {
			externalLoader.save(0);
		}
	}
			
	protected Project getFmpProject() {
		return fmpProject;
	}
}
