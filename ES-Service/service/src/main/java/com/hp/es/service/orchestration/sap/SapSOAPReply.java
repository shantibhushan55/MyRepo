package com.hp.es.service.orchestration.sap;

public class SapSOAPReply {
	private Object _soapCastorReply;
	
	public SapSOAPReply(Object reply) {
		super();
		_soapCastorReply = reply;
	}

	public Object getSoapCastorReply() {
		return _soapCastorReply;
	}
	
	
	
	
}
