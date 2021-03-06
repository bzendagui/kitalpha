/*******************************************************************************
 * Copyright (c) 2014, 2018 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.validation.representation;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.validation.extension.IAdditionalConstraint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.validation.extension.ValidationStatus;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.validation.message.Messages;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.NamedElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.AbstractEdge;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdiagram.EdgeDescription;

/**
 * @author Boubekeur Zendagui
 */

public class EdgesUniqueNoConditionalRepresentationRules implements IAdditionalConstraint {

	@Override
	public boolean isObjectInScope(Object object) {
		return object instanceof AbstractEdge;
	}

	@Override
	public ValidationStatus validationRules(Object data) {
		AbstractEdge aEdge= (AbstractEdge) data;
		int contionalRepresentationCount = 0;
		for (EdgeDescription iEdgeDescription : aEdge.getE_description()) 
		{
			if (iEdgeDescription.getCondition() == null) {
				contionalRepresentationCount ++;
			}
			
			if (contionalRepresentationCount > 1) {
				return ValidationStatus.Error;
			}
		}
		return ValidationStatus.Ok;
	}

	@Override
	public String getMessage(ValidationStatus status, Object object) {
		NamedElement edge = (NamedElement) object;
		String elementType = edge.eClass().getName();
		String edgeName = edge.getName();

		if (edgeName != null && edgeName.trim().length() > 0 )
		{
			return Messages.bind(Messages.Validation_Representation_Condition_Unique_WithName, edgeName, elementType);
		}
		else
		{
			return Messages.bind(Messages.Validation_Representation_Condition_Unique_WithoutName, elementType);
		}
	}

}
