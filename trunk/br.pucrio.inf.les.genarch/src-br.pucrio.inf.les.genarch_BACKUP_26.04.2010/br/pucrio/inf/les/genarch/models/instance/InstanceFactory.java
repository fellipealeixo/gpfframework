/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage
 * @generated
 */
public interface InstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InstanceFactory eINSTANCE = br.pucrio.inf.les.genarch.models.instance.impl.InstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance</em>'.
	 * @generated
	 */
	Instance createInstance();

	/**
	 * Returns a new object of class '<em>Architecture Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Instance</em>'.
	 * @generated
	 */
	ArchitectureInstance createArchitectureInstance();

	/**
	 * Returns a new object of class '<em>Architecture Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Entity</em>'.
	 * @generated
	 */
	ArchitectureEntity createArchitectureEntity();

	/**
	 * Returns a new object of class '<em>Architecture Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Component</em>'.
	 * @generated
	 */
	ArchitectureComponent createArchitectureComponent();

	/**
	 * Returns a new object of class '<em>Architecture Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Class</em>'.
	 * @generated
	 */
	ArchitectureClass createArchitectureClass();

	/**
	 * Returns a new object of class '<em>Architecture Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Aspect</em>'.
	 * @generated
	 */
	ArchitectureAspect createArchitectureAspect();

	/**
	 * Returns a new object of class '<em>Architecture File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture File</em>'.
	 * @generated
	 */
	ArchitectureFile createArchitectureFile();

	/**
	 * Returns a new object of class '<em>Architecture Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Folder</em>'.
	 * @generated
	 */
	ArchitectureFolder createArchitectureFolder();

	/**
	 * Returns a new object of class '<em>Architecture Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Fragment</em>'.
	 * @generated
	 */
	ArchitectureFragment createArchitectureFragment();

	/**
	 * Returns a new object of class '<em>Architecture Fragment Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Fragment Container</em>'.
	 * @generated
	 */
	ArchitectureFragmentContainer createArchitectureFragmentContainer();

	/**
	 * Returns a new object of class '<em>Feature Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Instance</em>'.
	 * @generated
	 */
	FeatureInstance createFeatureInstance();

	/**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
	Feature createFeature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InstancePackage getInstancePackage();

} //InstanceFactory
