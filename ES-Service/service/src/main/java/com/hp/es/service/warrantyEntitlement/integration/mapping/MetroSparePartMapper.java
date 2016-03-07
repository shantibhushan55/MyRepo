/**
 * 
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYSPAREPART;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.Part;

/**
 * @author anvoi
 *
 */
class MetroSparePartMapper extends SparePartMapper {

	/**
	 * @param transaction
	 */
	MetroSparePartMapper(WarrantyTransaction transaction) {
		super(transaction);
	}

	 /**
     * map
     * @return
     * @throws MappingException
     */	
    Part map() throws MappingException {
    	if(_transaction == null) {
    		return null;
    	}
    	
    	ZWTYSPAREPART sparePart = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getSPAREPARTINFO();
    	if(sparePart == null) {
    		return null;
    	}
    	ESLog.debug("Mapping spare part: " + sparePart.getPARTNUMBER());		
    	Part part = new Part();
    	part.setPartNumber(MappingUtils.nullString(sparePart.getPARTNUMBER()));
    	part.setPartDescription(MappingUtils.nullString(sparePart.getPARTDESC()));
    	
    	// check if the spare part is empty, in this case we return a null
    	if((part.getPartDescription() == null) && (part.getPartNumber() == null)) {
    		return null;
    	} else {
            return part;
    	}
    }	
         

}
