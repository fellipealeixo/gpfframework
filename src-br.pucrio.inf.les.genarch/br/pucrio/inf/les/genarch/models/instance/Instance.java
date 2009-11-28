/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.Instance#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.Instance#getFeatureInstance <em>Feature Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getInstance()
 * @model
 * @generated
 */
public interface Instance extends EObject {
	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Architecture</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architecture</em>' containment reference.
	 * @see #setArchitecture(ArchitectureInstance)
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getInstance_Architecture()
	 * @model containment="true"
	 * @generated
	 */
	ArchitectureInstance getArchitecture();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.instance.Instance#getArchitecture <em>Architecture</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' containment reference.
	 * @see #getArchitecture()
	 * @generated
	 */
	void setArchitecture(ArchitectureInstance value);

	/**
	 * Returns the value of the '<em><b>Feature Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Instance</em>' containment reference.
	 * @see #setFeatureInstance(FeatureInstance)
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getInstance_FeatureInstance()
	 * @model containment="true"
	 * @generated
	 */
	FeatureInstance getFeatureInstance();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.instance.Instance#getFeatureInstance <em>Feature Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Instance</em>' containment reference.
	 * @see #getFeatureInstance()
	 * @generated
	 */
	void setFeatureInstance(FeatureInstance value);

} // Instance
