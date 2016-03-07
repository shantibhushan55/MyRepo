package com.hp.es.service.warrantyEntitlement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYINFO;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.types.PortfolioFlagType;
import com.hp.es.xml.service.types.WarrantyTypeType;

class MetroWarrantyMapper extends WarrantyMapper {

	MetroWarrantyMapper(WarrantyTransaction transaction,
			Date entitlementCheckDate, OOSComplexType oos,
			XMLIdGenerator XMLIdGenerator) {
		super(transaction, entitlementCheckDate, oos, XMLIdGenerator);

	}

    WarrantyComplexType[] map() throws MappingException{
    	if(_transaction == null) {
    		return new WarrantyComplexType[0];
    	}
    	
    	ZWTYWTYINFO swopWarranty = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO();
    	
    	if(swopWarranty == null) {
    		return new WarrantyComplexType[0];
    	}

    	// check if we have an empty reply 
    	if(!_transaction.isSuccessfull()) {
    		return new WarrantyComplexType[0];
    	}
    	
    	WarrantyComplexType[] warrantyList = null;
    	// check if we have a WarrantyBundleID. If this is the case then
    	// we need to create 2 WarrantyComplexTypes. 1 for FR and 1 for BW
    	if((swopWarranty.getWARRANTYBUNDLEID() != null) && 
    			(swopWarranty.getWARRANTYBUNDLEID().trim().length() > 0)) {
        	ESLog.debug("We need to create BW and FR warranty objects");
        	warrantyList = new WarrantyComplexType[2];
        	warrantyList[1] = mapWarranty(swopWarranty, WarrantyTypeType.BW);
    	} else {
        	ESLog.debug("We need to create only an FR warranty object");
        	warrantyList = new WarrantyComplexType[1];
    	}
    	warrantyList[0] = mapWarranty(swopWarranty, WarrantyTypeType.FR);
        return warrantyList;
    }
    	
    protected WarrantyComplexType mapWarranty(ZWTYWTYINFO swopWarranty, WarrantyTypeType warrantyType) throws MappingException {
    	ESLog.debug("Mapping warranty object");
    	WarrantyComplexType warranty = new WarrantyComplexType();
    	warranty.setWarrantyType(warrantyType);
    	warranty.setPortfolioFlag(PortfolioFlagType.G);
    	warranty.setWarrantyComment(MappingUtils.nullString(swopWarranty.getINELIGIBLEREASONDESC()));
    	warranty.setWarrantyDeterminationCode(WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode(swopWarranty.getSOURCEDATEFORWARRANTYSTART()));
    	warranty.setWarrantyDeterminationDescription(WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription(swopWarranty.getSOURCEDATEFORWARRANTYSTART()));
    	warranty.setWarrantyStartDate(MappingUtils.mapToCastorDate(swopWarranty.getWARRANTYSTARTDATE()));
    	warranty.setGracePeriod(MappingUtils.stringToInt(swopWarranty.getGRACEPERIOD()));
    	// currently this is not implemented in the SWOP interface it will be
    	// left empty for now. It is documented in the SWOP documentation, that this is 
    	// a future field
    	// warranty.setUpgradeable(false);
    	if(warrantyType == WarrantyTypeType.FR) {
    		warranty.setTermCode(MappingUtils.nullString(swopWarranty.getWARRANTYID()));
        	warranty.setGlobal(MappingUtils.mapToBoolean(swopWarranty.getGLOBALFLAG()));
        	warranty.setInstallationIncluded(MappingUtils.mapToBoolean(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getPRODUCTINFO().getINSTALLATIONFLAG()));
        	warranty.setSitePreparation(MappingUtils.mapToBoolean(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getPRODUCTINFO().getSITEPREPARATION()));
        	warranty.setWarrantyExtension("" + MappingUtils.stringToInt(swopWarranty.getWARRANTYEXTENSION()));
    	} else {
    		warranty.setTermCode(MappingUtils.nullString(swopWarranty.getWARRANTYBUNDLEID()));
    	}
    	
    	// Offer
    	if(MappingUtils.mapToBoolean(swopWarranty.getWARRANTYINELIGIBLEINDICATOR()) == true) {
    		warranty.setOffer(new OfferComplexType[0]);
    	} else {
    		OfferMapper om = OfferMapper.getInstance(_transaction, _entitlementCheckDate, _oos, _XMLIdGenerator, warrantyType);
    		warranty.setOffer(om.map());
    	}
    	return warranty;
    }


}
