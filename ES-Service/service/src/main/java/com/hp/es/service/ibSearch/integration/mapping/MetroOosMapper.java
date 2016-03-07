package com.hp.es.service.ibSearch.integration.mapping;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWTYPRODLIST;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;

class MetroOosMapper extends OosMapper {

	public MetroOosMapper(IBSearchTransaction transaction,
			XMLIdGenerator XMLIdGenerator) {
		super(transaction, XMLIdGenerator);
	}

	protected OOSComplexType mapOos(ZWTYPRODLIST ibProduct)
			throws MappingException {
    	if(_transaction == null) {
    		return null;
    	}

    	ESLog.debug("Mapping product: " + MappingUtils.stripLeadingZeroes(ibProduct.getOOSKEY()));
    	OOSComplexType oos = new OOSComplexType();
    	oos.setId(_XMLIdGenerator.nextId());
    	oos.setOOSKey(MappingUtils.stripLeadingZeroes(ibProduct.getOOSKEY()));
    	oos.addSerialNumber(ibProduct.getSERIALNUM());
    	// not mapped
    	// oos.setSalesOrderNumber("");
    	oos.setShipToCountry(ibProduct.getSHIPTOCTRYCODE());
    	
    	// Product
    	ProductComplexType product = new ProductComplexType();
    	product.setProductID(ibProduct.getPRODUCTID());
    	product.setProductDescription(ibProduct.getPRODUCTDESC());
    	oos.setProduct(product);
    	
      	
        return oos;
	}

	protected OOSComplexType mapOos(Object ibProduct) throws MappingException {
		// 
		return mapOos((ZWTYPRODLIST)ibProduct);
	}

}
