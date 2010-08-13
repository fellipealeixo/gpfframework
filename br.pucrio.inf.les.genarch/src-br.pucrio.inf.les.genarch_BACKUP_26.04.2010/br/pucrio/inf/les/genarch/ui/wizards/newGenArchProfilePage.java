package br.pucrio.inf.les.genarch.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class newGenArchProfilePage extends WizardPage {

    private Text projectName;
    
    public newGenArchProfilePage() {
	super("wizardPage");
	this.setTitle("Geanarch");
    }

    public void createControl(final Composite parent) {
	final Composite container = new Composite(parent, SWT.NULL);
	final GridLayout layout = new GridLayout();
	container.setLayout(layout);
	layout.numColumns = 2;

	Label label = new Label(container, SWT.NULL);
	label.setText("&Project Name:");

	this.projectName = new Text(container, SWT.BORDER | SWT.SINGLE);
	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	this.projectName.setLayoutData(gd);

	this.initialize();	
	this.setControl(container);
    }

    private void initialize() {

    }
    
    public String getProjectName() {
	return this.projectName.getText();
    }
}