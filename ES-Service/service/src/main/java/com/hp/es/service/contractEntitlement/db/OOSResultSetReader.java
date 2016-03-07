/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/OOSResultSetReader.java 1.11 2004-07-02 11:56:57+02 zhanghai Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: OOSResultSetReader.java,v $
 * Revision 1.11  2004-07-02 11:56:57+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Call addOosWarrantyStartDate to record information for PoP
 *
 * Revision 1.10  2004-06-22 10:49:12+02  yipa
 * Author: yipa@15.96.142.153 ()
 * add customerdefinedid for es8.0c2.
 *
 * Revision 1.9  2004-05-08 04:42:50+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:39+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-01-29 18:07:37+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-11-04 20:38:00+01  RONAR
 * Author: RONAR@dhcp-15-197-229-237.bbn.hp.com ()
 * Change for C3 iteration
 *
 * Revision 1.5  2003-08-04 16:51:57+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-06-05 14:39:38+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * don't set optional int values to 0 if the database has null-values
 *
 * Revision 1.3  2003-05-12 02:00:10+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-16 16:16:41+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * change product line code and product line descr.
 *
 * Revision 1.1  2003-04-15 14:01:04+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.OOSKey;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;

/**
 * This class reads the result set for OOSes
 */
class OOSResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public OOSResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String oosKey = rs.getString("OOS_KEY");

        OOSKey key = new OOSKey(oosKey);

        OOSComplexType o = new OOSComplexType();

        o.setCostCenter(rs.getString("OOS_COST_CENTER"));
        o.setOOSGroupID(rs.getString("OOS_GROUP_ID"));
        // o.setHWShipToPersonID();
        o.setOOSKey(oosKey);
        o.setOOSType(rs.getString("OOS_TYPE"));
        // o.setPart();  -> Warranty only

        ProductComplexType p = new ProductComplexType();
        // p.setEndOfSupportLife();  -> reserved for future
        p.setProductDescription(rs.getString("OOS_PRODUCT_DESC"));
        p.setProductID(rs.getString("OOS_PRODUCT_ID"));

        // setting the product Id and aggregated product Id in hash table.

        String pd =  rs.getString("OOS_PRODUCT_ID");
        String apd =  rs.getString("OOS_AGG_PRODUCT_ID");

        ctx.setAggProductId(pd,apd);

        p.setProductLineCode(rs.getString("OOS_PRODUCT_LINE"));
        // p.setProductLineDescription();  -> Warranty
        o.setProduct(p);

        // o.setProductShipToCustomerID();
        // o.setProgramDeal(); -> Warranty only
        o.setRedAccessID(rs.getString("OOS_RED_ACCESS_ID"));
        o.setRedGroupSerialNo(rs.getString("OOS_RED_GROUP_SERIAL_NO"));
        o.setRedSubKCode(rs.getString("OOS_RED_SUB_K_CODE"));
        // o.setSalesOrderNumber();  -> Warranty only
        // o.setSerialNumber();  -> SerialNumberResultSetReader
        // o.setShipToCountry(); -> Warranty only
        // o.setShipToCustomerNumber(); -> Warranty only
        // o.setSWShipToCustomerID(); -> OOSContactResultSetReader
        // o.setSWShipToPersonID();   -> OOSContactResultSetReader
        // o.setSystemMgrPersonID();  -> OOSContactResultSetReader
        o.setCustomerDefinedID(rs.getString("OOS_CUSTOMER_DEFINED_ID"));
        int qty = rs.getInt("OOS_TARGET_QTY");
        if ( !rs.wasNull()) {
            o.setTargetQuantity(qty);
        }

        ctx.addOOS(key, o);

        //The following two lines are for PoP. The column is from table "object_of_service"
        java.sql.Date d = rs.getDate("OOS_WARRANTY_START_DATE");
        if (d != null)
            ctx.addOosWarrantyStartDate(key, d);
    }
}

/*
OOS_KEY
OOS_TYPE
OOS_PRODUCT_DESC
OOS_PRODUCT_LINE
OOS_PRODUCT_ID
OOS_TARGET_QTY
OOS_GROUP_ID
OOS_DATA_ENTRY_SITE
OOS_SYS_TYPE
OOS_SYS_MODEL
OOS_SUPPORT_OFFICE
OOS_COST_CENTER
OOS_RED_GROUP_SERIAL_NO
OOS_RED_ACCESS_ID
OOS_RED_SUB_K_CODE
OOS_PREVIOUS_GROUP_ID
OOS_COMMENT
OOS_RED_DOMAIN
OOS_RED_PART_FLAG
*/


