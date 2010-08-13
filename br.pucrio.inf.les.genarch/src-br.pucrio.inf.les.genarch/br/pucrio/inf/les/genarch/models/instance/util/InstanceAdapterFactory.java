/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance.util;

import br.pucrio.inf.les.genarch.models.instance.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage
 * @generated
 */
public class InstanceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InstancePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = InstancePackage.eINSTANCE;
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
	@Override
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
	protected InstanceSwitch<Adapter> modelSwitch =
		new InstanceSwitch<Adapter>() {
			@Override
			public Adapter caseInstance(Instance object) {
				return createInstanceAdapter();
			}
			@Override
			public Adapter caseArchitectureInstance(ArchitectureInstance object) {
				return createArchitectureInstanceAdapter();
			}
			@Override
			public Adapter caseArchitectureEntity(ArchitectureEntity object) {
				return createArchitectureEntityAdapter();
			}
			@Override
			public Adapter caseArchitectureComponent(ArchitectureComponent object) {
				return createArchitectureComponentAdapter();
			}
			@Override
			public Adapter caseArchitectureClass(ArchitectureClass object) {
				return createArchitectureClassAdapter();
			}
			@Override
			public Adapter caseArchitectureAspect(ArchitectureAspect object) {
				return createArchitectureAspectAdapter();
			}
			@Override
			public Adapter caseArchitectureFile(ArchitectureFile object) {
				return createArchitectureFileAdapter();
			}
			@Override
			public Adapter caseArchitectureFolder(ArchitectureFolder object) {
				return createArchitectureFolderAdapter();
			}
			@Override
			public Adapter caseArchitectureFragment(ArchitectureFragment object) {
				return createArchitectureFragmentAdapter();
			}
			@Override
			public Adapter caseArchitectureFragmentContainer(ArchitectureFragmentContainer object) {
				return createArchitectureFragmentContainerAdapter();
			}
			@Override
			public Adapter caseFeatureInstance(FeatureInstance object) {
				return createFeatureInstanceAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.Instance
	 * @generated
	 */
	public Adapter createInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance <em>Architecture Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance
	 * @generated
	 */
	public Adapter createArchitectureInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity <em>Architecture Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity
	 * @generated
	 */
	public Adapter createArchitectureEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent <em>Architecture Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent
	 * @generated
	 */
	public Adapter createArchitectureComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureClass <em>Architecture Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureClass
	 * @generated
	 */
	public Adapter createArchitectureClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect <em>Architecture Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect
	 * @generated
	 */
	public Adapter createArchitectureAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFile <em>Architecture File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFile
	 * @generated
	 */
	public Adapter createArchitectureFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder <em>Architecture Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder
	 * @generated
	 */
	public Adapter createArchitectureFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment <em>Architecture Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment
	 * @generated
	 */
	public Adapter createArchitectureFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer <em>Architecture Fragment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer
	 * @generated
	 */
	public Adapter createArchitectureFragmentContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.FeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.FeatureInstance
	 * @generated
	 */
	public Adapter createFeatureInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.instance.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
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

} //InstanceAdapterFactory
