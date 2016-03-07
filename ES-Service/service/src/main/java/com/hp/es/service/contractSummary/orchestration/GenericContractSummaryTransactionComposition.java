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
 * @author yesilyur
 *
 */
public abstract class GenericContractSummaryTransactionComposition extends
		TransactionComposition{



	/**
	 * 
	 */
	protected GenericContractSummaryTransactionComposition() {
		super();
	}

	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.TransactionComposition#getComposedReply(java.util.ArrayList)
	 */
	public abstract EsReply getComposedReply(ArrayList replies, boolean includeWorkings) throws SifException;

	protected abstract void calculateReplyHeaderFields(EsReply finalReply);

	/*
	 * This method add warnings to a reply.
	 * @param reply
	 * @return the final reply
	 */
	protected void addWarning(String unavailableRegionList, EsReply finalReply) {
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
	 * This method compose the ODS ES reply
	 * @param the list of replies
	 * @return the EsReply which can be null
	 * @throws a SifException if appropriate
	 */	
	protected EsReply getODSEsReply(ArrayList replies)  throws SifException {
		Transaction tr = null;
		
		Iterator it = replies.iterator();
		while(it.hasNext()) {
			Transaction trTmp = (Transaction)it.next();
			if(trTmp != null && trTmp.getRegionDisplayName() != null && (trTmp.getRegionDisplayName().equalsIgnoreCase(EsConstants.ODS_SYSTEM_NAME) || trTmp.getRegionDisplayName().equalsIgnoreCase(EsConstants.ODSCI_SYSTEM_NAME))) {
				tr= trTmp;				
			}
		}
		if( tr != null) {
			if(tr.getMappedErrors() != null && tr.getMappedErrors().size() != 0) {
				
			
				throw ContractSummaryErrorsProcessing.getInstance().getHighestPriorityException(tr);
			}
			return tr.getMappedReply();
		}
		//we return null in that case
		return null;
	}
	
	
	
}
