package br.pucrio.inf.les.genarch.core.annotations;

public @interface Feature {
	String name();
	FeatureType type() default FeatureType.mandatory;
	String parent() default "";
}
