/*******************************************************************************
 * Copyright (c) 2014, 2018 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/


package org.polarsys.kitalpha.transposer.ui.internal.providers;


import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.polarsys.kitalpha.transposer.rules.handler.rules.contribution.ContributedPurpose;

/**
 * 
 * @author Guillaume Gebhart
 *
 */

public class ComboContentProvider implements IStructuredContentProvider{

	@Override
	public Object[] getElements(Object inputElement) {
		
		if (inputElement instanceof ContributedPurpose[]) {
		  ContributedPurpose[] input = (ContributedPurpose[]) inputElement;
      return input;
		}

			
		
		
		return null;
	}
		

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

}
