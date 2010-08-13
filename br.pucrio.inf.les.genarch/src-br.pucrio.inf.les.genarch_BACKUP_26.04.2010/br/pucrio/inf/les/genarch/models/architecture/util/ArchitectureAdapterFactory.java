/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.util;

import br.pucrio.inf.les.genarch.models.architecture.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage
 * @generated
 */
public class ArchitectureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ArchitecturePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ArchitecturePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureSwitch modelSwitch =
		new ArchitectureSwitch() {
			public Object caseArchitecture(Architecture object) {
				return createArchitectureAdapter();
			}
			public Object caseArchitectureContainer(ArchitectureContainer object) {
				return createArchitectureContainerAdapter();
			}
			public Object caseArchitectureResourcesContainer(ArchitectureResourcesContainer object) {
				return createArchitectureResourcesContainerAdapter();
			}
			public Object caseArchitectureFragmentContainer(ArchitectureFragmentContainer object) {
				return createArchitectureFragmentContainerAdapter();
			}
			public Object caseArchitectureEntity(ArchitectureEntity object) {
				return createArchitectureEntityAdapter();
			}
			public Object caseArchitectureComponent(ArchitectureComponent object) {
				return createArchitectureComponentAdapter();
			}
			public Object caseArchitectureClass(ArchitectureClass object) {
				return createArchitectureClassAdapter();
			}
			public Object caseArchitectureAspect(ArchitectureAspect object) {
				return createArchitectureAspectAdapter();
			}
			public Object caseArchitectureFile(ArchitectureFile object) {
				return createArchitectureFileAdapter();
			}
			public Object caseArchitectureTemplate(ArchitectureTemplate object) {
				return createArchitectureTemplateAdapter();
			}
			public Object caseArchitectureFolder(ArchitectureFolder object) {
				return createArchitectureFolderAdapter();
			}
			public Object caseArchitectureFragment(ArchitectureFragment object) {
				return createArchitectureFragmentAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.Architecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.Architecture
	 * @generated
	 */
	public Adapter createArchitectureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer
	 * @generated
	 */
	public Adapter createArchitectureContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer <em>Resources Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer
	 * @generated
	 */
	public Adapter createArchitectureResourcesContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer <em>Fragment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer
	 * @generated
	 */
	public Adapter createArchitectureFragmentContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity
	 * @generated
	 */
	public Adapter createArchitectureEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent
	 * @generated
	 */
	public Adapter createArchitectureComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass
	 * @generated
	 */
	public Adapter createArchitectureClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect
	 * @generated
	 */
	public Adapter createArchitectureAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile
	 * @generated
	 */
	public Adapter createArchitectureFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate
	 * @generated
	 */
	public Adapter createArchitectureTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder
	 * @generated
	 */
	public Adapter createArchitectureFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment
	 * @generated
	 */
	public Adapter createArchitectureFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ArchitectureAdapterFactory
