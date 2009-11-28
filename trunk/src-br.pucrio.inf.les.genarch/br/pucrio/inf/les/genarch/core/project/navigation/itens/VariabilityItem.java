package br.pucrio.inf.les.genarch.core.project.navigation.itens;

import br.pucrio.inf.les.genarch.core.annotations.VariabilityType;

public class VariabilityItem {
	
	private VariabilityType type;
	private String feature;
	private VariabilityItemDescription itemDescription;
	
	public String getFeature() {
		return this.feature;
	}
	
	public void setFeature(final String feature) {
		this.feature = feature;
	}
	
	public VariabilityType getType() {
		return this.type;
	}

	public void setType(final VariabilityType type) {
		this.type = type;
	}

	public VariabilityItemDescription getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(final VariabilityItemDescription itemDescription) {
		this.itemDescription = itemDescription;
	}
}
