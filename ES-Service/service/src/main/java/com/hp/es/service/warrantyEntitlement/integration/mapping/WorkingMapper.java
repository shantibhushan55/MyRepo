/*
 * Created on Mar 9, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.sif.SifException;

/**
 * @author juhank
 */
public abstract class WorkingMapper {

	protected WarrantyTransaction _transaction;
	protected EsRequestComplexType _request;
	ManufacturingInstalledBaseHeaderType _manufacturingInstalledBaseServiceReply;
	SifException _manufacturingInstalledBaseServiceSE;

    protected WorkingMapper(WarrantyTransaction transaction, EsRequestComplexType request,ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply, SifException manufacturingInstalledBaseServiceSE) {
    	_transaction = transaction;
    	_request = request;
    	_manufacturingInstalledBaseServiceReply=manufacturingInstalledBaseServiceReply;
    	_manufacturingInstalledBaseServiceSE=manufacturingInstalledBaseServiceSE;
    }
    


    public static WorkingMapper getInstance(WarrantyTransaction transaction, EsRequestComplexType request, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply, SifException manufacturingInstalledBaseServiceSE) {
            return new MetroWorkingMapper(transaction, request,manufacturingInstalledBaseServiceReply,  manufacturingInstalledBaseServiceSE);
    }
    
    public abstract WorkingComplexType[] map() throws MappingException ;
}
