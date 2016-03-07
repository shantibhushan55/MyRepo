/*
 * Created on Mar 21, 2006
 */
package com.hp.es.service.combinedEntitlement.requester;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.SerialNumberValidator;
import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.contractEntitlement.orchestration.ContractBySnReply;
import com.hp.es.service.contractEntitlement.orchestration.ContractOrchestration;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 */
public class ContractBySnRequester {

	ContractOrchestration _cOrchestration;
	
    public ContractBySnRequester() {
    	_cOrchestration = ContractOrchestration.getInstance();
    }

    // call the ContractBySN operation
    public RequesterReply execute(EsRequestComplexType request, MetricsHandler metrics) {

        ESLog.debug("Enter");
        RequesterReply rReply = null;
        ContractBySnReply snReply = null;
        try {
            validateSerialNumber(request);
        	// In this case we are using the direct access to the orchestration 
        	// layer of the contract entitlement, because the ContractBySN
        	// operation is not public
            ESLog.debug("Calling non public ContractBySN operation");                                                        
            snReply = _cOrchestration.getContractEntitlementBySerialNumberForOrchestration(request, metrics);
            ESLog.info("EdReply from snReply=" + snReply.getEsReply());
            ESLog.info("MappedProductList from =snReply" + snReply.getMappedProductList());
            ESLog.info("EsReplyContext from snReply=" + snReply.getEsReplyContext());
            // setting the reply
            ESLog.debug("Setting the reply");                                                        
        	rReply = new RequesterReply(snReply.getEsReply(), snReply.getMappedProductList(),snReply.getEsReplyContext());
        } catch(SifException ee) {
            ESLog.debug("Caught SIF exception "+ee.getMessage());                                                        
            //ESLog.log(ee);
            rReply = new RequesterReply(ee);
        } catch (Exception e) {
            ESLog.info("Caught an unknown exception",e);  
 
            
            SifException ex = ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,"Unknown internal error in Contract by sn request, message:"+ e.getMessage());
            rReply = new RequesterReply(ex);
        }

        ESLog.debug("Exit");
        return rReply;
    }

    private void validateSerialNumber(EsRequestComplexType request) throws SifException {
        if(request!=null && request.getEsRequestComplexTypeChoice()!=null && request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest()!=null){
            String serialNumber=request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber();
            if(serialNumber!=null){
                int maxLength=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_SN_MAXLENGTH);
                SerialNumberValidator.verifySerialNumberGreaterThan(serialNumber, maxLength);            
            }
        }
    }	
   
}
