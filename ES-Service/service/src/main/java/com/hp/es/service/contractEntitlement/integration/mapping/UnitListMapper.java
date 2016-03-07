/*
 * Created on Mar 13, 2006
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.sif.SifException;

/**
 * @author antoine 
 * This map a unit list
 */
public abstract class UnitListMapper {

	protected ContractTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;

    protected UnitListMapper(ContractTransaction transaction) {
    	_transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
    }	

    /**
     * map
     * @return
     * @throws MappingException
     * @throws SifException 
     */
    abstract public  UnitListComplexType map() throws MappingException, SifException;
	
    static public UnitListMapper getInstance(ContractTransaction transaction) {

        return new MetroUnitListMapper(transaction);

        
    }
    
}
