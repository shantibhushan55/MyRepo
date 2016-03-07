package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENTITLEMENTREPLYV1;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.sif.SifException;

class MetroContractEntitlementMapper extends ContractEntitlementMapper {



	MetroContractEntitlementMapper(ContractTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
    	super(transaction, request, ctx);
    }	
    
    public ContractEntitlementComplexType map() throws MappingException, SifException {
    	ContractRequest cr = _request.getEsRequestComplexTypeChoice().getContractRequest();
    	ContractEntitlementComplexType result = new ContractEntitlementComplexType();    	
    	
    	ZESCQSENTITLEMENTREPLYV1 cqsReply = (ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply();
    	
    	Map<String, ContactComplexType> contactMap = new HashMap<String, ContactComplexType>();
    	if(cr.getIncludeContacts()) {
		    ContactMapper contactMapper = new MetroContactMapper(_transaction,_XMLIdGenerator);
		    result.setContact(contactMapper.map());
		    // Convert the array of contacts into a HashMap for ContractMapper
		    
		    for (int i=0; i<result.getContactCount(); i++) {
		        contactMap.put(result.getContact(i).getSourcePersonID(), result.getContact(i));
		    }
    	}

    	Map<String, LocationComplexType> locationMap = new HashMap<String, LocationComplexType>();
    	if(cr.getIncludeAddresses()) {
		    LocationMapper locationMapper = new MetroLocationMapper(_transaction, _XMLIdGenerator);
		    result.setLocation(locationMapper.map());
		    // Convert the array of locations into a HashMap for ContractMapper
		    
		    for (int i=0; i<result.getLocationCount(); i++) {
		        locationMap.put(result.getLocation(i).getSourceCustomerID(), result.getLocation(i));
		    }
    	}
	
    	Map<String, OOSComplexType> oosMap = new HashMap<String, OOSComplexType>();
    	Map<String, ArrayList<String>> oosKeyListMapbyOOSGroupId = new HashMap<String, ArrayList<String>>();
		OosMapper oosMapper = new MetroOosMapper(_transaction, _XMLIdGenerator, _ctx);
        OOSComplexType[] oosResult = oosMapper.map();
        if(cr.isIncludeManufacturerInfo()) {
        	((MetroOosMapper)oosMapper).mapMV(oosResult);
        }
    
	    // Convert the array of ooses into a HashMap for ContractMapper
	    
	    for (int i=0; i<oosResult.length; i++) {
	        OOSComplexType oos = oosResult[i];
	        oosMap.put(oos.getOOSKey(), oos);
	        if(oosKeyListMapbyOOSGroupId.containsKey(oos.getOOSGroupID())) {
	        	ArrayList<String> list = oosKeyListMapbyOOSGroupId.get(oos.getOOSGroupID());
	        	list.add(oos.getOOSKey());
	        }else {
	        	ArrayList<String> list = new ArrayList<String>(); 
	        	list.add(oos.getOOSKey());
	        	oosKeyListMapbyOOSGroupId.put(oos.getOOSGroupID(),list);
	        	
	        }
	    }
        if(cr.getIncludeOOSes()){
           result.setOOS(oosResult);
        }
    	/* WITS.1464 UniqueOffers and UniqueDeliverables must be generated for getContractEntitlement
    	 * Implementation: 
    	 * The contractMapper is used by getContract and bySN, therefore we cannot pass the whole 
    	 * request structure but rather need to evaluate the correct include flags for the request 
    	 * 
    	 * The flag IncludeUniqueOffers is set in case, IncludeUniqueDeliverables is set:
    	 *  (See in RequestCleaner() !)  
    	 * As Unique offers and deliverables are only generated for getContract and not for 
    	 *  get Entitlement by SN, we do not include this logic into the contractMapper. 
    	 * Therefor we need to fetch the offers / deliverables first and then generate the 
    	 *  Unique Offers/Deliverables. For this we use the temporary flags: */
    	boolean tmpIncludeOffers = false;
    	boolean tmpIncludeDeliverables = false;	    
	    if (cr.getIncludeUniqueDeliverables() == true){
	    	ESLog.debug("... map deliverables and offers due to flag IncludeUniqueDeliverables");
	    	tmpIncludeOffers = true;
	    	tmpIncludeDeliverables = true;	    	
	    }else {
	    	if (cr.getIncludeUniqueOffers() == true ) {
	    		ESLog.debug("... map offers due to flag IncludeOffers");
	    		tmpIncludeOffers = true;   		
	    	}    		
    	}
    	tmpIncludeOffers = tmpIncludeOffers ? true : cr.getIncludeOffers();
    	tmpIncludeDeliverables = tmpIncludeDeliverables ? true : cr.getIncludeDeliverables();
    	
    	// Map the contract with all items underneath (Service, deliverables, ...)
    	ContractMapper contractMapper =
	        new MetroContractMapper(_transaction, _XMLIdGenerator, oosMap, locationMap, contactMap,oosKeyListMapbyOOSGroupId, _ctx);
    	result.setContract(contractMapper.map(tmpIncludeOffers, tmpIncludeDeliverables, cr.getIncludeModifiers(),cr.getIncludeContacts(), cr.getIncludeAddresses(), cr.getIncludeOOSes()));	    

    	/* unique offers and deliverables:
    	 * If unique offers are requested
    	 * we do the following
    	 *  Create unique offer and deliverables
    	 * 	remove "standard" offers if only unique offers are requested
    	 *  remove "standard" deliverable if only unique deliverables are requested
    	 * !!! The following code is copied from EsReplyContext.mergeAndCalculateAll() 
    	 * !!! and adapted to the CQS return structures and data
    	 *
    	 * We only check the flag IncludeOffers as this is also set if IncludeDeliverables are requested.*/ 
    	if (cr.getIncludeUniqueOffers() ) {
    		/* We only hand over the includeUniqueDeliverables flag, as we know that we
    		 * need to include unique offers too in that case. So include unique offers is 
    		 * no differentiation criteria any longer (See if) */
    		createUniqueOffersAndDeliverables( cr.getIncludeUniqueDeliverables(), result);

            /* if only the unique offers or deliverables are included
             * remove source offer or deliverable references */
            if (!cr.getIncludeOffers()){
            	ESLog.debug("... remove unwanted offers now" );
            	for (int c=0; c<result.getContractCount();c++) {
            		for (int o=0; o<result.getContract(c).getObligationHeaderCount();o++){
            			// Delete the offer references underneath the obligation header
            			ESLog.debug("... remove offer references of obligation " + 
            					result.getContract(c).getObligationHeader(o).getSourceObligationID());
            			result.getContract(c).getObligationHeader(o).removeAllServiceItem();
            		}
            		// Delete the actual offers on the contract level
            		ESLog.debug("... remove offers for Svc Agreement ID " + 
        					result.getContract(c).getSvcAgreementID());
            		result.getContract(c).removeAllOffer();
            	}
            }
            else {
            	/* The Deliverables could have been included, as the flag IncludeUniqueOffers 
            	 * could be set in RequestCleaner() */ 
                if (!cr.getIncludeDeliverables()) {
                	ESLog.debug("... remove the unwanted deliverables now" );
                    // offers are included but deliverable not
                	for (int c=0; c<result.getContractCount();c++) {
                		for (int s=0; s<result.getContract(c).getOfferCount();s++){
                			// Delete the deliverables underneath the offer 
                			ESLog.debug("... remove all deliverables for offer code " + 
                			result.getContract(c).getOffer(s).getOfferCode());
                			result.getContract(c).getOffer(s).removeAllDeliverable();
                		}
                	}
                }
            }
        }
    	//End WITS.1464
    	
    	/*
    	 * Adding customer identification
    	 */
    	if(cr.isIncludeCustomerIdentificationInformation() && cqsReply.getCUSTOMERIDENTIFICATION() != null )  {
    		result.setCustomerIdentification(MetroCustomerIdentificationTypeMapper.mapCUSTOMERIDENTIFICATION(cqsReply.getCUSTOMERIDENTIFICATION()));
    	}
    	// now we set the summary fields at the top
	    result.setActiveContractEntitlement(MappingUtils.mapToBoolean(cqsReply.getACTIVECONTRACTENTITLEMENT()));
	    result.setOverallContractEndDate(MappingUtils.mapToCastorDate(cqsReply.getOVERALLCONTRACTENDDATE()));
	    result.setOverallContractStartDate(MappingUtils.mapToCastorDate(cqsReply.getOVERALLCONTRACTSTARTDATE()));
	    return result;
    }




}
