package br.pucrio.inf.les.genarch.core.models.dsl.fmp;

import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractFeatuerParentName;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;

import br.pucrio.inf.les.genarch.models.feature.Feature;
import br.pucrio.inf.les.genarch.models.feature.FeatureType;
import ca.uwaterloo.gp.fmp.ConfigState;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.ValueType;
import ca.uwaterloo.gp.fmp.system.MetaModel;
import ca.uwaterloo.gp.fmp.system.ModelManipulation;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.system.NodeIdDictionary;
import ca.uwaterloo.gp.fmp.system.RoleQuery;

public class FeatureModelAddElement {
	
	private FeatureModelHandle featureModelHandle;
	private ModelNavigation modelNavigation;
	
	public FeatureModelAddElement(FeatureModelHandle featureModelHandle) {
		this.featureModelHandle = featureModelHandle;
		this.modelNavigation = ModelNavigation.INSTANCE;
	}
	
	public FeatureModelAddElement feature(Feature feature) {
		Node model = featureModelHandle.getFmpProject().getModel();
		Node featureNode = modelNavigation.findNodeWithName(model,feature.getName());
		
		if ( featureNode == null ) {
			Path xPath = new Path(feature.getPath());
			int featurePathLength = xPath.segmentCount();
			
			Node parent = (Node)model.getChildren().get(0);
			
			if ( featurePathLength > 2 ) {			
				parent = modelNavigation.findNodeWithName(model,extractFeatuerParentName(feature.getPath()));
				
				if ( parent == null ) {
					parent = addDefaultFeature(extractFeatuerParentName(feature.getPath()),model,featureModelHandle.getFmpProject());
				}
			}			
			createFeature(feature, parent);
		}
					
		return this;
	}
	
	private void createFeature(Feature feature,Node parent) {
		Node model = featureModelHandle.getFmpProject().getModel();
		
		int max = 0;
		int min = 0;
		
		ca.uwaterloo.gp.fmp.Feature child = null;

		if ( feature.getType().getValue() == FeatureType.ALTERNATIVE ) {
			FeatureGroup childGroup = findFeatureGroup(parent);

			if ( childGroup == null ) {
				childGroup = MetaModel.createFeatureGroupWithProperties(parent.getId() + "Group", 1, 1, featureModelHandle.getFmpProject().getMetaModel());
				parent.getChildren().add(childGroup);
				configureFeatureGroup(childGroup,model,featureModelHandle.getFmpProject().getMetaModel());
			}

			child = MetaModel.createFeatureWithProperties(feature.getName(),ModelManipulation.INSTANCE.getValidId(feature.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, 0, 1, featureModelHandle.getFmpProject().getMetaModel());
			childGroup.getChildren().add(child);
			configureFeature(child,childGroup,featureModelHandle.getFmpProject().getMetaModel());		    		    		    		 
		} else {
			
			if ( feature.getType().getValue() == FeatureType.MANDATORY ) {
				max = 1;
				min = 0;
			} else if ( feature.getType().getValue() == FeatureType.OPTIONAL ) {
				max = 1;
				min = 1;
			}
			
			child = MetaModel.createFeatureWithProperties(feature.getName(),ModelManipulation.INSTANCE.getValidId(feature.getName()), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, min, max, featureModelHandle.getFmpProject().getMetaModel());
			Node c = (Node)model.getChildren().get(0); 
			c.getChildren().add(child);
			configureFeature(child,model,featureModelHandle.getFmpProject().getMetaModel());
		}
	}
	
	private Node addDefaultFeature(String name,Node parent,Project fmpProject) {
		int max = 1;
		int min = 1;

		ca.uwaterloo.gp.fmp.Feature child = MetaModel.createFeatureWithProperties(name,ModelManipulation.INSTANCE.getValidId(name), ConfigState.UNDECIDED_LITERAL, ValueType.NONE_LITERAL, null, null, min, max, fmpProject.getMetaModel());
		Node c = (Node)parent.getChildren().get(0);
		c.getChildren().add(child);
		configureFeature(child,parent,fmpProject.getMetaModel());

		return child;		
	}
	
	private void configureFeature(ca.uwaterloo.gp.fmp.Feature feature,Node owner,ca.uwaterloo.gp.fmp.Feature metaModel) {
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
	

	private void configureFeatureGroup(FeatureGroup feature,Node owner,ca.uwaterloo.gp.fmp.Feature metaModel) {
		ca.uwaterloo.gp.fmp.Feature metaFeature;

		int i = 1;

		if (RoleQuery.INSTANCE.getLocationType((Node)owner) == RoleQuery.MODEL)
			metaFeature = (ca.uwaterloo.gp.fmp.Feature)metaModel.getChildren().get(i);
		else if (RoleQuery.INSTANCE.getLocationType((Node)owner) == RoleQuery.METAMODEL)
			metaFeature = (ca.uwaterloo.gp.fmp.Feature)metaModel.getChildren().get(i);
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
}
