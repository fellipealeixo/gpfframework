/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.impl;

import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;

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
public class ConfigurationPackageImpl extends EPackageImpl implements ConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRelationshipsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationResourcesContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationFragmentContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationClassEClass = null;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationAspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureExpressionEClass = null;

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
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConfigurationPackageImpl() {
		super(eNS_URI, ConfigurationFactory.eINSTANCE);
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
	public static ConfigurationPackage init() {
		if (isInited) return (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ConfigurationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfigurationPackage.freeze();

		return theConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_MappingRelationships() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRelationships() {
		return mappingRelationshipsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRelationships_Containers() {
		return (EReference)mappingRelationshipsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRelationships_ResourcesContainers() {
		return (EReference)mappingRelationshipsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRelationships_FragmentsContainer() {
		return (EReference)mappingRelationshipsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingEntity() {
		return mappingEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingEntity_Name() {
		return (EAttribute)mappingEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingEntity_Path() {
		return (EAttribute)mappingEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingEntity_FeatureExpression() {
		return (EReference)mappingEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationContainer() {
		return configurationContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationContainer_Name() {
		return (EAttribute)configurationContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationContainer_Components() {
		return (EReference)configurationContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationResourcesContainer() {
		return configurationResourcesContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationResourcesContainer_Name() {
		return (EAttribute)configurationResourcesContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationResourcesContainer_Folders() {
		return (EReference)configurationResourcesContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationResourcesContainer_Files() {
		return (EReference)configurationResourcesContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationResourcesContainer_Templates() {
		return (EReference)configurationResourcesContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationFragmentContainer() {
		return configurationFragmentContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationFragmentContainer_Name() {
		return (EAttribute)configurationFragmentContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationFragmentContainer_Fragments() {
		return (EReference)configurationFragmentContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationComponent() {
		return configurationComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationComponent_Classes() {
		return (EReference)configurationComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationComponent_Aspects() {
		return (EReference)configurationComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationComponent_Templates() {
		return (EReference)configurationComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationComponent_Files() {
		return (EReference)configurationComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationComponent_SubComponents() {
		return (EReference)configurationComponentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationClass() {
		return configurationClassEClass;
	}

	public EClass getConfigurationProcess() {
		return configurationProcessEClass;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationAspect() {
		return configurationAspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationTemplate() {
		return configurationTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationFile() {
		return configurationFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationFolder() {
		return configurationFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationFolder_SubFolders() {
		return (EReference)configurationFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationFolder_Files() {
		return (EReference)configurationFolderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationFolder_Templates() {
		return (EReference)configurationFolderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationFragment() {
		return configurationFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureExpression() {
		return featureExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureExpression_Expression() {
		return (EAttribute)featureExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFactory getConfigurationFactory() {
		return (ConfigurationFactory)getEFactoryInstance();
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
		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__MAPPING_RELATIONSHIPS);

		mappingRelationshipsEClass = createEClass(MAPPING_RELATIONSHIPS);
		createEReference(mappingRelationshipsEClass, MAPPING_RELATIONSHIPS__CONTAINERS);
		createEReference(mappingRelationshipsEClass, MAPPING_RELATIONSHIPS__RESOURCES_CONTAINERS);
		createEReference(mappingRelationshipsEClass, MAPPING_RELATIONSHIPS__FRAGMENTS_CONTAINER);

		mappingEntityEClass = createEClass(MAPPING_ENTITY);
		createEAttribute(mappingEntityEClass, MAPPING_ENTITY__NAME);
		createEAttribute(mappingEntityEClass, MAPPING_ENTITY__PATH);
		createEReference(mappingEntityEClass, MAPPING_ENTITY__FEATURE_EXPRESSION);

		configurationContainerEClass = createEClass(CONFIGURATION_CONTAINER);
		createEAttribute(configurationContainerEClass, CONFIGURATION_CONTAINER__NAME);
		createEReference(configurationContainerEClass, CONFIGURATION_CONTAINER__COMPONENTS);

		configurationResourcesContainerEClass = createEClass(CONFIGURATION_RESOURCES_CONTAINER);
		createEAttribute(configurationResourcesContainerEClass, CONFIGURATION_RESOURCES_CONTAINER__NAME);
		createEReference(configurationResourcesContainerEClass, CONFIGURATION_RESOURCES_CONTAINER__FOLDERS);
		createEReference(configurationResourcesContainerEClass, CONFIGURATION_RESOURCES_CONTAINER__FILES);
		createEReference(configurationResourcesContainerEClass, CONFIGURATION_RESOURCES_CONTAINER__TEMPLATES);

		configurationFragmentContainerEClass = createEClass(CONFIGURATION_FRAGMENT_CONTAINER);
		createEAttribute(configurationFragmentContainerEClass, CONFIGURATION_FRAGMENT_CONTAINER__NAME);
		createEReference(configurationFragmentContainerEClass, CONFIGURATION_FRAGMENT_CONTAINER__FRAGMENTS);

		configurationComponentEClass = createEClass(CONFIGURATION_COMPONENT);
		createEReference(configurationComponentEClass, CONFIGURATION_COMPONENT__CLASSES);
		createEReference(configurationComponentEClass, CONFIGURATION_COMPONENT__ASPECTS);
		createEReference(configurationComponentEClass, CONFIGURATION_COMPONENT__TEMPLATES);
		createEReference(configurationComponentEClass, CONFIGURATION_COMPONENT__FILES);
		createEReference(configurationComponentEClass, CONFIGURATION_COMPONENT__SUB_COMPONENTS);

		configurationClassEClass = createEClass(CONFIGURATION_CLASS);

		configurationAspectEClass = createEClass(CONFIGURATION_ASPECT);

		configurationTemplateEClass = createEClass(CONFIGURATION_TEMPLATE);

		configurationFileEClass = createEClass(CONFIGURATION_FILE);

		configurationFolderEClass = createEClass(CONFIGURATION_FOLDER);
		createEReference(configurationFolderEClass, CONFIGURATION_FOLDER__SUB_FOLDERS);
		createEReference(configurationFolderEClass, CONFIGURATION_FOLDER__FILES);
		createEReference(configurationFolderEClass, CONFIGURATION_FOLDER__TEMPLATES);

		configurationFragmentEClass = createEClass(CONFIGURATION_FRAGMENT);

		featureExpressionEClass = createEClass(FEATURE_EXPRESSION);
		createEAttribute(featureExpressionEClass, FEATURE_EXPRESSION__EXPRESSION);
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
		configurationComponentEClass.getESuperTypes().add(this.getMappingEntity());
		configurationClassEClass.getESuperTypes().add(this.getMappingEntity());
		configurationAspectEClass.getESuperTypes().add(this.getMappingEntity());
		configurationTemplateEClass.getESuperTypes().add(this.getMappingEntity());
		configurationFileEClass.getESuperTypes().add(this.getMappingEntity());
		configurationFolderEClass.getESuperTypes().add(this.getMappingEntity());
		configurationFragmentEClass.getESuperTypes().add(this.getMappingEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_MappingRelationships(), this.getMappingRelationships(), null, "mappingRelationships", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingRelationshipsEClass, MappingRelationships.class, "MappingRelationships", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingRelationships_Containers(), this.getConfigurationContainer(), null, "containers", null, 0, -1, MappingRelationships.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingRelationships_ResourcesContainers(), this.getConfigurationResourcesContainer(), null, "resourcesContainers", null, 0, -1, MappingRelationships.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingRelationships_FragmentsContainer(), this.getConfigurationFragmentContainer(), null, "fragmentsContainer", null, 0, -1, MappingRelationships.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEntityEClass, MappingEntity.class, "MappingEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, MappingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingEntity_Path(), ecorePackage.getEString(), "path", null, 0, 1, MappingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingEntity_FeatureExpression(), this.getFeatureExpression(), null, "featureExpression", null, 1, 1, MappingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationContainerEClass, ConfigurationContainer.class, "ConfigurationContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConfigurationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationContainer_Components(), this.getConfigurationComponent(), null, "components", null, 0, -1, ConfigurationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationResourcesContainerEClass, ConfigurationResourcesContainer.class, "ConfigurationResourcesContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationResourcesContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConfigurationResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationResourcesContainer_Folders(), this.getConfigurationFolder(), null, "folders", null, 0, -1, ConfigurationResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationResourcesContainer_Files(), this.getConfigurationFile(), null, "files", null, 0, -1, ConfigurationResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationResourcesContainer_Templates(), this.getConfigurationTemplate(), null, "templates", null, 0, -1, ConfigurationResourcesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationFragmentContainerEClass, ConfigurationFragmentContainer.class, "ConfigurationFragmentContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationFragmentContainer_Name(), ecorePackage.getEString(), "name", "", 0, 1, ConfigurationFragmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationFragmentContainer_Fragments(), this.getConfigurationFragment(), null, "fragments", null, 0, -1, ConfigurationFragmentContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationComponentEClass, ConfigurationComponent.class, "ConfigurationComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationComponent_Classes(), this.getConfigurationClass(), null, "classes", null, 0, -1, ConfigurationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationComponent_Aspects(), this.getConfigurationAspect(), null, "aspects", null, 0, -1, ConfigurationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationComponent_Templates(), this.getConfigurationTemplate(), null, "templates", null, 0, -1, ConfigurationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationComponent_Files(), this.getConfigurationFile(), null, "files", null, 0, -1, ConfigurationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationComponent_SubComponents(), this.getConfigurationComponent(), null, "subComponents", null, 0, -1, ConfigurationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationClassEClass, ConfigurationClass.class, "ConfigurationClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(configurationAspectEClass, ConfigurationAspect.class, "ConfigurationAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(configurationTemplateEClass, ConfigurationTemplate.class, "ConfigurationTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(configurationFileEClass, ConfigurationFile.class, "ConfigurationFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(configurationFolderEClass, ConfigurationFolder.class, "ConfigurationFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationFolder_SubFolders(), this.getConfigurationFolder(), null, "subFolders", null, 0, -1, ConfigurationFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationFolder_Files(), this.getConfigurationFile(), null, "files", null, 0, -1, ConfigurationFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationFolder_Templates(), this.getConfigurationTemplate(), null, "templates", null, 0, -1, ConfigurationFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationFragmentEClass, ConfigurationFragment.class, "ConfigurationFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureExpressionEClass, FeatureExpression.class, "FeatureExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureExpression_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, FeatureExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

	

} //ConfigurationPackageImpl
