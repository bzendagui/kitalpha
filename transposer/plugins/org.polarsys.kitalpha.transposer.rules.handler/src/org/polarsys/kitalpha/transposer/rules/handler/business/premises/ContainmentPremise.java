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

package org.polarsys.kitalpha.transposer.rules.handler.business.premises;

/**
 * @author David Baudon
 * 
 */
public class ContainmentPremise<MetaClass> extends PrecedencePremise<MetaClass> {

  /**
   * @param firstElement_p
   */
  public ContainmentPremise(MetaClass firstElement_p) {
    super(firstElement_p, "container"); //$NON-NLS-1$
    setCritical(true);
  }

}
