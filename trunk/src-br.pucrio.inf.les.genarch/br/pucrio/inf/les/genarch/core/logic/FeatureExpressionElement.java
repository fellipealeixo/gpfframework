package br.pucrio.inf.les.genarch.core.logic;

public class FeatureExpressionElement {
	
	private String leftOperator;
	private String feature;
	private String rightOperator;
	
	public String getLeftOperator() {
		return leftOperator;
	}
	public void setLeftOperator(String leftOperator) {
		this.leftOperator = leftOperator;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getRightOperator() {
		return rightOperator;
	}
	public void setRightOperator(String rightOperator) {
		this.rightOperator = rightOperator;
	}
}
