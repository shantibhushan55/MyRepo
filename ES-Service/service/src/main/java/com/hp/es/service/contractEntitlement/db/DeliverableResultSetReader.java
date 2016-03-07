/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/DeliverableResultSetReader.java 1.9 2004-05-08 04:42:47+02 entitlem Exp $
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
 * $Log: DeliverableResultSetReader.java,v $
 * Revision 1.9  2004-05-08 04:42:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:36+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-01-29 18:07:34+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-08-27 20:38:26+02  RONAR
 * Author: RONAR@dhcp-15-197-238-62.bbn.hp.com ()
 * Updated for new flag in deliverable table.
 *
 * Revision 1.5  2003-08-04 16:51:54+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-06-05 14:39:38+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * don't set optional int values to 0 if the database has null-values
 *
 * Revision 1.3  2003-05-12 02:00:07+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-16 16:51:59+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * change column names
 *
 * Revision 1.1  2003-04-15 14:01:03+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.DeliverableKey;
import com.hp.es.xml.service.Deliverable;

/**
 * This class reads the result set for deliverables.
 */
class DeliverableResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public DeliverableResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("DLV_SOURCE_OBLIGATION_ID");
        String item               = rs.getString("DLV_SVC_ITEM");
        String name               = rs.getString("DLV_NAME");
        String redDlvCode         = rs.getString("DLV_CODE");

        DeliverableKey key = new DeliverableKey(sourceObligationId, item, name, redDlvCode);

        Deliverable d = new Deliverable();
        int qty = rs.getInt("DLV_RED_DLV_UNITS_AVAILABLE");
        if ( !rs.wasNull()) {
            d.setAvailableQuantity(qty);
        }
        d.setDelivCode(redDlvCode);
        d.setDelivName(name);
        d.setDelivValue(rs.getString("DLV_VALUE"));
        Boolean tmp = convertBoolean(rs.getString("DLV_AGG_INCIDENT_BASED"));
        d.setIncidentBasedDeliverable((tmp==null) ? false : tmp.booleanValue());

        ctx.addDeliverable(key, d);
    }
}

/*
DLV_SOURCE_OBLIGATION_ID
DLV_SVC_ITEM
DLV_NAME
DLV_RED_DLV_CODE
DLV_RED_DLV_UNITS_AVAILABLE
DLV_VALUE
DLV_AGG_INCIDENT_BASED
*/
