package br.pucrio.inf.les.genarch.core.models;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;

public class FeatureModelContent {
	
	List<FeatureItem> featureItens;
	
	public FeatureModelContent() {
		this.featureItens = new ArrayList<FeatureItem>();
	}

	public List<FeatureItem> getFeatureItens() {
		return this.featureItens;
	}
}
