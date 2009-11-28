/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.impl;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl#getSubFolders <em>Sub Folders</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationFolderImpl extends MappingEntityImpl implements ConfigurationFolder {
	/**
	 * The cached value of the '{@link #getSubFolders() <em>Sub Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubFolders()
	 * @generated
	 * @ordered
	 */
	protected EList subFolders;

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
	 * The cached value of the '{@link #getTemplates() <em>Templates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplates()
	 * @generated
	 * @ordered
	 */
	protected EList templates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.CONFIGURATION_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubFolders() {
		if (subFolders == null) {
			subFolders = new EObjectContainmentEList(ConfigurationFolder.class, this, ConfigurationPackage.CONFIGURATION_FOLDER__SUB_FOLDERS);
		}
		return subFolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList(ConfigurationFile.class, this, ConfigurationPackage.CONFIGURATION_FOLDER__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTemplates() {
		if (templates == null) {
			templates = new EObjectContainmentEList(ConfigurationTemplate.class, this, ConfigurationPackage.CONFIGURATION_FOLDER__TEMPLATES);
		}
		return templates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION_FOLDER__SUB_FOLDERS:
				return ((InternalEList)getSubFolders()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.CONFIGURATION_FOLDER__FILES:
				return ((InternalEList)getFiles()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.CONFIGURATION_FOLDER__TEMPLATES:
				return ((InternalEList)getTemplates()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.CONFIGURATION_FOLDER__SUB_FOLDERS:
				return getSubFolders();
			case ConfigurationPackage.CONFIGURATION_FOLDER__FILES:
				return getFiles();
			case ConfigurationPackage.CONFIGURATION_FOLDER__TEMPLATES:
				return getTemplates();
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
			case ConfigurationPackage.CONFIGURATION_FOLDER__SUB_FOLDERS:
				getSubFolders().clear();
				getSubFolders().addAll((Collection)newValue);
				return;
			case ConfigurationPackage.CONFIGURATION_FOLDER__FILES:
				getFiles().clear();
				getFiles().addAll((Collection)newValue);
				return;
			case ConfigurationPackage.CONFIGURATION_FOLDER__TEMPLATES:
				getTemplates().clear();
				getTemplates().addAll((Collection)newValue);
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
			case ConfigurationPackage.CONFIGURATION_FOLDER__SUB_FOLDERS:
				getSubFolders().clear();
				return;
			case ConfigurationPackage.CONFIGURATION_FOLDER__FILES:
				getFiles().clear();
				return;
			case ConfigurationPackage.CONFIGURATION_FOLDER__TEMPLATES:
				getTemplates().clear();
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
			case ConfigurationPackage.CONFIGURATION_FOLDER__SUB_FOLDERS:
				return subFolders != null && !subFolders.isEmpty();
			case ConfigurationPackage.CONFIGURATION_FOLDER__FILES:
				return files != null && !files.isEmpty();
			case ConfigurationPackage.CONFIGURATION_FOLDER__TEMPLATES:
				return templates != null && !templates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationFolderImpl
