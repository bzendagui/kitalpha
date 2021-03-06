/*******************************************************************************
 * Copyright (c) 2019 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.doc.gen.business.core.services;

import java.util.Objects;

/**
 * 
 * @author Faycal Abka
 *
 */
public class IndexItem implements Comparable<IndexItem>{
	
	private final String conceptName;
	private final String conceptType;
	private final String iconTag;
	private final String linkTagTowardPage;
	private final String fileName;
	
	/**
	 * New index item
	 * @param conceptName not null concept name
	 * @param conceptType not null type of concept
	 * @param iconTag not null icon html tag
	 * @param linkTagTowardPage not null html link toward page element
	 * @param fileName the target file where the content is generated
	 */
	public IndexItem(String conceptName, String conceptType, String iconTag, String linkTagTowardPage, String fileName) {
		super();
		this.conceptName = conceptName;
		this.conceptType = conceptType;
		this.iconTag = iconTag;
		this.linkTagTowardPage = linkTagTowardPage;
		this.fileName = fileName;
	}
	
	public String getConceptName() {
		return conceptName;
	}
	
	public String getIconTag() {
		return iconTag;
	}
	
	public String getLinkTagTowardPageElement() {
		return linkTagTowardPage;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getConceptType() {
		return conceptType;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof IndexItem) {
			IndexItem item = (IndexItem)arg0;
			return getConceptName().equalsIgnoreCase(item.getConceptName()) &&
					getIconTag().equalsIgnoreCase(item.getIconTag()) &&
					getLinkTagTowardPageElement().equalsIgnoreCase(item.getLinkTagTowardPageElement()) &&
					getFileName().equalsIgnoreCase(item.getFileName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getConceptName()) + 
				Objects.hashCode(getIconTag()) +
				Objects.hashCode(getLinkTagTowardPageElement()) +
				Objects.hashCode(getFileName());
	}


	@Override
	public int compareTo(IndexItem arg0) {
		return getConceptName().compareTo(arg0.getConceptName());
	}
	
}
