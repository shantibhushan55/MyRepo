/*
 * Created on Mar 20, 2006
 */
package com.hp.es.service.manufacturingHeaderInformation.orchestration;

import java.util.Iterator;

import com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 * The orchestration is only used for passing the requests and replies.
 * No orchestration is done, since we are sending the request only
 * to the local region.
 */
public class ManufacturingInstalledBaseServiceOrchestraction extends SourceSystemsOrchestration   {	
	/*
	 * Singleton
	 */
	protected final static ManufacturingInstalledBaseServiceOrchestraction _instance = new ManufacturingInstalledBaseServiceOrchestraction();
	protected ManufacturingInstalledBaseServiceIntegration _snrIntegration = null;
	/*
	 * Default Constructor.
	 */
	private ManufacturingInstalledBaseServiceOrchestraction() {
		super();
		_snrIntegration= ManufacturingInstalledBaseServiceIntegration.getInstance();
	}

	/*
	 * Instance Method
	 */
	public static synchronized ManufacturingInstalledBaseServiceOrchestraction getInstance() {
		return _instance;
	}
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#init()
	 */
	protected synchronized int init() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException{
		ESLog.debug("Start SNR call");

        Transaction transaction = null;
		try {
	        // access objects from factory
	        ESLog.debug("Starting SNR access");
	        transaction =  _snrIntegration.execute(request, metricsHandler);
	        if(transaction.getMappedReply() != null) {
	        	return transaction.getMappedReply() ;
	        }
	        if(transaction.getMappedErrors()!= null && !transaction.getMappedErrors().isEmpty()) {
	        	Iterator<SifException> it= transaction.getMappedErrors().iterator();
	        	SifException sifE= (SifException) it.next();
	        	throw sifE;
	        }
	        /*we should never ever go here  but for safety*/
        	throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Internal error when accessing MIB, no reply, no sifexceptiopn mapped");
			}finally {
		        	ESLog.debug("end  SNR call");
			}
			
		
	}
	

}
