package com.hp.es.tm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.FraudTransaction;

/**
 * @author youlin.zhang<you-lin.zhang@hp.com>
 * 
 */

public final class FraudTransactionDao {
	/**
	 * insert the FraudTransaction object
	 * @param fraudTransaction
	 * @return FRAUD_TXN_SEQUENCE value
	 * @throws Exception
	 */
	
	private static final String SQL_INSERT = "insert into FRAUD_RSP(FRAUD_RSP_ID, FRD_CHCK_TXN_ID, ORIG_ENTLMT_RSP_CD, ORIG_WARR_STRT_DT, ORIG_WARR_END_DT, " 
		+"ORIG_CNTRCT_STRT_DT, ORIG_CNTRCT_END_DT, ORIG_WARR_ID, ORIG_WARR_DTRMN_CD, FG_TYPE_CD, " +
		"TM_TRANSACTION_ID, ES_TXN_ID) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	private static final String SQL_SEQ = "select FRAUD_TXN_SEQUENCE.nextval from dual";
	
	private static FraudTransactionDao instance = new FraudTransactionDao();
	
	private FraudTransactionDao() {
		
	}
	
	public static FraudTransactionDao getInstance() {
		return instance;
	}
	
	public void saveFraudTransaction(
			final FraudTransaction fraudTransaction,final Connection conn) throws SQLException {
		PreparedStatement pst = null;
		try {
			long seqVal = getSequenceValue(conn);
			if (ESLog.isDebugLogEnabled()){
				ESLog.debug("insertFraudTransaction|seqVal:" + seqVal);
				ESLog.debug(fraudTransaction.toString());
			}
			int pos = 1;
			pst = conn.prepareStatement(SQL_INSERT);
			pst.setLong(pos++, seqVal);
			pst.setBigDecimal(pos++, fraudTransaction.getFraudCheckTransactionId());
			pst.setString(pos++, fraudTransaction.getOriginalEntitlementResponseCode());
			pst.setTimestamp(pos++, fraudTransaction.getOriginalWarrantyStartDate());
			pst.setTimestamp(pos++, fraudTransaction.getOriginalWarrantyEndDate());
			pst.setTimestamp(pos++, fraudTransaction.getOriginalContractStartDate());
			pst.setTimestamp(pos++, fraudTransaction.getOriginalContractEndDate());
			pst.setString(pos++, fraudTransaction.getOriginalWarrantyId());
			pst.setString(pos++, fraudTransaction.getOriginalWarrantyDeterminationCode());
			pst.setString(pos++, fraudTransaction.getFlagTypeCode());
			pst.setBigDecimal(pos++, fraudTransaction.getTmTransactionId());
			pst.setBigDecimal(pos++, fraudTransaction.getEsTransactionId());
			
			pst.executeUpdate();
			ESLog.debug("FraudTransactionDao|after insertFraudTransaction");
		} finally {
			if(pst != null) {
				pst.close();
			}
		}
	}
	
	private long getSequenceValue(Connection conn) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		long seqVal = 0;
		try {
			pst = conn.prepareStatement(SQL_SEQ);
			rs = pst.executeQuery();
			while (rs.next()) {
				seqVal = rs.getLong(1);
			}
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pst != null) {
				pst.close();
			}
		}
		
		return seqVal;
	}
	
}
