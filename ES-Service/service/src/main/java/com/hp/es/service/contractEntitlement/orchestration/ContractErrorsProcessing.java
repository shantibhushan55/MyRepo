/**
 * 
 */
package com.hp.es.service.contractEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.service.orchestration.ErrorsProcessing;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
class ContractErrorsProcessing extends ErrorsProcessing {
	
	
	private final static int PRIORITY_1_ID_VALUE= 1;
	private final static int PRIORITY_1_ID = 200;
	private final static int PRIORITY_1_NID = 200;
	private final static int PRIORITY_2_ID_VALUE= 2;
	private final static int PRIORITY_2_ID= 201;
	private final static int PRIORITY_2_NID=236;
	private final static int PRIORITY_3_ID_VALUE= 3;
	private final static int PRIORITY_3_ID= 300;
	private final static int PRIORITY_3_NID= 236;

	private final static String PRODUCT_SHIPTO_LOCATION_MISSING_ERROR ="237";

	private static ContractErrorsProcessing _instance = new ContractErrorsProcessing();;
	
	
	
	/**
	 * 
	 */
	private ContractErrorsProcessing() {
		super();
	}

	public static ContractErrorsProcessing getInstance() {
		// Get a singleton instance
		// In this context this is in order to use static method everywhere
		return _instance;
	}

	
	/*
	 *  (non-Javadoc)
	 * @see com.hp.es.service.orchestration.ErrorsProcessing#getPriorityForSifException(com.hp.sif.SifException)
	 */
	protected int getPriorityForSifException(SifException ex) {
		int priority = MAX_PRIORITY;
		int errorId;
		try {
			errorId =Integer.valueOf(ex.getErrorID()).intValue();
		}catch (NumberFormatException nfe) {
			ESLog.debug("Incorrect SifException error Id " + ex.getErrorID());
			errorId = -1;
		}
		
		if(errorId == PRIORITY_1_ID) {
			priority = PRIORITY_1_ID_VALUE;
		}else if(errorId == PRIORITY_2_ID){
			priority = PRIORITY_2_ID_VALUE;
		}else if(errorId == PRIORITY_3_ID){
			priority = PRIORITY_3_ID_VALUE;
		}
		
		return priority;

	}

	/*
	 *  (non-Javadoc)
	 * @see com.hp.es.service.orchestration.ErrorsProcessing#getRedefinedSifException(com.hp.sif.SifException, com.hp.es.service.orchestration.Transaction[])
	 */
	protected SifException getRedefinedSifException(SifException composedException, ArrayList list) throws SifException {
		int refinedId = 0;
		int composedId = 0;
		SifException refinedException = composedException;
		String unaivalableRegionList="";
		String listNoShipToerrors= "";		
		unaivalableRegionList = getUnavailableRegionList(list);
		listNoShipToerrors    = getListNoShipToerrors(list);
		
		if( (unaivalableRegionList != null && unaivalableRegionList.trim().length()> 0) ||
				(listNoShipToerrors != null && listNoShipToerrors.trim().length()> 0)) { 
			try {
				composedId =Integer.valueOf(composedException.getErrorID()).intValue();
			}catch (NumberFormatException nfe) {
				ESLog.debug("Incorrect SifException error Id " + composedException.getErrorID());
				composedId = -1;
			}		
			
	
			refinedId = getRefinedIdForSifException(composedId);
			//In that case we may need to have a list of down region
			//We need to get the string concanetion of the region that were down or unavailable
	
	
			if((composedId != refinedId)  && (
					(unaivalableRegionList.trim().length() != 0)||
					(listNoShipToerrors.trim().length() != 0))){
					String concat ="";
					if(!unaivalableRegionList.equals("")) {
						concat = unaivalableRegionList ;
						if(listNoShipToerrors.trim().length()>0)
							concat += ", " +listNoShipToerrors;
					}else {
						concat = listNoShipToerrors;
					}
					refinedException = ErrorFactory.getSifException(refinedId,concat);
			}
			
		}
		return refinedException;

	}
	
	/*
	 * Returns a concatenation of all
	 * ProductShiptoLocation missing Error (237)
	 * @param the list of trans
	 * @return a concatenated string
	 */
	private String getListNoShipToerrors(ArrayList list) throws SifException {
		StringBuffer concatenated = new StringBuffer("");
		
		if(list != null) {
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if(tr != null) {
					SifException tmpEx = getHighestPriorityException(tr.getMappedErrors());
					if(tmpEx.getErrorID().equals(PRODUCT_SHIPTO_LOCATION_MISSING_ERROR)) {
						if(concatenated.length() != 0) {
							concatenated.append(", ");
						}
						concatenated.append(tmpEx.getDataPayLoad());
					}
				}
				
			}
		}
		ESLog.debug("List of PRODUCT_SHIPTO_LOCATION_MISSING_ERROR is "+concatenated.toString());
				
		
		return concatenated.toString();
	}

	/*
	 * We will get the refined ID
	 */
	private int getRefinedIdForSifException(int  errorId) {
		int refinedId = errorId;
		if(errorId == PRIORITY_1_ID) {
			refinedId = PRIORITY_1_NID;
		}else if(errorId == PRIORITY_2_ID){
			refinedId = PRIORITY_2_NID;
		}else if(errorId == PRIORITY_3_ID){
			refinedId = PRIORITY_3_NID;
		}
		
		return refinedId;
		
		
	}		

}//EOF
