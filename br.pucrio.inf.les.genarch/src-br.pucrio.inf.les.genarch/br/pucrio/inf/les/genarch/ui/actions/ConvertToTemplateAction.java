package br.pucrio.inf.les.genarch.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import br.pucrio.inf.les.genarch.core.operations.ConvertFileToTemplate;

public class ConvertToTemplateAction implements IObjectActionDelegate {

	private ISelection fSelection;
	public ConvertToTemplateAction() {
		super();
	}

	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {		
	}

	public void run(final IAction action) {

		if(this.fSelection instanceof StructuredSelection) {
			Object element = ((StructuredSelection)this.fSelection).getFirstElement();
			if(element instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable) element;
				IFile resource = (IFile)adaptable.getAdapter(IFile.class);
				if(resource != null) {					
					ConvertFileToTemplate runnable = new ConvertFileToTemplate(resource);

					try {
						PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
					} catch (final InvocationTargetException ex) {
						ex.printStackTrace();
					} catch (final InterruptedException ex) {
						ex.printStackTrace();
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
