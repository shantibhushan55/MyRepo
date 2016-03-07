/**
 * 
 */
package com.hp.es.service.contractEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTBYSNES10Response;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTES10Response;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMESSAGE;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.util.ESLog;

/**
 * @author ANVOI
 *
 */
public class ContractTransaction extends Transaction {
	

    // For Customer Indicator we need the reference of ObligationHeader to Location
	private HashMap<?, ?> oHeadLocMap = null;

	private String _sourceSystemStatus = null;
	private HashMap<?, ?> _standardizedProductHashMap;
	private EsReplyContext _ctx;
	/**
	 * @param config
	 * @param failoverMode
	 * @param sourceReply
	 * @param functionName
	 */
	public ContractTransaction(RegionConfiguration config, boolean failoverMode,
			Object sourceReply, String functionName, String displayName,boolean isLocal) {
		super(config, failoverMode, sourceReply, functionName, displayName,isLocal);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#isSourceSystemUnitList()
	 */
	public boolean isSourceSystemUnitList() {

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTES10Response) {
            return false;
        }else {
            ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
            
            return (out.getESREPLY().getUNITLIST() != null && 
                    out.getESREPLY().getUNITLIST().getPRODUCTS() != null && 
                    out.getESREPLY().getUNITLIST().getPRODUCTS().getItem() != null && 
                    out.getESREPLY().getUNITLIST().getPRODUCTS().getItem().size() != 0);
        }               
	
	}

	
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#getSourceSystemUnitList()
	 */
	public Object getSourceSystemUnitList() {
		//First we check if this is an error
        if(!isSourceSystemError()) {
        	//only sn can get unit list
	        

            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTBYSNES10Response)  {
                ZESCONTRACTENTBYSNES10Response  out  = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
                return out.getESREPLY().getUNITLIST();
            }else {
                return null;
            }
        }
	    return null;        
	}
  
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#isSourceSystemStandardReply()
	 */
	public boolean isSourceSystemStandardReply() {
        if(!isSourceSystemError()) {

            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTES10Response) {
                ZESCONTRACTENTES10Response out = (ZESCONTRACTENTES10Response) reply.getSoapCastorReply();
                return isSuccess(out.getESREPLY().getPROCSTATE());
            }else {
                ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
                return isSuccess(out.getESREPLY().getPROCSTATE());
            }
        }			
        return false;
	}
	

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#getSourceSystemStandardReply()
	 */
	public Object getSourceSystemStandardReply() {
            
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if (reply.getSoapCastorReply() instanceof  ZESCONTRACTENTES10Response) {
                
                ZESCONTRACTENTES10Response out = (ZESCONTRACTENTES10Response) reply.getSoapCastorReply();
                return out.getESREPLY();               
            }else {
                ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
                return out.getESREPLY();
            }

	}

	
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#isSourceSystemError()
	 */
	public boolean isSourceSystemError() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTES10Response) {
            ZESCONTRACTENTES10Response out = (ZESCONTRACTENTES10Response) reply.getSoapCastorReply();
            return !isSuccess(out.getESREPLY().getPROCSTATE());
        }else {
            ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
            return !isSuccess(out.getESREPLY().getPROCSTATE());
        }   
	}


	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#getSourceSystemError()
	 */
	public Collection<ZESCQSMESSAGE> getSourceSystemErrors() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTES10Response) {
            ZESCONTRACTENTES10Response out = (ZESCONTRACTENTES10Response) reply.getSoapCastorReply();
            
            return getOnlySourceSystemErrors(out.getESREPLY().getMESSAGES().getItem());
        }else {
            ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
            return getOnlySourceSystemErrors(out.getESREPLY().getMESSAGES().getItem());
        }   
	}

	/*
	 * Extract only the error out of the list of errors.
	 * The warning will be extracted later on
	 * The sucess messwage is discarded
	 * @param the Collection
	 * @return a new Collection
	 */
	private Collection<ZESCQSMESSAGE> getOnlySourceSystemErrors(Collection<?> messages) {
		ArrayList<ZESCQSMESSAGE> list = new ArrayList<ZESCQSMESSAGE>();
		Iterator<?> iterator = messages.iterator();
		while(iterator.hasNext()) {
			Object tmp = iterator.next();
                if(tmp instanceof ZESCQSMESSAGE) {
                    ZESCQSMESSAGE msg = (ZESCQSMESSAGE)tmp;
                    if(EsConstants.CQS_ERROR_PROCESS_STATE.equals(msg.getTYPE())) {
                        list.add(msg);
                    }
                }
		}			
		
		return list;
	}

	
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#isSourceSystemWarnings()
	 */
	public boolean isSourceSystemWarnings() {

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTES10Response) {
            ZESCONTRACTENTES10Response out = (ZESCONTRACTENTES10Response) reply.getSoapCastorReply();
            return isWarning(out.getESREPLY().getPROCSTATE());
        }else {
            ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
            return isWarning(out.getESREPLY().getPROCSTATE());
        }   
	}


	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.Transaction#getSourceSystemWarnings()
	 */
	public Collection<ZESCQSMESSAGE> getSourceSystemWarnings() {

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTENTES10Response) {
            ZESCONTRACTENTES10Response out = (ZESCONTRACTENTES10Response) reply.getSoapCastorReply();
            
            return getOnlySourceSystemWarnings(out.getESREPLY().getMESSAGES().getItem());
        }else {
            ZESCONTRACTENTBYSNES10Response out = (ZESCONTRACTENTBYSNES10Response) reply.getSoapCastorReply();
            return getOnlySourceSystemWarnings(out.getESREPLY().getMESSAGES().getItem());
        }   
	}

	/*
	 * Extract only the error out of the list of errors.
	 * The warning will be extracted later on
	 * The sucess messwage is discarded
	 * @param the Collection
	 * @return a new Collection
	 */
	private Collection<ZESCQSMESSAGE> getOnlySourceSystemWarnings(Collection<?> messages) {
		ArrayList<ZESCQSMESSAGE> list = new ArrayList<ZESCQSMESSAGE>();
		Iterator<?> iterator = messages.iterator();
		while(iterator.hasNext()) {
			Object tmp = iterator.next();
                if(tmp instanceof ZESCQSMESSAGE) {
                    ZESCQSMESSAGE msg = (ZESCQSMESSAGE) tmp;
                    if(EsConstants.CQS_WARNING_PROCESS_STATE.equals(msg.getTYPE())) {
                        list.add(msg);
                    }
                }   
		}
					
		return list;
	}

	/*
	 * @param Process state (empty,w,e)
	 * @retun a boolean
	 */
	private boolean isSuccess(String proc_state) {
		if(proc_state == null) {
			return true;
		}
		if(proc_state.equalsIgnoreCase(EsConstants.CQS_EMPTY_PROCESS_STATE)) {
			return true;
		}

		if(proc_state.equalsIgnoreCase(EsConstants.CQS_SUCCESS_PROCESS_STATE)) {
			return true;
		}
		
		if(proc_state.equalsIgnoreCase(EsConstants.CQS_WARNING_PROCESS_STATE)) {
			return true;
		}
		
		if(proc_state.equalsIgnoreCase(EsConstants.CQS_ERROR_PROCESS_STATE)) {
			return false;
		}				
			
		return false;
	}

	
	/*
	 * Tell if the process state is a  warning.
	 */
	private boolean isWarning(String proc_state) {
		// a Warning is a success.
		if(proc_state != null) {
			if(proc_state.equalsIgnoreCase(EsConstants.CQS_WARNING_PROCESS_STATE)) {
				return true;
			}
		}
			
		return false;
	}

	/*
	 * get Source system status
	 */	
	public String getSourceSystemStatus() {
        if(_sourceSystemStatus != null) {
        	return _sourceSystemStatus;
        }else if(isSourceSystemUnavailable()) {
        	return "Unavailable";
        	
		}else if(getMappedErrors() != null && getMappedErrors().size() >0) {

        	return "Error";
        	
        }else {
        	if(getMappedReply() != null && getMappedReply().getEsReplyChoice().getUnitList() != null) {
        		return "Unit List";
        	}else {
        		return "Success";
        	}
        }
	}
	/*
	 * This is used by the ODS
	 */
	public void setODSSucessStatus() {
		_sourceSystemStatus = "success";
	}	
	
	/*
	 * store the standard product hash map 
	 * if we add it
	 */
	public void setStandardizedProductHashMap(HashMap<?, ?> map) {
		_standardizedProductHashMap = map;
	}
	
	/*
	 * store the standard product hash map 
	 * if we add it
	 */
	public HashMap<?, ?> getStandardizedProductHashMap() {
		return _standardizedProductHashMap;
	}

	public void setReplyContext(EsReplyContext ctx) {
		_ctx= ctx;
		
	}	
	
	public EsReplyContext getReplyContext() {
		return _ctx;
		
	}	

	public HashMap<?, ?> getOHeadLocMap() {
		return oHeadLocMap;
	}

	public void setOHeadLocMap(HashMap<?, ?> headLocMap) {
		oHeadLocMap = headLocMap;
	}

	@Override
	public void destroy() {
		
		
		super.destroy();
		ESLog.debug("Destroy all, we finished using Context");
		if(oHeadLocMap != null) {
			oHeadLocMap.clear();
		}
		oHeadLocMap = null;
		
		if(_standardizedProductHashMap != null) {
			_standardizedProductHashMap.clear();
		}

		_standardizedProductHashMap = null;
		_sourceSystemStatus = null;

	}	
}

//eof