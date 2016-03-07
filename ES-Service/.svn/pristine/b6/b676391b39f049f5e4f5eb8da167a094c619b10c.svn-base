/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/GetAssociatedContractsOperation.java 1.22 2004-05-08 04:42:41+02 entitlem Exp $
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
 * $Log: GetAssociatedContractsOperation.java,v $
 * Revision 1.22  2004-05-08 04:42:41+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.21  2004-05-05 15:41:30+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.20  2004-01-29 18:07:27+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.19  2003-12-03 18:05:32+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * This operation ignores the NO DATA FOUND (300).
 *
 * Revision 1.18  2003-12-03 16:57:15+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * let DbContractEntitlementManager return an error code in case of "no data found"
 *
 * Revision 1.17  2003-12-03 14:48:07+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * handle no-data-found
 *
 * Revision 1.16  2003-08-19 13:32:27+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * inherit class from EsOperation (instead of Operation)
 *
 * Revision 1.15  2003-08-04 16:51:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.14  2003-07-15 18:54:17+02  lbednari
 * Author: lbednari@dhcp-15-197-229-125.bbn.hp.com ()
 * - passing MetricsHandler to DbContractEntitlementManager method call
 *
 * Revision 1.13  2003-07-01 21:48:39+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * - transaction id in EsHeader now set on service handler level
 *
 * Revision 1.12  2003-06-26 01:02:33+02  lbednari
 * Author: lbednari@bbnnaid72.bbn.hp.com ()
 * CountryCode -> IsoCountryCd
 *
 * Revision 1.11  2003-06-04 19:25:52+02  lbednari
 * Author: lbednari@bbnnaid28.bbn.hp.com ()
 * using new constants for error ids
 *
 * Revision 1.10  2003-06-04 15:06:45+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * change exception handling and/or log output
 *
 * Revision 1.9  2003-05-12 02:00:02+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.8  2003-04-30 10:39:23+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * - obsolete WarrantyDetailsKNIGHT, WarrantyDetailsKNIGHTImpl,
 *   EsLocalState, HPSEServiceHandler, WarrantyService,
 *   WarrantyServiceImpl, whole state package
 * - applied KNIGHT WSDL change (for red warranty)
 *
 * Revision 1.7  2003-04-29 13:08:43+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * bugfix octal number used for error code
 *
 * Revision 1.6  2003-04-25 18:27:35+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * debug contactlist
 *
 * Revision 1.5  2003-04-25 15:14:05+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * bugfix index mistake
 *
 * Revision 1.4  2003-04-23 08:40:05+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * bugfix error while converting the contracts collection into an array
 *
 * Revision 1.3  2003-04-22 15:28:28+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * changes for fixed request class
 *
 * Revision 1.2  2003-04-22 14:00:39+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * bugfix cut&paste-errors
 *
 * Revision 1.1  2003-04-17 08:58:47+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * Initial revision
 */
package com.hp.es.service.contractEntitlement;

import com.hp.es.service.contractEntitlement.db.DbContractEntitlementManager;
import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.AssociatedContractsComplexType;
import com.hp.es.xml.service.AssociatedContractsRequest;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Handle the AssociatedContractsRequests
 */
public class GetAssociatedContractsOperation extends EsOperation {

    //private DbContractEntitlementManager dbContractEntitlementManager;

    /**
     * This method has to be imeplemented by the sub classes. It processes the
     * the requests and return an EsReply, which is sent back to the client.
     * @param request the request that was sent from the client
     * @param metricsHandler
     * @throws SifException      Thrown when the request couldn't be processed
     *                           successfully.
     * @return EsReply the reply that can be sent back to the client
     */
    protected EsReply execute(EsRequestComplexType request, OperationContext context,
                              MetricsHandler metricsHandler)
                  throws SifException {

        AssociatedContractsRequest acr = request.getEsRequestComplexTypeChoice()
                                                .getAssociatedContractsRequest();
        DbContractEntitlementManager dbContractEntitlementManager =DbContractEntitlementManager.getNewInstance();
        EsReplyContext ctx =null;
        try {
            OutputDetails details = new OutputDetails(acr);
            ctx = new EsReplyContext(details);
            
            // call the database
            int errorId = dbContractEntitlementManager.getAssociatedContracts(
                                ctx,
                                acr.getAssociatedContractIdentifier(),
                                acr.getAssociatedContractIdentifierType(),
                                getContactSearchString(acr),
                                acr.getIsoCountryCd(),
                                acr.getActiveContractsOnly(),
                                acr.getChunkSize(),
                                acr.getChunkPosition(),
                                metricsHandler);

            // check for errors returned from the database
            // Note: This operation ignores the NO DATA FOUND (300)
            if (errorId!=0 && errorId!=300) {
                // map errorId to SifException
                // this probably needs to be enhanced to provide more details
                throw ErrorFactory.getSifException(errorId);
            }

            // merge objects, create ID/IDREFs, calculate overall start/end dates
            ctx.mergeAndCalculateAll();

            AssociatedContractsComplexType result = new AssociatedContractsComplexType();

            result.setContract( (ContractComplexType[])ctx.getContracts().toArray(new ContractComplexType[0]) );
            result.setActualChunkSize(ctx.getCurrentChunkSize());
            result.setChunkPosition(acr.getChunkPosition());
            result.setChunkSize(acr.getChunkSize());
            result.setTotalResultSize(ctx.getTotalResultSize());

            EsHeader esHeader = new EsHeader();
            esHeader.setInputRequest(request);
            // transaction ID is set in service handler class

            EsReplyChoice esReplyChoice = new EsReplyChoice();
            esReplyChoice.setAssociatedContracts(result);

            EsReply esReply = new EsReply();
            esReply.setEsHeader(esHeader);
            esReply.setEsReplyChoice(esReplyChoice);

            return esReply;
        } catch (DataAccessException e) {
            ESLog.info("Caught a DataAccessException.");
            return generateEsReplyWithWarning(ErrorFactory.id9999_INTERNAL_ERROR,"Unknow database exception while processing AssociatedContractsRequest.",request);           

        } catch (DatabaseDownException e) {
            ESLog.info("Caught a DatabaseDownException.");
            return generateEsReplyWithWarning(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,"ODS",request);           
        }finally {
        	dbContractEntitlementManager.destroy();
        	/*if(ctx != null) 
        		ctx.destroy();*/
        }
    }

    private EsReply generateEsReplyWithWarning(int errorId, String errorText, EsRequestComplexType request) {
        ESLog.debug("Enter createEsReplyWithWarning()");
        EIAError eiaError = ErrorFactory.getEIAError(errorId, errorText);
        
        Warnings warnings = new Warnings();
        warnings.addEIAError(eiaError);
        
        EsReply esReply = new EsReply();
        EsHeader esHeader=new EsHeader();
        esHeader.setInputRequest(request);        
        esReply.setEsHeader(esHeader);
        esReply.getEsHeader().setWarnings(warnings);
        
        ESLog.debug("Exit createEsReplyWithWarning()");
        return esReply;
    }

    /**
     * This method is called by the OperationManager when a new object of the
     * Operation is created. All time-consuming initializations should be done
     * here. <b>Note:</b> The same Operation object will be used in parallel
     * by multiple threads. The access to other resources needs to be
     * synchronized if necessary.
     */
    protected void init() {
        // just to make sure that the database is initialized when the
        // first request comes in
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
    protected void verifyRequest(EsRequestComplexType request,
                                 MetricsHandler metricsHandler)
                                                           throws SifException {
        AssociatedContractsRequest cr = request.getEsRequestComplexTypeChoice().getAssociatedContractsRequest();
        if (cr==null) {
            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST,
                "The GetAssociatedContracts operation requires an " +
                "AssociatedContractsRequest request.");
        }
    }

    /**
     * concatenate the given PersonIds
     * @param acr
     * @return all contact IDs separated by ';'
     */
    private String getContactSearchString(AssociatedContractsRequest acr) {
        StringBuffer personIds = new StringBuffer();
        for (int i = 0; i < acr.getPersonIDCount(); i++) {
            if (i != 0) {
                personIds.append(';');
            }
            personIds.append(acr.getPersonID(i));
        }
        return personIds.toString();
    }

	
}