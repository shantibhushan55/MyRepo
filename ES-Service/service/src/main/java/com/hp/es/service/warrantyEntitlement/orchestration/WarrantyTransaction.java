/*
 * Created on Mar 8, 2006
 */
package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSUResponse;

/**
 * @author juhank
 */
public class WarrantyTransaction extends Transaction {

    // The source system reply cannot be uniquely identified. Therefore on the WarrantyTransaction,
    // we introduce a flag to indicate whether this tranaction is chosen as the final es reply.
    // 
    // This flag should be set in after the final SWOP reply was chosen.
    // com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode.getHighestPriority(ArrayList)
    // com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransactionComposition.getLocalReply(ArrayList)

    // This flag would then be used in
    // com.hp.es.service.warrantyEntitlement.orchestration.WarrantyOrchestration.getCatsAgreement(EsRequestComplexType,
    // EsReply, ArrayList, MetricsHandler)
    // to decide, from which transaction the support product line should be retrieved and checked.

    private boolean _esReplyChoice = false;

    /**
     * @param config
     * @param failoverMode
     * @param sourceReply
     * @param functionName
     */
    public WarrantyTransaction(RegionConfiguration config, boolean failoverMode, Object sourceReply, String functionName,
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
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        if (out.getZWTYLOOKUP().getPRODLIST() != null) {
            if (out.getZWTYLOOKUP().getPRODLIST().getItem().size() > 1) {
                return true;
            }
        }
        return false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemUnitList()
     */
    public Object getSourceSystemUnitList() {
        ESLog.debug("Getting for SourceSystemUnitList");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        return out.getZWTYLOOKUP().getPRODLIST();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemStandardReply()
     */
    public boolean isSourceSystemStandardReply() {
        ESLog.debug("Checking for SourceSystemStandardReply");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        return (out.getZWTYLOOKUP()!=null && out.getZWTYLOOKUP().getWTYENTITLEMENT() != null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemStandardReply()
     */
    public Object getSourceSystemStandardReply() {

        ESLog.debug("Getting for SourceSystemStandardReply");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        return out.getZWTYLOOKUP().getWTYENTITLEMENT();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemError()
     */
    public boolean isSourceSystemError() {
        ESLog.debug("Checking for SourceSystemError");
        ESLog.debug("SOAP_SAPACCESS_METRO isSourceSystemError CHECK");

           SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        
  
            // if we have a message list at this point, we have errors
        if (out.getZWTYLOOKUP()!=null && out.getZWTYLOOKUP().getWTYMESSAGE() != null) {
            ESLog.debug("SOAP_SAPACCESS_METRO out.getZWTYLOOKUP()!=null && out.getZWTYLOOKUP().getWTYMESSAGE() != null::TRUE");
            ESLog.debug("SOAP_SAPACCESS_METRO out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size()="+out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size());

                if (out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size() > 0) {
  
                    // we need to go through all wty messages, since we can get errors and warnings
                List<com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR> msgList = out.getZWTYLOOKUP().getWTYMESSAGE().getItem();
                if(msgList != null) {
                    Iterator it= msgList.iterator();
                    while(it.hasNext()) {
                    	Object tmp = it.next();
                    	if (tmp instanceof com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR) {
                    		com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR error = (com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR) tmp; 
	                    	
	                        ESLog.debug("SOAP_SAPACCESS_METRO::: error.getID() returned::ID="+error.getID());
	                        ESLog.debug("SOAP_SAPACCESS_METRO::: error.getID() returned::MSG="+error.getMESSAGE());
	
	                    	// if the ID starts doesn't start with a 0 or 1, it is an error
	                        // all warnings start with a 1 and 0000 is the successful message
	                        if (!error.getID().startsWith("1") && !error.getID().startsWith("0")  && !error.getID().startsWith("3")) {
	                            return true;
	                        }
                    	}else {
                    		//we have a classcast exception, this is a major erro
                    		ESLog.error("Object is not of right type: " + tmp.toString() +" ;"+tmp.getClass().getPackage()+tmp.getClass().getName());
                    		return true;
                    	}
                    }
                }
            }
        }
        /*
         * We also need to check if we are not in the case of an empty reply
         */
        if (isSwopEmptyReply()) {
            ESLog.debug("SWOP returned an empty reply, this need to be mapped to a no data found error.");
            return true;
        }

        // at this point, we just return false
        return false;



    }

    /**
     * check if the SWOP reply is empty
     * 
     * @return
     */
    public boolean isSwopEmptyReply() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();

        // check if 1 of the higher levels are already empty
        if (out == null || out.getZWTYLOOKUP()==null) {
            return true;
        }

        // check if productlist or wtyentitlement is empty
        if (out.getZWTYLOOKUP().getPRODLIST() == null && out.getZWTYLOOKUP().getWTYENTITLEMENT() == null) {
            return true;
        }

        // check if we have wtymessage
        if (out.getZWTYLOOKUP().getWTYMESSAGE() == null) {
            return true;
        }

        // if we have no message at all, the reply is empty
        if (out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size() == 0) {
            return true;
        }

        // SWOP reply is NOT empty
        return false;


    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemError()
     */
    public Collection getSourceSystemErrors() {
        ESLog.debug("Getting for SourceSystemError");

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out =(ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        if (isSourceSystemError()) {
            return out.getZWTYLOOKUP().getWTYMESSAGE().getItem();
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
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        // check if we have a warranty entitlement and messages
        if (out.getZWTYLOOKUP()!=null && out.getZWTYLOOKUP().getWTYENTITLEMENT() != null && out.getZWTYLOOKUP().getWTYMESSAGE() != null) {
            if (out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size() > 0) {
                return containsWarnings(out.getZWTYLOOKUP());
            }
        }

        // check if we have a product list and messages
        if (out.getZWTYLOOKUP()!=null && out.getZWTYLOOKUP().getPRODLIST() != null && out.getZWTYLOOKUP().getWTYMESSAGE() != null) {
            if (out.getZWTYLOOKUP().getPRODLIST().getItem().size() > 0) {
                if (out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size() > 0) {
                    return containsWarnings(out.getZWTYLOOKUP());
                }
            }
        }

        // at this point we checked the valid combination for warning, so if we are
        // here we don't have warnings
        return false;


    }

    /**
     * checks if a warning is available
     * 
     * @param out
     * @return
    private boolean containsWarnings(OutputZ_warranty_lookup_parallel_bsu out) {
        // go through all errors
        Iterator iterator = out.getZWTYLOOKUP().getWTYMESSAGE().iterator();
        if (iterator.hasNext()) {
            Zwtyerrortab error = (Zwtyerrortab) iterator.next();
            // if the ID starts doesn't start with a 0 or 2, it is a warning
            // all errors start with a 2 and 0000 is the successful message
            if (!error.getID().startsWith("2") && !error.getID().startsWith("0")) {
                return true;
            }
        }
        return false;
    }
     */

    /**
     * checks if a warning is available
     * 
     * @param out
     * @return
    private boolean containsWarnings(ZWTYLOOKUP out) {
        // go through all errors
        Enumeration msgList = out.getWTYMESSAGE().enumerateItem();
        if (msgList.hasMoreElements()) {
            ZWTYERROR error = (ZWTYERROR) msgList.nextElement();
            // if the ID starts doesn't start with a 0 or 2, it is a warning
            // all errors start with a 2 and 0000 is the successful message
            if (!error.getID().startsWith("2") && !error.getID().startsWith("0")) {
                return true;
            }
        }
        return false;
    }
     */

    /**
     * checks if a warning is available
     * 
     * @param out
     * @return
     */
    private boolean containsWarnings(
            com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYLOOKUP out) {
        // go through all errors
        List<com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR> msgList = out
                .getWTYMESSAGE().getItem();
        for (com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR error : msgList) {
            // if the ID starts doesn't start with a 0 or 2, it is a warning
            // all errors start with a 2 and 0000 is the successful message
            if (!error.getID().startsWith("2") && !error.getID().startsWith("0")) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemWarnings()
     */
    public Collection getSourceSystemWarnings() {
        ESLog.debug("Getting for SourceSystemWarnings");

            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
            if (isSourceSystemWarnings()) {
                return out.getZWTYLOOKUP().getWTYMESSAGE().getItem();
            } else {
                return new ArrayList();
            }
    }

    /**
     * isSwopWarningMessageReturned checks whether the defined warning id is included in the SWOP reply
     * 
     * @param warningIdToCheck
     * @return
     */
    public boolean isSwopWarningMessageReturned(int warningIdToCheck) {
        ESLog.debug("Checking for warning id " + warningIdToCheck);
        // check if we have warnings at all
        Collection warnings = getSourceSystemWarnings();
        if (warnings.size() == 0) {
            ESLog.debug("No warnings at all in the reply");
            return false;
        }
        // go trough all the warnings
        Iterator iterator = warnings.iterator();
        while (iterator.hasNext()) {
            com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR warning = (com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR) iterator
                    .next();
            int swopWarningId = 0;
            try {
                swopWarningId = Integer.parseInt(warning.getID());
            } catch (NumberFormatException nfe) {
                ESLog.error("A number format Exception occurred with received ID: " + warning.getID() + ". This ID will be ignored.");
                swopWarningId = 0;
            }
            if (swopWarningId == warningIdToCheck) {
                ESLog.debug("Found warning id " + warningIdToCheck);
                return true;
            }
        }
        // if we are here we don't have the warning id
        ESLog.debug("Warning id " + warningIdToCheck + " not availabe in the reply");
        return false;
    }

    /**
     * getSwopSystemStatus checks the system status of SWOP depending on the retrieved errors and warnings from SWOP
     * 
     * @return status message
     */
    public String getSwopSystemStatus() {
        ESLog.debug("Checking the SWOP system status");
        // check if everything was ok
        if (isSourceSystemUnitList() || isSourceSystemStandardReply()) {
            ESLog.debug("SWOP Status: " + EsConstants.SWOP_STATUS_SUCCESSFULL);
            return EsConstants.SWOP_STATUS_SUCCESSFULL;
        }

        // check for error 224 and other SWOP exception
        if (isUnavailable()) {
            ESLog.debug("SWOP Status: " + EsConstants.SWOP_STATUS_SYSTEM_NOT_AVAILABLE);
            return EsConstants.SWOP_STATUS_SYSTEM_NOT_AVAILABLE;
        }

        // check for error id 202 (SWOP error 2010 or 2008 or 2017)
        if (isSwopWarningMessageReturned(2010) || isSwopWarningMessageReturned(2008) || isSwopWarningMessageReturned(2017)) {
            ESLog.debug("SWOP Status: " + EsConstants.SWOP_STATUS_NO_ENTRY_FOUND);
            return EsConstants.SWOP_STATUS_NO_ENTRY_FOUND;
        }

        // check for error < 224
        // if no nothing above matched than we will return an error
        ESLog.debug("SWOP Status: " + EsConstants.SWOP_STATUS_ERROR);
        return EsConstants.SWOP_STATUS_ERROR;
    }

    /**
     * checks if the we have at least the successfull message from SWOP
     * 
     * @return
     */
    public boolean isSuccessfull() {
        ESLog.debug("Checking if the SWOP returned a successful message");

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        // check if we have a warranty entitlement and messages
        if (out.getZWTYLOOKUP().getWTYMESSAGE() != null) {
            if (out.getZWTYLOOKUP().getWTYMESSAGE().getItem().size() == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * getSUPPORTPRODUCTLINE
     * 
     * @return
     */
    public String getProductLine() {
        ESLog.debug("getSUPPORTPRODUCTLINE()");

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ZWARRANTYLOOKUPPARALLELBSUResponse out = (ZWARRANTYLOOKUPPARALLELBSUResponse) reply.getSoapCastorReply();
        if (out.getZWTYLOOKUP() != null && out.getZWTYLOOKUP().getWTYENTITLEMENT() != null && 
                out.getZWTYLOOKUP().getWTYENTITLEMENT().getWARRANTYINFO() != null)
            return out.getZWTYLOOKUP().getWTYENTITLEMENT().getWARRANTYINFO().getSUPPORTPRODUCTLINE();

        return null;
    }

    public boolean isEsReplyChoice() {
        return _esReplyChoice;
    }

    public void setEsReplyChoice(boolean replyChoice) {
        _esReplyChoice = replyChoice;
    }

	@Override
	public void destroy() {
		super.destroy();
		
	}
}
