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

package org.polarsys.kitalpha.ad.viewpoint.integration.services;

import org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Service;
import org.polarsys.kitalpha.ad.viewpoint.utils.ModelAccessor;

/**
 * @author Thomas Guiu
 * 
 */
public interface ServiceImplementation {
	boolean canRun(Service service, ModelAccessor properties, Object[] selection);

	void run(Service service, ModelAccessor properties, Object[] selection);
}
