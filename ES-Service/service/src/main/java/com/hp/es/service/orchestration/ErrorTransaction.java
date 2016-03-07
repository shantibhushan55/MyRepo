/*
 * Created on Mar 1, 2006
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hp.es.service.orchestration;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 *
 */
public class ErrorTransaction extends Transaction {

	public ErrorTransaction(RegionConfiguration config, boolean failoverMode, Throwable thr, String displayName, boolean isLocal) {
        super(config, failoverMode, null, null, displayName,isLocal);
        setSourceSystemThrowable(thr);
        mapThrowable2MappedError(thr);
	}
	
	
    public EsReply getMappedReply() {
    	return null;
    }

    public Object getSourceSystemStandardReply() {
        return null;
    }
    public Object getSourceSystemUnitList() {
        return null;
    }

    public boolean isSourceSystemStandardReply() {
        return false;
    }
    public boolean isSourceSystemUnitList() {
        return false;
    }

	public boolean isSourceSystemError() {
		return false;
	}

	public Collection getSourceSystemErrors() {
		return null;
	}

	public boolean isSourceSystemWarnings() {
		return false;
	}

	public Collection getSourceSystemWarnings() {
		return null;
	}
	
	private void mapThrowable2MappedError(Throwable throwable) {
		ESLog.debug("An ErrorTransaction occured, map it to the mappedError");
		ArrayList errorList = new ArrayList();
		// checking which type it is
		if(throwable instanceof SifException) {
			// convert the throwable into a SifException
			ESLog.debug("We have a SifException");
			errorList.add((SifException) throwable);
		} else {
			// create a new SifException because an unknown error occured
			ESLog.debug("We have another Exception, create an internal SifException");
			errorList.add(ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, throwable.toString()));
		}
		// adding it to the mappedErrors collection
		ESLog.debug("Add the SifException to the mapped errors list");
		setMappedErrors(errorList);
	}


	@Override
	public void destroy() {
		// 
		super.destroy();
	}

}
