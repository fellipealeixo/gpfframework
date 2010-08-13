/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance;

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
 * @see br.pucrio.inf.les.genarch.models.instance.InstanceFactory
 * @model kind="package"
 * @generated
 */
public interface InstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "instance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///InstanceMetaModel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "br.pucrio.inf.les.genarch.models.instance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InstancePackage eINSTANCE = br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstanceImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__ARCHITECTURE = 0;

	/**
	 * The feature id for the '<em><b>Feature Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__FEATURE_INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl <em>Architecture Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureInstance()
	 * @generated
	 */
	int ARCHITECTURE_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__CLASSES = 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__ASPECTS = 1;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__FILES = 2;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__COMPONENTS = 3;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__FOLDERS = 4;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__FRAGMENTS = 5;

	/**
	 * The feature id for the '<em><b>Fragment Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS = 6;

	/**
	 * The number of structural features of the '<em>Architecture Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_INSTANCE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureEntityImpl <em>Architecture Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureEntityImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureEntity()
	 * @generated
	 */
	int ARCHITECTURE_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ENTITY__PATH = 1;

	/**
	 * The number of structural features of the '<em>Architecture Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ENTITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl <em>Architecture Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureComponent()
	 * @generated
	 */
	int ARCHITECTURE_COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__CLASSES = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__ASPECTS = ARCHITECTURE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__FILES = ARCHITECTURE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__SUB_COMPONENTS = ARCHITECTURE_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Architecture Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureClassImpl <em>Architecture Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureClassImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureClass()
	 * @generated
	 */
	int ARCHITECTURE_CLASS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CLASS__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CLASS__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The number of structural features of the '<em>Architecture Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CLASS_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureAspectImpl <em>Architecture Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureAspectImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureAspect()
	 * @generated
	 */
	int ARCHITECTURE_ASPECT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ASPECT__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ASPECT__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The number of structural features of the '<em>Architecture Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ASPECT_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFileImpl <em>Architecture File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFileImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFile()
	 * @generated
	 */
	int ARCHITECTURE_FILE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FILE__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FILE__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The number of structural features of the '<em>Architecture File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FILE_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFolderImpl <em>Architecture Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFolderImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFolder()
	 * @generated
	 */
	int ARCHITECTURE_FOLDER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Sub Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER__SUB_FOLDERS = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER__FILES = ARCHITECTURE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Architecture Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentImpl <em>Architecture Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFragment()
	 * @generated
	 */
	int ARCHITECTURE_FRAGMENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT__CONTENT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Architecture Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentContainerImpl <em>Architecture Fragment Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFragmentContainer()
	 * @generated
	 */
	int ARCHITECTURE_FRAGMENT_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT_CONTAINER__FRAGMENTS = 1;

	/**
	 * The number of structural features of the '<em>Architecture Fragment Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureInstanceImpl <em>Feature Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.FeatureInstanceImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getFeatureInstance()
	 * @generated
	 */
	int FEATURE_INSTANCE = 10;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Feature Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl
	 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__MAX = 3;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__MIN = 4;

	/**
	 * The feature id for the '<em><b>Is Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_SELECTED = 5;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__FEATURES = 6;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the containment reference '{@link br.pucrio.inf.les.genarch.models.instance.Instance#getArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Architecture</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Instance#getArchitecture()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Architecture();

	/**
	 * Returns the meta object for the containment reference '{@link br.pucrio.inf.les.genarch.models.instance.Instance#getFeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Instance</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Instance#getFeatureInstance()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_FeatureInstance();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance <em>Architecture Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Instance</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance
	 * @generated
	 */
	EClass getArchitectureInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getClasses()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getAspects()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_Aspects();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFiles()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getComponents()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFolders()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFragments()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_Fragments();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFragmentContainers <em>Fragment Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragment Containers</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance#getFragmentContainers()
	 * @see #getArchitectureInstance()
	 * @generated
	 */
	EReference getArchitectureInstance_FragmentContainers();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity <em>Architecture Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Entity</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity
	 * @generated
	 */
	EClass getArchitectureEntity();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity#getName()
	 * @see #getArchitectureEntity()
	 * @generated
	 */
	EAttribute getArchitectureEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity#getPath()
	 * @see #getArchitectureEntity()
	 * @generated
	 */
	EAttribute getArchitectureEntity_Path();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent <em>Architecture Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Component</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent
	 * @generated
	 */
	EClass getArchitectureComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getClasses()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getAspects()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Aspects();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getFiles()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Components</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent#getSubComponents()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_SubComponents();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureClass <em>Architecture Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Class</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureClass
	 * @generated
	 */
	EClass getArchitectureClass();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect <em>Architecture Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Aspect</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect
	 * @generated
	 */
	EClass getArchitectureAspect();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFile <em>Architecture File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture File</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFile
	 * @generated
	 */
	EClass getArchitectureFile();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder <em>Architecture Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Folder</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder
	 * @generated
	 */
	EClass getArchitectureFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder#getSubFolders <em>Sub Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Folders</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder#getSubFolders()
	 * @see #getArchitectureFolder()
	 * @generated
	 */
	EReference getArchitectureFolder_SubFolders();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder#getFiles()
	 * @see #getArchitectureFolder()
	 * @generated
	 */
	EReference getArchitectureFolder_Files();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment <em>Architecture Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Fragment</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment
	 * @generated
	 */
	EClass getArchitectureFragment();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment#getContent()
	 * @see #getArchitectureFragment()
	 * @generated
	 */
	EAttribute getArchitectureFragment_Content();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer <em>Architecture Fragment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture Fragment Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer
	 * @generated
	 */
	EClass getArchitectureFragmentContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getName()
	 * @see #getArchitectureFragmentContainer()
	 * @generated
	 */
	EAttribute getArchitectureFragmentContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer#getFragments()
	 * @see #getArchitectureFragmentContainer()
	 * @generated
	 */
	EReference getArchitectureFragmentContainer_Fragments();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.FeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Instance</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.FeatureInstance
	 * @generated
	 */
	EClass getFeatureInstance();

	/**
	 * Returns the meta object for the containment reference '{@link br.pucrio.inf.les.genarch.models.instance.FeatureInstance#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.FeatureInstance#getRoot()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EReference getFeatureInstance_Root();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.FeatureInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.FeatureInstance#getName()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EAttribute getFeatureInstance_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.FeatureInstance#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.FeatureInstance#getAttribute()
	 * @see #getFeatureInstance()
	 * @generated
	 */
	EAttribute getFeatureInstance_Attribute();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.instance.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.Feature#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#getAttribute()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.Feature#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#getMax()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Max();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.Feature#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#getMin()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Min();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.instance.Feature#isIsSelected <em>Is Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Selected</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#isIsSelected()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_IsSelected();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.instance.Feature#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see br.pucrio.inf.les.genarch.models.instance.Feature#getFeatures()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Features();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InstanceFactory getInstanceFactory();

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
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstanceImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__ARCHITECTURE = eINSTANCE.getInstance_Architecture();

		/**
		 * The meta object literal for the '<em><b>Feature Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__FEATURE_INSTANCE = eINSTANCE.getInstance_FeatureInstance();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl <em>Architecture Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureInstanceImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureInstance()
		 * @generated
		 */
		EClass ARCHITECTURE_INSTANCE = eINSTANCE.getArchitectureInstance();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__CLASSES = eINSTANCE.getArchitectureInstance_Classes();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__ASPECTS = eINSTANCE.getArchitectureInstance_Aspects();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__FILES = eINSTANCE.getArchitectureInstance_Files();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__COMPONENTS = eINSTANCE.getArchitectureInstance_Components();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__FOLDERS = eINSTANCE.getArchitectureInstance_Folders();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__FRAGMENTS = eINSTANCE.getArchitectureInstance_Fragments();

		/**
		 * The meta object literal for the '<em><b>Fragment Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_INSTANCE__FRAGMENT_CONTAINERS = eINSTANCE.getArchitectureInstance_FragmentContainers();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureEntityImpl <em>Architecture Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureEntityImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureEntity()
		 * @generated
		 */
		EClass ARCHITECTURE_ENTITY = eINSTANCE.getArchitectureEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_ENTITY__NAME = eINSTANCE.getArchitectureEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_ENTITY__PATH = eINSTANCE.getArchitectureEntity_Path();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl <em>Architecture Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureComponentImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureComponent()
		 * @generated
		 */
		EClass ARCHITECTURE_COMPONENT = eINSTANCE.getArchitectureComponent();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_COMPONENT__CLASSES = eINSTANCE.getArchitectureComponent_Classes();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_COMPONENT__ASPECTS = eINSTANCE.getArchitectureComponent_Aspects();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_COMPONENT__FILES = eINSTANCE.getArchitectureComponent_Files();

		/**
		 * The meta object literal for the '<em><b>Sub Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_COMPONENT__SUB_COMPONENTS = eINSTANCE.getArchitectureComponent_SubComponents();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureClassImpl <em>Architecture Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureClassImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureClass()
		 * @generated
		 */
		EClass ARCHITECTURE_CLASS = eINSTANCE.getArchitectureClass();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureAspectImpl <em>Architecture Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureAspectImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureAspect()
		 * @generated
		 */
		EClass ARCHITECTURE_ASPECT = eINSTANCE.getArchitectureAspect();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFileImpl <em>Architecture File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFileImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFile()
		 * @generated
		 */
		EClass ARCHITECTURE_FILE = eINSTANCE.getArchitectureFile();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFolderImpl <em>Architecture Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFolderImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFolder()
		 * @generated
		 */
		EClass ARCHITECTURE_FOLDER = eINSTANCE.getArchitectureFolder();

		/**
		 * The meta object literal for the '<em><b>Sub Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FOLDER__SUB_FOLDERS = eINSTANCE.getArchitectureFolder_SubFolders();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FOLDER__FILES = eINSTANCE.getArchitectureFolder_Files();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentImpl <em>Architecture Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFragment()
		 * @generated
		 */
		EClass ARCHITECTURE_FRAGMENT = eINSTANCE.getArchitectureFragment();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_FRAGMENT__CONTENT = eINSTANCE.getArchitectureFragment_Content();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentContainerImpl <em>Architecture Fragment Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.ArchitectureFragmentContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getArchitectureFragmentContainer()
		 * @generated
		 */
		EClass ARCHITECTURE_FRAGMENT_CONTAINER = eINSTANCE.getArchitectureFragmentContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_FRAGMENT_CONTAINER__NAME = eINSTANCE.getArchitectureFragmentContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FRAGMENT_CONTAINER__FRAGMENTS = eINSTANCE.getArchitectureFragmentContainer_Fragments();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureInstanceImpl <em>Feature Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.FeatureInstanceImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getFeatureInstance()
		 * @generated
		 */
		EClass FEATURE_INSTANCE = eINSTANCE.getFeatureInstance();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INSTANCE__ROOT = eINSTANCE.getFeatureInstance_Root();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INSTANCE__NAME = eINSTANCE.getFeatureInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INSTANCE__ATTRIBUTE = eINSTANCE.getFeatureInstance_Attribute();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.FeatureImpl
		 * @see br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ATTRIBUTE = eINSTANCE.getFeature_Attribute();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__MAX = eINSTANCE.getFeature_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__MIN = eINSTANCE.getFeature_Min();

		/**
		 * The meta object literal for the '<em><b>Is Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IS_SELECTED = eINSTANCE.getFeature_IsSelected();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__FEATURES = eINSTANCE.getFeature_Features();

	}

} //InstancePackage
