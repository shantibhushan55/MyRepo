package com.hp.es.service;

/**
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/RequestCleaner.java 1.25 2004-09-28 13:48:56+02 stefsobe Exp $
 *
 * Title:
 * Description:
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 *
 *
 */
import org.exolab.castor.types.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.AssociatedContractsRequest;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.ContractRequestComplexType;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.PrintAdvantageRequest;
import com.hp.es.xml.service.RoutingDetailsRequest;
import com.hp.es.xml.service.UnitEventHistoryRequest;
import com.hp.es.xml.service.WarrantyRequest;

public class RequestCleaner{
    private static final String CASTOR_EMPTY_DATE_STRING = "0000-00-00";
    private static final boolean snLeftTrimEnable = Configuration.getInstance().getProperties().getBooleanProperty(EsConstants.ES_SN_WARRANTY_LEFT_TRIM_ENABLE, Boolean.TRUE).booleanValue();
    
    static {
    	ESLog.debug("ES_SN_CONTRACT_LEFT_TRIM_ENABLE is "+snLeftTrimEnable);
    }
    /**
     * This will perform all transformation and defaulting for the request parameters.  The work is done
     * <strong>directly on the passed object</strong>.
     * @param esRequest the request object to clean.
     * @see #cleanACopyOfThisRequest(EsRequestComplexType)
     */
    public static void cleanThisRequest(EsRequestComplexType esRequest){

        final EsRequestComplexTypeChoice choice = esRequest.getEsRequestComplexTypeChoice();
        if(choice != null) {
            if(choice.getWarrantyRequest() != null){ //WITS.1471 ??
                cleanThisRequest(choice.getWarrantyRequest());
            } else if(choice.getEntitlementBySnRequest() != null){ //WITS.1471
                cleanThisRequest(choice.getEntitlementBySnRequest());
            } else if(choice.getEntitlementByPnRequest() != null){ //WITS.1471
                cleanThisRequest(choice.getEntitlementByPnRequest());
            } else if(choice.getAssociatedContractsRequest() != null){
                cleanThisRequest(choice.getAssociatedContractsRequest());
            } else if(choice.getContractRequest() != null){ //WITS.1471
                cleanThisRequest(choice.getContractRequest());
            } else if(choice.getRoutingDetailsRequest() != null){
                cleanThisRequest(choice.getRoutingDetailsRequest());
            } else if(choice.getPrintAdvantageRequest() != null){
                cleanThisRequest(choice.getPrintAdvantageRequest());
            }else if(choice.getUnitEventHistoryRequest() != null){
                cleanThisRequest(choice.getUnitEventHistoryRequest());
            }

        }
    }

    private static void cleanThisRequest(
			UnitEventHistoryRequest unitEventHistoryRequest) {
    	unitEventHistoryRequest.setSerialNumber(cleanSingleQuotationAndSpace(unitEventHistoryRequest.getSerialNumber()));
    	unitEventHistoryRequest.setProductNumber(cleanSingleQuotationAndSpace(unitEventHistoryRequest.getProductNumber()));		
	}

	/**
     * The following function will perform all transformation and defaulting for the request parameters.  The work is done directly on the
     * passed object.
     * @param request the request object to clean.
     */
    //EntitlementBySnRequest
    private static void cleanThisRequest(EntitlementBySnRequest request){
    	request.setSerialNumber(cleanSingleQuotationAndSpace(request.getSerialNumber()));
    	request.setProductID(cleanSingleQuotationAndSpace(request.getProductID()));
    	
        request.setSerialNumber(cleanStringNullTrimUpper(request.getSerialNumber()));
        boolean snLeftTrimEnable = Configuration.getInstance().getProperties().getBooleanProperty(
                EsConstants.ES_SN_CONTRACT_LEFT_TRIM_ENABLE, Boolean.TRUE).booleanValue();
        if(snLeftTrimEnable){
            request.setSerialNumber(keepLastCharactersIfNeed(cleanStringNullTrimUpper(request.getSerialNumber())));
        }        
        request.setProductID(cleanStringNullTrimUpper(request.getProductID()));
        cleanThisRequest((ContractRequestComplexType)request);        
    }
    //EntitlementByPnRequest
    private static void cleanThisRequest(EntitlementByPnRequest request){
    	request.setProductID(cleanSingleQuotationAndSpace(request.getProductID()));
	
        request.setProductID(cleanStringNullTrimUpper(request.getProductID()));
        request.setCustomerDefinedID(cleanStringNullTrimUpper(request.getCustomerDefinedID()));
        /* WITS.1464 IncludeUniqueOffers should automatically be considered true
		 * as soon as IncludeUniqueDeliverables is true. */
		if (request.getIncludeUniqueDeliverables()) {
			request.setIncludeUniqueOffers(true);
		} // End WITS.1464

		
        cleanThisRequest((ContractRequestComplexType)request);
    }
    //AssociatedContractsRequest
    private static void cleanThisRequest(AssociatedContractsRequest request){
        request.setIsoCountryCd(cleanStringNullTrimUpper(request.getIsoCountryCd()));
    }
    //ContractRequest
    private static void cleanThisRequest(ContractRequest request){
    	request.setProductID(cleanSingleQuotationAndSpace(request.getProductID()));
    	
        request.setProductID(cleanStringNullTrimUpper(request.getProductID()));
        request.setCustomerDefinedID(cleanStringNullTrimUpper(request.getCustomerDefinedID()));
        /* WITS.1464 IncludeUniqueOffers should automatically be considered true
		 * as soon as IncludeUniqueDeliverables is true. */
		if (request.getIncludeUniqueDeliverables()) {
			request.setIncludeUniqueOffers(true);
		} // End WITS.1464
        cleanThisRequest((ContractRequestComplexType)request);
    }
    //RoutingDetailsRequest
    private static void cleanThisRequest(RoutingDetailsRequest request){
        //no actions
    }
    //EntitlementBySnRequest
    private static void cleanThisRequest(PrintAdvantageRequest request){
        request.setIsoCountryCd(cleanStringNullTrimUpper(request.getIsoCountryCd()));
    }
    //WarrantyRequest
    private static void cleanThisRequest(WarrantyRequest request){
    	request.setSerialNumber(cleanSingleQuotationAndSpace(request.getSerialNumber()));
    	request.setProductID(cleanSingleQuotationAndSpace(request.getProductID()));
	
        // clean logically null Date elements
        request.setEntitlementCheckDate(cleanCastorDate(request.getEntitlementCheckDate()));
        request.setProofPurchaseDate(cleanCastorDate(request.getProofPurchaseDate()));
        // clean String elements
        request.setIsoCountryCd(cleanStringNullTrimUpper(request.getIsoCountryCd()));
        request.setSourceSystem(cleanStringNullTrimUpper(request.getSourceSystem()));
        request.setCarePackSerialNumber(cleanStringNullTrimUpper(request.getCarePackSerialNumber()));
        request.setCarePackProductNumber(cleanStringNullTrimUpper(request.getCarePackProductNumber()));
        
        
        ESLog.debug("ES_SN_WARRANTY_LEFT_TRIM_ENABLE is true.");
        if(snLeftTrimEnable){
            
            request.setSerialNumber(keepLastCharactersIfNeed(cleanStringNullTrimUpper(request.getSerialNumber())));
        }
        
        // note: we first extract the product-without-option, then do the usual stuff
        request.setProductID(removeProductOption(request.getProductID()));
        request.setProductID(cleanStringNullTrimUpper(request.getProductID()));
        request.setSparePartNumber(cleanStringNullTrimUpper(request.getSparePartNumber()));
        request.setDateCode(cleanStringNullTrimUpper(request.getDateCode()));
        request.setServiceID(cleanStringNullTrimUpper(request.getServiceID()));
        request.setMarketSegment(cleanStringNullTrimUpper(request.getMarketSegment()));
        request.setGeoCode(cleanStringNullTrimUpper(request.getGeoCode()));
        // map values
        if(request.getIsoCountryCd() != null) {
            // apply known mappings for country code (e.g. UK => GB)
            String countryCode = Configuration.getInstance().getProperties().getProperty(
                EsConstants.COUNTRY_CODE_MAPPING_PREFIX + request.getIsoCountryCd(),request.getIsoCountryCd());
            request.setIsoCountryCd(countryCode);
        }
        // default values
        if(request.getEntitlementCheckDate() == null){
            request.setEntitlementCheckDate(DateHelper.mapJavaDate2Castor(new java.util.Date()));
        }
        if(request.getSourceSystem() == null){
            request.setSourceSystem("ALL");
        }
		
    }

    /**
     * clean the ContractRequestComplexType
     */
    private static void cleanThisRequest(ContractRequestComplexType request){
        request.setIsoCountryCd(cleanStringNullTrimUpper(request.getIsoCountryCd()));
        //if checkdate is null, it should use default value which is today
        request.setEntitlementCheckDate(defaultTodayCastorDate(request.getEntitlementCheckDate()));
		/* WITS.1471: Return the flags which are used to select the ES data 
		 * 1. If modifiers are requested, we also return
		 *    - deliverables
		 *    - services
		 * 2. If deliverables are requested, we also return
		 *    - services	*/	 		
		if (request.getIncludeModifiers()) {
			request.setIncludeDeliverables(true);
			request.setIncludeOffers(true);
		}else if (request.getIncludeDeliverables()) {
			request.setIncludeOffers(true);
		} //End WITS.1471
    }

    /**
     * This will perform all transformation and defaulting for the request parameters.  The work is done
     * <strong> on a copy of the passed object</strong>.
     * @param esRequest the request object to clean
     * @return a cleaned copy of the passed request object
     * @see #cleanThisRequest(EsRequestComplexType)
     */
    public static EsRequestComplexType cleanACopyOfThisRequest(EsRequestComplexType esRequest){
        /* todo:
         * 1. take a deep copy of the passed request object
         * 2. return cleanThisRequest(copyOfRequest)
         */
        throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * This will perform all transformation and defaulting for the request parameters.  The work is done
     * <strong> on a copy of the passed object</strong>.
     * @param request the request object to clean
     * @return a cleaned copy of the passed request object
     * @see #cleanThisRequest(WarrantyRequest)
     */
    public static WarrantyRequest cleanACopyOfThisRequest(WarrantyRequest request){
        /* todo:
         * 1. take a deep copy of the passed request object
         * 2. return cleanThisRequest(copyOfRequest)
         */
        throw new UnsupportedOperationException("not yet implemented");
    }

    /* -------------------------------------------------------------------
         private helper methods
         ------------------------------------------------------------------- */
    /**
     * Castor will unmarshall a present-but-empty Date element as a real Date object set to zeros
     * (see the CASTOR_EMPTY_DATE_STRING definition).  Here we translate this logical null into
     * a real java null value.
     * @param castorDate
     * @return a Castor Date, or java null
     */
    private static Date cleanCastorDate(Date castorDate){
        if((castorDate != null) && (CASTOR_EMPTY_DATE_STRING.equals(castorDate.toString()))){
            return null;
        } 
        return castorDate;
        
    }

    private static Date defaultTodayCastorDate(Date castorDate) {
        if ((castorDate == null) || CASTOR_EMPTY_DATE_STRING.equals(castorDate.toString())) {
            return (new Date(new java.util.Date()));
        }
        return castorDate;
        
    }

    /**
     * This version of cleanString() will do the following:
     * <ul>
     * <li>trim leading/trailing white space from value
     * <li>translate empty strings to java null
     * <li>shift value to upper-case
     * </ul>
     * @param str
     * @return a cleaned string, or java null
     */
    private static String cleanStringNullTrimUpper(String passstr){
    	String str = null; 
    	str = passstr;
        if(str != null){
            if("".equals(str.trim())){
                // logical null => java null
                str = null;
            } else{
                // trim and upper
                str = str.trim().toUpperCase();
            }
        }
        return str;
    }

    /**
     * This will trim the product option (starting with a '#') from the product.
     * Leading spaces for the option are not removed; this is handled when we clean the product
     * string itself.
     * @param productNr
     * @return a cleaned string, or java null
     * @see #cleanStringNullTrimUpper(String)
     */
    private static String removeProductOption(String productNr){
        if(productNr == null){
            return null;
        }
        final int idx = productNr.indexOf('#');
        if(idx < 0){
            return productNr;
        } else if(idx == 0){
            return null;
        } else{
            return productNr.substring(0,idx);
        }
    }
    
    
    /**
     * @deprecated Currently it never used
     * This will remove extraneous leading 'S' if the serial number is 11 digits in length and the first character is an 'S' for warranty entitlement.
     * @param serialNumber
     * @return corrected serialNumber

    private static String removeExtraneousLeadingSIfNeed(String serialNumber) {
        if (serialNumber != null && serialNumber.length() == 11 && serialNumber.startsWith("S")) {
            return serialNumber.substring(1);
        }
        return serialNumber;
    }     */
    
    /**
     * @since from MV project
     * 
     * keep the last lastTrimLength characters if SN is longer than lastTrimLength
     * @param serialNumber
     * @return
     */
    private static String keepLastCharactersIfNeed(String serialNumber) {
    	int lastTrimLength = 20;
		try {
			lastTrimLength = Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_SN_MAX_LEFT_TRIM_LENGTH);
		} catch (Exception e) {
			ESLog.warn("ES_SN_MAX_LEFT_TRIM_LENGTH contains invalid data!");
		}
    	if (serialNumber != null && serialNumber.length() > lastTrimLength) {
            return serialNumber.substring(serialNumber.length() - lastTrimLength);
        }
    	return serialNumber;
    }
    
    /**
     * clean SingleQuotation and space in SN and PN as it will cause GUI SQL Exception
     * @param serialNumber or productId
     * @return
     */
    private static String cleanSingleQuotationAndSpace(String pnOrsn){
        if(pnOrsn != null){
            if("".equals(pnOrsn.trim())){
            	return pnOrsn;
            } else{
            	return pnOrsn.replaceAll("'", "").trim();
            }
        }else{
        	return pnOrsn;
        }	
    }
}
