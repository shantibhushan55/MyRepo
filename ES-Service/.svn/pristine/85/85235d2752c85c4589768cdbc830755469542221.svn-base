package com.hp.es.service.serviceNotes;

import java.util.Collection;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;


public class GetServiceNotesPseudoOperation extends EsOperation {

	protected void verifyRequest(EsRequestComplexType request,
			MetricsHandler metricsHandler) throws SifException {
	    WarrantyRequest wr =
            request.getEsRequestComplexTypeChoice().getWarrantyRequest();
        if (wr == null) {
            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST, "The GetServiceNotes operation requires a Warranty request.");
        }
        checkMandatoryParameter(wr.getProductID(), "ProductID()",
                                "The parameter ProductID is missing in GetServiceNotesPseudoOperation");
        int maxLength=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
        ProductNumberValidator.verifyProductNumberGreaterThan(wr.getProductID(), maxLength);
	}

	protected EsReply execute(EsRequestComplexType request, OperationContext context,
			MetricsHandler metricsHandler) throws SifException {
        String methodId = "GetServiceNotesPseudoOperation.execute()";
        MetricsEntry overallTime = null;
        if (metricsHandler != null) overallTime = metricsHandler.startEntry(methodId);

        EsReply esReply = null;
    	ServiceNoteIntegration integ = ServiceNoteIntegration.getInstance();
    	ServiceNoteTransaction trans = null;
        try {
        	trans = (ServiceNoteTransaction) integ.execute(request, metricsHandler);
        	if (trans.isSourceSystemError()) {
        		Collection errorList = trans.getMappedErrors();
        		throw (SifException)errorList.iterator().next();
        	}
        	esReply = trans.getMappedReply();
        }
        finally {
    		if(trans != null)
    			trans.destroy();
    		
    		trans= null;
            if (overallTime != null) overallTime.actionDone();
        }
        return esReply;
	}

	protected void init() {
		// nothing to do
	}



}
