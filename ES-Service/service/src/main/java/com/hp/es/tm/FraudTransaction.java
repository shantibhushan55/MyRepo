package com.hp.es.tm;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * This Class is mapped to table FRAUD_RSP
 * 
 * @author zengzhao
 * 
 */
public class FraudTransaction {
	//private BigDecimal fraudTransactionId;
	private BigDecimal fraudCheckTransactionId;
	private String originalEntitlementResponseCode;

	private BigDecimal tmTransactionId;

	// cannot get value. the same as before
	private String originalWarrantyId;
	private String originalWarrantyDeterminationCode;
	private BigDecimal esTransactionId;
	private String flagTypeCode;

	private Timestamp originalWarrantyStartDate;
	private Timestamp originalWarrantyEndDate;
	private Timestamp originalContractStartDate;
	private Timestamp originalContractEndDate;

	/*
	public BigDecimal getFraudTransactionId() {
		return fraudTransactionId;
	}

	public void setFraudTransactionId(BigDecimal fraudTransactionId) {
		this.fraudTransactionId = fraudTransactionId;
	}*/

	public BigDecimal getFraudCheckTransactionId() {
		return fraudCheckTransactionId;
	}

	public void setFraudCheckTransactionId(BigDecimal fraudCheckTransactionId) {
		this.fraudCheckTransactionId = fraudCheckTransactionId;
	}

	public BigDecimal getTmTransactionId() {
		return tmTransactionId;
	}

	public void setTmTransactionId(BigDecimal tmTransactionId) {
		this.tmTransactionId = tmTransactionId;
	}

	public String getOriginalEntitlementResponseCode() {
		return originalEntitlementResponseCode;
	}

	public void setOriginalEntitlementResponseCode(
			String originalEntitlementResponseCode) {
		this.originalEntitlementResponseCode = originalEntitlementResponseCode;
	}

	public String getOriginalWarrantyId() {
		return originalWarrantyId;
	}

	public void setOriginalWarrantyId(String originalWarrantyId) {
		this.originalWarrantyId = originalWarrantyId;
	}

	public String getOriginalWarrantyDeterminationCode() {
		return originalWarrantyDeterminationCode;
	}

	public void setOriginalWarrantyDeterminationCode(
			String originalWarrantyDeterminationCode) {
		this.originalWarrantyDeterminationCode = originalWarrantyDeterminationCode;
	}

	public BigDecimal getEsTransactionId() {
		return esTransactionId;
	}

	public void setEsTransactionId(BigDecimal esTransactionId) {
		this.esTransactionId = esTransactionId;
	}

	public String getFlagTypeCode() {
		return flagTypeCode;
	}

	public void setFlagTypeCode(String flagTypeCode) {
		this.flagTypeCode = flagTypeCode;
	}

	public Timestamp getOriginalWarrantyStartDate() {
		return originalWarrantyStartDate;
	}

	public void setOriginalWarrantyStartDate(Timestamp originalWarrantyStartDate) {
		this.originalWarrantyStartDate = originalWarrantyStartDate;
	}

	public Timestamp getOriginalWarrantyEndDate() {
		return originalWarrantyEndDate;
	}

	public void setOriginalWarrantyEndDate(Timestamp originalWarrantyEndDate) {
		this.originalWarrantyEndDate = originalWarrantyEndDate;
	}

	public Timestamp getOriginalContractStartDate() {
		return originalContractStartDate;
	}

	public void setOriginalContractStartDate(Timestamp originalContractStartDate) {
		this.originalContractStartDate = originalContractStartDate;
	}

	public Timestamp getOriginalContractEndDate() {
		return originalContractEndDate;
	}

	public void setOriginalContractEndDate(Timestamp originalContractEndDate) {
		this.originalContractEndDate = originalContractEndDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FraudTransaction [fraudCheckTransactionId="
				+ fraudCheckTransactionId
				+ ", originalEntitlementResponseCode="
				+ originalEntitlementResponseCode + ", tmTransactionId="
				+ tmTransactionId + ", originalWarrantyId="
				+ originalWarrantyId + ", originalWarrantyDeterminationCode="
				+ originalWarrantyDeterminationCode + ", esTransactionId="
				+ esTransactionId + ", flagTypeCode=" + flagTypeCode
				+ ", originalWarrantyStartDate=" + originalWarrantyStartDate
				+ ", originalWarrantyEndDate=" + originalWarrantyEndDate
				+ ", originalContractStartDate=" + originalContractStartDate
				+ ", originalContractEndDate=" + originalContractEndDate + "]";
	}


	

}
