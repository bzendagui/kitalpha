/*******************************************************************************
 * Copyright (c) 2014, 2018 Thales Global Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.generator.IViewpointSynchronizer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.generator.VpspecGenerator;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.resource.VpspecResourceServiceProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.scoping.VpspecContainerManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.scoping.VpspecGlobalScopeProvider;


/**
 * 
 * @author Amine Lajmi
 *
 */
public class VpspecRuntimeModule extends org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.AbstractVpspecRuntimeModule {

	public VpspecRuntimeModule() {
	}
	
	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return VpspecResourceServiceProvider.class;
	}
	
	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager() {
		return VpspecContainerManager.class;
	}
	
	// contributed by org.eclipse.xtext.generator.scoping.AbstractScopingFragment
	@Override
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VpspecGlobalScopeProvider.class;
	}
	
	public Class<? extends IViewpointSynchronizer> bindIViewpointSynchronizer() {
		return VpspecGenerator.class;
	}
}
