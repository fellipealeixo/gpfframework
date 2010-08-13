package br.pucrio.inf.les.genarch.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Variability {
	VariabilityType type() default VariabilityType.hotSpot;
	String feature();
}
