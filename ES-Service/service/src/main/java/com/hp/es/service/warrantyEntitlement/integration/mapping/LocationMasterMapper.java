/*
 * Created on Mar 8, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.LocationComplexType;

/**
 * @author juhank
 */
abstract class LocationMasterMapper {

	protected Transaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;

    protected LocationMasterMapper(WarrantyTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract LocationComplexType[]  map() throws MappingException ;

    /**
     * This methods checks if at least one of the field contains some data after mapping.
     * @param locationToCheck
     * @return true if all fields are null
     */
    protected boolean isLoactionNull(LocationComplexType locationToCheck) {
    	if(locationToCheck.getSourceCustomerID() != null ||
    			locationToCheck.getCity() != null ||
    			locationToCheck.getFmtAddrLine1() != null ||
    			locationToCheck.getFmtAddrLine2() != null ||
    			locationToCheck.getFmtAddrLine3() != null ||
    			locationToCheck.getFmtAddrLine4() != null ||
    			locationToCheck.getFmtAddrLine5() != null ||
    			locationToCheck.getGeographicArea() != null ||
    			locationToCheck.getIsoCountryCd() != null ||
    			locationToCheck.getPostalCode() != null ||
    			locationToCheck.getSiteBusinessName1() != null ||
    			locationToCheck.getSiteBusinessName2() != null ||
    			locationToCheck.getSiteBusinessName3() != null ||
    			locationToCheck.getSiteBusinessName4() != null ||
    			locationToCheck.getStreetAddr1() != null ||
    			locationToCheck.getStreetAddr2() != null) {
    		return false;
    	} else {
    		return true;
    	}
    }

}
