package br.pucrio.inf.les.genarch.ui.actions;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.operations.CreateModelsOperation;

public class CreateModelsAction implements IObjectActionDelegate {

	private ISelection fSelection;
	public CreateModelsAction() {
		super();
	}

	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {		
	}

	public void run(final IAction action) {

		if(this.fSelection instanceof StructuredSelection) {
			Object element = ((StructuredSelection)this.fSelection).getFirstElement();
			if(element instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable) element;
				IResource resource = (IResource) adaptable.getAdapter(IResource.class);
				if(resource != null) {				
					final IProject project = resource.getProject();
					
					CreateModelsOperation runnable = new CreateModelsOperation(project);
					
					//por wanderson
					//JOptionPane.showMessageDialog(null,"create Models operation");
					
					try {
						PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
					} catch (final InvocationTargetException ex) {
						ex.printStackTrace();
						GenarchEMFPlugin.INSTANCE.log(ex);
					} catch (final InterruptedException ex) {
						ex.printStackTrace();
						GenarchEMFPlugin.INSTANCE.log(ex);
					}
				}
			}
		}
	}

	public void selectionChanged(final IAction action, final ISelection selection) {
		this.fSelection = selection;
	}

	public void dispose() {

	}	
}
