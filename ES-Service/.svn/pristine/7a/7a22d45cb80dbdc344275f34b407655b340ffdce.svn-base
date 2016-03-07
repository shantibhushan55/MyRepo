/*
 * BatchReplyMapper
 * Created on 2 d�c. 2004
 *
 * Entitlement Service Project
 * This the batch reply mapping calss
 */
package com.hp.es.service.batchEntitlement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.exolab.castor.types.Date;

import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.WarrantyRequest;
/**
 * @author anvoi
 * The batch reply mapper, map reply from ES service into the batch schema. Only EntitlementItemComplexType is being mapped as else it will take too much time
 *
 */
class BatchRequestMapper {

    private static BatchRequestMapper _instance = new BatchRequestMapper();
    // Some Constants
    private final static String BATCH_CLIENT_APP_ID="ESBatchTool";
    private final static String BATCH_OPERATION_NAME="getEntitlementBySn";


    /*
     * Constructor
     */
    private BatchRequestMapper() {

    }

    /*
     * singleton method
     * @return singleton for this class
     */
    synchronized static BatchRequestMapper getInstance() {

        return _instance;
    }

    /*
     * Build the request with the input parameters.
     * @param a SubRequest
     * @return request the built request
     * @throws MapperException
     */
    EsRequestComplexType createEsRequestComplexType(SubRequest sr) throws MapperException {



	    if(sr== null || sr.getIsoCountryCode() == null || sr.getSerialNumber() == null || sr.getIsoCountryCode().trim().length()==0
	            || sr.getSerialNumber().trim().length()==0) {
	        throw new MapperException("Iso Country Code and Serial Number must have value.");
	    }
        String isoCountryCode=sr.getIsoCountryCode();
		String serialNumber=sr.getSerialNumber();
		String productId= sr.getProductId();
		boolean includeOffers =sr.isIncludeOffers();
		boolean includeContracts = sr.isIncludeContracts();

	    EsRequestComplexType request = new EsRequestComplexType();
	    EsRequestComplexTypeChoice erctc = new EsRequestComplexTypeChoice();
	    EntitlementBySnRequest     ebsr  = new EntitlementBySnRequest();
	    String checkDateStr = sr.getCheckDate();
	    String strForCastorDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
	    if(checkDateStr != null && !"".equals(checkDateStr.trim())) {
	    	try {
	    		strForCastorDate = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy").parse(checkDateStr));
	    	} catch (ParseException e) {
	    		ESLog.error("Wrong date format for Check Date, should be dd-MM-yyyy");
	    	}
	    }
	    try {
	    	ebsr.setEntitlementCheckDate(new Date(strForCastorDate));
		} catch (ParseException e) {
			ESLog.error("issue when parse String to castor date");
		}
	    
	    request.setClientAppID(BATCH_CLIENT_APP_ID);
	    request.setOperation(BATCH_OPERATION_NAME);
	    /*
	     * As not specified we are setting activeXXonly to false
	     */

	    ebsr.setIncludeContracts(includeContracts);
	    ebsr.setIncludeOffers(includeOffers);
        //If includeOffers is true, includeModifiers is also true.
        ebsr.setIncludeModifiers(includeOffers);

	    ebsr.setIncludeWarranty(true);

	    ebsr.setIsoCountryCd(isoCountryCode);
	    ebsr.setProductID(productId);
	    ebsr.setSerialNumber(serialNumber);
	    ebsr.setIncludeWorkings(true);



	    erctc.setEntitlementBySnRequest(ebsr);
	    request.setEsRequestComplexTypeChoice(erctc);

	    return request;
	}

}
//eof