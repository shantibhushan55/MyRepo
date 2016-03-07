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
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSDELIVSUM;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.DeliverableComplexType;

/**
 * @author yesilyur
 *
 */
public class MetroCSDeliverableMapper extends CSDeliverableMapper{

	/**
	 * 
	 */
	MetroCSDeliverableMapper(Object deliverable, EsReplyCSContext ctx) {
		super(deliverable, ctx);
	}
	
    /**
     * mapDeliverable
     * @param input
     * @return
     * @throws MappingException
     */
 	
	DeliverableComplexType map(){
 
		// Local Object
		ESLog.debug("Mapping deliverable: ");
		
     	DeliverableComplexType deliver = new DeliverableComplexType();
		
		/*
		 * Mapping
		 * ZES_CQS_DELIVERABLE_SUM	SERVICE_LINK 	Deliverable	---	Internal linkage between offer and deliverable
		 * 															NOT mapped to ES Reply 
		 * ZES_CQS_DELIVERABLE_SUM  DELIV_CODE		Deliverable	DelivCode
		 * ZES_CQS_DELIVERABLE_SUM	DELIV_NAME		Deliverable	DelivName
		 * ZES_CQS_DELIVERABLE_SUM	DELIV_VALUE		Deliverable	DelivValue 
		 */
				
     	ZESCQSDELIVSUM deliverTmp = (ZESCQSDELIVSUM)_deliverable;
		

     	deliver.setDelivCode(MappingUtils.nullString(deliverTmp.getDELIVCODE()));
     	deliver.setDelivName(MappingUtils.nullString(deliverTmp.getDELIVNAME()));
     	deliver.setDelivValue(MappingUtils.nullString(deliverTmp.getDELIVVALUE()));

        return deliver;

	}
	
}
