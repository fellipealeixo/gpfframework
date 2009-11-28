/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitectureFactoryImpl extends EFactoryImpl implements ArchitectureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchitectureFactory init() {
		try {
			ArchitectureFactory theArchitectureFactory = (ArchitectureFactory)EPackage.Registry.INSTANCE.getEFactory("http:///ArchitectureMetaModel.ecore"); 
			if (theArchitectureFactory != null) {
				return theArchitectureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ArchitectureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ArchitecturePackage.ARCHITECTURE: return createArchitecture();
			case ArchitecturePackage.ARCHITECTURE_CONTAINER: return createArchitectureContainer();
			case ArchitecturePackage.ARCHITECTURE_RESOURCES_CONTAINER: return createArchitectureResourcesContainer();
			case ArchitecturePackage.ARCHITECTURE_FRAGMENT_CONTAINER: return createArchitectureFragmentContainer();
			case ArchitecturePackage.ARCHITECTURE_ENTITY: return createArchitectureEntity();
			case ArchitecturePackage.ARCHITECTURE_COMPONENT: return createArchitectureComponent();
			case ArchitecturePackage.ARCHITECTURE_CLASS: return createArchitectureClass();
			case ArchitecturePackage.ARCHITECTURE_ASPECT: return createArchitectureAspect();
			case ArchitecturePackage.ARCHITECTURE_FILE: return createArchitectureFile();
			case ArchitecturePackage.ARCHITECTURE_TEMPLATE: return createArchitectureTemplate();
			case ArchitecturePackage.ARCHITECTURE_FOLDER: return createArchitectureFolder();
			case ArchitecturePackage.ARCHITECTURE_FRAGMENT: return createArchitectureFragment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Architecture createArchitecture() {
		ArchitectureImpl architecture = new ArchitectureImpl();
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureContainer createArchitectureContainer() {
		ArchitectureContainerImpl architectureContainer = new ArchitectureContainerImpl();
		return architectureContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureResourcesContainer createArchitectureResourcesContainer() {
		ArchitectureResourcesContainerImpl architectureResourcesContainer = new ArchitectureResourcesContainerImpl();
		return architectureResourcesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFragmentContainer createArchitectureFragmentContainer() {
		ArchitectureFragmentContainerImpl architectureFragmentContainer = new ArchitectureFragmentContainerImpl();
		return architectureFragmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureEntity createArchitectureEntity() {
		ArchitectureEntityImpl architectureEntity = new ArchitectureEntityImpl();
		return architectureEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureComponent createArchitectureComponent() {
		ArchitectureComponentImpl architectureComponent = new ArchitectureComponentImpl();
		return architectureComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureClass createArchitectureClass() {
		ArchitectureClassImpl architectureClass = new ArchitectureClassImpl();
		return architectureClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureAspect createArchitectureAspect() {
		ArchitectureAspectImpl architectureAspect = new ArchitectureAspectImpl();
		return architectureAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFile createArchitectureFile() {
		ArchitectureFileImpl architectureFile = new ArchitectureFileImpl();
		return architectureFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureTemplate createArchitectureTemplate() {
		ArchitectureTemplateImpl architectureTemplate = new ArchitectureTemplateImpl();
		return architectureTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFolder createArchitectureFolder() {
		ArchitectureFolderImpl architectureFolder = new ArchitectureFolderImpl();
		return architectureFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFragment createArchitectureFragment() {
		ArchitectureFragmentImpl architectureFragment = new ArchitectureFragmentImpl();
		return architectureFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitecturePackage getArchitecturePackage() {
		return (ArchitecturePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ArchitecturePackage getPackage() {
		return ArchitecturePackage.eINSTANCE;
	}

} //ArchitectureFactoryImpl
