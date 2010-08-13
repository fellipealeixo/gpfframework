package br.pucrio.inf.les.genarch.core.logic.model;

import java.util.List;

import br.pucrio.inf.les.genarch.core.logic.model.IExpression;
import br.pucrio.inf.les.genarch.core.logic.model.IFeature;

/**
 * Represents a feature within a feature model.
 * 
 * @author Andrea Menezes � andrea.menezes@cesar.org.br
 * @author Fernando Calheiros � fernando.calheiros@cesar.org.br
 * @author Geraldo Fernandes � geraldo.fernandes@cesar.org.br
 * @author Vilmar Nepomuceno � vilmar.nepomuceno@cesar.org.br
 * 
 */
public interface IFeature extends IExpression {

	public enum FeatureType {
		MANDATORY, OPTIONAL, OR, ALTERNATIVE
	}

	/**
	 * Returns the list of feature's children.
	 * 
	 * @return The list of feature's children.
	 */
	public List<IFeature> getChildren();

	/**
	 * Sets the parent feature.
	 * 
	 * @param parent
	 *            The parent feature.
	 */
	public void setParent(IFeature parent);

	/**
	 * Returns the parent feature.
	 * 
	 * @return The parent feature.
	 */
	public IFeature getParent();

	/**
	 * Returns the name of the feature.
	 * 
	 * @return The name of the feature.
	 */
	public String getName();

	/**
	 * Returns the type of the feature.
	 * 
	 * @return The type of the feature.
	 */
	public FeatureType getType();

	/**
	 * Sets the type of the feature.
	 * 
	 * @param type
	 *            The type of the feature.
	 */
	public void setType(FeatureType parameterType);
}
