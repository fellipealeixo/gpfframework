/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance.impl;

import br.pucrio.inf.les.genarch.models.instance.Feature;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#getId <em>Id</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#getMax <em>Max</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#getMin <em>Min</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#isIsSelected <em>Is Selected</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected String attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSelected() <em>Is Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSelected() <em>Is Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean isSelected = IS_SELECTED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(String newAttribute) {
		String oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(int newMax) {
		int oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(int newMin) {
		int oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSelected() {
		return isSelected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSelected(boolean newIsSelected) {
		boolean oldIsSelected = isSelected;
		isSelected = newIsSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE__IS_SELECTED, oldIsSelected, isSelected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, InstancePackage.FEATURE__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.FEATURE__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case InstancePackage.FEATURE__ID:
				return getId();
			case InstancePackage.FEATURE__NAME:
				return getName();
			case InstancePackage.FEATURE__ATTRIBUTE:
				return getAttribute();
			case InstancePackage.FEATURE__MAX:
				return new Integer(getMax());
			case InstancePackage.FEATURE__MIN:
				return new Integer(getMin());
			case InstancePackage.FEATURE__IS_SELECTED:
				return isIsSelected() ? Boolean.TRUE : Boolean.FALSE;
			case InstancePackage.FEATURE__FEATURES:
				return getFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InstancePackage.FEATURE__ID:
				setId((String)newValue);
				return;
			case InstancePackage.FEATURE__NAME:
				setName((String)newValue);
				return;
			case InstancePackage.FEATURE__ATTRIBUTE:
				setAttribute((String)newValue);
				return;
			case InstancePackage.FEATURE__MAX:
				setMax(((Integer)newValue).intValue());
				return;
			case InstancePackage.FEATURE__MIN:
				setMin(((Integer)newValue).intValue());
				return;
			case InstancePackage.FEATURE__IS_SELECTED:
				setIsSelected(((Boolean)newValue).booleanValue());
				return;
			case InstancePackage.FEATURE__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case InstancePackage.FEATURE__ID:
				setId(ID_EDEFAULT);
				return;
			case InstancePackage.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case InstancePackage.FEATURE__ATTRIBUTE:
				setAttribute(ATTRIBUTE_EDEFAULT);
				return;
			case InstancePackage.FEATURE__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case InstancePackage.FEATURE__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case InstancePackage.FEATURE__IS_SELECTED:
				setIsSelected(IS_SELECTED_EDEFAULT);
				return;
			case InstancePackage.FEATURE__FEATURES:
				getFeatures().clear();
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
			case InstancePackage.FEATURE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case InstancePackage.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case InstancePackage.FEATURE__ATTRIBUTE:
				return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
			case InstancePackage.FEATURE__MAX:
				return max != MAX_EDEFAULT;
			case InstancePackage.FEATURE__MIN:
				return min != MIN_EDEFAULT;
			case InstancePackage.FEATURE__IS_SELECTED:
				return isSelected != IS_SELECTED_EDEFAULT;
			case InstancePackage.FEATURE__FEATURES:
				return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", attribute: ");
		result.append(attribute);
		result.append(", max: ");
		result.append(max);
		result.append(", min: ");
		result.append(min);
		result.append(", isSelected: ");
		result.append(isSelected);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
