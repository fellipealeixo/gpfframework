/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.util;

import br.pucrio.inf.les.genarch.models.configuration.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigurationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationSwitch modelSwitch =
		new ConfigurationSwitch() {
			public Object caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			public Object caseMappingRelationships(MappingRelationships object) {
				return createMappingRelationshipsAdapter();
			}
			public Object caseMappingEntity(MappingEntity object) {
				return createMappingEntityAdapter();
			}
			public Object caseConfigurationContainer(ConfigurationContainer object) {
				return createConfigurationContainerAdapter();
			}
			public Object caseConfigurationResourcesContainer(ConfigurationResourcesContainer object) {
				return createConfigurationResourcesContainerAdapter();
			}
			public Object caseConfigurationFragmentContainer(ConfigurationFragmentContainer object) {
				return createConfigurationFragmentContainerAdapter();
			}
			public Object caseConfigurationComponent(ConfigurationComponent object) {
				return createConfigurationComponentAdapter();
			}
			public Object caseConfigurationClass(ConfigurationClass object) {
				return createConfigurationClassAdapter();
			}
			public Object caseConfigurationAspect(ConfigurationAspect object) {
				return createConfigurationAspectAdapter();
			}
			public Object caseConfigurationTemplate(ConfigurationTemplate object) {
				return createConfigurationTemplateAdapter();
			}
			public Object caseConfigurationFile(ConfigurationFile object) {
				return createConfigurationFileAdapter();
			}
			public Object caseConfigurationFolder(ConfigurationFolder object) {
				return createConfigurationFolderAdapter();
			}
			public Object caseConfigurationFragment(ConfigurationFragment object) {
				return createConfigurationFragmentAdapter();
			}
			public Object caseFeatureExpression(FeatureExpression object) {
				return createFeatureExpressionAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.MappingRelationships <em>Mapping Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingRelationships
	 * @generated
	 */
	public Adapter createMappingRelationshipsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.MappingEntity <em>Mapping Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.MappingEntity
	 * @generated
	 */
	public Adapter createMappingEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationContainer
	 * @generated
	 */
	public Adapter createConfigurationContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer <em>Resources Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationResourcesContainer
	 * @generated
	 */
	public Adapter createConfigurationResourcesContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer <em>Fragment Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragmentContainer
	 * @generated
	 */
	public Adapter createConfigurationFragmentContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent
	 * @generated
	 */
	public Adapter createConfigurationComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass
	 * @generated
	 */
	public Adapter createConfigurationClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect
	 * @generated
	 */
	public Adapter createConfigurationAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate
	 * @generated
	 */
	public Adapter createConfigurationTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile
	 * @generated
	 */
	public Adapter createConfigurationFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder
	 * @generated
	 */
	public Adapter createConfigurationFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment
	 * @generated
	 */
	public Adapter createConfigurationFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link br.pucrio.inf.les.genarch.models.configuration.FeatureExpression <em>Feature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see br.pucrio.inf.les.genarch.models.configuration.FeatureExpression
	 * @generated
	 */
	public Adapter createFeatureExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConfigurationAdapterFactory
