package br.pucrio.inf.les.genarch.core.operations;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureModelHandle;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

public class ConvertFileToTemplate implements IRunnableWithProgress {

	private IFile file;

	public ConvertFileToTemplate(IFile file) {
		this.file = file;
	}

	public void run(IProgressMonitor progressMonitor) throws InvocationTargetException,InterruptedException {

		try {
			InputStream inputStream = file.getContents();

			String head = "«IMPORT br::pucrio::inf::les::genarch::models::instance»\n«EXTENSION br::pucrio::inf::les::genarch::models::Model»\n«DEFINE Main FOR Instance»\n«FILE " +  "\"" + file.getName() + "\"" + "-»\n";
			String foot = "«ENDFILE»\n«ENDDEFINE»";

			StringBuffer newContent = new StringBuffer();
			newContent.append(head);

			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while ( (line = in.readLine()) != null ) {
				newContent.append(line);
				newContent.append("\n");
			}

			newContent.append(foot);

			ByteArrayInputStream newInputStream = new ByteArrayInputStream(newContent.toString().getBytes());
			IFile fileTemplate = file.getProject().getFile(file.getProjectRelativePath().removeLastSegments(1).append(file.getName() + ".xpt"));

			try {
				if ( fileTemplate.exists() ) {
					fileTemplate.setContents(newInputStream, true, true, progressMonitor);					
				} else {
					fileTemplate.create(newInputStream, true, new NullProgressMonitor());
				}
			} catch (final CoreException e) {
				e.printStackTrace();
			}

			newInputStream.close();
			inputStream.close();
			
			file.delete(false,progressMonitor);
			
			ArchitectureTemplate architectureTemplate = ArchitecturePackage.eINSTANCE.getArchitectureFactory().createArchitectureTemplate();
			architectureTemplate.setGenerationPath(file.getProjectRelativePath().removeLastSegments(1).toString());
			architectureTemplate.setName(file.getName() + ".xpt");
			architectureTemplate.setPath(file.getProjectRelativePath().append(file.getName() + ".xpt").toString());
			
			ArchitectureModelHandle architectureModel = ArchitectureModelHandle.architectureModel(file.getProject());
			architectureModel.add().template(architectureTemplate);
			
			EcoreUtil.remove(architectureModel.get().clazz(file.getProjectRelativePath().toString()));
			
			architectureModel.save();			
		} catch (CoreException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		}		
	}	
}
