package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.ObligHeaderLocation;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCONTRACTV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENTITLEMENTREPLYV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBLIGATIONCONTACT;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBLIGATIONHEADERV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBLIGATIONLOCATION;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOOS;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSSERVICE;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESPRODUCTTYPE;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.sif.SifException;

class MetroContractMapper extends ContractMapper{

    // For Customer Indicator we need the reference of ObligationHeader to Location
	private HashMap oHeadLocMap = null;
	
	
	MetroContractMapper(ContractTransaction transaction, XMLIdGenerator generator, Map oosMap, Map locationMap, Map contactMap, Map oosKeyListMapbyOOSGroupId, EsReplyContext ctx) {
		super(transaction, generator, oosMap, locationMap, contactMap, oosKeyListMapbyOOSGroupId, ctx);
		oHeadLocMap = new HashMap();
	}

	ContractComplexType[] map(boolean includeOffers, boolean includeDeliverables, boolean  includeModifiers, boolean includeContact, boolean includeLocation, boolean includeOOSes) throws MappingException, SifException {

    	if(_transaction == null) {
    		return new ContractComplexType[0];
    	}
    	
    	Collection sapContracts = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getCONTRACTS().getItem();
        ContractComplexType[] contracts = new ContractComplexType[sapContracts.size()];
        
        Collection sapOOSes = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getOOS().getItem();

        ESLog.debug("Mapping " + contracts.length + " contracts ...");
        int i=0;
        //we go through all sap contracts
        for (Iterator it=sapContracts.iterator(); it.hasNext(); ) {
            contracts[i++] = mapContract((ZESCQSCONTRACTV1) it.next(),sapOOSes, includeOffers, includeDeliverables, includeModifiers,includeContact, includeLocation, includeOOSes);
        }

        // For Customer Indicator we need the reference of ObligationHeader to Location
    	_transaction.setOHeadLocMap(getOHeadLocMap());

        return contracts;
	}

    protected ContractComplexType mapContract(ZESCQSCONTRACTV1 input,Collection sapOOSes,boolean includeOffers, boolean includeDeliverables, boolean  includeModifiers,boolean includeContact, boolean includeLocation, boolean includeOOSes) throws MappingException, SifException {

    	ESLog.debug("Mapping contract: " + input.getSVCAGREEMENTID());
        ContractComplexType contract = new ContractComplexType();

        // Add code to map contract fields
        contract.setPortfolioFlag( MappingUtils.nullString(input.getPORTFOLIOFLAG()));
        contract.setSvcAgreementID(MappingUtils.nullString(input.getSVCAGREEMENTID()));
        contract.setActiveContractEntitlement(MappingUtils.mapToBoolean(input.getACTIVECONTRACTENTITLEMENT()));
        contract.setHeaderStartDate(MappingUtils.mapToCastorDate(input.getHEADERSTARTDATE()));
        contract.setHeaderEndDate(MappingUtils.mapToCastorDate(input.getHEADERENDDATE()));
        
        
        ZESCQSOBLIGATIONHEADERV1 lastHeader =  getLatestObligationHeader(input);
        ZESCQSOOS firstOOS =  getFirstOOS(sapOOSes );
        
        contract.setAMPID(MappingUtils.nullString(lastHeader.getAMPID()));
        
        /*
         * Those fields only apply for blue

        contract.setBlueSupportLevelForSGID()
        contract.setBlueSupportLevelForSGIDSource()
         */
        
        contract.setCCRN(getUniqueCCRN(input));
        contract.setCdoPublishDate(MappingUtils.nullString(lastHeader.getCDOPUBLISHDATE()));
        
        contract.setCustomerSegment(MappingUtils.nullString(lastHeader.getCUSTOMERSEGMENT()));
        contract.setCustServiceAgreement(MappingUtils.nullString(lastHeader.getCUSTSERVICEAGREEMENT()));
        if(includeOOSes && firstOOS != null) {
        	contract.setDataEntrySite(MappingUtils.nullString(firstOOS.getDATAENTRYSITE()));
        }
        
        
       
        
        /* Blue not mapped
        contract.setOOSGroupID()
        contract.setMissionCritical()
        contract.setPenalty()
        contract.setRCXDescription()
        contract.setRCXResponsibleEngineer()
        contract.setRCXResponsibleEngineer()
        contract.setRCXServiceLevel()
        contract.setSysModel()
        contract.setSysType()                 
        */
        contract.setSpecialHandling(getSpecialHandling(input));
        contract.setSupportGroupID(MappingUtils.nullString(lastHeader.getSUPPORTGROUPID()));

        

        
        /*
         * Contract identifier for pmCPQ contracts only
        contract.setRedContractID()
        */
        
        
 
        
        
        List<ZESPRODUCTTYPE> enumSvc =  input.getSVCPRODUCTTYPES().getItem();
        
        //adding svc product type
        for (ZESPRODUCTTYPE zesproducttype : enumSvc) {
            contract.addSvcProductType(MappingUtils.nullString(zesproducttype.getSVCPRODUCTTYPE()));
        }       
        // Add code to map ObligationHeaders
        List<ZESCQSOBLIGATIONHEADERV1> enumObj = input.getOBLIGATIONHEADERS().getItem();
        HashMap offerForThisObligation = new HashMap();
        //a hash map for obligation offer
        for (ZESCQSOBLIGATIONHEADERV1 header : enumObj) {
        	//WE map the PRODUCT_SHIP_TO_COUNTRY_CODE
        	contract.setProductShipToCountryCode(MappingUtils.nullString(header.getPRODUCTSHIPTOCOUNTRYCODE()));
        	mapAddressAndLocation(contract,header, includeContact, includeLocation);
        	
        	if(includeOffers) {
	        	List<ZESCQSSERVICE> serviceList = header.getSERVICES().getItem();

	        	ESLog.debug("Creating"+header.getSERVICES().getItem().size()+" offers.");
	        	for (ZESCQSSERVICE service : serviceList) {
	        		ESLog.debug("Creating offer " +service.getITEM() + " for obligation "+header.getSOURCEOBLIGATIONID());
	        		OfferMapper mapper = new MetroOfferMapper(service, _XMLIdGenerator, _oosMap, _oosKeyListMapbyOOSGroupId, _ctx, getFirstOOS(sapOOSes));
	        		OfferComplexType offerTmp = mapper.map(includeDeliverables, includeModifiers, header.getSOURCEOBLIGATIONID()); 
	        		contract.addOffer(offerTmp);
	        		offerForThisObligation.put(service.getITEM(),offerTmp);
	        	}
        	}
        	
        	
        	ObligationHeaderMapper mapper = new MetroObligationHeaderMapper(header,_XMLIdGenerator,offerForThisObligation, _ctx);
        	//Adding the obligation header
        	ObligationHeader ohTmp = mapper.map();
        	contract.addObligationHeader(mapper.map());
        	if(_ctx != null) { 
        		ObligationHeaderKey key = new ObligationHeaderKey(ohTmp.getSourceObligationID());
                _ctx.addObligationHeader(key, ohTmp);
                _ctx.addContract(key, contract);
        	}
        	offerForThisObligation.clear();

        }
        

        
        return contract;
    }


    /*
     * Gte the special handling (true if at least one is true.
     */
	protected boolean getSpecialHandling(ZESCQSCONTRACTV1 cqsContract) {

		List<ZESCQSOBLIGATIONHEADERV1> enumHeader = cqsContract.getOBLIGATIONHEADERS().getItem(); 
		for (ZESCQSOBLIGATIONHEADERV1 tmp : enumHeader) {
			if(MappingUtils.mapToBoolean(tmp.getSPECIALHANDLING())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This gets the CCRN only if unique (else returns null)
	 */
	protected String getUniqueCCRN(ZESCQSCONTRACTV1 cqsContract) {
		String ccrn = null;
		List<ZESCQSOBLIGATIONHEADERV1> enumHeader = cqsContract.getOBLIGATIONHEADERS().getItem(); 
		for (ZESCQSOBLIGATIONHEADERV1 tmp : enumHeader) {
			if(ccrn == null) {
				ccrn = tmp.getCCRN();
			}
			if(ccrn.compareToIgnoreCase(tmp.getCCRN()) != 0) {
				return null;
			}
		}
		return ccrn;
	}

	/*
	 * This gets the first oos
	 */
	protected ZESCQSOOS getFirstOOS(Collection sapOOSes) {
		ZESCQSOOS first = null;
		if(sapOOSes != null && !sapOOSes.isEmpty()) {
			Iterator it = sapOOSes.iterator();
			//If not empty we can do that safely
			first = (ZESCQSOOS)it.next();
			
		} 
		return first;
	}


	/**
	 * Maps the IDs and References for the contact and location into the contract
	 * @param contract
	 * @param header
	 * @param includeContact
	 * @param includeLocation
	 * @throws SifException
	 */
	protected void mapAddressAndLocation(ContractComplexType contract, ZESCQSOBLIGATIONHEADERV1 header,boolean includeContact, boolean includeLocation) throws SifException {

		// Note: The ID on the header level needs to be always set. Only the references will be set if the request
		//       had the include flag set to true
		
		// CONTACT
		if(header.getOBLIGATIONCONTACT() != null) {
			List<ZESCQSOBLIGATIONCONTACT> enumOBLIGATION_CONTACT = header.getOBLIGATIONCONTACT().getItem();
			for (ZESCQSOBLIGATIONCONTACT contact : enumOBLIGATION_CONTACT) {
				// SYSTEM MGR
				if("SystemMgr".equalsIgnoreCase(contact.getOBLIGCONTACTROLE())) {
					contract.setSystemMgrPersonID(contact.getOBLIGSOURCEPERSONID());
					if(includeContact) {
						contract.setSystemMgrPersonRef(_contactMap.get(contact.getOBLIGSOURCEPERSONID()));
					}
				// SW SHIP TO
				} else if("SWShipTo".equalsIgnoreCase(contact.getOBLIGCONTACTROLE())) { 
					contract.setSWShipToPersonID(contact.getOBLIGSOURCEPERSONID());
					if(includeContact) {
						contract.setSWShipToPersonRef(_contactMap.get(contact.getOBLIGSOURCEPERSONID()));
					}
				// HW SHIP TO
				} else if("HWShipTo".equalsIgnoreCase(contact.getOBLIGCONTACTROLE())) {
					contract.setHWShipToPersonID(contact.getOBLIGSOURCEPERSONID());
					if(includeContact) {
						contract.setHWShipToPersonRef(_contactMap.get(contact.getOBLIGSOURCEPERSONID()));
					}
				// HP ADMIN
				} else if("Admin".equalsIgnoreCase(contact.getOBLIGCONTACTROLE())) {
					ESLog.info("++++++++++++++++++++Admin ++++++++++++++++");
					contract.setHPAdminPersonID(contact.getOBLIGSOURCEPERSONID());
					if(includeContact) {
						contract.setHPAdminPersonRef(_contactMap.get(contact.getOBLIGSOURCEPERSONID()));
					}
				// ORDERER
				} else if("Orderer".equalsIgnoreCase(contact.getOBLIGCONTACTROLE())) {
					contract.setOrdererPersonID(contact.getOBLIGSOURCEPERSONID());
					if(includeContact) {
						contract.setOrdererPersonRef(_contactMap.get(contact.getOBLIGSOURCEPERSONID()));
					}
				}
			}
		}

		// LOCATION
		if(header.getOBLIGATIONLOCATION() != null) {
			List<ZESCQSOBLIGATIONLOCATION> enumOBLIGATION_LOCATION = header.getOBLIGATIONLOCATION().getItem();
			for (ZESCQSOBLIGATIONLOCATION location : enumOBLIGATION_LOCATION) {
				// SOLD TO
				if("SoldTo".equalsIgnoreCase(location.getOBLIGADDRROLE())) {
					contract.setSoldToCustomerID(location.getOBLIGSOURCECUSTOMERID());
					if(includeLocation) {
						contract.setSoldToCustomerRef(_locationMap.get(location.getOBLIGSOURCECUSTOMERID()));
					}
					
					// For Customer Indicator we need the reference of ObligationHeader to Location
	          	  	ObligHeaderLocation oHeadLoc = new ObligHeaderLocation();
	          	  	oHeadLoc.setSourceObligationId(header.getSOURCEOBLIGATIONID());
	          	  	oHeadLoc.setSourceCustomerId(location.getOBLIGSOURCECUSTOMERID());
	          	  	oHeadLoc.setObligHeaderRole(location.getOBLIGADDRROLE());
	          	  	if(!oHeadLocMap.containsKey(header.getSOURCEOBLIGATIONID())){
		          	    oHeadLocMap.put(header.getSOURCEOBLIGATIONID(),oHeadLoc);	          	  		
	          	  	}
					
					
				// SW SHIP TO
				} else if("SWShipTo".equalsIgnoreCase(location.getOBLIGADDRROLE())) { 
					contract.setSWShipToCustomerID(location.getOBLIGSOURCECUSTOMERID());
					if(includeLocation) {
						contract.setSWShipToCustomerRef(_locationMap.get(location.getOBLIGSOURCECUSTOMERID()));
					}
				// PRODUCT SHIP TO
				} else if("ProductShipTo".equalsIgnoreCase(location.getOBLIGADDRROLE())) {
					contract.setProductShipToCustomerID(location.getOBLIGSOURCECUSTOMERID());
					if(includeLocation) {
						contract.setProductShipToCustomerRef(_locationMap.get(location.getOBLIGSOURCECUSTOMERID()));
					}
				// ORDERING PARTY
				} else if("OrderingParty".equalsIgnoreCase(location.getOBLIGADDRROLE())) {
					contract.setOrderingPartyCustomerID(location.getOBLIGSOURCECUSTOMERID());
					if(includeLocation) {
						contract.setOrderingPartyCustomerRef(_locationMap.get(location.getOBLIGSOURCECUSTOMERID()));
					}
					//PSP
				}else if("PSP".equalsIgnoreCase(location.getOBLIGADDRROLE())) {
					contract.setPSPCustomerID(location.getOBLIGSOURCECUSTOMERID());					
					if(includeLocation) {
						contract.setPSPCustomerRef(_locationMap.get(location.getOBLIGSOURCECUSTOMERID()));
					}
				}
			}
		}
	}

	
	/*
	 * 
	 */
	protected ZESCQSOBLIGATIONHEADERV1 getLatestObligationHeader(ZESCQSCONTRACTV1 cqsContract) {
		ZESCQSOBLIGATIONHEADERV1 latestObligationHeader = null;
		
		List<ZESCQSOBLIGATIONHEADERV1> enumHeader = cqsContract.getOBLIGATIONHEADERS().getItem(); 
		for (ZESCQSOBLIGATIONHEADERV1 tmp : enumHeader) {
			if(latestObligationHeader == null) {
				latestObligationHeader = tmp;
			}
			Date dTmp = DateHelper.mapIsoDate2JavaDate(tmp.getCDOPUBLISHDATE());
			Date dlatest = DateHelper.mapIsoDate2JavaDate(latestObligationHeader.getCDOPUBLISHDATE());
			if (DateHelper.isGreater(dTmp,dlatest)) {
				latestObligationHeader = tmp;
				
			}
		}
		
		
		return latestObligationHeader;
	}
	
	private HashMap getOHeadLocMap() {
		return oHeadLocMap;
	}
	
}
