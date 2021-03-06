/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.validation.ocl.provider.generic.util;

import org.eclipse.emf.validation.model.ConstraintSeverity;

public class ValidationInfo {
  private final String theMessage;

  private final ConstraintSeverity theSeverity;

  public ValidationInfo(String message, ConstraintSeverity severity) {
    this.theMessage = message;
    this.theSeverity = severity;
  }

  public String getMessage() {
    return this.theMessage;
  }

  public ConstraintSeverity getSeverity() {
    return this.theSeverity;
  }
}
