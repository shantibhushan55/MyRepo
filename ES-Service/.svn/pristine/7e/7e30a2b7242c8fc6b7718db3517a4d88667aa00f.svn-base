package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.OrchestrationWorker;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.warrantyEntitlement.integration.MultipleInstanceIntegration;
import com.hp.es.service.warrantyEntitlement.integration.SingleInstanceIntegration;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class WarrantyOrchestration extends SourceSystemsOrchestration implements ConfigChangeListener {

    /*
     * Singleton
     */
    protected final static WarrantyOrchestration _instance = new WarrantyOrchestration();

    /*
     * Default Constructor. It will do initializatiuon at the same time
     */
    private WarrantyOrchestration() {
        super();
        Configuration.getInstance().addConfigChangeListener(this);
    }

    /*
     * Instance Method
     */
    public static WarrantyOrchestration getInstance() {
        return _instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#init()
     */
    protected int init() {
        // nothing to do anymore after changing to country of service
        return 0;
    }

    /*
     * receiveFromSingleInstance is used for sending the request to a single instance for product /
     * spare part calculation @param request @param metricsHandler
     */
    protected Transaction receiveFromSingleInstance(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
        Transaction reply = null;
        ESLog.debug("Starting single instance access");

        // create a single integration object for product / spare part calculatiopn
        SingleInstanceIntegration singleInstanceIntegration = new SingleInstanceIntegration(request.getEsRequestComplexTypeChoice()
                .getWarrantyRequest().getIsoCountryCd());

        // start threads for the received access objects w/ timeout
        OrchestrationWorker integrationLayerThread = new OrchestrationWorker(request, singleInstanceIntegration, metricsHandler);
        ESLog.debug("Starting 1 thread");
        try {
            reply = startOneThreadAndWaitForReply(integrationLayerThread);
        } finally {
            integrationLayerThread = null;
        }

        return reply;
    }

    /*
     * receiveFromMultipleInstances is used for sending the request to a all instances for unit
     * warranty and product / spare part calculation @param request @param metricsHandler
     */
    protected ArrayList receiveFromMultipleInstances(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler) throws SifException {
        ArrayList replies = null;
        // access objects from factory
        ESLog.debug("Starting multiple instance access");
        ArrayList threadList = new ArrayList();
        ArrayList listOfRegionName = RegionFactory.getInstance().getAvailableRegionsName();
        ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply = null;
        SifException manufacturingInstalledBaseServiceSE = null;
        
        
        if(context != null) {
	        if (context.getManufacturingInstalledBaseServicEsReply() != null 
	        		&& context.getManufacturingInstalledBaseServicEsReply().getEsReplyChoice() != null 
	        		&& context.getManufacturingInstalledBaseServicEsReply().getEsReplyChoice().getManufacturingInstalledBaseHeader() != null) {
	        	 manufacturingInstalledBaseServiceReply = context.getManufacturingInstalledBaseServicEsReply().getEsReplyChoice().getManufacturingInstalledBaseHeader();
	        }

        	manufacturingInstalledBaseServiceSE = context.getManufacturingInstalledBaseServiceSifException();
        }

        // We need to create the integration layers.
        for (int i = 0; i < listOfRegionName.size(); i++) {
            String regionName = (String) listOfRegionName.get(i);
            MultipleInstanceIntegration currentUnitWarrantyIntegrationObject = new MultipleInstanceIntegration(regionName, request
                    .getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd(), manufacturingInstalledBaseServiceReply,manufacturingInstalledBaseServiceSE);
            ESLog.debug("Prepraring thread for region: " + currentUnitWarrantyIntegrationObject.getRegionName());
            Thread integrationLayerThread = new OrchestrationWorker(request, currentUnitWarrantyIntegrationObject, metricsHandler);
            threadList.add(integrationLayerThread);
        }
        // start threads for the received access objects w/ timeout
        ESLog.debug("Starting threads");

        try {
            ESLog.debug("Start SWOP access threads");
            long startTime = startWorkerThreads(threadList);
            ESLog.debug("Wait for the SWOP access threads");
            replies = waitForWorkerThreads(threadList, startTime);
        } finally {
            threadList.clear();
        }

        return replies;

    }

    /*
     * This method is making one EsReply out of three
     */
    /**
	 * @param metricsHandler  
	 */
    protected EsReply mergeMultipleWarrantyReplies(ArrayList replies, OperationContext context, MetricsHandler metricsHandler, EsRequestComplexType request) throws SifException {
        ESLog.debug("Warranty merging is beginning");

	        if (WarrantyErrorsProcessing.getInstance().countSifException(replies) == replies.size()) {
	
	            // We only got exception.
	        	// we need to check if SNR has a Unit list if so, we'll return it
	        	if (context.getManufacturingInstalledBaseServicEsReply() != null ) {
	        		EsReply esReplyFromMIBService =context.getManufacturingInstalledBaseServicEsReply();
					if(esReplyFromMIBService != null && esReplyFromMIBService.getEsReplyChoice() !=null && esReplyFromMIBService.getEsReplyChoice().getUnitList() != null) {
						ESLog.info("SNR have returned a unit list, we are not looking at SWOP error here");
						return esReplyFromMIBService;
					}
	        	}
	            ESLog.debug("We only got execption so , First we try to prioritize errors");
	
	            SifException composedError = WarrantyErrorsProcessing.getInstance().getHighestPriorityException(replies);
	            if (composedError != null) {
	                ESLog.debug("Warranty merging was having only exception");
	                throw composedError;
	            }
	        }
	        // We are getting a reply how of it
	        ESLog.debug("A composed reply will be generated");

	        return WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
    }

    private void cleanWarrantyReplies(ArrayList replies) {
		ESLog.debug("Cleaning up orchestration");
		try {
			if(replies != null) {
				Iterator it = replies.iterator();
				// go through all replies 
				while(it.hasNext()) {
					Transaction tr= (Transaction)it.next();
					tr.destroy();
				}
			}
		}catch(Exception e)  {
			ESLog.debug("Found an exception while cleaning up",e);
		}
	}

	/*
     * The public interface It execute to get warranty @param The request @param metrics handler to
     * track time @throws SifException
     */
    public EsReply execute(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler) throws SifException {

        String methodId = "WarrantyOrchestration.execute()";
        MetricsEntry overallTime = null;
        if (metricsHandler != null)
            overallTime = metricsHandler.startEntry(methodId);

        EsReply esReply = null;
        ESLog.debug("execute starting");
        Transaction reply = null;
        ArrayList replies = null;
        try {

            // We check what kind of warranty request we have
            switch (WarrantyRoutingInformation.determineWarrantyRouting(request.getEsRequestComplexTypeChoice().getWarrantyRequest())) {
            case WarrantyRoutingInformation.MULTIPLE_INSTANCE_ROUTING:
                ESLog.debug("execute MULTIPLE_INSTANCE_ROUTING");
                replies = receiveFromMultipleInstances(request,context, metricsHandler);
                esReply = mergeMultipleWarrantyReplies(replies,context, metricsHandler, request);
                ESLog.debug("Starting calculateHeaderFields with esReply: " + esReply + " and replies: " + replies);
                esReply = calculateHeaderFields(esReply, replies);

                // calculate support line to fill the context
                Iterator iterator = replies.iterator();
                boolean flagFound=false;
                while (iterator.hasNext() && flagFound == false) {
                    // check esReplyChoice to determine which swop warranty transaction will be used
                    // to get production line
                    Object transaction = iterator.next();
                    if (transaction instanceof WarrantyTransaction) {
                        WarrantyTransaction wt = (WarrantyTransaction) transaction;
                        if (wt.isEsReplyChoice()) {
                            String swopProductLine = wt.getProductLine();
                            ESLog.debug("In SWOP warranty, the WarrantyInfo.SupportLine is: " + swopProductLine);
                            context.setSupportLineFromSwop(swopProductLine);
                            flagFound = true;
                        }
                    }
                }

                break;

            case WarrantyRoutingInformation.SINGLE_INSTANCE_ROUTING:
                ESLog.debug("execute SINGLE_INSTANCE_ROUTING");
                reply = receiveFromSingleInstance(request, metricsHandler);
                if (reply.getMappedErrors() != null && reply.getMappedErrors().size() != 0) {
                    ArrayList list = new ArrayList();
                    list.add(reply);

                    throw WarrantyErrorsProcessing.getInstance().getHighestPriorityException(list);
                }

                esReply = reply.getMappedReply();
                esReply = calculateHeaderFields(esReply);

                // calculate support line to fill the context
                if (reply instanceof WarrantyTransaction) {
                    WarrantyTransaction wt = (WarrantyTransaction) reply;
                    if (wt != null)
                        context.setSupportLineFromSwop(((WarrantyTransaction) reply).getProductLine());
                }

                break;

            case WarrantyRoutingInformation.INVALID_ROUTING:
            default:
                ESLog.info("Invalid Warranty Scenario");
                throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "This is not a valid warranty scenario");
            }

            return esReply;

        } finally {
            if (overallTime != null)
                overallTime.actionDone();
           if(replies != null)
        	   this.cleanWarrantyReplies(replies);
           if (reply != null) {
        	   reply.destroy();
           }
        }

    }

    /*
     * EsReply the reply to calculate header field.
     * 
     */
    private EsReply calculateHeaderFields(EsReply esReply, ArrayList replies) throws SifException {

        ESLog.debug("Start calculation");
        // We are adding the system not available warning
        // if this is not a unit list

        ESLog.debug("get unavailable regions");
        String listOfUnavailableRegion = WarrantyErrorsProcessing.getInstance().getUnavailableRegionList(replies);

        if (!"".equalsIgnoreCase(listOfUnavailableRegion)) {
            ESLog.debug("Some regions were not available: " + listOfUnavailableRegion);
            EIAError eiaError = ErrorFactory.getEIAError(ErrorFactory.id400_SYSTEM_NOT_AVAILABLE, listOfUnavailableRegion);
            Warnings warnings = null;
            ESLog.debug("Check for warnings");
            ESLog.debug("esReply: " + esReply);
            if (esReply.getEsHeader().getWarnings() == null) {
                ESLog.debug("Create new warnings");
                warnings = new Warnings();
                esReply.getEsHeader().setWarnings(warnings);
            }
            warnings = esReply.getEsHeader().getWarnings();
            ESLog.debug("Add a new error to the warnings: " + warnings);
            warnings.addEIAError(eiaError);
        }
        ESLog.debug("Exit");
        return esReply;
    }

    /*
     * Calculate header fields @param reply @return reply
     * 
     */
    private EsReply calculateHeaderFields(EsReply esReply) {
        // Those fields are already calculated, this the last chance to add them, so let's keep this
        // method
        ESLog.debug("Nothing is done - because the fields are already calculated");
        return esReply;
    }

    public void configChanged(ConfigChangeEvent event) {
        String threadTimeoutEnable = event.getNewConfig().getProperty("es.sap.integration.thread.timeout.enable");
        String threadTimeout = event.getNewConfig().getProperty("es.sap.integration.thread.timeout");

        if ((threadTimeoutEnable != null) && (threadTimeoutEnable.trim().equalsIgnoreCase("true"))) {
            _threadTimeoutEnable = true;
        }
        if ((threadTimeout != null) && (threadTimeout.trim().length() > 0)) {
            _threadTimeout = Long.parseLong(threadTimeout);
        }

    }

}
