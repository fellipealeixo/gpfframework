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
 * A representation of the model object '<em><b>Resources Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getFolders <em>Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationResourcesContainer()
 * @model
 * @generated
 */
public interface ConfigurationResourcesContainer extends EObject {
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
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationResourcesContainer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Folders</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationResourcesContainer_Folders()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder" containment="true"
	 * @generated
	 */
	EList getFolders();

	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationResourcesContainer_Files()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile" containment="true"
	 * @generated
	 */
	EList getFiles();

	/**
	 * Returns the value of the '<em><b>Templates</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Templates</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationResourcesContainer_Templates()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate" containment="true"
	 * @generated
	 */
	EList getTemplates();

} // ConfigurationResourcesContainer
