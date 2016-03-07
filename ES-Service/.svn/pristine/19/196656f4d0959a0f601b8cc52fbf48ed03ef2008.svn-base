/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/DbContractEntitlementManager.java 1.40 2004-09-27 17:57:00+02 stefsobe Exp $
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
 * $Log: DbContractEntitlementManager.java,v $
 * Revision 1.40  2004-09-27 17:57:00+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.39  2004-09-14 17:03:40+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * minor change
 *
 * Revision 1.38  2004-07-01 15:20:08+02  wanglon
 * Author: wanglon@sh01015.china.hp.com ()
 * Update the error message for WITS 851
 *
 * Revision 1.37  2004-07-01 15:10:46+02  wanglon
 * Author: wanglon@sh01015.china.hp.com ()
 * If a SQLException ORA-06512

 * occurred (in one of the 3 methods), log the exception to the log file

 * but throw en SifException PARAMETER_HAS_INVALID_DATA (201).

 *
 * Revision 1.36  2004-06-28 12:47:31+02  yipa
 * Author: yipa@15.96.142.153 ()
 * no comment
 *
 * Revision 1.35  2004-06-26 04:19:26+02  yipa
 * Author: yipa@15.123.190.5 ()
 * update the index of getcontractent paras.
 *
 * Revision 1.34  2004-06-22 10:48:50+02  yipa
 * Author: yipa@15.96.142.153 ()
 * add customerdefinedid for es8.0c2.
 *
 * Revision 1.33  2004-05-08 04:42:46+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.32  2004-05-05 15:41:36+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.31  2004-04-23 13:34:16+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * fixed parameter index for stored proc; changed comment
 *
 * Revision 1.30  2004-04-23 11:50:57+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * fixed parameter index for stored proc
 *
 * Revision 1.29  2004-04-23 11:27:17+02  yipa
 * Author: yipa@15.96.142.153 ()
 * change for WFM CR ES612
 *
 * Revision 1.28  2004-04-15 09:40:24+02  zhangliw
 * Author: zhangliw@sh210058.china.hp.com ()
 * Removed ITO error log while throwing DatabaseDownException
 *
 * Revision 1.27  2004-02-16 15:40:40+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.26  2004-02-12 18:06:09+01  stefsobe
 * Author: stefsobe@sobesteffen ()
 * add redGroupSerialNo and MNContractSourceDoc
 *
 * Revision 1.25  2004-01-29 18:07:33+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.24  2003-12-03 16:57:14+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * let DbContractEntitlementManager return an error code in case of "no data found"
 *
 * Revision 1.23  2003-10-22 16:02:39+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * replace DataEntrySite with IsoCountryCd for PA operation;
 * add get_pa_entitlement_6 procedure
 *
 * Revision 1.22  2003-09-08 15:19:42+02  RONAR
 * Author: RONAR@dhcp-15-197-238-62.bbn.hp.com ()
 * updated for 6.0 care pack
 *
 * Revision 1.21  2003-08-04 16:51:53+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.20  2003-07-15 21:01:39+02  lbednari
 * Author: lbednari@dhcp-15-197-229-125.bbn.hp.com ()
 * no comment
 *
 * Revision 1.18  2003-07-14 15:22:59+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * use TransactionMonitor
 *
 * Revision 1.17  2003-06-16 14:28:13+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * fix exception (bind-variable doesn't exist)
 *
 * Revision 1.16  2003-06-13 13:24:14+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * add flag StandaloneOffersOnly;

 * for PA: replace source-customer ID with data entry site
 *
 * Revision 1.15  2003-06-04 15:26:40+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * enhance log output when exception occured
 *
 * Revision 1.14  2003-05-27 16:07:12+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * add JavaDoc
 *
 * Revision 1.13  2003-05-27 14:47:27+02  THKOE
 * Author: THKOE@dhcp-15-197-238-218.bbn.hp.com ()
 * getPrintAdvantageEntitlement now calls the get_pa_entitlement sql-method
 *
 * Revision 1.12  2003-05-27 10:17:14+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.11  2003-05-22 14:26:16+02  THKOE
 * Author: THKOE@dhcp-15-197-238-218.bbn.hp.com ()
 * added method for PrintAdvantageEntitlement operation
 *
 * Revision 1.10  2003-05-12 02:00:06+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.9  2003-05-05 11:28:56+02  lbednari
 * Author: lbednari@bbnnaid103.bbn.hp.com ()
 * - making sure all ResultSets are closed even if there is an error while reading one of them
 *
 * Revision 1.8  2003-04-23 08:40:23+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * div bugfixes
 *
 * Revision 1.7  2003-04-17 09:00:54+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * DB access for the getAssociatedContractsOperation added
 *
 * Revision 1.6  2003-04-16 16:27:36+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * remove hardcoded stuff
 *
 * Revision 1.5  2003-04-16 16:15:04+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * no comment
 *
 * Revision 1.4  2003-04-16 09:25:47+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * replace tabs
 *
 * Revision 1.3  2003-04-15 17:59:01+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * add ServiceProductTypeResultSetReader;

 * update parameter for DB procedure
 *
 * Revision 1.2  2003-04-15 17:27:27+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * getAssociatedContracts started
 *
 * Revision 1.1  2003-04-15 14:01:03+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import oracle.jdbc.OracleTypes;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.db.DbConnectionManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.OracleHelper;
import com.hp.es.xml.service.types.AssociatedContractIdentifierTypeType;
import com.hp.es.xml.service.types.ContractIdentifierTypeType;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * This class handles the access to the database for all requests
 * related to contract entitlement.
 */
public class DbContractEntitlementManager  {

	static protected final String CONTRACT_FILTERING_PORTFOLIO_PROPERTY = "es.contractservice.ODS.filtering";
	static protected final String DEFAULT_CONTRACT_FILTERING_PORTFOLIO_PROPERTY = "G";
	private String _portfolioFiltering = DEFAULT_CONTRACT_FILTERING_PORTFOLIO_PROPERTY;
	
	
	//private DbConnectionManager connectionManager;
    
    // For Customer Indicator we need the reference of ObligationHeader to Location
	private HashMap oHeadLocMap = null;

    static final private String GET_CONTRACT_ENTITLEMENT =
        "{call es.get_contract_entitlement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                                          "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                                          "?,?,?,?,?,?)}";

/* es9.0.0C3 get_contract_entitlement interface
get_contract_entitlement (
    1   p_identifier              IN       VARCHAR2,
    2   p_identifier_type         IN       VARCHAR2,
    3   p_data_entry_site         IN       VARCHAR2,
    4   p_product_id              IN       VARCHAR2,
    5   p_serial_number           IN       VARCHAR2,
    6   p_source_customer_id      IN       VARCHAR2,
    7   p_red_access_id           IN       VARCHAR2,
    8   p_red_group_serial_no     IN       VARCHAR2,
    9   p_mn_contract_source_doc  IN       VARCHAR2,
    10  p_ship_to_country_code    IN       VARCHAR2,
    11  p_customer_defined_id     IN       VARCHAR2,
    12  p_check_date              IN       DATE,
    13  p_active_contracts_only   IN       CHAR DEFAULT 'N',
    14  p_active_services_only    IN       CHAR DEFAULT 'N',
    15  p_standalone_offers_only  IN       CHAR DEFAULT 'N',
    16  p_detail_level            IN       VARCHAR2,
    17  p_filter_oos_by_country   IN       CHAR DEFAULT 'N',
    18  p_is_psg_unit             IN       CHAR DEFAULT 'N',
    19  p_exclude_portfolios      IN       VARCHAR2,  -- comma separated list of portfolios (G, S or C) which are filterred out
    20  p_error_code              OUT      NUMBER,
    21  p_ohdr_cursor             OUT      es_output.es_cursor,
    22  p_svc_cursor              OUT      es_output.es_cursor,
    23  p_smod_cursor             OUT      es_output.es_cursor,
    24  p_dlv_cursor              OUT      es_output.es_cursor,
    25  p_dmod_cursor             OUT      es_output.es_cursor,
    26  p_sat_cursor              OUT      es_output.es_cursor,
    27  p_oos_cursor              OUT      es_output.es_cursor,
    28  p_oou_cursor              OUT      es_output.es_cursor,
    29  p_adr_cursor              OUT      es_output.es_cursor,
    30  p_ohar_cursor             OUT      es_output.es_cursor,
    31  p_oar_cursor              OUT      es_output.es_cursor,
    32  p_cnt_cursor              OUT      es_output.es_cursor,
    33  p_ohcr_cursor             OUT      es_output.es_cursor,
    34  p_ocr_cursor              OUT      es_output.es_cursor,
    35  p_cntc_cursor             OUT      es_output.es_cursor,
    36  p_svc_type_cursor         OUT      es_output.es_cursor)       */

    /**
     * Call the database procedure get_contract_entitlement() and read all
     * returned cursors. All results are stored in the EsReplyContext.
     * @param context used to store all found results
     * @param identifier contract identifier
     * @param identifierType the type of contract identifier
     * @param dataEntrySite Data Entry Site for blue contracts
     * @param productId the product number
     * @param serialNumber the serial number
     * @param sourceCustomerId the identifier that uniquely identifies the
     *                  customer address
     * @param redAccessId the identifier for red contracts
     * @param checkDate ???
     * @return error ID returned from database
     * @return error ID
     */
    public int getContractEntitlement(
        EsReplyContext context,
        String identifier,
        ContractIdentifierTypeType identifierType,
        String dataEntrySite,
        String productId,
        String serialNumber,
        String sourceCustomerId,
        String redAccessId,
        String redGroupSerialNo,
        String mnContractSourceDoc,
        String shipToCountryCodeId,
        String customerDefinedId,
        org.exolab.castor.types.Date entitlementCheckDate,
        boolean activeContractsOnly,
        boolean activeServicesOnly,
        boolean standaloneOffersOnly,
        OutputDetails detailLevel,
        boolean    filter_oos_by_country,
        MetricsHandler mh,
        boolean isPSGUnitSearch)
        throws DatabaseDownException, DataAccessException,SifException{


        Connection connection = null;
        CallableStatement statement = null;
        int errorCode = 0;

        ResultSet ohrs = null;
        ResultSet srs= null;
        ResultSet smrs= null;
        ResultSet drs= null;
        ResultSet dmrs= null;
        ResultSet atrs= null;
        ResultSet oosrs= null;
        ResultSet snrs = null;
        ResultSet lrs = null;
        ResultSet clrs = null;
        ResultSet ooslrs = null;
        ResultSet crs = null;
        ResultSet ccrs = null;
        ResultSet ooscrs = null;
        ResultSet ccommrs = null;
        ResultSet sptrs = null;
        java.sql.Date checkDate = null;
        MetricsEntry stmtExec = null;
        MetricsEntry getRs = null;
        try {
            connection = DbConnectionManager.getInstance().getReadonlyConnection();

            connection.setAutoCommit(false);

            statement = connection.prepareCall(GET_CONTRACT_ENTITLEMENT);

            // convert the checkDate to java.sql.Date
            if (entitlementCheckDate!=null) {
                checkDate = new java.sql.Date(entitlementCheckDate.toDate().getTime());
            }

            statement.setString( 1, identifier);
            statement.setString( 2, (identifierType==null ? null : identifierType.toString()));
            statement.setString( 3, dataEntrySite);
            statement.setString( 4, productId);
            statement.setString( 5, serialNumber);
            statement.setString( 6, sourceCustomerId);
            statement.setString( 7, redAccessId);
            statement.setString( 8, redGroupSerialNo);  // RedGroupSerialNo
            statement.setString( 9, mnContractSourceDoc);
            statement.setString(10, shipToCountryCodeId);
            statement.setString(11, customerDefinedId);
            statement.setDate  (12, checkDate);
            statement.setString(13, activeContractsOnly  ? "Y" : "N" );
            statement.setString(14, activeServicesOnly   ? "Y" : "N");
            statement.setString(15, standaloneOffersOnly ? "Y" : "N");
            statement.setString(16, detailLevel==null ? null : detailLevel.toDbString() );
            statement.setString(17, filter_oos_by_country ? "Y" : "N");
            statement.setString(18, isPSGUnitSearch? "Y" : "N");
            //This is not a parameter but a field as this must be use by all calls.
            statement.setString(19,_portfolioFiltering );
            statement.registerOutParameter(20, OracleTypes.INTEGER);
            for (int i=21; i<=36; i++) {
                statement.registerOutParameter(i, OracleTypes.CURSOR);
            }
            if(mh != null)
            	stmtExec = mh.startEntry("getContEnt_SqlExec");
            
            statement.execute();
            
            
            if(stmtExec!=null) {
            	stmtExec.actionDone();
            	stmtExec = null;
            }

            // any error occured?
            errorCode = statement.getInt(20);

            // Now read all returned cursors and store the data in the context.
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: ohrs");
            ohrs =      (ResultSet)statement.getObject(21);
            
            
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: srs");
            srs =       (ResultSet)statement.getObject(22);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: smrs");
            smrs =      (ResultSet)statement.getObject(23);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: drs");
            drs =       (ResultSet)statement.getObject(24);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: dmrs");
            dmrs =      (ResultSet)statement.getObject(25);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: atrs");
            atrs =      (ResultSet)statement.getObject(26);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: oosrs");
            oosrs =     (ResultSet)statement.getObject(27);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: snrs");
            snrs =      (ResultSet)statement.getObject(28);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: lrs");
            lrs =       (ResultSet)statement.getObject(29);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: clrs");
            clrs =      (ResultSet)statement.getObject(30);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: ooslrs");
            ooslrs =    (ResultSet)statement.getObject(31);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: crs");
            crs =       (ResultSet)statement.getObject(32);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: ccrs");
            ccrs =      (ResultSet)statement.getObject(33);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: ooscrs");
            ooscrs =    (ResultSet)statement.getObject(34);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: ccommrs");
            ccommrs =   (ResultSet)statement.getObject(35);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getContEnt_GetRS: sptrs");
            sptrs =     (ResultSet)statement.getObject(36);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            

            //================================================================
            ObligationHeaderResultSetReader ohrsr =
                        new ObligationHeaderResultSetReader(context, ohrs);
            ohrsr.run(mh);
            //================================================================
            ServiceResultSetReader srsr =
                        new ServiceResultSetReader(context, srs);
            srsr.run(mh);
            //================================================================
            SvcModifierResultSetReader smrsr =
                        new SvcModifierResultSetReader(context, smrs);
            smrsr.run(mh);
            //================================================================
            DeliverableResultSetReader drsr =
                        new DeliverableResultSetReader(context, drs);
            drsr.run(mh);
            //================================================================
            DlvModifierResultSetReader dmrsr =
                        new DlvModifierResultSetReader(context, dmrs);
            dmrsr.run(mh);
            //================================================================
            AppliesToResultSetReader atrsr =
                        new AppliesToResultSetReader(context, atrs);
            atrsr.run(mh);
            //================================================================
            OOSResultSetReader oosrsr =
                        new OOSResultSetReader(context, oosrs);
            oosrsr.run(mh);
            //================================================================
            // Note: OOSResultSetReader has to be finished before the
            // SerialNumberResultSetReader is called.
            SerialNumberResultSetReader snrsr =
                        new SerialNumberResultSetReader(context, snrs);
            snrsr.run(mh);
            //================================================================
            LocationResultSetReader lrsr =
                        new LocationResultSetReader(context, lrs);
            lrsr.run(mh);
            //================================================================
            // Note: ObligationHeaderResultSetReader has to be finished before
            // the ContractLocationResultSetReader is called.
            ContractLocationResultSetReader clrsr =
                        new ContractLocationResultSetReader(context, clrs);
            clrsr.run(mh);

            // For Customer Indicator we need the reference of ObligationHeader to Location
            setOHeadLocMap(clrsr.getOHeadLocMap());
            
            
            //================================================================
            // Note: OOSResultSetReader has to be finished before
            // the OOSLocationResultSetReader is called.
            OOSLocationResultSetReader ooslrsr =
                        new OOSLocationResultSetReader(context, ooslrs);
            ooslrsr.run(mh);
            //================================================================
            ContactsResultSetReader crsr =
                        new ContactsResultSetReader(context, crs);
            crsr.run(mh);
            //================================================================
            ContractContactResultSetReader ccrsr =
                        new ContractContactResultSetReader(context, ccrs);
            ccrsr.run(mh);
            //================================================================
            // Note: OOSResultSetReader has to be finished before
            // the OOSContactResultSetReader is called.
            OOSContactResultSetReader ooscrsr =
                        new OOSContactResultSetReader(context, ooscrs);
            ooscrsr.run(mh);
            //================================================================
            // Note: ContactsResultSetReader has to be finished before
            // the ContactCommunicationResultSetReader is called.
            ContactCommunicationResultSetReader ccommrsr =
                        new ContactCommunicationResultSetReader(context, ccommrs);
            ccommrsr.run(mh);
            //================================================================
            // Note: ObligationHeaderResultSetReader has to be finished before
            // the ServiceProductTypeResultSetReader is called.
            ServiceProductTypeResultSetReader sptrsr =
                        new ServiceProductTypeResultSetReader(context, sptrs);
            sptrsr.run(mh);
        }
        catch (SQLException e) {
            String nl = System.getProperty("line.separator");
            StringBuffer buf = new StringBuffer();
            buf.append(nl);
            buf.append("identifier=");
            buf.append(identifier);
            buf.append(nl);
            buf.append("identifierType=");
            buf.append((identifierType==null ? null : identifierType.toString()));
            buf.append(nl);
            buf.append("dataEntrySite=");
            buf.append(dataEntrySite);
            buf.append(nl);
            buf.append("productId=");
            buf.append(productId);
            buf.append(nl);
            buf.append("serialNumber=");
            buf.append(serialNumber);
            buf.append(nl);
            buf.append("sourceCustomerId=");
            buf.append(sourceCustomerId);
            buf.append(nl);
            buf.append("redAccessId=");
            buf.append(redAccessId);
            buf.append(nl);
            buf.append("redGroupSerialNo=");
            buf.append(redGroupSerialNo);
            buf.append(nl);
            buf.append("mnContractSourceDoc=");
            buf.append(mnContractSourceDoc);
            buf.append(nl);
            buf.append("shipToCountryCodeId=");
            buf.append(shipToCountryCodeId);
            buf.append(nl);
            buf.append("customerDefinedId=");
            buf.append(customerDefinedId);
            buf.append(nl);
            buf.append("checkDate=");
            buf.append(checkDate);
            buf.append(nl);
            buf.append("activeContractsOnly=");
            buf.append((activeContractsOnly ? "Y" : "N" ));
            buf.append(nl);
            buf.append("activeServicesOnly=");
            buf.append((activeServicesOnly  ? "Y" : "N"));
            buf.append(nl);
            buf.append("detailLevel=");
            buf.append((detailLevel==null ? null : detailLevel.toDbString()));

            throwException(e, "DbContractEntitlementManager.getContractEntitlement",
                            buf.toString());
        }
        finally {
            //MetricsEntry allClose = mh.startEntry("getContEnt_CloseAll");
     		try { ohrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { srs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { smrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { drs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { dmrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { atrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { oosrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { snrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { lrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { clrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { ooslrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { crs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { ccrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { ooscrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { ccommrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { sptrs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            try { statement.close(); }  catch (Exception e) {ESLog.debug("error in finally",e);}
            try { connection.commit(); }  catch (Exception e) {ESLog.debug("error in finally",e);}
            try { connection.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
           // allClose.actionDone();

        }

        // check for "NO DATA FOUND"
        if (errorCode==0 && context.getContracts().isEmpty()) {
            errorCode = ErrorFactory.id300_NO_DATA_FOUND;
        }

        return errorCode;
    }

    static final private String GET_ASSOCIATED_CONTRACTS =
        "{call es.get_associated_contracts(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    /*
       PROCEDURE get_associated_contracts (
         1   p_identifier              IN       VARCHAR2,
         2   p_identifier_type         IN       VARCHAR2,
         3   p_contact_list            IN       VARCHAR2,
         4   p_ship_to_country_code    IN       VARCHAR2,
         5   p_active_contracts_only   IN       CHAR DEFAULT 'Y',
         6   p_chunk_size              IN       INTEGER DEFAULT 0,
         7   p_chunk_position          IN       INTEGER DEFAULT 0,
         8   p_error_code              OUT      NUMBER,
         9   p_total_result_size       OUT      NUMBER,
        10   p_current_chunk_size      OUT      NUMBER,
        11   p_ohdr_cursor             OUT      es_output.es_cursor,
        12   p_svc_type_cursor         OUT      es_output.es_cursor,
        13   p_ohar_cursor             OUT      es_output.es_cursor,
        14   p_ohcr_cursor             OUT      es_output.es_cursor
       );
    */

    /**
     * Call the database procedure get_contract_entitlement() and read all
     * returned cursors. All results are stored in the EsReplyContext.
     * @param context used to store all found results
     * @param identifier contract identifier
     * @param identifierType the type of contract identifier
     * @param contactList List of SourcePersonIds to filter the result
     * @param shipToCountryCode
     * @param activeContractsOnly
     * @param chunkSize the maximum amount of obligation_headers
     *                  that should be returned
     * @param chunkPosition number of obligation_headers
     * @return error ID
     */
    public int getAssociatedContracts(
        EsReplyContext context,
        String identifier,
        AssociatedContractIdentifierTypeType identifierType,
        String contactList,
        String shipToCountryCode,
        boolean activeContractsOnly,
        int chunkSize,
        int chunkPosition,
        MetricsHandler mh)
        throws DatabaseDownException, DataAccessException,SifException{


        Connection connection = null;
        CallableStatement statement = null;
        int errorCode = 0;
        int currentChunkSize = 0;
        int totalResultSize = 0;

        ResultSet ohrs    = null;
        ResultSet clrs    = null;
        ResultSet ccrs    = null;
        ResultSet sptrs   = null;
        MetricsEntry stmtExec = null;
        MetricsEntry getRs = null;

        try {
            connection = DbConnectionManager.getInstance().getReadonlyConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareCall(GET_ASSOCIATED_CONTRACTS);

            statement.setString( 1, identifier);
            statement.setString( 2, (identifierType==null ? null : identifierType.toString()));
            statement.setString( 3, contactList);
            statement.setString( 4, shipToCountryCode);
            statement.setString( 5, activeContractsOnly ? "Y" : "N" );
            statement.setInt   ( 6, chunkSize);
            statement.setInt   ( 7, chunkPosition);
            statement.registerOutParameter( 8, OracleTypes.INTEGER);
            statement.registerOutParameter( 9, OracleTypes.INTEGER);
            statement.registerOutParameter(10, OracleTypes.INTEGER);
            for (int i=11; i<=14; i++) {
                statement.registerOutParameter(i, OracleTypes.CURSOR);
            }

            if(mh != null)
            	stmtExec =  mh.startEntry("getAssCon_SqlExec");
            statement.execute();
            if(stmtExec!=null) {
            	stmtExec.actionDone();
            	stmtExec = null;
            }

            // any error occured?
            errorCode = statement.getInt(8);

            totalResultSize = statement.getInt(9);
            context.setTotalResultSize(totalResultSize);

            currentChunkSize = statement.getInt(10);
            context.setCurrentChunkSize(currentChunkSize);

            // Now read all returned cursors and store the data in the context.
            if(mh != null)
            	getRs = mh.startEntry("getAssCon_GetRS: ohrs");
           
            
            ohrs    = (ResultSet)statement.getObject(11);
            
            
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getAssCon_GetRS: clrs");
                     
            clrs    = (ResultSet)statement.getObject(13);
             if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getAssCon_GetRS: ccrs");
            
            ccrs    = (ResultSet)statement.getObject(14);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
            
            if(mh != null)
            	getRs = mh.startEntry("getAssCon_GetRS: sptrs");
            
            sptrs   = (ResultSet)statement.getObject(12);
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }


            //================================================================
            ObligationHeaderResultSetReader ohrsr =
                        new ObligationHeaderResultSetReader(context,ohrs);
            ohrsr.run(mh);
            //================================================================
            // Note: ObligationHeaderResultSetReader has to be finished before
            // the ServiceProductTypeResultSetReader is called.
            ServiceProductTypeResultSetReader sptrsr =
                        new ServiceProductTypeResultSetReader(context,sptrs);
            sptrsr.run(mh);
            //================================================================
            // Note: ObligationHeaderResultSetReader has to be finished before
            // the ContractLocationResultSetReader is called.
            ContractLocationResultSetReader clrsr =
                        new ContractLocationResultSetReader(context,clrs);
            clrsr.run(mh);
            
            // For Customer Indicator we need the reference of ObligationHeader to Location
            setOHeadLocMap(clrsr.getOHeadLocMap());
            
            //================================================================
            ContractContactResultSetReader ccrsr =
                        new ContractContactResultSetReader(context,ccrs);
            ccrsr.run(mh);
        } catch (SQLException e) {
            String nl = System.getProperty("line.separator");
            StringBuffer buf = new StringBuffer();
            buf.append(nl);
            buf.append("identifier=");
            buf.append(identifier);
            buf.append(nl);
            buf.append("identifierType=");
            buf.append((identifierType==null ? null : identifierType.toString()));
            buf.append(nl);
            buf.append("contactList=");
            buf.append(contactList);
            buf.append(nl);
            buf.append("shipToCountryCode=");
            buf.append(shipToCountryCode);
            buf.append(nl);
            buf.append("activeContractsOnly=");
            buf.append((activeContractsOnly ? "Y" : "N"));
            buf.append(nl);
            buf.append("chunkSize=");
            buf.append(chunkSize);
            buf.append(nl);
            buf.append("chunkPosition=");
            buf.append(chunkPosition);


            throwException(e, "DbContractEntitlementManager.getAssociatedContracts",
                           buf.toString());
        } finally {
            try { ohrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { clrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { ccrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { sptrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { statement.close(); }  catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { connection.commit(); }  catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { connection.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }

            
            
            if(stmtExec!=null) {
            	stmtExec.actionDone();
            	stmtExec = null;
            }
            if(getRs!=null) {
            	getRs.actionDone();
            	getRs = null;
            }
        }

        // check for "NO DATA FOUND"
        if (errorCode==0 && context.getContracts().isEmpty()) {
            errorCode = ErrorFactory.id300_NO_DATA_FOUND;
        }
        return errorCode;
    }

    // Since ES 6.0 the get_pa_entitlement_6 is called.
    static final private String GET_PRINT_ADVANTAGE_ENTITLEMENT =
            "{call es.get_pa_entitlement_6(?,?,?,?,?,?,?,?,?)}";

    /**
     * Call the database procedure get_pa_entitlement() and read all
     * returned cursors. All results are stored in the EsReplyContext.
     * @param replyContext
     * @param identifier
     * @param identifierType
     * @param productShipToSourceCustomerid
     * @param outputDetails
     * @return error ID
     */
    public int getPrintAdvantageEntitlement(
        EsReplyContext context,
        String identifier,
        ContractIdentifierTypeType identifierType,
        String isoCountryCode,
        OutputDetails outputDetails,
        MetricsHandler mh)
    throws DatabaseDownException, DataAccessException, SifException {


        Connection connection = null;
        CallableStatement statement = null;
        int errorCode = 0;

        ResultSet ohrs = null;
        ResultSet srs = null;
        ResultSet atrs = null;
        ResultSet oosrs = null;
        ResultSet strs = null;

        try {
            connection = DbConnectionManager.getInstance().getReadonlyConnection();

            connection.setAutoCommit(false);

            statement = connection.prepareCall(GET_PRINT_ADVANTAGE_ENTITLEMENT);

            statement.setString( 1, identifier);
            statement.setString( 2, (identifierType==null ? null : identifierType.toString()));
            statement.setString( 3, isoCountryCode);

            statement.registerOutParameter(4, OracleTypes.INTEGER);
            for (int i=5; i<=9; i++) {
                 statement.registerOutParameter(i, OracleTypes.CURSOR);
            }
            MetricsEntry stmtExec = null;
            if(mh != null) 
            	stmtExec = mh.startEntry("getPAEnt_SqlExec");
            statement.execute();
            if(mh != null&& stmtExec!= null) 
            	stmtExec.actionDone();

            // any error occured?
            errorCode = statement.getInt(4);

            // Now read all returned cursors and store the data in the context.
            MetricsEntry getRs = null;
            if(mh != null) 
            	getRs = mh.startEntry("getPAEnt_GetRS: ohrs");
            ohrs =      (ResultSet)statement.getObject(5);
            if(mh != null&& getRs!= null) 
            	getRs.actionDone();
            if(mh != null)
            	getRs = mh.startEntry("getPAEnt_GetRS: srs");
            srs =       (ResultSet)statement.getObject(6);
            if(mh != null&& getRs!= null) 
            	getRs.actionDone();
            if(mh != null)
            	getRs = mh.startEntry("getPAEnt_GetRS: atrs");
            atrs =      (ResultSet)statement.getObject(7);
            if(mh != null&& getRs!= null) 
            	getRs.actionDone();
            if(mh != null)
            	getRs = mh.startEntry("getPAEnt_GetRS: oosrs");
            oosrs =     (ResultSet)statement.getObject(8);
            if(mh != null&& getRs!= null) 
            	getRs.actionDone();
            if(mh != null)
            	getRs = mh.startEntry("getPAEnt_GetRS: strs");
            strs =      (ResultSet)statement.getObject(9);
            
            if(mh != null&& getRs!= null) 
            	getRs.actionDone();


            //================================================================
            ObligationHeaderResultSetReader ohrsr =
                      new ObligationHeaderResultSetReader(context, ohrs);
            ohrsr.run(mh);
            //================================================================
            ServiceResultSetReader srsr =
                      new ServiceResultSetReader(context, srs);
            srsr.run(mh);
            //================================================================
            AppliesToResultSetReader atrsr =
                      new AppliesToResultSetReader(context, atrs);
            atrsr.run(mh);
            //================================================================
            OOSResultSetReader oosrsr =
                      new OOSResultSetReader(context, oosrs);
            oosrsr.run(mh);
            //================================================================
            ServiceProductTypeResultSetReader strsr=
                      new ServiceProductTypeResultSetReader(context, strs);
            strsr.run(mh);

        }
        catch (SQLException e) {
            String nl = System.getProperty("line.separator");
            StringBuffer buf = new StringBuffer();
            buf.append(nl);
            buf.append("identifier=");
            buf.append(identifier);
            buf.append(nl);
            buf.append("identifierType=");
            buf.append((identifierType==null ? null : identifierType.toString()));
            buf.append(nl);
            buf.append("isoCountryCode=");
            buf.append(isoCountryCode);


            throwException(e, "DbContractEntitlementManager.getPrintAdvantageEntitlement",
                           buf.toString());
        }
        finally {
           // MetricsEntry allClose = mh.startEntry("getPAEnt_CloseAll");
            try { ohrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { srs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { atrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { oosrs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { strs.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { statement.close(); }  catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { connection.commit(); }  catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            try { connection.close(); } catch (Exception e) {
            	ESLog.debug("error in finalize",e);
            }
            //allClose.actionDone();

        }

        // check for "NO DATA FOUND"
        if (errorCode==0 && context.getContracts().isEmpty()) {
            errorCode = ErrorFactory.id300_NO_DATA_FOUND;
        }
        return errorCode;
    }

    /**
     * private constructor
     */
    private DbContractEntitlementManager() {
    	
    }

    /**
     * @return the DbSystemHandleManager object (singleton).
     */
    public  static DbContractEntitlementManager getNewInstance() {
        return  new DbContractEntitlementManager();
    }

    /**
     * Map the SQLException to a DatabaseDownException or DataAccessException
     * and throw the new exception.
     * @param e
     * @param methodName
     * @param paramList
     * @throws DatabaseDownException
     * @throws DataAccessException
     * @throws SifException
     */
    private void throwException(SQLException e, String methodName, String paramList)
        throws DatabaseDownException, DataAccessException, SifException {

        if (OracleHelper.isDatabaseDown(e.getErrorCode())) {
            throw new DatabaseDownException(e);
        }
        String message = e.getMessage();
        
        if (message != null && (message.indexOf("ORA-06512") != -1 || message.indexOf("ORA-06502") != -1 || message.indexOf("ORA-04063") != -1 || message.indexOf("ORA-01013") != -1) ) {
            ESLog.info("DB exception (" + methodName + "): One of the parameter is too long: " + paramList, e);
            throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "One of the parameters are too long.");
        }

        ESLog.error("Unknown DB exception (" + methodName
                + "): The procedure was called with following parameter:"
                + paramList, e);
        DataAccessException exception = new DataAccessException(e);
        exception.setErrorCode(e.getErrorCode());
        throw exception;
    }




	public HashMap getOHeadLocMap() {
		return oHeadLocMap;
	}

	private void setOHeadLocMap(HashMap headLocMap) {
		oHeadLocMap = headLocMap;
	}


	public void destroy() {
		
		if(oHeadLocMap != null) {
			oHeadLocMap.clear();
		}
	}
}
