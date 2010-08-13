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
 * A representation of the model object '<em><b>Architecture Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getClasses <em>Classes</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getAspects <em>Aspects</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getComponents <em>Components</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFolders <em>Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFragments <em>Fragments</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFragmentContainers <em>Fragment Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance()
 * @model
 * @generated
 */
public interface ArchitectureInstance extends EObject {
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
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_Classes()
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
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_Aspects()
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
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_Files()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureFile> getFiles();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureComponent> getComponents();

	/**
	 * Returns the value of the '<em><b>Folders</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_Folders()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureFolder> getFolders();

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
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_Fragments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureFragment> getFragments();

	/**
	 * Returns the value of the '<em><b>Fragment Containers</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment Containers</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureInstance_FragmentContainers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureFragmentContainer> getFragmentContainers();

} // ArchitectureInstance
