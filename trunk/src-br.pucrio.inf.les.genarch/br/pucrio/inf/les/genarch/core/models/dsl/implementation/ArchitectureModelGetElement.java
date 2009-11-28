package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

public class ArchitectureModelGetElement {

	private ArchitectureModelHandle architectureModelHandle;

	public ArchitectureModelGetElement(ArchitectureModelHandle architectureModelHandle) {
		this.architectureModelHandle = architectureModelHandle;
	}
	
	public ArchitectureComponent component(String path) {
		return (ArchitectureComponent)getElement(path);
	}
	
	public ArchitectureFolder folder(String path) {
		return (ArchitectureFolder)getElement(path);
	}
	
	public ArchitectureClass clazz(String path) {
		return (ArchitectureClass)getElement(path);
	}
	
	public ArchitectureAspect aspect(String path) {
		return (ArchitectureAspect)getElement(path);
	}
	
	public ArchitectureFile file(String path) {
		return (ArchitectureFile)getElement(path);
	}
	
	public ArchitectureTemplate template(String path) {
		return (ArchitectureTemplate)getElement(path);
	}
	
	public ArchitectureContainer sourceContainer(String name) {
		return (ArchitectureContainer)getContainer(name);
	}
	
	public ArchitectureResourcesContainer resourceContainer(String name) {
		return (ArchitectureResourcesContainer)getContainer(name);
	}
	
	public ArchitectureFragmentContainer fragmentContainer(String name) {
		return (ArchitectureFragmentContainer)getContainer(name);
	}

	private ArchitectureEntity getElement(String path) {
		TreeIterator iterator = this.architectureModelHandle.getArchitecture().eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof ArchitectureEntity ) {
				ArchitectureEntity c = (ArchitectureEntity)o;
				if ( c.getPath().equals(path) ) {
					return c;
				}
			}	   
		}

		return null;
	}
	
	private EObject getContainer(String name) {
		TreeIterator iterator = this.architectureModelHandle.getArchitecture().eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof ArchitectureContainer ) {
				ArchitectureContainer c = (ArchitectureContainer)o;
				if ( c.getName().equals(name) ) {
					return c;
				}
			} else if ( o instanceof ArchitectureResourcesContainer ) {
				ArchitectureResourcesContainer c = (ArchitectureResourcesContainer)o;
				if ( c.getName().equals(name) ) {
					return c;
				}
			} else if ( o instanceof ArchitectureFragmentContainer ) {
				ArchitectureFragmentContainer c = (ArchitectureFragmentContainer)o;
				if ( c.getName().equals(name) ) {
					return c;
				}
			}
		}

		return null;
	}
}