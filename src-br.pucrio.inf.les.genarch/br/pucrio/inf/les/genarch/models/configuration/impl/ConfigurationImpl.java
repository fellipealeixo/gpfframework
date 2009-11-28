/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.impl;

import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationImpl#getMappingRelationships <em>Mapping Relationships</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getMappingRelationships() <em>Mapping Relationships</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingRelationships()
	 * @generated
	 * @ordered
	 */
	protected MappingRelationships mappingRelationships;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRelationships getMappingRelationships() {
		return mappingRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingRelationships(MappingRelationships newMappingRelationships, NotificationChain msgs) {
		MappingRelationships oldMappingRelationships = mappingRelationships;
		mappingRelationships = newMappingRelationships;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS, oldMappingRelationships, newMappingRelationships);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingRelationships(MappingRelationships newMappingRelationships) {
		if (newMappingRelationships != mappingRelationships) {
			NotificationChain msgs = null;
			if (mappingRelationships != null)
				msgs = ((InternalEObject)mappingRelationships).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS, null, msgs);
			if (newMappingRelationships != null)
				msgs = ((InternalEObject)newMappingRelationships).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS, null, msgs);
			msgs = basicSetMappingRelationships(newMappingRelationships, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS, newMappingRelationships, newMappingRelationships));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS:
				return basicSetMappingRelationships(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS:
				return getMappingRelationships();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS:
				setMappingRelationships((MappingRelationships)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS:
				setMappingRelationships((MappingRelationships)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION__MAPPING_RELATIONSHIPS:
				return mappingRelationships != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
