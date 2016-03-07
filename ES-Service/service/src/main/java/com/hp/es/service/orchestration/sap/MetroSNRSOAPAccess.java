package com.hp.es.service.orchestration.sap;

import javax.xml.ws.BindingProvider;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.IManufacturingInstalledBaseService;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingBillOfMaterialRequest;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingBillOfMaterialResponse;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingInstalledBaseService;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ThreadLocalHolder;
import com.hp.sif.SifException;

public class MetroSNRSOAPAccess extends MetroSOAPAccess{


		private static ManufacturingInstalledBaseService cachedManufacturingInstalledBaseService;
		
		private final static int CachedPortPoolCapicity=50;
		
		
		private static CachedPortPool<IManufacturingInstalledBaseService> portPoolIManufacturingInstalledBaseService;
		

		protected MetroSNRSOAPAccess(String url, String user, String password, long connectionTimeout, long unavailibilityDuration) {
	        super(url, user, password, connectionTimeout, unavailibilityDuration);
	    }
	    
	    //private void cacheService() {
	    	//synchronized (initSyncMutex) {
		static {
		    		ESLog.error("caching service URL for MetroSNRSOAPAccess");
			    	cachedManufacturingInstalledBaseService = new ManufacturingInstalledBaseService();
			    	/*
			    	 * For each of them, we'll also get a port to initialize it
			    	 * 
			    	 * 
			    	 */
			    	
			    	if(enablePortPooling) {
			    		ESLog.error("creating port cache for METRO");
			    		cachedPortPoolIManufacturingInstalledBaseService();
			    	}

	    	}

	@Override
    public SapSOAPReply execute(String packageName, String sapFunctionName, Object request) throws SifException, SapAccessFailureException {
        ESLog.debug("ENTER");
        long starttime = System.currentTimeMillis();
        Object response = null;
        try{
            if(EsConstants.FUNCTION_NAME_SNR_MFG.equals(sapFunctionName)){
            	response = getManufacturingBillOfMaterialForEntitlement(request);
            }
        }
        /*catch(ClientTransportException cte){
            //exception may be caused by Timeout, bad url, bad user, bad password, etc. 
            ESLog.error("Caught ClientTransportException while processing SOAP request", cte);
            // threadlocal will be cleaned in Region
            ESLog.error("Dumping config " + this.toString());
            ESLog.error(ThreadLocalHolder.getAllAsString());
            throw new SapAccessFailureException("Caught exception while accessing SAP with SOAP", cte); 
        }*/
        catch(Exception e){
        	
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
	
	
	private Object getManufacturingBillOfMaterialForEntitlement(Object request) {
		ManufacturingInstalledBaseService  service = null;
		IManufacturingInstalledBaseService port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
	        if(portPoolIManufacturingInstalledBaseService != null) {
	        	port = portPoolIManufacturingInstalledBaseService.borrowObject();
	        }
	        if(port ==null) {// no port in pool...
	        	service =getCachedManufacturingInstalledBaseService();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getWSHttpBindingIManufacturingInstalledBaseService();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ManufacturingBillOfMaterialResponse response = port.getManufacturingBillOfMaterial((ManufacturingBillOfMaterialRequest)request);        
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("getManufacturingBillOfMaterialForEntitlement",startTime, serviceTime, portTime, endTime);	
			if(toReturn) {
				 if(portPoolIManufacturingInstalledBaseService != null) {
					 portPoolIManufacturingInstalledBaseService.returnObject(port);
				 }
			}
		}
        
       
	}
	
	
	private static void cachedPortPoolIManufacturingInstalledBaseService() {
		portPoolIManufacturingInstalledBaseService = new CachedPortPool<IManufacturingInstalledBaseService>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			
			portPoolIManufacturingInstalledBaseService.returnObject(cachedManufacturingInstalledBaseService.getWSHttpBindingIManufacturingInstalledBaseService());
		}
		
	}
	
	private ManufacturingInstalledBaseService getCachedManufacturingInstalledBaseService() {
		return cachedManufacturingInstalledBaseService;
	}

}
