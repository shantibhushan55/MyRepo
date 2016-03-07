package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.HashMap;
import java.util.TreeMap;

import org.exolab.castor.types.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYINFO;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.types.StatusType;
import com.hp.sif.SifException;

class MetroWarrantyEntitlementMapper extends WarrantyEntitlementMapper {

	protected MetroWarrantyEntitlementMapper(WarrantyTransaction transaction,
			EsRequestComplexType request, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply, SifException manufacturingInstalledBaseServiceSE) {
		super(transaction, request,manufacturingInstalledBaseServiceReply,  manufacturingInstalledBaseServiceSE);
	}

	 /**
     * map(). This is the entry point for mapping a complete warranty reply
     * @return
     * @throws MappingException
     */
	public WarrantyEntitlementComplexType map() throws MappingException {

    	ESLog.debug("Enter warranty mapping");		

    	WarrantyEntitlementComplexType result = new WarrantyEntitlementComplexType();

    	// Location
        if(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeAddresses() == true) {
	    	ESLog.debug("Call location mapping ...");		
	        LocationMasterMapper locationMapper =
	            new MetroLocationMasterMapper(_transaction,_XMLIdGenerator);
	        result.setLocation(locationMapper.map());
        }

        // check if we have a location and set it accordingly. 
        // This is needed for the OOS reference WarrantyShipToCustomerRef
        LocationComplexType locationObject = null;
        if(result.getLocation() != null && result.getLocationCount() > 0) {
        	locationObject = result.getLocation(0);
        } else {
        	locationObject = null;
        }
        
        // OOS
    	ESLog.debug("Call oos mapping ...");		
        OosMapper oosMapper = new MetroOosMapper(_transaction, locationObject, _XMLIdGenerator, _request);
        result.setOOS(oosMapper.map());

        // Workings 
        if(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIncludeWorkings() == true) {
	        ESLog.debug("Call workings mapping ...");		        
	        WorkingMapper workingMapper = WorkingMapper.getInstance(_transaction,_request,_manufacturingInstalledBaseServiceReply,  _manufacturingInstalledBaseServiceSE);
	        result.setWorking(workingMapper.map());
        }

        // Warranty
    	ESLog.debug("Call warranty mapping ...");		
        WarrantyMapper warrantyMapper = new MetroWarrantyMapper(_transaction, _entitlementCheckDate, 
        												result.getOOS(), _XMLIdGenerator);
        result.setWarranty(warrantyMapper.map());
         
        // set the overall status
    	ESLog.debug("Setting the overall status of the warranty reply ...");		
        HashMap<String, Date> dates = getOverallDates(result);
        if(MappingUtils.getStatus(dates.get(EsConstants.START_DATE), 
								dates.get(EsConstants.END_DATE), 
								_entitlementCheckDate) == StatusType.A) {
			result.setActiveWarrantyEntitlement(true);
		} else {
			result.setActiveWarrantyEntitlement(false);
		}													
    	ESLog.debug("Overall Status: " + result.getActiveWarrantyEntitlement());		
        result.setOverallWarrantyStartDate(dates.get(EsConstants.START_DATE));
        result.setOverallWarrantyEndDate(checkForEligibleProductAndGetWarrantyEndDate(
        									dates.get(EsConstants.START_DATE), 
        									dates.get(EsConstants.END_DATE)));
        return result;
    }


	/**
	 * getOverallDates
	 * @param result
	 * @return
	 */
	protected HashMap<String, Date> getOverallDates(WarrantyEntitlementComplexType result) {
		TreeMap<java.util.Date, java.util.Date> endDateMap = new TreeMap<java.util.Date, java.util.Date>();
		TreeMap<java.util.Date, java.util.Date> startDateMap = new TreeMap<java.util.Date, java.util.Date>();
    	ESLog.debug("result.getWarrantyCount() = " + result.getWarrantyCount());
		for(int i = 0; i < result.getWarrantyCount(); i++ ) {
	    	ESLog.debug("result.getWarranty(" + i + ").getOfferCount() = " + result.getWarranty(i).getOfferCount());
			if(result.getWarranty(i).getOfferCount() > 0) {
				for(int k = 0; k < result.getWarranty(i).getOfferCount(); k++) {
			    	ESLog.debug("result.getWarranty(" + i + ").getOffer(" + k + ") = " + result.getWarranty(i).getOffer(k));
					for(int m = 0; m < result.getWarranty(i).getOffer(k).getAppliesToCount(); m++) {
				    	ESLog.debug("result.getWarranty(" + i + ").getOffer(" + k + ").getAppliesToCount() " + result.getWarranty(i).getOffer(k).getAppliesToCount());
				    	java.util.Date startDateTmp = MappingUtils.mapCastorToJavaDate(result.getWarranty(i).getOffer(k).getAppliesTo(m).getStartDate());
						startDateMap.put(startDateTmp,startDateTmp);
						
						java.util.Date endDateTmp = MappingUtils.mapCastorToJavaDate(result.getWarranty(i).getOffer(k).getAppliesTo(m).getEndDate());
						
						endDateMap.put(endDateTmp,endDateTmp);
					}
				}
			} else {
				ZWTYWTYINFO wty = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO();
				java.util.Date startDateTmp = MappingUtils.mapStringToJavaDate(wty.getWARRANTYSTARTDATE());
				java.util.Date endDateTmp = MappingUtils.mapCastorToJavaDate(checkForEligibleProductAndGetWarrantyEndDate(
							MappingUtils.mapToCastorDate(wty.getWARRANTYSTARTDATE()), 
							MappingUtils.mapToCastorDate(wty.getWARRANTYENDDATE())));
				
				
				startDateMap.put(startDateTmp,startDateTmp);
				endDateMap.put(endDateTmp,endDateTmp);
			}
		}
		HashMap<String, Date> dates = new HashMap<String, Date>();
		if(!endDateMap.isEmpty()) {
	    	ESLog.debug("Overall EndDate: " + endDateMap.lastKey());
			dates.put(EsConstants.END_DATE, MappingUtils.mapToCastorDate(endDateMap.lastKey()));
		} else {
	    	ESLog.debug("No end date available");
		}
		if(!startDateMap.isEmpty()) {
			ESLog.debug("Overall StartDate: " + startDateMap.firstKey());
			
			dates.put(EsConstants.START_DATE, MappingUtils.mapToCastorDate(startDateMap.firstKey()));
		} else {
	    	ESLog.debug("No start date available");
		}
		return dates;
	}	
}
