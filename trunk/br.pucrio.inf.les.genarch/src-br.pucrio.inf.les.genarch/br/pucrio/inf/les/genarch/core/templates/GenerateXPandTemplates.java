package br.pucrio.inf.les.genarch.core.templates;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EPackage;
import org.openarchitectureware.expression.ExecutionContext;
import org.openarchitectureware.expression.Variable;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.util.ResourceLoaderFactory;
import org.openarchitectureware.workflow.util.ResourceLoaderImpl;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;
import org.openarchitectureware.xpand2.XpandUtil;
import org.openarchitectureware.xpand2.ast.Template;
import org.openarchitectureware.xpand2.model.XpandDefinition;
import org.openarchitectureware.xpand2.output.JavaBeautifier;
import org.openarchitectureware.xpand2.output.Outlet;
import org.openarchitectureware.xpand2.output.OutputImpl;
import org.openarchitectureware.xpand2.parser.XpandParseFacade;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class GenerateXPandTemplates {

	private static GenerateXPandTemplates instance;	
	private static final String fileEncoding = "ISO-8859-1";

	public static GenerateXPandTemplates getInstance() {

		if ( instance == null ) {
			instance = new GenerateXPandTemplates();
		}

		return instance;

	}

	private GenerateXPandTemplates() {

	}

	public void generate(IPath instantiationPath,IPath templatePath,String definitionName,Object targetObject,EPackage ePackage) {

		ResourceLoaderFactory.setCurrentThreadResourceLoader(new ResourceLoaderImpl(this.getClass().getClassLoader()));

		try {
			OutputImpl out = new OutputImpl();
			JavaBeautifier beautifier = new JavaBeautifier();	  
			Outlet o = new Outlet();
			o.setPath(instantiationPath.toString());
			o.addPostprocessor(beautifier);
			out.addOutlet(o);

			XpandExecutionContextImpl ctx = new XpandExecutionContextImpl(out, null);
			ctx.setFileEncoding(fileEncoding);
			EmfMetaModel m = new EmfMetaModel(ePackage);
			ctx.registerMetaModel(m);			
			ctx = (XpandExecutionContextImpl)ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE,targetObject));

			String fileName = XpandUtil.getJavaResourceName(XpandUtil.withoutLastSegment(definitionName));	    
			String definition = XpandUtil.getLastSegment(definitionName);	  

			InputStream fIn = ResourcesPlugin.getWorkspace().getRoot().getFile(templatePath).getContents();
			XpandDefinition xd = null;
				
			Template template = XpandParseFacade.file(new InputStreamReader(fIn), fileName);
			xd = template.getDefinitionsByName(definition)[0];
			ctx = (XpandExecutionContextImpl)ctx.cloneWithResource(xd.getOwner());
			xd.evaluate(ctx);

		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);			
		} catch (Exception e ) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}
}
