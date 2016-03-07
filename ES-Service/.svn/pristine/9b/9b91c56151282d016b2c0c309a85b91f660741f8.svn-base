package com.hp.es.tm;

/**
 * @author zhanyoul<you-lin.zhang@hp.com>
 *
 */
public class ComplexTransaction {
	public TmTransaction tmTransaction=new TmTransaction();
	public FraudTransaction fraudTransaction =new FraudTransaction();
	

	public TmTransaction getTmTransaction() {
		return tmTransaction;
	}
	public void setTmTransaction(TmTransaction tmTransaction) {
		this.tmTransaction = tmTransaction;
	}
	public FraudTransaction getFraudTransaction() {
		return fraudTransaction;
	}
	public void setFraudTransaction(FraudTransaction fraudTransaction) {
		this.fraudTransaction = fraudTransaction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer tmp = new StringBuffer();
		tmp.append(tmTransaction.toString());
		if(fraudTransaction != null) {
			tmp.append("\n");
			tmp.append(fraudTransaction.toString());
		}
		return tmp.toString();
	}
	

}
