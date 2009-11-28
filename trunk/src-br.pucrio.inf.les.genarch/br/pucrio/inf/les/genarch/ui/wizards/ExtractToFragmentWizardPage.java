package br.pucrio.inf.les.genarch.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.provider.ArchitectureItemProviderAdapterFactory;

public class ExtractToFragmentWizardPage extends WizardPage {
	
	private Text fragmentNameText;
	private IProject project;
	
	private Tree implementationModelTree;
	private TreeViewer implementationModelTreeViewer;
	
	private Text featureExpressionText;
	
	protected ExtractToFragmentWizardPage(String pageName,IProject project) {
		super(pageName);
		this.project = project;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
						
		Composite fragmentTextContainer = new Composite(container,SWT.NULL);

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		
		layout = new GridLayout();
		layout.numColumns = 1;
		fragmentTextContainer.setLayout(layout);
		fragmentTextContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label fragmentTextLabel = new Label(fragmentTextContainer, SWT.NULL);
		fragmentTextLabel.setText("Fragment Name");

		this.fragmentNameText = new Text(fragmentTextContainer,SWT.BORDER);							
		this.fragmentNameText.setLayoutData(gd);
		this.fragmentNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				
			}	    
		});

		Composite implementationModelContainer = new Composite(container,SWT.NULL);

		layout = new GridLayout();
		layout.numColumns = 1;
		implementationModelContainer.setLayout(layout);
		implementationModelContainer.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label label = new Label(implementationModelContainer, SWT.NULL);
		label.setText("Fragment Container");

		this.implementationModelTree = new Tree(implementationModelContainer, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		FillLayout fillLayout = new FillLayout();
		this.implementationModelTree.setLayout(fillLayout);
		this.implementationModelTree.setHeaderVisible(true);
		this.implementationModelTree.setLinesVisible(true);
		this.implementationModelTree.setLayoutData(gd);
			
		this.implementationModelTreeViewer = new TreeViewer(this.implementationModelTree);
		
		TreeColumn column = new TreeColumn(this.implementationModelTree, SWT.LEFT);		
		column.setText("Implementation Model");
		column.setResizable(true);
		column.setWidth(250);
		
		List factories = new ArrayList();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ArchitectureItemProviderAdapterFactory());
																
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(factories);
				
		ViewerFilter filter = new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parent, Object element) {
				if (element instanceof ArchitectureFragmentContainer) {
					return true;
				}
				return false;
			}
		};
		
		this.implementationModelTreeViewer.setFilters(new ViewerFilter[] {filter});
		this.implementationModelTreeViewer.setColumnProperties(new String [] {"a"});
		this.implementationModelTreeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		this.implementationModelTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
				
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		String implementationModelPath = genarchProjectConfigurationFile.getArchitectureModelPath();	
		IFile implementationModelFile = this.project.getFile(implementationModelPath);
		URI implementationFileURI = URI.createPlatformResourceURI(implementationModelFile.getFullPath().toString());

		ResourceSet implementationResourceSet = new ResourceSetImpl();
		Resource implementationResource = implementationResourceSet.getResource(implementationFileURI, true);

		this.implementationModelTreeViewer.setInput(implementationResource.getContents().get(0));
		
		Composite featureExpressionTextContainer = new Composite(container,SWT.NULL);

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		
		layout = new GridLayout();
		layout.numColumns = 1;
		featureExpressionTextContainer.setLayout(layout);
		featureExpressionTextContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label featureExpressionLabel = new Label(fragmentTextContainer, SWT.NULL);
		featureExpressionLabel.setText("Feature Expression");

		this.featureExpressionText = new Text(featureExpressionTextContainer,SWT.BORDER);							
		this.featureExpressionText.setLayoutData(gd);
		this.featureExpressionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				
			}	    
		});
		
		this.setControl(container);
	}
	
	public String getFragmentName() {
		return this.fragmentNameText.getText();
	}
	
	public String getFragmentContainerName() {
		return ((TreeItem)this.implementationModelTree.getSelection()[0]).getText();
	}

	public String getFeatureExpression() {
		return featureExpressionText.getText();
	}

	public void setFeatureExpressionText(Text featureExpressionText) {
		this.featureExpressionText = featureExpressionText;
	}
}
