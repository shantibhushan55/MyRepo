package com.hp.es.tm;

import com.hp.es.xml.service.EIAMessage;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;

/*
 * This is a simple bean to represent a ES Transaction 
 */
public class Transaction {

	long startDate;
	long endDate;
	EIAMessage request;
	EIAMessage reply;
	EIAMessage replyAfterFraud;
	private ComplianceValidationReply cvsReply;

	
	/**
	 * Constructor
	 */
	public Transaction() {
		super();

	}

	/**
	 * @return the startDate
	 */
	public long getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public long getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the request
	 */
	public EIAMessage getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(EIAMessage request) {
		this.request = request;
	}

	/**
	 * @return the reply
	 */
	public EIAMessage getReply() {
		return reply;
	}

	/**
	 * @param reply the reply to set
	 */
	public void setReply(EIAMessage reply) {
		this.reply = reply;
	}

	/**
	 * @return the replyAfterFraud
	 */
	public EIAMessage getReplyAfterFraud() {
		return replyAfterFraud;
	}

	/**
	 * @param replyAfterFraud the replyAfterFraud to set
	 */
	public void setReplyAfterFraud(EIAMessage replyAfterFraud) {
		this.replyAfterFraud = replyAfterFraud;
	}

	/**
	 * @param cvsReply the cvsReply to set
	 */
	public void setComplianceServiceReply(ComplianceValidationReply cvsReply) {
		this.cvsReply=cvsReply;
	}

	/**
	 * @return the ComplianceValidationReply
	 */
	public ComplianceValidationReply getComplianceServiceReply () {
		return cvsReply;
	}





}