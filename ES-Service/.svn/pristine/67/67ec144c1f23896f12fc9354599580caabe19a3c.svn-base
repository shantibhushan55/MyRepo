/*
 * Created on Mar 13, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 */
public abstract class UnitListMapper {

	protected WarrantyTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;

    protected UnitListMapper(WarrantyTransaction transaction) {
    	_transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
    }	

    public static UnitListMapper getInstance(WarrantyTransaction transaction) {

            return new MetroUnitListMapper(transaction);
    }
    
    
    
    
    
    
    /**
     * map(). This is the entry point for mapping a complete unit list reply
     * @return
     * @throws MappingException
     * @throws SifException 
     */
	public abstract UnitListComplexType map() throws MappingException, SifException ;
	
    
}
