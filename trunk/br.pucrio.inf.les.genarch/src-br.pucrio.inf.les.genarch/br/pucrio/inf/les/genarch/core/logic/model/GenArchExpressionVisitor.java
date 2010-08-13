package br.pucrio.inf.les.genarch.core.logic.model;

import org.eclipse.emf.common.util.TreeIterator;

import br.pucrio.inf.les.genarch.core.logic.model.expressions.AndExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.ExpressionVisitor;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.NotExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.OrExpression;
import br.pucrio.inf.les.genarch.models.instance.Feature;


public class GenArchExpressionVisitor extends ExpressionVisitor {
	
	private StringBuilder expressionBuilder;
	private Feature featureConfiguration;
	
	public GenArchExpressionVisitor(Feature featureConfiguration) {
		 this.expressionBuilder = new StringBuilder();
		 this.featureConfiguration = featureConfiguration;
	}

	@Override
	public void visitAndExpression(AndExpression andExpression) {
		expressionBuilder.append("(");
		andExpression.getLhs().accept(this);
		expressionBuilder.append(" && ");
		andExpression.getRhs().accept(this);
		expressionBuilder.append(")");
	}

	@Override
	public void visitIFeature(IFeature feature) {
		br.pucrio.inf.les.genarch.models.instance.Feature fmpFeature = (br.pucrio.inf.les.genarch.models.instance.Feature)findFeatureWithName(feature.getName(),featureConfiguration);

		if ( fmpFeature != null ) {
			if ( fmpFeature.isIsSelected() ) {
				expressionBuilder.append("true");
			} else {
				expressionBuilder.append("false");
			}
		} else {
			expressionBuilder.append("false");			
		}
	}

	@Override
	public void visitNotExpression(NotExpression notExpression) {
		expressionBuilder.append("!");
		expressionBuilder.append("(");
		notExpression.getExp().accept(this);
		expressionBuilder.append(")");
	}

	@Override
	public void visitOrExpression(OrExpression orExpression) {
		expressionBuilder.append("(");
		orExpression.getLhs().accept(this);
		expressionBuilder.append(" || ");
		orExpression.getRhs().accept(this);
		expressionBuilder.append(")");
	}
	
	private br.pucrio.inf.les.genarch.models.instance.Feature findFeatureWithName(String name,Feature featureConfiguration) {
		TreeIterator iterator = featureConfiguration.eAllContents();
		
		while ( iterator.hasNext() ) {
			br.pucrio.inf.les.genarch.models.instance.Feature feature = (br.pucrio.inf.les.genarch.models.instance.Feature)iterator.next();
			
			if ( feature.getName().equals(name) ) {
				return feature;
			}
		}
		
		return null;
	}
	
	public String getExpression() {
		return expressionBuilder.toString();
	}

}
