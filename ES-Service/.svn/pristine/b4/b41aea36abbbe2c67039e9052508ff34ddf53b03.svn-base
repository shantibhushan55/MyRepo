/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.contractSummary.integration.mapping;

import com.hp.es.xml.service.WorkingComplexType;

/**
 * @author yesilyur
 *
 */
public final class CSWorkingMapper {

	protected String _sourceSystemStatus;
	protected String _regionDisplayName;
	/**
	 * 
	 */
	public CSWorkingMapper(String sourceSystemStatus, String regionDisplayName) {
		super();
		_sourceSystemStatus = sourceSystemStatus;
		_regionDisplayName = regionDisplayName;
	}

	public WorkingComplexType map() {
		WorkingComplexType working = new WorkingComplexType();
		working.setWorkingName(_regionDisplayName);
		working.setWorkingValue(_sourceSystemStatus);
		return working;
	}

}
