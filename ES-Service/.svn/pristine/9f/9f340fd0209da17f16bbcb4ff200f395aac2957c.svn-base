/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ServiceProductTypeResultSetReader.java 1.10 2004-09-27 17:57:04+02 stefsobe Exp $
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
 * $Log: ServiceProductTypeResultSetReader.java,v $
 * Revision 1.10  2004-09-27 17:57:04+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.9  2004-05-08 04:42:53+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:43+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-03-15 15:22:12+01  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * fix possible null pointer exceptions
 *
 * Revision 1.6  2004-01-29 18:07:41+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:52:00+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-07-18 11:52:42+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * rename getContract() to getUniqueContract()
 *
 * Revision 1.3  2003-05-12 02:00:13+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-25 12:12:36+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * add only unique service produc types
 *
 * Revision 1.1  2003-04-15 17:59:20+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 * Revision 1.1  2003-04-15 14:01:02+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.xml.service.ContractComplexType;

/**
 * This class reads the result set for service product types and adds
 * the service product type to the contract. It ensures that only unique
 * service product types are added.
 * <b>Note:</b> This class requires that the contracts are available in the context,
 * i.e. the ObligationHeaderResultSetReader must be called before!
 */
class ServiceProductTypeResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ServiceProductTypeResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("SVC_SOURCE_OBLIGATION_ID");
        ObligationHeaderKey key = new ObligationHeaderKey(sourceObligationId);

        // The same contract can be returned for different keys, i.e.
        // if the database returns the same service product type for
        // different source obligation IDs, we would duplicate the
        // service product type. Therefore, the method checks if the
        // service product type already exists.
        ContractComplexType c = ctx.getUniqueContract(key);
        if (c!=null) {
            String type = rs.getString("SVC_PRODUCT_TYPE");
            if (type!=null) {
                // the following simple algorithm should not be a
                // performance issue because there are just 6
                // different service product types
                Enumeration enumeration = c.enumerateSvcProductType();
                while (enumeration.hasMoreElements()) {
                    if (type.equals(enumeration.nextElement())) {
                        // if already exists then don't add a duplicate
                        // entry
                        return;
                    }
                }
                c.addSvcProductType(type);
            }
        }
    }
}

/*
SVC_SOURCE_OBLIGATION_ID
SVC_PRODUCT_TYPE
*/
