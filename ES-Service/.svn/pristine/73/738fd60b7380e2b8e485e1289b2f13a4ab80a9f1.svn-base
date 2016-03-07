package com.hp.es.tm;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.service.TmService;
import com.hp.es.tm.util.exception.TmException;

public class TransactionLogging {
	private static TransactionLogging instance = new TransactionLogging();
	
	/**
	 * @return the instance
	 */
	public static TransactionLogging getInstance() {
		return instance;
	}

	/*
	 * default constructor (disables)
	 */
	private TransactionLogging() {
		
	}
	
	/*
	 * This is the place where logging happens
	 * 
	 */
	public void processRequest(Transaction transaction) {
		try {
			ESLog.debug("Start to process Transaction!");
			ComplexTransaction complexTransaction=TmService.getInstance().processTransaction(transaction);
			ESLog.debug("start to do getFraudServiceReply");
			if(complexTransaction != null) {
				TmService.getInstance().saveComplexTransaction(complexTransaction);
			}else {
				ESLog.error("This transaction is not expected to be logged");
			}
			
		} catch (TmException e) {
			ESLog.error("TmException when process Transaction Or insert TmTransaction into DB! This transaction will be skipped!",
							e); 
		} catch (Throwable t) {
			ESLog.error("TmException when process Transaction Or insert TmTransaction into DB! This transaction will be skipped!",
					t); 
		}



	}
}
