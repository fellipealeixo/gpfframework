package br.pucrio.inf.les.genarch.core.models.dsl.configuration;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;
import br.pucrio.inf.les.genarch.models.configuration.FeatureExpression;
import br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationPackageImpl;

public class ConfigurationAspectBuilder {
		
	private final ConfigurationAspect configurationAspect;
	
	private ConfigurationAspectBuilder() {
		configurationAspect = ConfigurationPackage.eINSTANCE.getConfigurationFactory().createConfigurationAspect();
	}
	
	public ConfigurationAspect build() {
		return configurationAspect;
	}
	
	public static ConfigurationAspectBuilder configurationAspect() {
		return new ConfigurationAspectBuilder();
	}
	
	public ConfigurationAspectBuilder name(String name) {
		configurationAspect.setName(name);
		return this;
	}
	
	public ConfigurationAspectBuilder path(String path) {
		configurationAspect.setPath(path);
		return this;
	}
	
	public ConfigurationAspectBuilder featureExpression(String featureExpression) {
		FeatureExpression expression = ConfigurationPackageImpl.eINSTANCE.getConfigurationFactory().createFeatureExpression();
		expression.setExpression(featureExpression);
		configurationAspect.setFeatureExpression(expression);
		return this;
	}

}
