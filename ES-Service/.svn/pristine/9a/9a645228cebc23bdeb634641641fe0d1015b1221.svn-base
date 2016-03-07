/*
 * Created on Mar 13, 2006
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.List;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSPRODUCT;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSUNIT;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.sif.SifException;

/**
 * @author antoine 
 * This map a unit list
 */
public class MetroUnitListMapper extends UnitListMapper {


	protected MetroUnitListMapper(ContractTransaction transaction) {
    	super(transaction);
    }	

    /**
     * map
     * @return
     * @throws MappingException
     * @throws SifException 
     */
	public UnitListComplexType map() throws MappingException, SifException {

    	ESLog.debug("Enter unit list mapping");
    	
    	ZESCQSUNIT cqsUnitList = (ZESCQSUNIT) _transaction.getSourceSystemUnitList();
    	UnitListComplexType unitList = new UnitListComplexType();
    	List<ZESCQSPRODUCT> prodList = cqsUnitList.getPRODUCTS().getItem();
    	
    	ESLog.debug("Mapping Unit list :");
    	
    	unitList.setSerialNumber(cqsUnitList.getSERIALNUMBER());
    	
    	// map each product and add it to the unit list
    	ESLog.debug("Call product mapping for unit list ...");
    	for (ZESCQSPRODUCT cqsProduct : prodList) {
    		unitList.addProduct(mapProduct(cqsProduct));
    	}

    	return unitList;

    }
	
	/**
	 * mapProduct
	 * @param cqsProduct
	 * @return
	 */
	protected ProductComplexType mapProduct(ZESCQSPRODUCT cqsProduct) {
		ESLog.debug("Map product '" + cqsProduct.getPRODUCTID() + "' for unit list");
		
		ProductComplexType product = new ProductComplexType();
		
		product.setProductID(cqsProduct.getPRODUCTID());
		product.setProductDescription(cqsProduct.getPRODUCTDESCRIPTION());
		return product;
	}
    
}
