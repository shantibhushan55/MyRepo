package com.hp.es.service.routingDetails.orchestration;

import java.util.ArrayList;

import com.hp.es.service.orchestration.ErrorsProcessing;
import com.hp.sif.SifException;

/**
 * @author Chunyang
 * @since 9.0.2
 */
public class RoutingDetailsErrorsProcessing extends ErrorsProcessing {
    protected final static RoutingDetailsErrorsProcessing _instance = new RoutingDetailsErrorsProcessing();

    protected int getPriorityForSifException(SifException ex) {
        // NOT IMPLEMENTED
        return 0;
    }
    protected RoutingDetailsErrorsProcessing() {
    	
    }
    /**
     * @return
     */
    public static RoutingDetailsErrorsProcessing getInstance() {
        // Get a singleton instance

        return _instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.ErrorsProcessing#getRedefinedSifException(com.hp.sif.SifException,
     *      java.util.ArrayList)
     */
    protected SifException getRedefinedSifException(SifException ex, ArrayList replies) throws SifException {
        // we simply return the exception again, because we have only 1 exception
        return ex;
    }
}
