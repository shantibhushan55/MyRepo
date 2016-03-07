/*
 * Created on Mar 8, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;

/**
 * @author juhank
 */
public abstract class RequestMapper {
	
	EsRequestComplexType _inputRequest = null;
	String _performProductBasedCalculation = null;
	ManufacturingInstalledBaseHeaderType _manufacturingInstalledBaseServiceReply = null;
	

	protected RequestMapper(EsRequestComplexType inputRequest, String performProductBasedCalculation,ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply) {
		_inputRequest = inputRequest;
		_performProductBasedCalculation = performProductBasedCalculation;
		_manufacturingInstalledBaseServiceReply=manufacturingInstalledBaseServiceReply;
	}

	
    public static RequestMapper getInstance(EsRequestComplexType inputRequest, String performProductBasedCalculation, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply) {

            return new MetroRequestMapper(inputRequest, performProductBasedCalculation,manufacturingInstalledBaseServiceReply);

        
    }
	
	
	/**
	 * maps the ES request
	 * @return
	 */
	public abstract Object map();
}