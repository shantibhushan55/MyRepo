/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ObligationHeaderResultSetReader.java 1.13 2004-09-27 17:57:01+02 stefsobe Exp $
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
 * $Log: ObligationHeaderResultSetReader.java,v $
 * Revision 1.13  2004-09-27 17:57:01+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.12  2004-05-08 04:42:49+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.11  2004-05-05 15:41:38+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.10  2004-02-16 15:40:42+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.9  2004-01-29 18:07:36+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.8  2003-09-08 15:19:47+02  RONAR
 * Author: RONAR@dhcp-15-197-238-62.bbn.hp.com ()
 * updated for 6.0 care pack
 *
 * Revision 1.7  2003-08-04 16:51:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.6  2003-06-25 10:46:53+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * rename and/or add column(s)
 *
 * Revision 1.5  2003-06-13 13:25:12+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * use aggregarted data for  BlueSupportLevelForSGID
 * and BlueSupportLevelForSGIDSource
 *
 * Revision 1.4  2003-05-27 10:17:16+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.3  2003-05-12 02:00:08+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-16 16:15:29+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * fill missing attributes
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
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.types.ContractStatusType;

/**
 * This class reads the result set for obligation headers.
 */
class ObligationHeaderResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ObligationHeaderResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {
        Boolean tmpBoolean = null;

        String sourceObligationId = rs.getString("OHDR_SOURCE_OBLIGATION_ID");
        ObligationHeaderKey key = new ObligationHeaderKey(sourceObligationId);

        // ====================================================================
        ContractComplexType c = new ContractComplexType();
        // c.setActiveContractEntitlement(); -> derived from ???
        c.setAMPID(rs.getString("OHDR_AMP_ID"));
        // Note: The following two elements uses the OHDR_AGG_xxx columns:
        c.setBlueSupportLevelForSGID(rs.getString("OHDR_AGG_SUPP_LEVEL_FOR_SGID"));
        c.setBlueSupportLevelForSGIDSource(rs.getString("OHDR_AGG_SUPP_LEVEL_SOURCE"));

        // c.setCCRN(); -> derived from ObligationHeader
        c.setCdoPublishDate(formatTimestamp(rs.getTimestamp("CDO_LAST_PUBLISHED_DATE")));
        c.setCustomerSegment(rs.getString("OHDR_CUSTOMER_SEGMENT"));
        c.setCustServiceAgreement(rs.getString("OHDR_CSSA_NUMBER"));
        c.setDataEntrySite(rs.getString("OHDR_AGG_BLUE_DATA_ENTRY_SITE"));
        c.setOOSGroupID(rs.getString("OHDR_AGG_BLUE_FUNC_LOC"));

        // c.setHeaderEndDate(rs.getString(""));  -> is derived from obligation header
        // c.setHeaderStartDate(rs.getString(""));  -> is derived from obligation header

        c.setProductShipToCountryCode(rs.getString("OHDR_AGG_SHIP_TO_COUNTRY_CODE"));
        // c.setHWShipToCustomerID(rs.getString("")); -> will be set later
        // c.setHWShipToPersonID(rs.getString(""));  -> will be set later

        tmpBoolean = convertBoolean(rs.getString("OHDR_AGG_MISSION_CRITICAL"));
        if (tmpBoolean!=null) {
          c.setMissionCritical(tmpBoolean.booleanValue());
        }

        // c.setOOSGroupID(rs.getString("")); -> derived from OOS

        tmpBoolean = convertBoolean(rs.getString("OHDR_AGG_PENALTY"));
        if (tmpBoolean!=null) {
          c.setPenalty(tmpBoolean.booleanValue());
        }

        tmpBoolean = convertBoolean(rs.getString("OHDR_AGG_SPECIAL_HANDLING"));
        if (tmpBoolean!=null) {
          c.setSpecialHandling(tmpBoolean.booleanValue());
        }

        c.setPortfolioFlag(rs.getString("OHDR_PORTFOLIO"));
        c.setRCXDescription(rs.getString("OHDR_AGG_RCX_DESCRIPTION"));
        c.setRCXResponsibleEngineer(rs.getString("OHDR_AGG_RCX_RESP_ENGINEER"));
        c.setRCXServiceLevel(rs.getString("OHDR_AGG_RCX_SVC_LEVEL"));
        c.setRedContractID(rs.getString("OHDR_RED_CONTRACT_ID"));
        // c.setSoldToCustomerID(rs.getString("")); -> will be set later
        c.setSupportGroupID(rs.getString("OHDR_SUPPORT_GROUP_ID"));
        c.setSvcAgreementID(rs.getString("OHDR_SVC_AGREEMENT_ID"));
        // c.setSvcProductType(rs.getString("")); -> derived from Offer
        // c.setSWShipToCustomerID(rs.getString("")); -> will be set later
        // c.setSWShipToPersonID(rs.getString("")); -> will be set later

        c.setSysModel(rs.getString("OHDR_AGG_BLUE_SYS_MODEL"));

        // c.setSystemMgrPersonID(rs.getString("")); -> will be set later

        c.setSysType(rs.getString("OHDR_AGG_BLUE_SYS_TYPE"));

        // change for OHDR_HP_CARE_PACK_SERIAL_NO --- 6.0
        c.setHPCarePackSerialNumber(rs.getString("OHDR_HP_CARE_PACK_SERIAL_NO"));

        // ====================================================================
        ObligationHeader o = new ObligationHeader();
        o.setCCRN(rs.getString("OHDR_CCRN"));

        // column name needs to be updated...
        String contractStatusType = rs.getString("AGG_CONTRACT_STATUS");
        try {
            ContractStatusType type = ContractStatusType.valueOf(contractStatusType);
            o.setContractStatus(type);
        }
        catch (Exception e) {
            ESLog.info("ContractStatusType='" + contractStatusType
                    + "' is not supported. (ObligationHeaderID='"
                    + sourceObligationId + "')");
        }

        o.setCustPurchaseOrder(rs.getString("OHDR_CUST_PURCHASE_ORDER"));
        o.setDeliveryBlock(rs.getString("OHDR_DELIVERY_BLOCK"));
        o.setHeaderEndDate(convertDate(rs.getDate("OHDR_END_DATE")));
        o.setHeaderStartDate(convertDate(rs.getDate("OHDR_START_DATE")));
        o.setObligationType(rs.getString("OHDR_OBLIGATION_TYPE"));
        o.setOriginatingOrder(rs.getString("OHDR_ORIGINATING_ORDER"));
        o.setChannelProfile(rs.getString("OHDR_CHANNEL_PROFILE"));
        o.setChannelRelationship(rs.getString("OHDR_CHANNEL_RELATIONSHIP"));
        o.setSourceObligationID(sourceObligationId);

        tmpBoolean = convertBoolean(rs.getString("AGG_ACTIVE_CONTRACT"));
        if (tmpBoolean!=null) {
            o.setActiveObligation(tmpBoolean.booleanValue());
        }
        else {
            ESLog.info("AGG_ACTIVE_CONTRACT was null but it is mandatory");
            o.setActiveObligation(false);
        }

        // ====================================================================
        ctx.addObligationHeader(key, o);
        ctx.addContract(key, c);
    }
}

/*
OHDR_SOURCE_OBLIGATION_ID
OHDR_SVC_AGREEMENT_ID
OHDR_CCRN
OHDR_OBLIGATION_TYPE
OHDR_PORTFOLIO
OHDR_CONTRACT_STATUS
OHDR_ORIG_START_DATE
OHDR_START_DATE
OHDR_END_DATE
OHDR_RENEWAL_DATE
OHDR_CUST_PURCHASE_ORDER
OHDR_CHANNEL_RELATIONSHIP
OHDR_CONTRACT_CATEGORY
OHDR_CONTRACT_HANDLING
OHDR_EVERGREEN
OHDR_NET_VALUE_EST
OHDR_CURRENCY
OHDR_DELIVERY_BLOCK
OHDR_SW_DISTRIBUTION_CODE
OHDR_SUPPORT_GROUP_ID
OHDR_AMP_ID
OHDR_CSSA_NUMBER
OHDR_INVOICE_GROUP
OHDR_ORIGINATING_ORDER
OHDR_SALES_ORG
OHDR_MODIFICATION_DATE
OHDR_CUSTOMER_SEGMENT
OHDR_CHANNEL_PROFILE
OHDR_MAJOR_ACCT_ID
OHDR_PREV_OBLIGATION_ID
OHDR_SI_TYPE
OHDR_SI_TEXT
OHDR_RED_PROGRAM_CODE_1
OHDR_RED_PROGRAM_CODE_2
OHDR_RED_PROGRAM_CODE_3
OHDR_AGG_MISSION_CRITICAL
OHDR_AGG_OPEN_ENV_SUPPORT
OHDR_AGG_RCX_SVC_LEVEL
OHDR_AGG_RCX_DESCRIPTION
OHDR_AGG_RCX_RESP_ENGINEER
OHDR_AGG_HS
OHDR_AGG_SS
OHDR_AGG_PS
OHDR_AGG_PENALTY
OHDR_AGG_SHIP_TO_COUNTRY_CODE
OHDR_RED_CONTRACT_ID
OHDR_AGG_SUPP_LEVEL_FOR_SGID
OHDR_AGG_SUPP_LEVEL_SOURCE
AGG_ACTIVE_CONTRACT

List of columns that are currently not used:
===========================================

OHDR_ORIG_START_DATE
OHDR_RENEWAL_DATE
OHDR_CHANNEL_RELATIONSHIP
OHDR_CONTRACT_CATEGORY
OHDR_CONTRACT_HANDLING
OHDR_EVERGREEN
OHDR_NET_VALUE_EST
OHDR_CURRENCY
OHDR_SW_DISTRIBUTION_CODE
OHDR_CSSA_NUMBER
OHDR_INVOICE_GROUP
OHDR_SALES_ORG
OHDR_CHANNEL_PROFILE
OHDR_MAJOR_ACCT_ID
OHDR_PREV_OBLIGATION_ID
OHDR_MODIFICATION_DATE
OHDR_SI_TYPE
OHDR_SI_TEXT
OHDR_RED_PROGRAM_CODE_1
OHDR_RED_PROGRAM_CODE_2
OHDR_RED_PROGRAM_CODE_3
OHDR_AGG_OPEN_ENV_SUPPORT
OHDR_SUPP_LEVEL_FOR_SGID
OHDR_SUPP_LEVEL_FOR_SGID_SRC
OHDR_AGG_HS
OHDR_AGG_SS
OHDR_AGG_PS
*/

