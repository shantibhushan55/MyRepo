package com.hp.es.service;


/*
 * An adapter interface
 * Adapters are responsible of accessing data in the backend system 
 */

public interface AdapterInterface {
	
	public Object execute(Object request) throws Exception;

	
	/*
	 * @return the status of the integration layer. This call should be directed to the adapter
	 */
	public boolean isAvailable();
	
	/*
	 * @return the status of the integration layer. This call should be directed to the adapter
	 */	
	public boolean isRunningOnMain();

	/*
	 * @return the status of the integration layer. This call should be directed to the adapter
	 */	
	public boolean isRunningOnFailover();
	
	/*
	 * @return the number of consecutive failures. This call should be directed to the adapter
	 */		
	public int getConsecutiveFailures();	
}
