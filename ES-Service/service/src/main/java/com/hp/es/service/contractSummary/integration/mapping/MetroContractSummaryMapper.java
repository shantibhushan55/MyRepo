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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSOBLIGATIONHDSUM;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContractSummaryComplexType;
import com.hp.es.xml.service.ContractSummaryRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class MetroContractSummaryMapper extends ContractSummaryMapper {

	/**
	 * 
	 */
	MetroContractSummaryMapper(ContractSummaryTransaction transaction, EsRequestComplexType request, EsReplyCSContext ctx) {
    	super(transaction, request, ctx);
	}
	
    public ContractSummaryComplexType map() throws MappingException, SifException {
    	ContractSummaryRequest cr = _request.getEsRequestComplexTypeChoice().getContractSummaryRequest();
    	ContractSummaryComplexType result = new ContractSummaryComplexType();
    	    	    	
    	Map contactMap = new HashMap();
    	if(cr.getIncludeContacts()) {
		    CSContactMapper contactMapper = new MetroCSContactMapper(_transaction,_XMLIdGenerator);
		    result.setContact(contactMapper.map());
		    // Convert the array of contacts into a HashMap for ContractMapper
		    
		    for (int i=0; i<result.getContactCount(); i++) {
		        contactMap.put(result.getContact(i).getSourcePersonID(), result.getContact(i));
		    }
    	}
    	
    	//put all location to a hashmap for directly access
    	Map locationMap = new HashMap();
    	if(cr.getIncludeAddresses()) {
		    CSLocationMapper locationMapper = new MetroCSLocationMapper(_transaction, _XMLIdGenerator);
		    
		    result.setLocation(locationMapper.map());
		    // Convert the array of locations into a HashMap for ContractMapper
		    
		    for (int i=0; i<result.getLocationCount(); i++) {
		        locationMap.put(result.getLocation(i).getSourceCustomerID(), result.getLocation(i));
		    }
    	}
 
		boolean includeOffers = false;
    	if(cr.getIncludeSoftwareServiceLevelCategory()){
    		includeOffers = true;
		}

    	if(cr.getIncludeOffers())
    	{
    		includeOffers = true;
    		
    	}
    	
    	// Map the obligationHeader with all items underneath (Services (offers), deliverables, ...)
    	CSObligationHeaderMapper obligationMapper =
	        new MetroCSObligationHeaderMapper(_transaction, _XMLIdGenerator,locationMap,contactMap,_ctx);
    	result.setObligationHeader(obligationMapper.map(includeOffers, cr.getIncludeDeliverables(), cr.getIncludeContacts(), cr.getIncludeAddresses(), cr.getIncludeFunctionalLocation(), cr.getIncludeSoftwareServiceLevelCategory()));	    
    	
    	//Map the Product list to ES Reply structure
    	CSProductListMapper prodListMapper = new MetroCSProductListMapper(_transaction,_ctx);
    	result.setProductList(prodListMapper.map());
    	ZESCONTRACTSUMES10Response cqsReply = (ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply();
    	result.setSvcAgreementID(cqsReply.getSVCAGREEMENTID());
    	
    	// now we set the summary fields at the top
    	// It is to early hier, please refer to ContractSummaryOrchestration->processListOfReplies()
    	/*
	    result.setActiveContractEntitlement(isObligationHeaderActive());
	    result.setOverallContractEndDate(getLatestHeaderEndDate());
	    result.setOverallContractStartDate(getEarliestHeaderStartDate());
	    */
	    //Mapping completed, return the result.
	    return result;
    }
    
    
    /**
     * This Methode checks if an obligation header object has a true active status (ContractStatus)
     * @return true if an obligation header's contractStatus is checked "X"
     */
    private boolean isObligationHeaderActive() {
    	boolean isActive = false;
    	
    	Collection sapObligHeaders = ((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getOBLIGATIONHEADERS().getItem();
		
		Iterator enumHeader = sapObligHeaders.iterator();
		while(enumHeader.hasNext()) {
			ZESCQSOBLIGATIONHDSUM oHeader = (ZESCQSOBLIGATIONHDSUM)enumHeader.next();
			if(oHeader.getCONTRACTSTATUS() != null){
				if(oHeader.getCONTRACTSTATUS().trim().equalsIgnoreCase(EsConstants.ABAP_TRUE)){
					isActive = true;
					break;
				}
			}
		}
		
    	return isActive;
    }

    
    /**
     * @return the earliest start date (HeaderStartDate) from all existing ObligationHeader objects

    private org.exolab.castor.types.Date getEarliestHeaderStartDate() {
        org.exolab.castor.types.Date date = null;
        // find the earliest start date from all ObligationHeaders
 
    	Collection sapObligHeaders = ((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getOBLIGATIONHEADERS().getItem();
		
		Iterator enumHeader = sapObligHeaders.iterator();
		while(enumHeader.hasNext()) {
			ZESCQSOBLIGATIONHDSUM oHeader = (ZESCQSOBLIGATIONHDSUM)enumHeader.next();
			if(oHeader.getHEADERSTARTDATE() != null){
                if (date==null || date.compareTo(MappingUtils.mapToCastorDate(oHeader.getHEADERSTARTDATE()))== org.exolab.castor.types.DateTimeBase.GREATER_THAN) {
                    date = MappingUtils.mapToCastorDate(oHeader.getHEADERSTARTDATE());
                }	
			}
		}
		
        return date;
    }
     */
    
    
    /**
     * @return the latest header end date (HeaderEndDate) from all existing ObligationHeader objects

    private org.exolab.castor.types.Date getLatestHeaderEndDate() {
        org.exolab.castor.types.Date date = null;
        // find the latest end date from all ObligationHeaders
 
    	Collection sapObligHeaders = ((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getOBLIGATIONHEADERS().getItem();
		
		Iterator enumHeader = sapObligHeaders.iterator();
		while(enumHeader.hasNext()) {
		    ZESCQSOBLIGATIONHDSUM oHeader = (ZESCQSOBLIGATIONHDSUM)enumHeader.next();
			if(oHeader.getHEADERENDDATE() != null){
                if (date==null || date.compareTo(MappingUtils.mapToCastorDate(oHeader.getHEADERENDDATE()))== org.exolab.castor.types.DateTimeBase.LESS_THAN) {
                    date = MappingUtils.mapToCastorDate(oHeader.getHEADERENDDATE());
                }	
			}
		} 
		
        return date;
    }
         */
}
