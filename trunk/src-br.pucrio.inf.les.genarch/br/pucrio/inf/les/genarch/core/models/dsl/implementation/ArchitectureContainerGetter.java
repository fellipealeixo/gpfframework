package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;

public class ArchitectureContainerGetter<T> {
	
	private Architecture architecture;

	public ArchitectureContainerGetter(Architecture architecture) {
		this.architecture = architecture;
	}

	public T get(String name) {
		TreeIterator iterator = architecture.eAllContents();

		while ( iterator.hasNext() ) {
			EObject o = (EObject)iterator.next();

			if ( o instanceof ArchitectureContainer ) {
				ArchitectureContainer c = (ArchitectureContainer)o;
				if ( c.getName().equals(name) ) {
					return (T)c;
				}
			} else if (o instanceof ArchitectureResourcesContainer ) {
				ArchitectureResourcesContainer c = (ArchitectureResourcesContainer)o;
				if ( c.getName().equals(name) ) {
					return (T)c;
				}
			}
		}

		return null;
	}

}
