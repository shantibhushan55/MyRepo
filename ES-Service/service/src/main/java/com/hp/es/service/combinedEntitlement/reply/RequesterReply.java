/*
 * Project: HPS Entitlement Service
 *
 * Copyright (c) 2003 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 */
package com.hp.es.service.combinedEntitlement.reply;

import java.util.HashMap;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.sif.SifException;

public class RequesterReply {

    private EsReply      _reply = null;
    private HashMap      _mappedProductList = null;
    private SifException _exception = null;
    private EsReplyContext _ctx = null;

    public RequesterReply(EsReply reply) {
        _reply = reply;
    }

    public RequesterReply(EsReply reply, HashMap mappedProductList, EsReplyContext ctx) {
        _reply = reply;
        _mappedProductList = mappedProductList;
        _ctx = ctx;
    }

    public RequesterReply(SifException exception) {
        _exception = exception;
    }

    public boolean isNormalReply() {
        return ( (_reply != null) &&
                 (_reply.getEsReplyChoice() != null) &&
                 ( ( _reply.getEsReplyChoice().getCombinedUnitEntitlement() != null )  ||
                   ( _reply.getEsReplyChoice().getCombinedProductEntitlement() != null )  ||
                   ( _reply.getEsReplyChoice().getWarrantyEntitlement() != null )
                 )
               );
    }

    public boolean isListReply() {
        return ( (_reply != null) &&
                 (_reply.getEsReplyChoice() != null) &&
                 ( _reply.getEsReplyChoice().getUnitList() != null )
               );
    }

    public boolean isErrorReply() {
        return (_exception != null);
    }

    public boolean isNull() {
        return false;
    }

    public EsReply getReply() {
        return _reply;
    }

    public UnitListComplexType getUnitList() {
        if (isListReply()) {
            return _reply.getEsReplyChoice().getUnitList();
        }

        return null;
    }

    public SifException getException() {
        return _exception;
    }

    public boolean hasProductId() {
        if(isNormalReply()) {
            if(_reply.getEsReplyChoice().getCombinedUnitEntitlement() != null) {
                CombinedUnitEntitlementComplexType comUnit = _reply.getEsReplyChoice().getCombinedUnitEntitlement();
                if((comUnit.getOOS() ==null) ||(comUnit.getOOS().getProduct() == null)|| (comUnit.getOOS().getProduct().getProductID() == null) ||
                    ("".equals(comUnit.getOOS().getProduct().getProductID().trim()))) {
                    return false;
                }
            }
            if(_reply.getEsReplyChoice().getCombinedProductEntitlement() != null) {
                CombinedProductEntitlementComplexType comProd = _reply.getEsReplyChoice().getCombinedProductEntitlement();
                // Note: Since we get only OOSs with ProductIDs or only 1 which doesn't has
                //       a productId we can always check the first on
                if((comProd.getOOSCount() == 0)|| (comProd.getOOS(0) == null) ||
                		(comProd.getOOS(0).getProduct().getProductID() == null) ||
                    ("".equals(comProd.getOOS(0).getProduct().getProductID().trim()))) {
                    return false;
                }
            }
            if(_reply.getEsReplyChoice().getWarrantyEntitlement() != null) {
                WarrantyEntitlementComplexType warEnt = _reply.getEsReplyChoice().getWarrantyEntitlement();
                if((warEnt.getOOS() == null)||(warEnt.getOOS().getProduct() == null)||(warEnt.getOOS().getProduct().getProductID() == null) ||
                    ("".equals(warEnt.getOOS().getProduct().getProductID().trim()))) {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }

    /**
     * returns the mapped product list
     * @return HashMap
     */
    public HashMap getMappedProductList() {
		return _mappedProductList;
	}
    
    public EsReplyContext getEsReplyContext() {
    	return _ctx;
    }
}