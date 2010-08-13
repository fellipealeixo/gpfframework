package br.pucrio.inf.les.genarch.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.wizards.TypedElementSelectionValidator;
import org.eclipse.jdt.internal.ui.wizards.TypedViewerFilter;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.JavaElementSorter;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.operations.ConvertOperation;

public class ConvertToGenarchProjectAction implements IObjectActionDelegate {

	private ISelection fSelection;
	public ConvertToGenarchProjectAction() {
		super();
	}

	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {		
	}

	public void run(final IAction action) {

		if(this.fSelection instanceof StructuredSelection) {
			Object element = ((StructuredSelection)this.fSelection).getFirstElement();
			if(element instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable) element;
				IResource resource = (IResource) adaptable.getAdapter(IResource.class);
				if(resource != null) {					
					final IProject project = resource.getProject();
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

					StandardJavaElementContentProvider provider= new StandardJavaElementContentProvider();
					ILabelProvider labelProvider= new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
					ElementTreeSelectionDialog dialog= new ElementTreeSelectionDialog(shell, labelProvider, provider);

					Class[] acceptedClasses = new Class[] { IPackageFragmentRoot.class, IJavaProject.class, IFolder.class };
					TypedElementSelectionValidator validator = new TypedElementSelectionValidator(acceptedClasses, true) {
						public boolean isSelectedValid(Object element) {
							try {
								if (element instanceof IJavaProject) {
									IJavaProject jproject = (IJavaProject)element;
									IPath path = jproject.getProject().getFullPath();				 
									return (jproject.findPackageFragmentRoot(path) != null);
								} else if (element instanceof IPackageFragmentRoot) {
									return (((IPackageFragmentRoot)element).getKind() == IPackageFragmentRoot.K_SOURCE);
								} else if (element instanceof IFolder ) {
									return true;
								}
								return true;
							} catch (JavaModelException e) {
								GenarchEMFPlugin.INSTANCE.log(e);
							}
							return false;
						}
					};

					acceptedClasses = new Class[] { IJavaModel.class, IPackageFragmentRoot.class, IJavaProject.class, IFolder.class };
					ViewerFilter filter = new TypedViewerFilter(acceptedClasses) {
						public boolean select(Viewer viewer, Object parent, Object element) {
							if (element instanceof IPackageFragmentRoot) {
								try {
									return (((IPackageFragmentRoot)element).getKind() == IPackageFragmentRoot.K_SOURCE);
								} catch (JavaModelException e) {
									GenarchEMFPlugin.INSTANCE.log(e);
									return false;
								}
							} else if ( element instanceof IJavaProject ) {
								return ((IJavaProject)element).getProject().getName().equals(project.getName());
							}
							return super.select(viewer, parent, element);
						}
					};

					dialog.setSorter(new JavaElementSorter());
					dialog.setValidator(validator);
					dialog.setTitle(""); 
					dialog.setMessage(""); 
					dialog.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
					dialog.addFilter(filter);
					dialog.setHelpAvailable(false);
					dialog.setAllowMultiple(true);

					if (dialog.open() == Window.OK) {
						Object[] e = dialog.getResult();
						List<String> sourceContainers = new ArrayList<String>();
						List<String> resourceContainers = new ArrayList<String>();

						for ( int x = 0; x < e.length; x++ ) {
							Object eb = e[x];
							if ( eb instanceof IPackageFragmentRoot) {
								IPackageFragmentRoot javaElement = (IPackageFragmentRoot)eb;
								sourceContainers.add(javaElement.getElementName());
							} else if ( eb instanceof IFolder ) {
								IFolder folder = (IFolder)eb;
								resourceContainers.add(folder.getName());
							}
						}			

						final ConvertOperation runnable = new ConvertOperation(project,sourceContainers,resourceContainers);

						try {
							PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
						} catch (final InvocationTargetException ex) {
							ex.printStackTrace();
							GenarchEMFPlugin.INSTANCE.log(ex);
						} catch (final InterruptedException ex) {
							ex.printStackTrace();
							GenarchEMFPlugin.INSTANCE.log(ex);
						}
					}		   
				}
			}
		}
	}

	public void selectionChanged(final IAction action, final ISelection selection) {
		this.fSelection = selection;
	}

	public void dispose() {

	}	
}
