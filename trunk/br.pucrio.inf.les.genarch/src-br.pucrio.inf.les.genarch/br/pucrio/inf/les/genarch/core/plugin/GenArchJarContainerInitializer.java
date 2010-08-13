package br.pucrio.inf.les.genarch.core.plugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import br.pucrio.inf.les.genarch.GenarchPlugin;

public class GenArchJarContainerInitializer extends ClasspathContainerInitializer {

    @Override
    public void initialize(IPath containerPath, IJavaProject project) throws CoreException {
	int size = containerPath.segmentCount();
	if (size > 0) {
	    if (containerPath.segment(0).equals(GenarchPlugin.GENARCH_CONTAINER)) {
		GenArchJarContainer container = new GenArchJarContainer();
		JavaCore.setClasspathContainer(containerPath,new IJavaProject[] { project },new IClasspathContainer[] { container }, null);
	    }
	}
    }

}
