/*
 * Created on Mar 8, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Map;

import org.exolab.castor.types.Date;

import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.WarrantyComplexType;

/**
 * @author juhank
 */
abstract class WarrantyMapper {

    protected WarrantyTransaction _transaction;
    protected Map _oosMap;
    protected OOSComplexType _oos;
    protected Date _entitlementCheckDate;
    protected XMLIdGenerator _XMLIdGenerator;

    WarrantyMapper(WarrantyTransaction transaction, Date entitlementCheckDate, 
    						OOSComplexType oos, XMLIdGenerator XMLIdGenerator) {
    	_transaction = transaction;
        _entitlementCheckDate = entitlementCheckDate;
        _oos = oos;
        _XMLIdGenerator = XMLIdGenerator;
    }	

    
    
    
    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract WarrantyComplexType[] map() throws MappingException;
}
