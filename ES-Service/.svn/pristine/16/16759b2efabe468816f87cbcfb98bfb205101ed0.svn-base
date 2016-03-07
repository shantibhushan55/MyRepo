/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ContractLocationResultSetReader.java 1.10 2004-05-08 04:42:45+02 entitlem Exp $
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
 * $Log: ContractLocationResultSetReader.java,v $
 * Revision 1.10  2004-05-08 04:42:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.9  2004-05-05 15:41:35+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.8  2004-01-29 18:07:33+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.7  2003-09-08 15:19:30+02  RONAR
 * Author: RONAR@dhcp-15-197-238-62.bbn.hp.com ()
 * udpated for care pack 6.0
 *
 * Revision 1.6  2003-08-04 16:51:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.5  2003-07-17 17:54:48+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * reformatting
 *
 * Revision 1.4  2003-05-27 10:17:14+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.3  2003-05-12 02:00:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-16 16:14:22+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * change role HWShipTo to ProductShipTo
 *
 * Revision 1.1  2003-04-15 14:01:02+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.ObligHeaderLocation;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.xml.service.ContractComplexType;

/**
 * This class reads the result set for all contract-address relations.<br>
 * <b>Note:</b> This class requires that the Contracts are available in the context,
 * i.e. the ObligationHeaderResultSetReader must be called before! The addresses
 * are not needed before because we just insert the customer IDs.
 */
class ContractLocationResultSetReader extends ResultSetReader {

    // For Customer Indicator we need the reference of ObligationHeader to Location
	private HashMap oHeadLocMap = null;
    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ContractLocationResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
        oHeadLocMap = new HashMap();
    }

    /**
     * Parse one row of the results set and insert the customer IDs into the
     * contracts.
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs)
        throws SQLException {

        String sourceObligationId = rs.getString("OHAR_SOURCE_OBLIGATION_ID");

        ObligationHeaderKey key = new ObligationHeaderKey(sourceObligationId);

        ContractComplexType c = ctx.getContract(key);
        if (c != null) {
            String sourceCustomerId = rs.getString("OHAR_SOURCE_CUSTOMER_ID");
            String role = rs.getString("OHAR_ROLE");
            if ("SoldTo".equalsIgnoreCase(role)) {
                c.setSoldToCustomerID(sourceCustomerId);
                // For Customer Indicator we need the reference of ObligationHeader to Location
          	  	ObligHeaderLocation oHeadLoc = new ObligHeaderLocation();
          	  	oHeadLoc.setSourceObligationId(sourceObligationId.trim());
          	  	oHeadLoc.setSourceCustomerId(sourceCustomerId.trim());
          	  	oHeadLoc.setObligHeaderRole(role.trim());
          	  	if(!oHeadLocMap.containsKey(sourceObligationId.trim())){
	          	    oHeadLocMap.put(sourceObligationId.trim(),oHeadLoc);	          	  		
          	  	}
            }
            else if ("SWShipTo".equalsIgnoreCase(role)) {
                c.setSWShipToCustomerID(sourceCustomerId);
            }
            else if ("ProductShipTo".equalsIgnoreCase(role)) {
                c.setProductShipToCustomerID(sourceCustomerId);
            }
            else if ("PSP".equalsIgnoreCase(role)) {
                c.setPSPCustomerID(sourceCustomerId);
            }
            else if ("OrderingParty".equalsIgnoreCase(role)) {
                c.setOrderingPartyCustomerID(sourceCustomerId);
            }
        }
    }


	public HashMap getOHeadLocMap() {
		return oHeadLocMap;
	}
}

/*
OHAR_SOURCE_OBLIGATION_ID
OHAR_SOURCE_CUSTOMER_ID
OHAR_ROLE
*/
