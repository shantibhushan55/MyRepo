/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.DeliverableComplexType;

/**
 * @author yesilyur
 *
 */
abstract class CSDeliverableMapper {

	protected Object _deliverable;
	protected EsReplyCSContext _ctx;

	/**
	 * @param _deliverable 
	 * @param _ctx 
	 * 
	 */
    protected CSDeliverableMapper(Object deliverable, EsReplyCSContext ctx) {
    	_deliverable = deliverable;
    	_ctx = ctx;
    	
	}

    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract DeliverableComplexType map();


}
