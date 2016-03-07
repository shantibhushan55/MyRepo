package com.hp.es.tm.dao;

/*
 *  @author Wade He <wei.he6@hp.com>
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.tm.TmTransaction;

public final class TmDao {

	private final static String SQL_INSERT = "insert into tm_transaction (TRANSACTION_ID,START_DATE_TIME,RESPONSE_TIME,"
			+ "ES_VERSION,ES_OPERATION,CLIENT_APP_ID,REQ_PRODUCTID,REQ_ISO_COUNTRY_CODE,REQ_SERIALNUMBER,"
			+ "REQ_ENTITLEMENT_CHECKDATE,REQ_INC_SERVICENOTES,REQ_INC_WORKINGS,REQ_SOURCE_SYSTEM,"
			+ "REQ_CAREPACK_SERIALNUMBER,REQ_CAREPACK_PN,REQ_PROOF_PURCHASE_DATE,REQ_SPAREPART_NUMBER,"
			+ "REQ_DATE_CODE,REQ_SERVICEID,REQ_CONSUMER_BUSI_LOGIC_NEEDED,REQ_MARKET_SEGMENT,REQ_GEO_CODE,REQ_INC_CATS,"
			+ "REQ_CONTRACT_ID_TYPE,REQ_DATA_ENTRY_SITE,REQ_SOURCE_CUSTOMERID,REQ_RED_ACCESSID,REQ_ACTIVE_CONTRACTS_ONLY,"
			+ "REQ_ACTIVE_SERVICES_ONLY,REQ_INC_WARRANTY,REQ_INC_ADDRESSES,REQ_INC_CONTACTS,REQ_INC_OFFERS,REQ_INC_DELIVERABLES,"
			+ "REQ_INC_MODIFIERS,REQ_MNCONTRACT_SOURCE_DOC,REQ_RED_GROUP_SERIALNO,REQ_CONTRACT_IDENTIFIER,REQ_INC_UNIQUE_OFFERS,"
			+ "REQ_INC_UNIQUE_DELIVER,REQ_INC_OOSES,REQ_STANDALONE_OFFERS_ONLY,REQ_CUSTOMER_DEFINEDID,REQ_INC_SW_SVCLVCATEGORY,"
			+ "REQ_INC_SPECIAL_INSTRUCTIONS,REQ_INC_CUSTOMER_INDICATOR,REQ_INC_FUNCTIONAL_LOCATION,REQ_SVC_AGREEMENTID,REQ_PRODUCT_TYPE,"
			+ "REQ_SERVICE_ABLE_PRODUCTS_ONLY,REQ_OFFER_CODE,REQ_ACTIVE_WARRANTY_ONLY,REQ_ASSOCIATED_CID_TYPE,REQ_ASSOCIATED_CID,"
			+ "REQ_PERSONID,REQ_CHUNK_SIZE,REQ_CHUNK_POSITION,REQ_SALESORDER_NUMBER,REQ_TOTAL_RESULT_SIZE,RESPONSE_CODE,REPLY_SERIAL_NUMBER,"
			+ "REPLY_PRODUCT_NUMBER,REPLY_PRODUCT_LINE,REPLY_ISO_COUNTRY_CODE,NUMBER_PMCPQ_CONTRACT,NUMBER_PMHP_CONTRACT,"
			+ "NUMBER_PMHP_CAREPAQS,NUMBER_PMCPQ_CAREPAQS,NUMBER_GIS_CONTRACT,NUMBER_GIS_CAREPAQS,WARNING_CODE1,WARNING_CODE2,WARNING_CODE3)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
			+ "?,?,?,?,?,?,?,?,?,?,?,?,?)";

	
	private final static String DEFAULTVERSION =EsConstants.ES_VERSION;
	private final static String DEFAULTOPERATION = "NO_OPERATION";
	private final static String DEFAULTAPPID = "DUMMY_APPID";

	private static TmDao instance = new TmDao();

	private TmDao() {

	}

	public static TmDao getInstance() {
		return instance;
	}

	public void saveTmTransaction(final TmTransaction tmTrans, final Connection conn)
			throws SQLException {
		
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(SQL_INSERT);
			
			int pos = 1;
			pst.setBigDecimal(pos++, tmTrans.getTransactionId());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|TRANSACTION_ID="
						+ tmTrans.getTransactionId());

			long startDateTime = tmTrans.getStartDate();
			pst.setTimestamp(pos++, startDateTime == 0 ? null : new Timestamp(
					startDateTime));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|StartDate="
						+ tmTrans.getStartDate());

			pst.setLong(pos++, tmTrans.getResponseTime());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ResponseTime="
						+ tmTrans.getResponseTime());

			String esVersion = trim(tmTrans.getEsVersion());
			if (esVersion != null && esVersion.length() > 0) {
				pst.setString(pos++,
						(esVersion.length() > 5 ? esVersion.substring(0, 5)
								: esVersion));
			} else {
				pst.setString(pos++, DEFAULTVERSION);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|EsVersion=" + esVersion);

			String esOperation = trim(tmTrans.getEsOperation());
			if (esOperation != null && esOperation.length() > 0) {
				pst.setString(pos++,
						(esOperation.length() > 30 ? esOperation.substring(0, 30)
								: esOperation));
			} else {
				pst.setString(pos++, DEFAULTOPERATION);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|EsOperation=" + esOperation);

			String appClientId = trim(tmTrans.getAppClientId());
			if (appClientId != null && appClientId.length() > 0) {
				pst.setString(pos++,
						(appClientId.length() > 20 ? appClientId.substring(0, 20)
								: appClientId));
			} else {
				pst.setString(pos++, DEFAULTAPPID);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|AppClientId=" + appClientId);

			String reqProductId = trim(tmTrans.getReqProductId());
			if (reqProductId != null && reqProductId.length() > 0) {
				pst.setString(pos++,
						(reqProductId.length() > 20 ? reqProductId.substring(0, 20)
								: reqProductId));
			} else {
				pst.setString(pos++, reqProductId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqProductId=" + reqProductId);

			String reqCountryCode = trim(tmTrans.getReqCountryCode());
			if (reqCountryCode != null && reqCountryCode.length() > 0) {
				pst.setString(
						pos++,
						(reqCountryCode.length() > 20 ? reqCountryCode.substring(0,
								20) : reqCountryCode));
			} else {
				pst.setString(pos++, reqCountryCode);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqCountryCode=" + reqCountryCode);

			String reqSn = trim(tmTrans.getReqSn());
			if (reqSn != null && reqSn.length() > 0) {
				pst.setString(pos++, (reqSn.length() > 20 ? reqSn.substring(0, 20)
						: reqSn));
			} else {
				pst.setString(pos++, reqSn);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqSn=" + reqSn);

			long checkDate = tmTrans.getReqEntitleCheckDate();
			pst.setDate(pos++, checkDate == 0 ? null : new Date(checkDate));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqEntitleCheckDate="
						+ tmTrans.getReqEntitleCheckDate());

			pst.setInt(pos++, toInt(tmTrans.isReqIncludeServiceNote()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeServiceNote="
						+ tmTrans.isReqIncludeServiceNote());

			pst.setInt(pos++, toInt(tmTrans.isReqIncludeWorkings()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeWorkings="
						+ tmTrans.isReqIncludeWorkings());

			String reqSourceSystem = trim(tmTrans.getReqSourceSystem());
			if (reqSourceSystem != null && reqSourceSystem.length() > 0) {
				pst.setString(
						pos++,
						(reqSourceSystem.length() > 20 ? reqSourceSystem.substring(
								0, 20) : reqSourceSystem));
			} else {
				pst.setString(pos++, reqSourceSystem);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqSourceSystem="
						+ reqSourceSystem);

			String reqCarePackSn = trim(tmTrans.getReqCarePackSn());
			if (reqCarePackSn != null && reqCarePackSn.length() > 0) {
				pst.setString(
						pos++,
						(reqCarePackSn.length() > 15 ? reqCarePackSn.substring(0,
								15) : reqCarePackSn));
			} else {
				pst.setString(pos++, reqCarePackSn);
			}

			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqCarePackSn=" + reqCarePackSn);
			String reqCarePackPn = trim(tmTrans.getReqCarePackPn());
			if (reqCarePackPn != null && reqCarePackPn.length() > 0) {
				pst.setString(
						pos++,
						(reqCarePackPn.length() > 20 ? reqCarePackPn.substring(0,
								20) : reqCarePackPn));
			} else {
				pst.setString(pos++, reqCarePackPn);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqCarePackPn=" + reqCarePackPn);

			long proofPurchaseDate = tmTrans.getReqProofPurchaseDate();
			pst.setDate(pos++, proofPurchaseDate == 0 ? null : new Date(
					proofPurchaseDate));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqProofPurchaseDate="
						+ tmTrans.getReqProofPurchaseDate());

			String reqSparepartNumber = trim(tmTrans.getReqSparepartNumber());
			if (reqSparepartNumber != null && reqSparepartNumber.length() > 0) {
				pst.setString(
						pos++,
						(reqSparepartNumber.length() > 20 ? reqSparepartNumber
								.substring(0, 20) : reqSparepartNumber));
			} else {
				pst.setString(pos++, reqSparepartNumber);
			}

			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqSparepartNumber="
						+ reqSparepartNumber);

			String reqDateCode = trim(tmTrans.getReqDateCode());
			if (reqDateCode != null && reqDateCode.length() > 0) {
				pst.setString(pos++,
						(reqDateCode.length() > 20 ? reqDateCode.substring(0, 20)
								: reqDateCode));
			} else {
				pst.setString(pos++, reqDateCode);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqDateCode=" + reqDateCode);

			String reqServiceId = trim(tmTrans.getReqServiceId());
			if (reqServiceId != null && reqServiceId.length() > 0) {
				pst.setString(pos++,
						(reqServiceId.length() > 20 ? reqServiceId.substring(0, 20)
								: reqServiceId));
			} else {
				pst.setString(pos++, reqServiceId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqServiceId=" + reqServiceId);
			pst.setInt(pos++, toInt(tmTrans.isReqConsumerBusinessLogicNeeded()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqConsumerBusinessLogicNeeded="
						+ tmTrans.isReqConsumerBusinessLogicNeeded());

			String reqMarketSegment = trim(tmTrans.getReqMarketSegment());
			if (reqMarketSegment != null && reqMarketSegment.length() > 0) {
				pst.setString(
						pos++,
						(reqMarketSegment.length() > 20 ? reqMarketSegment
								.substring(0, 20) : reqMarketSegment));
			} else {
				pst.setString(pos++, reqMarketSegment);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqMarketSegment="
						+ reqMarketSegment);
			String reqGeoCode = trim(tmTrans.getReqGeoCode());
			if (reqGeoCode != null && reqGeoCode.length() > 0) {
				pst.setString(pos++,
						(reqGeoCode.length() > 20 ? reqGeoCode.substring(0, 20)
								: reqGeoCode));
			} else {
				pst.setString(pos++, reqGeoCode);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqGeoCode=" + reqGeoCode);
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeCats()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeCats="
						+ tmTrans.isReqIncludeCats());
			String reqContractIdType = trim(tmTrans.getReqContractIdType());
			if (reqContractIdType != null && reqContractIdType.length() > 0) {
				pst.setString(
						pos++,
						(reqContractIdType.length() > 20 ? reqContractIdType
								.substring(0, 20) : reqContractIdType));
			} else {
				pst.setString(pos++, reqContractIdType);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqContractIdType="
						+ reqContractIdType);
			String reqDataEntrySite = trim(tmTrans.getReqDataEntrySite());
			if (reqDataEntrySite != null && reqDataEntrySite.length() > 0) {
				pst.setString(
						pos++,
						(reqDataEntrySite.length() > 20 ? reqDataEntrySite
								.substring(0, 20) : reqDataEntrySite));
			} else {
				pst.setString(pos++, reqDataEntrySite);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqDataEntrySite="
						+ reqDataEntrySite);
			String reqSourceCustomerId = trim(tmTrans.getReqSourceCustomerId());
			if (reqSourceCustomerId != null && reqSourceCustomerId.length() > 0) {
				pst.setString(
						pos++,
						(reqSourceCustomerId.length() > 20 ? reqSourceCustomerId
								.substring(0, 20) : reqSourceCustomerId));
			} else {
				pst.setString(pos++, reqSourceCustomerId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqSourceCustomerId="
						+ reqSourceCustomerId);
			String reqRedAccessId = trim(tmTrans.getReqRedAccessId());
			if (reqRedAccessId != null && reqRedAccessId.length() > 0) {
				pst.setString(
						pos++,
						(reqRedAccessId.length() > 20 ? reqRedAccessId.substring(0,
								20) : reqRedAccessId));
			} else {
				pst.setString(pos++, reqRedAccessId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqRedAccessId=" + reqRedAccessId);
			pst.setInt(pos++, toInt(tmTrans.isReqActiveContractsOnly()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqActiveContractsOnly="
						+ tmTrans.isReqActiveContractsOnly());

			pst.setInt(pos++, toInt(tmTrans.isReqActiveServicesOnly()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqActiveServicesOnly="
						+ tmTrans.isReqActiveServicesOnly());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeWarranty()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeWarranty="
						+ tmTrans.isReqIncludeWarranty());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeAddress()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeAddress="
						+ tmTrans.isReqIncludeAddress());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeContacts()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeContracts="
						+ tmTrans.isReqIncludeContacts());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeOffers()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeOffers="
						+ tmTrans.isReqIncludeOffers());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeDeliverables()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeDeliverables="
						+ tmTrans.isReqIncludeDeliverables());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeModifiers()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeModifiers="
						+ tmTrans.isReqIncludeModifiers());

			String reqMnContractSourceDoc = trim(tmTrans
					.getReqMnContractSourceDoc());
			if (reqMnContractSourceDoc != null
					&& reqMnContractSourceDoc.length() > 0) {
				pst.setString(
						pos++,
						(reqMnContractSourceDoc.length() > 20 ? reqMnContractSourceDoc
								.substring(0, 20) : reqMnContractSourceDoc));
			} else {
				pst.setString(pos++, reqMnContractSourceDoc);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqMnContractSourceDoc="
						+ reqMnContractSourceDoc);
			String reqRedGroupSn = trim(tmTrans.getReqRedGroupSn());
			if (reqRedGroupSn != null && reqRedGroupSn.length() > 0) {
				pst.setString(
						pos++,
						(reqRedGroupSn.length() > 20 ? reqRedGroupSn.substring(0,
								20) : reqRedGroupSn));
			} else {
				pst.setString(pos++, reqRedGroupSn);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqRedGroupSn=" + reqRedGroupSn);
			String reqContractId = trim(tmTrans.getReqContractId());
			if (reqContractId != null && reqContractId.length() > 0) {
				pst.setString(
						pos++,
						(reqContractId.length() > 30 ? reqContractId.substring(0,
								30) : reqContractId));
			} else {
				pst.setString(pos++, reqContractId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqContractId=" + reqContractId);

			pst.setInt(pos++, toInt(tmTrans.isReqIncludeUniqueOffers()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeUniqueOffers="
						+ tmTrans.isReqIncludeUniqueOffers());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeUniqueDeliver()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeUniqueDeliver="
						+ tmTrans.isReqIncludeUniqueDeliver());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeOoses()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeOoses="
						+ tmTrans.isReqIncludeOoses());
			pst.setInt(pos++, toInt(tmTrans.isReqStandaloneOffersOnly()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqStandaloneOffersOnly="
						+ tmTrans.isReqStandaloneOffersOnly());
			String reqCustomerDefinedId = trim(tmTrans.getReqCustomerDefinedId());
			if (reqCustomerDefinedId != null && reqCustomerDefinedId.length() > 0) {
				pst.setString(
						pos++,
						(reqCustomerDefinedId.length() > 20 ? reqCustomerDefinedId
								.substring(0, 20) : reqCustomerDefinedId));
			} else {
				pst.setString(pos++, reqCustomerDefinedId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqCustomerDefinedId="
						+ reqCustomerDefinedId);
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeSoftwareLevelCatrgory()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeSoftwareLevelCatrgory="
						+ tmTrans.isReqIncludeSoftwareLevelCatrgory());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeSpecialInstructions()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeSpecialInstructions="
						+ tmTrans.isReqIncludeSpecialInstructions());

			pst.setInt(pos++, toInt(tmTrans.isReqIncludeCustomerIndicator()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeCustomerIndicator="
						+ tmTrans.isReqIncludeCustomerIndicator());
			pst.setInt(pos++, toInt(tmTrans.isReqIncludeFounctionalLocation()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqIncludeFounctionalLocation="
						+ tmTrans.isReqIncludeFounctionalLocation());
			String reqSvcAgreementId = trim(tmTrans.getReqSvcAgreementId());
			if (reqSvcAgreementId != null && reqSvcAgreementId.length() > 0) {
				pst.setString(
						pos++,
						(reqSvcAgreementId.length() > 20 ? reqSvcAgreementId
								.substring(0, 20) : reqSvcAgreementId));
			} else {
				pst.setString(pos++, reqSvcAgreementId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqSvcAgreementId="
						+ reqSvcAgreementId);
			String reqProductType = trim(tmTrans.getReqProductType());
			if (reqProductType != null && reqProductType.length() > 0) {
				pst.setString(
						pos++,
						(reqProductType.length() > 10 ? reqProductType.substring(0,
								10) : reqProductType));
			} else {
				pst.setString(pos++, reqProductType);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqProductType=" + reqProductType);
			pst.setInt(pos++, toInt(tmTrans.isReqServiceAbleProductsOnly()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqServiceAbleProductsOnly="
						+ tmTrans.isReqServiceAbleProductsOnly());
			String reqOfferCode = trim(tmTrans.getReqOfferCode());
			if (reqOfferCode != null && reqOfferCode.length() > 0) {
				pst.setString(pos++,
						(reqOfferCode.length() > 20 ? reqOfferCode.substring(0, 20)
								: reqOfferCode));
			} else {
				pst.setString(pos++, reqOfferCode);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqOfferCode=" + reqOfferCode);
			pst.setInt(pos++, toInt(tmTrans.isReqActiveWarrantyOnly()));
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqActiveWarrantyOnly="
						+ tmTrans.isReqActiveWarrantyOnly());
			String reqAssociateCidType = trim(tmTrans.getReqAssociateCidType());
			if (reqAssociateCidType != null && reqAssociateCidType.length() > 0) {
				pst.setString(
						pos++,
						(reqAssociateCidType.length() > 20 ? reqAssociateCidType
								.substring(0, 20) : reqAssociateCidType));
			} else {
				pst.setString(pos++, reqAssociateCidType);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqAssociateCidType="
						+ reqAssociateCidType);
			String reqAssociateCid = trim(tmTrans.getReqAssociateCid());
			if (reqAssociateCid != null && reqAssociateCid.length() > 0) {
				pst.setString(
						pos++,
						(reqAssociateCid.length() > 20 ? reqAssociateCid.substring(
								0, 20) : reqAssociateCid));
			} else {
				pst.setString(pos++, reqAssociateCid);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqAssociateCid="
						+ reqAssociateCid);
			String reqPersonId = trim(tmTrans.getReqPersonId());
			if (reqPersonId != null && reqPersonId.length() > 0) {
				pst.setString(pos++,
						(reqPersonId.length() > 10 ? reqPersonId.substring(0, 10)
								: reqPersonId));
			} else {
				pst.setString(pos++, reqPersonId);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqPersonId=" + reqPersonId);
			pst.setLong(pos++, tmTrans.getReqChunkSize());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqChunkSize="
						+ tmTrans.getReqChunkSize());
			pst.setLong(pos++, tmTrans.getReqChunkPosition());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReqChunkPosition="
						+ tmTrans.getReqChunkPosition());
			String reqSaleSorderNumber = trim(tmTrans.getReqSaleSorderNumber());
			if (reqSaleSorderNumber != null && reqSaleSorderNumber.length() > 0) {
				pst.setString(
						pos++,
						(reqSaleSorderNumber.length() > 20 ? reqSaleSorderNumber
								.substring(0, 20) : reqSaleSorderNumber));
			} else {
				pst.setString(pos++, reqSaleSorderNumber);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|Request Sale Sorder Number="
						+ reqSaleSorderNumber);
			pst.setLong(pos++, tmTrans.getReqTotalResultSize());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ResultSize="
						+ tmTrans.getReqTotalResultSize());
			String responseCode = trim(tmTrans.getResponseCode());
			if (responseCode != null && responseCode.length() > 0) {
				pst.setString(pos++,
						(responseCode.length() > 10 ? responseCode.substring(0, 10)
								: responseCode));
			} else {
				pst.setString(pos++, "1");
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ResponseCode=" + responseCode);
			String replySn = trim(tmTrans.getReplySn());
			if (replySn != null && replySn.length() > 0) {
				pst.setString(
						pos++,
						(replySn.length() > 20 ? replySn.substring(0, 20) : replySn));
			} else {
				pst.setString(pos++, replySn);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReplySn=" + replySn);
			String replyPn = trim(tmTrans.getReplyPn());
			if (replyPn != null && replyPn.length() > 0) {
				pst.setString(
						pos++,
						(replyPn.length() > 20 ? replyPn.substring(0, 20) : replyPn));
			} else {
				pst.setString(pos++, replyPn);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReplyPn=" + replyPn);
			String replyProductLine = trim(tmTrans.getReplyProductLine());
			if (replyProductLine != null && replyProductLine.length() > 0) {
				pst.setString(
						pos++,
						(replyProductLine.length() > 20 ? replyProductLine
								.substring(0, 20) : replyProductLine));
			} else {
				pst.setString(pos++, replyProductLine);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReplyProductLine="
						+ replyProductLine);
			String replyCountryCode = trim(tmTrans.getReplyCountryCode());
			if (replyCountryCode != null && replyCountryCode.length() > 0) {
				pst.setString(
						pos++,
						(replyCountryCode.length() > 20 ? replyCountryCode
								.substring(0, 20) : replyCountryCode));

			} else {
				pst.setString(pos++, replyCountryCode);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|ReplyCountryCode="
						+ replyCountryCode);
			pst.setInt(pos++, tmTrans.getNumberPmcpqContract());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|NumberPmcpqContract="
						+ tmTrans.getNumberPmcpqContract());
			pst.setInt(pos++, tmTrans.getNumberPmhpContract());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|NumberPmhpContract="
						+ tmTrans.getNumberPmhpContract());
			pst.setInt(pos++, tmTrans.getNumberPmhpCarepaqs());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|NumberPmhpCarepaqs="
						+ tmTrans.getNumberPmhpCarepaqs());
			pst.setInt(pos++, tmTrans.getNumberPmcpqCarepaqs());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|NumberPmcpqCarepaqs="
						+ tmTrans.getNumberPmcpqCarepaqs());
			pst.setInt(pos++, tmTrans.getNumberGisContract());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|NumberGisContract="
						+ tmTrans.getNumberGisContract());
			pst.setInt(pos++, tmTrans.getNumberGisCarepaqs());
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|NumberGisCarepaqs="
						+ tmTrans.getNumberGisCarepaqs());
			String warningCode1 = trim(tmTrans.getWarningCode1());
			if (warningCode1 != null && warningCode1.length() > 0) {
				pst.setString(pos++,
						(warningCode1.length() > 5 ? warningCode1.substring(0, 5)
								: warningCode1));
			} else {
				pst.setString(pos++, warningCode1);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|WarningCode1=" + warningCode1);
			String warningCode2 = trim(tmTrans.getWarningCode2());
			if (warningCode2 != null && warningCode2.length() > 0) {
				pst.setString(pos++,
						(warningCode2.length() > 5 ? warningCode2.substring(0, 5)
								: warningCode2));
			} else {
				pst.setString(pos++, warningCode2);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|WarningCode2=" + warningCode2);
			String warningCode3 = trim(tmTrans.getWarningCode3());
			if (warningCode3 != null && warningCode3.length() > 0) {
				pst.setString(pos++,
						(warningCode3.length() > 5 ? warningCode3.substring(0, 5)
								: warningCode3));
			} else {
				pst.setString(pos++, warningCode3);
			}
			if (ESLog.isDebugLogEnabled())
				ESLog.debug("TmDao||TmTransaction|WarningCode3=" + warningCode3);
			pst.executeUpdate();
		} finally {
			if(pst != null) {
				pst.close();
			}
		}
	}

	private static int toInt(boolean arg) {
		int intArg = 0;
		if (arg) {
			intArg = 1;
		} else {
			intArg = 0;
		}
		return intArg;
	}

	private static String trim(String str) {
		String strRet = str;
		if (strRet != null) {
			strRet = strRet.trim();
		}
		return strRet;
	}
}
