/*
 * Created on Mar 20, 2006
 */
package com.hp.es.service.unitEventHistory.orchestration;

import java.util.ArrayList;

import com.hp.es.service.orchestration.ErrorsProcessing;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 * This class is only created to get the ErrorsProcessing methods for 
 * IBSearch operation. No additional methods are implement, because
 * there are not needed
 */
public class UnitEventHistoryErrorsProcessing extends ErrorsProcessing {

	/*
	 * TODO Need to get error that can be throwed by sap FOR UNIT EVENT HIST
	 */
	protected final static UnitEventHistoryErrorsProcessing _instance = new UnitEventHistoryErrorsProcessing();	
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.ErrorsProcessing#getPriorityForSifException(com.hp.sif.SifException)
	 */
	protected int getPriorityForSifException(SifException ex) {
		// NOT IMPLEMENTED
		return 0;
	}
	
	protected UnitEventHistoryErrorsProcessing() {
		
	}

	/**
	 * @return
	 */
	static UnitEventHistoryErrorsProcessing getInstance() {
		// Get a singleton instance
		return _instance;
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.ErrorsProcessing#getRedefinedSifException(com.hp.sif.SifException, java.util.ArrayList)
	 */
	protected SifException getRedefinedSifException(SifException ex, ArrayList replies) throws SifException {
		// we simply return the exception again, because we have only 1 exception
		return ex;
	}

}
