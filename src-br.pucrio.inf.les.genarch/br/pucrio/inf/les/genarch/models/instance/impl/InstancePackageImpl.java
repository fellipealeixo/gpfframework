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
import br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.Feature;
import br.pucrio.inf.les.genarch.models.instance.FeatureInstance;
import br.pucrio.inf.les.genarch.models.instance.Instance;
import br.pucrio.inf.les.genarch.models.instance.InstanceFactory;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstancePackageImpl extends EPackageImpl implements InstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureAspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureFragmentContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InstancePackageImpl() {
		super(eNS_URI, InstanceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InstancePackage init() {
		if (isInited) return (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);

		// Obtain or create and register package
		InstancePackageImpl theInstancePackage = (InstancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof InstancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new InstancePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theInstancePackage.createPackageContents();

		// Initialize created meta-data
		theInstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInstancePackage.freeze();

		return theInstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstance() {
		return instanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstance_Architecture() {
		return (EReference)instanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstance_FeatureInstance() {
		return (EReference)instanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureInstance() {
		return architectureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_Classes() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_Aspects() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_Files() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_Components() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_Folders() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_Fragments() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureInstance_FragmentContainers() {
		return (EReference)architectureInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureEntity() {
		return architectureEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureEntity_Name() {
		return (EAttribute)architectureEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureEntity_Path() {
		return (EAttribute)architectureEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureComponent() {
		return architectureComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureComponent_Classes() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureComponent_Aspects() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureComponent_Files() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureComponent_SubComponents() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureClass() {
		return architectureClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureAspect() {
		return architectureAspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureFile() {
		return architectureFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureFolder() {
		return architectureFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFolder_SubFolders() {
		return (EReference)architectureFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFolder_Files() {
		return (EReference)architectureFolderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureFragment() {
		return architectureFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureFragment_Content() {
		return (EAttribute)architectureFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureFragmentContainer() {
		return architectureFragmentContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureFragmentContainer_Name() {
		return (EAttribute)architectureFragmentContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureFragmentContainer_Fragments() {
		return (EReference)architectureFragmentContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInstance() {
		return featureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInstance_Root() {
		return (EReference)featureInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureInstance_Name() {
		return (EAttribute)featureInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureInstance_Attribute() {
		return (EAttribute)featureInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Id() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Name() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Attribute() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Max() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Min() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_IsSelected() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Features() {
		return (EReference)featureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceFactory getInstanceFactory() {
		return (InstanceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		instanceEClass = createEClass(INSTANCE);
		createEReference(instanceEClass, INSTANCE__ARCHITECTURE);
		createEReference(instanceEClass, INSTANCE__FEATURE_INSTANCE);

		architectureInstanceEClass = createEClass(ARCHITECTURE_INSTANCE);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__CLASSES);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__ASPECTS);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__FILES);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__COMPONENTS);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__FOLDERS);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__FRAGMENTS);
		createEReference(architectureInstanceEClass, ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS);

		architectureEntityEClass = createEClass(ARCHITECTURE_ENTITY);
		createEAttribute(architectureEntityEClass, ARCHITECTURE_ENTITY__NAME);
		createEAttribute(architectureEntityEClass, ARCHITECTURE_ENTITY__PATH);

		architectureComponentEClass = createEClass(ARCHITECTURE_COMPONENT);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__CLASSES);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__ASPECTS);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__FILES);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__SUB_COMPONENTS);

		architectureClassEClass = createEClass(ARCHITECTURE_CLASS);

		architectureAspectEClass = createEClass(ARCHITECTURE_ASPECT);

		architectureFileEClass = createEClass(ARCHITECTURE_FILE);

		architectureFolderEClass = createEClass(ARCHITECTURE_FOLDER);
		createEReference(architectureFolderEClass, ARCHITECTURE_FOLDER__SUB_FOLDERS);
		createEReference(architectureFolderEClass, ARCHITECTURE_FOLDER__FILES);

		architectureFragmentEClass = createEClass(ARCHITECTURE_FRAGMENT);
		createEAttribute(architectureFragmentEClass, ARCHITECTURE_FRAGMENT__CONTENT);

		architectureFragmentContainerEClass = createEClass(ARCHITECTURE_FRAGMENT_CONTAINER);
		createEAttribute(architectureFragmentContainerEClass, ARCHITECTURE_FRAGMENT_CONTAINER__NAME);
		createEReference(architectureFragmentContainerEClass, ARCHITECTURE_FRAGMENT_CONTAINER__FRAGMENTS);

		featureInstanceEClass = createEClass(FEATURE_INSTANCE);
		createEReference(featureInstanceEClass, FEATURE_INSTANCE__ROOT);
		createEAttribute(featureInstanceEClass, FEATURE_INSTANCE__NAME);
		createEAttribute(featureInstanceEClass, FEATURE_INSTANCE__ATTRIBUTE);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__ID);
		createEAttribute(featureEClass, FEATURE__NAME);
		createEAttribute(featureEClass, FEATURE__ATTRIBUTE);
		createEAttribute(featureEClass, FEATURE__MAX);
		createEAttribute(featureEClass, FEATURE__MIN);
		createEAttribute(featureEClass, FEATURE__IS_SELECTED);
		createEReference(featureEClass, FEATURE__FEATURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		architectureComponentEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureClassEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureAspectEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureFileEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureFolderEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureFragmentEClass.getESuperTypes().add(this.getArchitectureEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(instanceEClass, Instance.class, "Instance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstance_Architecture(), this.getArchitectureInstance(), null, "architecture", null, 0, 1, Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstance_FeatureInstance(), this.getFeatureInstance(), null, "featureInstance", null, 0, 1, Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureInstanceEClass, ArchitectureInstance.class, "ArchitectureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureInstance_Classes(), this.getArchitectureClass(), null, "classes", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureInstance_Aspects(), this.getArchitectureAspect(), null, "aspects", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureInstance_Files(), this.getArchitectureFile(), null, "files", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureInstance_Components(), this.getArchitectureComponent(), null, "components", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureInstance_Folders(), this.getArchitectureFolder(), null, "folders", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureInstance_Fragments(), this.getArchitectureFragment(), null, "fragments", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureInstance_FragmentContainers(), this.getArchitectureFragmentContainer(), null, "fragmentContainers", null, 0, -1, ArchitectureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureEntityEClass, ArchitectureEntity.class, "ArchitectureEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitectureEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArchitectureEntity_Path(), ecorePackage.getEString(), "path", null, 0, 1, ArchitectureEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureComponentEClass, ArchitectureComponent.class, "ArchitectureComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureComponent_Classes(), this.getArchitectureClass(), null, "classes", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_Aspects(), this.getArchitectureAspect(), null, "aspects", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_Files(), this.getArchitectureFile(), null, "files", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_SubComponents(), this.getArchitectureComponent(), null, "subComponents", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureClassEClass, ArchitectureClass.class, "ArchitectureClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(architectureAspectEClass, ArchitectureAspect.class, "ArchitectureAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(architectureFileEClass, ArchitectureFile.class, "ArchitectureFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(architectureFolderEClass, ArchitectureFolder.class, "ArchitectureFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureFolder_SubFolders(), this.getArchitectureFolder(), null, "subFolders", null, 0, -1, ArchitectureFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFolder_Files(), this.getArchitectureFile(), null, "files", null, 0, -1, ArchitectureFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureFragmentEClass, ArchitectureFragment.class, "ArchitectureFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureFragment_Content(), ecorePackage.getEString(), "content", "", 0, 1, ArchitectureFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureFragmentContainerEClass, ArchitectureFragmentContainer.class, "ArchitectureFragmentContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureFragmentContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitectureFragmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFragmentContainer_Fragments(), this.getArchitectureFragment(), null, "fragments", null, 0, -1, ArchitectureFragmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureInstanceEClass, FeatureInstance.class, "FeatureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureInstance_Root(), this.getFeature(), null, "root", null, 0, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureInstance_Name(), ecorePackage.getEString(), "name", null, 0, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureInstance_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, FeatureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Id(), ecorePackage.getEString(), "id", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Max(), ecorePackage.getEInt(), "max", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Min(), ecorePackage.getEInt(), "min", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_IsSelected(), ecorePackage.getEBoolean(), "isSelected", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Features(), this.getFeature(), null, "features", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InstancePackageImpl
