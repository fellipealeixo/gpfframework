/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getSubFolders <em>Sub Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationFolder()
 * @model
 * @generated
 */
public interface ConfigurationFolder extends MappingEntity {
	/**
	 * Returns the value of the '<em><b>Sub Folders</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Folders</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationFolder_SubFolders()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder" containment="true"
	 * @generated
	 */
	EList getSubFolders();

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
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationFolder_Files()
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
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationFolder_Templates()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate" containment="true"
	 * @generated
	 */
	EList getTemplates();

} // ConfigurationFolder
