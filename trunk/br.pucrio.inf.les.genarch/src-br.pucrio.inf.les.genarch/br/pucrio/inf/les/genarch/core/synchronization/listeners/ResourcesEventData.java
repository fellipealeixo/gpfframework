package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;

public class ResourcesEventData implements Comparable{
    
    private int eventType;
    private int flags;
    private IResource resource;
    private IResourceDelta resourceDelta;
    private String fromPath;
    
    public int getEventType() {
        return eventType;
    }
    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
    public IResource getResource() {
        return resource;
    }
    public void setResource(IResource resource) {
        this.resource = resource;
    }
    public IResourceDelta getResourceDelta() {
        return resourceDelta;
    }
    public void setResourceDelta(IResourceDelta resourceDelta) {
        this.resourceDelta = resourceDelta;
    }
    public int getFlags() {
        return flags;
    }
    public void setFlags(int flags) {
        this.flags = flags;
    }
    public String getFromPath() {
        return fromPath;
    }
    public void setFromPath(String fromPath) {
        this.fromPath = fromPath;
    }
    public int compareTo(Object o) {
	if ( o instanceof ResourcesEventData ) {
	    ResourcesEventData oData = (ResourcesEventData)o;
	    if ( oData.getEventType() > this.getEventType() ) {
		return 1;
	    } else if ( oData.getEventType() == this.getEventType() ) {
		return 0;
	    } else {
		return -1;
	    }
	}
	
	return 0;
    }
}
