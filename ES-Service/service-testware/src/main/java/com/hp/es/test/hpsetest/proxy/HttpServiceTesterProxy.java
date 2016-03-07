package com.hp.es.test.hpsetest.proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.hp.es.constants.EsConstants;
import com.hp.es.test.hpsetest.TestConfigHolder;

public class HttpServiceTesterProxy extends ServiceTesterProxy{

	public HttpServiceTesterProxy() {
		super();
	}


	/*
	 * send request as string
	 * @param XML request
	 * @return XML reply
	 * @throws java.lang.Exception
	 * @see com.hp.es.test.hpsetest.proxy.ServiceTesterProxy#sendRequest(java.lang.String)
	 */
	public String sendRequest(String requestXml) throws Exception {
        URL url = new URL(getServerAddress());
        BufferedReader in = null;
        BufferedWriter out = null;   
        StringBuffer replyXml = new StringBuffer();
        HttpURLConnection httpUrlCon = null;
        try {
	        if (url.getProtocol().toLowerCase().equals("http")) {
	        	httpUrlCon = (HttpURLConnection)url.openConnection();
	        }else {
	        	httpUrlCon = (HttpsURLConnection)url.openConnection();
	        	
	        }
	        httpUrlCon.setDoOutput(true);
	        httpUrlCon.setDoInput(true);
	        httpUrlCon.setDefaultUseCaches(false);
	        httpUrlCon.setUseCaches(false);
	        httpUrlCon.setRequestMethod("POST");
	        httpUrlCon.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
	        
	        //httpUrlCon.setRequestProperty("charset","UTF-8");
	        
	        
	        httpUrlCon.connect();
	
	        
	        /*
	         * Writing the request to the socket
	         */
	        
	        //

	      
	        out = new BufferedWriter(new OutputStreamWriter(httpUrlCon.getOutputStream(), "UTF8"));
	        
	        
	        //out.write("POST " + url.getPath() + " HTTP/1.0\r\n");
	        //out.write("Content-Length: " + String.valueOf(requestXml.length())
	        //        + "\r\n");
	        //out.write(EsConstants.HTTP_HEADER);
	        //out.write("\r\n");
	        out.write(requestXml);
	        out.flush();
	
	        /*
	         * reading the reply from the socket
	         */        
	        
	        in = new BufferedReader(new InputStreamReader(httpUrlCon.getInputStream(), EsConstants.UTF8_ENCODING));
	
	        String buffer;
	        while ((buffer = in.readLine()) != null) {
	            replyXml.append(buffer);
	        }
        }finally {
        	try {
        		if (httpUrlCon != null) {
        			httpUrlCon.disconnect();
        		}       		
        	} catch(Exception e) {};
        	
        	if(in != null) {
            	try {
            		in.close();       		
            	} catch(Exception e) {};
        		
        	}
        	if(out != null) {
            	try {
            		out.close();       		
            	} catch(Exception e) {};
        	}
        }
		
		return replyXml.toString();
	}

	/*
	 * Return name for proxy
	 * @see com.hp.es.test.hpsetest.proxy.ServiceTesterProxy#getName()
	 */
	public String getName() {
		return this.getClass().getName();
	}

	/*
	 * return Server URL
	 * @see com.hp.es.test.hpsetest.proxy.ServiceTesterProxy#getServerAddress()
	 */
	public String getServerAddress() {
		return TestConfigHolder.getInstance().getConfigParameter("hpse.test.http.url");
	}

	/*
	 * Init method
	 * @see com.hp.es.test.hpsetest.proxy.ServiceTesterProxy#init()
	 */
	public void init() {
		//Nothing to init
		
	}

}
