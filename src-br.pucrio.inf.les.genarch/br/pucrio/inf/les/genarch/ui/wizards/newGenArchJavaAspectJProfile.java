package br.pucrio.inf.les.genarch.ui.wizards;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.ClasspathEntry;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.GenarchPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;

public class newGenArchJavaAspectJProfile extends NewGenArchProfile {

	public boolean configureProject(IProject project) {

		try {
			//Adding project natures
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();

			String[] newNatures = new String[prevNatures.length + 3];	
			System.arraycopy(prevNatures, 0, newNatures, 3, prevNatures.length);
			newNatures[0] = "br.pucrio.inf.les.genarch.genarchnature";
			newNatures[1] = "org.eclipse.ajdt.ui.ajnature";
			newNatures[2] = "org.eclipse.jdt.core.javanature";	    
			description.setNatureIds(newNatures);
			project.setDescription(description, null);

			//Convert the projeto to Java Project
			IJavaProject javaProject = JavaCore.create(project);

			//Adding a source folder
			IFolder sourceFolder = project.getFolder(new Path("src"));
			sourceFolder.create(true, true, new NullProgressMonitor());

			IClasspathEntry[] originalCP = javaProject.getRawClasspath();
			int originalCPLength = originalCP.length;
			IClasspathEntry[] newCP = new IClasspathEntry[originalCPLength];
			System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);	    
			IClasspathEntry sourcePath = new ClasspathEntry(IPackageFragmentRoot.K_SOURCE,IClasspathEntry.CPE_SOURCE,new Path("src"),ClasspathEntry.INCLUDE_ALL,ClasspathEntry.EXCLUDE_NONE,null,null,null,false,null,false,ClasspathEntry.NO_EXTRA_ATTRIBUTES); 	    
			newCP[0] = sourcePath;
			javaProject.setRawClasspath(newCP, new NullProgressMonitor());

			//Adding the AspectJ libraries
			originalCP = javaProject.getRawClasspath();	    
			IClasspathEntry ajrtLIB = JavaCore.newContainerEntry(new Path("org.eclipse.ajdt.core.ASPECTJRT_CONTAINER"), true);
			originalCPLength = originalCP.length;
			newCP = new IClasspathEntry[originalCPLength + 1];
			System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);
			newCP[originalCPLength] = ajrtLIB;
			javaProject.setRawClasspath(newCP, new NullProgressMonitor());

			//Adding the java libraries
			originalCP = javaProject.getRawClasspath();
			ajrtLIB = JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER"), true);
			originalCPLength = originalCP.length;
			newCP = new IClasspathEntry[originalCPLength + 1];
			System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);
			newCP[originalCPLength] = ajrtLIB;
			javaProject.setRawClasspath(newCP, new NullProgressMonitor());

			originalCP = javaProject.getRawClasspath();
			ajrtLIB = JavaCore.newContainerEntry(new Path(GenarchPlugin.GENARCH_CONTAINER), true);
			originalCPLength = originalCP.length;
			newCP = new IClasspathEntry[originalCPLength + 1];
			System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);
			newCP[originalCPLength] = ajrtLIB;
			javaProject.setRawClasspath(newCP, new NullProgressMonitor());

			//Removing project bilders
			description = project.getDescription();
			description.setBuildSpec(new ICommand[]{});
			project.setDescription(description, null);


			GenarchProjectConfigurationFile.open(project).save(new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return true;
	}

}
