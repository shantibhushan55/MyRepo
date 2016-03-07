/**
 * 
 */
package com.hp.es.service.ibSearch.orchestration;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWARRANTYWILDCARDSEARCHResponse;


/**
 * @author ANVOI
 * 
 */
public class IBSearchTransaction extends Transaction {

    /**
     * @param config
     * @param failoverMode
     * @param sourceReply
     * @param functionName
     */
    public IBSearchTransaction(RegionConfiguration config, boolean failoverMode, Object sourceReply, String functionName,
            String displayName, boolean isLocal) {
        super(config, failoverMode, sourceReply, functionName, displayName, isLocal);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemUnitList()
     */
    public boolean isSourceSystemUnitList() {
        ESLog.debug("Checking for SourceSystemUnitList");

            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYWILDCARDSEARCHResponse out = (ZWARRANTYWILDCARDSEARCHResponse) reply.getSoapCastorReply();
            boolean hasList = false;
            if (out.getZPRODUCTLIST() != null && out.getZPRODUCTLIST().getPRODLIST() != null
                    && out.getZPRODUCTLIST().getPRODLIST().getItem() != null) {
                hasList = (out.getZPRODUCTLIST().getPRODLIST().getItem().size() > 0);
            }
            return hasList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemUnitList()
     */
    public Collection getSourceSystemUnitList() {
        ESLog.debug("Getting for SourceSystemUnitList");
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYWILDCARDSEARCHResponse out = (ZWARRANTYWILDCARDSEARCHResponse) reply.getSoapCastorReply();
            return out.getZPRODUCTLIST().getPRODLIST().getItem();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemStandardReply()
     */
    public boolean isSourceSystemStandardReply() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemStandardReply()
     */
    public Object getSourceSystemStandardReply() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemError()
     */
    public boolean isSourceSystemError() {
        ESLog.debug("Checking for SourceSystemError");
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYWILDCARDSEARCHResponse out = (ZWARRANTYWILDCARDSEARCHResponse) reply.getSoapCastorReply();
            if (out.getZPRODUCTLIST() != null && out.getZPRODUCTLIST().getPRODLIST() != null
                    && out.getZPRODUCTLIST().getPRODLIST().getItem() != null) {
                if (out.getZPRODUCTLIST().getPRODLIST().getItem().size() > 0) {
                    return false;
                }
            }
            // at this point we don't have a product list, if we now have message list,
            // then we have a errors
            if (out.getZPRODUCTLIST() != null && out.getZPRODUCTLIST().getWTYMESSAGE() != null
                    && out.getZPRODUCTLIST().getWTYMESSAGE().getItem() != null) {
                if (out.getZPRODUCTLIST().getWTYMESSAGE().getItem().size() > 0) {
                    return true;
                }
            }
            // at this point both is empty, so we return false
            return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemError()
     */
    public Collection getSourceSystemErrors() {
        ESLog.debug("Getting for SourceSystemError");
        if (isSourceSystemError()) {
                SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
                ZWARRANTYWILDCARDSEARCHResponse out = (ZWARRANTYWILDCARDSEARCHResponse) reply.getSoapCastorReply();
                return out.getZPRODUCTLIST().getWTYMESSAGE().getItem();

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
        ESLog.debug("Checking for SourceSystemWarnings");

            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYWILDCARDSEARCHResponse out = (ZWARRANTYWILDCARDSEARCHResponse) reply.getSoapCastorReply();
            // if we have a product list and a message list then we have warnings
            if (out.getZPRODUCTLIST() != null && out.getZPRODUCTLIST().getPRODLIST() != null
                    && out.getZPRODUCTLIST().getPRODLIST().getItem() != null) {
                if (out.getZPRODUCTLIST().getPRODLIST().getItem().size() > 0) {
                    if (out.getZPRODUCTLIST().getWTYMESSAGE() != null && out.getZPRODUCTLIST().getWTYMESSAGE() != null) {
                        if (out.getZPRODUCTLIST().getWTYMESSAGE().getItem().size() > 0) {
                            return true;
                        }
                    }
                }
            }
            // at this point we either have no warnings or we have a errors
            // so we return false
            return false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemWarnings()
     */
    public Collection getSourceSystemWarnings() {
        if (isSourceSystemWarnings()) {
                SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
                ZWARRANTYWILDCARDSEARCHResponse out = (ZWARRANTYWILDCARDSEARCHResponse) reply.getSoapCastorReply();
                return out.getZPRODUCTLIST().getWTYMESSAGE().getItem();
        } else {
            return new ArrayList();
        }
    }

	@Override
	public void destroy() {
		
		super.destroy();
	}

}
