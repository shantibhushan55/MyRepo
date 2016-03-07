/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.manufacturingHeaderInformation.integration.mapping;

import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingBillOfMaterialRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 */
public abstract class ManufacturingInstalledBaseServiceRequestMapper {
	EsRequestComplexType _inputRequest = null;

	protected ManufacturingInstalledBaseServiceRequestMapper(EsRequestComplexType inputRequest) {
		_inputRequest = inputRequest;
	}

	/**
	 * maps the ES request
	 * @return
	 * @throws SifException 
	 */
	public abstract ManufacturingBillOfMaterialRequest map() throws SifException;

	
    public static ManufacturingInstalledBaseServiceRequestMapper getInstance(EsRequestComplexType inputRequest) {
            return new ManufacturingInstalledBaseServiceMetroRequestMapper(inputRequest);
        
    }
}
