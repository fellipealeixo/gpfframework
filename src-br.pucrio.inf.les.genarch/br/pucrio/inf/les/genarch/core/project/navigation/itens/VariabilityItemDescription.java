package br.pucrio.inf.les.genarch.core.project.navigation.itens;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;

public class VariabilityItemDescription {
	
	public enum ItemType {interfaceType,abstractClassType,aspectType};
	
	private String name;
	private String packageName;
	private IPath fullPath;
	private ItemType type;
	private List<String> abstractDeclarations;
	
	public VariabilityItemDescription() {
		this.abstractDeclarations = new ArrayList<String>();
	}
	
	public IPath getFullPath() {
		return this.fullPath;
	}

	public void setFullPath(final IPath fullPath) {
		this.fullPath = fullPath;
	}

	public ItemType getType() {
		return this.type;
	}

	public void setType(final ItemType type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(final String packageName) {
		this.packageName = packageName;
	}

	public List<String> getAbstractDeclarations() {
		return this.abstractDeclarations;
	}

	public void setAbstractDeclarations(final List<String> abstractDeclarations) {
		this.abstractDeclarations = abstractDeclarations;
	}
}
