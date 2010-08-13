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
 * A representation of the model object '<em><b>Mapping Relationships</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getContainers <em>Containers</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getResourcesContainers <em>Resources Containers</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getFragmentsContainer <em>Fragments Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getMappingRelationships()
 * @model
 * @generated
 */
public interface MappingRelationships extends EObject {
	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getMappingRelationships_Containers()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer" containment="true"
	 * @generated
	 */
	EList getContainers();

	/**
	 * Returns the value of the '<em><b>Resources Containers</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources Containers</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getMappingRelationships_ResourcesContainers()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer" containment="true"
	 * @generated
	 */
	EList getResourcesContainers();

	/**
	 * Returns the value of the '<em><b>Fragments Container</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments Container</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getMappingRelationships_FragmentsContainer()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer" containment="true"
	 * @generated
	 */
	EList getFragmentsContainer();

} // MappingRelationships
