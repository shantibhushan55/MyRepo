package com.hp.es.tm.service;

/*
 *  @author Wade He <wei.he6@hp.com>
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import com.hp.es.service.db.DbConnectionManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.tm.ComplexTransaction;
import com.hp.es.tm.FraudTransaction;
import com.hp.es.tm.TmTransaction;
import com.hp.es.tm.Transaction;
import com.hp.es.tm.dao.FraudTransactionDao;
import com.hp.es.tm.dao.TmDao;
import com.hp.es.tm.util.exception.TmException;
import com.hp.es.xml.service.EIAMessage;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;

public final class TmService {
	private static HashSet <String> operationTable= new HashSet <String> ();
	static {
		operationTable.add( "getwarrantyentitlement");
		operationTable.add( "getcontractentitlement");
		operationTable.add( "getcontractsummary");
		operationTable.add( "getentitlementbypn");
		operationTable.add( "getentitlementbysn");
		operationTable.add( "getassociatedcontracts");
		operationTable.add( "getprintadvantageentitlement");
		operationTable.add( "getroutingdetails");
		operationTable.add( "getuniteventhistory");
		operationTable.add( "getinstalledbaseunits");
	}

	private static TmService _instance = new TmService();

	/*
	 * Disable constructor
	 */
	private TmService() {

	}

	/*
	 * Return singleton
	 */
	public static TmService getInstance() {
		return _instance;
	}






	/*
	 * Build a complex transaction, this is the exact mapping to what will be logged to database
	 * @param transaction
	 * @return ComplexTransaction
	 */
	public ComplexTransaction processTransaction(Transaction trans)
			throws TmException {
		ESLog.debug("************ processTransaction");
		if(trans==null) {
			return null;
		}
		
		ComplexTransaction complexTransaction = new ComplexTransaction();
		TmTransaction tmTrans = new TmTransaction();
		FraudTransaction fraudTransaction = null;

		EIAMessage replyBeforeFraud = trans.getReply();
		EIAMessage reply			= trans.getReplyAfterFraud();
		ComplianceValidationReply cvsReply = trans.getComplianceServiceReply();

		EIAMessage request = trans.getRequest();


		/*
		 * Now we check if this transaction needs to be logged
		 * Some transaction does not need
		 */
		if(!isTransactionTobeLogged(request)) {
			return null;
		}
		
		
		long startDate = TransactionHelper.getStartDate(trans);
		long responseTime = TransactionHelper.calculateResponseTime(trans);

		TransactionCommonFieldHelper.processCommonFields(request, reply, tmTrans, startDate, responseTime);


		TransactionRequestHelper.processRequest(request, tmTrans);
		TransactionReplyHelper.calculateNumberOfContracts(reply, tmTrans);
		TransactionReplyHelper.calculateNumberOfWarranties(reply, tmTrans);

		TransactionReplyHelper.processWarningCode(reply, tmTrans);


		TransactionReplyHelper.processReplyResponseCode( reply, tmTrans);
		
		
		if(cvsReply !=null && cvsReply.getMessageList() != null && cvsReply.getMessageList().size()>0) {
		//if (cvsReply != null && cvsReply.getCheckTransactionId() != null ) {
			fraudTransaction = new FraudTransaction();
			fraudTransaction.setTmTransactionId(tmTrans.getTransactionId());
			fraudTransaction.setEsTransactionId(tmTrans.getTransactionId());
			TransactionCVSHelper.processTransaction(replyBeforeFraud,fraudTransaction, cvsReply);
		}
		
		complexTransaction.setTmTransaction(tmTrans);
		complexTransaction.setFraudTransaction(fraudTransaction);

		return complexTransaction;
	}

	

	private boolean isTransactionTobeLogged(EIAMessage request) {
		if(request != null && request.getMessageBody()!= null 
				&& request.getMessageBody().getEsRequest() != null
				&& request.getMessageBody().getEsRequest().getOperation() !=null
				&& request.getMessageBody().getEsRequest().getOperation().trim().length()> 0) {
			if(operationTable.contains(request.getMessageBody().getEsRequest().getOperation().toLowerCase()))
				return true;
			
		}
		
		return false;
	}

	public void saveComplexTransaction(ComplexTransaction complexTransaction) {
		Connection conn = null;
		
		try {
			// begin transaction
			conn = DbConnectionManager.getInstance().getWritableConnection();
			conn.setAutoCommit(false);
			TmDao.getInstance().saveTmTransaction(complexTransaction.getTmTransaction(), conn);
			if(complexTransaction.getFraudTransaction() != null) {
				FraudTransactionDao.getInstance().saveFraudTransaction(complexTransaction.getFraudTransaction(), conn);
			}
			conn.commit();
		} catch (Exception e) {
			if(e instanceof SQLException)
				ESLog.error("error occured when insert complex transaction, the transaction is "+complexTransaction.toString()+ "SQL Message"+e.getMessage());
			else
				ESLog.error("error occured when insert complex transaction, the transaction is "+complexTransaction.toString(),e);
			
			
			
			try {
				if(conn != null && !conn.isClosed()) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				ESLog.error("error occured when roll back DB", e1);
			}
			
		} finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				ESLog.error("error occured when close connection", e);
			}
		}
	}




}
