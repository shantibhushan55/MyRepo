/**
 * 
 */
package com.hp.es.service.contractEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.TransactionComposition;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.Warnings;
import com.hp.sif.SifException;

/**
 * @author anvoi
 *
 */
public abstract class GenericContractTransactionComposition extends
		TransactionComposition {

	/**
	 * 
	 */
	protected GenericContractTransactionComposition() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.TransactionComposition#getComposedReply(java.util.ArrayList)
	 */
	public abstract EsReply getComposedReply(ArrayList replies, boolean includeWorkings) throws SifException;
	protected abstract void calculateReplyHeaderFields(EsReply finalReply);

	/*
	 * This method add warning to a reply.
	 * @param reply
	 * @return the final reply
	 */
	protected void addSystemNotAvailableWarning(String unavailableRegionList, EsReply finalReply) {
		//If there is any unavailibility issue.
		if(( unavailableRegionList!= null) && (unavailableRegionList.trim().length() >0)){
			if(finalReply.getEsHeader().getWarnings() == null) {
				ESLog.debug("A warning list is created");
				finalReply.getEsHeader().setWarnings(new Warnings());
			}
			
			finalReply.getEsHeader().getWarnings().addEIAError(ErrorFactory.getEIAError(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, unavailableRegionList));
			
		}

	}
	

	
	/*
	 * @raram the transaction list
	 * @return a new transaction list
	 */
	protected ArrayList getOnlyCQSTransaction(ArrayList trans) throws SifException {
		ArrayList transList = new ArrayList();

		Iterator it = trans.iterator();
		while(it.hasNext()) {
			Transaction tmp = (Transaction)it.next();
			if(tmp != null && tmp.getRegionDisplayName() != null && tmp.getRegionDisplayName().startsWith(EsConstants.CQS_SYSTEM_NAME)) {
				transList.add(tmp);
			}
		}
		

		
		
		return transList; 
	}

	
	/*
	 * @raram the transaction list
	 * @return a new transaction list
	 */
	protected ArrayList getOnlyODSTransaction(ArrayList trans) throws SifException {
		ArrayList transList = new ArrayList();

		Iterator it = trans.iterator();
		while(it.hasNext()) {
			Transaction tmp = (Transaction)it.next();
			if(tmp != null && tmp.getRegionDisplayName() != null && tmp.getRegionDisplayName().startsWith(EsConstants.ODS_SYSTEM_NAME)) {
				transList.add(tmp);
			}
		}
		return transList; 
	}
	/*
	 * This method compose the ODS ES reply
	 * @param the list of replies
	 * @return the EsReply which can be null
	 * @throws a SifException if appropriate
	 */	
	protected EsReply getODSEsReply(ArrayList replies)  throws SifException {
	    ESLog.debug("ENTER getODSEsReply().");
		Transaction tr = null;
		
		Iterator it = replies.iterator();
		while(it.hasNext()) {
			Transaction trTmp = (Transaction)it.next();
			if(ESLog.isDebugLogEnabled()) {
				if(trTmp!=null){
				    ESLog.debug("regionName=["+trTmp.getRegionDisplayName()+"]");
				}else {
				    
				    		ESLog.debug(" trTmp is null");
				}
			}	
			
			if(trTmp != null && EsConstants.ODS_SYSTEM_NAME.equalsIgnoreCase(trTmp.getRegionDisplayName())) {
				tr= trTmp;				
			}
		}
		if( tr != null) {
			if(tr.getMappedErrors() != null && tr.getMappedErrors().size() != 0) {
				throw ContractErrorsProcessing.getInstance().getHighestPriorityException(tr);
			}
			return tr.getMappedReply();
		}
		//we return null in that case
		return null;
	}
	
	/*
	 * This method compose the ODS ES reply
	 * @param the list of replies
	 * @return the EsReply which can be null
	 * @throws a SifException if appropriate
	 */	
	protected EsReply getODSCIEsReply(ArrayList replies)  throws SifException {
		Transaction tr = null;
		
		Iterator it = replies.iterator();
		while(it.hasNext()) {
			Transaction trTmp = (Transaction)it.next();
			if(trTmp != null && trTmp.getRegionDisplayName() != null && trTmp.getRegionDisplayName().equalsIgnoreCase(EsConstants.ODSCI_SYSTEM_NAME)) {
				tr= trTmp;				
			}
		}
		if( tr != null) {
			if(tr.getMappedErrors() != null && tr.getMappedErrors().size() != 0) {
				
			
				throw ContractErrorsProcessing.getInstance().getHighestPriorityException(tr);
			}
			return tr.getMappedReply();
		}
		//we return null in that case
		return null;
	}

}
