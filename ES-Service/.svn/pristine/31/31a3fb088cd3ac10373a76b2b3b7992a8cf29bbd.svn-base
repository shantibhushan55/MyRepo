package com.hp.es.service.transactionLogging;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.tm.Transaction;
import com.hp.es.tm.TransactionLogging;

public class TransactionLoggingMessageSender implements Runnable {

    private static TransactionLoggingMessageSender instance = new TransactionLoggingMessageSender();

    
    

    private boolean running = false;
    private boolean tmEnable = false;
    private int     tmInterval = 5;

    
    /*
     * The 
     */
    private ConcurrentLinkedQueue<Transaction> _transactionQueue = new ConcurrentLinkedQueue<Transaction>();

	private Object runningSync = new Object();

	


    /**
     * The requestXml and replyXml must be EIA message. It means EIA envelope must be included.
     * 
     * @param eiaRequestXml
     * @param eiaReplyXml
     * @param startTime
     * @param endTime
     */
    private TransactionLoggingMessageSender() {
		tmEnable = Configuration.getInstance().getProperties().getBoolean(
				EsConstants.ES_TM_ENABLED);
		tmInterval = Configuration.getInstance().getProperties()
				.getIntegerProperty(EsConstants.ES_TM_INTERVAL,
						Integer.valueOf(5)).intValue();
        ESLog.info("tmEnable=" + tmEnable);
    }

    public void run() {
        try {
        	synchronized(runningSync ) {
        		running = tmEnable;
        	}
            while (running) {
				// while (!_transactionQueue.isEmpty()) {
                Transaction tm = getNextTransaction();
				while (tm == null) {
					//no need to synchonize on a ConcurrentLinkedQueue
					synchronized (_transactionQueue) {
	                    try {
								_transactionQueue.wait(tmInterval);
						} catch (Exception exe) {
							ESLog.error("Error In wait statement",exe);
						}
					}
					//}
					tm = getNextTransaction();
					if (tm == null && !running) {
						break;
					}
				}
				if (tm != null) {
					processTransaction(tm);
				}
				synchronized (runningSync) {
					tmEnable = Configuration.getInstance().getProperties()
							.getBoolean(EsConstants.ES_TM_ENABLED);
					tmInterval = Configuration.getInstance().getProperties()
							.getIntegerProperty(EsConstants.ES_TM_INTERVAL,
									Integer.valueOf(5)).intValue();
					running = tmEnable;
				}
			}
		} catch (Throwable e) {
			ESLog.error(" Exception in TM, let's consider we have stopped it",
					e);
		} finally {
			stopRunning();
		}
	}
	private void processTransaction(Transaction tm) {
			TransactionLogging.getInstance().processRequest(tm);
    }



	/*
     * This method will send Transaction message to a JMS queue.
     */

    private Transaction getNextTransaction() {
        return _transactionQueue.poll();
    }


 
    /**
     * @return the running
     */
    public boolean isRunning() {
    	synchronized(runningSync ) {
    		return running;
    	}
    }

    /**
     * @return the running
     */
    public void stopRunning() {
        synchronized(runningSync ) {
        	running = false;
        	tmEnable = false;
        }
        _transactionQueue.clear();
    }

    /*
     * Singleton
     */
    public static TransactionLoggingMessageSender getInstance() {

        return instance;
    }

    /*
     * Add an object to queue
     */
    public void addToTransactionQueue(Transaction tm) {
    	boolean enable = false;
    	synchronized(runningSync ) {
    		enable = tmEnable;
    	}
        if (enable && tm != null) {
			if (ESLog.isDebugLogEnabled()) {
            ESLog.debug("Transaction will be added to queue.");
			}
			synchronized (_transactionQueue) {
            _transactionQueue.add(tm);
			_transactionQueue.notify();
			}
//        }
        }
	}

}
