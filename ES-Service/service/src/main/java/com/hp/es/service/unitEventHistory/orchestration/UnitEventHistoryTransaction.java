/**
 * 
 */
package com.hp.es.service.unitEventHistory.orchestration;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWARRANTYEVENTHISTORYResponse;
import com.hp.es.service.util.ESLog;

/**
 * @author ANVOI
 * 
 */
public class UnitEventHistoryTransaction extends Transaction {

    /**
     * @param config
     * @param failoverMode
     * @param sourceReply
     * @param functionName
     */
    public UnitEventHistoryTransaction(RegionConfiguration config, boolean failoverMode, Object sourceReply, String functionName,
            String displayName, boolean isLocal) {
        super(config, failoverMode, sourceReply, functionName, displayName, isLocal);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemUnitList()
     */
    public boolean isSourceSystemUnitList() {
    	throw new RuntimeException("Not supported");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemUnitList()
     */
    public Collection getSourceSystemUnitList() {
    	throw new RuntimeException("Not supported");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemStandardReply()
     */
    public boolean isSourceSystemStandardReply() {
    	throw new RuntimeException("Not supported");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemStandardReply()
     */
    public Object getSourceSystemStandardReply() {
        ESLog.debug("Getting for SourceSystemStandardReply");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        
        ZWARRANTYEVENTHISTORYResponse out = (ZWARRANTYEVENTHISTORYResponse) reply.getSoapCastorReply();
        
        return out.getEVENTHISTORY();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemError()
     */
    public boolean isSourceSystemError() {
        ESLog.debug("Checking for SourceSystemError");
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYEVENTHISTORYResponse out = (ZWARRANTYEVENTHISTORYResponse) reply.getSoapCastorReply();
            /*
             * If we have a valid reply with at least a PN and SN and no WTY message
             */
            if (out.getEVENTHISTORY() != null && out.getEVENTHISTORY().getPRODUCTNUMOUT()!= null
                    && out.getEVENTHISTORY().getSERIALNUMOUT()!= null && out.getEVENTHISTORY().getUNITEVENT() != null && out.getEVENTHISTORY().getUNITEVENT().getItem() != null && !out.getEVENTHISTORY().getUNITEVENT().getItem().isEmpty()) {
                    return false;
            }
            return true;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemError()
     */
    public Collection getSourceSystemErrors() {
        ESLog.debug("Getting for SourceSystemError");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYEVENTHISTORYResponse out = (ZWARRANTYEVENTHISTORYResponse) reply.getSoapCastorReply();
        
        if (isSourceSystemError() 
        		&&  out.getEVENTHISTORY().getWTYMESSAGE() != null  
        		&&  out.getEVENTHISTORY().getWTYMESSAGE().getItem() != null) {
        	
                return out.getEVENTHISTORY().getWTYMESSAGE().getItem();
        } else {
            return new ArrayList();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemWarnings()
     */
    public boolean isSourceSystemWarnings() {
        ESLog.debug("Checking for SourceSystemWarnings, no warning for Unit Event history");
        return false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemWarnings()
     */
    public Collection getSourceSystemWarnings() {
    		ESLog.debug("No warning for Unit Event history");
            return new ArrayList();
    }

	@Override
	public void destroy() {
		super.destroy();
	}

}
