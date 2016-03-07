/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.TreeMap;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public abstract class CombinedUnitEntitlementMapper {

	protected ContractTransaction _transaction;
	protected XMLIdGenerator _XMLIdGenerator;
	protected EsRequestComplexType _request;
	protected EsReplyContext _ctx;
	/**
	 * @param transaction 
	 * 
	 */
	CombinedUnitEntitlementMapper(ContractTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
		super();
		_transaction = transaction;
		_XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
		_request = request;
		_ctx = ctx;
	}

	public abstract CombinedUnitEntitlementComplexType map() throws MappingException, SifException;
	/*
	 * This method sort oos by ooskey and return the first one
	 */
	protected final OOSComplexType mapNOosesToOne(OOSComplexType[] types) {
        if (types == null)
            return null;
		
	    TreeMap<String, OOSComplexType> toSort = new TreeMap<String, OOSComplexType>();
		for (OOSComplexType oosTmp : types) {
            if (oosTmp.getOOSKey() != null) {
                toSort.put(oosTmp.getOOSKey(), oosTmp);
            }
        }
		OOSComplexType oos =null;
        if (toSort.size()>0 && toSort.firstKey() != null) {
            oos = toSort.get(toSort.firstKey());
        }
		
		return oos;
	}
	
	
	
    static public CombinedUnitEntitlementMapper getInstance(ContractTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
            return new MetroCombinedUnitEntitlementMapper(transaction,  request, ctx);

        
    }	

}
