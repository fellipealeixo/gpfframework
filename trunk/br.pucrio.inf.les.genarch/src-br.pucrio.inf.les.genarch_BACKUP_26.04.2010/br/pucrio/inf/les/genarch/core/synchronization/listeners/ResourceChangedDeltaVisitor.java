package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

public class ResourceChangedDeltaVisitor implements IResourceDeltaVisitor  {

    private List<ResourcesEventData> resourcesDataEvent;

    public ResourceChangedDeltaVisitor() {
	this.resourcesDataEvent = new ArrayList<ResourcesEventData>();
    }

    public boolean visit(IResourceDelta delta) throws CoreException {
	IResource res = delta.getResource();

	if ( res.getType() == IResource.FILE || res.getType() == IResource.FOLDER ) {
	    ResourcesEventData resourceData = new ResourcesEventData();
	    resourceData.setEventType(delta.getKind());
	    resourceData.setFlags(delta.getFlags());

	    if ( delta.getFlags() == IResourceDelta.MOVED_FROM ) {
		resourceData.setFromPath(delta.getMovedFromPath().removeFirstSegments(1).toString());
	    }

	    resourceData.setResource(res);

	    resourcesDataEvent.add(resourceData);
	}

	return true;
    }

    public List<ResourcesEventData> getResourcesDataEvent() {
	return resourcesDataEvent;
    }
}
