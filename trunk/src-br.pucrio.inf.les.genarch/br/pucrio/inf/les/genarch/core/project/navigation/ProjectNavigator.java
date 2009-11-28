package br.pucrio.inf.les.genarch.core.project.navigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class ProjectNavigator {

	private IProject project;
	private List<String> containers;
	private List<ResourceClient> clients;
	private Map<String,SourceFolderVisitor> sourceFolderVisitors;
	private List<String> visitedResourceByPath;

	public ProjectNavigator(IProject project,List<String> containers) {
		this.project = project;
		this.containers = containers;
		this.clients = new ArrayList<ResourceClient>();
		this.sourceFolderVisitors = new HashMap<String,SourceFolderVisitor>();
		this.visitedResourceByPath = new ArrayList<String>();
	}

	public void navigate() {
		try {
			for (String sourceFolder : this.containers ) {
				IFolder folder = project.getFolder(sourceFolder);
				SourceFolderVisitor visitor = new SourceFolderVisitor(sourceFolder,clients,visitedResourceByPath);
				this.sourceFolderVisitors.put(sourceFolder, visitor);				
				folder.accept(visitor);
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}

	public void addResourceVisitors(final ResourceClient visit) {
		this.clients.add(visit);
	}
}