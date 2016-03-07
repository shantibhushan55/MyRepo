/*
 * Created on Mar 9, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.Part;

/**
 * @author JUHANK
 */
abstract class SparePartMapper {

	protected Transaction _transaction;

    protected SparePartMapper(WarrantyTransaction transaction) {
        _transaction = transaction;
    }

    
    abstract Part map() throws MappingException;
    
 
}
