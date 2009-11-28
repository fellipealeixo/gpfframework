package br.pucrio.inf.les.genarch.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.operations.DerivateAsNewProjectOperation;

public class DerivateNewProductWizard extends Wizard implements INewWizard {

	private DerivateNewProductWizardPage page;
	private IProject project;

	public DerivateNewProductWizard(final IProject project) {
		super();
		this.setNeedsProgressMonitor(true);

		this.project = project;
	}

	@Override
	public void addPages() {
		this.page = new DerivateNewProductWizardPage(this.project);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String projectName = this.page.getProjectName();
		final int featureConfigurationIndex = this.page.getFeatureModelConfigurationIndex();
		final String featureModelConfigurationName = this.page.getFeatureModelConfigurationName();

		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					DerivateNewProductWizard.this.doFinish(projectName,featureConfigurationIndex,featureModelConfigurationName,monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					GenarchEMFPlugin.INSTANCE.log(e);
					throw new InvocationTargetException(e);
				} catch (Exception e) {
					GenarchEMFPlugin.INSTANCE.log(e);
					e.printStackTrace();
				} finally {
					monitor.done();
				}
			}
		};

		try {
			this.getContainer().run(true, false, op);
		} catch (final InterruptedException e) {
			return false;
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(this.getShell(), "Error", realException.getMessage());
			return false;
		}

		return true;
	}

	private void doFinish(String projectName,int featureConfigurationIndex,String featureModelConfigurationName,IProgressMonitor monitor) throws CoreException {
		IProject newProductProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);		
		
		DerivateAsNewProjectOperation derivateNewProduct = new DerivateAsNewProjectOperation(this.project,newProductProject,featureConfigurationIndex,featureModelConfigurationName,monitor);
		derivateNewProduct.derivate();
		
		/*DerivateAsBuildFile derivator = new DerivateAsBuildFile(this.project,monitor);
		derivator.derivate();
		monitor.worked(1);*/
	}

	public void init(final IWorkbench workbench, final IStructuredSelection selection) {

	}
}