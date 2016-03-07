/*
 * Created on Dec 7, 2004
 */
package com.hp.es.service.batchEntitlement;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.hp.es.service.batchEntitlement.db.DbBatchEntitlementManager;
import com.hp.es.service.compliancevalidation.ComplianceValidationHelper;
import com.hp.es.service.transactionLogging.EsTransactionHelper;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.service.util.mail.EmailUtilities;
import com.hp.es.service.util.mail.EmailUtilitiesException;
import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.service.wsInterface.EsServiceHandler;
import com.hp.es.xml.batchEntitlement.EntitlementItem;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.io.zip.StreamCompressException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * The worker is actually initiating the different tasks for batch entitlement.
 * Following tasks are executed:
 *
 * <ul>
 * <li>
 * <li>access the DbBatchEntitlementManager to get the data for the next request to process
 * <li>if data are available then start a GetEntitlementBySN operation, retrieve the result,
 *     store the result in the DB (using the DbBatchEntitlementManager) and continue with #1
 * <li>check if all requests are finished
 * <li>if yes build a response and send the email to the user, update the status accordingly
 *     and continue with #1 get the next request and create subrequests in the database
 * <li>remove old requests.
 * <li>wait until the service load is under a configured limit
 * <ul>
 */
public class Worker extends Thread implements ConfigChangeListener {

    private BatchLoadMonitor batchLoadMonitor;
    private boolean stopped;

    /*
     * Variable that are read from config file
     */
    private boolean sendEmailEnabled = true;
    private boolean processRequestsEnabled = true;
    private boolean extractRequestsEnabled = true;
    private boolean deleteRequestsEnabled = true;
    private int subRequestListMaxSize = 0;
    private int emailRetries;
    private String smtpServer;

    //We add a service handler and instantiate it
    //TODO look if we cannot reuse the one that created the BatchRequestManager
    private EsServiceHandler serviceHandler = new EsServiceHandler();
    private static DbBatchEntitlementManager dbMgr = DbBatchEntitlementManager.getInstance();

    private static final String EMAIL_SUBJECT = "Batch Result: ";
    private static final String EMAIL_MESSAGE_TEXT_SUCESS = "Batch was created, result is attached.\n\r ";
    private static final String EMAIL_MESSAGE_TEXT_SIGNATURE = "\n\rES Service Team\n";

    private static final String BATCH_FILE_NAME = "batch_";
    private static final String BATCH_FILE_EXTENSION = ".zip";

    // all threads are working on this request ID
    private static String currentRequestId = null;

    // Variables needed to avoid that the delete, extract and email methods are called
    // too often by the different threads.
    private static long nextExtractTime = System.currentTimeMillis();
    private static long nextDeleteTime = System.currentTimeMillis();
    private static long nextEmailTime = System.currentTimeMillis();
    private static long nextSubRequestProcessTime = System.currentTimeMillis();
    private static final Object mutex = new Object();


    /**
     * @param batchLoadMonitor
     */
    public Worker(BatchLoadMonitor batchLoadMonitor) {
    	super( "Batch worker-Thread");
        ESLog.info("Created worker");
        this.batchLoadMonitor = batchLoadMonitor;
        // We register for getting config changes updates
        Configuration.getInstance().addConfigChangeListener(this);

        // The service Handler is initialized as it is not being called by the EIA SF
        serviceHandler.init();

        stopped = false;
    }

    /**
     *
     */
    public void run() {
        ESLog.info("Starting new batch entitlement thread");
        try {
        	batchLoadMonitor.waitForLowLoad(true);
            do {
                try {
                	Date start = new Date();
                	ESLog.debug("Thread Name:"+this.getName()+",ID:"+this.getId()+",Enter run:"+start.getTime());                	
    	            if (!processNextSubRequest()) {
    	            	Date startSending = new Date();
    	            	ESLog.debug("Thread Name:"+this.getName()+",ID:"+this.getId()+",Enter sending");
    	            	ESLog.debug("Start check For Email And SendEmail:"+startSending.getTime());
  	                    checkForEmailAndSendEmail();
  	                    Date emailEnding = new Date();
  	                    ESLog.debug("Thread Name:"+this.getName()+",ID:"+this.getId()+",finish sending:"+(emailEnding.getTime()-startSending.getTime()));
                        extractRequestToSubRequest();
                        Date extractNewEnding = new Date();
                        ESLog.debug("Thread Name:"+this.getName()+",ID:"+this.getId()+",finish extract New:"+(extractNewEnding.getTime()-emailEnding.getTime()));
    	                deleteOldRequests();
    	                Date deleteOldEnding = new Date();
    	                ESLog.debug("Thread Name:"+this.getName()+",ID:"+this.getId()+",finish delete Old:"+(deleteOldEnding.getTime()-extractNewEnding.getTime()));
    	                ESLog.debug("Thread Name:"+this.getName()+",ID:"+this.getId()+",finish sending:"+(deleteOldEnding.getTime()-startSending.getTime()));
    	                ESLog.debug("Name:"+this.getName()+",ID:"+this.getId()+",Exit sending:"+deleteOldEnding.getTime());
    	            }
                }
                catch (Exception e) {
                    // We catch Runtime here to make sure that a bug does not stop all workers
                    ESLog.error("Exception occur in worker, worker will continue and will go in wait state", e);
                }

                if (!stopped) {
                    // Wait some until the load is under the configured limit.
                    // If nothing was to do in the last loop, we enforce to
                    // wait at least a certain time.
                    batchLoadMonitor.waitForLowLoad(
                                        currentRequestId == null ||
                                         (   (!extractRequestsEnabled || nextExtractTime > System.currentTimeMillis())
                                          && (!sendEmailEnabled       || nextEmailTime > System.currentTimeMillis())
                                          && (!processRequestsEnabled || nextSubRequestProcessTime > System.currentTimeMillis())));
                }
            } while (!stopped);
        }
        finally {
            //You can only go in a stop state if you are running
            //This means that we have to decrease
            batchLoadMonitor.operationHasFinished();
            //The operation that stopped was running so we need
            // Note that we don't catch RuntimeException, such Exception will cause the thread to die
            ESLog.info("Batch entitlement thread was stopped");
        }
    }

    /**
     * delete Request that are older than a certain time
     */
    private void deleteOldRequests() {
        if (!deleteRequestsEnabled) {
            return;
        }

        synchronized (mutex) {
            if (nextDeleteTime < System.currentTimeMillis()) {
                ESLog.debug("Enter deleteOldRequests");
                try {
                    dbMgr.deleteOldRequests();
                }
                catch (DatabaseDownException e) {
                    handleDatabaseDown(e);
                }
                catch (Exception e) {
                    //If we get an error, we can do nothing except logging to log file.
                    ESLog.error("Error while trying to delete old requests from Database", e);
                }

                nextDeleteTime = System.currentTimeMillis() + (60L * 60000L); // only once per hour
                ESLog.debug("Exit deleteOldRequests");
            }
        }
    }

    /**
     * This method extract a request (if there is any available) into sub requests
     */
    private void extractRequestToSubRequest() {
        if (!extractRequestsEnabled) {
            return;
        }

        synchronized (mutex) {
            if (nextExtractTime < System.currentTimeMillis()) {
		        ESLog.debug("Enter extractRequestToSubRequest");
                currentRequestId = dbMgr.extractRequestToSubRequests();
                if (currentRequestId!=null) {
                    // start processing it immediately
                    nextSubRequestProcessTime = System.currentTimeMillis();
                }
		        nextExtractTime = System.currentTimeMillis() + 60000L; // only once per minute
		        ESLog.debug("Exit extractRequestToSubRequest");
            }
        }
    }

    /**
     * Check if an email is ready for sending and send the result to the user.
     */
    private void checkForEmailAndSendEmail() {

        if (!sendEmailEnabled) {
            return;
        }

        synchronized (mutex) {
            if (nextEmailTime < System.currentTimeMillis()) {
                ESLog.debug("Enter");

                boolean sendEmailSucceded = true;
                Request onSendingRequest=null;
                Request request = null;

                try {

        	        /*
        	         * synopsis
        	         * use request to send the email
        	         *
        	         * if failed
        	         *   request.emailRetries++
        	         *   if retries > limit
        	         * 		request.status = failed
        	         * 	    ITO alert
        	         *   else
        	         *      request.status = waitForResend
        	         *      request.setNextResendTime
        	         */
                	
                    try {
                    	Date startRequestForEmailing =new Date();
                    	ESLog.debug("start Request For Emailing"+startRequestForEmailing.getTime());
                    	onSendingRequest=dbMgr.getOnsendingRequest(null);
                    	ESLog.debug("finish get onSending request:"+onSendingRequest.getStatus());
                        request = dbMgr.getRequestForEmailing(onSendingRequest);
                        Date endRequestForEmailing =new Date();
                        ESLog.debug("Time of getting Request For Emailing:"+(endRequestForEmailing.getTime()-startRequestForEmailing.getTime()));
                        if (request == null) {
                            // If no request is available for sending, then we
                            // wait some time before we check again.
                            nextEmailTime = System.currentTimeMillis() + 60000L; // only once per minute
                            ESLog.debug("nextEmailTime=" + nextEmailTime);
                            return;
                        }

//                        if (ESLog.isDebugLogEnabled()) {
                            ESLog.info("Worker will send email for request " + request.toString());
//                        }
                            
                       long startSendingEmail=System.currentTimeMillis();
                       ESLog.debug("Start Sending Email:"+startSendingEmail);
                        EmailUtilities eu = new EmailUtilities(smtpServer);
                        String toList[] = new String[1];
                        toList[0] = request.getEmailAddress();
                        if (request.getNbSubRequest() > 0) {

                        	ESLog.debug("request.getNbSubRequest=" + request.getNbSubRequest());
                            String errorMessage = "";
                            if (request.getErrorMessage() != null && request.getErrorMessage().length() != 0) {
                                errorMessage = "\nwith following warnings:\n\n" + request.getErrorMessage();
                            }

                            StringBuffer includeInformation = new StringBuffer();
                            includeInformation.append("INCLUDE_OFFER_FLAG:" + request.isIncludeOffers() + "\n");
                            includeInformation.append("INCLUDE_CONTRACT_FLAG:" + request.isIncludeContracts() + "\n");
                            
                            ESLog.debug("toList=" + request.getEmailAddress());
                            ESLog.debug("EMAIL_SUBJECT=" + EMAIL_SUBJECT);
                            ESLog.debug("request.getFileName=" + request.getFileName());
                            ESLog.debug("request.getRequestId=" + request.getRequestId());

                            eu.postMail(toList, request.getEmailAddress(), EMAIL_SUBJECT + request.getRequestId() + " - for "
                                    + request.getFileName(),
                            includeInformation + EMAIL_MESSAGE_TEXT_SUCESS + errorMessage + EMAIL_MESSAGE_TEXT_SIGNATURE, request
                                    .getStreamForCompressedResponse(), BATCH_FILE_NAME + request.getRequestId() + BATCH_FILE_EXTENSION);

                        } else {
                            ESLog.debug("This is a request that failed as the number of request is equals to 0");
                            eu.postMail(toList, request.getEmailAddress(), EMAIL_SUBJECT + request.getRequestId() + " - for "
                                    + request.getFileName(), request.getErrorMessage() + EMAIL_MESSAGE_TEXT_SIGNATURE);
                        }
                        long endSendingEmail=System.currentTimeMillis();
                        ESLog.debug("Time of sending email:"+(endSendingEmail-startSendingEmail));
                        ESLog.info("Finished sending:"+endSendingEmail+" Request id:"+request.getRequestId()+" Request Name=" + request.getFileName());
                        
                    } catch (EmailUtilitiesException e1) {
                        ESLog.error("Email Exception while sending the message. request=" + request, e1);
                        sendEmailSucceded = false;
                    } catch (StreamCompressException e) {
                    	if (onSendingRequest!=null && onSendingRequest.getRequestId()!=null && request==null){
                    		dbMgr.updateOnSendingRequestAndDeleteSubRequest(onSendingRequest);
                    	}
                        ESLog.error("Error while sending email. request=" + request, e);
                        sendEmailSucceded = false;
                    } catch (SifException e) {
                    	if (onSendingRequest!=null && onSendingRequest.getRequestId()!=null && request==null){
                    		dbMgr.updateOnSendingRequestAndDeleteSubRequest(onSendingRequest);
                    	}
                        ESLog.error("Error while sending email. request=" + request, e);
                        sendEmailSucceded = false;
                    }catch(SQLException sqle) {
                    	if (onSendingRequest!=null && onSendingRequest.getRequestId()!=null && request==null){
                    		dbMgr.updateOnSendingRequestAndDeleteSubRequest(onSendingRequest);
                    	}
                    	if(DbBatchEntitlementManager.isSeriousOracleIssue(sqle)) {
                    		ESLog.error("SQL Error while sending email" + sqle.getMessage());
                    	}else {
                    		ESLog.info("Oracle reported an issue with a NOWAIT statement, that's expected");
                    	}
                    	sendEmailSucceded = false;
                	}catch (Exception e) {
                		if (onSendingRequest!=null && onSendingRequest.getRequestId()!=null && request==null){
                    		dbMgr.updateOnSendingRequestAndDeleteSubRequest(onSendingRequest);
                    	}
                        ESLog.error("Internal Error while sending email. request=" + request,e);
                        sendEmailSucceded = false;
                    }
                    
                    if(request!=null){
                    	 long startRequestStatus =System.currentTimeMillis();
            	        if(sendEmailSucceded) {
            	        	ESLog.info("Send seccessfully for Request:" + request.getRequestId());
            	            request.setStatus("sent");
            	        }else {
            	            ESLog.debug("request="+request);
            	            ESLog.debug("request.getEmailRetries="+request.getEmailRetries());
            	            ESLog.debug("this.emailRetries="+this.emailRetries);
            	            //We exceeded the number of retries
            	            if(request.getEmailRetries() > this.emailRetries) {
            	                request.setStatus("failed");
            	                request.setErrorMessage("E-Mail error: batch failed to send email");
            	                ESLog.error("Error when sending emails, maximum retries exceeded");
            	            }else {
            	               request.setEmailRetries(request.getEmailRetries()+1);
            	               request.setStatus("waitForResend");
            	            }
    
            	        }
            	        dbMgr.updateRequestStatus(request);
            	        long endRequestStatus=System.currentTimeMillis();
            	        ESLog.debug("Time of update request status:"+(endRequestStatus-startRequestStatus));
                    }
                    // we can try to extract another request immediately
                    nextExtractTime = System.currentTimeMillis();

                /*
                 * In case of Exception we can do nothing else than logging them
                 */
                }
                catch (DatabaseDownException e) {
                    handleDatabaseDown(e);
                }catch(SQLException sqle) {
                	if(DbBatchEntitlementManager.isSeriousOracleIssue(sqle)) {
                		ESLog.error("SQL Error while sending email", sqle);
                	}else {
                		ESLog.info("Oracle reported an issue with a NOWAIT statement, that's expected");
                	}
                	
            	}catch (Exception e) {
                    ESLog.error("Error while sending email", e);
                    
                }
                finally {
                	nextEmailTime = System.currentTimeMillis() + 60000L; // only once per minute
                    if(request!=null) {
                        request.releaseResources();
                    }
                    ESLog.debug("Exit");
                }
            }
        }
    }



	/**
     * @return true if a SubRequest was processed. false if no SubRequest was available for processing
     */
    private boolean processNextSubRequest() {
        SubRequest subRequest = null;
        EsReply reply = null;
        EsReply replyBeforeCVS = null;
        EsRequestComplexType request = null;
        MetricsHandler handler = null;
        EntitlementItem batchReply = null;
        BatchRequestMapper requestMapper = BatchRequestMapper.getInstance();
        BatchReplyMapper replyMapper = BatchReplyMapper.getInstance();
        String retXml = null;
        String retCsv=null;
        
        // subRequestList is used to hold next 50 sub requests in memory. (50 is just taken as an example, this is
        // configurable.)
        List<SubRequest> subRequestList = null;

        synchronized (mutex) {
        }

        if (nextSubRequestProcessTime > System.currentTimeMillis() || !processRequestsEnabled) {
            return false;
        }
        
        try {
        	long startGetSubRequestList=System.currentTimeMillis();
            subRequestList = dbMgr.getSubRequestList(currentRequestId, subRequestListMaxSize);
            long endGetSubRequestList=System.currentTimeMillis();
            ESLog.debug("Time of geting sub request:"+(endGetSubRequestList-startGetSubRequestList));
        } catch (DatabaseDownException e) {
            handleDatabaseDown(e);
            return false;
        } catch (Exception e) {
            ESLog.error("Error while processing SubRequest", e);
            return false;
        }
        
        if (subRequestList == null || subRequestList.size() == 0) {
            currentRequestId = null;

            // it can be possible that we have some unprocessed request due to a
            // service that fails. These requests will be processed 30 minutes later

            // If no SubRequest was found, then all threads should wait some
            // time before they call the database again
            nextSubRequestProcessTime = System.currentTimeMillis() + 60000L; // only once per minute
            ESLog.debug("exit");
            return false;
        }

        if (subRequestList.size() >0)
            currentRequestId = ((SubRequest) subRequestList.get(0)).getRequestId();

        for (int i = 0; i < subRequestList.size(); i++) {
            long startTime = System.currentTimeMillis();

            subRequest = (SubRequest) subRequestList.get(i);
    		
            if (ESLog.isDebugLogEnabled())
    			handler = new MetricsHandler();
            
            /*
             * Use sequence with cache instead of batch sequence
             */
            String transId = "";
            try {
            	transId = TransactionIdGenerator.getInstance().nextId();
            	
                // We create some objects needed to call the service (transid, ..)
                
                
                request = requestMapper.createEsRequestComplexType(subRequest);

                reply = serviceHandler.callServiceWithObject(request, transId, handler);
                /*
                 * Put the cvs code here
                 */
                ComplianceValidationReply cvsReply = null;
                try {
                	cvsReply = ComplianceValidationHelper.getInstance().callComplianceValidationService(reply, request,transId);
                } catch (Exception e1)  {
                	//we can't add the se for the batch so we have to ignore them
                	ESLog.error("Error in CVS",e1);
                }
                
                if(cvsReply !=null && cvsReply.getMessageList() != null && cvsReply.getMessageList().size()>0) {
                	replyBeforeCVS=copyReply(reply);
                	reply=ComplianceValidationHelper.getInstance().modifyESReply(reply, cvsReply);
                }
                long endTime = System.currentTimeMillis();
                ESLog.debug("[perf] batch: " + (endTime-startTime));

                batchReply = replyMapper.mapEsReplytoEntitlementItem(reply, subRequest);
                retCsv=BatchxmlConverter.getInstance().marshalToCSV(batchReply);
                retXml = MarshalHelper.marshal(batchReply, handler);
                EsTransactionHelper.getInstance().sendTransactionToTransactionLoggingMessageSender(request, reply,replyBeforeCVS,cvsReply,transId, startTime, endTime, handler);
            } catch (SifException e) {
            	ESLog.error("processNextSubRequest transId:"+transId+" Caught SifException: ", e);
                try {
                    batchReply = replyMapper.mapEsReplytoEntitlementItem(e, subRequest);
                    retCsv=BatchxmlConverter.getInstance().marshalToCSV(batchReply);
                    retXml = MarshalHelper.marshal(batchReply, handler);
                } catch (SifException e1) {
                	ESLog.error("processNextSubRequest transId:"+transId+" Caught SifException in SifException: ", e1);
                    // This case should never happen but we have to cope with it here
                    replyMapper.createReplyForInternalError(subRequest,retXml,retCsv);
                } catch (MapperException me) {
                    // This case should never happen but we have to cope with it here
                	ESLog.error("processNextSubRequest transId:"+transId+" Caught MapperException in SifException: ", me);
                    retXml = replyMapper.createReplyForInternalError();
                    retCsv=replyMapper.createCsvReplyForInternalError();
                }
                long endTime = System.currentTimeMillis();
                ESLog.debug("[perf] batch (exception): " + (endTime-startTime));
                //log transaction
                EsTransactionHelper.getInstance().sendTransactionToTransactionLoggingMessageSender(request, e, transId,startTime, endTime, handler);
            } catch (MapperException me) {
            	ESLog.error("processNextSubRequest transId:"+transId+" Caught MapperException while processing the request", me);
                // GENERATE an internal error
                replyMapper.createReplyForInternalError(subRequest,retXml,retCsv);
                long endTime = System.currentTimeMillis();
                EsTransactionHelper.getInstance().sendTransactionToTransactionLoggingMessageSender(request, ErrorFactory.getSifException(9999), transId,startTime, endTime, handler);
            } catch (Throwable thr) {
                ESLog.error("processNextSubRequest transId:"+transId+" Caught throwable while processing the request", thr);
                // We map the throwable to an internal error
                replyMapper.createReplyForInternalError(subRequest,retXml,retCsv);
                long endTime = System.currentTimeMillis();
                EsTransactionHelper.getInstance().sendTransactionToTransactionLoggingMessageSender(request, ErrorFactory.getSifException(9999), transId,startTime, endTime, handler);
            } finally {
            	// We then need to update the subRequest
            	// the retXml should never be null
            	try {
            		subRequest.setResponse(retXml);
            		subRequest.setCsvResponse(retCsv);
            		dbMgr.updateSubRequest(subRequest);                                
            	} catch (DatabaseDownException e) {
            		handleDatabaseDown(e);
            		return false;
            	} catch (Exception e) {
            		ESLog.error("processNextSubRequest transId:"+transId+" Error while updating the SubRequest", e);
            		return false;
            	}
            }

        }
        return true;
    }

    private EsReply copyReply(EsReply reply) {
		// TODO Auto-generated method stub This is incorrect for now and dirty
    	EsReply replycopied = null;
    	try {
			String tmpXml = MarshalHelper.marshal(reply, null);
			replycopied = (EsReply) MarshalHelper.unmarshal(tmpXml, null, EsReply.class);
		} catch (SifException e) {
			ESLog.error("Error in cloning", e);
			replycopied = reply;
		}
		return replycopied;
	}

	/**
     * 
     */
    public void setStopFlag() {
        ESLog.info("Thread stop flag was set to true");
        stopped = true;
    }

    /**
     * Read and initialize following values: <ul>
     * <li>batchEntitlement.email.enable
     * <li>batchEntitlement.email.retries
     * <li>batchEntitlement.email.smtpserver
     * </ul>
     * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
     */
    public void configChanged(ConfigChangeEvent event) {
        if (event!=null && event.getNewConfig()!=null) {
            ESLog.info("Reload configuration");

            sendEmailEnabled       = getBooleanProperty(event, "batchEntitlement.email.enable", Boolean.TRUE);
            processRequestsEnabled = getBooleanProperty(event, "batchEntitlement.processRequests.enable", Boolean.TRUE);
            extractRequestsEnabled = getBooleanProperty(event, "batchEntitlement.extractRequests.enable", Boolean.TRUE);
            deleteRequestsEnabled  = getBooleanProperty(event, "batchEntitlement.deleteRequests.enable", Boolean.TRUE);
            
            /*
             * getting batchEntitlement.subRequestList.maxSize
             */
            try {
                subRequestListMaxSize = event.getNewConfig().getIntegerProperty("batchEntitlement.subRequestList.maxSize",
                        new Integer(50)).intValue();
            } catch (Exception e) {
                ESLog.error("Error while reading parameters", e);
                ESLog.info("No batchEntitlement.subRequestList.maxSize defined, default value \"50\" will be used");
                subRequestListMaxSize = 50;
            }
            
            /*
             * getting batchEntitlement.email.retries
             */
            try {
                emailRetries  = event.getNewConfig().getIntegerProperty("batchEntitlement.email.retries", new Integer(48)).intValue();
            }
            catch (Exception e) {
                ESLog.error("Error while reading parameters", e);
                ESLog.info("No emailRetries defined, default value \"48\" will be used");
                emailRetries  = 48;
            }

            /*
             * getting batchEntitlement.email.smtpserver=localhost
             */
            try {
                smtpServer = event.getNewConfig().getProperty("batchEntitlement.email.smtpserver", "localhost");
            }
            catch (Exception e) {
                ESLog.error("Error while reading parameters", e);
                ESLog.info("No smtpServer defined, default value \"localhost\" will be used");
                smtpServer = "localhost";
            }

            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("processRequestsEnabled = " + processRequestsEnabled);
                ESLog.debug("extractRequestsEnabled = " + extractRequestsEnabled);
                ESLog.debug("deleteRequestsEnabled = " + deleteRequestsEnabled);
                ESLog.debug("sendEmailEnabled = " + sendEmailEnabled);
                ESLog.debug("emailRetries = " + emailRetries);
                ESLog.debug("smtpserver = " + smtpServer);
            }
        }
    }

    /**
     * Helper method to get a boolean property
     */
    private boolean getBooleanProperty(ConfigChangeEvent event, String key, Boolean defaultValue) {
        try {
            return event.getNewConfig().getBooleanProperty(key, Boolean.TRUE).booleanValue();
        }
        catch (Exception e) {
            ESLog.error("Error while reading parameter " + key
                    + " (use default [" + defaultValue + "])", e);
        }
        return defaultValue.booleanValue();
    }


    /**
     * Do not access the database for 5 minutes because the database is down.
     */
    private void handleDatabaseDown(Exception e) {
        ESLog.error("Database is down. Batch Entitlement pauses for 15 minutes", e);
        nextDeleteTime = nextDeleteTime + 900000L;
        nextExtractTime = System.currentTimeMillis() + 960000L;
        nextEmailTime = System.currentTimeMillis() + 900000L;
        nextSubRequestProcessTime = System.currentTimeMillis() + 900000L;
    }

    /**
     * Only used for testing!!!
     * @param args
     */
    public static void main(String[] args) {
        Worker w = new Worker(new BatchLoadMonitor());
        w.start();
        try {
            w.join();
        }
        catch (InterruptedException e) {
        }
    }
}
