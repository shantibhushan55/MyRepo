/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.ibSearch.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.OOSComplexType;

/**
 * @author JUHANK
 */
abstract class OosMapper {
	
	protected IBSearchTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;

    protected OosMapper(IBSearchTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
    }

    /**
     * map() maps a all swop products to OOSs
     * @return
     * @throws MappingException
     */
    OOSComplexType[] map() throws MappingException {
    	if(_transaction == null) {
    		return new OOSComplexType[0];
    	}
    	Collection ibProdlist = (Collection) _transaction.getSourceSystemUnitList();
    	OOSComplexType oosList[] = new OOSComplexType[ibProdlist.size()];
     	ESLog.debug("Mapping " + ibProdlist.size() + " OOSs ...");
     	Iterator iterator = ibProdlist.iterator();
     	int i = 0;
     	while(iterator.hasNext()) {
     		oosList[i] = mapOos(iterator.next());
     		i++;
     	}
        return oosList;
    }    
    
    /**
     * mapOos maps the product from IB (SWOP) to an OOS
     * @return
     * @throws MappingException
     */
    protected abstract OOSComplexType mapOos(Object ibProduct) throws MappingException;
  
}
