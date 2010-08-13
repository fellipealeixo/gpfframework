/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

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
public class ArchitecturePackageImpl extends EPackageImpl implements ArchitecturePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureResourcesContainerEClass = null;

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
	private EClass architectureTemplateEClass = null;

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
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ArchitecturePackageImpl() {
		super(eNS_URI, ArchitectureFactory.eINSTANCE);
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
	public static ArchitecturePackage init() {
		if (isInited) return (ArchitecturePackage)EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);

		// Obtain or create and register package
		ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ArchitecturePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ArchitecturePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theArchitecturePackage.createPackageContents();

		// Initialize created meta-data
		theArchitecturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theArchitecturePackage.freeze();

		return theArchitecturePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitecture() {
		return architectureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitecture_Containers() {
		return (EReference)architectureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitecture_ResourcesContainer() {
		return (EReference)architectureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitecture_FragmentsContainer() {
		return (EReference)architectureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureContainer() {
		return architectureContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureContainer_Name() {
		return (EAttribute)architectureContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureContainer_Components() {
		return (EReference)architectureContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectureResourcesContainer() {
		return architectureResourcesContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureResourcesContainer_Name() {
		return (EAttribute)architectureResourcesContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureResourcesContainer_Folders() {
		return (EReference)architectureResourcesContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureResourcesContainer_Files() {
		return (EReference)architectureResourcesContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureResourcesContainer_Templates() {
		return (EReference)architectureResourcesContainerEClass.getEStructuralFeatures().get(3);
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
	public EReference getArchitectureComponent_Templates() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureComponent_Files() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectureComponent_SubComponents() {
		return (EReference)architectureComponentEClass.getEStructuralFeatures().get(4);
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
	public EClass getArchitectureTemplate() {
		return architectureTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitectureTemplate_GenerationPath() {
		return (EAttribute)architectureTemplateEClass.getEStructuralFeatures().get(0);
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
	public EReference getArchitectureFolder_Templates() {
		return (EReference)architectureFolderEClass.getEStructuralFeatures().get(2);
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
	public ArchitectureFactory getArchitectureFactory() {
		return (ArchitectureFactory)getEFactoryInstance();
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
		architectureEClass = createEClass(ARCHITECTURE);
		createEReference(architectureEClass, ARCHITECTURE__CONTAINERS);
		createEReference(architectureEClass, ARCHITECTURE__RESOURCES_CONTAINER);
		createEReference(architectureEClass, ARCHITECTURE__FRAGMENTS_CONTAINER);

		architectureContainerEClass = createEClass(ARCHITECTURE_CONTAINER);
		createEAttribute(architectureContainerEClass, ARCHITECTURE_CONTAINER__NAME);
		createEReference(architectureContainerEClass, ARCHITECTURE_CONTAINER__COMPONENTS);

		architectureResourcesContainerEClass = createEClass(ARCHITECTURE_RESOURCES_CONTAINER);
		createEAttribute(architectureResourcesContainerEClass, ARCHITECTURE_RESOURCES_CONTAINER__NAME);
		createEReference(architectureResourcesContainerEClass, ARCHITECTURE_RESOURCES_CONTAINER__FOLDERS);
		createEReference(architectureResourcesContainerEClass, ARCHITECTURE_RESOURCES_CONTAINER__FILES);
		createEReference(architectureResourcesContainerEClass, ARCHITECTURE_RESOURCES_CONTAINER__TEMPLATES);

		architectureFragmentContainerEClass = createEClass(ARCHITECTURE_FRAGMENT_CONTAINER);
		createEAttribute(architectureFragmentContainerEClass, ARCHITECTURE_FRAGMENT_CONTAINER__NAME);
		createEReference(architectureFragmentContainerEClass, ARCHITECTURE_FRAGMENT_CONTAINER__FRAGMENTS);

		architectureEntityEClass = createEClass(ARCHITECTURE_ENTITY);
		createEAttribute(architectureEntityEClass, ARCHITECTURE_ENTITY__NAME);
		createEAttribute(architectureEntityEClass, ARCHITECTURE_ENTITY__PATH);

		architectureComponentEClass = createEClass(ARCHITECTURE_COMPONENT);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__CLASSES);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__ASPECTS);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__TEMPLATES);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__FILES);
		createEReference(architectureComponentEClass, ARCHITECTURE_COMPONENT__SUB_COMPONENTS);

		architectureClassEClass = createEClass(ARCHITECTURE_CLASS);

		architectureAspectEClass = createEClass(ARCHITECTURE_ASPECT);

		architectureFileEClass = createEClass(ARCHITECTURE_FILE);

		architectureTemplateEClass = createEClass(ARCHITECTURE_TEMPLATE);
		createEAttribute(architectureTemplateEClass, ARCHITECTURE_TEMPLATE__GENERATION_PATH);

		architectureFolderEClass = createEClass(ARCHITECTURE_FOLDER);
		createEReference(architectureFolderEClass, ARCHITECTURE_FOLDER__SUB_FOLDERS);
		createEReference(architectureFolderEClass, ARCHITECTURE_FOLDER__FILES);
		createEReference(architectureFolderEClass, ARCHITECTURE_FOLDER__TEMPLATES);

		architectureFragmentEClass = createEClass(ARCHITECTURE_FRAGMENT);
		createEAttribute(architectureFragmentEClass, ARCHITECTURE_FRAGMENT__CONTENT);
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

		// Add supertypes to classes
		architectureComponentEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureClassEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureAspectEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureFileEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureTemplateEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureFolderEClass.getESuperTypes().add(this.getArchitectureEntity());
		architectureFragmentEClass.getESuperTypes().add(this.getArchitectureEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(architectureEClass, Architecture.class, "Architecture", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitecture_Containers(), this.getArchitectureContainer(), null, "containers", null, 0, -1, Architecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitecture_ResourcesContainer(), this.getArchitectureResourcesContainer(), null, "resourcesContainer", null, 0, -1, Architecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitecture_FragmentsContainer(), this.getArchitectureFragmentContainer(), null, "fragmentsContainer", null, 0, -1, Architecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureContainerEClass, ArchitectureContainer.class, "ArchitectureContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitectureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureContainer_Components(), this.getArchitectureComponent(), null, "components", null, 0, -1, ArchitectureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureResourcesContainerEClass, ArchitectureResourcesContainer.class, "ArchitectureResourcesContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureResourcesContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitectureResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureResourcesContainer_Folders(), this.getArchitectureFolder(), null, "folders", null, 0, -1, ArchitectureResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureResourcesContainer_Files(), this.getArchitectureFile(), null, "files", null, 0, -1, ArchitectureResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureResourcesContainer_Templates(), this.getArchitectureTemplate(), null, "templates", null, 0, -1, ArchitectureResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureFragmentContainerEClass, ArchitectureFragmentContainer.class, "ArchitectureFragmentContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureFragmentContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitectureFragmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFragmentContainer_Fragments(), this.getArchitectureFragment(), null, "fragments", null, 0, -1, ArchitectureFragmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureEntityEClass, ArchitectureEntity.class, "ArchitectureEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitectureEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArchitectureEntity_Path(), ecorePackage.getEString(), "path", null, 0, 1, ArchitectureEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureComponentEClass, ArchitectureComponent.class, "ArchitectureComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureComponent_Classes(), this.getArchitectureClass(), null, "classes", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_Aspects(), this.getArchitectureAspect(), null, "aspects", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_Templates(), this.getArchitectureTemplate(), null, "templates", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_Files(), this.getArchitectureFile(), null, "files", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureComponent_SubComponents(), this.getArchitectureComponent(), null, "subComponents", null, 0, -1, ArchitectureComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureClassEClass, ArchitectureClass.class, "ArchitectureClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(architectureAspectEClass, ArchitectureAspect.class, "ArchitectureAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(architectureFileEClass, ArchitectureFile.class, "ArchitectureFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(architectureTemplateEClass, ArchitectureTemplate.class, "ArchitectureTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureTemplate_GenerationPath(), ecorePackage.getEString(), "generationPath", null, 0, 1, ArchitectureTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureFolderEClass, ArchitectureFolder.class, "ArchitectureFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectureFolder_SubFolders(), this.getArchitectureFolder(), null, "subFolders", null, 0, -1, ArchitectureFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFolder_Files(), this.getArchitectureFile(), null, "files", null, 0, -1, ArchitectureFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectureFolder_Templates(), this.getArchitectureTemplate(), null, "templates", null, 0, -1, ArchitectureFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureFragmentEClass, ArchitectureFragment.class, "ArchitectureFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitectureFragment_Content(), ecorePackage.getEString(), "content", null, 0, 1, ArchitectureFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ArchitecturePackageImpl
