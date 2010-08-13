package br.pucrio.inf.les.genarch.core.project.navigation.itens;

import br.pucrio.inf.les.genarch.core.annotations.FeatureType;

public class FeatureItem {
	
	private String name;
	private FeatureType type;
	private String parent;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getParent() {
		return this.parent;
	}
	
	public void setParent(final String parent) {
		this.parent = parent;
	}
	
	public FeatureType getType() {
		return this.type;
	}
	
	public void setType(final FeatureType type) {
		this.type = type;
	}
}
