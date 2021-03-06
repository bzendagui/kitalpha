/*******************************************************************************
 * Copyright (c) 2015 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.style.customization.validation.appliedon;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.sirius.viewpoint.description.EStructuralFeatureCustomization;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.style.customization.validation.internal.AbstractStyleCustomizationReuseRule;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpstylecustomization.StyleCustomizationReuse;

/**
 * @author Boubekeur Zendagui
 */
public class StyleCustomizationReuseReusedCustoNotEmpty extends AbstractStyleCustomizationReuseRule{

	@Override
	protected EList<EStructuralFeatureCustomization> getListTocheck(StyleCustomizationReuse reuse) {
		if (reuse != null)
			return reuse.getReusedCustomization();
		else
			return new BasicEList<EStructuralFeatureCustomization>();
	}

	@Override
	protected String getListName() {
		return "\"Reused style customization\"";
	}
}
