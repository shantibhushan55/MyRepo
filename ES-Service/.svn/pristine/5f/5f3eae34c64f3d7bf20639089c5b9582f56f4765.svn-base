package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYPRODINFO;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.ProductComplexType;

class MetroProductMapper extends ProductMapper {

	MetroProductMapper(WarrantyTransaction transaction) {
		super(transaction);
	}
	
	
	/**
     * map
     * @return
     * @throws MappingException
     */
    ProductComplexType map() throws MappingException {
    	if(_transaction == null) {
    		return null;
    	}
    	
    	ZWTYPRODINFO productInfo = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getPRODUCTINFO();
    	if(productInfo == null) {
    		return null;
    	}
    	ESLog.debug("Mapping product: " + productInfo.getPRODUCTNUM());
    	ProductComplexType product = new ProductComplexType();
    	product.setProductID(MappingUtils.nullString(productInfo.getPRODUCTNUM()));
    	product.setProductDescription(MappingUtils.nullString(productInfo.getPRODUCTDESC()));
    	product.setProductLineCode(MappingUtils.nullString(productInfo.getPRODUCTLINECODE()));
    	product.setProductLineDescription(MappingUtils.nullString(productInfo.getPRODUCTLINEDESC()));
    	// check whether the product is empty or not
    	if(isProductNull(product)) {
    		return null;
    	}
        return product;
    }
}
