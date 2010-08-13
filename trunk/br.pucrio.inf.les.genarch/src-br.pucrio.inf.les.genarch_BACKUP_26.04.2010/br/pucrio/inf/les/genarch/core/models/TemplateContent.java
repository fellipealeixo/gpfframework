package br.pucrio.inf.les.genarch.core.models;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;

public class TemplateContent {

	private List<VariabilityItem> variabilities;
	
	public TemplateContent() {		
		this.variabilities = new ArrayList<VariabilityItem>();
	}
	
	public List<VariabilityItem> getVariabilities() {
		return this.variabilities;
	}
}
