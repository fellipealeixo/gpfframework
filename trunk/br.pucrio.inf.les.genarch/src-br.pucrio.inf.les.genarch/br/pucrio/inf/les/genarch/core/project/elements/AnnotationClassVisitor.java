package br.pucrio.inf.les.genarch.core.project.elements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;

public class AnnotationClassVisitor extends ASTVisitor {
	
	private List<MarkerAnnotation> markerAnnotations = null;
	private List<AnnotationTypeDeclaration> annotationsTypeDeclaration = null;
	private List<AnnotationTypeMemberDeclaration> annotationsTypeMemberDeclaration = null;
	private List<NormalAnnotation> normalAnnotations = null;
	private List<SingleMemberAnnotation> singleMemberAnnotations = null;
	
	public AnnotationClassVisitor() {
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

	@Override
	public boolean visit(final AnonymousClassDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ArrayAccess node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ArrayCreation node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ArrayInitializer node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ArrayType node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final AssertStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final Assignment node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final Block node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final BooleanLiteral node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final BreakStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final CastExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final CatchClause node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final CharacterLiteral node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ClassInstanceCreation node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final CompilationUnit node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ConditionalExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ConstructorInvocation node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ContinueStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final DoStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final EmptyStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ExpressionStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final FieldAccess node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final FieldDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ForStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final IfStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ImportDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final InfixExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final InstanceofExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final Initializer node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final Javadoc node) {
		if (super.visit(node)) {
		    return this.visitNode(node);
		} else {
		    return false;
		}
	}
	@Override
	public boolean visit(final LabeledStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final MethodDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final MethodInvocation node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final NullLiteral node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final NumberLiteral node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final PackageDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ParenthesizedExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final PostfixExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final PrefixExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final PrimitiveType node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final QualifiedName node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ReturnStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SimpleName node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SimpleType node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final StringLiteral node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SuperConstructorInvocation node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SuperFieldAccess node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SuperMethodInvocation node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SwitchCase node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SwitchStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SynchronizedStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ThisExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final ThrowStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final TryStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final TypeDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final TypeDeclarationStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final TypeLiteral node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final SingleVariableDeclaration node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final VariableDeclarationExpression node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final VariableDeclarationStatement node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final VariableDeclarationFragment node) {
		return this.visitNode(node);
	}
	@Override
	public boolean visit(final WhileStatement node) {
		return this.visitNode(node);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration)
	 */
	@Override
	public boolean visit(final AnnotationTypeDeclaration node) {
		this.annotationsTypeDeclaration.add(node);
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration)
	 */
	@Override
	public boolean visit(final AnnotationTypeMemberDeclaration node) {
		this.annotationsTypeMemberDeclaration.add(node);
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.BlockComment)
	 */
	@Override
	public boolean visit(final BlockComment node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.EnhancedForStatement)
	 */
	@Override
	public boolean visit(final EnhancedForStatement node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.EnumConstantDeclaration)
	 */
	@Override
	public boolean visit(final EnumConstantDeclaration node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.EnumDeclaration)
	 */
	@Override
	public boolean visit(final EnumDeclaration node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.LineComment)
	 */
	@Override
	public boolean visit(final LineComment node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MarkerAnnotation)
	 */
	@Override
	public boolean visit(final MarkerAnnotation node) {
		this.markerAnnotations.add(node);
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MemberRef)
	 */
	@Override
	public boolean visit(final MemberRef node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MemberValuePair)
	 */
	@Override
	public boolean visit(final MemberValuePair node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodRef)
	 */
	@Override
	public boolean visit(final MethodRef node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodRefParameter)
	 */
	@Override
	public boolean visit(final MethodRefParameter node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.Modifier)
	 */
	@Override
	public boolean visit(final Modifier node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.NormalAnnotation)
	 */
	@Override
	public boolean visit(final NormalAnnotation node) {
		this.normalAnnotations.add(node);
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.ParameterizedType)
	 */
	@Override
	public boolean visit(final ParameterizedType node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.QualifiedType)
	 */
	@Override
	public boolean visit(final QualifiedType node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.SingleMemberAnnotation)
	 */
	@Override
	public boolean visit(final SingleMemberAnnotation node) {
		this.singleMemberAnnotations.add(node);
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.TagElement)
	 */
	@Override
	public boolean visit(final TagElement node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.TextElement)
	 */
	@Override
	public boolean visit(final TextElement node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.TypeParameter)
	 */
	@Override
	public boolean visit(final TypeParameter node) {
		return this.visitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.WildcardType)
	 */
	@Override
	public boolean visit(final WildcardType node) {
		return this.visitNode(node);
	}
	
	@Override
	public void endVisit(final AnonymousClassDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ArrayAccess node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ArrayCreation node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ArrayInitializer node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ArrayType node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final AssertStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final Assignment node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final Block node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final BooleanLiteral node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final BreakStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final CastExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final CatchClause node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final CharacterLiteral node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ClassInstanceCreation node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final CompilationUnit node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ConditionalExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ConstructorInvocation node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ContinueStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final DoStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final EmptyStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ExpressionStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final FieldAccess node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final FieldDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ForStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final IfStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ImportDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final InfixExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final InstanceofExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final Initializer node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final Javadoc node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final LabeledStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final MethodDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final MethodInvocation node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final NullLiteral node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final NumberLiteral node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final PackageDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ParenthesizedExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final PostfixExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final PrefixExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final PrimitiveType node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final QualifiedName node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ReturnStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SimpleName node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SimpleType node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final StringLiteral node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SuperConstructorInvocation node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SuperFieldAccess node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SuperMethodInvocation node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SwitchCase node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SwitchStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SynchronizedStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ThisExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final ThrowStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final TryStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final TypeDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final TypeDeclarationStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final TypeLiteral node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final SingleVariableDeclaration node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final VariableDeclarationExpression node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final VariableDeclarationStatement node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final VariableDeclarationFragment node) {
		this.endVisitNode(node);
	}
	@Override
	public void endVisit(final WhileStatement node) {
		this.endVisitNode(node);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration)
	 */
	@Override
	public void endVisit(final AnnotationTypeDeclaration node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration)
	 */
	@Override
	public void endVisit(final AnnotationTypeMemberDeclaration node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.BlockComment)
	 */
	@Override
	public void endVisit(final BlockComment node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.EnhancedForStatement)
	 */
	@Override
	public void endVisit(final EnhancedForStatement node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.EnumConstantDeclaration)
	 */
	@Override
	public void endVisit(final EnumConstantDeclaration node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.EnumDeclaration)
	 */
	@Override
	public void endVisit(final EnumDeclaration node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.LineComment)
	 */
	@Override
	public void endVisit(final LineComment node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.MarkerAnnotation)
	 */
	@Override
	public void endVisit(final MarkerAnnotation node) {		
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.MemberRef)
	 */
	@Override
	public void endVisit(final MemberRef node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.MemberValuePair)
	 */
	@Override
	public void endVisit(final MemberValuePair node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.MethodRef)
	 */
	@Override
	public void endVisit(final MethodRef node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.MethodRefParameter)
	 */
	@Override
	public void endVisit(final MethodRefParameter node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.Modifier)
	 */
	@Override
	public void endVisit(final Modifier node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.NormalAnnotation)
	 */
	@Override
	public void endVisit(final NormalAnnotation node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.ParameterizedType)
	 */
	@Override
	public void endVisit(final ParameterizedType node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.QualifiedType)
	 */
	@Override
	public void endVisit(final QualifiedType node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.SingleMemberAnnotation)
	 */
	@Override
	public void endVisit(final SingleMemberAnnotation node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.TagElement)
	 */
	@Override
	public void endVisit(final TagElement node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.TextElement)
	 */
	@Override
	public void endVisit(final TextElement node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.TypeParameter)
	 */
	@Override
	public void endVisit(final TypeParameter node) {
		this.endVisitNode(node);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.WildcardType)
	 */
	@Override
	public void endVisit(final WildcardType node) {
		this.endVisitNode(node);
	}
}
