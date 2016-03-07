package com.hp.es.tm;

import java.math.BigDecimal;

/**
 * @author zhanyoul<you-lin.zhang@hp.com>
 * 
 */
public class FraudTransactionMessage {
	protected long fraudWarningMessageIdentifier;
	protected long fraudTransactionIdentifier;
	protected BigDecimal tmTransactionId;

	/*
	 * TODO there is an 
	 */
	public long getFraudWarningMessageIdentifier() {
		return fraudWarningMessageIdentifier;
	}

	public void setFraudWarningMessageIdentifier(
			long fraudWarningMessageIdentifier) {
		this.fraudWarningMessageIdentifier = fraudWarningMessageIdentifier;
	}

	public long getFraudTransactionIdentifier() {
		return fraudTransactionIdentifier;
	}

	public void setFraudTransactionIdentifier(long fraudTransactionIdentifier) {
		this.fraudTransactionIdentifier = fraudTransactionIdentifier;
	}

	public BigDecimal getTmTransactionId() {
		return tmTransactionId;
	}

	public void setTmTransactionId(BigDecimal tmTransactionId) {
		this.tmTransactionId = tmTransactionId;
	}

	@Override
	public String toString() {
		return "FraudTransactionMessage [fraudTransactionIdentifier="
				+ fraudTransactionIdentifier
				+ ", fraudWarningMessageIdentifier="
				+ fraudWarningMessageIdentifier + ", tmTransactionId="
				+ tmTransactionId + "]";
	}

}
