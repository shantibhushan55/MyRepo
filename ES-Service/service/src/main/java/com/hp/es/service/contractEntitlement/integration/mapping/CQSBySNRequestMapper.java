package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.xml.service.EsRequestComplexType;

public abstract class CQSBySNRequestMapper {

	CQSBySNRequestMapper() {
		super();

	}
	public abstract Object map(EsRequestComplexType input);

    public static CQSBySNRequestMapper getInstance() {

            return new MetroCQSBySNRequestMapper();

        
    }

}
