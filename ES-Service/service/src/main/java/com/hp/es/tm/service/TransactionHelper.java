package com.hp.es.tm.service;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.Transaction;

final class TransactionHelper {

	private TransactionHelper() {
	}

	/*
	 * Calculate response time
	 */
	static long calculateResponseTime(Transaction trans) {
		long startDate = getStartDate(trans);
		long endDate = trans.getEndDate();
		ESLog.debug("The operation end date=" + endDate);
		long responseTime = (endDate - startDate);
		ESLog.debug("The operation response time=" + responseTime);
		return responseTime;
	}

	
	
	/*
	 * Calculate response time
	 */
	static long getStartDate(Transaction trans) {
		long startDate = trans.getStartDate();
		ESLog.debug("The operation start date=" + startDate);
		return startDate;
	}

	
}
