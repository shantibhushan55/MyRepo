package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCUSTOMERIDENTITY;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCUSTOMERSEGMENT;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCUSTOMERSEGMENTS;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.xml.service.AccountSegmentType;
import com.hp.es.xml.service.CustomerIdentificationType;

class MetroCustomerIdentificationTypeMapper {
	
	private static AccountSegmentType[] mapCQSSegmentToEsSegment(
			ZESCQSCUSTOMERSEGMENTS endcustomeramidl2segments) {
		ArrayList <AccountSegmentType>  list = new ArrayList<AccountSegmentType>  () ;

		if(endcustomeramidl2segments != null && endcustomeramidl2segments.getItem() !=null) {
			Iterator <ZESCQSCUSTOMERSEGMENT> listTmp=endcustomeramidl2segments.getItem().iterator();
			
			while(listTmp.hasNext()) {
				ZESCQSCUSTOMERSEGMENT seg = listTmp.next();
				AccountSegmentType tmpAccount = new AccountSegmentType();
				list.add(tmpAccount);
				
				tmpAccount.setAccountSegmentCode(MappingUtils.nullString(seg.getSEGMENTCODE()));
				tmpAccount.setAccountSegmentOwnerCode(MappingUtils.nullString(seg.getSEGMENTOWNERCODE()));
			}
			
		}

		AccountSegmentType[] returnArray = new AccountSegmentType[list.size()] ;
		return list.toArray(returnArray);
	}

	
	public static CustomerIdentificationType mapCUSTOMERIDENTIFICATION(
			ZESCQSCUSTOMERIDENTITY ci) {
		CustomerIdentificationType cit = null;
		if(ci != null) {
			cit = new CustomerIdentificationType();
			cit.setEndCustomerAMIDL2AccountSegment(mapCQSSegmentToEsSegment(ci.getENDCUSTOMERAMIDL2SEGMENTS()));
			cit.setEndCustomerAMIDL2Identifier(MappingUtils.nullString(ci.getENDCUSTOMERAMIDL2ID()));
			cit.setEndCustomerAMIDL3AccountSegment(mapCQSSegmentToEsSegment(ci.getENDCUSTOMERAMIDL3SEGMENTS()));
			cit.setEndCustomerAMIDL3Identifier(MappingUtils.nullString(ci.getENDCUSTOMERAMIDL3ID()));
			cit.setEndCustomerAMIDL4AccountSegment(mapCQSSegmentToEsSegment(ci.getENDCUSTOMERAMIDL4SEGMENTS()));
			cit.setEndCustomerAMIDL4Identifier(MappingUtils.nullString(ci.getENDCUSTOMERAMIDL4ID()));
			
			cit.setSiteLevelCustomerIdentifier(MappingUtils.nullString(ci.getSITELEVELCUSTOMERID()));
		}
		return cit;
	}


}
