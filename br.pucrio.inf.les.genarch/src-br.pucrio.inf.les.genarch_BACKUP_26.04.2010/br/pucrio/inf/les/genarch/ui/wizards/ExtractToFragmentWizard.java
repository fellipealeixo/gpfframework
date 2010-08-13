package br.pucrio.inf.les.genarch.ui.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationFragmentBuilder;
import br.pucrio.inf.les.genarch.core.models.dsl.configuration.ConfigurationModelHandle;
import br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureFragmentBuilder;
import br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureModelHandle;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer;

public class ExtractToFragmentWizard extends Wizard implements INewWizard {

	private ExtractToFragmentWizardPage extractToFragmentWizardPage;
	private ITextSelection selecion;
	private IProject project;
	private IFile file;

	public ExtractToFragmentWizard(IFile file,ITextSelection selection) {
		this.project = file.getProject();
		this.file = file;
		this.selecion = selection;
		this.extractToFragmentWizardPage = new ExtractToFragmentWizardPage("Extract Fragment Page",project);
	}

	public void addPages() {
		this.addPage(this.extractToFragmentWizardPage);
	}

	public boolean performFinish() {
		String fragmentName = this.extractToFragmentWizardPage.getFragmentName();
		String fragmentContainerName = this.extractToFragmentWizardPage.getFragmentContainerName();
		String featureExpression = this.extractToFragmentWizardPage.getFeatureExpression();

		fragmentContainerName = fragmentContainerName.substring("Fragment Container".length()+1,fragmentContainerName.length());

		ArchitectureModelHandle architectureModelHandle = ArchitectureModelHandle.architectureModel(this.project);
		ArchitectureFragmentContainer fragmentContainer = architectureModelHandle.get().fragmentContainer(fragmentContainerName);
		ArchitectureFragment implementationFragment = ArchitectureFragmentBuilder.implementationFragment().name(fragmentName).path(fragmentContainerName + "/" + fragmentName).content(this.selecion.getText()).build();
		fragmentContainer.getFragments().add(implementationFragment);
		architectureModelHandle.save();
		
		ConfigurationModelHandle configurationModelHandle = ConfigurationModelHandle.configurationModel(this.project);
		ConfigurationFragmentContainer configurationFragmentContainer = configurationModelHandle.get().fragmentContainer(fragmentContainerName);
		ConfigurationFragment configurationFragment = ConfigurationFragmentBuilder.configurationFragment().name(fragmentName).path(fragmentContainerName + "/" + fragmentName).featureExpression(featureExpression).build();
		configurationFragmentContainer.getFragments().add(configurationFragment);
		configurationModelHandle.save();
		

		try {			
			InputStream fileContentInputStream = file.getContents();

			StringBuffer stringContent = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(fileContentInputStream));
			String line = "";

			while ( (line = in.readLine()) != null ) {
				stringContent.append(line);
				stringContent.append("\n");				
			}
			
			String first = stringContent.substring(0,selecion.getOffset());
			String last = stringContent.substring(selecion.getOffset() + selecion.getLength(),stringContent.length());
			String comment = "«REM»Code extracted to '" + implementationFragment.getPath() + "' frament«ENDREM»";
			String letCode = "«LET fragment(\"" + implementationFragment.getPath() + "\",architecture) AS e»«e.content»«ENDLET»";
			String content = comment + "\n" + letCode;
						
			ByteArrayInputStream newInputStream = new ByteArrayInputStream((first + content + last).getBytes());

			try {
				if ( file.exists() ) {
					file.setContents(newInputStream, true, true, new NullProgressMonitor());					
				} else {
					file.create(newInputStream, true, new NullProgressMonitor());
				}
			} catch (final CoreException e) {
				e.printStackTrace();
			}

			fileContentInputStream.close();

		} catch (CoreException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return true;
	}

	public void init(IWorkbench arg0, IStructuredSelection arg1) {

	}
}
