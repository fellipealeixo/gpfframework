package br.pucrio.inf.les.genarch.core.logic.model.expressions;

import br.pucrio.inf.les.genarch.core.logic.model.IExpression;

public class GenArchNodeFactory {
	public GenArchNodeFactory() {
	}

	public AndExpression createAndExpression(IExpression lhs, IExpression rhs) {
		return new AndExpression(lhs, rhs);
	}

	public OrExpression createOrExpression(IExpression lhs, IExpression rhs) {
		return new OrExpression(lhs, rhs);
	}

	public NotExpression createNotExpression(IExpression exp) {
		return new NotExpression(exp);
	}

	public IExpression createFeature(String name) throws Exception {
		return new Feature(name);
	}
}
