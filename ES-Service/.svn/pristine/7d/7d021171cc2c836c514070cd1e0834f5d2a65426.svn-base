/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */

package com.hp.es.service.contractSummary.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSPRODUCTITEMSUM;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ProductListComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class MetroCSProductListMapper extends CSProductListMapper {

	/**
	 * 
	 */
	MetroCSProductListMapper(ContractSummaryTransaction transaction, EsReplyCSContext ctx) {
		super(transaction, ctx);
	}

	
	ProductListComplexType[] map() throws MappingException, SifException {
	   	
		if(_transaction == null) {
    		return new ProductListComplexType[0];
    	}

    	if(((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getPRODUCTS() == null){
    		return new ProductListComplexType[0];
    	}
		
		
    	Collection sapProductLists =((ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply()).getPRODUCTS().getItem();
    	ProductListComplexType[] productLists = new ProductListComplexType[sapProductLists.size()];
        

        ESLog.debug("Mapping " + productLists.length + " productLists ...");
        int i=0;
        //we go through all sap products
        for (Iterator it=sapProductLists.iterator(); it.hasNext(); ) {
        	productLists[i++] = mapProductList((ZESCQSPRODUCTITEMSUM) it.next());
        }
        return productLists;
	}

	
	private ProductListComplexType mapProductList(ZESCQSPRODUCTITEMSUM input){
		ESLog.debug("Mapping productList: " + input.getPRODUCTID());
		ProductListComplexType prodList = new ProductListComplexType();

    	// Map to ES product list type
		prodList.setProductID(MappingUtils.nullString(input.getPRODUCTID()));
		prodList.setProductDescription(MappingUtils.nullString(input.getPRODUCTDESCRIPTION()));
		prodList.setProductType(MappingUtils.nullString(input.getPRODUCTTYPE()));
        return prodList;
		
	}
	
}
