package br.pucrio.inf.les.genarch.core.project.navigation;

import org.eclipse.core.resources.IResource;

public interface ResourceClient {

	public void visit(IResource resource);
}
