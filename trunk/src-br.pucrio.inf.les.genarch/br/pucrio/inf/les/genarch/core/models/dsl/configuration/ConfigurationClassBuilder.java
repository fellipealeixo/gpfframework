package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationClassBuilder {
	
	private final ConfigurationClass configurationClass;
		
	private ConfigurationClassBuilder() {
		configurationClass = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createConfigurationClass();
	}
	
	public ConfigurationClass build() {
		return configurationClass;
	}
	
	public static ConfigurationClassBuilder configurationClass() {		
		return new ConfigurationClassBuilder();
	}
	
	public ConfigurationClassBuilder name(String name) {
		configurationClass.setName(name);
		return this;
	}
	
	public ConfigurationClassBuilder path(String path) {
		configurationClass.setPath(path);
		return this;
	}
	
	public ConfigurationClassBuilder featureExpression(String featureExpression) {
		FeatureExpression expression = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createFeatureExpression();
		expression.setExpression(featureExpression);
		configurationClass.setFeatureExpression(expression);
		return this;
	}

}
