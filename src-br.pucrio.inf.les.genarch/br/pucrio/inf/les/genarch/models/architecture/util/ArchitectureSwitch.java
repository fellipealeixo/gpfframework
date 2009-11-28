/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.util;

import br.pucrio.inf.les.genarch.models.architecture.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage
 * @generated
 */
public class ArchitectureSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ArchitecturePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureSwitch() {
		if (modelPackage == null) {
			modelPackage = ArchitecturePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ArchitecturePackage.ARCHITECTURE: {
				Architecture architecture = (Architecture)theEObject;
				Object result = caseArchitecture(architecture);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_CONTAINER: {
				ArchitectureContainer architectureContainer = (ArchitectureContainer)theEObject;
				Object result = caseArchitectureContainer(architectureContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_RESOURCES_CONTAINER: {
				ArchitectureResourcesContainer architectureResourcesContainer = (ArchitectureResourcesContainer)theEObject;
				Object result = caseArchitectureResourcesContainer(architectureResourcesContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_FRAGMENT_CONTAINER: {
				ArchitectureFragmentContainer architectureFragmentContainer = (ArchitectureFragmentContainer)theEObject;
				Object result = caseArchitectureFragmentContainer(architectureFragmentContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_ENTITY: {
				ArchitectureEntity architectureEntity = (ArchitectureEntity)theEObject;
				Object result = caseArchitectureEntity(architectureEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_COMPONENT: {
				ArchitectureComponent architectureComponent = (ArchitectureComponent)theEObject;
				Object result = caseArchitectureComponent(architectureComponent);
				if (result == null) result = caseArchitectureEntity(architectureComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_CLASS: {
				ArchitectureClass architectureClass = (ArchitectureClass)theEObject;
				Object result = caseArchitectureClass(architectureClass);
				if (result == null) result = caseArchitectureEntity(architectureClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_ASPECT: {
				ArchitectureAspect architectureAspect = (ArchitectureAspect)theEObject;
				Object result = caseArchitectureAspect(architectureAspect);
				if (result == null) result = caseArchitectureEntity(architectureAspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_FILE: {
				ArchitectureFile architectureFile = (ArchitectureFile)theEObject;
				Object result = caseArchitectureFile(architectureFile);
				if (result == null) result = caseArchitectureEntity(architectureFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_TEMPLATE: {
				ArchitectureTemplate architectureTemplate = (ArchitectureTemplate)theEObject;
				Object result = caseArchitectureTemplate(architectureTemplate);
				if (result == null) result = caseArchitectureEntity(architectureTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_FOLDER: {
				ArchitectureFolder architectureFolder = (ArchitectureFolder)theEObject;
				Object result = caseArchitectureFolder(architectureFolder);
				if (result == null) result = caseArchitectureEntity(architectureFolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitecturePackage.ARCHITECTURE_FRAGMENT: {
				ArchitectureFragment architectureFragment = (ArchitectureFragment)theEObject;
				Object result = caseArchitectureFragment(architectureFragment);
				if (result == null) result = caseArchitectureEntity(architectureFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architecture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitecture(Architecture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureContainer(ArchitectureContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resources Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resources Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureResourcesContainer(ArchitectureResourcesContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureFragmentContainer(ArchitectureFragmentContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureEntity(ArchitectureEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureComponent(ArchitectureComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureClass(ArchitectureClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureAspect(ArchitectureAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureFile(ArchitectureFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureTemplate(ArchitectureTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureFolder(ArchitectureFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArchitectureFragment(ArchitectureFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ArchitectureSwitch
