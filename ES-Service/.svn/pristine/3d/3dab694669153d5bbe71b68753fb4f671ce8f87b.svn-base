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

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContractSummaryComplexType;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public abstract class ContractSummaryMapper {

    protected ContractSummaryTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
	protected EsRequestComplexType _request;
    static protected EsReplyCSContext _ctx;

	/**
	 * 
	 */
	public ContractSummaryMapper(ContractSummaryTransaction transaction, EsRequestComplexType request, EsReplyCSContext ctx) {
    	_transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
        _request = request;
        _ctx = ctx;
	}

	public abstract ContractSummaryComplexType map() throws MappingException, SifException;
	
	
    static public ContractSummaryMapper getInstance(ContractSummaryTransaction transaction, EsRequestComplexType request) {
        return new MetroContractSummaryMapper(transaction, request, _ctx);
    }    
}
