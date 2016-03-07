package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.HashMap;
import java.util.List;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENTITLEMENTREPLYV1;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMV;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMVT;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOOS;
import com.hp.es.service.contractEntitlement.keys.OOSKey;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ManufacturerComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;

class MetroOosMapper extends OosMapper {


    MetroOosMapper(ContractTransaction transaction, XMLIdGenerator generator, EsReplyContext ctx) {
        super(transaction,generator, ctx);
    }

    /*
     * map
     * @return OOSComplexType[]
     */
    OOSComplexType[] map() throws MappingException {

    	if(_transaction == null) {
    		return new OOSComplexType[0];
    	}

       	List<ZESCQSOOS> sapOoses = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getOOS().getItem();
        OOSComplexType[] ooses = new OOSComplexType[((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getOOS().getItem().size()];

        ESLog.debug("Mapping " + ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getOOS().getItem().size() + " ooses ...");
        int i=0;
        for (ZESCQSOOS oos : sapOoses) {
            ooses[i++] = mapOos(oos);
        }
        return ooses;
    }

    
    /*
     * mapOOS
     * @return OOSComplexType
     */    
    protected OOSComplexType mapOos(ZESCQSOOS input) throws MappingException {

        OOSComplexType oos = new OOSComplexType();
        oos.setId(_generator.nextId());
        
        oos.setCustomerDefinedID(MappingUtils.nullString(input.getCUSTOMERDEFINEDID()));
        oos.setOOSGroupID(MappingUtils.nullString(input.getOOSGROUPID()));
        oos.setOOSKey(MappingUtils.nullString(input.getOOSKEY()));
        oos.setOOSType(MappingUtils.nullString(input.getOOSTYPE()));
        if (input.getTARGETQUANTITY() != null) {
            oos.setTargetQuantity(MappingUtils.floatStringToInt(input.getTARGETQUANTITY()));
        }
        String serial = MappingUtils.nullString(input.getSERIALNUMBER());
        //setting the serial Number for the OOS (only one)
        if (serial != null) {
        	oos.setSerialNumber( new String[] { serial } );
        }

        ProductComplexType product = new ProductComplexType();
        product.setProductID(MappingUtils.nullString(input.getPRODUCTID()));
        product.setProductDescription(MappingUtils.nullString(input.getPRODUCTDESCRIPTION()));
        product.setProductLineCode(MappingUtils.nullString(input.getPRODUCTLINECODE()));
        product.setProductLineDescription(MappingUtils.nullString(input.getPRODUCTLINEDESCRIPTION()));
        
        HashMap map = _transaction.getStandardizedProductHashMap();
        
        if(map == null) {
        	map = new HashMap();
        	_transaction.setStandardizedProductHashMap(map);
        }
        map.put(MappingUtils.nullString(input.getPRODUCTID()),MappingUtils.nullString(input.getPRODUCTIDSTANDARDIZED()));
        
        oos.setProduct(product);

        if(_ctx != null) {
        	OOSKey key = new OOSKey(oos.getOOSKey());
        	_ctx.addOOS(key, oos);
        	_ctx.setAggProductId(input.getPRODUCTID(),MappingUtils.nullString(input.getPRODUCTIDSTANDARDIZED()));
        	
        	
        	try {
        		if((input.getWTYSTARTDATE() != null) && (input.getWTYSTARTDATE().trim().length() > 0)) {
	        		java.sql.Date d = java.sql.Date.valueOf(input.getWTYSTARTDATE());
	                //The following two lines are for PoP. The column is from table "object_of_service"        	
	                if (d != null) {
	                    _ctx.addOosWarrantyStartDate(key, d);
	                }
        		}
        	}catch(IllegalArgumentException ex) {
        		ESLog.debug("Caught IllegalArgumentException while parsing date",ex);
        	}
        }
        return oos;
    }
    
    /*
     * mapping manufacture information to OOS
     * 
     * get all ZESCQSOOS and ZESCQSMV from SAP reply, iterate each ZESCQSOOS
     * to get the manufacture id. Then iterate each ZESCQSMV. If the manufacture id
     * in ZESCQSMV is equals to the manufacture id in ZESCQSOOS, create one ManufacturerComplexType
     * and set multi vendor information to OOSComplexType
     */
    void mapMV(OOSComplexType[] oosComplexTypes) {
    	ZESCQSMVT sapMvt = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getMVINFOR();
    	if(null == sapMvt || null == sapMvt.getItem()
    			|| sapMvt.getItem().size() == 0
    			|| null == oosComplexTypes
    			|| oosComplexTypes.length == 0) {
    		ESLog.debug("No MV info returned from SAP. MV list is emppty");
    		return;
    	}
    	// get all ZESCQSOOS and ZESCQSMV from SAP reply
    	List<ZESCQSOOS> sapOoses = ((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getOOS().getItem();
    	List<ZESCQSMV> sapMvs = sapMvt.getItem();
    	ESLog.debug(sapMvs.size() + " MV(s) is(are) returned from SAP");
    	ESLog.debug(sapOoses.size() + " OOS(es) is(are) returned from SAP");
    	for(int i=0; i<sapOoses.size(); i++) {
    		String oosMVId = sapOoses.get(i).getMANUFACTURERID();
    		if(null == oosMVId || oosMVId.trim().length() == 0) {
    			ESLog.debug("manufacture id in ZESCQSOOS is empty or null, skip it. ZESCQSOOS key is " + sapOoses.get(i).getOOSKEY());
    			continue;
    		}
    		for(ZESCQSMV mv : sapMvs) {
    			if(null == mv.getMANUFACTURERID() || mv.getMANUFACTURERID().trim().length() == 0) {
    				ESLog.debug("manufacture id in ZESCQSMV is empty or null, skip it. ZESCQSOOS key is " + sapOoses.get(i).getOOSKEY());
    				continue;
    			}
    			if(oosMVId.trim().equals(mv.getMANUFACTURERID().trim())) {
    				ESLog.debug("Find one MV. Manufacturer ID is "
    						+ oosMVId + ", ZESCQSOOS key is " + sapOoses.get(i).getOOSKEY()
    						+ ", OOSComplexType OOS key is " + oosComplexTypes[i].getOOSKey());
    				// when find the first mv, set mv info and return.
    				ManufacturerComplexType mvType = new ManufacturerComplexType();
    				mvType.setManufacturerCode(MappingUtils.nullString(mv.getMANUFACTURERCODE()));
    				mvType.setManufacturerID(MappingUtils.nullString(mv.getMANUFACTURERID()));
    				mvType.setManufacturerName(MappingUtils.nullString(mv.getMANUFACTURERNAME()));
    				oosComplexTypes[i].getProduct().setManufacturer(mvType);
    				oosComplexTypes[i].setManufacturerProductNumber(MappingUtils.nullString(sapOoses.get(i).getMANUFACTURERPARTNO()));
    				break;
    			}
    		}
    	}
    }

}
