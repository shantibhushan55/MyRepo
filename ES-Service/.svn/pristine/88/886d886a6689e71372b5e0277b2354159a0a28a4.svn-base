package com.hp.es.service.orchestration.sap;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import com.hp.es.service.util.ESLog;
import com.hp.sif.SifException;
import com.sun.xml.ws.developer.JAXWSProperties;

abstract class MetroSOAPAccess extends SapSOAPAccess {
	protected final static int CachedPortPoolCapicity=50;
	protected final static boolean enablePortPooling = true;
	private Object objSyncAvailibility = new Object();
	
	protected MetroSOAPAccess(String url, String user, String password,
			long connectionTimeout, long unavailibilityDuration) {
		super(url, user, password, connectionTimeout, unavailibilityDuration);
	}

	@Override
	public abstract SapSOAPReply execute(String packageName, String sapFunctionName,
			Object request) throws SifException, SapAccessFailureException ;

	public synchronized  void setUnAvailable() {
		synchronized (objSyncAvailibility) {
			if(_available) {
				_endOfUnavailibility = System.currentTimeMillis() + _unavailibilityDuration;
				_available = false;
			}
		}
		
		
	}
	
	
	protected void recacheService() {
	}
	
	@Override
	public synchronized boolean isAvailable() {
		ESLog.debug("MetroSapSOAPAccess>>isAvailable>>_available=" + _available);
		ESLog.debug("MetroSapSOAPAccess>>isAvailable>>_endOfUnavailibility=" + _endOfUnavailibility);
		synchronized (objSyncAvailibility) {
			if(!_available && _endOfUnavailibility < System.currentTimeMillis()) {
				
					
						ESLog.error("This access should be again available, let's cache it again");
						recacheService();
						_available = true;
				
	
			}
		}
		ESLog.debug("MetroSapSOAPAccess>>isAvailable>>_availableReturned=" + _available);
		return _available;
	}
	
	
    protected void setupPortProperties(BindingProvider port) {
        Map<String, Object> requestContext = port.getRequestContext();
        
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, _url);
        requestContext.put(BindingProvider.USERNAME_PROPERTY, _user);
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, _password);
        if(_connectionTimeout > 0 ){
        	requestContext.put(JAXWSProperties.CONNECT_TIMEOUT,  (int)_connectionTimeout);
        	ESLog.debug("Setting read  timeout for "  +"com.sun.xml.ws.request.timeout"+ " to "+ _connectionTimeout+"ms" );
        	requestContext.put(JAXWSProperties.REQUEST_TIMEOUT,  (int)_connectionTimeout);
        }

        
       /* if(_url.startsWith("https")){            
            requestContext.put(JAXWSProperties.SSL_SOCKET_FACTORY, SSLSocketFactoryHolder.getSSLSocketFactory());
            requestContext.put(JAXWSProperties.HOSTNAME_VERIFIER, SSLSocketFactoryHolder.getSSLNostNameVerifier());
            
        	
        }*/
        /*boolean soapLogEnable = Configuration.getInstance().getProperties().getBoolean(EsConstants.ES_SOAP_LOGMESSAGE);
		if(soapLogEnable){
		    BindingProvider bindingProvider = ((BindingProvider) port);         
		    List handlerChain = bindingProvider.getBinding().getHandlerChain();         
		    handlerChain.add(new SOAPLoggingHandler());         
		    bindingProvider.getBinding().setHandlerChain(handlerChain); 
		}*/

    }
    
    
    protected void logTime(String sapFunction, long startTime, long serviceTime, long portTime, long endTime) {
        StringBuffer sb=new StringBuffer();
        sb.append("[Metro-perf] Function "+sapFunction+"|");
        sb.append("TotalTime "+(endTime - startTime)+"|");
        sb.append("ServiceTime "+(serviceTime - startTime)+"|");
        sb.append("PortTime "+(portTime - serviceTime)+"|");
        sb.append("Backend "+(endTime - portTime));
        ESLog.info(sb.toString());
    }
    
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MetroSapSOAPAccess [objSyncAvailibility=" + objSyncAvailibility
				+ ", toString()=" + super.toString() + "]";
	}
}
