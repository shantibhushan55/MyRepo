/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/combinedEntitlement/bySn/UnitListMerger.java 1.8 2004-09-27 17:56:55+02 stefsobe Exp $
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
 * $Log: UnitListMerger.java,v $
 * Revision 1.8  2004-09-27 17:56:55+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 */
package com.hp.es.service.combinedEntitlement.bySn;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;

public class UnitListMerger {

    private String _serialNumber = null;
    private UnitListComplexType _list1 = null;
    private UnitListComplexType _list2 = null;
    private ProductComplexType _product = null;
    private boolean _preferSingleProduct = false;

    // this object will hold our merged list
    private UnitListComplexType _result = new UnitListComplexType();
    // in this map we keep the groups of products that match to the same
    // base product number
    private Map _productsByBase = new TreeMap();


    /**
     * Constructor: product is makred to have precedence over list.
     * @param serialNumber
     * @param product
     * @param list
     */
    public UnitListMerger(String serialNumber,
                          ProductComplexType product,
                          UnitListComplexType list) {
        _serialNumber = serialNumber;
        _product = product;
        _preferSingleProduct = true;
        _list1 = list;
    }

    /**
     * Constructor: product precedence is explicitly defined.
     * @param serialNumber
     * @param product
     * @param list
     */
    public UnitListMerger(String serialNumber,
                          ProductComplexType product,
                          UnitListComplexType list,
                          boolean preferProduct ) {
        _serialNumber = serialNumber;
        _product = product;
        _preferSingleProduct = preferProduct;
        _list1 = list;
    }

    /**
     * Constructor: product is marked to have precedence over list.
     * @param serialNumber
     * @param product
     * @param list
     */
    public UnitListMerger(String serialNumber,
                          UnitListComplexType list1,
                          UnitListComplexType list2) {
        _serialNumber = serialNumber;
        _list1 = list1;
        _list2 = list2;
    }


    private void addList(UnitListComplexType list) {
        Enumeration enumeration = list.enumerateProduct();
        while (enumeration.hasMoreElements()) {
            ProductComplexType prod = (ProductComplexType) enumeration.nextElement();
            addProduct(prod);
        }
    }

    private void addProduct(ProductComplexType product) {
        String productNumber = product.getProductID();
        // filter out empty product numbers
        if((productNumber == null) || ("".equals(productNumber.trim()))) {
            return;
        }
        String baseNumber = BaseProductHelper.extractBase(productNumber);

        // if this is the first entry for this base number create a hash for tracking
        // the product numbers matching this base
        Map prodsForBase = (Map) _productsByBase.get(baseNumber);
        if (prodsForBase == null) {
            prodsForBase = new TreeMap();
            _productsByBase.put(baseNumber, prodsForBase);
        }
        // note this product number, overwrite any previous entry
        prodsForBase.put(productNumber, product);
    }

    private void removeBaseProductIfNotNeeded(String baseNumber, Map products) {
        // no need for action if only single product is present
        if (products.size() > 1) {
            // we leave in all entries except the 'naked' base product number
            // if it is present - this would be coming from warranty - see §5.4.4.3
            products.remove(baseNumber);
        }
    }

    /** Based on the data provided in the constructor a UnitList is created
     *  with following rules:
     *  <UL>
     *  <LI>The first list overwrites identical entries from the second list (if
     *  a second list is present)
     *  <LI>The single product if present may either overwrite an identical entry on
     *  the list or be overwritten, depending on the passed flag
     *  <LI>Identical means same product id.
     *  <LI>If there are multiple entries with the same base product number and
     *  this includes an entry with <b>exactly</b> the base product number then this entry
     *  will be removed.
     *  <LI>The resulting Product elements only have the id and the description
     *      set. Note that this method is <b>desctructive</b> - meaning that the
     *      existing Product elements are manipulated instead of copying them to
     *      save memory. As the merged list is the only one of interested after
     *      this method has been called this is OK.
     *  </UL>
     */
    public UnitListComplexType getMergedList() {

        // list2 is processed list1 so entries from list1 can overwrite
        if ( _list2 != null ) addList(_list2);
        // the single producrt is processed before list1 in case it has lower prio
        if ( _product != null && !_preferSingleProduct) addProduct(_product);
        // now process list1 and possibly overwrite stuff from list2 or a lower
        // prio single product
        if ( _list1 != null ) addList(_list1);
        // finally let a higher prio single product have the last word
        if ( _product != null && _preferSingleProduct) addProduct(_product);

        // all have been processed, we are ready to produce the result list
        // for this we look at each group of products that share the same base and
        // in case we have more than one for a given base we remove the unspecific
        // base product number if it is present as an entry of it's own
        Iterator baseIterator = _productsByBase.keySet().iterator();
        while (baseIterator.hasNext()) {
            String baseNumber = (String)baseIterator.next();
            Map products = (Map) _productsByBase.get(baseNumber);
            removeBaseProductIfNotNeeded(baseNumber, products);
            Iterator prodIterator = products.keySet().iterator();
            while (prodIterator.hasNext()) {
                // we dont copy the products to save memory, instead we directly
                // modify them to not contain anything but the ID and desc
                ProductComplexType prod = (ProductComplexType)products.get(prodIterator.next());
                prod.setEndOfSupportLife(null);
                prod.setProductLineCode(null);
                prod.setProductLineDescription(null);
                _result.addProduct(prod);
            }
        }

        // copy the serial to the result
        _result.setSerialNumber(_serialNumber);
        return _result;
    }
}