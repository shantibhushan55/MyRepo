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

import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.Warnings;

/**
 * @author yesilyur
 *
 */
public abstract class CSWarningMapper {

	protected Collection _cqsWarnings;
	protected String _sapRegionDisplayName;

	/**
	 * 
	 */
	public CSWarningMapper(Collection cqsWarnings, String sapRegionDisplayName) {
    	_cqsWarnings = cqsWarnings;
    	_sapRegionDisplayName = sapRegionDisplayName;
	}

	   /**
     * map
     * @return Warnings
     * @throws MappingException
     */
    abstract public Warnings map() throws MappingException;

    /**
     * getInstance -
     * @param cqsWarnings
     * @param sapRegionDisplayName
     * @return CSWarningMapper
     */
	public static CSWarningMapper getInstance(Collection cqsWarnings, String sapRegionDisplayName) {

            return new MetroCSWarningMapper(cqsWarnings, sapRegionDisplayName);
	}    
    
}
