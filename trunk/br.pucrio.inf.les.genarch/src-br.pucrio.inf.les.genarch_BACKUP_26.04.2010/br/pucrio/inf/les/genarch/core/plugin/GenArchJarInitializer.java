package br.pucrio.inf.les.genarch.core.plugin;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ClasspathVariableInitializer;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.osgi.framework.Bundle;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.GenarchPlugin;

public class GenArchJarInitializer extends ClasspathVariableInitializer {

	public static boolean hasBeenUsed = false;

	@Override
	public void initialize(String variable) {
		if (variable.equals("GENARCH_LIB")) { 
			String jatJarPath = getJATJarPath();			
			try {
				JavaCore.setClasspathVariable("GENARCH_LIB",new Path(jatJarPath),null);
				hasBeenUsed = true;
			} catch (JavaModelException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		}
	}

	private String getJATJarPath() {
		
		StringBuffer cpath = new StringBuffer();
		
		Bundle jatBundle = Platform.getBundle(GenarchPlugin.PLUGIN_ID);

		String pluginLoc = null;

		if (jatBundle != null) {
			URL installLoc = jatBundle.getEntry("/"); //$NON-NLS-1$
			URL resolved = null;
			try {
				resolved = FileLocator.resolve(installLoc);
				pluginLoc = resolved.toExternalForm();
			} catch (IOException e) {
			}
		}
		
		if (pluginLoc != null) {
			if (pluginLoc.startsWith("file:")) { //$NON-NLS-1$
				cpath.append(pluginLoc.substring("file:".length())); //$NON-NLS-1$
				cpath.append("lib/genarchannotations.jar"); //$NON-NLS-1$
			}
		}
		
		return cpath.toString();
	}
}
