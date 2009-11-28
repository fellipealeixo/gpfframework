package br.pucrio.inf.les.genarch.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public abstract class NewGenArchProfile extends Wizard implements INewWizard {

	private newGenArchProfilePage page1;

	public NewGenArchProfile() {
		super();
		setNeedsProgressMonitor(true);
	}

	public void addPages() {
		this.page1 = new newGenArchProfilePage();
		addPage(this.page1);
	}

	public boolean performFinish() {

		//Cria um projeto Eclipse sem natureza
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		IProject newGenArchProject = workspaceRoot.getProject(this.page1.getProjectName());

		String workspaceLocation = workspaceRoot.getLocation().toString();
		String newGenArchProjectName = newGenArchProject.getName();
		IPath projectPath = new Path(workspaceLocation + newGenArchProjectName);

		IProjectDescription newGenArchProjectDescription = workspace.newProjectDescription(newGenArchProjectName);
		newGenArchProjectDescription.setLocation(projectPath);

		try {
			newGenArchProject.create(new NullProgressMonitor());
			newGenArchProject.open(new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		//Adiciona configurações
		return configureProject(newGenArchProject);	
	}

	public abstract boolean configureProject(IProject project);

	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

}
