package br.pucrio.inf.les.genarch.core.logic.model;

import br.pucrio.inf.les.genarch.core.logic.model.expressions.ExpressionVisitor;

/**
 * Interface representing a feature expression.
 * 
 * @author Andrea Menezes � andrea.menezes@cesar.org.br
 * @author Fernando Calheiros � fernando.calheiros@cesar.org.br
 * @author Geraldo Fernandes � geraldo.fernandes@cesar.org.br
 * @author Vilmar Nepomuceno � vilmar.nepomuceno@cesar.org.br
 */
public interface IExpression {

	/**
	 * Returns the code of expression.
	 * 
	 * @return The code of expression.
	 */
	public String getCode();

	/**
	 * Accepts the given visitor.
	 * 
	 * @param visitor
	 *            the visitor.
	 */
	public void accept(ExpressionVisitor visitor);
}
