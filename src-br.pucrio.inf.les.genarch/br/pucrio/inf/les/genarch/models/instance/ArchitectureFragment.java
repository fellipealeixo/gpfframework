/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.instance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureFragment()
 * @model
 * @generated
 */
public interface ArchitectureFragment extends ArchitectureEntity {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see br.pucrio.inf.les.genarch.models.instance.InstancePackage#getArchitectureFragment_Content()
	 * @model default=""
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // ArchitectureFragment
