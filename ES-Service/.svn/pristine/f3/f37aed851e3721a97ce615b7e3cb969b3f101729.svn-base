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

import java.util.ArrayList;
import java.util.List;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSDELIVSUM;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSSERVICESITEMSUM;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.DeliverableComplexType;
import com.hp.es.xml.service.Offer;
import com.hp.sif.SifException;


/**
 * @author yesilyur
 *
 */
public class MetroCSOfferMapper extends CSOfferMapper{

	/**
	 * 
	 */
	MetroCSOfferMapper(ContractSummaryTransaction transaction, Object service, EsReplyCSContext ctx) {
		super(transaction, service, ctx);
	}

	Offer map(boolean includeDeliverables) throws SifException {
		// Local Object
		Offer offer = new Offer();
		
		/*
		 * Mapping
		 * Service	SOURCE_OBLIGATION_ID 		Offer	---	Internal linkage between offer and obligation header
		 * 													NOT mapped to ES Reply 
		 * Service  ITEM						Offer   item
		 * Service	ASSOCIATED_PKG_ITM			Offer	AssociatedPkgItem
		 * Service	SVC_PRODUCT_ID				Offer	OfferCode 
		 * Service	SVC_DESCRIPTION				Offer	OfferDescription
		 * Service	SVC_PRODUCT_TYPE			Offer	SvcProductType
		 * Service	SVC_PRODUCT_LINE			Offer	SvcProductLine
		 * Service	STAND_ALONE_SERVICE			Offer	StandAloneOffer
		 * Service	INCIDENT_BASE_SERVICE		Offer	IncidentBasedOffer
		 * Service	SERVICE_QUANTITY			Offer	ServiceQuantity
		 * Service	AVAILABLE_QUANTITY			Offer	AvailableQuantity
		 */
		
		
		ZESCQSSERVICESITEMSUM serviceTmp = (ZESCQSSERVICESITEMSUM)_service;

		
		ESLog.debug("Mapping Service (Offer): ");
		offer.setItem(MappingUtils.nullString(serviceTmp.getITEM()));
		offer.setAssociatedPkgItem(MappingUtils.nullString(serviceTmp.getASSOCIATEDPKGITEM()));
		offer.setOfferCode(MappingUtils.nullString(serviceTmp.getSVCPRODUCTID()));
		offer.setOfferDescription(MappingUtils.nullString(serviceTmp.getSVCDESCRIPTION()));
		offer.setSvcProductType(MappingUtils.nullString(serviceTmp.getSVCPRODUCTTYPE()));
		offer.setSvcProductLine(MappingUtils.nullString(serviceTmp.getSVCPRODUCTLINE()));
		offer.setStandAloneOffer(MappingUtils.mapToBoolean(serviceTmp.getSTANDALONESERVICE()));
		offer.setIncidentBasedOffer(MappingUtils.mapToBoolean(serviceTmp.getINCIDENTBASEDSERVICE()));
		try {
			offer.setServiceQuantity(MappingUtils.floatStringToInt(serviceTmp.getSERVICEQUANTITY()));
			offer.setAvailableQuantity(MappingUtils.floatStringToInt(serviceTmp.getAVAILABLEQUANTITY()));
		}catch(MappingException e) {
			ESLog.info("Caught Number Format", e);
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Incorrect Quantity, CQS mapping issue");
		}
		
		//Deliverables
    	if(includeDeliverables) {
    		ZESCONTRACTSUMES10Response cqsReply = (ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply();
        	if(cqsReply.getDELIVERABLES() != null){
              	List<ZESCQSDELIVSUM> deliverList = cqsReply.getDELIVERABLES().getItem();
            	ESLog.debug("Creating deliverables...");
            	ArrayList deliverAry = new ArrayList();
            	for (ZESCQSDELIVSUM deliver : deliverList) {
            		// Local Object
            		if(serviceTmp.getDELIVLINK().trim().equalsIgnoreCase(deliver.getSERVICELINK().trim())){
    	        		ESLog.debug("Creating deliverables " +deliver.getDELIVCODE() + " for offer "+serviceTmp.getITEM());
    	        		CSDeliverableMapper mapper = new MetroCSDeliverableMapper(deliver, _ctx);
    	        		// Local Object
    	        		DeliverableComplexType deliverTmp = mapper.map(); 
    	        		deliverAry.add(deliverTmp);
            		}
            	}
            	DeliverableComplexType[] delivItems = (DeliverableComplexType[]) deliverAry.toArray(new DeliverableComplexType[0]);
            	offer.setDeliverable(delivItems);	
        		
        	}
    	}
		
		return offer;
	}

}
