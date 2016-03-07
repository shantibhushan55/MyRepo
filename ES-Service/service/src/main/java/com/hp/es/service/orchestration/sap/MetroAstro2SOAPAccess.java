package com.hp.es.service.orchestration.sap;

import javax.xml.ws.BindingProvider;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WS;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WSPortType;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WSResponse;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WSService;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ThreadLocalHolder;
import com.hp.sif.SifException;

public class MetroAstro2SOAPAccess extends MetroSOAPAccess {

	
	
	private static ZA2FMAESGETENTV3WSService cachedZA2FMAESGETENTV3WSService;
	private static CachedPortPool<ZA2FMAESGETENTV3WSPortType> portPoolZA2FMAESGETENTV3WSPortType        ;
	
	
	static {
    		ESLog.error("caching service URL for MetroAstro2SOAPAccess");
    		cachedZA2FMAESGETENTV3WSService = new ZA2FMAESGETENTV3WSService();
    		if(enablePortPooling) {
    			ESLog.error("creating port cache for METRO");
    			cachedPortPoolZA2FMAESGETENTV3WSPortType();
    			
    		}

	}
	
	protected MetroAstro2SOAPAccess(String url, String user, String password,
			long connectionTimeout, long unavailibilityDuration) {
		super(url, user, password, connectionTimeout, unavailibilityDuration);
	}

	@Override
    public SapSOAPReply execute(String packageName, String sapFunctionName, Object request) throws SifException, SapAccessFailureException {
        ESLog.debug("ENTER");
        long starttime = System.currentTimeMillis();
        Object response = null;
        try{

            if (EsConstants.SAP_FUNCTION_NAME_ASTRO2.equals(sapFunctionName)) {
                response = getAstro2Response(request);
            }
        }catch(Exception e){
        	
			long timeTaken= System.currentTimeMillis() - starttime;
            ESLog.error("SOAP Exception during communication after " +timeTaken+" msec", e);
            // threadlocal will be cleaned in Region
            ESLog.error("Dumping config " + this.toString());
            ESLog.error("Dumping request/response: " +ThreadLocalHolder.getAllAsString());
            throw new SapAccessFailureException("Caught exception while accessing SAP with SOAP", e);
            //throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Exception during communication with SOAP");
        }
        
        SapSOAPReply result = new SapSOAPReply(response);
        return result;
    }
	
	
	private Object getAstro2Response(Object request) {
		ZA2FMAESGETENTV3WSService  service = null;
		ZA2FMAESGETENTV3WSPortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
	        if(portPoolZA2FMAESGETENTV3WSPortType!=null) {
	        		port = portPoolZA2FMAESGETENTV3WSPortType.borrowObject();
	        }
   
	        if(port ==null) {// no port in pool...
	        	service =getCachedZA2FMAESGETENTV3WSService();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZA2FMAESGETENTV3WSPortType();
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);    
	        portTime=System.currentTimeMillis();   
	        ZA2FMAESGETENTV3WSResponse response = port.za2FMAESGETENTV3WS((ZA2FMAESGETENTV3WS) request); 
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("za2FMAESGETENTV3WS",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZA2FMAESGETENTV3WSPortType!=null)
					portPoolZA2FMAESGETENTV3WSPortType.returnObject(port);
			}
		}
    }
	
	

	private ZA2FMAESGETENTV3WSService getCachedZA2FMAESGETENTV3WSService() {
		return cachedZA2FMAESGETENTV3WSService;
	}

	private static void cachedPortPoolZA2FMAESGETENTV3WSPortType() {
		portPoolZA2FMAESGETENTV3WSPortType = new CachedPortPool<ZA2FMAESGETENTV3WSPortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZA2FMAESGETENTV3WSPortType.returnObject(cachedZA2FMAESGETENTV3WSService.getZA2FMAESGETENTV3WSPortType());
		}
	
	}
	
	
	
}
