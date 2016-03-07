package com.hp.es.service.orchestration;


import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.EsException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
 

 
 public class OrchestrationWorker extends Thread {
	private EsRequestComplexType _request;
	private IntegrationInterface _integrationLayer;
	private MetricsHandler _metricsHandler;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrchestrationWorker [_request=" + _request
				+ ", _integrationLayer=" + _integrationLayer
				+ ", _metricsHandler=" + _metricsHandler + ", _reply=" + _reply
				+ "]";
	}

	private Transaction _reply;

	public OrchestrationWorker(EsRequestComplexType request,
			IntegrationInterface integrationLayer,
			MetricsHandler metricsHandler) {
		super(integrationLayer.getName() + "-Thread");
		_request = request;
		_integrationLayer = integrationLayer;
		_metricsHandler = metricsHandler;
	}

	/**
	 * 
	 * @param reply
	 */
	synchronized protected void setReply(Transaction reply) {
		_reply = reply;
	}

	/**
	 * @return Returns the reply.
	 */
	synchronized public Transaction getReply() {
		return _reply;
	}

	public void run() {
		
			// Default error reply for the case we run into a timeout
			Transaction reply = new ErrorTransaction(_integrationLayer.getRegionConfiguration(), 
										_integrationLayer.isRegionInFailoverMode(), 
									ErrorFactory.getSifException(ErrorFactory.id8000_TIMEOUT_OCCURRED, _integrationLayer.getRegionDisplayName()), 
										_integrationLayer.getRegionDisplayName(),_integrationLayer.isLocal());
	        setReply(reply);
			try {
				ESLog.debug("THREAD: Calling Source System");
				reply = _integrationLayer.execute(_request,
						_metricsHandler);
				
	            setReply(reply);
				ESLog.debug("THREAD: Received result and storing it");
			} catch (java.lang.Throwable thr) {
				if(thr instanceof EsException) {
					ESLog.debug("THREAD: Error - Caught a EsException "+  thr.getClass()+"/"+thr.getMessage());
				}else {
					ESLog.info("THREAD: Error - Caught a Throwable "+  thr.getClass()+"/"+thr.getMessage(), thr);
					ESLog.info(thr.toString());
					ESLog.info("cauaght a throwable",thr);
				}
	            reply = new ErrorTransaction(_integrationLayer.getRegionConfiguration(),
	            						_integrationLayer.isRegionInFailoverMode(), 
	            						thr,_integrationLayer.getRegionDisplayName(),_integrationLayer.isLocal());
	            setReply(reply);
			} finally {
				ESLog.debug("THREAD: Done, the thread will die after that");
				_request = null;
				_integrationLayer = null;
				_metricsHandler = null;
				
			}
		
	}



}
