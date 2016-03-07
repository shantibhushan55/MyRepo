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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSCONTACTSUM;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSLOCATIONSUM;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSOBLIGATIONHDSUM;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSSERVICESITEMSUM;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ObligationHeaderComplexType;
import com.hp.es.xml.service.Offer;
import com.hp.es.xml.service.types.ContractStatusType;
import com.hp.sif.SifException;


public class MetroCSObligationHeaderMapper extends CSObligationHeaderMapper{


	public MetroCSObligationHeaderMapper(ContractSummaryTransaction transaction, XMLIdGenerator generator, Map locationMap, Map contactMap, EsReplyCSContext ctx){
		super(transaction,generator,locationMap,contactMap,ctx);
	}

	
	ObligationHeaderComplexType[] map(boolean includeOffers, boolean includeDeliverables, boolean includeContact, boolean includeLocation, boolean includeFunctionalLocation, boolean includeSWServiceLevelCategory) throws MappingException, SifException {
    	
		if(_transaction == null) {
    		return new ObligationHeaderComplexType[0];
    	}

      	if(includeDeliverables){
      		includeOffers = true;
      	}
		
    	if(((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getOBLIGATIONHEADERS() == null){
    		return new ObligationHeaderComplexType[0];
    	}
		
    	Collection sapObligHeaders = ((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getOBLIGATIONHEADERS().getItem();
        ObligationHeaderComplexType[] obligationHeaders = new ObligationHeaderComplexType[sapObligHeaders.size()];
        

        ESLog.debug("Mapping " + obligationHeaders.length + " obligationHeaders ...");
        int i=0;
        //we go through all sap contracts
        for (Iterator it=sapObligHeaders.iterator(); it.hasNext(); ) {
        	obligationHeaders[i++] = mapObligationHeader((ZESCQSOBLIGATIONHDSUM) it.next(),includeOffers, includeDeliverables,includeContact, includeLocation, includeFunctionalLocation,includeSWServiceLevelCategory);
        }
        return obligationHeaders;
	}


	protected ObligationHeaderComplexType mapObligationHeader(ZESCQSOBLIGATIONHDSUM input,boolean includeOffers, boolean includeDeliverables,boolean includeContact, boolean includeLocation, boolean includeFunctionalLocation, boolean includeSWServiceLevelCategory) throws MappingException, SifException {

			ESLog.debug("Mapping obligationHeader: " + input.getSOURCEOBLIGATIONID());
			ObligationHeaderComplexType oHeader = new ObligationHeaderComplexType();

	      	if(includeDeliverables){
	      		includeOffers = true;
	      	}
			
	    	// Map to obligation header type
	        oHeader.setSourceObligationID(MappingUtils.nullString(input.getSOURCEOBLIGATIONID()));
	        oHeader.setContractDocType(MappingUtils.nullString(input.getCONTRACTDOCTYPE()));
	        oHeader.setHeaderStartDate(MappingUtils.mapToCastorDate(input.getHEADERSTARTDATE()));
	        oHeader.setHeaderEndDate(MappingUtils.mapToCastorDate(input.getHEADERENDDATE()));
	        oHeader.setContractStatus(ContractStatusType.valueOf(MappingUtils.nullString(input.getCONTRACTSTATUS())));
	        oHeader.setDeliveryBlock(MappingUtils.nullString(input.getDELIVERYBLOCK()));
	       	oHeader.setActiveObligation(MappingUtils.mapToBoolean(input.getACTIVEOBLIGATION()));
	        oHeader.setAMPID(MappingUtils.nullString(input.getAMPID()));
	        
        	if(includeFunctionalLocation){
        		oHeader.setFunctionalLocation(MappingUtils.nullString(input.getFUNCTIONALLOCATION()));
        	}
	        
	        oHeader.setSoftwareServiceLevelCategory(MappingUtils.nullString(input.getSWSERVICELEVELCATEGORY()));
	        // The following two fields will be received from ODS - Customer indicator
	        // These fields are also not available in the input object from CQS
	        //oHeader.setCustomerIndicatorName(arg0);
	        //oHeader.setCustomerIndicatorValue(arg0);
	        oHeader.setHPAdminPersonID(MappingUtils.nullString(input.getHPADMINPERSONID()));
	        oHeader.setSoldToCustomID(MappingUtils.nullString(input.getSOLDTOCUSTOMERID()));
	    	
	      	mapAddressAndLocation(oHeader, includeContact, includeLocation);

	      	ZESCONTRACTSUMES10Response cqsReply = (ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply();
	    
        	if(includeOffers) {
	        	List<ZESCQSSERVICESITEMSUM> serviceList = cqsReply.getSERVICES().getItem();
	        	ESLog.debug("Creating offers...");
	        	ArrayList offerAry = new ArrayList();
	        	for (ZESCQSSERVICESITEMSUM service : serviceList) {
	        		if(input.getSOURCEOBLIGATIONID().trim().equalsIgnoreCase(service.getSOURCEOBLIGATIONID().trim())){
		        		ESLog.debug("Creating offer " +service.getITEM() + " for obligation "+input.getSOURCEOBLIGATIONID());
		        		CSOfferMapper mapper = new MetroCSOfferMapper(_transaction,service, _ctx);
		        		Offer offerTmp = mapper.map(includeDeliverables); 
		        		offerAry.add(offerTmp);
	        		}
	        	}
	        	Offer[] items = (Offer[]) offerAry.toArray(new Offer[0]);
	        	oHeader.setOffer(items);	
        	}
	      		      	
        return oHeader;
	}
	
	   
	/**
	 * Maps the IDs and References for the contact and location into the obligation header
	 * @param oHeader
	 * @param includeContact
	 * @param includeLocation
	 * @throws SifException
	 */
	protected void mapAddressAndLocation(ObligationHeaderComplexType oHeader, boolean includeContact, boolean includeLocation) throws SifException {

			// Note: The ID on the header level needs to be always set. Only the references will be set if the request
			//       had the include flag set to true
			
			ZESCONTRACTSUMES10Response cqsReply = (ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply();
			// CONTACT
			if(includeContact) {
				if(cqsReply.getCONTACTS() != null) {
					List<ZESCQSCONTACTSUM> enumCONTACTS = cqsReply.getCONTACTS().getItem();
					for (ZESCQSCONTACTSUM contact : enumCONTACTS) {
						// HP ADMIN
						if(oHeader.getHPAdminPersonID().trim().equalsIgnoreCase(contact.getSOURCEPERSONID().trim())){
							oHeader.setHPAdminPersonRef(_contactMap.get(contact.getSOURCEPERSONID()));
							break;
						}
					}
				}
			}

			// LOCATION
			if(includeLocation) {
				if(cqsReply.getLOCATIONS() != null) {
					List<ZESCQSLOCATIONSUM> cqsLocations = cqsReply.getLOCATIONS().getItem();
					for (ZESCQSLOCATIONSUM location : cqsLocations) {
						// SOLD TO
						if(oHeader.getSoldToCustomID().trim().equalsIgnoreCase(location.getSOURCECUSTOMERID())){
							oHeader.setSoldToCustomRef(_locationMap.get(location.getSOURCECUSTOMERID()));
							break;
						}
					}
				}
			}
		}

}
