/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.ad.integration.sirius;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;

/**
 * This service is used dynamically by MDK Viewpoints. So don't move/rename it
 * unless MDK is updated accordingly.
 * 
 * @author Thomas Guiu
 */

public class ModelExtensionServices {
	public boolean isExtensionModelActive(EObject obj) {
		if (obj instanceof DSemanticDecorator) {
			DSemanticDecorator elt = (DSemanticDecorator) obj;
			if ((elt.getTarget() != null) && ModelExtensionHelper.getInstance(elt.getTarget()).isExtensionModelDisabled(elt.getTarget())) {
				return false;
			}
		}

		if (obj instanceof DRepresentationElement) {
			DRepresentationElement elt = (DRepresentationElement) obj;
			for (EObject eobj : elt.getSemanticElements()) {
				if ((eobj != null) && ModelExtensionHelper.getInstance(eobj).isExtensionModelDisabled(eobj)) {
					return false;
				}
			}
		}
		return true;
	}
}
