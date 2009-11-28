/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance.impl;

import br.pucrio.inf.les.genarch.models.instance.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder;
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
 * An implementation of the model object '<em><b>Architecture Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFolderImpl#getSubFolders <em>Sub Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFolderImpl#getFiles <em>Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureFolderImpl extends ArchitectureEntityImpl implements ArchitectureFolder {
	/**
	 * The cached value of the '{@link #getSubFolders() <em>Sub Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureFolder> subFolders;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.ARCHITECTURE_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureFolder> getSubFolders() {
		if (subFolders == null) {
			subFolders = new EObjectContainmentEList<ArchitectureFolder>(ArchitectureFolder.class, this, InstancePackage.ARCHITECTURE_FOLDER__SUB_FOLDERS);
		}
		return subFolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureFile> getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList<ArchitectureFile>(ArchitectureFile.class, this, InstancePackage.ARCHITECTURE_FOLDER__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.ARCHITECTURE_FOLDER__SUB_FOLDERS:
				return ((InternalEList<?>)getSubFolders()).basicRemove(otherEnd, msgs);
			case InstancePackage.ARCHITECTURE_FOLDER__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
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
			case InstancePackage.ARCHITECTURE_FOLDER__SUB_FOLDERS:
				return getSubFolders();
			case InstancePackage.ARCHITECTURE_FOLDER__FILES:
				return getFiles();
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
			case InstancePackage.ARCHITECTURE_FOLDER__SUB_FOLDERS:
				getSubFolders().clear();
				getSubFolders().addAll((Collection<? extends ArchitectureFolder>)newValue);
				return;
			case InstancePackage.ARCHITECTURE_FOLDER__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends ArchitectureFile>)newValue);
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
			case InstancePackage.ARCHITECTURE_FOLDER__SUB_FOLDERS:
				getSubFolders().clear();
				return;
			case InstancePackage.ARCHITECTURE_FOLDER__FILES:
				getFiles().clear();
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
			case InstancePackage.ARCHITECTURE_FOLDER__SUB_FOLDERS:
				return subFolders != null && !subFolders.isEmpty();
			case InstancePackage.ARCHITECTURE_FOLDER__FILES:
				return files != null && !files.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureFolderImpl
