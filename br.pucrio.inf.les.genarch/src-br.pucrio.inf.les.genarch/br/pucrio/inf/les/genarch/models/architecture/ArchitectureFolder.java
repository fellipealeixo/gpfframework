/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getSubFolders <em>Sub Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureFolder()
 * @model
 * @generated
 */
public interface ArchitectureFolder extends ArchitectureEntity {
	/**
	 * Returns the value of the '<em><b>Sub Folders</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Folders</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureFolder_SubFolders()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder" containment="true"
	 * @generated
	 */
	EList getSubFolders();

	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureFolder_Files()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile" containment="true"
	 * @generated
	 */
	EList getFiles();

	/**
	 * Returns the value of the '<em><b>Templates</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Templates</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureFolder_Templates()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate" containment="true"
	 * @generated
	 */
	EList getTemplates();

} // ArchitectureFolder
