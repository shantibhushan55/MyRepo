package com.hp.es.service.orchestration.sap;


/**
 * SAP access exception thrown when a resource fails completely:
 * for example, if we can't connect to a SAP using HTTP.
 * @author wangwchu
 *
 */
public class SapAccessFailureException extends Exception{
    private static final long serialVersionUID = 3405619770923293070L;
    public SapAccessFailureException(String msg) {
        super(msg);
    }
    public SapAccessFailureException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
