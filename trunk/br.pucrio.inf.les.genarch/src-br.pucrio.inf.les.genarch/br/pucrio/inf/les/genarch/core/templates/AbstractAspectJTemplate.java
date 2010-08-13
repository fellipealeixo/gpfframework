package br.pucrio.inf.les.genarch.core.templates;

import java.util.*;

import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItemDescription;

public class AbstractAspectJTemplate
{
  protected static String nl;
  public static synchronized AbstractAspectJTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractAspectJTemplate result = new AbstractAspectJTemplate();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = "�IMPORT br::pucrio::inf::les::genarch::models::feature�" + NL + "�DEFINE Main FOR Feature�" + NL + "�FILE attribute + \".aj\"�" + NL + "package "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_2 = ";" + NL + NL + "public aspect �attribute� extends "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_3 = " {" + NL; //$NON-NLS-1$
  protected final String TEXT_4 = "\t\t"; //$NON-NLS-1$
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "}" + NL + "�ENDFILE�" + NL + "�ENDDEFINE�"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
 VariabilityItemDescription config = (VariabilityItemDescription)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( config.getPackageName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( config.getName() );
    stringBuffer.append(TEXT_3);
 List methods = (List)config.getAbstractDeclarations(); 
  for (Iterator i = methods.iterator(); i.hasNext(); ) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(i.next().toString());
    stringBuffer.append(TEXT_5);
 } 
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
