/*******************************************************************************
 * Copyright (c) 2017 Thales Global Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.VpuiGrammarAccess;

public class VpuiParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private VpuiGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr.internal.InternalVpuiParser createParser(XtextTokenStream stream) {
		return new org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr.internal.InternalVpuiParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "UserInterface";
	}
	
	public VpuiGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(VpuiGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
