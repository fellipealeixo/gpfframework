package br.pucrio.inf.les.genarch.core.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;

public class GenArchElementDeleteParticipant extends DeleteParticipant {

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor arg0,CheckConditionsContext arg1) throws OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException,OperationCanceledException {
		CompositeChange changes = new CompositeChange("");
		return null;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	protected boolean initialize(Object arg0) {
		return false;
	}

}
