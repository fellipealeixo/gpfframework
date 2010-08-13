package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;

import br.pucrio.inf.les.genarch.core.models.dsl.ArchitectureModelUtil;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;

public class ResourceChangeToArchitecture {

	private Map<String,ArchitectureModelUtil> architectureModelsChanged = new HashMap<String,ArchitectureModelUtil>();

	public void resourceChanged(ResourcesEventData eventData, int eventType) { 
		IResource res = eventData.getResource();
		
		if ( eventData.getEventType() == IResourceDelta.ADDED ) {
			ArchitectureEntity element = createArchitectureEntity(res);
			getArchitectureModelUtil(res).addElement(element);					
		}
		
		for ( ArchitectureModelUtil architectureModelUtil : architectureModelsChanged.values() ) {
			if ( eventType != IResourceChangeEvent.POST_BUILD ) {
				architectureModelUtil.saveModel();		   
			}
		}

		architectureModelsChanged.clear();
	}

	private ArchitectureModelUtil getArchitectureModelUtil(IResource res) {
		ArchitectureModelUtil architectureModelUtil = architectureModelsChanged.get(res.getProject().getName());

		if ( architectureModelUtil == null ) {
			GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(res.getProject());

			String architectureModelPath = genarchProjectConfigurationFile.getArchitectureModelPath();
			architectureModelUtil = new ArchitectureModelUtil(res.getProject());
			architectureModelsChanged.put(res.getProject().getName(), architectureModelUtil);		    
		}

		return architectureModelUtil;
	}
	
	private ArchitectureEntity createArchitectureEntity(IResource res) {
		ArchitectureFactory architectureFactory = ArchitecturePackage.eINSTANCE.getArchitectureFactory();
		ArchitectureEntity entity;
		
		if ( res.getType() == IResource.FOLDER ) {
			String containerName = res.getProjectRelativePath().segment(0);
			IResource resou = res.getProject().findMember(new Path(containerName));
			IJavaElement container = JavaCore.create(resou);
			if ( container instanceof IPackageFragmentRoot ) {
				entity = architectureFactory.createArchitectureComponent();
			} else {
				entity = architectureFactory.createArchitectureFolder();
			}
		} else if ( "java".equals(res.getFileExtension()) ) {
			entity = architectureFactory.createArchitectureClass();
		} else if ( "aj".equals(res.getFileExtension()) ) {
			entity = architectureFactory.createArchitectureAspect();
		} else if ( "xpt".equals(res.getFileExtension()) ) {
			entity = architectureFactory.createArchitectureTemplate();
		} else {
			entity = architectureFactory.createArchitectureFile();
		}

		entity.setName(res.getName());
		entity.setPath(res.getProjectRelativePath().toString());

		return entity;
	}
}
