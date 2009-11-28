package br.pucrio.inf.les.genarch.core.project.elements;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.ASTNode;
import org.aspectj.org.eclipse.jdt.core.dom.ASTVisitor;
import org.aspectj.org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation;
import org.aspectj.org.eclipse.jdt.core.dom.SingleMemberAnnotation;


public class AnnotationAspectVisitor extends ASTVisitor {

	private List<MarkerAnnotation> markerAnnotations = null;
	private List<AnnotationTypeDeclaration> annotationsTypeDeclaration = null;
	private List<AnnotationTypeMemberDeclaration> annotationsTypeMemberDeclaration = null;
	private List<NormalAnnotation> normalAnnotations = null;
	private List<SingleMemberAnnotation> singleMemberAnnotations = null;

	public AnnotationAspectVisitor() {
		this.markerAnnotations = new ArrayList<MarkerAnnotation>();
		this.annotationsTypeDeclaration = new ArrayList<AnnotationTypeDeclaration>();
		this.annotationsTypeMemberDeclaration = new ArrayList<AnnotationTypeMemberDeclaration>();
		this.normalAnnotations = new ArrayList<NormalAnnotation>();
		this.singleMemberAnnotations = new ArrayList<SingleMemberAnnotation>();		
	}

	public List<AnnotationTypeDeclaration> getAnnotationsTypeDeclaration() {
		return this.annotationsTypeDeclaration;
	}

	public List<AnnotationTypeMemberDeclaration> getAnnotationsTypeMemberDeclaration() {
		return this.annotationsTypeMemberDeclaration;
	}

	public List<MarkerAnnotation> getMarkerAnnotations() {
		return this.markerAnnotations;
	}

	public List<NormalAnnotation> getNormalAnnotations() {
		return this.normalAnnotations;
	}

	public List<SingleMemberAnnotation> getSingleMemberAnnotations() {
		return this.singleMemberAnnotations;
	}

	protected boolean visitNode(final ASTNode node) {
		return true;
	}

	protected void endVisitNode(final ASTNode node) {
		// do nothing
	}

	public boolean visit(AnnotationTypeDeclaration node) {
		this.annotationsTypeDeclaration.add(node);
		return this.visitNode(node);
	}

	public boolean visit(AnnotationTypeMemberDeclaration node) {
		this.annotationsTypeMemberDeclaration.add(node);
		return this.visitNode(node);
	}

	public boolean visit(MarkerAnnotation node) {
		this.markerAnnotations.add(node);
		return this.visitNode(node);
	}

	public boolean visit(NormalAnnotation node) {
		this.normalAnnotations.add(node);
		return this.visitNode(node);
	}

	public boolean visit(SingleMemberAnnotation node) {
		this.singleMemberAnnotations.add(node);
		return this.visitNode(node);
	}

	public void endVisit(AnnotationTypeDeclaration node) {
		// default implementation: do nothing
	}

	public void endVisit(AnnotationTypeMemberDeclaration node) {
		// default implementation: do nothing
	}

	public void endVisit(MarkerAnnotation node) {
		// default implementation: do nothing
	}

	public void endVisit(NormalAnnotation node) {
		// default implementation: do nothing
	}

	public void endVisit(SingleMemberAnnotation node) {
		// default implementation: do nothing
	}
}
