/*
 * Created on Mar 9, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.types.WarrantyTypeType;

/**
 * @author JUHANK
 */
abstract class OfferMapper {

	protected Transaction _transaction;
    protected OOSComplexType _oos;
    protected Date _entitlementCheckDate;
    protected XMLIdGenerator _XMLIdGenerator;
    protected WarrantyTypeType _warrantyType;

    protected OfferMapper(WarrantyTransaction transaction, Date entitlementCheckDate, 
    					OOSComplexType oos, XMLIdGenerator XMLIdGenerator, WarrantyTypeType warrantyType) {
        _transaction = transaction;
        _oos = oos;
        _entitlementCheckDate = entitlementCheckDate;
        _XMLIdGenerator = XMLIdGenerator;
        _warrantyType = warrantyType;
    }

    
    
    static OfferMapper getInstance(WarrantyTransaction transaction, Date entitlementCheckDate, 
			OOSComplexType oos, XMLIdGenerator XMLIdGenerator, WarrantyTypeType warrantyType) {

            return new MetroOfferMapper(transaction, entitlementCheckDate,oos, XMLIdGenerator, warrantyType);
    }    
    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract OfferComplexType[] map() throws MappingException;
    
     
}
