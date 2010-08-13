package br.pucrio.inf.les.genarch.core.refactoring;

import org.eclipse.ajdt.core.text.CoreMessages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;

import br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationModelHandle;
import br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureModelHandle;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;

public class GenArchElementRenameParticipant extends RenameParticipant {

	private IFile element;

	public GenArchElementRenameParticipant() {

	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor progressMonitor,CheckConditionsContext checkConditionsContext) throws OperationCanceledException {			
		RefactoringStatus rs = new RefactoringStatus();
		IProject project = element.getProject();
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		if ( !project.getFile(genarchProjectConfigurationFile.getArchitectureModelPath()).exists() ) {
			rs.addError("Architecture Model file not found.");
		}

		if ( !project.getFile(genarchProjectConfigurationFile.getConfigurationModelPath()).exists() ) {
			rs.addError("Configuration Model file not found.");
		}

		return rs;
	}

	@Override
	public Change createChange(IProgressMonitor arg0) throws CoreException,OperationCanceledException {
		CompositeChange changes = new CompositeChange(CoreMessages.renameTypeReferences);
		IProject project = element.getProject();
		String oldName = element.getName();
		String newName = getArguments().getNewName();

		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		ArchitectureModelHandle architectureModelHandle = ArchitectureModelHandle.architectureModel(project);
		//if ( architectureElement != null ) {
			GenArchElementChange genArchElementChangeInArchitectureModel = new GenArchElementChange();
			genArchElementChangeInArchitectureModel.setEnabled(true);
			genArchElementChangeInArchitectureModel.setModifiedElement(project.getFile(genarchProjectConfigurationFile.getArchitectureModelPath()));
			genArchElementChangeInArchitectureModel.setName("Rename implementation element '" + oldName + "' to '" + newName + "' in architecture model.");
			changes.add(genArchElementChangeInArchitectureModel);
		//}

		ConfigurationModelHandle configurationModelHandle = ConfigurationModelHandle.configurationModel(project);
		//if ( configurationElement != null ) {
			GenArchElementChange genArchElementChangeInConfigurationModel = new GenArchElementChange();
			genArchElementChangeInConfigurationModel.setEnabled(true);
			genArchElementChangeInConfigurationModel.setModifiedElement(project.getFile(genarchProjectConfigurationFile.getArchitectureModelPath()));
			genArchElementChangeInConfigurationModel.setName("Rename implementation element '" + oldName + "' to '" + newName + "' in configuration model.");
			changes.add(genArchElementChangeInConfigurationModel);
		//}

		return changes;
	}

	@Override
	public String getName() {
		return "renameParticipant";
	}

	protected boolean initialize(Object arg0) {
		if ( arg0 instanceof IFile ) {
			element = (IFile)arg0;
		}
		return true;
	}

}
