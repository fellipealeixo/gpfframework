/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.impl;

import br.pucrio.inf.les.genarch.models.configuration.*;

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
public class ConfigurationFactoryImpl extends EFactoryImpl implements ConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigurationFactory init() {
		try {
			ConfigurationFactory theConfigurationFactory = (ConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http:///ConfigurationMetaModel.ecore"); 
			if (theConfigurationFactory != null) {
				return theConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConfigurationPackage.CONFIGURATION: return createConfiguration();
			case ConfigurationPackage.MAPPING_RELATIONSHIPS: return createMappingRelationships();
			case ConfigurationPackage.MAPPING_ENTITY: return createMappingEntity();
			case ConfigurationPackage.CONFIGURATION_CONTAINER: return createConfigurationContainer();
			case ConfigurationPackage.CONFIGURATION_RESOURCES_CONTAINER: return createConfigurationResourcesContainer();
			case ConfigurationPackage.CONFIGURATION_FRAGMENT_CONTAINER: return createConfigurationFragmentContainer();
			case ConfigurationPackage.CONFIGURATION_COMPONENT: return createConfigurationComponent();
			case ConfigurationPackage.CONFIGURATION_CLASS: return createConfigurationClass();
			case ConfigurationPackage.CONFIGURATION_ASPECT: return createConfigurationAspect();
			case ConfigurationPackage.CONFIGURATION_TEMPLATE: return createConfigurationTemplate();
			case ConfigurationPackage.CONFIGURATION_FILE: return createConfigurationFile();
			case ConfigurationPackage.CONFIGURATION_FOLDER: return createConfigurationFolder();
			case ConfigurationPackage.CONFIGURATION_FRAGMENT: return createConfigurationFragment();
			case ConfigurationPackage.FEATURE_EXPRESSION: return createFeatureExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRelationships createMappingRelationships() {
		MappingRelationshipsImpl mappingRelationships = new MappingRelationshipsImpl();
		return mappingRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEntity createMappingEntity() {
		MappingEntityImpl mappingEntity = new MappingEntityImpl();
		return mappingEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationContainer createConfigurationContainer() {
		ConfigurationContainerImpl configurationContainer = new ConfigurationContainerImpl();
		return configurationContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationResourcesContainer createConfigurationResourcesContainer() {
		ConfigurationResourcesContainerImpl configurationResourcesContainer = new ConfigurationResourcesContainerImpl();
		return configurationResourcesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFragmentContainer createConfigurationFragmentContainer() {
		ConfigurationFragmentContainerImpl configurationFragmentContainer = new ConfigurationFragmentContainerImpl();
		return configurationFragmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationComponent createConfigurationComponent() {
		ConfigurationComponentImpl configurationComponent = new ConfigurationComponentImpl();
		return configurationComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationClass createConfigurationClass() {
		ConfigurationClassImpl configurationClass = new ConfigurationClassImpl();
		return configurationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationAspect createConfigurationAspect() {
		ConfigurationAspectImpl configurationAspect = new ConfigurationAspectImpl();
		return configurationAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationTemplate createConfigurationTemplate() {
		ConfigurationTemplateImpl configurationTemplate = new ConfigurationTemplateImpl();
		return configurationTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFile createConfigurationFile() {
		ConfigurationFileImpl configurationFile = new ConfigurationFileImpl();
		return configurationFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFolder createConfigurationFolder() {
		ConfigurationFolderImpl configurationFolder = new ConfigurationFolderImpl();
		return configurationFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationFragment createConfigurationFragment() {
		ConfigurationFragmentImpl configurationFragment = new ConfigurationFragmentImpl();
		return configurationFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureExpression createFeatureExpression() {
		FeatureExpressionImpl featureExpression = new FeatureExpressionImpl();
		return featureExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationPackage getConfigurationPackage() {
		return (ConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ConfigurationPackage getPackage() {
		return ConfigurationPackage.eINSTANCE;
	}

} //ConfigurationFactoryImpl
