/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.provider;


import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFactory;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationComponentItemProvider
	extends MappingEntityItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationComponentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__CLASSES);
			childrenFeatures.add(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__ASPECTS);
			childrenFeatures.add(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__TEMPLATES);
			childrenFeatures.add(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__FILES);
			childrenFeatures.add(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__SUB_COMPONENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConfigurationComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConfigurationComponent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((ConfigurationComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ConfigurationComponent_type") :
			getString("_UI_ConfigurationComponent_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConfigurationComponent.class)) {
			case ConfigurationPackage.CONFIGURATION_COMPONENT__CLASSES:
			case ConfigurationPackage.CONFIGURATION_COMPONENT__ASPECTS:
			case ConfigurationPackage.CONFIGURATION_COMPONENT__TEMPLATES:
			case ConfigurationPackage.CONFIGURATION_COMPONENT__FILES:
			case ConfigurationPackage.CONFIGURATION_COMPONENT__SUB_COMPONENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__CLASSES,
				 ConfigurationFactory.eINSTANCE.createConfigurationClass()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__ASPECTS,
				 ConfigurationFactory.eINSTANCE.createConfigurationAspect()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__TEMPLATES,
				 ConfigurationFactory.eINSTANCE.createConfigurationTemplate()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__FILES,
				 ConfigurationFactory.eINSTANCE.createConfigurationFile()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.CONFIGURATION_COMPONENT__SUB_COMPONENTS,
				 ConfigurationFactory.eINSTANCE.createConfigurationComponent()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return ConfigurationMetaModelEditPlugin.INSTANCE;
	}

}
