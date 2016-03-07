/*
 * Created on Mar 9, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.ProductComplexType;

/**
 * @author JUHANK
 */
abstract class ProductMapper {

	protected Transaction _transaction;

    protected ProductMapper(WarrantyTransaction transaction) {
        _transaction = transaction;
    }

    
    
    abstract ProductComplexType  map() throws MappingException;
    
    
 
    
    /**
     * checks whether a product is empty or not
     * @param product
     * @return
     */
    protected boolean isProductNull(ProductComplexType product) {
    	if(product.getProductID() != null || product.getProductDescription() != null || 
    			product.getProductLineCode() != null || product.getProductLineDescription() != null) {
    		return false;
    	} else {
    		return true;
    	}
    }

}
