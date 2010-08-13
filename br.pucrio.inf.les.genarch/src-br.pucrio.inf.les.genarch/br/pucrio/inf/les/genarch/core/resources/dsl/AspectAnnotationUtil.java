package br.pucrio.inf.les.genarch.core.resources.dsl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.AST;
import org.aspectj.org.eclipse.jdt.core.dom.ASTNode;
import org.aspectj.org.eclipse.jdt.core.dom.Annotation;
import org.aspectj.org.eclipse.jdt.core.dom.ArrayInitializer;
import org.aspectj.org.eclipse.jdt.core.dom.BodyDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit;
import org.aspectj.org.eclipse.jdt.core.dom.Expression;
import org.aspectj.org.eclipse.jdt.core.dom.IExtendedModifier;
import org.aspectj.org.eclipse.jdt.core.dom.ImportDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.MemberValuePair;
import org.aspectj.org.eclipse.jdt.core.dom.NormalAnnotation;
import org.aspectj.org.eclipse.jdt.core.dom.QualifiedName;
import org.aspectj.org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.aspectj.org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnit;
import org.eclipse.ajdt.core.javaelements.AJCompilationUnitManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;

public class AspectAnnotationUtil {

	public static NormalAnnotation newNormalAnnotation(AST ast, String annotationName) {
		NormalAnnotation annotation = ast.newNormalAnnotation();
		annotation.setTypeName(ast.newSimpleName(annotationName));
		return annotation;
	}


	public static void addLiteralMemberValuePair(NormalAnnotation annotation, String name, String value) {
		AST ast = annotation.getAST();

		List list = (List) annotation.getStructuralProperty(NormalAnnotation.VALUES_PROPERTY);
		MemberValuePair newValuePair = ast.newMemberValuePair();
		newValuePair.setName(ast.newSimpleName(name));
		newValuePair.setValue(AspectAnnotationUtil.newStringLiteral(ast, value));
		list.add(newValuePair);
	}

	public static void addQualifiedNameMemberValuePair(NormalAnnotation annotation, String name,String qualifier, String qName) {
		AST ast = annotation.getAST();

		List list = (List) annotation.getStructuralProperty(NormalAnnotation.VALUES_PROPERTY);
		MemberValuePair newValuePair = ast.newMemberValuePair();
		newValuePair.setName(ast.newSimpleName(name));
		newValuePair.setValue(ast.newQualifiedName(ast.newName(qualifier),ast.newSimpleName(qName)));	
		list.add(newValuePair);
	}

	public static StringLiteral newStringLiteral(AST ast, String literalValue) {
		StringLiteral stringLiteral = ast.newStringLiteral();
		stringLiteral.setLiteralValue(literalValue);
		return stringLiteral;
	}

	public static boolean containsAnnotation(BodyDeclaration bodyDeclaration, String annotationName) {
		for (Iterator stream = bodyDeclaration.modifiers().iterator(); stream.hasNext(); ) {
			IExtendedModifier modifier = (IExtendedModifier) stream.next();
			if (modifier.isAnnotation()) {
				if (((Annotation)modifier).getTypeName().getFullyQualifiedName().equals(annotationName)) {
					return true;
				}
			}
		}
		return false;
	}

	public static Annotation annotation(BodyDeclaration bodyDeclaration, String annotationName) {
		for (Iterator stream = bodyDeclaration.modifiers().iterator(); stream.hasNext(); ) {
			IExtendedModifier modifier = (IExtendedModifier) stream.next();
			if (modifier.isAnnotation()) {
				if (((Annotation)modifier).getTypeName().getFullyQualifiedName().equals(annotationName)) {
					return (Annotation) modifier;
				}
			}
		}
		return null;
	}

	public static void addValuePair(NormalAnnotation annotation, MemberValuePair valuePair) {
		List list = (List) annotation.getStructuralProperty(NormalAnnotation.VALUES_PROPERTY);
		list.add(valuePair);
	}

	public static void addAnnotation(BodyDeclaration bodyDeclaration, Annotation annotation) {
		List list = (List) bodyDeclaration.getStructuralProperty(bodyDeclaration.getModifiersProperty());
		list.add(annotationLocation(bodyDeclaration), annotation);
	}

	public static int annotationLocation(BodyDeclaration bodyDeclaration) {
		int count = 0;
		for (Iterator i = bodyDeclaration.modifiers().listIterator(); i.hasNext();) {
			IExtendedModifier modifier = (IExtendedModifier) i.next();
			if (modifier.isModifier()) {
				break;
			}
			count++;
		}
		return count;
	}

	public static MemberValuePair memberValuePair(NormalAnnotation annotation, String elementName) {
		for (Iterator stream = annotation.values().iterator(); stream.hasNext(); ) {
			MemberValuePair valuePair = (MemberValuePair) stream.next();
			if (valuePair.getName().getFullyQualifiedName().equals(elementName)) {
				return valuePair;
			}
		}
		return null;
	}
	
	//TODO Arrumar este código
	public static void removeVariabilityAnnotation(IFile file) {
		AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(file);
		ASTNode astNode = AJDTASTUtil.astNode(file,ajCompilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		BodyDeclaration bodyDeclaration = AJDTASTUtil.bodyDeclaration(unit);
		IDocument document = AJDTASTUtil.createDocument(ajCompilationUnit);		    
		unit.recordModifications();
				
		Annotation annotation = annotation(bodyDeclaration, "Variability");
		if ( annotation != null ) {
			removeAnnotation(bodyDeclaration, annotation);
		}	
			
		List<ImportDeclaration> removeImports = new ArrayList<ImportDeclaration>();
		List imports = unit.imports();
		for ( int x = 0; x < imports.size(); x++ ) {
			ImportDeclaration importDeclaration = (ImportDeclaration)imports.get(x);
			String importName = importDeclaration.getName().getFullyQualifiedName(); 
			if ( importName.equals("br.pucrio.inf.les.genarch.core.annotations.Variability")||
					importName.equals("br.pucrio.inf.les.genarch.core.annotations.VariabilityType")) {
				removeImports.add(importDeclaration);
			}
		}

		for ( ImportDeclaration importDeclaration : removeImports ) {
			imports.remove(importDeclaration);
		}

		TextEdit textEdit = unit.rewrite(document, ajCompilationUnit.getJavaProject().getOptions(true));

		try {
			textEdit.apply(document);
		} catch (MalformedTreeException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (BadLocationException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		String newSource = document.get();

		try {
			ajCompilationUnit.getBuffer().setContents(newSource); 
			ajCompilationUnit.save(new NullProgressMonitor(),true);
		} catch (JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}

	public static void removeFeaturesAnnotation(IFile file) {
		AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(file);
		ASTNode astNode = AJDTASTUtil.astNode(file,ajCompilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		BodyDeclaration bodyDeclaration = AJDTASTUtil.bodyDeclaration(unit);
		IDocument document = AJDTASTUtil.createDocument(ajCompilationUnit);		    
		unit.recordModifications();
				
		Annotation annotation = annotation(bodyDeclaration, "Feature");
		if ( annotation != null ) {
			removeAnnotation(bodyDeclaration, annotation);
		}	

		annotation = annotation(bodyDeclaration, "Features");
		if ( annotation != null ) {
			removeAnnotation(bodyDeclaration, annotation);
		}
		
		List<ImportDeclaration> removeImports = new ArrayList<ImportDeclaration>();
		List imports = unit.imports();
		for ( int x = 0; x < imports.size(); x++ ) {
			ImportDeclaration importDeclaration = (ImportDeclaration)imports.get(x);
			String importName = importDeclaration.getName().getFullyQualifiedName(); 
			if ( importName.equals("br.pucrio.inf.les.genarch.core.annotations.Feature") || 
					importName.equals("br.pucrio.inf.les.genarch.core.annotations.Features") ||		
					importName.equals("br.pucrio.inf.les.genarch.core.annotations.FeatureProperty") ||
					importName.equals("br.pucrio.inf.les.genarch.core.annotations.FeatureType") ) {
				removeImports.add(importDeclaration);
			}
		}

		for ( ImportDeclaration importDeclaration : removeImports ) {
			imports.remove(importDeclaration);
		}

		TextEdit textEdit = unit.rewrite(document, ajCompilationUnit.getJavaProject().getOptions(true));

		try {
			textEdit.apply(document);
		} catch (MalformedTreeException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (BadLocationException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		String newSource = document.get();

		try {
			ajCompilationUnit.getBuffer().setContents(newSource); 
			ajCompilationUnit.save(new NullProgressMonitor(),true);
		} catch (JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}

	public static void removeAnnotation(BodyDeclaration bodyDeclaration, String annotationName) {
		removeAnnotation(bodyDeclaration, annotation(bodyDeclaration, annotationName));
	}


	public static void removeAnnotation(BodyDeclaration bodyDeclaration, Annotation annotation) {
		List list = (List) bodyDeclaration.getStructuralProperty(bodyDeclaration.getModifiersProperty());
		list.remove(annotation);
	}

	public static SingleMemberAnnotation newSingleMemberAnnotation(AST ast, String annotationName) {
		SingleMemberAnnotation annotation = ast.newSingleMemberAnnotation();
		annotation.setTypeName(ast.newSimpleName(annotationName));
		return annotation;
	}

	public static MemberValuePair memberValuePair(BodyDeclaration bodyDeclaration, String annotationName, String name) {
		return memberValuePair(annotation(bodyDeclaration, annotationName), name);
	}	

	public static MemberValuePair memberValuePair(Annotation annotation, String elementName) {
		if ((annotation != null) && annotation.isNormalAnnotation()) {
			return memberValuePair((NormalAnnotation) annotation, elementName);
		}
		return null;
	}

	public static boolean containsAnnotationElement(BodyDeclaration bodyDeclaration, String annotationName, String elementName) {
		Annotation annotation = annotation(bodyDeclaration, annotationName);
		if (elementName.equals("value") && annotation.isSingleMemberAnnotation()) {
			return ((SingleMemberAnnotation) annotation).getValue() != null;
		}
		return memberValuePair(annotation, elementName) != null;
	}

	public static Expression element(Annotation annotation, String elementName) {
		if (elementName.equals("value") && annotation.isSingleMemberAnnotation()) {
			return ((SingleMemberAnnotation) annotation).getValue();
		}
		MemberValuePair valuePair = memberValuePair(annotation, elementName);
		return (valuePair == null) ? null : valuePair.getValue();
	}

	public static void addExpressionToArrayInitializer(ArrayInitializer arrayInitializer, Expression expression) {
		List list = (List) arrayInitializer.getStructuralProperty(ArrayInitializer.EXPRESSIONS_PROPERTY);
		list.add(expression);
	}

	public static void removeFromArrayInitializer(ArrayInitializer arrayInitializer, int position) {
		List list = (List) arrayInitializer.getStructuralProperty(ArrayInitializer.EXPRESSIONS_PROPERTY);
		list.remove(position);
	}

	public static void removeFromArrayInitializer(ArrayInitializer arrayInitializer, Object object) {
		List list = (List) arrayInitializer.getStructuralProperty(ArrayInitializer.EXPRESSIONS_PROPERTY);
		list.remove(object);
	}

	public static List<FeatureItem> featuresAnnotations(IFile annotedFile) {
		return JavaAnnotationUtil.featureAnnotations(annotedFile);
		/*List<FeatureItem> annotations = new ArrayList<FeatureItem>();					
		AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(annotedFile);
		ASTNode astNode = AJDTASTUtil.astNode(annotedFile,ajCompilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		BodyDeclaration bodyDeclaration = AJDTASTUtil.bodyDeclaration(unit);
								
		Annotation annotation = AspectAnnotationUtil.annotation(bodyDeclaration, "Feature");
		if ( annotation != null ) {
			annotations.add(makeFeatureItem(annotation));
		} else { 
			annotation = AspectAnnotationUtil.annotation(bodyDeclaration, "Features");
			if ( annotation != null ) {
				SingleMemberAnnotation singleAnnotaton = (SingleMemberAnnotation)annotation;
				Expression value = singleAnnotaton.getValue();
				ArrayInitializer arrayInitializer = (ArrayInitializer)value;
				List list = (List)arrayInitializer.getStructuralProperty(ArrayInitializer.EXPRESSIONS_PROPERTY);

				for ( int x = 0; x < list.size(); x++ ) {
					Annotation featureAnnotation = (Annotation)list.get(x);
					annotations.add(makeFeatureItem(featureAnnotation));
				}		
			}
		}

		return annotations;*/
	}

	private static FeatureItem makeFeatureItem(Annotation annotation) {
		FeatureItem featureItem = new FeatureItem();
		MemberValuePair valuePair = AspectAnnotationUtil.memberValuePair(annotation, "name");
		if ( valuePair != null ) {
			StringLiteral nameValue = (StringLiteral)valuePair.getValue();
			featureItem.setName(nameValue.getLiteralValue());
		}

		valuePair = AspectAnnotationUtil.memberValuePair(annotation, "parent");
		if ( valuePair != null ) {	
			StringLiteral parentValue = (StringLiteral)valuePair.getValue();
			featureItem.setParent(parentValue.getLiteralValue());
		}

		valuePair = AspectAnnotationUtil.memberValuePair(annotation, "type");
		if ( valuePair != null ) {
			QualifiedName typeValue = (QualifiedName)valuePair.getValue();	    
			featureItem.setType(FeatureType.valueOf(typeValue.getName().getIdentifier()));
		}

		return featureItem;
	}

	public static VariabilityItem variabilityAnnotation(IFile annotedFile) {
		return JavaAnnotationUtil.variabilityAnnotation(annotedFile);
		/*AJCompilationUnit ajCompilationUnit = AJCompilationUnitManager.INSTANCE.getAJCompilationUnit(annotedFile);
		ASTNode astNode = AJDTASTUtil.astNode(annotedFile,ajCompilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		BodyDeclaration bodyDeclaration = AJDTASTUtil.bodyDeclaration(unit);

		VariabilityItem variabilityItem = null;
		Annotation annotation = annotation(bodyDeclaration,"Variability");

		if ( annotation != null ) {
			variabilityItem = new VariabilityItem();
			MemberValuePair valuePair = memberValuePair(annotation,"feature");
			if ( valuePair != null ) {
				StringLiteral featureValue = (StringLiteral)valuePair.getValue();
				variabilityItem.setFeature(featureValue.getLiteralValue());
			}

			valuePair = memberValuePair(annotation,"type");
			if ( valuePair != null ) {
				QualifiedName typeValue = (QualifiedName)valuePair.getValue();	    
				variabilityItem.setType(VariabilityType.valueOf(typeValue.getName().getIdentifier()));
			}
		}

		return variabilityItem;*/
	}
}
