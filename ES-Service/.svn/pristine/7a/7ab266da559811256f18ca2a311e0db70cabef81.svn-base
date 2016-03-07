package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.xml.service.Deliverable;

abstract class DeliverableMapper {

	protected Object _del;
	EsReplyContext _ctx;

	protected DeliverableMapper(Object del, EsReplyContext ctx) {
		super();
		_del = del;
		_ctx  = ctx;
		
	}

	/*
	 * Map deliverable
	 * @return deliverable (mapped)
	 */
	abstract Deliverable map(String sourceObligationId, String item);
}
