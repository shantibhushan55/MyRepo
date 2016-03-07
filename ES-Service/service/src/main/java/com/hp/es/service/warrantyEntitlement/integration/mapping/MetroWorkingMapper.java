/**
 * 
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.ArrayList;

import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.sif.SifException;

/**
 * @author anvoi
 *
 */
public class MetroWorkingMapper extends WorkingMapper {

	/**
	 * @param transaction
	 * @param request
	 */
	protected MetroWorkingMapper(WarrantyTransaction transaction,
			EsRequestComplexType request,ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply, SifException manufacturingInstalledBaseServiceSE) {
		super(transaction, request,manufacturingInstalledBaseServiceReply, manufacturingInstalledBaseServiceSE);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.warrantyEntitlement.integration.mapping.WorkingMapper#map()
	 */
	public WorkingComplexType[] map() throws MappingException {
		if(_transaction == null) {
    		return new WorkingComplexType[0];
    	}

    	ESLog.debug("Mapping workings ...");
    	ArrayList<WorkingComplexType> workingList = new ArrayList<WorkingComplexType>();
     	
     	WorkingComplexType working = new WorkingComplexType();
     	
     	// SWOP warranty ID
     	working.setWorkingName("SWOP Warranty ID");
     	working.setWorkingValue(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getWARRANTYID());
     	workingList.add(working);
     	
     	// SWOP Warranty Start Date
     	if((((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getWARRANTYSTARTDATE() != null) &&
     		(MappingUtils.mapToCastorDate(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getWARRANTYSTARTDATE()) != null)) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Warranty Start Date");
	     	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getWARRANTYSTARTDATE()));
	     	workingList.add(working);
     	}
     	
     	// SWOP Grace Period
     	if(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getGRACEPERIOD() != null) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Grace Period");
	     	working.setWorkingValue("" + MappingUtils.stringToInt(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getGRACEPERIOD())));
	     	workingList.add(working);
     	}
     	
     	// SWOP Proof Of Purchase Date
     	if((((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getPROOFOFPURCHASEDATE() != null) && 
     		(MappingUtils.mapToCastorDate(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getPROOFOFPURCHASEDATE()) != null)) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Proof Of Purchase Date");
	     	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getPROOFOFPURCHASEDATE()));
	     	workingList.add(working);
     	}
     	
     	// SWOP Shipment Date
     	if((((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getSHIPMENTDATE() != null) &&
     		(MappingUtils.mapToCastorDate(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getSHIPMENTDATE()) != null)) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Shipment Date");
	     	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getSHIPMENTDATE()));
	     	workingList.add(working);
     	}
     	
     	// SWOP Installation Date
     	if((((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getINSTALLATIONDATE() != null) &&
     		(MappingUtils.mapToCastorDate(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getINSTALLATIONDATE()) != null)) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Installation Date");
	     	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getINSTALLATIONDATE()));
	     	workingList.add(working);
     	}

     	// SWOP Born on date
     	if((((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getBORNONDATE() != null) &&
     		(MappingUtils.mapToCastorDate(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getBORNONDATE()) != null)) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Born On Date");
	     	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getBORNONDATE()));
	     	workingList.add(working);
     	}

     	// SWOP Factory Restart Date
     	if((((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getFACTORYRESTARTDATE() != null) &&
     		(MappingUtils.mapToCastorDate(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getFACTORYRESTARTDATE()) != null)) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Factory Restart Date");
	     	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO().getFACTORYRESTARTDATE()));
	     	workingList.add(working);
     	}
     	
     	// SWOP Start Date Type
     	if(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getSOURCEDATEFORWARRANTYSTART() != null) {
     		working = new WorkingComplexType();
	     	working.setWorkingName("SWOP Start Date Type");
	     	working.setWorkingValue(WarrantyDeterminationCode.getInstance().
	     								getWarrantyDeterminationDescription(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).
	     																getWARRANTYINFO().getSOURCEDATEFORWARRANTYSTART()));
	     	workingList.add(working);
     	}
     	
     	// SWOP instance
     	working = new WorkingComplexType();
     	working.setWorkingName("SWOP Instance");
     	working.setWorkingValue(_transaction.getSourceSystemHost());
     	workingList.add(working);

     	// SWOP Request Status
     	working = new WorkingComplexType();
     	working.setWorkingName("SWOP Request Status");
     	working.setWorkingValue(_transaction.getSwopSystemStatus());
     	workingList.add(working);
     	
     	
     	// SWOP Original Product
     	if(_transaction.isSwopWarningMessageReturned(1005)) {
     		if((_request.getEsRequestComplexTypeChoice().getWarrantyRequest()!= null)) {
	         	working = new WorkingComplexType();
	         	working.setWorkingName("SWOP Original Product");
	         	working.setWorkingValue(MappingUtils.nullString(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProductID()));
	         	workingList.add(working);
     		}
     	}
     		
     	// SWOP Product Alias
     	if(_transaction.isSwopWarningMessageReturned(1005)) {
         	working = new WorkingComplexType();
         	working.setWorkingName("SWOP Produt Alias");
         	working.setWorkingValue(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getPRODUCTINFO().getPRODUCTNUM()));
         	workingList.add(working);
     	}
     	
     	
     	
     	// SWOP Unit List Returned
     	working = new WorkingComplexType();
     	working.setWorkingName("SWOP Unit List Returned");
     	if(_transaction.isSourceSystemUnitList()) {
         	working.setWorkingValue("Y");
     	} else {
         	working.setWorkingValue("N");
     	}
     	workingList.add(working);
     	
     	// SWOP Product Base Warranty
     	working = new WorkingComplexType();
     	working.setWorkingName("SWOP Product Base Warranty");
     	if(_transaction.isSwopWarningMessageReturned(1009)) {
         	working.setWorkingValue("Y");
     	} else {
         	working.setWorkingValue("N");
     	}
     	workingList.add(working);
 
     	if(_manufacturingInstalledBaseServiceSE != null ||_manufacturingInstalledBaseServiceReply != null ) {
	     	working = new WorkingComplexType();
	     	working.setWorkingName("SNR call");
	     	ESLog.debug("Mapping workings");
	     	if(_manufacturingInstalledBaseServiceSE != null && _manufacturingInstalledBaseServiceSE.getErrorText() != null && Integer.parseInt(_manufacturingInstalledBaseServiceSE.getErrorID()) ==ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE) {
	     		ESLog.debug("manufacturing Installed Base Service exception  is not null so we got a SNR error");
	     		working.setWorkingValue("Failure "+ _manufacturingInstalledBaseServiceSE.getErrorText());
	     	}else {
	     		if(_manufacturingInstalledBaseServiceReply != null) {
		     		working.setWorkingValue("Success");
		     		workingList.add(working);
		         	working = new WorkingComplexType();
		         	working.setWorkingName("SNR manufacturing date");
		         	working.setWorkingValue(DateHelper.toIsoDateString(_manufacturingInstalledBaseServiceReply.getManufacturingDate()));
		     		workingList.add(working);
		         	working = new WorkingComplexType();
		         	working.setWorkingName("SNR Shipment date");
		         	working.setWorkingValue(DateHelper.toIsoDateString(_manufacturingInstalledBaseServiceReply.getShipmentDate()));
		     		workingList.add(working);
		         	working = new WorkingComplexType();
		         	working.setWorkingName("SNR return date");
		         	working.setWorkingValue(DateHelper.toIsoDateString(_manufacturingInstalledBaseServiceReply.getReturnDate()));
		         	workingList.add(working);
	     		}else if(_manufacturingInstalledBaseServiceSE != null && Integer.parseInt(_manufacturingInstalledBaseServiceSE.getErrorID()) ==ErrorFactory.id300_NO_DATA_FOUND) {
		     		working.setWorkingValue("NoDataFound");
		     		workingList.add(working);
	     		}else if(_manufacturingInstalledBaseServiceSE != null) {
		     		working.setWorkingValue("SNR error "+ _manufacturingInstalledBaseServiceSE.getErrorText());
		     		workingList.add(working);
	     		}else {
		     		working.setWorkingValue("SNR not called");
		     		workingList.add(working);
	     		}
	     		
	
	     	}
     	}

     	
     	
     	
     	return (WorkingComplexType[]) workingList.toArray(new WorkingComplexType[0]);
	}

}
