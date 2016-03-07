package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.List;

import org.exolab.castor.types.Date;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZOFFERINFO;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYOFFERINFO;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.types.StatusType;
import com.hp.es.xml.service.types.WarrantyTypeType;

class MetroOfferMapper extends OfferMapper {

	MetroOfferMapper(WarrantyTransaction transaction,
			Date entitlementCheckDate, OOSComplexType oos,
			XMLIdGenerator XMLIdGenerator, WarrantyTypeType warrantyType) {
		super(transaction, entitlementCheckDate, oos, XMLIdGenerator, warrantyType);
	}

    /**
     * map
     * @return
     * @throws MappingException
     */
    OfferComplexType[] map() throws MappingException {
    	if(_transaction == null) {
    		return new OfferComplexType[0];
    	}

    	ZOFFERINFO swopOffers = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOFFERINFO();
    	ArrayList offerList = new ArrayList(); 
     	ESLog.debug("Mapping in total (BW & FR): " + swopOffers.getItem().size() + " offers ...");
     	
    	List<ZWTYOFFERINFO> enumeration = swopOffers.getItem();
    	for (ZWTYOFFERINFO swopOffer : enumeration) {
    		// check if we have an offer obligation type. It must be available and the
    		// content must be FR or BW, otherwise it is an invalid SWOP result.
    		ESLog.debug("getOFFEROBLIGATIONTYPE: " + swopOffer.getOFFEROBLIGATIONTYPE());
    		if(swopOffer.getOFFEROBLIGATIONTYPE() == null) {
    	     	ESLog.error("SWOP returned an empty offer obligation type");
    			throw new MappingException("Invalid SWOP result - Mandatory field OfferObligationType return from SWOP is null");
    		}
    		ESLog.debug("WarrantyTypeType.FR String: " + WarrantyTypeType.FR.toString());
    		ESLog.debug("WarrantyTypeType.BW String: " + WarrantyTypeType.BW.toString());
    		if(swopOffer.getOFFEROBLIGATIONTYPE() != null && 
    				!(WarrantyTypeType.FR.toString().equalsIgnoreCase(swopOffer.getOFFEROBLIGATIONTYPE()) ||
    				 WarrantyTypeType.BW.toString().equalsIgnoreCase(swopOffer.getOFFEROBLIGATIONTYPE()))) {
    			// if we have something other than FR or BW we also throw an expection
    	     	ESLog.error("SWOP returned another offer obligation type than FR or BW: " + swopOffer.getOFFEROBLIGATIONTYPE());
    			throw new MappingException("Invalid SWOP result - OfferObligationType from SWOP is NOT type FR or BW: " + swopOffer.getOFFEROBLIGATIONTYPE());
    		}
    		
    		// added only the offers which have the same obligation type as the warranty type
    		if(swopOffer.getOFFEROBLIGATIONTYPE() != null && (_warrantyType.toString().equalsIgnoreCase(swopOffer.getOFFEROBLIGATIONTYPE()))) {
    			offerList.add(mapOffer(swopOffer));
    		}
    	}
    	return (OfferComplexType[]) offerList.toArray(new OfferComplexType[0]);
    }

    /**
     * mapOffer
     * @param swopOffer
     * @return
     * @throws MappingException
     */
    private OfferComplexType mapOffer(ZWTYOFFERINFO swopOffer) throws MappingException {

     	ESLog.debug("Mapping offer: " + swopOffer.getOFFERPRODUCTID());
     	OfferComplexType offer = new OfferComplexType();
     	offer.setId(_XMLIdGenerator.nextId());
     	offer.setOfferCode(MappingUtils.nullString(swopOffer.getOFFERPRODUCTID()));
     	offer.setOfferDescription(swopOffer.getOFFERDESC());

     	// Modifier
     	
     	ModifierMapper mm = new MetroModifierMapper(swopOffer.getMODIFIER().getItem());
     	offer.setModifier(mm.map());
     	
     	// Deliverable
     	DeliverableMapper dm = new MetroDeliverableMapper(swopOffer.getDELIVERABLE().getItem());
     	offer.setDeliverable(dm.map());
     	
     	// AppliesTo
     	offer.setAppliesTo(mapAppliesTo(swopOffer));     	
     	
        return offer;
    }

    /**
     * mapAppliesTo()
     * @return
     */
    private AppliesTo[] mapAppliesTo(ZWTYOFFERINFO swopOffer){
    	
     	ESLog.debug("Mapping appliesTo");
     	
     	AppliesTo appliesTo = new AppliesTo();
     	appliesTo.setOOSRef(_oos);
    	appliesTo.setOOSKey(MappingUtils.stripLeadingZeroes(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getOOSKEY()));
    	appliesTo.setStartDate(MappingUtils.mapToCastorDate(swopOffer.getOFFERSTARTDATE()));
    	appliesTo.setEndDate(MappingUtils.mapToCastorDate(swopOffer.getOFFERENDDATE()));
    	appliesTo.setStatus(MappingUtils.getStatus(MappingUtils.mapToCastorDate(swopOffer.getOFFERSTARTDATE()),
    						   MappingUtils.mapToCastorDate(swopOffer.getOFFERENDDATE()), 
    						   _entitlementCheckDate));
    	if(appliesTo.getStatus() == StatusType.A) {
    		appliesTo.setActiveAppliesTo(true);
    	} else {
    		appliesTo.setActiveAppliesTo(false);
    	}
    	AppliesTo[] appliesToList = new AppliesTo[1];
    	appliesToList[0] = appliesTo;
    	return appliesToList;
    }	

}
