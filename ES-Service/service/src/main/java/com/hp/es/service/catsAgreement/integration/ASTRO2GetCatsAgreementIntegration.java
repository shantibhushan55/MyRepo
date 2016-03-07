package com.hp.es.service.catsAgreement.integration;

import java.util.ArrayList;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.integration.mapping.CATSAgreementMapper;
import com.hp.es.service.catsAgreement.integration.mapping.CATSAgreementRequestMapper;
import com.hp.es.service.catsAgreement.integration.mapping.ErrorMapper;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class ASTRO2GetCatsAgreementIntegration extends ASTRO2CatsAgreementIntegration {

    public ASTRO2GetCatsAgreementIntegration(WarrantyEntitlementComplexType warrantyEntitlement) {
        super(warrantyEntitlement);
    }

    protected CatsAgreementTransaction doCatsAgreementIntegration(EsRequestComplexType request, MetricsHandler handler) throws SifException {
        ESLog.debug("Mapping ES request to ASTRO2 request");
        // map ES request to ASTRO2 request
        Object astro2Request = mapEsRequest2Astro2Request(request);

        Transaction transaction = null;
        try {
            ESLog.debug("Send request to ASTRO2");

            transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_ASTRO2, astro2Request, getRegionDisplayName(), isLocal(), handler);

        } catch (Exception e) {
        	if(ESLog.isDebugLogEnabled())
           		ESLog.debug("Exception while connecting to ASTRO2 ", e);
        	
        	ESLog.error("Exception while connecting to ASTRO2 "+ e.getMessage());
            if (e instanceof SifException) {
                throw (SifException) e;
            } 
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "ASTRO2",
                        "Unkown Exception class:" + e.getClass().getName() + ", Message: " + e.getMessage());

        }

        // Check the reply for any errors
        if (transaction.isSourceSystemError()) {
            CatsAgreementTransaction catsTransaction = (CatsAgreementTransaction) transaction;
            try {
                List<EIAError> errors = new ArrayList<EIAError>();
                errors.add(mapError(catsTransaction));
                catsTransaction.setMappedErrors(errors);
            } catch (MappingException e) {
                ESLog.info("Exception while mapping", e);
                throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, e.getMessage(), "ASTRO2");
            }
            return catsTransaction;
        } else if (transaction instanceof ErrorTransaction) {
            ESLog.debug("We have an error ...");
            // ERROR
            // There is no need to do anything here, it will be done in the composition layer
            // so we simply return the transaction
            return mapErrorTransaction2ComposedErrors(EsConstants.SAP_FUNCTION_NAME_ASTRO2, (ErrorTransaction) transaction);
        } else {
            ESLog.debug("We have a sucessfull reply ...");
            // NORMAL REPLY
            CatsAgreementTransaction catsTransaction = (CatsAgreementTransaction) transaction;
            mapAstro2Reply2EsReply(catsTransaction, request);
            return (CatsAgreementTransaction) transaction;
        }
    }

    protected void mapAstro2Reply2EsReply(CatsAgreementTransaction transaction, EsRequestComplexType request) throws SifException {
        ESLog.debug("Enter");
        try {
            ESLog.debug("Creating the reply structure");
            EsReply reply = new EsReply();

            // set request
            reply.setEsHeader(new EsHeader());
            reply.getEsHeader().setInputRequest(request);

            // set warnings
            ESLog.debug("Warnings will be mapped");
            EIAError eiaError = mapError(transaction);
            if (eiaError != null) {
                reply.getEsHeader().setWarnings(new Warnings());
                reply.getEsHeader().getWarnings().addEIAError(eiaError);
            }
            // set warranty
            reply.setEsReplyChoice(new EsReplyChoice());
            ESLog.debug("A CATSAgreement will be mapped");
            CATSAgreementMapper catsMapper = CATSAgreementMapper.getInstance(transaction, request, _swopWarranty);
            WarrantyEntitlementComplexType astro2WarrantyEnt = catsMapper.map();
            if (astro2WarrantyEnt != null) {
                reply.getEsReplyChoice().setWarrantyEntitlement(astro2WarrantyEnt);
            }

            // add reply into transaction
            transaction.setMappedReply(reply);

        } catch (MappingException e) {
            ESLog.info("Exception while mapping", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "ASTRO2", "Unkown Exception class:" + e.getClass().getName()
                    + ", Message: " + e.getMessage());
        }

        ESLog.debug("Exit");

    }

    /**
     * @param esRequest
     * @return an reply suitable for input to Region.execute()
     */
    public Object mapEsRequest2Astro2Request(EsRequestComplexType esRequest) {
        return CATSAgreementRequestMapper.getInstance().map(esRequest, getClientType(), getCallOption(), getSwopProductId(), getSwopShipToCountry());
    }

    /**
     * This method map ASTRO2 error (ERROR_CODE and ERROR_MESSAGE) to ES error.
     */
    protected final EIAError mapError(CatsAgreementTransaction transaction) throws MappingException {
        ErrorMapper em = ErrorMapper.getInstance(transaction);
        return em.map();
    }
}
