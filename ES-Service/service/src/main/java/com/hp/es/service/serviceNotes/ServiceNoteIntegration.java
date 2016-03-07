package com.hp.es.service.serviceNotes;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ServiceNoteComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class ServiceNoteIntegration implements IntegrationInterface {

	private static ServiceNoteIntegration _instance = new ServiceNoteIntegration();
    /**
     * All time-consuming initializations should be done
     * here. <b>Note:</b> The same object will be used in parallel
     * by multiple threads. The access to other resources needs to be
     * synchronized if necessary.
     * 
     */
    protected void init() {
        // just to make sure that the database is initialized when the
        // first request comes in

    }

    private ServiceNoteIntegration() {
    	super();
    	//init();
    }
    
    public static ServiceNoteIntegration getInstance() {
    	return _instance;
    }
    
    
	public String getName() {
		return this.getClass().toString();
	}

	public RegionConfiguration getRegionConfiguration() {
		// there is no regionConfiguration for the ODS
		return null;
	}

	public boolean isRegionInFailoverMode() {
		//there is no failover mode for the ODS
		return false;
	}

	public String getRegionDisplayName() {
		return EsConstants.ODS_SYSTEM_NAME;
	}

	public Transaction execute(EsRequestComplexType request, MetricsHandler handler) throws SifException {

		WarrantyRequest wtyRequest = request.getEsRequestComplexTypeChoice().getWarrantyRequest();
		String productId = wtyRequest.getProductID();
		String serialNumber = wtyRequest.getSerialNumber();
		
		ServiceNoteComplexType[] sNotes =  null;
		
		ServiceNoteTransaction sTrans = new ServiceNoteTransaction(sNotes,getRegionDisplayName(),true);
		// in case something bad happens we prepare a place to store the exception in
		Collection<SifException> errorList = new ArrayList<SifException>();	
		try {
			sNotes = DbServiceNoteManager.getInstance().getServiceNotes(productId, serialNumber, handler);
			if (sNotes.length >0) {
				// wrap the result into an EsReply (leaving header empty)
				EsReply reply = new EsReply();
				reply.setEsReplyChoice(new EsReplyChoice());
				reply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
				reply.getEsReplyChoice().getWarrantyEntitlement().setServiceNote(sNotes);
				reply.setEsHeader(new EsHeader());
				reply.getEsHeader().setInputRequest(request);
				sTrans.setMappedReply(reply);		
			} else {
	            errorList.add( ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND,
	            	           "No service notes found in ODS."));
	            ESLog.debug("No service notes found in ODS.");
	            sTrans.setMappedErrors(errorList);
			}
			
		} catch (DataAccessException e) {
            // map to SifException
            ESLog.error("Unexpected Data access exception", e.getCause());
            errorList.add( ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
                           "Unknow database exception while processing ServiceNotes."));
            sTrans.setMappedErrors(errorList);
		} catch (SifException se) {
            errorList.add(se);
            sTrans.setMappedErrors(errorList);
		} catch (DatabaseDownException e) {
            ESLog.error("Unexpected DatabaseDownException", e.getCause());
            errorList.add( ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,EsConstants.ODS_SYSTEM_NAME));
            sTrans.setMappedErrors(errorList);
        } 
		
		return sTrans;
	}

	public boolean isLocal() {
		return true;
	}
}
