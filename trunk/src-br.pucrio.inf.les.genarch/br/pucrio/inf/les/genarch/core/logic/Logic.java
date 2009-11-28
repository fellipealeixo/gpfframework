package br.pucrio.inf.les.genarch.core.logic;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.logic.model.GenArchExpressionVisitor;
import br.pucrio.inf.les.genarch.core.logic.model.IExpression;
import br.pucrio.inf.les.genarch.core.logic.model.IFeature;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.AndExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.ExpressionVisitor;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.NodeFactory;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.NotExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.OrExpression;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.parse.parser;
import br.pucrio.inf.les.genarch.core.logic.model.expressions.parse.scanner;

public class Logic {

	public static String makeExpression(List<String> features) {
		StringBuilder expression = new StringBuilder();

		if ( features.size() == 1 ) {
			expression.append(features.get(0));
		} else if ( features.size() > 1 ) {
			for ( int x = 0; x < features.size()-1; x++ ) {
				String featureName = features.get(x);
				expression.append(featureName);
				expression.append(" and ");
			}	    
			expression.append(features.get(features.size()-1));
		}

		return expression.toString();
	}

	public static String makeExpression(String expression,List<String> features) {
		StringBuilder bExpression = new StringBuilder();

		bExpression.append(expression);

		for ( int x = 0; x < features.size(); x++ ) {
			String featureName = features.get(x);
			bExpression.append(" and ");
			bExpression.append(featureName);	    
		}

		return bExpression.toString();
	}

	public static List<String> toFeatures(String expression) {
		try {
			final List<String> features = new ArrayList<String>();

			IExpression pExp = parseExpression(expression);
			pExp.accept(new ExpressionVisitor() {	
				public void visitAndExpression(AndExpression andExpression) {
					andExpression.getLhs().accept(this);
					andExpression.getRhs().accept(this);
				}
				public void visitIFeature(IFeature feature) {
					features.add(feature.getName());
				}
				public void visitNotExpression(NotExpression notExpression) {
					notExpression.getExp().accept(this);
				}
				public void visitOrExpression(OrExpression orExpression) {
					orExpression.getLhs().accept(this);
					orExpression.getRhs().accept(this);
				}			
			});

			return features;
		} catch (Exception e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return null;
	}

	public static String[] hotExpression(String expression,List<String> removeFeatures) {	
		final List<String> tokens = new ArrayList<String>();

		try {
			IExpression pExp = parseExpression(expression);
			pExp.accept(new ExpressionVisitor() {	
				public void visitAndExpression(AndExpression andExpression) {
					andExpression.getLhs().accept(this);
					tokens.add("and");
					andExpression.getRhs().accept(this);
				}
				public void visitIFeature(IFeature feature) {
					tokens.add(feature.getName());
				}
				public void visitNotExpression(NotExpression notExpression) {
					tokens.add("not");
					notExpression.getExp().accept(this);
				}
				public void visitOrExpression(OrExpression orExpression) {
					orExpression.getLhs().accept(this);
					tokens.add("or");
					orExpression.getRhs().accept(this);
				}			
			});
		} catch (Exception e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		if ( tokens.size() == 1 ) {
			if ( tokens.get(0).equals(removeFeatures.get(0)) ) {
				tokens.remove(0);
			}

			return new String[0];
		} else {
			for ( int y = 0; y < removeFeatures.size(); y++ ) {
				String feature = removeFeatures.get(y);
				int featurePosition;

				do {
					featurePosition = -1;

					for ( int x = 0; x < tokens.size(); x++ ) {
						String token = tokens.get(x);		
						if ( feature.equals(token) ) {
							featurePosition = x;
							break;
						}			
					}

					if ( featurePosition == 0 ) {

					}

					if ( featurePosition >= 0 ) {
						String tokenA = "";
						String tokenB = "";

						if ( ( featurePosition + 1 ) < tokens.size() ) {
							tokenA = tokens.get(featurePosition + 1);
							/*if ( !tokenA.equals(")") ) {
				    tokens.remove(featurePosition + 1);
				}*/
						}

						//tokens.remove(featurePosition);

						if ( (featurePosition - 1) >= 0) {
							tokenB = tokens.get(featurePosition-1);
							/*if ( !tokenB.equals("(") ) {
				    tokens.remove(featurePosition - 1);
				}*/	
						}

						if ( tokenA.equals("") && !tokenB.equals("")) { //TokenB
							tokens.remove(featurePosition);
							tokens.remove(featurePosition - 1);			
						} else if ( tokenB.equals("") && !tokenA.equals("") ) { //TokenA
							tokens.remove(featurePosition + 1);
							tokens.remove(featurePosition);
						} else if ( tokenA.equals("and") && tokenB.equals("or") ) {
							tokens.remove(featurePosition + 1);
							tokens.remove(featurePosition);
						} else if ( tokenA.equals("or") && tokenB.equals("and") ) {
							tokens.remove(featurePosition);
							tokens.remove(featurePosition - 1);
						} else {
							tokens.remove(featurePosition);
							tokens.remove(featurePosition - 1);
						}
					}
				} while ( featurePosition != - 1);


			}

			String[] res = new String[tokens.size()];
			return tokens.toArray(res);
		}
	}

	
	
	public static boolean eval(String expression,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
		try {
			IExpression pExp = parseExpression(expression);

			final GenArchExpressionVisitor visitor = new GenArchExpressionVisitor(featureConfiguration);
			pExp.accept(visitor);

			Context ctx = Context.enter();
			Scriptable scope = ctx.initStandardObjects();
			boolean value = Boolean.parseBoolean(ctx.toString(ctx.evaluateString(scope,visitor.getExpression(),"<cmd>", 1, null)));
			
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return false;
	}

	public static boolean validate(String expression) {
		try {
			System.out.println(expression);
			IExpression pExp = parseExpression(expression);
			GenarchEMFPlugin.INSTANCE.log(pExp);
		} catch (Exception e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
			return false;
		} 

		return true;
	}

	public static IExpression parseExpression(String text) throws Exception {
		IExpression exp = null;
		scanner s = new scanner(new StringReader(text));
		parser p = new parser(s, new NodeFactory());
		try {
			Symbol sym = p.parse();
			exp = (IExpression) sym.value;					
		} catch (Exception e) {
			GenarchEMFPlugin.INSTANCE.log("Invalid expression.");
			throw e;
		} catch (Error e) {
			GenarchEMFPlugin.INSTANCE.log("Invalid character at position "
					+ (s.yycolumn() + 1) + ": " + "'"
					+ text.charAt(s.yycolumn()) + "'");
			throw e;
		}
		return exp;
	}	
}
