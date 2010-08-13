package br.pucrio.inf.les.genarch.models;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.Feature;
import br.pucrio.inf.les.genarch.models.instance.FeatureInstance;

public class InstanceModelHelper {

	public static Feature feature(Object name,Object model) {
		String sName = (String)name;
		
		FeatureInstance featureInstance = (FeatureInstance)model;
		TreeIterator iterator = featureInstance.getRoot().eAllContents();
		
		while ( iterator.hasNext() ) {
			Object o = iterator.next();
			
			if ( o instanceof Feature ) {
				Feature e = (Feature)o;
				GenarchEMFPlugin.INSTANCE.log(sName + " :: ------------------------------------");
				GenarchEMFPlugin.INSTANCE.log(e.getId());
				GenarchEMFPlugin.INSTANCE.log("------------------------------------------------");
				
				if ( e.getId().equals(sName) ) {
					return e;
				}
			}
		}
		
		return null;
	}

	public static List featureConfigurations(Object name,Object model) {		
		String sName = (String)name;
		FeatureInstance featureInstance = (FeatureInstance)model;

		List configuration = new ArrayList();

		TreeIterator iterator = featureInstance.eAllContents();

		while ( iterator.hasNext() ) {
			Object o = iterator.next();

			if ( o instanceof Feature ) {
				Feature f = (Feature)o;
				if ( f.getName().equals(sName) ) {
					configuration.add(f);
				}
			}
		}

		return configuration;
	}
	
	public static ArchitectureContainer container(Object name,Object model) {
		String cName = (String)name;
		
		ArchitectureInstance architectureInstance = (ArchitectureInstance)model;
		TreeIterator iterator = architectureInstance.eAllContents();
		
		while ( iterator.hasNext() ) {
			Object o = iterator.next();
			
			if ( o instanceof ArchitectureContainer ) {
				ArchitectureContainer e = (ArchitectureContainer)o;
				
				if ( e.getName().equals(cName) ) {
					return e;
				}
			}
		}
		
		return null;
	}

	public static ArchitectureEntity element(Object name,Object model) {		
		String sName = (String)name;
		
		ArchitectureInstance architectureInstance = (ArchitectureInstance)model;
		TreeIterator iterator = architectureInstance.eAllContents();
		
		while ( iterator.hasNext() ) {
			Object o = iterator.next();
			
			if ( o instanceof ArchitectureEntity ) {
				ArchitectureEntity e = (ArchitectureEntity)o;
				
				if ( e.getName().equals(sName) ) {
					return e;
				}
			}
		}
		
		return null;
	}
	
	public static ArchitectureFragment fragment(Object path,Object model) {
		String sPath = (String)path;
		
		ArchitectureInstance architectureInstance = (ArchitectureInstance)model;
		TreeIterator iterator = architectureInstance.eAllContents();
		
		while ( iterator.hasNext() ) {
			Object o = iterator.next();
			
			if ( o instanceof ArchitectureFragment ) {
				ArchitectureFragment e = (ArchitectureFragment)o;
				
				if ( e.getPath().equals(sPath) ) {
					return e;
				}
			}
		}
		
		return null;
	}
	
	public static ArchitectureFragmentContainer fragmentsContainer(Object name,Object model) {
		String sName = (String)name;
		
		ArchitectureInstance architectureInstance = (ArchitectureInstance)model;
		TreeIterator iterator = architectureInstance.eAllContents();
		
		while ( iterator.hasNext() ) {
			Object o = iterator.next();
			
			if ( o instanceof ArchitectureFragmentContainer ) {
				ArchitectureFragmentContainer e = (ArchitectureFragmentContainer)o;
				
				if ( e.getName().equals(sName) ) {
					return e;
				}
			}
		}
		
		return null;
	}

}
