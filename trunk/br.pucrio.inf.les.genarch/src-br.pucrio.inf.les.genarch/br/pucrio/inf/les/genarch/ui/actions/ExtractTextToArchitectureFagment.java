package br.pucrio.inf.les.genarch.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.UIPlugin;

import br.pucrio.inf.les.genarch.ui.wizards.ExtractToFragmentWizard;

public class ExtractTextToArchitectureFagment implements IEditorActionDelegate {

	private ITextSelection textSelection;
	private IAction action;
	private IFile file;
	
	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {
		
	}

	public void run(IAction arg0) {
		if(this.textSelection != null ) {
			Shell shell = UIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
			ExtractToFragmentWizard wizard = new ExtractToFragmentWizard(this.file,textSelection);
			WizardDialog dialog = new WizardDialog(shell,wizard);
			dialog.open();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if ( selection instanceof ITextSelection ) {
			this.textSelection = (ITextSelection)selection;
			this.action = action;
		}
	}

	public void setActiveEditor(IAction actions, IEditorPart editorPart) {
		this.file = ((IFileEditorInput)editorPart.getEditorInput()).getFile();
	}
}
