/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationContainer()
 * @model
 * @generated
 */
public interface ConfigurationContainer extends EObject {
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
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationContainer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationContainer_Components()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent" containment="true"
	 * @generated
	 */
	EList getComponents();

} // ConfigurationContainer
