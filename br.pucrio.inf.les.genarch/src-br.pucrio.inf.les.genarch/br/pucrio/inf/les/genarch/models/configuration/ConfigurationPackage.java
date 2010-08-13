/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///ConfigurationMetaModel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "br.pucrio.inf.les.genarch.models.configuration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Mapping Relationships</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAPPING_RELATIONSHIPS = 0;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.MappingRelationshipsImpl <em>Mapping Relationships</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.MappingRelationshipsImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getMappingRelationships()
	 * @generated
	 */
	int MAPPING_RELATIONSHIPS = 1;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RELATIONSHIPS__CONTAINERS = 0;

	/**
	 * The feature id for the '<em><b>Resources Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RELATIONSHIPS__RESOURCES_CONTAINERS = 1;

	/**
	 * The feature id for the '<em><b>Fragments Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RELATIONSHIPS__FRAGMENTS_CONTAINER = 2;

	/**
	 * The number of structural features of the '<em>Mapping Relationships</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RELATIONSHIPS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.MappingEntityImpl <em>Mapping Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.MappingEntityImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getMappingEntity()
	 * @generated
	 */
	int MAPPING_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY__PATH = 1;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY__FEATURE_EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Mapping Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationContainer()
	 * @generated
	 */
	int CONFIGURATION_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTAINER__COMPONENTS = 1;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationResourcesContainerImpl <em>Resources Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationResourcesContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationResourcesContainer()
	 * @generated
	 */
	int CONFIGURATION_RESOURCES_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESOURCES_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESOURCES_CONTAINER__FOLDERS = 1;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESOURCES_CONTAINER__FILES = 2;

	/**
	 * The feature id for the '<em><b>Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESOURCES_CONTAINER__TEMPLATES = 3;

	/**
	 * The number of structural features of the '<em>Resources Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_RESOURCES_CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentContainerImpl <em>Fragment Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFragmentContainer()
	 * @generated
	 */
	int CONFIGURATION_FRAGMENT_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT_CONTAINER__FRAGMENTS = 1;

	/**
	 * The number of structural features of the '<em>Fragment Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationComponentImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationComponent()
	 * @generated
	 */
	int CONFIGURATION_COMPONENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__CLASSES = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__ASPECTS = MAPPING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__TEMPLATES = MAPPING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__FILES = MAPPING_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT__SUB_COMPONENTS = MAPPING_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_COMPONENT_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationClassImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationClass()
	 * @generated
	 */
	int CONFIGURATION_CLASS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CLASS__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CLASS__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CLASS__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CLASS_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationAspectImpl <em>Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationAspectImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationAspect()
	 * @generated
	 */
	int CONFIGURATION_ASPECT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ASPECT__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ASPECT__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ASPECT__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ASPECT_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationTemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationTemplateImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationTemplate()
	 * @generated
	 */
	int CONFIGURATION_TEMPLATE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_TEMPLATE__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_TEMPLATE__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_TEMPLATE__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_TEMPLATE_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFileImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFile()
	 * @generated
	 */
	int CONFIGURATION_FILE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FILE__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FILE__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FILE__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FILE_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFolder()
	 * @generated
	 */
	int CONFIGURATION_FOLDER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Sub Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER__SUB_FOLDERS = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER__FILES = MAPPING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER__TEMPLATES = MAPPING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FOLDER_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentImpl <em>Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFragment()
	 * @generated
	 */
	int CONFIGURATION_FRAGMENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT__NAME = MAPPING_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT__PATH = MAPPING_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Feature Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT__FEATURE_EXPRESSION = MAPPING_ENTITY__FEATURE_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FRAGMENT_FEATURE_COUNT = MAPPING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.FeatureExpressionImpl <em>Feature Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.FeatureExpressionImpl
	 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getFeatureExpression()
	 * @generated
	 */
	int FEATURE_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXPRESSION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Feature Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_EXPRESSION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link br.pucrio.inf.les.genarch.models.configuration.Configuration#getMappingRelationships <em>Mapping Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Relationships</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.Configuration#getMappingRelationships()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_MappingRelationships();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships <em>Mapping Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Relationships</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingRelationships
	 * @generated
	 */
	EClass getMappingRelationships();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containers</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getContainers()
	 * @see #getMappingRelationships()
	 * @generated
	 */
	EReference getMappingRelationships_Containers();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getResourcesContainers <em>Resources Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources Containers</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getResourcesContainers()
	 * @see #getMappingRelationships()
	 * @generated
	 */
	EReference getMappingRelationships_ResourcesContainers();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getFragmentsContainer <em>Fragments Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingRelationships#getFragmentsContainer()
	 * @see #getMappingRelationships()
	 * @generated
	 */
	EReference getMappingRelationships_FragmentsContainer();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.MappingEntity <em>Mapping Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Entity</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingEntity
	 * @generated
	 */
	EClass getMappingEntity();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.configuration.MappingEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingEntity#getName()
	 * @see #getMappingEntity()
	 * @generated
	 */
	EAttribute getMappingEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.configuration.MappingEntity#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingEntity#getPath()
	 * @see #getMappingEntity()
	 * @generated
	 */
	EAttribute getMappingEntity_Path();

	/**
	 * Returns the meta object for the containment reference '{@link br.pucrio.inf.les.genarch.models.configuration.MappingEntity#getFeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Expression</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingEntity#getFeatureExpression()
	 * @see #getMappingEntity()
	 * @generated
	 */
	EReference getMappingEntity_FeatureExpression();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer
	 * @generated
	 */
	EClass getConfigurationContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getName()
	 * @see #getConfigurationContainer()
	 * @generated
	 */
	EAttribute getConfigurationContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer#getComponents()
	 * @see #getConfigurationContainer()
	 * @generated
	 */
	EReference getConfigurationContainer_Components();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer <em>Resources Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resources Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer
	 * @generated
	 */
	EClass getConfigurationResourcesContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getName()
	 * @see #getConfigurationResourcesContainer()
	 * @generated
	 */
	EAttribute getConfigurationResourcesContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getFolders()
	 * @see #getConfigurationResourcesContainer()
	 * @generated
	 */
	EReference getConfigurationResourcesContainer_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getFiles()
	 * @see #getConfigurationResourcesContainer()
	 * @generated
	 */
	EReference getConfigurationResourcesContainer_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer#getTemplates()
	 * @see #getConfigurationResourcesContainer()
	 * @generated
	 */
	EReference getConfigurationResourcesContainer_Templates();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer <em>Fragment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer
	 * @generated
	 */
	EClass getConfigurationFragmentContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer#getName()
	 * @see #getConfigurationFragmentContainer()
	 * @generated
	 */
	EAttribute getConfigurationFragmentContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer#getFragments()
	 * @see #getConfigurationFragmentContainer()
	 * @generated
	 */
	EReference getConfigurationFragmentContainer_Fragments();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent
	 * @generated
	 */
	EClass getConfigurationComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getClasses()
	 * @see #getConfigurationComponent()
	 * @generated
	 */
	EReference getConfigurationComponent_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getAspects()
	 * @see #getConfigurationComponent()
	 * @generated
	 */
	EReference getConfigurationComponent_Aspects();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getTemplates()
	 * @see #getConfigurationComponent()
	 * @generated
	 */
	EReference getConfigurationComponent_Templates();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getFiles()
	 * @see #getConfigurationComponent()
	 * @generated
	 */
	EReference getConfigurationComponent_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Components</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent#getSubComponents()
	 * @see #getConfigurationComponent()
	 * @generated
	 */
	EReference getConfigurationComponent_SubComponents();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass
	 * @generated
	 */
	EClass getConfigurationClass();
	
	
	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass
	 * @generated
	 */
	EClass getConfigurationProcess();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect
	 * @generated
	 */
	EClass getConfigurationAspect();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate
	 * @generated
	 */
	EClass getConfigurationTemplate();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile
	 * @generated
	 */
	EClass getConfigurationFile();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder
	 * @generated
	 */
	EClass getConfigurationFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getSubFolders <em>Sub Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Folders</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getSubFolders()
	 * @see #getConfigurationFolder()
	 * @generated
	 */
	EReference getConfigurationFolder_SubFolders();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getFiles()
	 * @see #getConfigurationFolder()
	 * @generated
	 */
	EReference getConfigurationFolder_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder#getTemplates()
	 * @see #getConfigurationFolder()
	 * @generated
	 */
	EReference getConfigurationFolder_Templates();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment
	 * @generated
	 */
	EClass getConfigurationFragment();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.configuration.FeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Expression</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.FeatureExpression
	 * @generated
	 */
	EClass getFeatureExpression();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.configuration.FeatureExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see br.pucrio.inf.les.genarch.models.configuration.FeatureExpression#getExpression()
	 * @see #getFeatureExpression()
	 * @generated
	 */
	EAttribute getFeatureExpression_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Mapping Relationships</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MAPPING_RELATIONSHIPS = eINSTANCE.getConfiguration_MappingRelationships();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.MappingRelationshipsImpl <em>Mapping Relationships</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.MappingRelationshipsImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getMappingRelationships()
		 * @generated
		 */
		EClass MAPPING_RELATIONSHIPS = eINSTANCE.getMappingRelationships();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RELATIONSHIPS__CONTAINERS = eINSTANCE.getMappingRelationships_Containers();

		/**
		 * The meta object literal for the '<em><b>Resources Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RELATIONSHIPS__RESOURCES_CONTAINERS = eINSTANCE.getMappingRelationships_ResourcesContainers();

		/**
		 * The meta object literal for the '<em><b>Fragments Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RELATIONSHIPS__FRAGMENTS_CONTAINER = eINSTANCE.getMappingRelationships_FragmentsContainer();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.MappingEntityImpl <em>Mapping Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.MappingEntityImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getMappingEntity()
		 * @generated
		 */
		EClass MAPPING_ENTITY = eINSTANCE.getMappingEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_ENTITY__NAME = eINSTANCE.getMappingEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_ENTITY__PATH = eINSTANCE.getMappingEntity_Path();

		/**
		 * The meta object literal for the '<em><b>Feature Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ENTITY__FEATURE_EXPRESSION = eINSTANCE.getMappingEntity_FeatureExpression();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationContainer()
		 * @generated
		 */
		EClass CONFIGURATION_CONTAINER = eINSTANCE.getConfigurationContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_CONTAINER__NAME = eINSTANCE.getConfigurationContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_CONTAINER__COMPONENTS = eINSTANCE.getConfigurationContainer_Components();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationResourcesContainerImpl <em>Resources Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationResourcesContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationResourcesContainer()
		 * @generated
		 */
		EClass CONFIGURATION_RESOURCES_CONTAINER = eINSTANCE.getConfigurationResourcesContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_RESOURCES_CONTAINER__NAME = eINSTANCE.getConfigurationResourcesContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_RESOURCES_CONTAINER__FOLDERS = eINSTANCE.getConfigurationResourcesContainer_Folders();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_RESOURCES_CONTAINER__FILES = eINSTANCE.getConfigurationResourcesContainer_Files();

		/**
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_RESOURCES_CONTAINER__TEMPLATES = eINSTANCE.getConfigurationResourcesContainer_Templates();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentContainerImpl <em>Fragment Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFragmentContainer()
		 * @generated
		 */
		EClass CONFIGURATION_FRAGMENT_CONTAINER = eINSTANCE.getConfigurationFragmentContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_FRAGMENT_CONTAINER__NAME = eINSTANCE.getConfigurationFragmentContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_FRAGMENT_CONTAINER__FRAGMENTS = eINSTANCE.getConfigurationFragmentContainer_Fragments();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationComponentImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationComponent()
		 * @generated
		 */
		EClass CONFIGURATION_COMPONENT = eINSTANCE.getConfigurationComponent();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_COMPONENT__CLASSES = eINSTANCE.getConfigurationComponent_Classes();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_COMPONENT__ASPECTS = eINSTANCE.getConfigurationComponent_Aspects();

		/**
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_COMPONENT__TEMPLATES = eINSTANCE.getConfigurationComponent_Templates();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_COMPONENT__FILES = eINSTANCE.getConfigurationComponent_Files();

		/**
		 * The meta object literal for the '<em><b>Sub Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_COMPONENT__SUB_COMPONENTS = eINSTANCE.getConfigurationComponent_SubComponents();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationClassImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationClass()
		 * @generated
		 */
		EClass CONFIGURATION_CLASS = eINSTANCE.getConfigurationClass();
		
		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationClassImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationClass()
		 * @generated
		 */
		EClass CONFIGURATION_PROCESS = eINSTANCE.getConfigurationClass();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationAspectImpl <em>Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationAspectImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationAspect()
		 * @generated
		 */
		EClass CONFIGURATION_ASPECT = eINSTANCE.getConfigurationAspect();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationTemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationTemplateImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationTemplate()
		 * @generated
		 */
		EClass CONFIGURATION_TEMPLATE = eINSTANCE.getConfigurationTemplate();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFileImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFile()
		 * @generated
		 */
		EClass CONFIGURATION_FILE = eINSTANCE.getConfigurationFile();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFolderImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFolder()
		 * @generated
		 */
		EClass CONFIGURATION_FOLDER = eINSTANCE.getConfigurationFolder();

		/**
		 * The meta object literal for the '<em><b>Sub Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_FOLDER__SUB_FOLDERS = eINSTANCE.getConfigurationFolder_SubFolders();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_FOLDER__FILES = eINSTANCE.getConfigurationFolder_Files();

		/**
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_FOLDER__TEMPLATES = eINSTANCE.getConfigurationFolder_Templates();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentImpl <em>Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationFragmentImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getConfigurationFragment()
		 * @generated
		 */
		EClass CONFIGURATION_FRAGMENT = eINSTANCE.getConfigurationFragment();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.configuration.impl.FeatureExpressionImpl <em>Feature Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.FeatureExpressionImpl
		 * @see br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl#getFeatureExpression()
		 * @generated
		 */
		EClass FEATURE_EXPRESSION = eINSTANCE.getFeatureExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_EXPRESSION__EXPRESSION = eINSTANCE.getFeatureExpression_Expression();

	}

} //ConfigurationPackage
