/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.contractSummary.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSMESSAGE;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;


/**
 * @author yesilyur
 *
 */
public class ContractSummaryTransaction extends Transaction{


	private String _sourceSystemStatus = null;
	/**
	 * 
	 */
	/**
	 * @param config
	 * @param failoverMode
	 * @param sourceReply
	 * @param functionName
	 */
	public ContractSummaryTransaction(RegionConfiguration config, boolean failoverMode,
			Object sourceReply, String functionName, String displayName,boolean isLocal) {
		super(config, failoverMode, sourceReply, functionName, displayName,isLocal);
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

	
	public Collection getSourceSystemErrors() {

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTSUMES10Response) {
            ZESCONTRACTSUMES10Response out = (ZESCONTRACTSUMES10Response) reply.getSoapCastorReply();
            if(out.getMESSAGES()!=null){
                return getOnlySourceSystemErrors(out.getMESSAGES().getItem());                    
            }else{
                return getOnlySourceSystemErrors(null);
            }
        }   
        return null;
	}

	public Object getSourceSystemStandardReply() {

            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if (reply.getSoapCastorReply() instanceof  ZESCONTRACTSUMES10Response) {
                ZESCONTRACTSUMES10Response out = (ZESCONTRACTSUMES10Response) reply.getSoapCastorReply();
                return out;             
            }
		return null;
	}

	public Object getSourceSystemUnitList() {
		
		return null;
	}

	public Collection getSourceSystemWarnings() {
	    SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
	    if(reply.getSoapCastorReply() instanceof ZESCONTRACTSUMES10Response) {
	        ZESCONTRACTSUMES10Response out = (ZESCONTRACTSUMES10Response) reply.getSoapCastorReply();     
	        if(out.getMESSAGES()!=null) {
	            return getOnlySourceSystemWarnings(out.getMESSAGES().getItem());                    
	        }else{
	            return getOnlySourceSystemWarnings(null);
	        }
	    }
		return null;
	}

	public boolean isSourceSystemError() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTSUMES10Response) {
            ZESCONTRACTSUMES10Response out = (ZESCONTRACTSUMES10Response) reply.getSoapCastorReply();
            return !isSuccess(out.getPROCSTATE());
        }   
        return true;		
	}

	
	public boolean isSourceSystemStandardReply() {

        if (!isSourceSystemError()) {
                SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
                if (reply.getSoapCastorReply() instanceof ZESCONTRACTSUMES10Response) {
                    ZESCONTRACTSUMES10Response out = (ZESCONTRACTSUMES10Response) reply.getSoapCastorReply();
                    return isSuccess(out.getPROCSTATE());
                }
        }
        
        return false;
	}

	
	public boolean isSourceSystemUnitList() {
		
		return false;
	}

	
	public boolean isSourceSystemWarnings() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if(reply.getSoapCastorReply() instanceof ZESCONTRACTSUMES10Response) {
            ZESCONTRACTSUMES10Response out = (ZESCONTRACTSUMES10Response) reply.getSoapCastorReply();
            return isWarning(out.getPROCSTATE());
        }
		return false;
	}


	/*
	 * Extract only the error out of the list of errors.
	 * The warning will be extracted later on
	 * The sucess messwage is discarded
	 * @param the Collection
	 * @return a new Collection
	 */
	private Collection getOnlySourceSystemWarnings(Collection messages) {
		ArrayList list = new ArrayList();
        if (messages == null)
            return list;
		Iterator iterator = messages.iterator();
		while(iterator.hasNext()) {
			Object tmp = iterator.next();
                if(tmp instanceof ZESCQSMESSAGE) {
                    ZESCQSMESSAGE msg = (ZESCQSMESSAGE) tmp;

                    if(msg.getTYPE() != null) {
                        if(msg.getTYPE().equals(EsConstants.CQS_WARNING_PROCESS_STATE)) {
                            list.add(msg);
                        }
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
	 * Extract only the error out of the list of errors.
	 * The warning will be extracted later on
	 * The sucess messwage is discarded
	 * @param the Collection
	 * @return a new Collection
	 */
	private Collection getOnlySourceSystemErrors(Collection messages) {
		ArrayList list = new ArrayList();
        if (messages == null)
            return list;
		Iterator iterator = messages.iterator();
		while(iterator.hasNext()) {
			Object tmp = iterator.next();
            if(tmp instanceof ZESCQSMESSAGE) {
                ZESCQSMESSAGE msg = (ZESCQSMESSAGE)tmp;
                if(msg.getTYPE() != null) {
                    if(msg.getTYPE().equals(EsConstants.CQS_ERROR_PROCESS_STATE)) {
                        list.add(msg);
                    }
                }
            }
			
		}
		
		return list;
	}

	/*
	 * This is used by the ODS
	 */
	public void setODSSucessStatus() {
		_sourceSystemStatus = "success";
	}

	@Override
	public void destroy() {
		
		super.destroy();
		
	}	

}
