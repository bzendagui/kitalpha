/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/


package org.polarsys.kitalpha.composer.ui.providers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.polarsys.kitalpha.composer.extension.points.CodeManagerExtensions;

/**
 * Filters the input according to the selected binding.
 * 
 
 */
public class ComboViewerFilter extends ViewerFilter {

	private String nsUri = "";
	private Viewer viewer = null;

	public ComboViewerFilter(Viewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		IConfigurationElement elt = (IConfigurationElement) element;
		return nsUri.equals(elt.getAttribute(CodeManagerExtensions.ATT_URI));
	}

	public String getNsUri() {
		return nsUri;
	}

	public void setNsUri(String nsUrip) {
		nsUri = nsUrip;
		viewer.refresh();
	}

}
