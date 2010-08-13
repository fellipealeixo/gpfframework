/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance.impl;

import br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl#getSubComponents <em>Sub Components</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureComponentImpl extends ArchitectureEntityImpl implements ArchitectureComponent {
	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureClass> classes;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureAspect> aspects;

	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureFile> files;

	/**
	 * The cached value of the '{@link #getSubComponents() <em>Sub Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureComponent> subComponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.ARCHITECTURE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<ArchitectureClass>(ArchitectureClass.class, this, InstancePackage.ARCHITECTURE_COMPONENT__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentEList<ArchitectureAspect>(ArchitectureAspect.class, this, InstancePackage.ARCHITECTURE_COMPONENT__ASPECTS);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureFile> getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList<ArchitectureFile>(ArchitectureFile.class, this, InstancePackage.ARCHITECTURE_COMPONENT__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureComponent> getSubComponents() {
		if (subComponents == null) {
			subComponents = new EObjectContainmentEList<ArchitectureComponent>(ArchitectureComponent.class, this, InstancePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS);
		}
		return subComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.ARCHITECTURE_COMPONENT__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_COMPONENT__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				return ((InternalEList<?>)getSubComponents()).basicRemove(otherEnd, msgs);
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
			case InstancePackage.ARCHITECTURE_COMPONENT__CLASSES:
				return getClasses();
			case InstancePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				return getAspects();
			case InstancePackage.ARCHITECTURE_COMPONENT__FILES:
				return getFiles();
			case InstancePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				return getSubComponents();
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
			case InstancePackage.ARCHITECTURE_COMPONENT__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends ArchitectureClass>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends ArchitectureAspect>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_COMPONENT__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends ArchitectureFile>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				getSubComponents().addAll((Collection<? extends ArchitectureComponent>)newValue);
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
			case InstancePackage.ARCHITECTURE_COMPONENT__CLASSES:
				getClasses().clear();
				return;
			case InstancePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				getAspects().clear();
				return;
			case InstancePackage.ARCHITECTURE_COMPONENT__FILES:
				getFiles().clear();
				return;
			case InstancePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
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
			case InstancePackage.ARCHITECTURE_COMPONENT__CLASSES:
				return classes != null && !classes.isEmpty();
			case InstancePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case InstancePackage.ARCHITECTURE_COMPONENT__FILES:
				return files != null && !files.isEmpty();
			case InstancePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				return subComponents != null && !subComponents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureComponentImpl
