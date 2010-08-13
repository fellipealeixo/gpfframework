package br.pucrio.inf.les.genarch.core.logic.model.expressions;

import br.pucrio.inf.les.genarch.core.logic.model.IExpression;

public class AndExpression implements IExpression {

	private IExpression lhs;

	private IExpression rhs;

	public AndExpression(IExpression lhs, IExpression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getCode() {
		return "(" + this.lhs.getCode() + " and " + this.rhs.getCode() + ")";
	}

	public IExpression getLhs() {
		return this.lhs;
	}

	public IExpression getRhs() {
		return this.rhs;
	}

	@Override
	public String toString() {
		return this.getCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof AndExpression)
				&& (((AndExpression) obj).getCode().equals(this.getCode()));
	}

	public void accept(ExpressionVisitor visitor) {
		visitor.visitAndExpression(this);
	}
}
