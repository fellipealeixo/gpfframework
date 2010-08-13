package br.pucrio.inf.les.genarch.core.operations;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.operation.IRunnableWithProgress;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.GenarchPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;

public class ConvertOperation implements IRunnableWithProgress {

	private IProject project;
	private List<String> sourceContainers;
	private List<String> resourceContainers;

	public ConvertOperation(IProject project,List<String> sourceContainers,List<String> resourceContainres) {
		this.project = project;
		this.sourceContainers = sourceContainers;
		this.resourceContainers = resourceContainres;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		genarchProjectConfigurationFile.setSourceContainers(sourceContainers);
		genarchProjectConfigurationFile.setResourceContainers(resourceContainers);
		genarchProjectConfigurationFile.save(monitor);

		try {
			IProjectDescription description = this.project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 1, prevNatures.length);
			newNatures[0] = "br.pucrio.inf.les.genarch.genarchnature";
			description.setNatureIds(newNatures);
			description.setBuildSpec(new ICommand[0]);
			this.project.setDescription(description, null);

			IClasspathEntry[] originalCP = JavaCore.create(this.project).getRawClasspath();
			IClasspathEntry ajrtLIB = JavaCore.newContainerEntry(new Path(GenarchPlugin.GENARCH_CONTAINER), true);
			int originalCPLength = originalCP.length;
			IClasspathEntry[] newCP = new IClasspathEntry[originalCPLength + 1];
			System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);
			newCP[originalCPLength] = ajrtLIB;
			JavaCore.create(this.project).setRawClasspath(newCP, new NullProgressMonitor());

		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		monitor.worked(7);
	}
}
