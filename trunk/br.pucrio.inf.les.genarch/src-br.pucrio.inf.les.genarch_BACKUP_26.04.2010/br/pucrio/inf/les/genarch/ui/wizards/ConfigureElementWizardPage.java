package br.pucrio.inf.les.genarch.ui.wizards;

import java.net.URL;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class ConfigureElementWizardPage extends WizardPage {

	private IProject project;
	private EObject element;
	private MappingRelationships mappingRelationships;

	private Table featuresTable;
	private Text featureExpressionText;

	public ConfigureElementWizardPage(IProject project,EObject element) {
		super("wizardPage");
		this.setTitle("GenArch");

		this.project = project;
		this.element = element;
	}

	public void createControl(final Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);

		Composite featureModelContainer = new Composite(container,SWT.NULL);

		layout = new GridLayout();
		layout.numColumns = 1;
		featureModelContainer.setLayout(layout);

		Label label = new Label(featureModelContainer, SWT.NULL);
		label.setText("Feature Model");

		this.featuresTable = new Table(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		this.featuresTable.setLinesVisible(true);
		this.featuresTable.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent selectionEvent) {					
			}
			public void widgetSelected(SelectionEvent selectionEvent) {
				int countFeatures = ((new StringTokenizer(featureExpressionText.getText()," ")).countTokens() + 1) / 2;
				if ( ((Table)selectionEvent.getSource()).getSelectionCount() > countFeatures ) {
					//featureExpressionText.setText(addSelectionToFeatureExpression((TableItem)selectionEvent.item));
				} else {
					//featureExpressionText.setText(removeSelectionToFeatureExpression((TableItem)selectionEvent.item));
				}
			}			
		});

		TableColumn column = new TableColumn(this.featuresTable, SWT.LEFT);
		column.setWidth(400);		

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		this.featuresTable.setLayoutData(gd);

		this.addFeatureModel();

		Composite featureExpressionContainer = new Composite(container,SWT.NULL);

		layout = new GridLayout();
		layout.numColumns = 1;
		featureExpressionContainer.setLayout(layout);
		featureExpressionContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label featureExpressionLabel = new Label(featureExpressionContainer, SWT.NULL);
		featureExpressionLabel.setText("Feature Expression");

		this.featureExpressionText = new Text(featureExpressionContainer,SWT.BORDER);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;	
		this.featureExpressionText.setLayoutData(gd);

		this.featureExpressionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String featureExpression = featureExpressionText.getText();
				boolean v = Logic.validate(featureExpression); 
				if ( v ) {
					updateStatus(null);
				} else {
					updateStatus("The feature expression is not valid.");
				}
			}	    
		});

		this.initialize();	
		this.setControl(container);
	}

	public void addFeatureModel() {
		final GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		final String featureModelName = genarchProjectConfigurationFile.getFeatureModelPath();
		final String configurationModelName = genarchProjectConfigurationFile.getConfigurationModelPath();

		final IFile fmpModelFile = this.project.getFile(new Path(featureModelName));

		ConfigurationPackageImpl.init();

		IFile configurationModelFile = this.project.getFile(configurationModelName);
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString());

		ResourceSet configurationResourceSet = new ResourceSetImpl();
		Resource configurationResource = configurationResourceSet.getResource(configurationFileURI, true);

		Configuration configuration = (Configuration)configurationResource.getContents().get(0);
		this.mappingRelationships = configuration.getMappingRelationships();

		String elementPath = "";

		if ( element instanceof ArchitectureEntity ) {
			elementPath = ((ArchitectureEntity)element).getPath();
		} else if ( element instanceof ArchitectureComponent ) {
			elementPath = ((ArchitectureComponent)element).getPath();
		}

		EObject configurationElement = findConfigurationElementByPath(elementPath);

		String featureName = "";

		if ( configurationElement != null ) {
			if ( configurationElement instanceof MappingEntity ) {
				MappingEntity conf = (MappingEntity)configurationElement;
				if ( conf.getFeatureExpression() != null ) {
					featureName = conf.getFeatureExpression().getExpression();
				}		
			} else if ( configurationElement instanceof ConfigurationComponent ) {
				ConfigurationComponent conf = (ConfigurationComponent)configurationElement;
				if ( conf.getFeatureExpression() != null ) {
					featureName = conf.getFeatureExpression().getExpression();   
				}		
			}
		}

		Project fmpProject;

		if ( fmpModelFile.exists() ) {
			final FmpExternalLoader externalLoader = new FmpExternalLoader();
			externalLoader.load(fmpModelFile);
			final EList resourceList = externalLoader.getResources();
			final FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
			fmpProject = (Project)fmpResource.getAllContents().next();

			EList children = fmpProject.getModel().getChildren();
			Feature childold = (Feature)children.get(0);

			createTable(childold,featureName);	    
		}
	}

	private void createTable(Node proj, String featureName) {
		EList c = proj.getChildren();
		Iterator tree = c.iterator();

		int selectedIndex = -1;
		int count = 0;

		while(tree.hasNext()) {
			Object o = tree.next();

			if ( o instanceof Feature ) {
				Feature child = (Feature)o;
				TableItem item = new TableItem(this.featuresTable, SWT.NONE);

				if ( child.getName().equals(featureName)) {
					selectedIndex = count;
				}

				item.setText(child.getName());				
				ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL((URL)GenarchEMFPlugin.INSTANCE.getImage("full/arrow_obj"));				
				item.setImage(imageDescriptor.createImage());

				if ( child.getChildren() != null && child.getChildren().size() > 0 ) {
					createTable(child,featureName);
				}
			} else if ( o instanceof FeatureGroup ) {
				FeatureGroup child = (FeatureGroup)o;

				if ( child.getChildren() != null && child.getChildren().size() > 0 ) {
					createTable(child,featureName);
				}
			}
		}
	}

	private EObject findConfigurationElementByPath(String path) {	
		TreeIterator configurationContents = mappingRelationships.eAllContents();

		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();

			if ( o instanceof ArchitectureComponent ) {
				ArchitectureComponent component = (ArchitectureComponent)o;

				if ( component.getPath().equals(path) ) {
					return component;
				}
			} else if ( o instanceof MappingEntity ) {
				MappingEntity entity = (MappingEntity)o;

				if ( entity.getPath().equals(path) ) {
					return entity;
				}
			}
		}

		return null;
	}

	private void updateStatus(String message) {
		this.setErrorMessage(message);
		this.setPageComplete(message == null);
	}
	
	private String removeSelectionToFeatureExpression(TableItem item) {
		String selectText = item.getText();
		String featureExpression = featureExpressionText.getText();
		int selectTextIndex = featureExpression.indexOf(selectText);
		
		if ( selectTextIndex != -1 ) {
			String ls = featureExpression.substring(0,selectTextIndex - 2);
			ls = ls.substring(0,ls.lastIndexOf(" "));
			String rs = featureExpression.substring(selectTextIndex + selectText.length(),featureExpression.length());
			return ls + rs;
		}
		
		return featureExpression;
	}

	private String addSelectionToFeatureExpression(TableItem item) {
		/*TableItem[] itens = this.featuresTable.getSelection();
		StringBuilder builder = new StringBuilder(featureExpressionText.getText());

		for ( int x = 0; x < itens.length-1; x++ ) {
			builder.append(itens[x].getText() + " and ");
		}

		builder.append(itens[itens.length-1].getText());

		return builder.toString();*/

		StringBuilder builder = new StringBuilder(featureExpressionText.getText());

		if (builder.length() > 0) {
			builder.append(" and ");
		}

		builder.append(item.getText());

		return builder.toString();
	}

	public String getFeatureExpression() {
		return featureExpressionText.getText();
	}

	private void initialize() {

	}
}