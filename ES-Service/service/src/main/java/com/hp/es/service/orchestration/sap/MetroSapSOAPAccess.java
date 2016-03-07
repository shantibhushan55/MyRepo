package com.hp.es.service.orchestration.sap;

import javax.xml.ws.BindingProvider;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTBYSNES10;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTBYSNES10PortType;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTBYSNES10Response;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTBYSNES10Service;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTES10;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTES10PortType;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTES10Response;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTES10Service;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ObjectFactory;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10PortType;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Service;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10PortType;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10Response;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10Service;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWARRANTYEVENTHISTORY;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWARRANTYEVENTHISTORYPortType;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWARRANTYEVENTHISTORYResponse;
import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWARRANTYEVENTHISTORYService;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ThreadLocalHolder;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSU;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSUPortType;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSUResponse;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSUService;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWARRANTYWILDCARDSEARCH;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWARRANTYWILDCARDSEARCHPortType;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWARRANTYWILDCARDSEARCHResponse;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWARRANTYWILDCARDSEARCHService;
import com.hp.sif.SifException;

public class MetroSapSOAPAccess extends MetroSOAPAccess {
	
  //  private boolean init = false;
   // private Object initSyncMutex = new Object();
	private static ZWARRANTYWILDCARDSEARCHService cachedZWARRANTYWILDCARDSEARCHService;
	private static ZWARRANTYLOOKUPPARALLELBSUService cachedZWARRANTYLOOKUPPARALLELBSUService;
	private static ZESCONTRACTSUMES10Service cachedZESCONTRACTSUMES10Service;
	private static ZESCONTRACTENTBYSNES10Service cachedZESCONTRACTENTBYSNES10Service;
	private static ZESCONTRACTENTES10Service cachedZESCONTRACTENTES10Service;
	private static ZESROUTINGDETAILSES10Service cachedZESROUTINGDETAILSES10Service;
	private static ZWARRANTYEVENTHISTORYService cachedZWARRANTYEVENTHISTORYService;

	
	
	
	private static CachedPortPool<ZWARRANTYWILDCARDSEARCHPortType> portPoolZWARRANTYWILDCARDSEARCHPortType;                                     
	private static CachedPortPool<ZWARRANTYLOOKUPPARALLELBSUPortType> portPoolZWARRANTYLOOKUPPARALLELBSUPortType   ;          
	private static CachedPortPool<ZESCONTRACTSUMES10PortType> portPoolZESCONTRACTSUMES10PortType      ;               
	private static CachedPortPool<ZESCONTRACTENTBYSNES10PortType> portPoolZESCONTRACTENTBYSNES10PortType  ;               
	private static CachedPortPool<ZESCONTRACTENTES10PortType> portPoolZESCONTRACTENTES10PortType       ;              
	private static CachedPortPool<ZESROUTINGDETAILSES10PortType> portPoolZESROUTINGDETAILSES10PortType   ;               
	private static CachedPortPool<ZWARRANTYEVENTHISTORYPortType> portPoolZWARRANTYEVENTHISTORYPortType   ;               

	
	

	protected MetroSapSOAPAccess(String url, String user, String password, long connectionTimeout, long unavailibilityDuration) {
        super(url, user, password, connectionTimeout, unavailibilityDuration);
    }
    
	static {
	    		ESLog.error("caching service URL for MetroSOAPAccess");
		    	cachedZWARRANTYWILDCARDSEARCHService = new ZWARRANTYWILDCARDSEARCHService();
		    	cachedZWARRANTYLOOKUPPARALLELBSUService = new ZWARRANTYLOOKUPPARALLELBSUService();
		    	cachedZESCONTRACTSUMES10Service = new ZESCONTRACTSUMES10Service();
		    	cachedZESCONTRACTENTBYSNES10Service = new ZESCONTRACTENTBYSNES10Service();
		    	cachedZESCONTRACTENTES10Service = new ZESCONTRACTENTES10Service();
		    	cachedZESROUTINGDETAILSES10Service = new ZESROUTINGDETAILSES10Service();
		    	cachedZWARRANTYEVENTHISTORYService = new ZWARRANTYEVENTHISTORYService();


		    	/*
		    	 * For each of them, we'll also get a port to initialize it
		    	 * 
		    	 * 
		    	 */
		    	
		    	if(enablePortPooling) {
		    		ESLog.error("creating port cache for METRO");
			    	cachedPortPoolZWARRANTYWILDCARDSEARCHPortType                ();
			    	cachedPortPoolZWARRANTYWILDCARDSEARCHPortType                ();
			    	cachedPortPoolZWARRANTYLOOKUPPARALLELBSUPortType             ();
			    	cachedPortPoolZESCONTRACTSUMES10PortType                     ();
			    	cachedPortPoolZESCONTRACTENTBYSNES10PortType                 ();
			    	cachedPortPoolZESCONTRACTENTES10PortType                     ();
			    	cachedPortPoolZESROUTINGDETAILSES10PortType                  ();
			    	cachedPortPoolZWARRANTYEVENTHISTORYPortType                  ();
		    	}

    	}

	private ZWARRANTYEVENTHISTORYService getCachedZWARRANTYEVENTHISTORYService() {
		return cachedZWARRANTYEVENTHISTORYService;
	}

	private static void cachedPortPoolZWARRANTYEVENTHISTORYPortType() {
		portPoolZWARRANTYEVENTHISTORYPortType = new CachedPortPool<ZWARRANTYEVENTHISTORYPortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			
			portPoolZWARRANTYEVENTHISTORYPortType.returnObject(cachedZWARRANTYEVENTHISTORYService.getZWARRANTYEVENTHISTORYPortType());
		}
		
	}
	private static void cachedPortPoolZESROUTINGDETAILSES10PortType() {
		portPoolZESROUTINGDETAILSES10PortType = new CachedPortPool<ZESROUTINGDETAILSES10PortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZESROUTINGDETAILSES10PortType.returnObject(cachedZESROUTINGDETAILSES10Service.getZESROUTINGDETAILSES10PortType());
		}
		
	}
	private static void cachedPortPoolZESCONTRACTENTES10PortType() {
		portPoolZESCONTRACTENTES10PortType = new CachedPortPool<ZESCONTRACTENTES10PortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZESCONTRACTENTES10PortType.returnObject(cachedZESCONTRACTENTES10Service.getZESCONTRACTENTES10PortType());
		}
		
	}
	private static void cachedPortPoolZESCONTRACTENTBYSNES10PortType() {
		portPoolZESCONTRACTENTBYSNES10PortType = new CachedPortPool<ZESCONTRACTENTBYSNES10PortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZESCONTRACTENTBYSNES10PortType.returnObject(cachedZESCONTRACTENTBYSNES10Service.getZESCONTRACTENTBYSNES10PortType());
		}
		
	}

	private static void cachedPortPoolZESCONTRACTSUMES10PortType() {
		portPoolZESCONTRACTSUMES10PortType = new CachedPortPool<ZESCONTRACTSUMES10PortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZESCONTRACTSUMES10PortType.returnObject(cachedZESCONTRACTSUMES10Service.getZESCONTRACTSUMES10PortType());
		}
		
	}
	private static void cachedPortPoolZWARRANTYLOOKUPPARALLELBSUPortType() {
		portPoolZWARRANTYLOOKUPPARALLELBSUPortType = new CachedPortPool<ZWARRANTYLOOKUPPARALLELBSUPortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZWARRANTYLOOKUPPARALLELBSUPortType.returnObject(cachedZWARRANTYLOOKUPPARALLELBSUService.getZWARRANTYLOOKUPPARALLELBSUPortType());
		}
			
	}
	private static void cachedPortPoolZWARRANTYWILDCARDSEARCHPortType() {
		portPoolZWARRANTYWILDCARDSEARCHPortType = new CachedPortPool<ZWARRANTYWILDCARDSEARCHPortType>();
		for(int i=0;i<CachedPortPoolCapicity;i++) {
			portPoolZWARRANTYWILDCARDSEARCHPortType.returnObject(cachedZWARRANTYWILDCARDSEARCHService.getZWARRANTYWILDCARDSEARCHPortType());
		}
	
	}
	private ZWARRANTYWILDCARDSEARCHService getCachedZWARRANTYWILDCARDSEARCHService() {
		return cachedZWARRANTYWILDCARDSEARCHService;
	}



	private ZWARRANTYLOOKUPPARALLELBSUService getCachedZWARRANTYLOOKUPPARALLELBSUService() {
		return cachedZWARRANTYLOOKUPPARALLELBSUService;
	}

	private ZESCONTRACTSUMES10Service getCachedZESCONTRACTSUMES10Service() {
		return cachedZESCONTRACTSUMES10Service;
	}

	private ZESCONTRACTENTBYSNES10Service getCachedZESCONTRACTENTBYSNES10Service() {
		return cachedZESCONTRACTENTBYSNES10Service;
	}

	private ZESCONTRACTENTES10Service getCachedZESCONTRACTENTES10Service() {
		return cachedZESCONTRACTENTES10Service;
	}

	private ZESROUTINGDETAILSES10Service getCachedZESROUTINGDETAILSES10Service() {
		return cachedZESROUTINGDETAILSES10Service;
	}
	
	


	@Override
    public SapSOAPReply execute(String packageName, String sapFunctionName, Object request) throws SifException, SapAccessFailureException {
        ESLog.debug("ENTER");
        long starttime = System.currentTimeMillis();
        Object response = null;
        try{
            if (EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS.equals(sapFunctionName)) {
                ZESROUTINGDETAILSES10Response routingDetailsResponse = getRoutingDetailsResponse(request);
                response = routingDetailsResponse;
            } else if (EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT.equals(sapFunctionName)) {
                response = getContractEntResponse(request);
            } else if (EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT_BYSN.equals(sapFunctionName)) {
                response = getContractEntBySnResponse(request);
            } else if (EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM.equals(sapFunctionName)) {
                response = getContractSummaryResponse(request);
            } else if (EsConstants.SAP_FUNCTION_NAME_SWOP.equals(sapFunctionName)) {
                response = getSwopResponse(request);
            } else if (EsConstants.SAP_FUNCTION_NAME_IBSEARCH.equals(sapFunctionName)) {
                response = getIBSearchResponse(request);
            } else if(EsConstants.SAP_FUNCTION_NAME_UNITEVENTHISTORY.equals(sapFunctionName)){
            	response = getUnitEventHistory(request);
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

	


	private Object getUnitEventHistory(Object request) {
		
		
		ZWARRANTYEVENTHISTORYService  service = null;
		ZWARRANTYEVENTHISTORYPortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
	        if(portPoolZWARRANTYEVENTHISTORYPortType!=null) {
	        	port = portPoolZWARRANTYEVENTHISTORYPortType.borrowObject();
	        	portTime=System.currentTimeMillis();
	        }
	        if(port ==null) {// no port in pool...
	        	service =getCachedZWARRANTYEVENTHISTORYService();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZWARRANTYEVENTHISTORYPortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZWARRANTYEVENTHISTORYResponse response = port.zWARRANTYEVENTHISTORY((ZWARRANTYEVENTHISTORY) request);   
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("ZWARRANTYEVENTHISTORYResponse",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZWARRANTYEVENTHISTORYPortType!=null) {
					portPoolZWARRANTYEVENTHISTORYPortType.returnObject(port);
				}
			}
		}

	}
	


	


	
              

    private Object getIBSearchResponse(Object request) {
    	
    	ZWARRANTYWILDCARDSEARCHService  service = null;
    	ZWARRANTYWILDCARDSEARCHPortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
			if(portPoolZWARRANTYWILDCARDSEARCHPortType!=null) {
				port = portPoolZWARRANTYWILDCARDSEARCHPortType.borrowObject();
			}
	        portTime=System.currentTimeMillis();   
	        if(port ==null) {// no port in pool...
	        	service =getCachedZWARRANTYWILDCARDSEARCHService();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZWARRANTYWILDCARDSEARCHPortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZWARRANTYWILDCARDSEARCHResponse response = port.zWARRANTYWILDCARDSEARCH((ZWARRANTYWILDCARDSEARCH) request);
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("zWARRANTYWILDCARDSEARCH",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZWARRANTYWILDCARDSEARCHPortType!=null) 
					portPoolZWARRANTYWILDCARDSEARCHPortType.returnObject(port);
			}
		}    	
    }

    

 
    private Object getSwopResponse(Object request) {
    	
    	ZWARRANTYLOOKUPPARALLELBSUService  service = null;
    	ZWARRANTYLOOKUPPARALLELBSUPortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
			if(portPoolZWARRANTYLOOKUPPARALLELBSUPortType!=null)  {
				port = portPoolZWARRANTYLOOKUPPARALLELBSUPortType.borrowObject();
				portTime=System.currentTimeMillis();
			}
	        if(port ==null) {// no port in pool...
	        	service =getCachedZWARRANTYLOOKUPPARALLELBSUService();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZWARRANTYLOOKUPPARALLELBSUPortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZWARRANTYLOOKUPPARALLELBSUResponse response = port.zWARRANTYLOOKUPPARALLELBSU((ZWARRANTYLOOKUPPARALLELBSU) request);
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("zWARRANTYLOOKUPPARALLELBSU",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZWARRANTYLOOKUPPARALLELBSUPortType!=null)
					portPoolZWARRANTYLOOKUPPARALLELBSUPortType.returnObject(port);
			}
		}
    }

    
    
    


    	
   
    private Object getContractSummaryResponse(Object request) {
    	
    	ZESCONTRACTSUMES10Service  service = null;
    	ZESCONTRACTSUMES10PortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
			if(portPoolZESCONTRACTSUMES10PortType!=null) {
		        port = portPoolZESCONTRACTSUMES10PortType.borrowObject();
		        portTime=System.currentTimeMillis();
			}
	        if(port ==null) {// no port in pool...
	        	service =getCachedZESCONTRACTSUMES10Service();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZESCONTRACTSUMES10PortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZESCONTRACTSUMES10 contractSummaryRequest = (ZESCONTRACTSUMES10) request;
	        ObjectFactory of = new ObjectFactory();
	        contractSummaryRequest.setCONTACTS(of.createZESCONTRACTSUMES10CONTACTS());
	        contractSummaryRequest.setDELIVERABLES(of.createZESCONTRACTSUMES10DELIVERABLES());
	        contractSummaryRequest.setLOCATIONS(of.createZESCONTRACTSUMES10LOCATIONS());
	        contractSummaryRequest.setMESSAGES(of.createZESCONTRACTSUMES10MESSAGES());
	        contractSummaryRequest.setOBLIGATIONHEADERS(of.createZESCONTRACTSUMES10OBLIGATIONHEADERS());
	        contractSummaryRequest.setPRODUCTS(of.createZESCONTRACTSUMES10PRODUCTS());
	        contractSummaryRequest.setRUNTIME(of.createZESCONTRACTSUMES10RUNTIME());
	        contractSummaryRequest.setSERVICES(of.createZESCONTRACTSUMES10SERVICES());
	        ZESCONTRACTSUMES10Response response = port.zesCONTRACTSUMES10(contractSummaryRequest);
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("zesCONTRACTSUMES10",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZESCONTRACTSUMES10PortType!=null) {					
					portPoolZESCONTRACTSUMES10PortType.returnObject(port);
				}
			}
		}
    }

    
    

    private Object getContractEntBySnResponse(Object request) {
    	ZESCONTRACTENTBYSNES10Service  service = null;
    	ZESCONTRACTENTBYSNES10PortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
			if(portPoolZESCONTRACTENTBYSNES10PortType!=null) {
				port = portPoolZESCONTRACTENTBYSNES10PortType.borrowObject();
				portTime=System.currentTimeMillis();   
			}
	        if(port ==null) {// no port in pool...
	        	service =getCachedZESCONTRACTENTBYSNES10Service();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZESCONTRACTENTBYSNES10PortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZESCONTRACTENTBYSNES10Response response = port.zesCONTRACTENTBYSNES10((ZESCONTRACTENTBYSNES10) request);
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("zesCONTRACTENTBYSNES10",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZESCONTRACTENTBYSNES10PortType!=null) 
					portPoolZESCONTRACTENTBYSNES10PortType.returnObject(port);
			}
		}
    }

    private ZESCONTRACTENTES10Response getContractEntResponse(Object request) {
    	ZESCONTRACTENTES10Service  service = null;
    	ZESCONTRACTENTES10PortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
			if(portPoolZESCONTRACTENTES10PortType!=null) { 
		        port = portPoolZESCONTRACTENTES10PortType.borrowObject();
		        portTime=System.currentTimeMillis();   
			}
	        if(port ==null) {// no port in pool...
	        	service =getCachedZESCONTRACTENTES10Service();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZESCONTRACTENTES10PortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZESCONTRACTENTES10Response response = port.zesCONTRACTENTES10((ZESCONTRACTENTES10) request);
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("zesCONTRACTENTES10",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZESCONTRACTENTES10PortType!=null) { 
					portPoolZESCONTRACTENTES10PortType.returnObject(port);
				}
			}
		}    	
    }
    
    

    private ZESROUTINGDETAILSES10Response getRoutingDetailsResponse(Object request) {
    	ZESROUTINGDETAILSES10Service  service = null;
    	ZESROUTINGDETAILSES10PortType port =  null;
		long startTime=System.currentTimeMillis();
		long serviceTime=0;
		long portTime=0;
		long endTime=0;
		boolean toReturn = false;
		try {
			if(portPoolZESROUTINGDETAILSES10PortType!=null) { 
				port = portPoolZESROUTINGDETAILSES10PortType.borrowObject();
				portTime=System.currentTimeMillis();
			}
	        if(port ==null) {// no port in pool...
	        	service =getCachedZESROUTINGDETAILSES10Service();
	        	serviceTime=System.currentTimeMillis();
	        	port = service.getZESROUTINGDETAILSES10PortType();
	        	
	        	portTime=System.currentTimeMillis();   
	        }else {
	        	serviceTime=System.currentTimeMillis();
	        	portTime=System.currentTimeMillis();   
	        	toReturn = true;
	        }
	        setupPortProperties((BindingProvider) port);     
	        ZESROUTINGDETAILSES10Response response = port.zesROUTINGDETAILSES10((ZESROUTINGDETAILSES10) request);
	        
	        return response;
		}finally {
			endTime=System.currentTimeMillis();
			logTime("zesROUTINGDETAILSES10",startTime, serviceTime, portTime, endTime);
			if(toReturn) {
				if(portPoolZESROUTINGDETAILSES10PortType!=null)
					portPoolZESROUTINGDETAILSES10PortType.returnObject(port);
			}
		}      	
    	
    }












	

}


