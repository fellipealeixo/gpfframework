/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture;

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
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///ArchitectureMetaModel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "br.pucrio.inf.les.genarch.models.architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl <em>Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitecture()
	 * @generated
	 */
	int ARCHITECTURE = 0;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__CONTAINERS = 0;

	/**
	 * The feature id for the '<em><b>Resources Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__RESOURCES_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Fragments Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__FRAGMENTS_CONTAINER = 2;

	/**
	 * The number of structural features of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureContainer()
	 * @generated
	 */
	int ARCHITECTURE_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTAINER__COMPONENTS = 1;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureResourcesContainerImpl <em>Resources Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureResourcesContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureResourcesContainer()
	 * @generated
	 */
	int ARCHITECTURE_RESOURCES_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RESOURCES_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RESOURCES_CONTAINER__FOLDERS = 1;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RESOURCES_CONTAINER__FILES = 2;

	/**
	 * The feature id for the '<em><b>Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RESOURCES_CONTAINER__TEMPLATES = 3;

	/**
	 * The number of structural features of the '<em>Resources Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_RESOURCES_CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentContainerImpl <em>Fragment Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentContainerImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFragmentContainer()
	 * @generated
	 */
	int ARCHITECTURE_FRAGMENT_CONTAINER = 3;

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
	 * The number of structural features of the '<em>Fragment Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureEntity()
	 * @generated
	 */
	int ARCHITECTURE_ENTITY = 4;

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
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ENTITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureComponent()
	 * @generated
	 */
	int ARCHITECTURE_COMPONENT = 5;

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
	 * The feature id for the '<em><b>Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__TEMPLATES = ARCHITECTURE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__FILES = ARCHITECTURE_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT__SUB_COMPONENTS = ARCHITECTURE_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_COMPONENT_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureClassImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureClass()
	 * @generated
	 */
	int ARCHITECTURE_CLASS = 6;

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
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CLASS_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureAspectImpl <em>Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureAspectImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureAspect()
	 * @generated
	 */
	int ARCHITECTURE_ASPECT = 7;

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
	 * The number of structural features of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_ASPECT_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFileImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFile()
	 * @generated
	 */
	int ARCHITECTURE_FILE = 8;

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
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FILE_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureTemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureTemplateImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureTemplate()
	 * @generated
	 */
	int ARCHITECTURE_TEMPLATE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_TEMPLATE__NAME = ARCHITECTURE_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_TEMPLATE__PATH = ARCHITECTURE_ENTITY__PATH;

	/**
	 * The feature id for the '<em><b>Generation Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_TEMPLATE__GENERATION_PATH = ARCHITECTURE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_TEMPLATE_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFolderImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFolder()
	 * @generated
	 */
	int ARCHITECTURE_FOLDER = 10;

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
	 * The feature id for the '<em><b>Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER__TEMPLATES = ARCHITECTURE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FOLDER_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentImpl <em>Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentImpl
	 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFragment()
	 * @generated
	 */
	int ARCHITECTURE_FRAGMENT = 11;

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
	 * The number of structural features of the '<em>Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAGMENT_FEATURE_COUNT = ARCHITECTURE_ENTITY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.Architecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.Architecture
	 * @generated
	 */
	EClass getArchitecture();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.Architecture#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containers</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.Architecture#getContainers()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_Containers();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.Architecture#getResourcesContainer <em>Resources Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.Architecture#getResourcesContainer()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_ResourcesContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.Architecture#getFragmentsContainer <em>Fragments Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.Architecture#getFragmentsContainer()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_FragmentsContainer();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer
	 * @generated
	 */
	EClass getArchitectureContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer#getName()
	 * @see #getArchitectureContainer()
	 * @generated
	 */
	EAttribute getArchitectureContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer#getComponents()
	 * @see #getArchitectureContainer()
	 * @generated
	 */
	EReference getArchitectureContainer_Components();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer <em>Resources Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resources Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer
	 * @generated
	 */
	EClass getArchitectureResourcesContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getName()
	 * @see #getArchitectureResourcesContainer()
	 * @generated
	 */
	EAttribute getArchitectureResourcesContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getFolders()
	 * @see #getArchitectureResourcesContainer()
	 * @generated
	 */
	EReference getArchitectureResourcesContainer_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getFiles()
	 * @see #getArchitectureResourcesContainer()
	 * @generated
	 */
	EReference getArchitectureResourcesContainer_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer#getTemplates()
	 * @see #getArchitectureResourcesContainer()
	 * @generated
	 */
	EReference getArchitectureResourcesContainer_Templates();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer <em>Fragment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Container</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer
	 * @generated
	 */
	EClass getArchitectureFragmentContainer();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer#getName()
	 * @see #getArchitectureFragmentContainer()
	 * @generated
	 */
	EAttribute getArchitectureFragmentContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer#getFragments()
	 * @see #getArchitectureFragmentContainer()
	 * @generated
	 */
	EReference getArchitectureFragmentContainer_Fragments();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity
	 * @generated
	 */
	EClass getArchitectureEntity();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getName()
	 * @see #getArchitectureEntity()
	 * @generated
	 */
	EAttribute getArchitectureEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getPath()
	 * @see #getArchitectureEntity()
	 * @generated
	 */
	EAttribute getArchitectureEntity_Path();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent
	 * @generated
	 */
	EClass getArchitectureComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getClasses()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getAspects()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Aspects();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getTemplates()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Templates();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getFiles()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Components</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent#getSubComponents()
	 * @see #getArchitectureComponent()
	 * @generated
	 */
	EReference getArchitectureComponent_SubComponents();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass
	 * @generated
	 */
	EClass getArchitectureClass();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect
	 * @generated
	 */
	EClass getArchitectureAspect();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile
	 * @generated
	 */
	EClass getArchitectureFile();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate
	 * @generated
	 */
	EClass getArchitectureTemplate();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate#getGenerationPath <em>Generation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Path</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate#getGenerationPath()
	 * @see #getArchitectureTemplate()
	 * @generated
	 */
	EAttribute getArchitectureTemplate_GenerationPath();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder
	 * @generated
	 */
	EClass getArchitectureFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getSubFolders <em>Sub Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Folders</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getSubFolders()
	 * @see #getArchitectureFolder()
	 * @generated
	 */
	EReference getArchitectureFolder_SubFolders();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getFiles()
	 * @see #getArchitectureFolder()
	 * @generated
	 */
	EReference getArchitectureFolder_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder#getTemplates()
	 * @see #getArchitectureFolder()
	 * @generated
	 */
	EReference getArchitectureFolder_Templates();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment
	 * @generated
	 */
	EClass getArchitectureFragment();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment#getContent()
	 * @see #getArchitectureFragment()
	 * @generated
	 */
	EAttribute getArchitectureFragment_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

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
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl <em>Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitecture()
		 * @generated
		 */
		EClass ARCHITECTURE = eINSTANCE.getArchitecture();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__CONTAINERS = eINSTANCE.getArchitecture_Containers();

		/**
		 * The meta object literal for the '<em><b>Resources Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__RESOURCES_CONTAINER = eINSTANCE.getArchitecture_ResourcesContainer();

		/**
		 * The meta object literal for the '<em><b>Fragments Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__FRAGMENTS_CONTAINER = eINSTANCE.getArchitecture_FragmentsContainer();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureContainer()
		 * @generated
		 */
		EClass ARCHITECTURE_CONTAINER = eINSTANCE.getArchitectureContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_CONTAINER__NAME = eINSTANCE.getArchitectureContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_CONTAINER__COMPONENTS = eINSTANCE.getArchitectureContainer_Components();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureResourcesContainerImpl <em>Resources Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureResourcesContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureResourcesContainer()
		 * @generated
		 */
		EClass ARCHITECTURE_RESOURCES_CONTAINER = eINSTANCE.getArchitectureResourcesContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_RESOURCES_CONTAINER__NAME = eINSTANCE.getArchitectureResourcesContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_RESOURCES_CONTAINER__FOLDERS = eINSTANCE.getArchitectureResourcesContainer_Folders();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_RESOURCES_CONTAINER__FILES = eINSTANCE.getArchitectureResourcesContainer_Files();

		/**
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_RESOURCES_CONTAINER__TEMPLATES = eINSTANCE.getArchitectureResourcesContainer_Templates();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentContainerImpl <em>Fragment Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentContainerImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFragmentContainer()
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
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureEntity()
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
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureComponentImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureComponent()
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
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_COMPONENT__TEMPLATES = eINSTANCE.getArchitectureComponent_Templates();

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
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureClassImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureClass()
		 * @generated
		 */
		EClass ARCHITECTURE_CLASS = eINSTANCE.getArchitectureClass();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureAspectImpl <em>Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureAspectImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureAspect()
		 * @generated
		 */
		EClass ARCHITECTURE_ASPECT = eINSTANCE.getArchitectureAspect();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFileImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFile()
		 * @generated
		 */
		EClass ARCHITECTURE_FILE = eINSTANCE.getArchitectureFile();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureTemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureTemplateImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureTemplate()
		 * @generated
		 */
		EClass ARCHITECTURE_TEMPLATE = eINSTANCE.getArchitectureTemplate();

		/**
		 * The meta object literal for the '<em><b>Generation Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_TEMPLATE__GENERATION_PATH = eINSTANCE.getArchitectureTemplate_GenerationPath();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFolderImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFolder()
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
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_FOLDER__TEMPLATES = eINSTANCE.getArchitectureFolder_Templates();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentImpl <em>Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureFragmentImpl
		 * @see br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl#getArchitectureFragment()
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

	}

} //ArchitecturePackage
