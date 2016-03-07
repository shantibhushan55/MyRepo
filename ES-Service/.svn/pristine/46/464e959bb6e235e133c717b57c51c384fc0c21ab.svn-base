/**
 * 
 */
package com.hp.es.service.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.hp.es.service.contractEntitlement.integration.mapping.WorkingMapper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public abstract class ErrorsProcessing {

	// A dummy max priority
	protected final static int MAX_PRIORITY = 100;
	
	/**
	 * 
	 */
	protected ErrorsProcessing() {
		super();
		
	}
	
	/*
	 * Get the priority for a SIF exception
	 * @param the exeption
	 * @return the priority
	 */
	protected abstract int getPriorityForSifException(SifException ex);

	/*
	 * Refine an exception
	 * @param the exeption
	 * @param the list of transaction
	 * @return the new SifException
	 */	
	protected abstract SifException getRedefinedSifException(SifException ex,ArrayList replies) throws SifException;
	

	/*
	 * Return the list of region that were not available.
	 * @param the list of orchestration reply
	 * @return the list
	 */	
	public String getUnavailableRegionList(ArrayList replies) throws SifException {
		StringBuffer sb = new StringBuffer();
		SortedSet s = new TreeSet();
		

		if(replies != null) {
			Iterator it = replies.iterator();
			
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if((tr != null)&&(tr.isUnavailable())) {
					s.add(tr.getRegionDisplayName());
				}
			}
			
			Iterator it2 = s.iterator();
			while(it2.hasNext()) {
				String str = (String)it2.next();
				if(sb.length() != 0) {
					sb.append(", ");
				}
				sb.append(str);
				
			}			
		}
		ESLog.debug("List of unavailable region is "+sb.toString());
		return sb.toString();
	}	
	
	/*
	 * Return the list of region that were not available.
	 * @param the list of orchestration reply
	 * @return the list
	 */	
	public WorkingComplexType getErrorWorking(Transaction errTrans) throws SifException {
		WorkingMapper errorWork = null;
		
		
		if(errTrans != null) {
			if(errTrans.isUnavailable()) {
				errorWork = new WorkingMapper("Unavailable",errTrans.getRegionDisplayName());
			}else { 
				SifException ex = getHighestPriorityException(errTrans);
				errorWork = new WorkingMapper(ex.getErrorText(),errTrans.getRegionDisplayName());
			}
			return errorWork.map();
		}
		
		return null;
		
	}	
	/*
	 * Count the number of throwabme in the orchestration reply
	 * @param the list of orchestration reply
	 * @return the number
	 */
	public int countSifException(ArrayList replies) throws SifException {
		int cptSifException= 0;
		if(replies != null) {
			Iterator it = replies.iterator();
			while (it.hasNext()){
				Transaction reply = (Transaction)it.next();
				if((reply != null) && (reply.getMappedErrors() != null)) {
					if(reply.getMappedErrors().size() != 0) {
						cptSifException++;
					}
				}
			}
		}
		ESLog.debug("Count " + cptSifException + " SifException");
		return cptSifException;
	}	
	
	/*
	 * This gets the highest priority error from the list 
	 * @param the list of trans
	 * @return a sif exception
	 */
	public SifException getHighestPriorityException(ArrayList replies) throws SifException {
		ESLog.debug("Checking highest priority with an ArrayList of replies");			
		// We are assuming that we only have sifException in the array as it was checked before.
		SifException composedException = null;
		Transaction  maxPriorityTr     = null;
		
		int minPriorityValue = MAX_PRIORITY;
		if(replies == null || replies.size() == 0 ) {
			ESLog.debug("The ArrayList replies is null or empty -> Throw an 9999 exception");			
			composedException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Replies list is empty");
		} else {
			// If all Transactions are not available
			//Then we return a not available.
			if(countNotAvailable(replies) == replies.size()) {
				return ErrorFactory.getSifException(ErrorFactory.id224_ALL_SOURCE_SYSTEMS_TIMED_OUT,getUnavailableRegionList(replies));
			}
			
			Iterator it = replies.iterator();
			
			while(it.hasNext()){
				Transaction trTmp = (Transaction)it.next();
				//In case a SWOP System Not Available error is returned and the other errors are NoDataFound or MissingDataContent error
				if(trTmp != null) {
					SifException currentObj = getHighestPriorityException(trTmp.getMappedErrors());
					int currentPrio = getPriorityForSifException(currentObj);
					ESLog.debug("CurrentPriority: " + currentPrio);			
					ESLog.debug("minPriorityValue: " + minPriorityValue);			
					// check for lower or equal priority. We also look for the same priority, 
					// in case of both having the default priority "MAX_PRIORITY" we would not get any exception.
					if(currentPrio <= minPriorityValue) {
						minPriorityValue = currentPrio;
						maxPriorityTr = trTmp;
					}
				}
			}
			
			//We should assume that the execption
			if( maxPriorityTr != null) {
				composedException = getHighestPriorityException(maxPriorityTr.getMappedErrors());
			} else {
				// Either no error or all system unavailable
				ESLog.debug("Either no error or all system unavailable -> Throw an 9999 exception");			
				composedException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Replies list is empty");
			}
			
			//if this is a are NoDataFound or MissingDataContent error
			composedException = getRedefinedSifException(composedException,replies);
		}
		ESLog.debug("Exit (ArrayList of replies)");			
		return composedException;
	}	
	
	/*
	 * Count the number of not available errors
	 * @return the number of them
	 */
	private int countNotAvailable(ArrayList replies) {
		Iterator it = replies.iterator();
		int i = 0;
		while(it.hasNext()) {
			Transaction t = (Transaction)it.next();
			if(t.isSourceSystemUnavailable()) {
				i++;
			}
		}
		return i;
	}

	/*
	 * This gets the highest priority error from the list 
	 * @param the list of trans
	 * @return a sif exception
	 */
	protected SifException getHighestPriorityException(Collection listException) {
		ESLog.debug("Checking highest priority with a collection of exceptions");			
		// We are assuming that we only have sifException in the array as it was checked before.
		SifException composedException = null;
		int minPriorityValue = MAX_PRIORITY;
				
		if(listException == null || listException.isEmpty()) {
			ESLog.debug("The Collection of exceptions is empty -> Throw an 9999 exception");			
			composedException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Replies list is empty");
		} else {
			Iterator itEx = listException.iterator();
			
			while(itEx.hasNext()) {
				SifException ex = (SifException)itEx.next();
				int currentPrio = getPriorityForSifException(ex);
				ESLog.debug("CurrentPriority: " + currentPrio);			
				ESLog.debug("minPriorityValue: " + minPriorityValue);			
				// check for lower or equal priority. We also look for the same priority, 
				// in case of both having the default priority "MAX_PRIORITY" we would not get any exception.
				if(currentPrio <= minPriorityValue) {
					minPriorityValue = currentPrio;
					composedException = ex;
				}
			}
			
			//We should assume that the execption
			if( composedException == null) {
				ESLog.debug("The composedException is null -> Throw an 9999 exception");			
				composedException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Replies list is empty");
			}
		}
		ESLog.debug("Exit (collection of exceptions)");			
		return composedException;
	}		

	
	/*
	 * This gets the highest priority error from the list 
	 * @param the list of trans
	 * @return a sif exception
	 */
	public SifException getHighestPriorityException(Transaction t) {
		ESLog.debug("Checking highest priority with a transaction");
		SifException e = null;
		if(t.isUnavailable()) {
			ESLog.debug("The system was unavailable -> Throw a timeout exception");			
			e = ErrorFactory.getSifException(ErrorFactory.id224_ALL_SOURCE_SYSTEMS_TIMED_OUT,t.getRegionDisplayName());
		} else {
			e = getHighestPriorityException(t.getMappedErrors());
		}
		ESLog.debug("Exit (transaction)");
		return e;
	}
}
