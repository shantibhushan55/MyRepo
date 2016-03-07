package com.hp.es.service.unitEventHistory.orchestration;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.sif.SifException;

public class UnitEventHistoryTransactionComposition {

	private static UnitEventHistoryTransactionComposition _instance = new UnitEventHistoryTransactionComposition();

	/*
	 * Get the instance
	 * @return the singleton
	 */
	static UnitEventHistoryTransactionComposition getInstance() {
		// Get a singleton instance
		return _instance;
	}	

	/*
	 * 
	 * The 3 responses returned by the UE instances are composed  
	 * Each individual UE response is in canonical format 
	 * (the transformation is performed by the SWOP warranty interface)
	 * We need to find the one that is a real reply 
	 * @param the list of reply
	 * @return a composed  reply
	 * @throws a SifException if not correctly used
	 *  
	 */
	public EsReply getReplyWithUnitEventHistory(ArrayList replies) throws SifException {
		EsReply composedReply = null;
		
		return this.findUnitEventHistory(replies);
	}



	/*
	 * This method count the number of warranty reply in the reply array
	 * @param the reply array
	 * @return the number of warranty reply
	 */
	private EsReply findUnitEventHistory(ArrayList replies) throws SifException {
		int nbUnitEventHistoryReply = 0;
		ESLog.debug("begin");
		if(replies != null ) {
			Iterator it = replies.iterator();
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if((tr != null) && (tr.getMappedReply() != null)) {
					EsReply currObj = (EsReply) tr.getMappedReply();
					if(currObj.getEsReplyChoice() != null) {
						if((currObj.getEsReplyChoice().getUnitEventHistory() != null) ) {
							return currObj;
						}
					}
					
				}
				
				
			}
		}
		ESLog.debug("end we found "+ nbUnitEventHistoryReply +" UNIT EVENT HISTORY replies");
		ESLog.debug("The replies array is not correct");
		throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"No reply to compose");
	}
	
	
	
}
