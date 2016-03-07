package com.hp.es.service.customerIndicator;

public class CustomIndicator {

	public CustomIndicator(){
		
	}
	
	private String soldToCustomerID;
	private String customerIndicatorName;
	private String customerIndicatorValue;

	
	public String getCustomerIndicatorName() {
		return customerIndicatorName;
	}
	public void setCustomerIndicatorName(String customerIndicatorName) {
		this.customerIndicatorName = customerIndicatorName;
	}
	public String getCustomerIndicatorValue() {
		return customerIndicatorValue;
	}
	public void setCustomerIndicatorValue(String customerIndicatorValue) {
		this.customerIndicatorValue = customerIndicatorValue;
	}
	public String getSoldToCustomerID() {
		return soldToCustomerID;
	}
	public void setSoldToCustomerID(String soldToCustomerID) {
		this.soldToCustomerID = soldToCustomerID;
	}
	
}
