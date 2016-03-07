/**
 * 
 */
package com.hp.es.service.orchestration;

import java.util.ArrayList;

import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 * This class is providing all utility method to work with 
 * Several source systems that needs to be called in paralell
 * 
 */
public abstract class SourceSystemsOrchestration 		 {

	/*
	 * Warranty or contract will have to implement the init
	 */
	protected abstract int init();
	protected int initialized =0;
	
	protected boolean   _threadTimeoutEnable = false;
	protected long 		_threadTimeout = 0;

	
	
	public abstract EsReply execute(EsRequestComplexType request, OperationContext context,
			MetricsHandler metricsHandler) throws SifException;
	
	/**
	 * Public constructor
	 */
	public SourceSystemsOrchestration() {
		super();
	}



	/*
	 * startOneThreadAndWaitForReply 
	 * Start one thread and wait for it to finish.
	 * It also return the orechestrationReply
	 * 
	 * @param integrationLayerThread a created thread
	 * @return OrchestrationReply 
	 */		
	protected Transaction startOneThreadAndWaitForReply(OrchestrationWorker integrationLayerThread) {
		Transaction transaction = null;
		long timeWaited = System.currentTimeMillis();
		ESLog.debug("Starting 1 thread "+integrationLayerThread.getClass().getName()+ ", "+integrationLayerThread.toString());
		integrationLayerThread.start();
		
		// wait for all threads
		ESLog.debug("Waiting for the thread "+integrationLayerThread.getClass().getName()+ ", "+integrationLayerThread.toString());
		try {
			if(_threadTimeoutEnable && _threadTimeout > 0){
                ESLog.debug("Waits at most " + _threadTimeout + " milliseconds for this thread to die.");
				integrationLayerThread.join(_threadTimeout);
			}else{
				integrationLayerThread.join();
			}
			timeWaited = System.currentTimeMillis() -timeWaited;
			transaction = integrationLayerThread.getReply();
			
		} catch (InterruptedException e) {
			ESLog.error("Error - Caught a InterruptedException "+  e.getClass()+"/"+e.getMessage(), e);
		}
		
		if( transaction instanceof ErrorTransaction) {
			ESLog.info("Thread "+integrationLayerThread.getClass().getName()+" errors "+transaction.toString()+" after "+timeWaited +"ms");
			
		}else {
			ESLog.debug("Finished waiting for the thread "+integrationLayerThread.getClass().getName()+" finished after "+ timeWaited+"ms");
		}

		// send back replies
		ESLog.debug("Exit");

		return transaction;
	}	
	
	/**
	 * startWorkerThreads - starts all Threads which has been passed. To get wait for 
	 * the threads and get the data, you need to call the method waitForWorkerThreads.
	 * NOTE: This has been split in 2 methods, that it is possible to start an ODS call 
	 *       in between. The ODS call can throw an DatabaseDownException which is picked 
	 *       in the thread and not passed on. This is a quick fix to have the DatabaseDown 
	 *       exception thrown all the way back to signal a service down.
	 *       This needs to be changed for the future. The WITS XXXX has been opened to
	 *       change this
	 * 
	 * @param integrationLayerThread a created thread
	 * @return OrchestrationReply 
	 */
	protected long startWorkerThreads(ArrayList <OrchestrationWorker> integrationLayerThreads) {
		//ArrayList arrReplies = new ArrayList(integrationLayerThreads.size());
		long startWaitTime = System.currentTimeMillis();
		/*
		 * We start all the threads
		 */
		for(int i =0; i< integrationLayerThreads.size(); i++) {

			OrchestrationWorker worker = integrationLayerThreads.get(i);
			ESLog.debug("Starting  thread "+  i +"/ "+ worker.getClass().getName()+ ", "+worker.toString() +" out of "+ integrationLayerThreads.size());
			worker.start();
		}
		return startWaitTime;
	}
	
	/**
	 * waitForWorkerThreads - wits for all Threads which has been passed and returns the replies.
	 * To start the threads you need to call the method startWorkerThreads.
	 * NOTE: This has been split in 2 methods, that it is possible to start an ODS call 
	 *       in between. The ODS call can throw an DatabaseDownException which is picked 
	 *       in the thread and not passed on. This is a quick fix to have the DatabaseDown 
	 *       exception thrown all the way back to signal a service down.
	 *       This needs to be changed for the future. The WITS XXXX has been opened to
	 *       change this
	 * 
	 * @param integrationLayerThreads
	 * @param startWaitTime
	 * @return
	 */
	protected ArrayList<Transaction> waitForWorkerThreads(ArrayList <OrchestrationWorker>  integrationLayerThreads,  long startWaitTime) {
		
		/*
		 * TODO this is incorrect
		 */
		
		Transaction reply = null;
		ArrayList<Transaction> arrReplies = new ArrayList<Transaction>(integrationLayerThreads.size());
		long timeWaited = 0;
		
		//long threadStarted = System.currentTimeMillis();

		// wait for all threads
		ESLog.debug("Waiting for the threads ...");
		
		for(int i =0; i< integrationLayerThreads.size(); i++) {
			
			OrchestrationWorker worker = (OrchestrationWorker) integrationLayerThreads.get(i);
			try {
				if(_threadTimeoutEnable && _threadTimeout > 0){
					//threadStarted = System.currentTimeMillis();
					
					worker.join(_threadTimeout);

					ESLog.debug("Thread "+ i + " out of "+ integrationLayerThreads.size()+ " stopped after (worker.join("+_threadTimeout+")) "+ (System.currentTimeMillis()-startWaitTime) + "ms");
					ESLog.debug("Already waited " + (System.currentTimeMillis()-startWaitTime) +" while timeout is "+_threadTimeout);

				}else{
				//	threadStarted = System.currentTimeMillis();
					worker.join();
					ESLog.debug("Thread "+ i + " out of "+ integrationLayerThreads.size()+ " stopped after (worker.join() "+ (System.currentTimeMillis()-startWaitTime) + "ms");
				}
				
			} catch (InterruptedException e) {
				ESLog.error("Error - Caught a InterruptedException "+  e.getClass()+" / "+e.getMessage(), e);
			}
			
			// get time how long we have waited already
			timeWaited = System.currentTimeMillis() - startWaitTime;
			ESLog.debug("Thread "+ i + " out of "+ integrationLayerThreads.size()+ " stopped after "+ timeWaited + "ms");
			
			// get the reply
			reply = worker.getReply();
			if(reply instanceof ErrorTransaction) {
				ESLog.warn("Thread "+i+","+worker.getClass().getName()+" returned errors "+reply.toString()+" after "+timeWaited +"ms, timeout was " +_threadTimeout +"ms");
			} else {
				ESLog.debug("Waiting for the thread "+i+","+worker.getClass().getName()+" finished after "+ timeWaited+"ms, timeout was " +_threadTimeout +"ms");
			}
			arrReplies.add(reply);
		}
		// send back replies
		return arrReplies;
	}
}
