package br.pucrio.inf.les.genarch.ui.wizards;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class DerivateNewProductAsBuildersWizardPage extends WizardPage {

	private Text folderPathText;
	private Table featureConfigurationsTable;

	private IProject project;

	public DerivateNewProductAsBuildersWizardPage(final IProject project) {
		super("wizardPage");
		this.setTitle("Geanarch");

		this.project = project;		
	}

	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		final GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;

		Label label = new Label(container, SWT.NULL);
		label.setText("&Folder:");

		this.folderPathText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		this.folderPathText.setLayoutData(gd);
		this.folderPathText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				DerivateNewProductAsBuildersWizardPage.this.dialogChanged();
			}
		});

		final Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				DerivateNewProductAsBuildersWizardPage.this.handleBrowseProject();
			}
		});

		new Separator(SWT.SEPARATOR | SWT.HORIZONTAL).doFillIntoGrid(container, 3);

		/*gd = new GridData(GridData.FILL_HORIZONTAL);
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

		this.addFeatureModelConfigurations();*/

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
				item.setText("Configuration " + x + " of " + child.getName());				
				final ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL((URL)GenarchEMFPlugin.INSTANCE.getImage("full/ConfRootFeature"));				
				item.setImage(imageDescriptor.createImage());
			}
		}
	}

	private void handleBrowseProject() {
		final StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		final ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(this.getShell(), labelProvider, provider);

		final Class[] acceptedClasses = new Class[] { IJavaProject.class,IFolder.class };
		final ViewerFilter filter = new TypedViewerFilter(acceptedClasses);

		dialog.setSorter(new JavaElementSorter());
		dialog.setTitle("");
		dialog.setMessage(""); 
		dialog.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		dialog.addFilter(filter);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			final Object element= dialog.getFirstResult();
			if (element instanceof IFolder) {
				final IFolder folder = (IFolder)element;
				this.folderPathText.setText(folder.getProjectRelativePath().toString());
			}					
		}
	}

	private void dialogChanged() {
		final IResource folder = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(this.getFolderPath()));
		
		if (this.getFolderPath().length() == 0) {
			this.updateStatus("The folder must be specified");
			return;
		}
				
		this.updateStatus(null);
	}

	private void updateStatus(final String message) {
		this.setErrorMessage(message);
		this.setPageComplete(message == null);
	}
	
	public String getFolderPath() {
		return this.folderPathText.getText();
	}

	public String getFeatureModelConfiguration() {
		return this.featureConfigurationsTable.getSelection()[0].getText();
	}

	private class MySelectionListener implements SelectionListener {

		public void widgetDefaultSelected(final SelectionEvent e) {

		}

		public void widgetSelected(final SelectionEvent e) {
			DerivateNewProductAsBuildersWizardPage.this.dialogChanged();			
		}		
	}
}