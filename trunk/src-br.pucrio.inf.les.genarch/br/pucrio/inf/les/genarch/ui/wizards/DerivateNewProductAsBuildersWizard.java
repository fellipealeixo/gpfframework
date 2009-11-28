package br.pucrio.inf.les.genarch.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.operations.DerivateAsBuildFileOperation;

public class DerivateNewProductAsBuildersWizard extends Wizard implements INewWizard {

	private DerivateNewProductAsBuildersWizardPage page;
	private IProject project;

	public DerivateNewProductAsBuildersWizard(final IProject project) {
		super();
		this.setNeedsProgressMonitor(true);

		this.project = project;
	}

	@Override
	public void addPages() {
		this.page = new DerivateNewProductAsBuildersWizardPage(this.project);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String folderPath = this.page.getFolderPath();
		
		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					DerivateNewProductAsBuildersWizard.this.doFinish(folderPath,monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} catch (Exception e) {
					e.printStackTrace();
					GenarchEMFPlugin.INSTANCE.log(e);
				} finally {
					monitor.done();
				}
			}
		};

		try {
			this.getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(this.getShell(),"Error",realException.getMessage());
			return false;
		}

		return true;
	}

	private void doFinish(String folderPath,IProgressMonitor monitor) throws CoreException {
		DerivateAsBuildFileOperation derivator = new DerivateAsBuildFileOperation(this.project,folderPath,monitor);
		try {
			derivator.derivate();
		} catch (Exception e) {
			throw new CoreException(null);
		} finally {
			monitor.worked(1);
		}		
	}

	public void init(final IWorkbench workbench, final IStructuredSelection selection) {

	}
}