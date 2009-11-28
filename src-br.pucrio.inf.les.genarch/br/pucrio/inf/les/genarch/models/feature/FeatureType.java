/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.genarch.models.feature.FeaturePackage#getFeatureType()
 * @model
 * @generated
 */
public final class FeatureType extends AbstractEnumerator {
	/**
	 * The '<em><b>Optional</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Optional</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPTIONAL_LITERAL
	 * @model name="optional"
	 * @generated
	 * @ordered
	 */
	public static final int OPTIONAL = 0;

	/**
	 * The '<em><b>Mandatory</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mandatory</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANDATORY_LITERAL
	 * @model name="mandatory"
	 * @generated
	 * @ordered
	 */
	public static final int MANDATORY = 1;

	/**
	 * The '<em><b>Alternative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Alternative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALTERNATIVE_LITERAL
	 * @model name="alternative"
	 * @generated
	 * @ordered
	 */
	public static final int ALTERNATIVE = 2;

	/**
	 * The '<em><b>Optional</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTIONAL
	 * @generated
	 * @ordered
	 */
	public static final FeatureType OPTIONAL_LITERAL = new FeatureType(OPTIONAL, "optional", "optional");

	/**
	 * The '<em><b>Mandatory</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDATORY
	 * @generated
	 * @ordered
	 */
	public static final FeatureType MANDATORY_LITERAL = new FeatureType(MANDATORY, "mandatory", "mandatory");

	/**
	 * The '<em><b>Alternative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALTERNATIVE
	 * @generated
	 * @ordered
	 */
	public static final FeatureType ALTERNATIVE_LITERAL = new FeatureType(ALTERNATIVE, "alternative", "alternative");

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FeatureType[] VALUES_ARRAY =
		new FeatureType[] {
			OPTIONAL_LITERAL,
			MANDATORY_LITERAL,
			ALTERNATIVE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureType get(int value) {
		switch (value) {
			case OPTIONAL: return OPTIONAL_LITERAL;
			case MANDATORY: return MANDATORY_LITERAL;
			case ALTERNATIVE: return ALTERNATIVE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FeatureType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //FeatureType
