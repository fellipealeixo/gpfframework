/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getClasses <em>Classes</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getAspects <em>Aspects</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getSubComponents <em>Sub Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureComponent()
 * @model
 * @generated
 */
public interface ArchitectureComponent extends ArchitectureEntity {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureComponent_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureClass> getClasses();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureComponent_Aspects()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureComponent_Files()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureFile> getFiles();

	/**
	 * Returns the value of the '<em><b>Sub Components</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Components</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureComponent_SubComponents()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureComponent> getSubComponents();

} // ArchitectureComponent
