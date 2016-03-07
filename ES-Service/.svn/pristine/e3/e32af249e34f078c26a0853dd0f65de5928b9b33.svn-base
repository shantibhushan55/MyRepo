/*
 * Created on Mar 9, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 */
public abstract class WarrantyEntitlementMapper {

    protected WarrantyTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected Date _entitlementCheckDate;
    EsRequestComplexType _request;
    ManufacturingInstalledBaseHeaderType _manufacturingInstalledBaseServiceReply;
    SifException _manufacturingInstalledBaseServiceSE;

    protected WarrantyEntitlementMapper(WarrantyTransaction transaction, EsRequestComplexType request, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply, SifException manufacturingInstalledBaseServiceSE) {
    	_transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
        _entitlementCheckDate = request.getEsRequestComplexTypeChoice().getWarrantyRequest().getEntitlementCheckDate();
        _request = request;
        _manufacturingInstalledBaseServiceReply=manufacturingInstalledBaseServiceReply;
        _manufacturingInstalledBaseServiceSE=manufacturingInstalledBaseServiceSE;
    }	
	   
    
    
    public static WarrantyEntitlementMapper getInstance(WarrantyTransaction transaction, EsRequestComplexType request, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply, SifException manufacturingInstalledBaseServiceSE) {

            return new MetroWarrantyEntitlementMapper(transaction, request,manufacturingInstalledBaseServiceReply,  manufacturingInstalledBaseServiceSE);
    }
    
    
    /**
     * map(). This is the entry point for mapping a complete warranty reply
     * @return
     * @throws MappingException
     */
    public abstract WarrantyEntitlementComplexType map() throws MappingException;

	/**
	 * here we check if we have a 1004 warning (Product no longer eligible for warranty)
	 * if this is the case then we set the end date to the same as the start date
	 */
	protected Date checkForEligibleProductAndGetWarrantyEndDate(Date startDate, Date endDate) {
		if(_transaction.isSwopWarningMessageReturned(1004)) {
			return startDate;
		} else {
			return endDate;
		}
	}
	

}
