/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.ibSearch.integration.mapping;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.InstalledBaseUnitListComplexType;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 */
public abstract class UnitListMapper {

	protected IBSearchTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;	

    public UnitListMapper(IBSearchTransaction transaction) {
    	_transaction = transaction;
    	_XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
    }	

    /**
     * map(). This is the entry point for mapping a complete IB Unit List reply
     * @return
     * @throws MappingException
     * @throws SifException 
     */
	public abstract InstalledBaseUnitListComplexType map() throws MappingException, SifException;


	public static UnitListMapper getInstance(IBSearchTransaction transaction) {

            return new MetroUnitListMapper(transaction);

	}
}
