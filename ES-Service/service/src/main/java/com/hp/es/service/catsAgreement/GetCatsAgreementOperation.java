package com.hp.es.service.catsAgreement;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementOrchestration;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class GetCatsAgreementOperation extends EsOperation {

    /**
     * This operation will add CATS agreement information into the ES reply which passed in by
     * OperationContext.
     */
    public EsReply execute(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler) throws SifException {
        ESLog.debug("Enter");

        EsReply esReply = context.getEsReplyOfSwop();

        // First check whether or not needs to access ASTRO2.
        if (needToCallASTRO2(request, context)) {
            ESLog.debug("Calling ASTRO2 to get CATS agressment information.");
            // If needs to access ASTRO2, call ASTRO2 to get CATS agressment information
            Transaction transaction = null;
            try {
            transaction = CatsAgreementOrchestration.getInstance().getTransaction(request, context, metricsHandler);

            // After that, add the cats agreement into warrantyEntitlement
            mergeCatsAgreementIntoEsReply(context, transaction);
            }finally {
            	if(transaction!=null) {
            		transaction.destroy();
            	}
            }
        } else {
            if (request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeCATS() == true
                    && request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeWorkings() == true) {
                // If CATS is requested (includeCATS = true) then the workings are always returned.
                // This will help to identify what was happening with the call to ASTRO2.
                addAstro2Workings(esReply, getWorkingForA2Instance());
                WorkingComplexType working = new WorkingComplexType();
                working.setWorkingName("ASTRO2 Request Status");
                working.setWorkingValue("NotAccessed");
                addAstro2Workings(esReply, working);
            }
        }

        // Remove the Warning 420 solely based on the input flag IncludeCATS. This means
        // that we assume, that a customer who wants to retrieve CATS, would know that he
        // entered a consumer product.
        if (request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeCATS())
            filterWarning420(esReply);
        ESLog.debug("Exit");

        return esReply;
    }

    protected void verifyRequest(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
        // do nothing
    }

    protected void init() {
        // do nothing

    }

    /**
     * Check whether ES needs to call ASTRO2 to get CATS agreement information
     * 
     * @param request
     * @param esReply
     * @param warrantyTransaction
     * @return
     */
    private boolean needToCallASTRO2(EsRequestComplexType request, OperationContext context) {
    	
    	ESLog.debug("ASTRO2 has been retired.");
    	return false;
    	
    	//ASTRO2 has been retired.    	
    	/**
        ESLog.debug("Check whether ES needs to access ASTRO2 to retrieve CATS agreement information.");

        // 1. Operation:
        // ES will call ASTRO2 to retrieve CATS only when the operation is either getEntitlementBySn
        // or getWarrantyEntitlement.
        // The operation getEntitlementByPn and getEntitlementBySn are combine operations. They will
        // call the getWarrantyEntitlement to get warranty info.
        // For getEntitlementByPn, the includeCATS is set with false when ES map the request of
        // getEntitlementByPn to warrantyRequest, so that it will not call
        // ASTRO2. See GetEntitlementByPnOperation.createWarrantyRequest().

        // 2. SWOP Warranty: Check whether swop warranty is returned. If not, ES will NOT call
        // ASTRO2.

        if (context.getEsReplyOfSwop() == null || context.getEsReplyOfSwop().getEsReplyChoice() == null
                || context.getEsReplyOfSwop().getEsReplyChoice().getWarrantyEntitlement() == null
                || context.getEsReplyOfSwop().getEsReplyChoice().getWarrantyEntitlement().getWarrantyCount() <= 0) {
            ESLog.debug("The Warranty is NOT returned from SWOP. ES will NOT call ASTRO2.");
            return false;
        }
        // 3. includeCATS
        boolean includeCATS = request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeCATS();
        if (includeCATS == false) {
            ESLog.debug("In request, includeCATS=" + includeCATS + ". ES will NOT call ASTRO2.");
            return false;
        }

        // 4. Americas Country
        String countryCode = context.getSwopShipToCountry();
        if (countryCode == null) {
            ESLog.debug("ShipToCountry in swop warranty is not available. ES will use countryCode in request to call ASTRO2.");
            countryCode = request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd();
        }

        if (RegionFactory.getInstance().lookupAmericasCountries(countryCode) == null) {
            ESLog.debug("In request, Country Code is " + countryCode + " which is not in AmericasCountries. ES will NOT call ASTRO2.");
            return false;
        }

        // 5. SN:
        // Before calling CATS we must make sure, that we have a Serial number specified in
        // the request. If not, we will not call ASTRO2 to retrieve CATS information.
        String sn = request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber();
        if (sn == null || "".equals(sn.trim())) {
            ESLog.debug("SN is not specified in the request. ES will NOT call ASTRO2.");
            return false;
        }

        // 6. SupportLine
        boolean isSupportLineForCATS = false;

        ESLog.debug("Try to get production line from swop warranty transaction");

        if (context.getSupportLineFromSwop() == null || "".equals(context.getSupportLineFromSwop().trim()))
            isSupportLineForCATS = true;
        else {
            String supportLineInConfig = Configuration.getInstance().getProperties().getProperty(EsConstants.ES_WARRANTYINFO_SUPPORTLINE_CALLASTRO2);
            if (supportLineInConfig != null && supportLineInConfig.trim().length() >= 0) {
                Set supportLinesSet=new HashSet();
                String[] supportLinesInConfig = supportLineInConfig.split(",");
                // trim spaces between the values
                for (int i = 0; i < supportLinesInConfig.length; i++) {
                    supportLinesSet.add(supportLinesInConfig[i].trim());
                }
                isSupportLineForCATS = (supportLinesSet.contains(context.getSupportLineFromSwop().trim()));
            }
        }

        if (isSupportLineForCATS == false) {
            ESLog.debug("Warranty support line is not for CATS. ES will NOT call ASTRO2.");
            return false;
        }

        ESLog.debug("Need to Access ASTRO2");
        return true;
        */
    }

    /**
     * Merge Cats Agreement information into ES Reply
     * 
     * @param esReply
     * @param catsReply
     */
    private void mergeCatsAgreementIntoEsReply(OperationContext context, Transaction transaction) {
        ESLog.debug("Enter");
        EsReply esReply = context.getEsReplyOfSwop();
        if (esReply==null || esReply.getEsReplyChoice().getWarrantyEntitlement() == null) {
            ESLog.debug("SWOP Warranty is NULL, returns without merging CATS agreement.");
            return;
        }

        Collection mappedErrors = transaction.getMappedErrors();

        if (mappedErrors != null && mappedErrors.size() != 0) {
            ESLog.debug("Error merge: add the error returned from ASTRO2 as a warning to the final result.");
            // 1. Add the error returned from ASTRO2 as a warning to the final result.
            EIAError eiaError = null;
            Iterator iterator = mappedErrors.iterator();
            Object error = iterator.next();
            if (error instanceof SifException)
                eiaError = ErrorFactory.convertSifException((SifException) error);
            else
                eiaError = (EIAError) error;

            ESLog.debug("Error merge: eiaError in ASTRO2 reply:" + eiaError.getErrorID() + "," + eiaError.getErrorText());

            if (esReply.getEsHeader().getWarnings() == null)
                esReply.getEsHeader().setWarnings(new Warnings());

            esReply.getEsHeader().getWarnings().addEIAError(eiaError);
            ESLog.debug("Error merge: done!");
        } else {
            // 2. Merge Warranty+Warnings:
            // 2.1 Add Warranty returned from ASTRO2 to the final result
            EsReply mappedReply = transaction.getMappedReply();
            if (mappedReply != null && mappedReply.getEsReplyChoice() != null && mappedReply.getEsReplyChoice().getWarrantyEntitlement() != null) {
                WarrantyEntitlementComplexType catsWE = mappedReply.getEsReplyChoice().getWarrantyEntitlement();
                WarrantyComplexType catsWarranty[] = catsWE.getWarranty();
                if (catsWarranty != null && catsWarranty.length > 0) {
                    ESLog.debug("Merge Cats Agreement: starting");
                    WarrantyEntitlementComplexType swopWE = esReply.getEsReplyChoice().getWarrantyEntitlement();
                    swopWE.addWarranty(catsWarranty[0]);
                    // Add catsWE into context, so that we can use it later (duplicate check,
                    // calculate overall warranty entitlement startdate/enddate/status)
                    context.setCatsWarrantyEntitlement(catsWE);
                }

                ESLog.debug("Merge Cats Agreement: done");
            }

            // 2.2 Add warnings
            Warnings catsWarnings = transaction.getMappedReply().getEsHeader().getWarnings();
            if (catsWarnings != null && catsWarnings.getEIAErrorCount() > 0) {
                EIAError eiaError = catsWarnings.getEIAError(0);
                ESLog.debug("Merge ASTRO2 Warning: starting " + eiaError.getErrorID() + "," + eiaError.getErrorText());

                if (esReply.getEsHeader().getWarnings() == null)
                    esReply.getEsHeader().setWarnings(new Warnings());

                esReply.getEsHeader().getWarnings().addEIAError(catsWarnings.getEIAError(0));
                ESLog.debug("Merge ASTRO2 Warning: done");
            }

        }
        // 3. Merge Workings
        // working mapping must be done after transaction.setMappedReply(reply)
        if (esReply.getEsHeader().getInputRequest().getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeWorkings()) {
            addAstro2Workings(esReply, getWorkingForA2Instance());

            if (transaction instanceof CatsAgreementTransaction) {
                CatsAgreementTransaction catsTransaction = (CatsAgreementTransaction) transaction;
                WorkingComplexType working = new WorkingComplexType();
                working.setWorkingName("ASTRO2 Request Status");
                working.setWorkingValue(catsTransaction.getSourceSystemStatus());
                addAstro2Workings(esReply, working);
            } else if (transaction instanceof ErrorTransaction) {
                WorkingComplexType working = new WorkingComplexType();
                working.setWorkingName("ASTRO2 Request Status");
                working.setWorkingValue("SystemNotAvailable");
                addAstro2Workings(esReply, working);
            }
        }
        ESLog.debug("Exit");
    }

    private void addAstro2Workings(EsReply esReply, WorkingComplexType working) {
        if (esReply.getEsReplyChoice().getWarrantyEntitlement() != null) {
            if (esReply.getEsReplyChoice().getWarrantyEntitlement().getWorkingCount() == 0) {
                esReply.getEsReplyChoice().getWarrantyEntitlement().setWorking(new WorkingComplexType[] { working });
            } else {
                esReply.getEsReplyChoice().getWarrantyEntitlement().addWorking(working);
            }
        }
    }

    /**
     * Remove warning 420 from es reply. The warning 420 usually signals that the product is a
     * consumer product.
     * 
     * @param esReply
     */
    private void filterWarning420(EsReply esReply) {
        Warnings warnings = esReply.getEsHeader().getWarnings();
        if (warnings != null) {
            EIAError[] eiaErrors = warnings.getEIAError();
            if (eiaErrors != null) {
                for (int i = 0; i < eiaErrors.length; i++) {
                    EIAError eiaError = eiaErrors[i];
                    if (eiaError != null && "420".equals(eiaError.getErrorID())) {
                        ESLog.debug("The warning 420 is removed from the reply");
                        warnings.removeEIAError(eiaError);
                    }
                }
            }
           //Wade added to fix PM16451: service not available issue.
            if (warnings.getEIAError().length < 1){
            	esReply.getEsHeader().setWarnings(null);
            }
        }
    }

    private WorkingComplexType getWorkingForA2Instance() {
        WorkingComplexType a2InstanceWorking = new WorkingComplexType();
        a2InstanceWorking.setWorkingName("ASTRO2 Instance");
        DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
        try {
            ReadOnlyProperties prop = configFactory.getConfig(EsConstants.ES_PROPERTIES_FILENAME);
            a2InstanceWorking.setWorkingValue(prop.getProperty(EsConstants.ASTRO2_CALL_OPTION));
        } catch (IOException e) {
            ESLog.error("Failed to load the configuration for ASTRO2.", e);
        }
        return a2InstanceWorking;
    }


}
