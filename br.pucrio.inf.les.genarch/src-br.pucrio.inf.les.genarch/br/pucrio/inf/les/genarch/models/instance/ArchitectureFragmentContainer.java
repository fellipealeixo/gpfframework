/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Fragment Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getFragments <em>Fragments</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureFragmentContainer()
 * @model
 * @generated
 */
public interface ArchitectureFragmentContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureFragmentContainer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureFragmentContainer_Fragments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureFragment> getFragments();

} // ArchitectureFragmentContainer
