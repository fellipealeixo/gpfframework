package br.pucrio.inf.les.genarch.ui.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.UIPlugin;

import br.pucrio.inf.les.genarch.ui.wizards.DerivateNewProductWizard;

public class DerivatieProductAsProjectAction implements IObjectActionDelegate {

	private ISelection fSelection;
	public DerivatieProductAsProjectAction() {
		super();
	}

	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
	}

	public void selectionChanged(final IAction action, final ISelection selection) {
		this.fSelection = selection;	
	}

	public void run(final IAction action) {

		if(this.fSelection instanceof StructuredSelection) {
			final Object element = ((StructuredSelection)this.fSelection).getFirstElement();
			if(element instanceof IAdaptable) {
				final IAdaptable adaptable = (IAdaptable) element;
				final IResource resource = (IResource)adaptable.getAdapter(IResource.class);
				if(resource != null) {
					final Shell shell = UIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
					final IProject project = resource.getProject();
					final DerivateNewProductWizard wizard = new DerivateNewProductWizard(project);
					final WizardDialog dialog = new WizardDialog(shell,wizard);
					dialog.open();
				}
			}
		}		
	}
}