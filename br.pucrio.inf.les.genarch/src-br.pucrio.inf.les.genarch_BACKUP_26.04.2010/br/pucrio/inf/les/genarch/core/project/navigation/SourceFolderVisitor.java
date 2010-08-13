package br.pucrio.inf.les.genarch.core.project.navigation;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class SourceFolderVisitor extends GenArchResourceVisitor {

    public SourceFolderVisitor(String name, List<ResourceClient> clients, List<String> visitedResourceByPath) {
	super(name, clients, visitedResourceByPath);
    }

    public boolean visit(IResource resource) throws CoreException {

	if ( getVisitedResourceByPath().contains(resource.getProjectRelativePath().toString()) ) {
	    return true;
	}

	getVisitedResourceByPath().add(resource.getProjectRelativePath().toString());

	for ( ResourceClient client : getClients() ) {
	    client.visit(resource);
	}	    

	if ( resource.getType() == IResource.FOLDER ) {
	    String folderName = resource.getName();
	    FolderVisitor folderVisitor = new FolderVisitor(folderName,getClients(),getVisitedResourceByPath());
	    getFolderVisitors().put(folderName,folderVisitor);		
	    resource.accept(folderVisitor);
	}

	return true;
    }    
}
