/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/LocationResultSetReader.java 1.9 2004-09-27 17:57:01+02 stefsobe Exp $
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
 * $Log: LocationResultSetReader.java,v $
 * Revision 1.9  2004-09-27 17:57:01+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.8  2004-05-08 04:42:48+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.7  2004-05-05 15:41:37+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.6  2004-02-16 15:40:42+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.5  2004-01-29 18:07:35+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.4  2003-09-18 11:03:07+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * new db field adr_external_psp_id added
 *
 * Revision 1.3  2003-08-04 16:51:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 02:00:08+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
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
import com.hp.es.service.contractEntitlement.keys.LocationKey;
import com.hp.es.xml.service.LocationComplexType;

/**
 * This class reads the result set for all addresses
 */
class LocationResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public LocationResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceCustomerId = rs.getString("ADR_SOURCE_CUSTOMER_ID");

        LocationKey key = new LocationKey(sourceCustomerId);

        LocationComplexType l = new LocationComplexType();
        l.setCity(rs.getString("ADR_CITY"));
        l.setFmtAddrLine1(rs.getString("ADR_FMT_ADDRESS_LINE_1"));
        l.setFmtAddrLine2(rs.getString("ADR_FMT_ADDRESS_LINE_2"));
        l.setFmtAddrLine3(rs.getString("ADR_FMT_ADDRESS_LINE_3"));
        l.setFmtAddrLine4(rs.getString("ADR_FMT_ADDRESS_LINE_4"));
        l.setFmtAddrLine5(rs.getString("ADR_FMT_ADDRESS_LINE_5"));
        l.setGeographicArea(rs.getString("ADR_GEOGRAPHIC_AREA"));
        l.setIsoCountryCd(rs.getString("ADR_ISO_COUNTRY_CODE"));
        l.setPostalCode(rs.getString("ADR_POSTAL_CODE"));
        l.setSiteBusinessName1(rs.getString("ADR_SITE_BUSINESS_NAME_1"));
        l.setSiteBusinessName2(rs.getString("ADR_SITE_BUSINESS_NAME_2"));
        l.setSiteBusinessName3(rs.getString("ADR_SITE_BUSINESS_NAME_3"));
        l.setSiteBusinessName4(rs.getString("ADR_SITE_BUSINESS_NAME_4"));
        l.setSourceCustomerID(sourceCustomerId);
        l.setStreetAddr1(rs.getString("ADR_STREET_1"));
        l.setStreetAddr2(rs.getString("ADR_STREET_2"));
        l.setPSPID(rs.getString("ADR_EXTERNAL_PSP_ID"));

        ctx.addLocation(key, l);
    }
}

/*
ADR_SOURCE_CUSTOMER_ID
ADR_SITE_BUSINESS_NAME_1
ADR_SITE_BUSINESS_NAME_2
ADR_SITE_BUSINESS_NAME_3
ADR_SITE_BUSINESS_NAME_4
ADR_FMT_ADDRESS_LINE_1
ADR_FMT_ADDRESS_LINE_2
ADR_FMT_ADDRESS_LINE_3
ADR_FMT_ADDRESS_LINE_4
ADR_FMT_ADDRESS_LINE_5
ADR_STREET_1
ADR_STREET_2
ADR_BUILDING_NAME
ADR_MAIL_STOP
ADR_POST_BOX_NUM
ADR_CITY
ADR_CITY_AREA
ADR_CITY_SUB_AREA
ADR_GEOGRAPHIC_AREA
ADR_GEOGRAPHIC_SUB_AREA
ADR_POSTAL_CODE
ADR_ISO_COUNTRY_CODE
*/

