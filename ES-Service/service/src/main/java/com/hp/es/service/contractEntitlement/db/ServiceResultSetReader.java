/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ServiceResultSetReader.java 1.9 2004-07-02 11:57:18+02 zhanghai Exp $
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
 * $Log: ServiceResultSetReader.java,v $
 * Revision 1.9  2004-07-02 11:57:18+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Call addSvcWtyStartDateEligibility to record information for PoP
 *
 * Revision 1.8  2004-05-08 04:42:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.7  2004-05-05 15:41:42+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.6  2004-01-29 18:07:40+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:51:59+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-06-06 10:12:06+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * read IncidentBasedOffer and StandAloneOffer from DB
 *
 * Revision 1.3  2003-06-05 17:21:58+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * replace svc_agg_available_qty with svc_agg_quantity;
 * make int values optional
 *
 * Revision 1.2  2003-05-12 02:00:12+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-15 14:01:05+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.ServiceKey;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ServiceItem;

/**
 * This class reads the result set for offers and service items.
 */
class ServiceResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ServiceResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("SVC_SOURCE_OBLIGATION_ID");
        String item               = rs.getString("SVC_ITEM");

        ServiceKey key = new ServiceKey(sourceObligationId, item);

        OfferComplexType o = new OfferComplexType();

        // Note: serviceQty is the SVC_AGG_QUANTITY, not the
        // SVC_QUANTITY which comes via CDO.
        int serviceQty = rs.getInt("SVC_AGG_QUANTITY");
        if ( !rs.wasNull()) {
            o.setServiceQuantity(serviceQty);
            int consumptionQty = rs.getInt("SVC_CONSUMPTION_QTY");
            if ( !rs.wasNull()) {
                // The available quantity is calculated based on the service
                // quantity and the consumption quantity. If one of these
                // quantities is null, the available quantity cannot be
                // calculated.
                o.setAvailableQuantity(serviceQty-consumptionQty);
            }
        }

        // o.setFromMonth(); -> Warranty only
        // o.setToMonth(); -> Warranty only

        Boolean tmp = convertBoolean(rs.getString("SVC_AGG_INCIDENT_BASED"));
        o.setIncidentBasedOffer((tmp==null) ? false : tmp.booleanValue());

        o.setOfferCode(rs.getString("SVC_PRODUCT_ID"));
        o.setOfferDescription(rs.getString("SVC_DESCRIPTION"));

        tmp = convertBoolean(rs.getString("SVC_AGG_STANDALONE_OFFER"));
        o.setStandAloneOffer((tmp==null) ? false : tmp.booleanValue());

        o.setSvcProductLine(rs.getString("SVC_PRODUCT_LINE"));
        o.setSvcProductType(rs.getString("SVC_PRODUCT_TYPE"));

        ServiceItem i = new ServiceItem();
        i.setAssociatedPkgItem(rs.getString("SVC_ASSOCIATED_PKG"));
        i.setItem(item);

        ctx.addOffer(key, o);
        ctx.addServiceItem(key, i);

        //The following two lines are for PoP. The column is from table "service"
        String serviceStartDateEligibility = rs.getString("SVC_WTY_START_DATE_ELIGIBILITY");
        if (serviceStartDateEligibility != null) {
            ctx.addSvcWtyStartDateEligibility(key, serviceStartDateEligibility);
        }
    }
}
/*
SVC_SOURCE_OBLIGATION_ID
SVC_ITEM
SVC_PRODUCT_ID
SVC_PRODUCT_TYPE
SVC_DESCRIPTION
SVC_PRODUCT_LINE
SVC_QUANTITY
SVC_CONSUMPTION_QTY
SVC_MODIFICATION_DATE
SVC_ASSOCIATED_PKG
SVC_AGG_QUANTITY
SVC_AGG_STANDALONE_OFFER
SVC_AGG_INCIDENT_BASED
*/
