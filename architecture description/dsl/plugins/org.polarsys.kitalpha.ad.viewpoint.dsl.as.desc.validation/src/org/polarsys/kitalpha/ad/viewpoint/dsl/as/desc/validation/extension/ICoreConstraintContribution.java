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

package org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.validation.extension;

import java.util.List;

/**
 * This interface allows contributor to provide information that allows to include
 * check of new model element in an available EMF validation rule 
 * @author Boubekeur Zendagui
 *
 */
public interface ICoreConstraintContribution {
	
	/**
	 * This method allows contributor to inform the validation service to check 
	 * the current object
	 * @param object The model element under validation
	 * @return True if the object must be checked by the rule, False else.
	 */
	boolean isObjectInScope(Object object);
	
	/**
	 * This method is used to define a validation context. So an object can be checked 
	 * by taking into account other object.
	 * @return � {@link List} containing EStructural features names
	 */
	List<String> brothersEStructuralFeatures();
}
