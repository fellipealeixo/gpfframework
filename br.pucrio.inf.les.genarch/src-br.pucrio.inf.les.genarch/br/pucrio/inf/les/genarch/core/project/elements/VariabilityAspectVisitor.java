package br.pucrio.inf.les.genarch.core.project.elements;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.AjASTVisitor;
import org.aspectj.org.eclipse.jdt.core.dom.MethodDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.PointcutDeclaration;

public class VariabilityAspectVisitor extends AjASTVisitor {
	
	private List<MethodDeclaration> abstractMethodsDeclaration;
	private List<PointcutDeclaration> abstractPointcutsDeclaration;
	
	public VariabilityAspectVisitor() {
		this.abstractMethodsDeclaration = new ArrayList<MethodDeclaration>();
		this.abstractPointcutsDeclaration = new ArrayList<PointcutDeclaration>();
	}
	
	public List<MethodDeclaration> getAbstractMethodsDeclaration() {
		return this.abstractMethodsDeclaration;
	}
		
	public List<PointcutDeclaration> getAbstractPointcutsDeclaration() {
		return abstractPointcutsDeclaration;
	}

	public boolean visit(PointcutDeclaration node) {
		this.abstractPointcutsDeclaration.add(node);
		return true;
	}
	
	public boolean visit(MethodDeclaration node) {
		this.abstractMethodsDeclaration.add(node);
		return true;
	}
}
