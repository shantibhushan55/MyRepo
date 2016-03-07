package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.List;
import java.util.TreeMap;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZPRODLIST;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYPRODLIST;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.sif.SifException;

public class MetroUnitListMapper extends UnitListMapper {

	public MetroUnitListMapper(WarrantyTransaction transaction) {
		super(transaction);
	}

	public UnitListComplexType map() throws MappingException, SifException {

		ESLog.debug("Enter unit list mapping");
		ZPRODLIST swopUnitList = (ZPRODLIST) _transaction.getSourceSystemUnitList();
		UnitListComplexType unitList = new UnitListComplexType();
		if(swopUnitList != null) {
			List<ZWTYPRODLIST> enUnit = swopUnitList.getItem();
			
			// map each product and add it to the unit list
			ESLog.debug("Call product mapping for unit list ...");
			
			TreeMap serialNumberMap = new TreeMap();
			for (ZWTYPRODLIST swopProduct : enUnit) {
				unitList.addProduct(mapProduct(swopProduct));
				serialNumberMap.put(swopProduct.getSERIALNUM(), swopProduct.getSERIALNUM());
			}
			// set the serial number, which should be the same for all returned products
			if(serialNumberMap.size() != 1) {
				ESLog.error("More than 1 serial number returned from SWOP in the Unit List! It can be only 1 (Highlander)");
		        throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "More than 1 serial number returned from SWOP in the Unit List!");
			}
			unitList.setSerialNumber((String)serialNumberMap.firstKey());
		    return unitList;
		}else{
			ESLog.error("UnitList is Null, so we cannot map a Unit List");
	        throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "UnitList is Null, so we cannot map a Unit List!");
		}

	}

	/**
	 * mapProduct
	 * @param swopProduct
	 * @return
	 */
	private ProductComplexType mapProduct(ZWTYPRODLIST swopProduct) {
		ESLog.debug("Map product '" + swopProduct.getPRODUCTID() + "' for unit list");
		ProductComplexType product = new ProductComplexType();
		product.setProductID(swopProduct.getPRODUCTID());
		product.setProductDescription(swopProduct.getPRODUCTDESC());
		return product;
	}

}
