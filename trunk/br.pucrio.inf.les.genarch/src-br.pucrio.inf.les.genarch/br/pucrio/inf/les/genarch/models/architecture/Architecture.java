/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.Architecture#getContainers <em>Containers</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.Architecture#getResourcesContainer <em>Resources Container</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.Architecture#getFragmentsContainer <em>Fragments Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitecture()
 * @model
 * @generated
 */
public interface Architecture extends EObject {
	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitecture_Containers()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer" containment="true"
	 * @generated
	 */
	EList getContainers();

	/**
	 * Returns the value of the '<em><b>Resources Container</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources Container</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitecture_ResourcesContainer()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer" containment="true"
	 * @generated
	 */
	EList getResourcesContainer();

	/**
	 * Returns the value of the '<em><b>Fragments Container</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments Container</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitecture_FragmentsContainer()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer" containment="true"
	 * @generated
	 */
	EList getFragmentsContainer();

} // Architecture
