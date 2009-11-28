package br.pucrio.inf.les.genarch;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Architecture editor plugin.
 * @generated
 */
public final class GenarchEMFPlugin extends EMFPlugin {
	
	public static final GenarchEMFPlugin INSTANCE = new GenarchEMFPlugin();

	private static Implementation plugin;

	public GenarchEMFPlugin() {
		super(new ResourceLocator [] {});	
	}
	
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}       
	
	public static Implementation getPlugin() {	
		return plugin;
	}

	public static class Implementation extends EclipseUIPlugin {
		public Implementation() {
			super();
			plugin = this;
		}

		public void start(BundleContext context) throws Exception {
			super.start(context);	  
		}
	}
}
