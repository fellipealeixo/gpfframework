package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationFragmentBuilder {
	
	private ConfigurationFragment fragment;
	
	private ConfigurationFragmentBuilder() {
		this.fragment = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationFragment();
	}
	
	public ConfigurationFragment build() {
		return this.fragment;
	}
	
	public static ConfigurationFragmentBuilder configurationFragment() {
		return new ConfigurationFragmentBuilder();
	}
	
	public ConfigurationFragmentBuilder name(String name) {
		this.fragment.setName(name);
		return this;
	}
	
	public ConfigurationFragmentBuilder path(String path) {
		this.fragment.setPath(path);
		return this;
	}
	
	public ConfigurationFragmentBuilder featureExpression(String featureExpression) {
		FeatureExpression expression = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createFeatureExpression();
		expression.setExpression(featureExpression);
		fragment.setFeatureExpression(expression);
		return this;
	}
}