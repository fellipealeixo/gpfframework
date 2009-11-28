package br.pucrio.inf.les.genarch;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

public class GenarchPlugin extends Plugin {

	public static final GenarchPlugin INSTANCE = new GenarchPlugin();

	public static final String PLUGIN_ID = "br.pucrio.inf.les.genarch";
	
	public static final String GENARCH_NATURE = PLUGIN_ID + ".genarchnature";

	public static final String GENARCH_CONTAINER = PLUGIN_ID + ".GENARCH_CONTAINER";

	public GenarchPlugin() {
		super();
	}

	public ResourceLocator getPluginResourceLocator() {
		return GenarchEMFPlugin.INSTANCE.getPluginResourceLocator();
	}

	public void start(BundleContext context) throws Exception {	
		super.start(context);				
	}
}
