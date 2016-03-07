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
package com.hp.es.service.manufacturingHeaderInformation;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceOrchestraction;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class ManufacturingInstalledBaseServiceOperation extends EsOperation {
	
    /**
     * This method has to be implemented by the sub classes. It processes the
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
            ESLog.debug("Calling ManufacturingHeaderInformation  orchestration ...");
            return ManufacturingInstalledBaseServiceOrchestraction.getInstance().execute(request, context, metricsHandler);
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
    	
    	//UnitEventHistoryRequest unitHistoryRequest = request.getEsRequestComplexTypeChoice().getUnitEventHistoryRequest();
    	WarrantyRequest  esWarrantyRequest =  request.getEsRequestComplexTypeChoice().getWarrantyRequest();
    	
    	//ManufacturingBillOfMaterialRequest  bomRequest = new ManufacturingBillOfMaterialRequest();
    
        if ( esWarrantyRequest == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id120_INVALID_REQUEST,
                "The Get SNR Manufactuing BOM request requires a valid Warranty request.");
        }
        if( (esWarrantyRequest.getProductID()!=null) && (esWarrantyRequest.getProductID().trim().length()!=0)){
			int maximum=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
			ProductNumberValidator.verifyProductNumberGreaterThan(esWarrantyRequest.getProductID(), maximum);
		}
        /*
         * TODO add extract check
         * Unit event history will need to check that at SN/PN are provided.
         * 
         */
        /*bomRequest.setSerialNumber(esWarrantyRequest.getSerialNumber());
        bomRequest.setProductNumber(esWarrantyRequest.getProductID());
        */
    }

}
//eof