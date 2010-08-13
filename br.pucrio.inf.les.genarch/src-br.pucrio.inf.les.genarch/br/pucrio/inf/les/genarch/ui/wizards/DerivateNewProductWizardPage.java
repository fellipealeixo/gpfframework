package br.pucrio.inf.les.genarch.ui.wizards;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.wizards.TypedViewerFilter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.Separator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.JavaElementSorter;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class DerivateNewProductWizardPage extends WizardPage {

	private Text projectNameText;
	private Table featureConfigurationsTable;

	private IProject project;

	public DerivateNewProductWizardPage(final IProject project) {
		super("wizardPage");
		this.setTitle("Genarch!!!!!!!!!!!!!!");

		this.project = project;		
	}

	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		final GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;

		Label label = new Label(container, SWT.NULL);
		label.setText("&Project:");

		this.projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		this.projectNameText.setLayoutData(gd);
		this.projectNameText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				DerivateNewProductWizardPage.this.dialogChanged();
			}
		});

		final Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				DerivateNewProductWizardPage.this.handleBrowseProject();
			}
		});

		new Separator(SWT.SEPARATOR | SWT.HORIZONTAL).doFillIntoGrid(container, 3);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;

		label = new Label(container, SWT.NULL);
		label.setText("Configurations");
		label.setLayoutData(gd);

		this.featureConfigurationsTable = new Table(container, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
		final TableColumn column = new TableColumn(this.featureConfigurationsTable, SWT.LEFT);
		column.setWidth(200);

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		this.featureConfigurationsTable.setLayoutData(gd);

		this.featureConfigurationsTable.addSelectionListener(new MySelectionListener());

		this.addFeatureModelConfigurations();

		this.initialize();
		this.dialogChanged();
		this.setControl(container);
	}

	private void initialize() {

	}

	public void addFeatureModelConfigurations() {
		final GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		final String featureModelName = genarchProjectConfigurationFile.getFeatureModelPath();

		final IFile fmpModelFile = this.project.getFile(new Path(featureModelName));

		Project fmpProject;

		if ( fmpModelFile.exists() ) {
			final FmpExternalLoader externalLoader = new FmpExternalLoader();
			externalLoader.load(fmpModelFile);
			final EList resourceList = externalLoader.getResources();
			final FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
			fmpProject = (Project)fmpResource.getAllContents().next();

			final EList children = ((Feature)fmpProject.getModel().getChildren().get(0)).getConfs();

			for ( int x = 0; x < children.size(); x++ ) {
				final Feature child = (Feature)children.get(x);
				final TableItem item = new TableItem(this.featureConfigurationsTable, SWT.NONE);
				item.setText("Configuration " + (x+1) + " of " + child.getName());				
				final ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL((URL)GenarchEMFPlugin.INSTANCE.getImage("full/ConfRootFeature"));				
				item.setImage(imageDescriptor.createImage());
			}
		}
	}

	private void handleBrowseProject() {
		final StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		final ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(this.getShell(), labelProvider, provider);

		final Class[] acceptedClasses = new Class[] { IJavaProject.class };
		final ViewerFilter filter = new TypedViewerFilter(acceptedClasses);

		dialog.setSorter(new JavaElementSorter());
		dialog.setTitle("Genarch!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		dialog.setMessage(""); 
		dialog.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		dialog.addFilter(filter);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			final Object element= dialog.getFirstResult();
			if (element instanceof IJavaProject) {
				final IJavaProject project = (IJavaProject)element;
				this.projectNameText.setText(project.getElementName());
			}					
		}
	}

	private void dialogChanged() {
		final IResource project = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(this.getProjectName()));
		
		if (this.getProjectName().length() == 0) {
			this.updateStatus("Project must be specified");
			return;
		}

		if ((project == null) || ((project.getType() & IResource.PROJECT) == 0)) {
			this.updateStatus("Project must exist");
			return;
		}

		if ( this.featureConfigurationsTable.getSelectionCount() == 0 ) {
			this.updateStatus("One feature configuration need to be selected.");
			return;
		}

		this.updateStatus(null);
	}

	private void updateStatus(final String message) {
		this.setErrorMessage(message);
		this.setPageComplete(message == null);
	}
	
	public String getProjectName() {
		return this.projectNameText.getText();
	}

	public int getFeatureModelConfigurationIndex() {
		return this.featureConfigurationsTable.getSelectionIndex();
	}
	
	public String getFeatureModelConfigurationName() {
		String configurationName = this.featureConfigurationsTable.getSelection()[0].getText();
		int configurationIndex = this.featureConfigurationsTable.getSelectionIndex() + 1;
		
		int configurationIndexPos = configurationName.indexOf(String.valueOf(configurationIndex));
		configurationIndexPos = configurationIndexPos + String.valueOf(configurationIndex).length() + 4;
		String projectName = configurationName.substring(configurationIndexPos, configurationName.length());
		
		return projectName;
	}

	private class MySelectionListener implements SelectionListener {

		public void widgetDefaultSelected(final SelectionEvent e) {

		}

		public void widgetSelected(final SelectionEvent e) {
			DerivateNewProductWizardPage.this.dialogChanged();			
		}		
	}
}