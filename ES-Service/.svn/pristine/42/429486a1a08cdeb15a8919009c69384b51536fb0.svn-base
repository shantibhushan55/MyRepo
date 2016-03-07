/*
 * Created on Sep 24, 2004
 *

 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hp.es.service.util.exception;

import com.hp.es.service.util.EsLogLevel;
import com.hp.sif.SifException;

/**
 * @author stefsobe
 *
 */
public class EsException extends SifException {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4570072516075371613L;
	private int logLevel = EsLogLevel.DEBUG;
    
    /**
     * @return Returns the logLevel. This log level is used when the
     * exception is logged into the log file. 
     */
    public int getLogLevel() {
        return logLevel;
    }
    /**
     * @param logLevel The logLevel to set.  This log level is used when the
     * exception is logged into the log file.
     */
    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }
	public String getMessage() {
		String message = null;
		message = super.getMessage() +"\n";
		message = "Id "+getErrorID()+" ,ErrorLevel "+getErrorLevel()+" ,ErrorClass "+getErrorClass()+" ,ErrorText "+getErrorText();
		return message;
	}
}
