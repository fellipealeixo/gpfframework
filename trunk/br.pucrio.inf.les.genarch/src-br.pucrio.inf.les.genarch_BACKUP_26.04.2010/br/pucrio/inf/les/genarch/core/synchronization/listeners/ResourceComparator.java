package br.pucrio.inf.les.genarch.core.synchronization.listeners;

import java.util.Comparator;

public class ResourceComparator implements Comparator {

	public int compare(Object o, Object e) {

		ResourcesEventData oData = (ResourcesEventData)o;
		ResourcesEventData eData = (ResourcesEventData)e;

		if ( oData.getEventType() > eData.getEventType() ) {
			return 1;
		} else if ( oData.getEventType() == eData.getEventType() ) {
			return 1;
		} else {
			return -1;
		}
	}
}