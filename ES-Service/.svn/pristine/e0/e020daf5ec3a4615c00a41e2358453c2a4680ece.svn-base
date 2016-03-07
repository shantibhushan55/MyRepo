package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.List;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZPARTLIST;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYOOSINFO;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYPARTINFO;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.PartListComplexType;

class MetroOosMapper extends OosMapper {

	MetroOosMapper(WarrantyTransaction transaction,
			LocationComplexType locationObject, XMLIdGenerator XMLIdGenerator,
			EsRequestComplexType request) {
		super(transaction, locationObject, XMLIdGenerator, request);
	}

    /**
     * map
     * @return
     * @throws MappingException
    */
    OOSComplexType map() throws MappingException {
    	if(_transaction == null) {
    		return null;
    	}
    	
    	ZWTYOOSINFO swopOos = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getOOSINFO();
    	
    	if(swopOos == null) {
    		return null;
    	}
    	// create the OOS object
    	ESLog.debug("Mapping oos: " + MappingUtils.stripLeadingZeroes(swopOos.getOOSKEY()));
    	OOSComplexType oos = new OOSComplexType();
    	oos.setWarrantyShipToCustomerRef(_locationObject);
		oos.setId(_XMLIdGenerator.nextId());
    	oos.setOOSKey(MappingUtils.nullString(MappingUtils.stripLeadingZeroes(swopOos.getOOSKEY())));
    	oos.setOOSType("HW");
    	String serialNumber = swopOos.getSERIALNUM();
    	// check if we have SN from SWOP, if not we get the SN from the request
    	if(serialNumber == null || "".equals(serialNumber)) {
        	oos.addSerialNumber(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber());
    	} else {
        	oos.addSerialNumber(serialNumber);
    	}
    	oos.setProgramDeal(MappingUtils.nullString(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO().getDEALCODE())); 
    	oos.setPurchaseAgreementNumber(MappingUtils.nullString(swopOos.getPURCHASEAGREENUM()));
    	oos.setSalesOrderNumber(MappingUtils.nullString(swopOos.getSALESORDERNUM()));
    	oos.setShipToCustomerNumber(MappingUtils.stripLeadingZeroes(MappingUtils.nullString(swopOos.getSHIPTOCUSTNUM())));
    	oos.setShipToCountry(MappingUtils.nullString(swopOos.getSHIPTOCTRY()));
    	oos.setShipFromCountry(MappingUtils.nullString(swopOos.getSHIPFROMCTRY()));
    	oos.setOMSystemDesc(MappingUtils.nullString(swopOos.getOMSYSTEMDESC()));
    	oos.setSalesChannel(MappingUtils.nullString(swopOos.getSALESCHANNEL()));
    	oos.setWarrantyShipToCustomerID(MappingUtils.nullString(swopOos.getSHIPTOCUSTNUM()));
    	
        //The generated SourceCustomerId value for SWOP warranties must 
        //also be populated in the WarrantyShipToCustomerID of the OOS.
        if (oos.getWarrantyShipToCustomerID() == null && _locationObject!=null)
            oos.setWarrantyShipToCustomerID(_locationObject.getSourceCustomerID());
            	
    	// Product
    	ProductMapper pm = new MetroProductMapper(_transaction);
    	oos.setProduct(pm.map());
    	
    	
    	SparePartMapper spm = new MetroSparePartMapper(_transaction);
      	oos.setPart(spm.map());
      	
        /*
         *  3G addition for mapping the PartListComplexType
         */
       	ESLog.debug("Mapping oos ->PART: *****");
       	ZPARTLIST sapPartList = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getPRODUCTINFO().getPARTINFO();     		
        if (sapPartList != null){
	       	List<ZWTYPARTINFO> sapParts =sapPartList.getItem();		       
	        if ((sapParts != null)&& (sapParts.size()>0))  {     	
	        	ESLog.debug("Mapping oos ->PART: FOUND VALUE IN ZPARTLIST: The Size of the PartList:" + sapParts.size() );	            
	        	for (ZWTYPARTINFO sapPart : sapParts) {   
	               		ESLog.debug("Mapping oos ->PART: About to call the Mapping for partNumber:" + sapPart.getPARTNUMBER() );
	               		PartListComplexType tmp = mapPart(sapPart);
	               		oos.addPartList(tmp);
	                }
	            }else{
	           		ESLog.debug("Mapping oos ->PART: ZPARTLIST is NULL" );	
	            }
        }else{       		
        	ESLog.debug("Mapping oos ->PART: (ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getPRODUCTINFO().getPARTINFO() returned NULL" );      		
        }	
  	
        return oos;
    }

	private PartListComplexType mapPart(ZWTYPARTINFO  sapPart) {
    	if(sapPart == null) {
    	  	ESLog.debug("Mapping part info:ZWTYPARTINFO was null " );	
    		return null;
    	}

    	ESLog.debug("Mapping part info: " + sapPart.getPARTNUMBER());	
    	
    	PartListComplexType part = new PartListComplexType();
    
    	
    	part.setPartNumber(MappingUtils.nullString(sapPart.getPARTNUMBER()));
    	part.setPartDescription(MappingUtils.nullString(sapPart.getPARTDESC()));
       	part.setPartSerialNumber(sapPart.getPARTSN());
      	part.setPartWarrantyStartDate(MappingUtils.nullString(sapPart.getPARTWTYSTART()));
       	part.setPartWarrantyEndDate(MappingUtils.nullString(sapPart.getPARTWTYEND()));
   	
    	// check if the part is empty, in this case we return a null
    	if((part.getPartDescription() == null) && (part.getPartNumber() == null)) {
    	  	ESLog.debug("Mapping part info:ZWTYPARTINFO  The Part Description and PartNumber was null " );	

    		return null;
    	} else {
            return part;
    	}
	}
    	
}
