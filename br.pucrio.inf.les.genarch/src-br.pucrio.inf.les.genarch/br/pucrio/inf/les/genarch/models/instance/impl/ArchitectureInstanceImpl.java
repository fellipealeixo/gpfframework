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
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getFolders <em>Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getFragments <em>Fragments</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl#getFragmentContainers <em>Fragment Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureInstanceImpl extends EObjectImpl implements ArchitectureInstance {
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
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureComponent> components;

	/**
	 * The cached value of the '{@link #getFolders() <em>Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureFolder> folders;

	/**
	 * The cached value of the '{@link #getFragments() <em>Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureFragment> fragments;

	/**
	 * The cached value of the '{@link #getFragmentContainers() <em>Fragment Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragmentContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureFragmentContainer> fragmentContainers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.ARCHITECTURE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<ArchitectureClass>(ArchitectureClass.class, this, InstancePackage.ARCHITECTURE_INSTANCE__CLASSES);
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
			aspects = new EObjectContainmentEList<ArchitectureAspect>(ArchitectureAspect.class, this, InstancePackage.ARCHITECTURE_INSTANCE__ASPECTS);
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
			files = new EObjectContainmentEList<ArchitectureFile>(ArchitectureFile.class, this, InstancePackage.ARCHITECTURE_INSTANCE__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureComponent> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<ArchitectureComponent>(ArchitectureComponent.class, this, InstancePackage.ARCHITECTURE_INSTANCE__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureFolder> getFolders() {
		if (folders == null) {
			folders = new EObjectContainmentEList<ArchitectureFolder>(ArchitectureFolder.class, this, InstancePackage.ARCHITECTURE_INSTANCE__FOLDERS);
		}
		return folders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureFragment> getFragments() {
		if (fragments == null) {
			fragments = new EObjectContainmentEList<ArchitectureFragment>(ArchitectureFragment.class, this, InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENTS);
		}
		return fragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureFragmentContainer> getFragmentContainers() {
		if (fragmentContainers == null) {
			fragmentContainers = new EObjectContainmentEList<ArchitectureFragmentContainer>(ArchitectureFragmentContainer.class, this, InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS);
		}
		return fragmentContainers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.ARCHITECTURE_INSTANCE__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_INSTANCE__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_INSTANCE__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_INSTANCE__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_INSTANCE__FOLDERS:
				return ((InternalEList<?>)getFolders()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENTS:
				return ((InternalEList<?>)getFragments()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS:
				return ((InternalEList<?>)getFragmentContainers()).basicRemove(otherEnd, msgs);
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
			case InstancePackage.ARCHITECTURE_INSTANCE__CLASSES:
				return getClasses();
			case InstancePackage.ARCHITECTURE_INSTANCE__ASPECTS:
				return getAspects();
			case InstancePackage.ARCHITECTURE_INSTANCE__FILES:
				return getFiles();
			case InstancePackage.ARCHITECTURE_INSTANCE__COMPONENTS:
				return getComponents();
			case InstancePackage.ARCHITECTURE_INSTANCE__FOLDERS:
				return getFolders();
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENTS:
				return getFragments();
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS:
				return getFragmentContainers();
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
			case InstancePackage.ARCHITECTURE_INSTANCE__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends ArchitectureClass>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends ArchitectureAspect>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends ArchitectureFile>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends ArchitectureComponent>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FOLDERS:
				getFolders().clear();
				getFolders().addAll((Collection<? extends ArchitectureFolder>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENTS:
				getFragments().clear();
				getFragments().addAll((Collection<? extends ArchitectureFragment>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS:
				getFragmentContainers().clear();
				getFragmentContainers().addAll((Collection<? extends ArchitectureFragmentContainer>)newValue);
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
			case InstancePackage.ARCHITECTURE_INSTANCE__CLASSES:
				getClasses().clear();
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__ASPECTS:
				getAspects().clear();
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FILES:
				getFiles().clear();
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__COMPONENTS:
				getComponents().clear();
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FOLDERS:
				getFolders().clear();
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENTS:
				getFragments().clear();
				return;
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS:
				getFragmentContainers().clear();
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
			case InstancePackage.ARCHITECTURE_INSTANCE__CLASSES:
				return classes != null && !classes.isEmpty();
			case InstancePackage.ARCHITECTURE_INSTANCE__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case InstancePackage.ARCHITECTURE_INSTANCE__FILES:
				return files != null && !files.isEmpty();
			case InstancePackage.ARCHITECTURE_INSTANCE__COMPONENTS:
				return components != null && !components.isEmpty();
			case InstancePackage.ARCHITECTURE_INSTANCE__FOLDERS:
				return folders != null && !folders.isEmpty();
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENTS:
				return fragments != null && !fragments.isEmpty();
			case InstancePackage.ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS:
				return fragmentContainers != null && !fragmentContainers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureInstanceImpl
