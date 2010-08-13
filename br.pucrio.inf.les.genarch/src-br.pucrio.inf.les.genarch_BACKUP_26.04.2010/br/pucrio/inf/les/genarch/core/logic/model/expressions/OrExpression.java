package br.pucrio.inf.les.genarch.core.logic.model.expressions;

import br.pucrio.inf.les.genarch.core.logic.model.IExpression;

public class OrExpression implements IExpression {

	private IExpression lhs;

	private IExpression rhs;

	public IExpression getLhs() {
		return this.lhs;
	}

	public IExpression getRhs() {
		return this.rhs;
	}

	public OrExpression(IExpression lhs, IExpression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getCode() {
		return "(" + this.lhs.getCode() + " or " + this.rhs.getCode() + ")";
	}

	@Override
	public String toString() {
		return this.getCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof OrExpression)
				&& (((OrExpression) obj).getCode().equals(this.getCode()));
	}

	public void accept(ExpressionVisitor visitor) {
		visitor.visitOrExpression(this);
	}
}
