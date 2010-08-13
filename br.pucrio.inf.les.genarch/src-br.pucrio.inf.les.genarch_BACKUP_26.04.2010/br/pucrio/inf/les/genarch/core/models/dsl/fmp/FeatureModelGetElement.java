package br.pucrio.inf.les.genarch.core.models.dsl.fmp;

import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractFeatureNameFromPath;
import br.pucrio.inf.les.genarch.models.feature.Feature;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;

public class FeatureModelGetElement {
	
	private FeatureModelHandle featureModelHandle;
	
	public FeatureModelGetElement(FeatureModelHandle featureModelHandle) {
		this.featureModelHandle = featureModelHandle;
	}
	
	public Feature feature(String path) {
		Node model = featureModelHandle.getFmpProject().getModel();
		ca.uwaterloo.gp.fmp.Feature featureNode = (ca.uwaterloo.gp.fmp.Feature)ModelNavigation.INSTANCE.findNodeWithName(model,extractFeatureNameFromPath(path));
		
		if ( featureNode != null ) {
			String attribute = null;
			
			if ( featureNode.getTypedValue() != null ) {
				attribute = featureNode.getTypedValue().getValueToString();
			}
			
			return FeatureBuilder.feature().name(featureNode.getName())
											.id(featureNode.getId())
											.max(featureNode.getMax())
											.min(featureNode.getMin())
											.attribute(attribute)
											.path(path).build();		
		}
		
		return null;
	}	
}
