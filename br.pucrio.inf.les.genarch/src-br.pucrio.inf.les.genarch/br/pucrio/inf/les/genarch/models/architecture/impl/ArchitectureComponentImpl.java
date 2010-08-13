/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl#getTemplates <em>Templates</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl#getSubComponents <em>Sub Components</em>}</li>
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
	protected EList classes;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList aspects;

	/**
	 * The cached value of the '{@link #getTemplates() <em>Templates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplates()
	 * @generated
	 * @ordered
	 */
	protected EList templates;

	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList files;

	/**
	 * The cached value of the '{@link #getSubComponents() <em>Sub Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubComponents()
	 * @generated
	 * @ordered
	 */
	protected EList subComponents;

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
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList(ArchitectureClass.class, this, ArchitecturePackage.ARCHITECTURE_COMPONENT__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentEList(ArchitectureAspect.class, this, ArchitecturePackage.ARCHITECTURE_COMPONENT__ASPECTS);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTemplates() {
		if (templates == null) {
			templates = new EObjectContainmentEList(ArchitectureTemplate.class, this, ArchitecturePackage.ARCHITECTURE_COMPONENT__TEMPLATES);
		}
		return templates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList(ArchitectureFile.class, this, ArchitecturePackage.ARCHITECTURE_COMPONENT__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubComponents() {
		if (subComponents == null) {
			subComponents = new EObjectContainmentEList(ArchitectureComponent.class, this, ArchitecturePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS);
		}
		return subComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__CLASSES:
				return ((InternalEList)getClasses()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				return ((InternalEList)getAspects()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__TEMPLATES:
				return ((InternalEList)getTemplates()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__FILES:
				return ((InternalEList)getFiles()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				return ((InternalEList)getSubComponents()).basicRemove(otherEnd, msgs);
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
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__CLASSES:
				return getClasses();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				return getAspects();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__TEMPLATES:
				return getTemplates();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__FILES:
				return getFiles();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				return getSubComponents();
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
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__TEMPLATES:
				getTemplates().clear();
				getTemplates().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__FILES:
				getFiles().clear();
				getFiles().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				getSubComponents().addAll((Collection)newValue);
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
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__CLASSES:
				getClasses().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				getAspects().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__TEMPLATES:
				getTemplates().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__FILES:
				getFiles().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__CLASSES:
				return classes != null && !classes.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__TEMPLATES:
				return templates != null && !templates.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__FILES:
				return files != null && !files.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT__SUB_COMPONENTS:
				return subComponents != null && !subComponents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureComponentImpl
