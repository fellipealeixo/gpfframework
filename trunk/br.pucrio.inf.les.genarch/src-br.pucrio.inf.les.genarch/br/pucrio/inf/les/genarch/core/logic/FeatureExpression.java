package br.pucrio.inf.les.genarch.core.logic;

import java.util.List;
import java.util.StringTokenizer;

import br.pucrio.inf.les.genarch.core.logic.model.IExpression;
import br.pucrio.inf.les.genarch.core.logic.model.IFeature;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.AndExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.ExpressionVisitor;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.NotExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.OrExpression;

public class FeatureExpression {
	
	public static final String AND = "and";
	public static final String OR = "or";
	public static final String NOT = "not";
	
	private List<FeatureExpressionElement> fees;
	
	private FeatureExpression() {
		
	}
	
	public static FeatureExpression build(String featureExpression) {
		return null;
	}
	
	public void addFeatureExpressionElement(FeatureExpressionElement featureExpressionElement) {
		this.fees.add(featureExpressionElement);
	}
	
	public void removeFeature(String feature) {
		int index = findFeatureExpressionElement(feature);
		
		if ( index >= 0) {
			this.fees.remove(index);	
		}		
	}
	
	private int findFeatureExpressionElement(String feature) {
		for (int x = 0; x < fees.size(); x++) {
			if ( fees.get(x).getFeature().equals(feature) ) {
				return x;
			}
		}
		
		return -1;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		if ( fees.size() != 0 && fees.size() == 1 ) {
			FeatureExpressionElement featureExpressionElement = fees.get(0);
			stringBuilder.append(featureExpressionElement.getFeature());
			stringBuilder.append(featureExpressionElement.getRightOperator());			
		} else if ( fees.size() > 1 ) {
			FeatureExpressionElement featureExpressionElement = fees.get(0);
			stringBuilder.append(featureExpressionElement.getFeature());			
			stringBuilder.append(featureExpressionElement.getRightOperator());
			stringBuilder.append("");
			
			for ( int x = 1; x <= fees.size(); x++) {
				stringBuilder.append(featureExpressionElement.getLeftOperator());
				stringBuilder.append("");
				stringBuilder.append(featureExpressionElement.getFeature());
				stringBuilder.append("");
				stringBuilder.append(featureExpressionElement.getRightOperator());
				stringBuilder.append("");
			}
			
			stringBuilder.append(featureExpressionElement.getLeftOperator());
			stringBuilder.append("");
			stringBuilder.append(featureExpressionElement.getFeature());
		}
		
		return stringBuilder.toString();
	}

}
