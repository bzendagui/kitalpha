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
package org.polarsys.kitalpha.emde.genchain.extension.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.emde.genchain.extension.model.ExtensionPackage
 * @generated
 */
public interface ExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensionFactory eINSTANCE = org.polarsys.kitalpha.emde.genchain.extension.model.impl.ExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Emde Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Emde Generation</em>'.
	 * @generated
	 */
	EmdeGeneration createEmdeGeneration();

	/**
	 * Returns a new object of class '<em>Emde Cdo Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Emde Cdo Generation</em>'.
	 * @generated
	 */
	EmdeCdoGeneration createEmdeCdoGeneration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExtensionPackage getExtensionPackage();

} //ExtensionFactory
