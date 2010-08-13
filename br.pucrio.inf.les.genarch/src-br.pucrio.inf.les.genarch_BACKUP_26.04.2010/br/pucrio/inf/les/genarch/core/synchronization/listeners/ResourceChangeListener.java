package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.CoreException;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;

public class ResourceChangeListener implements IResourceChangeListener {

	public void resourceChanged(IResourceChangeEvent event) {
		synchronized (event) {
			try {
				ResourceChangedDeltaVisitor deltaVisitor = new ResourceChangedDeltaVisitor();
				event.getDelta().accept(deltaVisitor);

				List<ResourcesEventData> eventsData = deltaVisitor.getResourcesDataEvent();

				Collections.sort(eventsData, new ResourceComparator());

				for ( ResourcesEventData eventData : eventsData) {
					IResource res = eventData.getResource();

					String resourceContainerName = res.getProjectRelativePath().segment(0);

					GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(res.getProject());

					if ( genarchProjectConfigurationFile != null && 
							(genarchProjectConfigurationFile.getSourceContainers().contains(resourceContainerName) ||
									genarchProjectConfigurationFile.getResourceContainers().contains(resourceContainerName))) {
						ResourceChangeToArchitecture resourceToArchitecture = new ResourceChangeToArchitecture();
						ResourceChangeToConfiguration resourceToConfiguration = new ResourceChangeToConfiguration();
						ResourceChangeToTemplate resourceToTemplate = new ResourceChangeToTemplate();

						resourceToArchitecture.resourceChanged(eventData,event.getType());
						resourceToConfiguration.resourceChanged(eventData,event.getType());
						resourceToTemplate.resourceChanged(eventData,event.getType());
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		}
	}
}
