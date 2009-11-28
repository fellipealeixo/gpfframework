package br.pucrio.inf.les.genarch.core.templates;

import java.util.HashMap;
import java.util.Map;

public class FeatureModel {
	
	private Map<String,Object> featureModel;
	
	public FeatureModel() {
		featureModel = new HashMap<String,Object>();		
	}
	
	public Map<String,Object> getFeatureModel() {
		return featureModel;
	}
	
}
