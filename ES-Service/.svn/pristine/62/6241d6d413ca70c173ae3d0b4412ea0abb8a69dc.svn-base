/*
 * Created on Mar 9, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;

/**
 * @author JUHANK
 */
abstract class OosMapper {

	protected WarrantyTransaction _transaction;
	protected LocationComplexType _locationObject;
	XMLIdGenerator _XMLIdGenerator;
	EsRequestComplexType _request;

    public OosMapper(WarrantyTransaction transaction, LocationComplexType locationObject, XMLIdGenerator XMLIdGenerator, EsRequestComplexType request) {
        _transaction = transaction;
        _locationObject = locationObject;
        _XMLIdGenerator = XMLIdGenerator;
        _request = request;
    }

    
    abstract OOSComplexType map() throws MappingException;
    

}