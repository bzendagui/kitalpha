/*******************************************************************************
 * Copyright (c) 2017 Thales Global Services.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.predicate.internal.extension.manager;

import java.util.function.Function;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Abstract class for managing extension points
 * 
 * @author Faycal Abka
 *
 */
public abstract class AbstractExtensionManager {
	/**
	 * Returns a configuration element for extension point ID
	 */
	protected Function<String, IConfigurationElement[]> getExtensionFor = id -> Platform.getExtensionRegistry().getConfigurationElementsFor(id);
}
