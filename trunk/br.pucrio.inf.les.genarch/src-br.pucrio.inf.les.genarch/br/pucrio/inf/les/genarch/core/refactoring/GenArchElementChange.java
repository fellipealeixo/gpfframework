package br.pucrio.inf.les.genarch.core.refactoring;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class GenArchElementChange extends Change {
	
	private String name;
	private IFile modifiedElement;
		
	public void setName(String name) {
		this.name = name;
	}

	public void setModifiedElement(IFile modifiedElement) {
		this.modifiedElement = modifiedElement;
	}

	@Override
	public Object getModifiedElement() {
		return modifiedElement;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void initializeValidationData(IProgressMonitor arg0) {
		
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor arg0) throws CoreException, OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor arg0) throws CoreException {
		return null;
	}
}
