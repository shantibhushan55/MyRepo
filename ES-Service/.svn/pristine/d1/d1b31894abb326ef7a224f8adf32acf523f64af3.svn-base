package com.hp.es.tm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.FraudTransactionMessage;

/**
 * @author zhanyoul<you-lin.zhang@hp.com>
 *
 */
public class FraudTransactionMessageDao {
	/**
	 * insert the FraudTransactionMessage object
	 * 
	 * @param fraudTransaction
	 * @return
	 * @throws Exception
	 */
	public boolean insertFraudTransactionMessage(FraudTransactionMessage fraudTransactionMessage, Connection con)
			throws Exception {
		if (ESLog.isDebugLogEnabled()) {
			ESLog.debug("before insertFraudTransactionMessage");
			ESLog.debug("insertFraudTransactionMessage:"+ fraudTransactionMessage.toString());
		}
		PreparedStatement pst = null;
		String sqlStr = "insert into Fraud_TXN_MSG(FRAUD_WARN_MSG_ID,FRAUD_TXN_ID,TM_TRANSACTION_ID)values(?,?,?)";
		try {
			int pos = 1;
			pst = con.prepareStatement(sqlStr);
			pst.setLong(pos++, fraudTransactionMessage.getFraudWarningMessageIdentifier());
			pst.setLong(pos++, fraudTransactionMessage.getFraudTransactionIdentifier());
			pst.setBigDecimal(pos++, fraudTransactionMessage.getTmTransactionId());
			pst.executeUpdate();
			ESLog.debug("FraudTransactionMessageDao|after insertFraudTransactionMessage");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ESLog.error("Exception when create PreparedStatement!", e);
			if (con != null) {
				try {
					con.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
					ESLog.error("SQLException: Can't rollback!", e1);
				}
			}
			return false;
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (Exception se) {
				se.printStackTrace();
				ESLog.error("SQLException: Can't close PreparedStatement!", se);
			}
		}
	}

}
