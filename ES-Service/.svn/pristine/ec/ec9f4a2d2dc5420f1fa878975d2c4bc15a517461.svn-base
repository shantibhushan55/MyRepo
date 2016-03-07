package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.xml.service.EsRequestComplexType;



public abstract class CQSRequestMapper{

	protected CQSRequestMapper() {
		super();
	}
	
	public abstract Object map(EsRequestComplexType input);

	public static CQSRequestMapper getInstance() {
            return new MetroCQSRequestMapper();

        
    }
	
	
}
