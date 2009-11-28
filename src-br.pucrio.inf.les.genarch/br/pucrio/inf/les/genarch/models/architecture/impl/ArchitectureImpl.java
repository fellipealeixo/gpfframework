/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl#getContainers <em>Containers</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl#getResourcesContainer <em>Resources Container</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl#getFragmentsContainer <em>Fragments Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureImpl extends EObjectImpl implements Architecture {
	/**
	 * The cached value of the '{@link #getContainers() <em>Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainers()
	 * @generated
	 * @ordered
	 */
	protected EList containers;

	/**
	 * The cached value of the '{@link #getResourcesContainer() <em>Resources Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcesContainer()
	 * @generated
	 * @ordered
	 */
	protected EList resourcesContainer;

	/**
	 * The cached value of the '{@link #getFragmentsContainer() <em>Fragments Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragmentsContainer()
	 * @generated
	 * @ordered
	 */
	protected EList fragmentsContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContainers() {
		if (containers == null) {
			containers = new EObjectContainmentEList(ArchitectureContainer.class, this, ArchitecturePackage.ARCHITECTURE__CONTAINERS);
		}
		return containers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourcesContainer() {
		if (resourcesContainer == null) {
			resourcesContainer = new EObjectContainmentEList(ArchitectureResourcesContainer.class, this, ArchitecturePackage.ARCHITECTURE__RESOURCES_CONTAINER);
		}
		return resourcesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFragmentsContainer() {
		if (fragmentsContainer == null) {
			fragmentsContainer = new EObjectContainmentEList(ArchitectureFragmentContainer.class, this, ArchitecturePackage.ARCHITECTURE__FRAGMENTS_CONTAINER);
		}
		return fragmentsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE__CONTAINERS:
				return ((InternalEList)getContainers()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE__RESOURCES_CONTAINER:
				return ((InternalEList)getResourcesContainer()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE__FRAGMENTS_CONTAINER:
				return ((InternalEList)getFragmentsContainer()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE__CONTAINERS:
				return getContainers();
			case ArchitecturePackage.ARCHITECTURE__RESOURCES_CONTAINER:
				return getResourcesContainer();
			case ArchitecturePackage.ARCHITECTURE__FRAGMENTS_CONTAINER:
				return getFragmentsContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE__CONTAINERS:
				getContainers().clear();
				getContainers().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE__RESOURCES_CONTAINER:
				getResourcesContainer().clear();
				getResourcesContainer().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE__FRAGMENTS_CONTAINER:
				getFragmentsContainer().clear();
				getFragmentsContainer().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE__CONTAINERS:
				getContainers().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE__RESOURCES_CONTAINER:
				getResourcesContainer().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE__FRAGMENTS_CONTAINER:
				getFragmentsContainer().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE__CONTAINERS:
				return containers != null && !containers.isEmpty();
			case ArchitecturePackage.ARCHITECTURE__RESOURCES_CONTAINER:
				return resourcesContainer != null && !resourcesContainer.isEmpty();
			case ArchitecturePackage.ARCHITECTURE__FRAGMENTS_CONTAINER:
				return fragmentsContainer != null && !fragmentsContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureImpl
