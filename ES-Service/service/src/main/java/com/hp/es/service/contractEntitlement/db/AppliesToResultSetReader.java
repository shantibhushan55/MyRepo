/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/AppliesToResultSetReader.java 1.11 2004-09-27 17:56:59+02 stefsobe Exp $
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
 * $Log: AppliesToResultSetReader.java,v $
 * Revision 1.11  2004-09-27 17:56:59+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.10  2004-05-08 04:42:43+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.9  2004-05-05 15:41:33+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.8  2004-02-16 15:40:39+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.7  2004-01-29 18:07:30+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-08-04 16:51:50+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.5  2003-06-25 10:46:53+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * rename and/or add column(s)
 *
 * Revision 1.4  2003-05-12 02:00:03+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.3  2003-04-29 16:25:44+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * skip AppliesTo objects with invalid type
 *
 * Revision 1.2  2003-04-16 16:13:30+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * change status column
 *
 * Revision 1.1  2003-04-15 14:01:02+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.AppliesToKey;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.ProfitCenter;
import com.hp.es.xml.service.types.StatusType;


/**
 * This class reads the result set for applies-to.
 */
class AppliesToResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public AppliesToResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("SAT_SOURCE_OBLIGATION_ID");
        String item               = rs.getString("SAT_SVC_ITEM");
        String oosKey             = rs.getString("SAT_OOS_KEY");

        AppliesToKey key = new AppliesToKey(sourceObligationId, item, oosKey);

        AppliesTo a = new AppliesTo();

        String type = rs.getString("AGG_SVC_STATUS");
        try {
            a.setStatus(StatusType.valueOf(type));
        }
        catch (Exception e) {
            ESLog.error("AppliesTo->StatusType='" + type
                    + "' is not supported. (ObligationHeaderID='"
                    + sourceObligationId + "')");
            // skip that AppliesTo
            return;
        }


        a.setEndDate(convertDate(rs.getDate("SAT_AGG_END_DATE")));
        a.setOOSKey(oosKey);

        // Group the following 4 attributes into "ProfitCenter". If at least
        // one element is available, the ProfitCenter is returned.
        String entity     = rs.getString("SAT_PROFIT_CENTER_ENTITY");
        String subentity  = rs.getString("SAT_PROFIT_CENTER_SUBENTITY");
        String department = rs.getString("SAT_PROFIT_CENTER_DEPARTMENT");
        String workforce  = rs.getString("SAT_PROFIT_CENTER_WORKFORCE");
        if (entity!=null || subentity!=null || department!=null || workforce!=null) {
            ProfitCenter p = new ProfitCenter();
            p.setDepartment(department);
            p.setEntity(entity);
            p.setSubEntity(subentity);
            p.setWorkforce(workforce);
            a.setProfitCenter(p);
        }

        a.setStartDate(convertDate(rs.getDate("SAT_AGG_START_DATE")));

        Boolean tmpBoolean = convertBoolean(rs.getString("AGG_ACTIVE_SVC"));
        if (tmpBoolean!=null) {
            a.setActiveAppliesTo(tmpBoolean.booleanValue());
        }
        else {
            ESLog.error("AGG_ACTIVE_SVC was null but it is mandatory");
            a.setActiveAppliesTo(false);
        }

        a.setDeliveryBlock(rs.getString("SAT_AGG_DELIVERY_BLOCK"));

        ctx.addAppliesTo(key, a);
    }
}

/*
SAT_SOURCE_OBLIGATION_ID
SAT_SVC_ITEM
SAT_OOS_KEY
SAT_PROFIT_CENTER_ENTITY
SAT_PROFIT_CENTER_SUBENTITY
SAT_PROFIT_CENTER_DEPARTMENT
SAT_PROFIT_CENTER_WORKFORCE
SAT_START_DATE
SAT_END_DATE
SAT_AGG_DELIVERY_BLOCK
AGG_ACTIVE_SVC
AGG_SVC_STATUS
*/

