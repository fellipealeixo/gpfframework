package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.CoreException;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.fmp.FMPChange;

public class FeatureModelChangeListener implements IResourceChangeListener {

	public void resourceChanged(IResourceChangeEvent event) {

		try {
			ResourceChangedDeltaVisitor deltaVisitor = new ResourceChangedDeltaVisitor();
			event.getDelta().accept(deltaVisitor);

			List<ResourcesEventData> datasEvents = deltaVisitor.getResourcesDataEvent();

			for ( ResourcesEventData dataEvent : datasEvents) {
				IResource res = dataEvent.getResource();

				if ("fmp".equals(res.getFileExtension()) ) {
					FMPChange fmpChange = new FMPChange();
					fmpChange.change(res.getProject());
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
	}
}
