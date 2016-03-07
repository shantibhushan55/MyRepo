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

import java.util.Date;
import java.util.Enumeration;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSCONTRACTREQUESTSUM;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSPRODUCTID;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSSERVICEABLEPRODSUMT;
import com.hp.es.service.util.DateHelper;
import com.hp.es.xml.service.ContractSummaryRequest;
import com.hp.es.xml.service.EsRequestComplexType;

/**
 * @author yesilyur
 *
 */
public class MetroCQSSummaryRequestMapper  extends CQSSummaryRequestMapper {

	/**
	 * 
	 */
	public MetroCQSSummaryRequestMapper() {
		super();
	}

	public Object map(EsRequestComplexType esRequest) {
		
		ContractSummaryRequest cr = esRequest.getEsRequestComplexTypeChoice().getContractSummaryRequest();
		
		ZESCQSCONTRACTREQUESTSUM cqsRequest = new ZESCQSCONTRACTREQUESTSUM();
		// Populate the request structure fields from the esRequest
		cqsRequest.setSVCAGREEMENTID(cr.getSvcAgreementID());
		
		String productType="";
		if((cr.getProductType() != null) && (cr.getProductType().toString().trim().length() >0)){
			productType = cr.getProductType().toString().trim();			
		}
		if("ALL".equalsIgnoreCase(productType)){
			cqsRequest.setINCLUDEHWPRODUCTS(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDEJWPRODUCTS(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDESWPRODUCTS(EsConstants.ABAP_TRUE);
		}else if ("HW".equalsIgnoreCase(productType)){
			cqsRequest.setINCLUDEHWPRODUCTS(EsConstants.ABAP_TRUE);
		}else if ("SW".equalsIgnoreCase(productType)){
			cqsRequest.setINCLUDESWPRODUCTS(EsConstants.ABAP_TRUE);
		}else if ("JW".equalsIgnoreCase(productType)){
			cqsRequest.setINCLUDEJWPRODUCTS(EsConstants.ABAP_TRUE);			
		}else{
			cqsRequest.setINCLUDEHWPRODUCTS(EsConstants.ABAP_FALSE);
			cqsRequest.setINCLUDEJWPRODUCTS(EsConstants.ABAP_FALSE);
			cqsRequest.setINCLUDESWPRODUCTS(EsConstants.ABAP_FALSE);			
		}
		
		if((cr.getEntitlementCheckDate() == null ) || (cr.getEntitlementCheckDate().toString().trim().equalsIgnoreCase("0000-00-00")) || (cr.getEntitlementCheckDate().toString().trim().length() <= 0))
		{
			cqsRequest.setCHECKDATE(new org.exolab.castor.types.Date(new Date()).toString());							
		}else{
			cqsRequest.setCHECKDATE(DateHelper.toIsoDateString(cr.getEntitlementCheckDate()));			
		}
		
		cqsRequest.setSERVICEABLEPRODUCTSONLY(cr.getServiceableProductsOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		if(cr.getServiceableProductsOnly())
		{
			if((cr.getServiceableProductsOfferList() != null) && (cr.getServiceableProductsOfferList().getOfferCodeCount() > 0)){
				ZESCQSSERVICEABLEPRODSUMT servisProdT = new ZESCQSSERVICEABLEPRODSUMT();
				Enumeration offerEnum = cr.getServiceableProductsOfferList().enumerateOfferCode();
				while(offerEnum.hasMoreElements()){
					String offerCode = (String)offerEnum.nextElement();
					offerCode = offerCode.trim();
					if(offerCode.length() > 0){
						ZESCQSPRODUCTID prodID = new ZESCQSPRODUCTID();
						prodID.setSVCPRODUCTID(offerCode);
						servisProdT.getItem().add(prodID);								
					}
				}
				cqsRequest.setSERVICEABLEPRODOFFERLIST(servisProdT);
			}
		}
		
		cqsRequest.setACTIVECONTRACTSONLY(cr.getActiveContractsOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDESERVICES(cr.getIncludeOffers() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDEDELIVERABLES(cr.getIncludeDeliverables() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDESWSERVICELEVELCAT(cr.getIncludeSoftwareServiceLevelCategory() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDEADDRESSES(cr.getIncludeAddresses() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDECONTACTS(cr.getIncludeContacts() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		
		cqsRequest.setINCLUDEFUNCTIONALLOCATION(cr.getIncludeFunctionalLocation()? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		
		if(cr.getIncludeDeliverables()){
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAP_TRUE);	
		}
		if(cr.getIncludeCustomerIndicator()){
			cqsRequest.setINCLUDEADDRESSES(EsConstants.ABAP_TRUE);	
		}

		if(cr.getIncludeSoftwareServiceLevelCategory()){
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAP_TRUE);	
			//WITS issue 1618
			//cqsRequest.setINCLUDE_FUNCTIONAL_LOCATION(EsConstants.ABAP_TRUE);
			
		}

				
		
		// Now fill the resulting object
		ZESCONTRACTSUMES10 result = new ZESCONTRACTSUMES10();
		result.setESREQUEST(cqsRequest);
		return result;
	}

}
