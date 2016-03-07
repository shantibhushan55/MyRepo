/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENTITLEMENTREPLYV1;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
class MetroCombinedUnitEntitlementMapper extends CombinedUnitEntitlementMapper {

	/**
	 * @param transaction 
	 * 
	 */
	MetroCombinedUnitEntitlementMapper(ContractTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
		super(transaction, request, ctx);
	}

	public CombinedUnitEntitlementComplexType map() throws MappingException, SifException{
		CombinedUnitEntitlementComplexType result = new CombinedUnitEntitlementComplexType();
		EntitlementBySnRequest esr =_request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest();
		
		

		Map<String, ContactComplexType> contactMap = new HashMap<String, ContactComplexType>();
		if(esr.getIncludeContacts()) {
		    ContactMapper contactMapper = new MetroContactMapper(_transaction,_XMLIdGenerator);
		    result.setContact(contactMapper.map());
		    // Convert the array of contacts into a HashMap for ContractMapper
		    
		    for (int i=0; i<result.getContactCount(); i++) {
		        contactMap.put(result.getContact(i).getSourcePersonID(), result.getContact(i));
		    }
		}
	    
	    Map<String, LocationComplexType> locationMap = new HashMap<String, LocationComplexType>();
	    if(esr.getIncludeAddresses()) {
		    LocationMapper locationMapper = new MetroLocationMapper(_transaction, _XMLIdGenerator);
		    result.setLocation(locationMapper.map());
		    // Convert the array of locations into a HashMap for ContractMapper
	    
		    for (int i=0; i<result.getLocationCount(); i++) {
		        locationMap.put(result.getLocation(i).getSourceCustomerID(), result.getLocation(i));
		    }
	    }
	
	    /* WITS.1470: bySN does not return applies tos for OSSGroup linkages
	     * Change: 
	     * 	Introduce an OOS list to contain all OOSes. 
	     * 	This OOS list is used to generate the OOS to OOSGroup linkage
	     *  The logic was copied from CombinedUnitEntitlementMapper.java */
	    Map<String, OOSComplexType> oosMap = new HashMap<String, OOSComplexType>();
	    Map<String, ArrayList<String>> oosKeyListMapbyOOSGroupId = new HashMap<String, ArrayList<String>>();
	    
	    OosMapper oosMapper = new MetroOosMapper(_transaction, _XMLIdGenerator, _ctx);
	    OOSComplexType[] oosTmpList = oosMapper.map();
	    if(esr.isIncludeManufacturerInfo()) {
	    	((MetroOosMapper)oosMapper).mapMV(oosTmpList);
	    }
	    result.setOOS(mapNOosesToOne(oosTmpList));
	    // Convert the array of ooses into a HashMap for ContractMapper
	    for (int i=0; i<oosTmpList.length; i++) {
		  	oosMap.put(oosTmpList[i].getOOSKey(), oosTmpList[i]);
		    if(oosKeyListMapbyOOSGroupId.containsKey(oosTmpList[i].getOOSGroupID())) {
		      	ArrayList<String> list = oosKeyListMapbyOOSGroupId.get(oosTmpList[i].getOOSGroupID());
		       	list.add(oosTmpList[i].getOOSKey());
		    }else {
		       	ArrayList<String> list = new ArrayList<String>(); 
		       	list.add(oosTmpList[i].getOOSKey());
		       	oosKeyListMapbyOOSGroupId.put(oosTmpList[i].getOOSGroupID(),list);		        	
		    }
		}
	
	    ContractMapper contractMapper =
	        new MetroContractMapper(_transaction, _XMLIdGenerator, oosMap, locationMap, contactMap, oosKeyListMapbyOOSGroupId, _ctx);
	    result.setContract(contractMapper.map(esr.getIncludeOffers(),esr.getIncludeDeliverables(),esr.getIncludeModifiers(),esr.getIncludeContacts(), esr.getIncludeAddresses(), true));
	    
    	
    	// now we set the summary fields at the top
	    ZESCQSENTITLEMENTREPLYV1 cqsReply = (ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply();
	    result.setActiveContractEntitlement(MappingUtils.mapToBoolean(cqsReply.getACTIVECONTRACTENTITLEMENT()));
	    result.setOverallContractEndDate(MappingUtils.mapToCastorDate(cqsReply.getOVERALLCONTRACTENDDATE()));
	    result.setOverallContractStartDate(MappingUtils.mapToCastorDate(cqsReply.getOVERALLCONTRACTSTARTDATE()));
	    
    	/*
    	 * Adding customer identification
    	 */
    	if(esr.isIncludeCustomerIdentificationInformation() && cqsReply.getCUSTOMERIDENTIFICATION() != null)  {
    		result.setCustomerIdentification(MetroCustomerIdentificationTypeMapper.mapCUSTOMERIDENTIFICATION(cqsReply.getCUSTOMERIDENTIFICATION()));
    	}
	    
	    return result;
	}
	
	




}
