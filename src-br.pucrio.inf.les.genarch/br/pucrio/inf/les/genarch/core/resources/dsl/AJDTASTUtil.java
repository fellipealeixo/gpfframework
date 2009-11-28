package br.pucrio.inf.les.genarch.core.resources.dsl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.ICompilationUnit;
import org.aspectj.org.eclipse.jdt.core.JavaModelException;
import org.aspectj.org.eclipse.jdt.core.dom.ASTNode;
import org.aspectj.org.eclipse.jdt.core.dom.ASTParser;
import org.aspectj.org.eclipse.jdt.core.dom.BodyDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit;
import org.aspectj.org.eclipse.jdt.core.dom.PointcutDeclaration;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnit;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class AJDTASTUtil {

	public static ASTNode astNode(IFile resource,AJCompilationUnit compilationUnit) {
		//try {
		/*InputStream fileContents = resource.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
			StringBuffer sb = new StringBuffer();

			while ( reader.ready() ) {
				sb.append(reader.readLine());
			}*/

		try {
			ASTParser astParser = ASTParser.newParser(AST.JLS3);
			astParser.setCompilerOptions(new HashMap());
			compilationUnit.requestOriginalContentMode();
			String content = compilationUnit.getBuffer().getContents();
			astParser.setSource(content.toCharArray());
			astParser.setKind(ASTParser.K_COMPILATION_UNIT);
			astParser.setResolveBindings(true);
			ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

			return rootNode;
		} catch (org.eclipse.jdt.core.JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}	     
		/*} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return null;
	}

	public static ASTNode astNode(IFile resource,AJCompilationUnit compilationUnit,boolean flag) {


		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setCompilerOptions(new HashMap());				
		astParser.setSource(compilationUnit.getContents());
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);
		astParser.setResolveBindings(true);
		ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

		return rootNode;
	}

	public static ASTNode astNode(IFile resource,ICompilationUnit compilationUnit) {
		try {
			InputStream fileContents = resource.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
			StringBuffer sb = new StringBuffer();

			while ( reader.ready() ) {
				sb.append(reader.readLine());
			}

			ASTParser astParser = ASTParser.newParser(org.aspectj.org.eclipse.jdt.core.dom.AST.JLS3);
			astParser.setCompilerOptions(new HashMap());
			astParser.setSource(compilationUnit);
			astParser.setKind(ASTParser.K_COMPILATION_UNIT);
			astParser.setResolveBindings(true);
			ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

			return rootNode;	     
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static IDocument createDocument(ICompilationUnit compilationUnit) {
		String source;
		try {
			source = compilationUnit.getBuffer().getContents();
			return new Document(source);
		} catch (JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
		return null;

		/*try {
	    InputStream fileContents = resource.getContents();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
	    StringBuffer sb = new StringBuffer();

	    while ( reader.ready() ) {
	        sb.append(reader.readLine());
	    }	    

	    return new Document(sb.toString());
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (CoreException e) {
	    e.printStackTrace();
	}*/

		/*try {
	    String source = ajCompilationUni.getBuffer().getContents();
	    return new Document(source);
	} catch (org.eclipse.jdt.core.JavaModelException e) {
	    e.printStackTrace();
	}*/

		//return null;	
	}

	public static IDocument createDocument(AJCompilationUnit ajCompilationUni) {

		/*try {
	    InputStream fileContents = resource.getContents();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
	    StringBuffer sb = new StringBuffer();

	    while ( reader.ready() ) {
	        sb.append(reader.readLine());
	    }	    

	    return new Document(sb.toString());
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (CoreException e) {
	    e.printStackTrace();
	}*/

		try {
			String source = ajCompilationUni.getBuffer().getContents();
			return new Document(source);
		} catch (org.eclipse.jdt.core.JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return null;	
	}

	public static BodyDeclaration bodyDeclaration(CompilationUnit unit) {
		BodyDeclaration typeDeclaration = (BodyDeclaration)unit.types().get(0);
		return typeDeclaration;
	}

	public static List<PointcutDeclaration> pointcutDeclarations(CompilationUnit unit) {
		GenarchEMFPlugin.INSTANCE.log(unit);
		return null;
	}

}
