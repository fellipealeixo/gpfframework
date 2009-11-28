package br.pucrio.inf.les.genarch.core.project.navigation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResourceVisitor;

public abstract class GenArchResourceVisitor implements IResourceVisitor {
    
    private String name;
    private List<ResourceClient> clients;
    private Map<String,FolderVisitor> folderVisitors;  
    private List<String> visitedResourceByPath;
    
    public GenArchResourceVisitor(String name,List<ResourceClient> clients,List<String> visitedResourceByPath) {
	this.name = name;
	this.clients = clients;
	this.folderVisitors = new HashMap<String, FolderVisitor>();
	this.visitedResourceByPath = visitedResourceByPath;
    }

    protected List<ResourceClient> getClients() {
        return clients;
    }

    protected Map<String, FolderVisitor> getFolderVisitors() {
        return folderVisitors;
    }

    protected String getName() {
        return name;
    }

    protected List<String> getVisitedResourceByPath() {
        return visitedResourceByPath;
    }
}
