package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCONTRACTV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENTITLEMENTREPLYV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSLOCATION;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBLIGATIONHEADERV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBLIGATIONLOCATION;
import com.hp.es.service.contractEntitlement.keys.LocationKey;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.LocationComplexType;

class MetroLocationMapper extends LocationMapper{

    MetroLocationMapper(ContractTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        super(transaction,XMLIdGenerator);
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    LocationComplexType[] map() throws MappingException {
    	if(_transaction == null) {
    		return new LocationComplexType[0];
    	}
    	
    	List<ZESCQSLOCATION> sapLocations = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getLOCATIONS().getItem();
    	
        LocationComplexType[] locations = new LocationComplexType[((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getLOCATIONS().getItem().size()];
        

        ESLog.debug("Mapping " + locations.length + " locations ...");
        int i=0;
        for (ZESCQSLOCATION location : sapLocations) {
        	locations[i++] = mapLocation(location);
        }
        return locations;
    }

    /**
     * mapLocation
     * @param input
     * @return
     * @throws MappingException
     */
     protected LocationComplexType mapLocation(ZESCQSLOCATION input) throws MappingException {

     	ESLog.debug("Mapping location: ");
        LocationComplexType location = new LocationComplexType();
        location.setSourceCustomerID(input.getSOURCECUSTOMERID());               
        addPSPId( input,  location); // PSP location added
        location.setId(_XMLIdGenerator.nextId());
        location.setCity(MappingUtils.nullString(input.getCITY()));
        location.setFmtAddrLine1(MappingUtils.nullString(input.getFMTADDRLINE1()));
        location.setFmtAddrLine2(MappingUtils.nullString(input.getFMTADDRLINE2()));
        location.setFmtAddrLine3(MappingUtils.nullString(input.getFMTADDRLINE3()));
        location.setFmtAddrLine4(MappingUtils.nullString(input.getFMTADDRLINE4()));
        location.setFmtAddrLine5(MappingUtils.nullString(input.getFMTADDRLINE5()));
        location.setGeographicArea(MappingUtils.nullString(input.getGEOGRAPHICAREA()));
        location.setIsoCountryCd(MappingUtils.nullString(input.getISOCOUNTRYCD()));
        location.setPostalCode(MappingUtils.nullString(input.getPOSTALCODE()));
        location.setSiteBusinessName1(MappingUtils.nullString(input.getSITEBUSINESSNAME1()));
        location.setSiteBusinessName2(MappingUtils.nullString(input.getSITEBUSINESSNAME2()));
        location.setSiteBusinessName3(MappingUtils.nullString(input.getSITEBUSINESSNAME3()));
        location.setSiteBusinessName4(MappingUtils.nullString(input.getSITEBUSINESSNAME4()));
        location.setStreetAddr1(MappingUtils.nullString(input.getSTREETADDR1()));
        location.setStreetAddr2(MappingUtils.nullString(input.getSTREETADDR2()));

        if(_ctx != null) {
            LocationKey key = new LocationKey(location.getSourceCustomerID());
            _ctx.addLocation(key, location);        	
        }
        return location;
    }
     /* PSP Id will be added to the location based on the OBLIGATION ADDR ROLE  and source customer id*/
    private void addPSPId(ZESCQSLOCATION input, LocationComplexType location)throws MappingException {
    	ESLog.debug("addPSPId begin ");
    	 
    	Collection sapContracts = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getCONTRACTS().getItem();
         
        for (Iterator it = sapContracts.iterator(); it.hasNext(); ) {
        	ZESCQSCONTRACTV1 zESCQSCONTRACTV1 = (ZESCQSCONTRACTV1) it.next(); 
        	if(zESCQSCONTRACTV1.getOBLIGATIONHEADERS() != null) {
	         	List<ZESCQSOBLIGATIONHEADERV1> enumObj = zESCQSCONTRACTV1.getOBLIGATIONHEADERS().getItem();
	         	for (ZESCQSOBLIGATIONHEADERV1 header : enumObj) {
	         		if(header.getOBLIGATIONLOCATION() != null) { 
	         			List<ZESCQSOBLIGATIONLOCATION> enumOBLIGATION_LOCATION = header.getOBLIGATIONLOCATION().getItem();
		         		for (ZESCQSOBLIGATIONLOCATION zesCQSOBLIGATIONLOCATION : enumOBLIGATION_LOCATION) {
		         			String oBLIGSOURCECUSTOMERID = zesCQSOBLIGATIONLOCATION.getOBLIGSOURCECUSTOMERID();
			         		if("PSP".equalsIgnoreCase(zesCQSOBLIGATIONLOCATION.getOBLIGADDRROLE()) && 
			         				( oBLIGSOURCECUSTOMERID != null && 
			         						oBLIGSOURCECUSTOMERID.equalsIgnoreCase(input.getSOURCECUSTOMERID())) ) { // check against role and customer id
			         			location.setPSPID(input.getSOURCECUSTOMERID()); //PSP id will be added
			         			ESLog.debug("PSP ID added "+ location.getPSPID());
			         		}
		         		}	         		
	         		}
	         	}
        	}
         	
        }
        ESLog.debug("addPSPId end ");
    	 
    }

}
