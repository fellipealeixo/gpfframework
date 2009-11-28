package br.pucrio.inf.les.genarch.core.logic.model.expressions;

import br.pucrio.inf.les.genarch.core.logic.model.IFeature;

public abstract class ExpressionVisitor {

	public abstract void visitIFeature(IFeature feature);

	public abstract void visitAndExpression(AndExpression andExpression);

	public abstract void visitOrExpression(OrExpression orExpression);

	public abstract void visitNotExpression(NotExpression notExpression);
}
