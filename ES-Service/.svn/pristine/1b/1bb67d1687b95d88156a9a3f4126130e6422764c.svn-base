package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Collection;

import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

public class MetroErrorMapper extends ErrorMapper {

	protected MetroErrorMapper(Collection swopErrors, EsRequestComplexType request) {
		super(swopErrors, request);
	}

	protected SifException mapError(Object swopError) {
		
		return mapError((ZWTYERROR)swopError);
	}
	
	protected SifException mapError(ZWTYERROR swopError) {
		
		return getError(swopError.getID(),swopError.getMESSAGE());
	}


}
