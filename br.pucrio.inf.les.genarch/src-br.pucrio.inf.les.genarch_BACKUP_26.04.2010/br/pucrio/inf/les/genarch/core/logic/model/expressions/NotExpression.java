package br.pucrio.inf.les.genarch.core.logic.model.expressions;

import br.pucrio.inf.les.genarch.core.logic.model.IExpression;

public class NotExpression implements IExpression {

	private IExpression exp;

	public NotExpression(IExpression exp) {
		this.exp = exp;
	}

	public IExpression getExp() {
		return this.exp;
	}

	public String getCode() {
		return "not(" + this.exp.getCode() + ")";
	}

	@Override
	public String toString() {
		return this.getCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof NotExpression)
				&& (((NotExpression) obj).getCode().equals(this.getCode()));
	}

	public void accept(ExpressionVisitor visitor) {
		visitor.visitNotExpression(this);
	}
}
