/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;

import java.util.List;

import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSLOCATIONSUM;
import com.hp.es.service.contractSummary.keys.CSLocationKey;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.AddressComplexType;

/**
 * @author yesilyur
 *
 */
public class MetroCSLocationMapper extends CSLocationMapper {

	MetroCSLocationMapper(ContractSummaryTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        super(transaction,XMLIdGenerator);
    }

	AddressComplexType[] map() throws MappingException {
    	if(_transaction == null) {
    		return new AddressComplexType[0];
    	}
    	if(((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getLOCATIONS() == null){
    		return new AddressComplexType[0];    		
    	}
    	List<ZESCQSLOCATIONSUM> sapLocations = ((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getLOCATIONS().getItem();
    	
    	AddressComplexType[] locations = new AddressComplexType[((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getLOCATIONS().getItem().size()];

        ESLog.debug("Mapping " + locations.length + " locations ...");
        int i=0;
        for (ZESCQSLOCATIONSUM sapLocation : sapLocations) {
        	locations[i++] = mapLocation(sapLocation);
        }
        return locations;	
	}

	
    /**
     * mapLocation
     * @param input
     * @return
     * @throws MappingException
     */
     protected AddressComplexType mapLocation(ZESCQSLOCATIONSUM input) throws MappingException {

     	ESLog.debug("Mapping location (address): ");
     	AddressComplexType location = new AddressComplexType();

     	location.setId(_XMLIdGenerator.nextId());
        
     	location.setSourceCustomerID(input.getSOURCECUSTOMERID());

     	location.setSiteBusinessName1(MappingUtils.nullString(input.getSITEBUSINESSNAME1()));
        location.setSiteBusinessName2(MappingUtils.nullString(input.getSITEBUSINESSNAME2()));
        location.setSiteBusinessName3(MappingUtils.nullString(input.getSITEBUSINESSNAME3()));
        location.setSiteBusinessName4(MappingUtils.nullString(input.getSITEBUSINESSNAME4()));

        location.setFmtAddrLine1(MappingUtils.nullString(input.getFMTADDRLINE1()));
        location.setFmtAddrLine2(MappingUtils.nullString(input.getFMTADDRLINE2()));
        location.setFmtAddrLine3(MappingUtils.nullString(input.getFMTADDRLINE3()));
        location.setFmtAddrLine4(MappingUtils.nullString(input.getFMTADDRLINE4()));
        location.setFmtAddrLine5(MappingUtils.nullString(input.getFMTADDRLINE5()));

        location.setStreetAddr1(MappingUtils.nullString(input.getSTREETADDR1()));
        location.setCity(MappingUtils.nullString(input.getCITY()));

        location.setGeographicArea(MappingUtils.nullString(input.getGEOGRAPHICAREA()));
        location.setPostalCode(MappingUtils.nullString(input.getPOSTALCODE()));
        location.setIsoCountryCd(MappingUtils.nullString(input.getISOCOUNTRYCD()));

        if(_ctx != null) {
            CSLocationKey key = new CSLocationKey(location.getSourceCustomerID());
            _ctx.addLocation(key, location);        	
        }
        return location;
    }
	
}
