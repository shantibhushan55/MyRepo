package com.hp.es.service.routingDetails.integration;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.contractEntitlement.integration.mapping.WarningMapper;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.routingDetails.integration.mapping.ErrorMapper;
import com.hp.es.service.routingDetails.integration.mapping.RequestMapper;
import com.hp.es.service.routingDetails.integration.mapping.RoutingDetailsMapper;
import com.hp.es.service.routingDetails.orchestration.RoutingDetailsTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * RoutingDetailsIntegration
 * 
 * @author Chunyang
 * @since 9.0.2
 */
public class RoutingDetailsIntegration implements IntegrationInterface {

    protected boolean _isLocal = false;
    protected Region _region = null;

    public RoutingDetailsIntegration(String regionName) {
        _region = RegionFactory.getInstance().getRegionByName(regionName);
        _isLocal = regionName.equals(_region.getConfiguration().getRegionName());
    }

    public Transaction execute(EsRequestComplexType request, MetricsHandler handler) throws SifException {
        return doRoutingDetailsIntegration(request, handler);
    }

    private Transaction doRoutingDetailsIntegration(EsRequestComplexType request, MetricsHandler handler)
            throws SifException {

        // map es request to routing details request
        Object rdRequest = mapEsRequest2RdRequest(request);

        // pass request to the region and get the result
        Transaction transaction = null;
        try {
            ESLog.debug("Send request to CQS using Region: " + _region.getConfiguration().getRegionName());
            transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS, rdRequest,
                    getRegionDisplayName(), isLocal(),handler);
    			
        } catch (Exception e) {
        	if(ESLog.isDebugLogEnabled())
           		ESLog.debug("Exception while connecting to CQS", e);

        	ESLog.error("Exception while connecting to CQS"+ e.getMessage());
            if (e instanceof SifException) {
                throw (SifException) e;
            } else {
                throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
                        "Exception while connecting to CQS", e.toString());
            }
        }

        // Check which reply we have error or normal reply
        if (transaction.isSourceSystemError()) {
            // CQS ERRORS
            mapSourceSystemError2ComposedErrors((RoutingDetailsTransaction) transaction, request);    			
            return (RoutingDetailsTransaction) transaction;
        } else if (transaction instanceof ErrorTransaction) {
            ESLog.debug("We have an error ...");
            // ERROR
            // There is no need to do anything here, it will be done in the composition layer
            // so we simply return the transaction
            return mapErrorTransaction2ComposedErrors(EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS,
                    (ErrorTransaction) transaction);
    			
        } else {
            ESLog.debug("We have a reply ...");
            // NORMAL REPLY
            mapCQSReply2EsReply((RoutingDetailsTransaction) transaction, request);    			
            return (RoutingDetailsTransaction) transaction;
        }
    }

    private Object mapEsRequest2RdRequest(EsRequestComplexType request) {
        RequestMapper rm = RequestMapper.getInstance(request);
        return rm.map();
    }


    public String getName() {
        return this.getClass().toString() + "-" + _region.getConfiguration().getRegionName();
    }

    public RegionConfiguration getRegionConfiguration() {
        return _region.getConfiguration();
    }

    public String getRegionDisplayName() {
        return EsConstants.CQS_SYSTEM_NAME + getRegionName();
    }

    public boolean isLocal() {
        return _isLocal;
    }

    public boolean isRegionInFailoverMode() {
        return _region.inFailoverMode();
    }

    public String getRegionName() {
        return _region.getConfiguration().getRegionName();
    }

    protected final void mapSourceSystemError2ComposedErrors(RoutingDetailsTransaction transaction,
            EsRequestComplexType request) throws SifException {
        Collection cqsErrors = transaction.getSourceSystemErrors();
        ErrorMapper mapper = ErrorMapper.getInstance(cqsErrors, request, transaction.getRegionDisplayName());
        try {
            transaction.setMappedErrors(mapper.map());

        } catch (MappingException e) {
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Caught runtime exception "
                    + e.getMessage());
        }
    }

    
    /**
     * refer from CQSIntegration
     * 
     * @param sapFunctionName
     * @param transaction
     * @return
     * @throws SifException
     */
    protected final RoutingDetailsTransaction mapErrorTransaction2ComposedErrors(String sapFunctionName,
            ErrorTransaction transaction) throws SifException {
        RoutingDetailsTransaction rdt = new RoutingDetailsTransaction(_region.getConfiguration(), _region
                .inFailoverMode(), null, sapFunctionName, getRegionDisplayName(), _isLocal);

        Throwable t = transaction.getSourceSystemThrowable();
        ArrayList listErrors = new ArrayList();
        if (t instanceof SifException) {
            listErrors.add((SifException) t);
        } else {
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Unkown Exception class:"
                    + t.getClass().getName() + ", Message: " + t.getMessage());
        }

        rdt.setMappedErrors(listErrors);
        return rdt;
    }

    
    
    protected void mapCQSReply2EsReply(RoutingDetailsTransaction transaction, EsRequestComplexType request)
            throws SifException {
        ESLog.debug("Enter");
        RoutingDetailsMapper mapper = RoutingDetailsMapper.getInstance(transaction, request);
        try {
            ESLog.debug("Creating the reply structure");
            EsReply esReply = new EsReply();

            esReply.setEsHeader(new EsHeader());
            esReply.getEsHeader().setInputRequest(request);

            ESLog.debug("Warnings will be mapped");
            esReply.getEsHeader().setWarnings(mapWarnings(transaction));

            esReply.setEsReplyChoice(new EsReplyChoice());
            ESLog.debug("A RoutingDetailsComplexType will be mapped");
            esReply.getEsReplyChoice().setRoutingDetails(mapper.map());

            transaction.setMappedReply(esReply);
        } catch (MappingException e) {
            ESLog.info("Exception while mapping", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "");
        }

        ESLog.debug("Exit");
    }

    

    
    /*
     * Map warning
     */
    protected final Warnings mapWarnings(RoutingDetailsTransaction transaction) throws MappingException {

        WarningMapper mapper = WarningMapper.getInstance(transaction.getSourceSystemWarnings(), getRegionDisplayName());

        return mapper.map();
    }

}
