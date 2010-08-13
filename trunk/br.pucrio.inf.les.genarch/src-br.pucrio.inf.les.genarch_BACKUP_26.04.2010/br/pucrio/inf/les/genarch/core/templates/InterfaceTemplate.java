package br.pucrio.inf.les.genarch.core.templates;


import java.util.Iterator;
import java.util.List;

import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItemDescription;

public class InterfaceTemplate
{
	protected static String nl;
	public static synchronized InterfaceTemplate create(final String lineSeparator)
	{
		nl = lineSeparator;
		final InterfaceTemplate result = new InterfaceTemplate();
		nl = null;
		return result;
	}

	protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "�IMPORT br::pucrio::inf::les::genarch::models::feature�" + this.NL + "�DEFINE Main FOR Feature�" + this.NL + "�FILE attribute + \".java\"�" + this.NL + "package ";
	protected final String TEXT_2 = ";" + this.NL + "" + this.NL + "public class �attribute� implements ";
	protected final String TEXT_3 = " {" + this.NL + "\t";
	protected final String TEXT_4 = this.NL + "\t";
	protected final String TEXT_5 = this.NL + "\t\t";
	protected final String TEXT_6 = this.NL + "\t";
	protected final String TEXT_7 = this.NL + "}" + this.NL + "�ENDFILE�" + this.NL + "�ENDDEFINE�";

	public String generate(final Object argument)
	{
		final StringBuffer stringBuffer = new StringBuffer();
		final VariabilityItemDescription config = (VariabilityItemDescription)argument; 
		stringBuffer.append(this.TEXT_1);
		stringBuffer.append( config.getPackageName() );
		stringBuffer.append(this.TEXT_2);
		stringBuffer.append( config.getName() );
		stringBuffer.append(this.TEXT_3);
		final List methods = config.getAbstractDeclarations(); 
		stringBuffer.append(this.TEXT_4);
		for (final Iterator i = methods.iterator(); i.hasNext(); ) { 
			stringBuffer.append(this.TEXT_5);
			stringBuffer.append(i.next().toString());
			stringBuffer.append(this.TEXT_6);
		} 
		stringBuffer.append(this.TEXT_7);
		return stringBuffer.toString();
	}
}
