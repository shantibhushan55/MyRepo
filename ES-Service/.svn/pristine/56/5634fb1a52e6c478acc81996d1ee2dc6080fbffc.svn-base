/**
 * 
 */
package com.hp.es.service.unitEventHistory.integration.mapping;

import java.util.List;

import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWTYEVENTDETAILS;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWTYEVENTHISTORY;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWTYUNITEVENT;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWTYWUEEVENT;
import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EventDetailsComplexType;
import com.hp.es.xml.service.EventDetailsComplexTypeChoice;
import com.hp.es.xml.service.PartComplexType;
import com.hp.es.xml.service.PartExchangeComplexType;
import com.hp.es.xml.service.PartExchangeList;
import com.hp.es.xml.service.UnitComplexType;
import com.hp.es.xml.service.UnitEvent;
import com.hp.es.xml.service.UnitEventHistoryComplexType;
import com.hp.es.xml.service.WholeUnitExchangeComplexType;

/**
 * @author ANVOI
 *
 */
class MetroUnitEventHistoryComplexTypeMapper extends
		UnitEventHistoryComplexTypeMapper {

	//disable cosntructor
	private MetroUnitEventHistoryComplexTypeMapper() {
		
	}
	/**
	 * @param transaction
	 */
	public MetroUnitEventHistoryComplexTypeMapper(
			UnitEventHistoryTransaction transaction) {
		super(transaction);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.unitEventHistory.integration.UnitEventHistoryComplexTypeMapper#mapUnitEventHistoryComplexType()
	 */
	@Override
	protected UnitEventHistoryComplexType mapUnitEventHistoryComplexType()
			throws MappingException {
		UnitEventHistoryComplexType uect= new UnitEventHistoryComplexType();
		
		ZWTYEVENTHISTORY tmp = (ZWTYEVENTHISTORY)_transaction.getSourceSystemStandardReply();
		uect.setUnitProductId(MappingUtils.nullString(tmp.getPRODUCTNUMOUT()));
		uect.setUnitSerialNumber(MappingUtils.nullString(tmp.getSERIALNUMOUT()));
		
		/*
		 * Mapping the unit Events
		 */
		List<ZWTYUNITEVENT> sapUnitEvents = tmp.getUNITEVENT().getItem();		
        if (sapUnitEvents != null) {
            for (ZWTYUNITEVENT sapUnitEvent : sapUnitEvents) {          	
            	uect.addUnitEvent(mapUnitEvent(sapUnitEvent));               
            }
        }		
		return uect;
	}
	
	/*
	 * Mapping one unit Events
	 */
	private UnitEvent mapUnitEvent(ZWTYUNITEVENT sapUnitEvent) throws MappingException{
		ESLog.debug(":: mapping UnitEvent");
		UnitEvent unitEvent= new UnitEvent();	
		unitEvent.setEventCreationDate		(MappingUtils.nullString(sapUnitEvent.getCREATEDATE()));
		unitEvent.setEventCountryCode		(MappingUtils.nullString(sapUnitEvent.getEVENTCOUNTRYCODE()));
		unitEvent.setEventCreationDate		(MappingUtils.nullString(sapUnitEvent.getEVENTDATE()));
		unitEvent.setEventId				(MappingUtils.nullString(sapUnitEvent.getEVENTID()));
		unitEvent.setProductId				(MappingUtils.nullString(sapUnitEvent.getEVENTPRODUCTNUM()));
		unitEvent.setSerialNumber			(sapUnitEvent.getEVENTSERIALNUM());
		unitEvent.setEventType(MappingUtils.nullString(sapUnitEvent.getEVENTTYPE()));
		unitEvent.setCustomerOwnershipType(MappingUtils.nullString(sapUnitEvent.getOWNERSHIPTYPE()));
		unitEvent.setEventSourceSystemId(MappingUtils.nullString(sapUnitEvent.getSRCSYS()));
		unitEvent.setEventSourceSystemTransactionId(MappingUtils.nullString(sapUnitEvent.getSRCSYSTRANSID()));
			
		/*
		 * Map the event details
		 */
		List<ZWTYEVENTDETAILS> sapUnitEventDetails = sapUnitEvent.getEVENTDETAILS().getItem();			
        if (sapUnitEventDetails  != null) {
            for (ZWTYEVENTDETAILS sapUnitEventDetail : sapUnitEventDetails) {          	
            	unitEvent.addEventDetails(mapUnitEventDetails(sapUnitEventDetail));               
            }
        }		
        
		return unitEvent;
	}
	/*
	Map one event details
	*/ 
	private EventDetailsComplexType mapUnitEventDetails(
			ZWTYEVENTDETAILS sapEventDetails) throws MappingException {
		ESLog.debug(":: mapping UnitEventDetails");

		EventDetailsComplexType eventDetails = new EventDetailsComplexType();
		eventDetails.setCode(MappingUtils.nullString(sapEventDetails.getCODE()));
		eventDetails.setDescription(MappingUtils.nullString(sapEventDetails.getDESCRIPTION()));

		//eventDetails.setEventDuration(MappingUtils.mapBigIntegerToInt(sapEventDetails.getDURATION()));
		eventDetails.setEventDuration(sapEventDetails.getDURATION());

		PartExchangeList partExchangeList = null;
		WholeUnitExchangeComplexType wueCT = null;

		/*
		 * Map the part exchange
		 */
		ZWTYWUEEVENT sapPartExchange = sapEventDetails.getPARTEXCHANGE();
		if (sapPartExchange  != null && ((sapPartExchange.getORIGINALPN()!=null &&sapPartExchange.getORIGINALPN().trim().length()>0) 
				||(sapPartExchange.getORIGINALSN()!=null&&sapPartExchange.getORIGINALSN().trim().length()>0)
				||(sapPartExchange.getREPLACEMENTPN()!=null&&sapPartExchange.getREPLACEMENTPN().trim().length()>0)
				||(sapPartExchange.getREPLACEMENTSN()!=null &&sapPartExchange.getREPLACEMENTSN().trim().length()>0) )) {
			

			ESLog.debug(":: mapping PartExchange");
			partExchangeList = new PartExchangeList();
			
			partExchangeList.addPartExchange(mapPartExchange(sapPartExchange));

			//we may have a schema issue here
			eventDetails.setEventDetailsComplexTypeChoice(new EventDetailsComplexTypeChoice());
			eventDetails.getEventDetailsComplexTypeChoice().setPartExchangeList(partExchangeList);
		}
		


		
		ZWTYWUEEVENT sapWUExchange = sapEventDetails.getWUE();
		if (sapWUExchange != null && (
				(sapWUExchange.getORIGINALPN()!=null &&sapWUExchange.getORIGINALPN().trim().length()>0) 
				||(sapWUExchange.getORIGINALSN()!=null&&sapWUExchange.getORIGINALSN().trim().length()>0)
				||(sapWUExchange.getREPLACEMENTPN()!=null&&sapWUExchange.getREPLACEMENTPN().trim().length()>0)
				||(sapWUExchange.getREPLACEMENTSN()!=null &&sapWUExchange.getREPLACEMENTSN().trim().length()>0))) {
			wueCT = new WholeUnitExchangeComplexType();
			ESLog.debug(":: mapping WUE");
			UnitComplexType originalUCT = new UnitComplexType();
			UnitComplexType replacedUCT = new UnitComplexType();

			originalUCT.setProductId(MappingUtils.nullString(sapWUExchange.getORIGINALPN()));
			originalUCT.setSerialNumber(MappingUtils.nullString(sapWUExchange.getORIGINALSN()));
			
			ESLog.debug(":: mapping WUE::originalUCT.getSerialNumber()=" + originalUCT.getSerialNumber()
					+ " ::originalUCT.getProductId()=" +originalUCT.getProductId());
			replacedUCT.setProductId(MappingUtils.nullString(sapWUExchange.getREPLACEMENTPN()));
			replacedUCT.setSerialNumber(MappingUtils.nullString(sapWUExchange.getREPLACEMENTSN()));
			
			ESLog.debug(":: mapping WUE::replacedUCT.getSerialNumber()=" + replacedUCT.getSerialNumber()
					+ " ::replacedUCT.getProductId()=" +replacedUCT.getProductId());

			wueCT.setOriginalUnit(originalUCT);
			wueCT.setReplacedUnit(replacedUCT);
			
			//we may have a schema issue here
			eventDetails.setEventDetailsComplexTypeChoice(new EventDetailsComplexTypeChoice());
			eventDetails.getEventDetailsComplexTypeChoice().setWholeUnitExchange(wueCT);
		}


		return eventDetails;
	}
	
	
	private PartExchangeComplexType mapPartExchange(ZWTYWUEEVENT sapPartExchange) {

		PartExchangeComplexType partExchangeCT = new PartExchangeComplexType();
		
		PartComplexType originalPart = new PartComplexType();
		PartComplexType replacementPart = new PartComplexType();
		
		originalPart.setPartNumber(MappingUtils.nullString(sapPartExchange.getORIGINALPN()));
		originalPart.setPartSerialNumber(MappingUtils.nullString(sapPartExchange.getORIGINALSN()));
		ESLog.debug(":: mapping PartExchange::originalPart.getPartSerialNumber()=" + originalPart.getPartSerialNumber()
				+ " ::originalPart.getPartNumber()=" +originalPart.getPartNumber());
		
		replacementPart.setPartNumber(MappingUtils.nullString(sapPartExchange.getREPLACEMENTPN()));
		replacementPart.setPartSerialNumber(MappingUtils.nullString(sapPartExchange.getREPLACEMENTSN()));
		
		ESLog.debug(":: mapping PartExchange::replacementPart.getPartSerialNumber()=" + replacementPart.getPartSerialNumber()
				+ " ::replacementPart.getPartNumber()=" +replacementPart.getPartNumber());

		partExchangeCT.setOriginalPart(originalPart);
		partExchangeCT.setReplacedPart(replacementPart);
		
		return partExchangeCT;
	}
	
}
