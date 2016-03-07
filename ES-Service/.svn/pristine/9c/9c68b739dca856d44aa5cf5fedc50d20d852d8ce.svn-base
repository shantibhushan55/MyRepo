package com.hp.es.service.catsAgreement.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTDETAILV3S;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTWEBSERVICEV3S;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WSResponse;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.Warnings;

/**
 * 
 * @author Chunyang Wang
 * 
 */
public class CatsAgreementTransaction extends Transaction {

    private String _sourceSystemStatus = null;
    private  static List<String> _errorList = new ArrayList<String>();
    private static List<String> _warningList = new ArrayList<String>();
    static {
        _errorList.add("2503");
        _errorList.add("2507");
        _errorList.add("2508");
        _errorList.add("2509");
        _errorList.add("2510");
        _errorList.add("2502");
        _errorList.add("2504");
        _errorList.add("2505");
        _errorList.add("2506");
        _errorList.add("0011");

        _warningList.add("5019");
        _warningList.add("5007");
        _warningList.add("5014");
        _warningList.add("5015");
        _warningList.add("5020");
        _warningList.add("5016");
        _warningList.add("5018");
        _warningList.add("5021");
        _warningList.add("5012");
        _warningList.add("5006");
        _warningList.add("5004");
        _warningList.add("5001");
        _warningList.add("5003");
        _warningList.add("5002");
        _warningList.add("5005");
        _warningList.add("5008");
        _warningList.add("5009");
        _warningList.add("5013");
        _warningList.add("5017");
        _warningList.add("5010");
        _warningList.add("5011");
        _warningList.add("6001");
        _warningList.add("6002");
        _warningList.add("6003");

    }

    /**
     * @param config
     * @param failoverMode
     * @param sourceReply
     * @param functionName
     */

    public CatsAgreementTransaction(RegionConfiguration config, boolean failoverMode, Object sourceReply, String functionName,
            String displayName, boolean isLocal) {
        super(config, failoverMode, sourceReply, functionName, displayName, isLocal);
    }

    /**
     * Get Source system status.
     * 
     * !!!This method must be invoked after reply and error mapping!!!
     */
    public String getSourceSystemStatus() {
        ESLog.debug("Enter");
        if (_sourceSystemStatus != null)
            return _sourceSystemStatus;
        EIAError eiaError = null;
        // try to get eiaError from mapped errors
        if (getMappedErrors() != null) {
            Iterator<?> iterator = getMappedErrors().iterator();
            if (iterator.hasNext())
                eiaError = (EIAError) iterator.next();
        }

        if (eiaError == null) {
            // try to get eiaError from warnings if mapped error is null
            if (getMappedReply() != null && getMappedReply().getEsHeader() != null) {
                Warnings warnings = getMappedReply().getEsHeader().getWarnings();
                if (warnings != null && warnings.getEIAErrorCount() > 0)
                    eiaError = warnings.getEIAError(0);
            }
        }

        // check eiaError mapped from astro2 error or warning
        if (eiaError != null) {
            String esErrorCode = eiaError.getErrorID();
            if (esErrorCode != null && esErrorCode.trim().length() != 0) {
                if (esErrorCode.equals("300"))
                    return "NoEntryFound";
                if (esErrorCode.equals("434"))
                    return "SystemNotAvailable";
                else
                    return "Error";
            }
        }
        return "Successful";

    }

    /**
     * Currenty this method is not used in ASTRO2 transaction. The from ASTRO2 can be get from getEntitlementHeader().getErrorCode().
     */
    public Collection<?> getSourceSystemErrors() {
        return null;
    }

    public Object getSourceSystemStandardReply() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if (reply.getSoapCastorReply() instanceof ZA2FMAESGETENTV3WSResponse) {
            ZA2FMAESGETENTV3WSResponse out = (ZA2FMAESGETENTV3WSResponse) reply.getSoapCastorReply();
            return out;
        }

        return null;
    }

    public Object getSourceSystemUnitList() {
        return null;
    }

    /**
     * Currenty this method is not used in ASTRO2 transaction. The error from ASTRO2 can be get from getEntitlementHeader().getErrorCode().
     */
    public Collection<?> getSourceSystemWarnings() {
        return null;
    }

    public boolean isSourceSystemError() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if (reply.getSoapCastorReply() instanceof ZA2FMAESGETENTV3WSResponse) {
            ZA2FMAESGETENTV3WSResponse out = (ZA2FMAESGETENTV3WSResponse) reply.getSoapCastorReply();
            String errorCode = out.getENTITLEMENT().getENTITLEMENTHEADER().getERRORCODE();
            return isError(errorCode);
        }
        return true;
    }

    public boolean isSourceSystemStandardReply() {
        return !isSourceSystemError();
    }

    public boolean isSourceSystemWarnings() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();

        if (reply.getSoapCastorReply() instanceof ZA2FMAESGETENTV3WSResponse) {
            ZA2FMAESGETENTV3WSResponse out = (ZA2FMAESGETENTV3WSResponse) reply.getSoapCastorReply();
            return isWarning(out.getENTITLEMENT().getENTITLEMENTHEADER().getERRORCODE());
        }

        return false;
    }

    private boolean isError(String errorCode) {
        return _errorList.contains(errorCode);
    }

    private boolean isWarning(String errorCode) {
        return _warningList.contains(errorCode);
    }

    public boolean isSourceSystemUnitList() {
        return false;
    }

    /**
     * This is a convenient method to get the ENTITLEMENT_HEADER from ASTRO2 reply.
     * 
     * @return ENTITLEMENT_HEADER
     */
    public Object getEntitlementHeader() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if (reply.getSoapCastorReply() instanceof ZA2FMAESGETENTV3WSResponse) {
            ZA2FMAESGETENTV3WSResponse out = (ZA2FMAESGETENTV3WSResponse) reply.getSoapCastorReply();
            return out.getENTITLEMENT().getENTITLEMENTHEADER();
        }
        return null;
    }

    /**
     * Only once for CATS
     * 
     * @return the first ENTITLEMENT_SUMMARY
     */
    public Object getFirstEntSummary() {
    	if (getSourceSystemStandardReply() instanceof ZA2FMAESGETENTV3WSResponse) {
            ZA2AESENTWEBSERVICEV3S a2Ent = ((ZA2FMAESGETENTV3WSResponse) (getSourceSystemStandardReply())).getENTITLEMENT();
            if (a2Ent != null && a2Ent.getENTITLEMENTSUMMARY().getItem().size() > 0)
                return a2Ent.getENTITLEMENTSUMMARY().getItem().get(0);
        }
        return null;
    }

    /**
     * Only once for CATS
     * 
     * @return the first ENTITLEMENT_DETAIL
     */
    public Object getFirstEntDetail() {
    	if (getSourceSystemStandardReply() instanceof ZA2FMAESGETENTV3WSResponse) {
            ZA2AESENTWEBSERVICEV3S a2Ent = ((ZA2FMAESGETENTV3WSResponse) (getSourceSystemStandardReply())).getENTITLEMENT();
            if (a2Ent != null && a2Ent.getENTITLEMENTDETAIL().getItem().size() > 0) {
                return a2Ent.getENTITLEMENTDETAIL().getItem().get(0);
            }
        }
        return null;
    }

    /**
     * CATS has a rule that there is only one OFFER. This could change in the future--but it is not likely.
     * 
     * @return the first OFFER
     */
    public Object getFirstOffer() {
        if (getFirstEntDetail() == null)
            return null;

        if (getFirstEntDetail() instanceof ZA2AESENTDETAILV3S) {
            if (((ZA2AESENTDETAILV3S) getFirstEntDetail()).getOFFERS().getItem().size() > 0)
                return ((ZA2AESENTDETAILV3S) getFirstEntDetail()).getOFFERS().getItem().get(0);

        }
        return null;
    }

	@Override
	public void destroy() {
		super.destroy();
		_sourceSystemStatus= null;
		
	}


}
