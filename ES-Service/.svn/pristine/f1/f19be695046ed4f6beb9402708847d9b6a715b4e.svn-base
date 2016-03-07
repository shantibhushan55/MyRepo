/*
 * Project: HPS Entitlement Service
 *
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 */
package com.hp.es.service.ibSearch;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.ibSearch.integration.mapping.MappingHelper;
import com.hp.es.service.ibSearch.orchestration.IBSearchOrchestraction;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.InstalledBaseUnitRequest;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class GetInstalledBaseUnitsOperation extends EsOperation {
	
    /**
     * This method has to be imeplemented by the sub classes. It processes the
     * the requests and return an EsReply, which is sent back to the client.
     * @param request the request that was sent from the client
     * @param metricsHandler
     * @throws SifException      Thrown when the request couldn't be processed
     *                           successfully.
     * @return EsReply the reply that can be sent back to the client
     */    
    protected EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler)
    			throws SifException {
    	        
        ESLog.debug("Enter");

        try {
            ESLog.debug("Calling IB Search orchestration ...");
            return IBSearchOrchestraction.getInstance().execute(request, context, metricsHandler);
        } finally {
            ESLog.debug("Exit");
        }
    }
    
    /**
     * This method is called by the OperationManager when a new object of the
     * Operation is created. All time-consuming initializations should be done
     * here. <b>Note:</b> The same Operation object will be used in parallel
     * by multiple threads. The access to other resources needs to be
     * synchronized if necessary.
     */
    protected void init() {
    }

    /**
     * This method is automatically called before the execute() is called. It
     * should validate if all input parameter are meaningful and complete.
     * When this method doesn't throw an exception, the execute() method should
     * be able to process the request.
     * @param request the request that was sent from the client
     * @param metricsHandler
     * @throws SifException when the parameter of the request are not complete
     *                      or not meaningful, i.e. when the request cannot
     *                      be handled by the operation
     */
    protected void verifyRequest(EsRequestComplexType request, MetricsHandler metricsHandler)
        throws SifException {
        InstalledBaseUnitRequest ibRequest = request.getEsRequestComplexTypeChoice().getInstalledBaseUnitRequest();
      
        if (ibRequest == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id120_INVALID_REQUEST,
                "The GetInstalledBaseUnits operation requires an InstalledBaseUnitRequest request.");
        }
        // Product number
        String productNum = ibRequest.getProductID();
        if (productNum == null) {
            productNum = "";
        }
        
        // Serial number
        String serialNum = ibRequest.getInstalledBaseUnitRequestChoice() == null
                         ? null
                         : ibRequest.getInstalledBaseUnitRequestChoice().getSerialNumber();
 
        if (serialNum == null) {
            serialNum = "";
        }
        
        // Sales order number
        String salesOrderNum = ibRequest.getInstalledBaseUnitRequestChoice() == null
                             ? null
                             : ibRequest.getInstalledBaseUnitRequestChoice().getSalesOrderNumber();
        if (salesOrderNum == null) {
            salesOrderNum = "";
        }
        
        // source system
        String sourceSystem = ibRequest.getSourceSystem();
        if(sourceSystem == null) {
            sourceSystem = "";
        }
        
        // check if we have serial number and sales order number
        if (!"".equals(serialNum) && !"".equals(salesOrderNum)) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "One of input parameters in serialNum and salesOrderNum should be empty.");
        }
        
        // check if we have NO serial number and NO sales order number
        if ("".equals(serialNum) && "".equals(salesOrderNum)) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "One of input parameters in serialNum and salesOrderNum should not be empty.");
        }

        // check for compinations with serial number
        if (!"".equals(serialNum)) {
            //Check serialNum and productNum, salesOrderNum is not available
            if ("*".equals(serialNum)) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "SerialNumber as a wildcard input requires a minimum of the first 5 characters + *");
            }
            if ("*".equals(productNum)) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "ProductNumber as wildcard input requires a minimum of the first 3 characters + *");
            }
            if (serialNum.indexOf("*") >= 0 && productNum.indexOf("*") >= 0) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "On ProductNumber and SerialNumber input cases, only one input can contain a wildcard - the other must contain the full data string");
            }
            if (serialNum.indexOf("*") >= 0 && serialNum.indexOf("*") <= 4) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "SerialNumber as a wildcard input requires a minimum of the first 5 characters + *");
            }
        // check for combinations with sales order number
        } else if (!"".equals(salesOrderNum)) {
            // check containing '*' leading by any preceding characters
            if ("*".equals(salesOrderNum)) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "The GetInstalledBaseUnits operation requires request salesOrderNum parameters "
                        + "containing '*' leading by any preceding characters.");
            }
            if ("*".equals(productNum)) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "SalesOrderNumber as a wildcard input requires a minimum of the first 5 characters + *");
            }
            if (salesOrderNum.indexOf("*") >= 0 && productNum.indexOf("*") >= 0) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "On ProductNumber and SalesOrderNumber input cases, only one input can contain a wildcard - the other must contain the full data string");
            }
            if (salesOrderNum.indexOf("*") >= 0 && salesOrderNum.indexOf("*") <= 4) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "SalesOrderNumber as a wildcard input requires a minimum of the first 5 characters + *");
            }
            //end
        }
        if (productNum.indexOf("*") >= 0 && productNum.indexOf("*") <= 2) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "ProductNumber as wildcard input requires a minimum of the first 3 characters + *");
        }
        // use wildcard at the ends for serialNum,productNum,salesOrderNum
        if (serialNum.indexOf("*") >= 0
            && !serialNum.endsWith("*")) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "SerialNumber as wildcard input requires a minimum of the first 5 characters + *");
        }
        if (productNum.indexOf("*") >= 0
            && !productNum.endsWith("*")) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "ProductNumber as wildcard input requires a minimum of the first 3 characters + *");
        }
        if (salesOrderNum.indexOf("*") >= 0
            && !salesOrderNum.endsWith("*")) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "SalesOrderNumber as wildcard input requires a minimum of the first 5 characters + *");
        }

        // getting the result size
        int resultSize = MappingHelper.getInstance().getRequestedTotalResultSize(request.getEsRequestComplexTypeChoice().getInstalledBaseUnitRequest());  
        if (resultSize > 200 || resultSize <= 0) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "ResultSize as input should be between 0 and 200.");
        }
        
        if( (productNum!=null) && (productNum.trim().length()!=0)){
			int maximum=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
			ProductNumberValidator.verifyProductNumberGreaterThan(productNum, maximum);
		}

    }

}