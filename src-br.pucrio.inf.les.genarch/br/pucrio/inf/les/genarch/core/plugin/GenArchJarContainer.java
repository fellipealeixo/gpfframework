package br.pucrio.inf.les.genarch.core.plugin;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.GenarchPlugin;

public class GenArchJarContainer implements IClasspathContainer {

	private IClasspathEntry[] fClasspathEntries;
	
	public IClasspathEntry[] getClasspathEntries() {
		
		if (fClasspathEntries == null) {
			String[] path = getJATClasspath();
			fClasspathEntries = new IClasspathEntry[path.length];
			for (int i = 0; i < path.length; i++) {
				IPath p = new Path(path[i]);
				fClasspathEntries[i] = JavaCore.newLibraryEntry(p, null, null,false);
			}
		}
		return fClasspathEntries;		
	}
	
	private String[] getJATClasspath() {
		
		List jatClasspathEntries = new LinkedList();
		String[] jatEntries = null;
		
		Bundle jatBundle = Platform.getBundle(GenarchPlugin.PLUGIN_ID);

		String pluginLoc = null;

		if (jatBundle != null) {
			URL installLoc = jatBundle.getEntry("/");
			URL resolved = null;
			try {
				resolved = FileLocator.resolve(installLoc);
				pluginLoc = resolved.toExternalForm();
			} catch (IOException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		}
		
		String[] libs = {"featuremodel.jar",
				 "genarchannotations.jar"};
		
		if (pluginLoc != null) {
			for ( int x = 0; x < libs.length; x++ ) {
				StringBuffer cpath = new StringBuffer();

				if (pluginLoc.startsWith("file:")) {
					cpath.append(pluginLoc.substring("file:".length()));
					cpath.append("lib/");
					cpath.append(libs[x]);
					
					jatClasspathEntries.add(cpath.toString());
				}
			}
		}
		
		jatEntries = new String[jatClasspathEntries.size()];
		jatClasspathEntries.toArray(jatEntries);
		
		return jatEntries;
	}

	public String getDescription() {
		return "Genarch Library";
	}

	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	public IPath getPath() {
		return new Path(GenarchPlugin.GENARCH_CONTAINER);
	}

}
