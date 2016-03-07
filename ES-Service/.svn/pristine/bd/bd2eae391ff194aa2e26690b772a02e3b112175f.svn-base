package com.hp.es.service.serviceNotes;

import java.util.Collection;

import com.hp.es.service.orchestration.Transaction;

public class ServiceNoteTransaction extends Transaction {

	protected ServiceNoteTransaction(Object sourceReply, String displayName, boolean isLocal) {
        super(null, false, sourceReply, null, displayName,isLocal);
	}

	public boolean isSourceSystemUnitList() {
		return false;
	}
	public Object getSourceSystemUnitList() {
		return null;
	}

	// Note that the integration layer for service notes is so thin that there
    // is no separation between raw and mapped reply
	public boolean isSourceSystemStandardReply() {
		return (_mappedReply != null);
	}
	public Object getSourceSystemStandardReply() {
		return _mappedReply;
	}

	public boolean isSourceSystemError() {
		return (_mappedErrors != null);
	}
	public Collection getSourceSystemErrors() {
		return _mappedErrors;
	}

	public boolean isSourceSystemWarnings() {
		return false;
	}

	public Collection getSourceSystemWarnings() {
		return null;
	}

	@Override
	public void destroy() {
		super.destroy();
	}


}
