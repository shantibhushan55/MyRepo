package com.hp.es.service.util;

//TODO this should not be static

public class ThreadLocalHolder {

	private static ThreadLocal<String> requests = new ThreadLocal<String>();
	private static ThreadLocal<String> responeses = new ThreadLocal<String>();
	private static ThreadLocal<String> hostNames = new ThreadLocal<String>();
	private static ThreadLocal<String> hostUrls = new ThreadLocal<String>();
	private static ThreadLocal<String> regionNames = new ThreadLocal<String>();

	public static ThreadLocal<String> getRequests() {
		return requests;
	}

	public static ThreadLocal<String> getResponeses() {
		return responeses;
	}

	public static ThreadLocal<String> getHostNames() {
		return hostNames;
	}

	public static ThreadLocal<String> getHostUrls() {
		return hostUrls;
	}

	public static ThreadLocal<String> getRegionNames() {
		return regionNames;
	}
	
	public static void removeAll() {
		requests.remove();
		responeses.remove();
		hostNames.remove();
		hostUrls.remove();
		regionNames.remove();
	}
	
	public static String getAllAsString() {
		return "SOAP request is: " + requests.get()
				+ "\n SOAP response is: " + responeses.get()
				+ "\n Host name is: " + hostNames.get()
				+ "\n Host url is: " + hostUrls.get()
				+ "\n Region name is: " + regionNames.get();
	}

}
