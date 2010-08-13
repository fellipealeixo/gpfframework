/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance.impl;

import br.pucrio.inf.les.genarch.models.instance.*;

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
public class InstanceFactoryImpl extends EFactoryImpl implements InstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InstanceFactory init() {
		try {
			InstanceFactory theInstanceFactory = (InstanceFactory)EPackage.Registry.INSTANCE.getEFactory("http:///InstanceMetaModel.ecore"); 
			if (theInstanceFactory != null) {
				return theInstanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InstancePackage.INSTANCE: return createInstance();
			case InstancePackage.ARCHITECTURE_INSTANCE: return createArchitectureInstance();
			case InstancePackage.ARCHITECTURE_ENTITY: return createArchitectureEntity();
			case InstancePackage.ARCHITECTURE_COMPONENT: return createArchitectureComponent();
			case InstancePackage.ARCHITECTURE_CLASS: return createArchitectureClass();
			case InstancePackage.ARCHITECTURE_ASPECT: return createArchitectureAspect();
			case InstancePackage.ARCHITECTURE_FILE: return createArchitectureFile();
			case InstancePackage.ARCHITECTURE_FOLDER: return createArchitectureFolder();
			case InstancePackage.ARCHITECTURE_FRAGMENT: return createArchitectureFragment();
			case InstancePackage.ARCHITECTURE_FRAGMENT_CONTAINER: return createArchitectureFragmentContainer();
			case InstancePackage.FEATURE_INSTANCE: return createFeatureInstance();
			case InstancePackage.FEATURE: return createFeature();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instance createInstance() {
		InstanceImpl instance = new InstanceImpl();
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureInstance createArchitectureInstance() {
		ArchitectureInstanceImpl architectureInstance = new ArchitectureInstanceImpl();
		return architectureInstance;
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
	public ArchitectureFragmentContainer createArchitectureFragmentContainer() {
		ArchitectureFragmentContainerImpl architectureFragmentContainer = new ArchitectureFragmentContainerImpl();
		return architectureFragmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance createFeatureInstance() {
		FeatureInstanceImpl featureInstance = new FeatureInstanceImpl();
		return featureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePackage getInstancePackage() {
		return (InstancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InstancePackage getPackage() {
		return InstancePackage.eINSTANCE;
	}

} //InstanceFactoryImpl
