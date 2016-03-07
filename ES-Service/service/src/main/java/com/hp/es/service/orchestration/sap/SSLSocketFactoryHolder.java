package com.hp.es.service.orchestration.sap;

import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;


public class SSLSocketFactoryHolder {
	/*
	 * SSL factory
	 */
    private static SSLSocketFactory factory;
    /**
     * Hostname verifier.
     */
    private static HostnameVerifier _hostnameVerifier = new FakeHostnameVerifier();
    /**
     * Thrust managers.
     */
    private static TrustManager[] _trustManagers = new TrustManager[] {new FakeX509TrustManager()};;
    
    private static weblogic.security.SSL.TrustManager[] _trustManagersBEA  = new weblogic.security.SSL.TrustManager[] {new BEATrustManager()};;
    
    public static synchronized SSLSocketFactory getSSLSocketFactory() {
        if (factory == null) {
            factory = createSSLSocketFactory();
        }
        return factory;
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        ESLog.debug("ENTER");
        SSLSocketFactory factory = null;
        // SSL case
        ESLog.debug("Overwrite TrustManager");
        /*
         * This is used to accept the strange SAP certificate coming from the fact that they are using foundry switch
         */
        
        SSLContext sslContext = null;
        ESLog.debug("SSLContext.getInstance(\"SSL\")");
        try {
        	

            ESLog.debug("SSLContext.getInstance(\"SSL\")");
            sslContext = SSLContext.getInstance(EsConstants.SSL_PROTOCOL);
            ESLog.debug("SSLContext init");
            sslContext.init(null, _trustManagers, new java.security.SecureRandom());
            ESLog.debug("Creating SSLSocketFactory");
            factory = sslContext.getSocketFactory();
            /* we also set the default socket factory*/
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory()); 
            ESLog.debug("Created SSLSocketFactory");
            
            //let's do the same for web logic.
            //weblogic.security.SSL.SSLContext.getInstance(EsConstants.SSL_PROTOCOL).setTrustManager(new BEATrustManager());
            
            
            
        } catch (Exception e) {
            ESLog.error("Exception in init ssl socket factory...", e);
        }

        return factory;
    }
    
    
    /**
     * This class implements a fake hostname verificator, trusting any host 
     * name.
     *
     */
    public static class FakeHostnameVerifier implements HostnameVerifier {
        
        /**
         * Always return true, indicating that the host name is 
         * an acceptable match with the server's authentication scheme.
         *
         * @param hostname        the host name.
         * @param session         the SSL session used on the connection to 
         * host.
         * @return                the true boolean value 
         * indicating the host name is trusted.
         */
        public boolean verify(String hostname, 
            javax.net.ssl.SSLSession session) {
            return(true);
        } // verify
    } // FakeHostnameVerifier

    /**
     * This class allow any X509 certificates to be used to authenticate the 
     * remote side of a secure socket, including self-signed certificates.
     *
     */
    public static class FakeX509TrustManager implements X509TrustManager {

        /**
         * Empty array of certificate authority certificates.
         */
        private static final X509Certificate[] _AcceptedIssuers = 
            new X509Certificate[] {};


        /**
         * Always trust for client SSL chain peer certificate 
         * chain with any authType authentication types.
         *
         * @param chain           the peer certificate chain.
         * @param authType        the authentication type based on the client 
         * certificate.
         */
        public void checkClientTrusted(X509Certificate[] chain, 
            String authType) {
        } // checkClientTrusted
        
        /**
         * Always trust for server SSL chain peer certificate 
         * chain with any authType exchange algorithm types.
         *
         * @param chain           the peer certificate chain.
         * @param authType        the key exchange algorithm used.
         */
        public void checkServerTrusted(X509Certificate[] chain, 
            String authType) {
        } // checkServerTrusted
        
        /**
         * Return an empty array of certificate authority certificates which 
         * are trusted for authenticating peers.
         *
         * @return                a empty array of issuer certificates.
         */
        public X509Certificate[] getAcceptedIssuers() {
            return(_AcceptedIssuers);
        } // getAcceptedIssuers
    } // FakeX509TrustManager

	public static HostnameVerifier getSSLNostNameVerifier() {
	        // Install the all-trusting host name verifier:
	      javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(_hostnameVerifier);
	      return _hostnameVerifier;
	}
	
	
    public static class BEATrustManager implements weblogic.security.SSL.TrustManager {

        public boolean certificateCallback(X509Certificate[] chain, int validateErr){
        		             return true;
        }
    } // BEATrustManager
    
    public class BEAHostnameVerifier implements weblogic.security.SSL.HostnameVerifier
    {
        public boolean verify(final String urlHostname, final javax.net.ssl.SSLSession session)
        {
            return true;
        }
    }
}

