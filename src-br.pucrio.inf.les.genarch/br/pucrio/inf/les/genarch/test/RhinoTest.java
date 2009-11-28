package br.pucrio.inf.les.genarch.test;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import br.pucrio.inf.les.genarch.core.logic.Logic;

public class RhinoTest {
	
	public static void main(String args[]) {
		
		Context ctx = Context.enter();
		Scriptable scope = ctx.initStandardObjects();
		boolean value = Boolean.parseBoolean(ctx.toString(ctx.evaluateString(scope,"!(true && true)", "", 1, null))); 
				
		System.out.println(value);
	}

}
