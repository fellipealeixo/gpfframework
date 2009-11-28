package br.pucrio.inf.les.genarch.core.models.dsl.fmp;

import br.pucrio.inf.les.genarch.models.feature.Feature;
import br.pucrio.inf.les.genarch.models.feature.FeatureFactory;
import br.pucrio.inf.les.genarch.models.feature.FeatureType;

public class FeatureBuilder {
	
	private Feature feature;
	
	private FeatureBuilder() {
		this.feature = FeatureFactory.eINSTANCE.createFeature();
	}
	
	public static FeatureBuilder feature() {
		return new FeatureBuilder();
	}
	
	public Feature build() {		
		return this.feature;
	}
	
	public FeatureBuilder name(String name) {
		this.feature.setName(name);
		return this;
	}
	
	public FeatureBuilder id(String id) {	
		return this;
	}
	
	public FeatureBuilder max(int max) {
		this.feature.setMax(max);
		return this;
	}
	
	public FeatureBuilder min(int min) {
		this.feature.setMin(min);
		return this;
	}
	
	public FeatureBuilder attribute(String attribute) {
		this.feature.setAttribute(attribute);
		return this;
	}
	
	public FeatureBuilder path(String path) {
		this.feature.setPath(path);
		return this;
	}
	
	public FeatureBuilder type(int type) {
		this.feature.setType(FeatureType.get(type));
		return this;
	}
}