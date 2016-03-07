package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBLIGATIONHEADERV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSSERVICE;
import com.hp.es.service.contractEntitlement.keys.ServiceKey;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ServiceItem;
import com.hp.es.xml.service.types.ContractStatusType;

class MetroObligationHeaderMapper extends ObligationHeaderMapper {



	MetroObligationHeaderMapper(Object header, XMLIdGenerator generator, HashMap<?, ?> offerMap, EsReplyContext ctx) {
    	super(header,generator,offerMap, ctx);
	}
	
	/*
	 * @return obligation header mapped
	 */
	ObligationHeader map() throws MappingException {
		ZESCQSOBLIGATIONHEADERV1 headerTmp= (ZESCQSOBLIGATIONHEADERV1)_header;
    	ESLog.debug("Mapping source obligation id: " + headerTmp.getSOURCEOBLIGATIONID());
    	ObligationHeader oHeader = new ObligationHeader();

    	
    	oHeader.setActiveObligation(MappingUtils.mapToBoolean(headerTmp.getACTIVEOBLIGATION()));
        oHeader.setCCRN(MappingUtils.nullString(headerTmp.getCCRN()));
        oHeader.setChannelProfile(MappingUtils.nullString(headerTmp.getCHANNELPROFILE()));
        oHeader.setChannelRelationship(MappingUtils.nullString(headerTmp.getCHANNELRELATIONSHIP()));
        
        oHeader.setContractStatus(ContractStatusType.valueOf(MappingUtils.nullString(headerTmp.getCONTRACTSTATUS())));
        oHeader.setCustPurchaseOrder(MappingUtils.nullString(headerTmp.getCUSTPURCHASEORDER()));
        oHeader.setDeliveryBlock(MappingUtils.nullString(headerTmp.getDELIVERYBLOCK()));
        oHeader.setHeaderStartDate(MappingUtils.mapToCastorDate(headerTmp.getHEADERSTARTDATE()));
        oHeader.setHeaderEndDate(MappingUtils.mapToCastorDate(headerTmp.getHEADERENDDATE()));
        oHeader.setObligationType(MappingUtils.nullString(headerTmp.getOBLIGATIONTYPE()));
        oHeader.setOriginatingOrder(MappingUtils.nullString(headerTmp.getORIGINATINGORDER()));
        oHeader.setSourceObligationID(MappingUtils.nullString(headerTmp.getSOURCEOBLIGATIONID()));
        oHeader.setServiceItem(mapServiceItem(oHeader.getSourceObligationID()));
 
        oHeader.setSpecialInstructions(MappingUtils.nullString(headerTmp.getSPECIALINSTRUCTIONS()));
        
//        String specialInst = headerTmp.getSPECIAL_INSTRUCTIONS().replaceAll("\r\n", "\n\r");
//        oHeader.setSpecialInstructions(MappingUtils.nullString(specialInst));
        
        
        oHeader.setSoftwareServiceLevelCategory(MappingUtils.nullString(headerTmp.getSWSERVICELEVELCATEGORY()));

    	return oHeader;
    }
	
	/*
	 * Map service Item
	 * @return ServiceItem[] 
	 */
	protected ServiceItem[] mapServiceItem(String sourceObligationId) {

		
		ServiceItem[] items    = null;
		ESLog.debug("Mapping Services Items");
		ZESCQSOBLIGATIONHEADERV1 headerTmp= (ZESCQSOBLIGATIONHEADERV1)_header;
		List<ZESCQSSERVICE>    services = headerTmp.getSERVICES().getItem();
		ArrayList<ServiceItem> listServiceItem = new ArrayList<ServiceItem>();
		
		ESLog.debug("Mapping Service Items");
		for (ZESCQSSERVICE service : services) {
			ServiceItem item = new ServiceItem();
			//Get and cast the service
			ESLog.debug("Mapping Service Item" + service.getASSOCIATEDPKGITEM());
			item.setAssociatedPkgItem(MappingUtils.nullString(service.getASSOCIATEDPKGITEM()));
			item.setItem(MappingUtils.nullString(service.getITEM()));
			OfferComplexType offtmp = (OfferComplexType)_offerMap.get(service.getITEM());
			item.setOfferRef(offtmp);
			listServiceItem.add(item);
			if(_ctx != null) {
				String itemKey               = service.getITEM();
				ServiceKey key = new ServiceKey(sourceObligationId, itemKey);
		        _ctx.addServiceItem(key,item);
		        //The following two lines are for PoP. The column is from table "service"
		        String serviceStartDateEligibility = MappingUtils.nullString(service.getWTYSTARTDATEELIGIBILITY());
		        if (serviceStartDateEligibility != null) {
		            _ctx.addSvcWtyStartDateEligibility(key, serviceStartDateEligibility);
		        }		        
			}
		}

		items = listServiceItem.toArray(new ServiceItem[0]);
		return items;
	}


}
