/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance.impl;

import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.FeatureInstance;
import br.pucrio.inf.les.genarch.models.instance.Instance;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.InstanceImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.InstanceImpl#getFeatureInstance <em>Feature Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceImpl extends EObjectImpl implements Instance {
	/**
	 * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected ArchitectureInstance architecture;

	/**
	 * The cached value of the '{@link #getFeatureInstance() <em>Feature Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureInstance()
	 * @generated
	 * @ordered
	 */
	protected FeatureInstance featureInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureInstance getArchitecture() {
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArchitecture(ArchitectureInstance newArchitecture, NotificationChain msgs) {
		ArchitectureInstance oldArchitecture = architecture;
		architecture = newArchitecture;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InstancePackage.INSTANCE__ARCHITECTURE, oldArchitecture, newArchitecture);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchitecture(ArchitectureInstance newArchitecture) {
		if (newArchitecture != architecture) {
			NotificationChain msgs = null;
			if (architecture != null)
				msgs = ((InternalEObject)architecture).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InstancePackage.INSTANCE__ARCHITECTURE, null, msgs);
			if (newArchitecture != null)
				msgs = ((InternalEObject)newArchitecture).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InstancePackage.INSTANCE__ARCHITECTURE, null, msgs);
			msgs = basicSetArchitecture(newArchitecture, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.INSTANCE__ARCHITECTURE, newArchitecture, newArchitecture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance getFeatureInstance() {
		return featureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatureInstance(FeatureInstance newFeatureInstance, NotificationChain msgs) {
		FeatureInstance oldFeatureInstance = featureInstance;
		featureInstance = newFeatureInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InstancePackage.INSTANCE__FEATURE_INSTANCE, oldFeatureInstance, newFeatureInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureInstance(FeatureInstance newFeatureInstance) {
		if (newFeatureInstance != featureInstance) {
			NotificationChain msgs = null;
			if (featureInstance != null)
				msgs = ((InternalEObject)featureInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InstancePackage.INSTANCE__FEATURE_INSTANCE, null, msgs);
			if (newFeatureInstance != null)
				msgs = ((InternalEObject)newFeatureInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InstancePackage.INSTANCE__FEATURE_INSTANCE, null, msgs);
			msgs = basicSetFeatureInstance(newFeatureInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.INSTANCE__FEATURE_INSTANCE, newFeatureInstance, newFeatureInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.INSTANCE__ARCHITECTURE:
				return basicSetArchitecture(null, msgs);
			case InstancePackage.INSTANCE__FEATURE_INSTANCE:
				return basicSetFeatureInstance(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InstancePackage.INSTANCE__ARCHITECTURE:
				return getArchitecture();
			case InstancePackage.INSTANCE__FEATURE_INSTANCE:
				return getFeatureInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InstancePackage.INSTANCE__ARCHITECTURE:
				setArchitecture((ArchitectureInstance)newValue);
				return;
			case InstancePackage.INSTANCE__FEATURE_INSTANCE:
				setFeatureInstance((FeatureInstance)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InstancePackage.INSTANCE__ARCHITECTURE:
				setArchitecture((ArchitectureInstance)null);
				return;
			case InstancePackage.INSTANCE__FEATURE_INSTANCE:
				setFeatureInstance((FeatureInstance)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InstancePackage.INSTANCE__ARCHITECTURE:
				return architecture != null;
			case InstancePackage.INSTANCE__FEATURE_INSTANCE:
				return featureInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //InstanceImpl
