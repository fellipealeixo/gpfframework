package br.pucrio.inf.les.genarch.core.project.navigation;

import org.eclipse.core.runtime.Path;

public class NavigationUtil {
    
    public static String getParentByPath(String sPath) {
	Path path = new Path(sPath);

	int segmentCount = path.segmentCount() - 1;

	if ( segmentCount == 0 ) {
	    return null;
	} else {	    
	    return path.removeLastSegments(1).toString();
	}
    }
}