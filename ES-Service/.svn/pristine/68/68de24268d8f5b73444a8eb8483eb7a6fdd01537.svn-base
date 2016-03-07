package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;

import com.hp.es.service.orchestration.ErrorsProcessing;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

/*
 * This class represents warranty error priority processing.
 * It encapsulates any rule to manipulates SifExecption related to warranty processing
 */
class WarrantyErrorsProcessing extends ErrorsProcessing {
	private final static int PRIORITY_1_ID_VALUE= 1;
	private final static int PRIORITY_1_ID = 214;
	private final static int PRIORITY_1_NID = 214;
	private final static int PRIORITY_2_ID_VALUE= 2;
	private final static int PRIORITY_2_ID= 200;
	private final static int PRIORITY_2_NID=200;
	private final static int PRIORITY_3_ID_VALUE= 3;
	private final static int PRIORITY_3_ID= 201;
	private final static int PRIORITY_3_NID= 201;
	private final static int PRIORITY_4_ID_VALUE= 4;
	private final static int PRIORITY_4_ID= 202;
	private final static int PRIORITY_4_NID= 232;
	private final static int PRIORITY_5_ID_VALUE= 5;
	private final static int PRIORITY_5_ID= 212;
	private final static int PRIORITY_5_NID= 233;
	private final static int PRIORITY_6_ID_VALUE= 6;
	private final static int PRIORITY_6_ID= 210;
	private final static int PRIORITY_6_NID= 234;
	private final static int PRIORITY_7_ID_VALUE= 7;
	private final static int PRIORITY_7_ID= 213;
	private final static int PRIORITY_7_NID= 235;
	private final static int PRIORITY_8_ID_VALUE= 8;
	private final static int PRIORITY_8_ID= 300;
	private final static int PRIORITY_8_NID= 301;
	private final static int PRIORITY_9_ID_VALUE= 9;
	private final static int PRIORITY_9_ID= 224;
	private final static int PRIORITY_9_NID= 224;  	
	
	
		
	private static WarrantyErrorsProcessing _instance = new WarrantyErrorsProcessing();
	protected WarrantyErrorsProcessing() {
		super();
	}

	/*
	 * Get the instance
	 * @return the singleton
	 */
	static WarrantyErrorsProcessing getInstance() {
		// Get a singleton instance

		return _instance;
	}



	/*
	 * 
	 */
	protected SifException getRedefinedSifException(SifException composedException, ArrayList replies) throws SifException {
		int refinedId = 0;
		int composedId = 0;
		SifException refinedException = composedException;
		
		try {
			composedId =Integer.valueOf(composedException.getErrorID()).intValue();
		}catch (NumberFormatException nfe) {
			ESLog.debug("Incorrect SifException error Id " + composedException.getErrorID());
			composedId = -1;
		}		
		

		refinedId = getRefinedIdForSifException(composedId);
		//In that case we may need to have a list of down region
		//We need to get the string concanetion of the region that were down or unavailable
		String unaivalableRegionList="";
		unaivalableRegionList = getUnavailableRegionList(replies);
		if((composedId != refinedId)  && (unaivalableRegionList.trim().length() != 0)){
				refinedException = ErrorFactory.getSifException(refinedId,unaivalableRegionList);
		}
		return refinedException;
	}


	/*
	 * We will assign a priority to the SifException
	 */
	protected int getPriorityForSifException(SifException e) {
		ESLog.debug("Enter");
		int priority = MAX_PRIORITY;
		int errorId;
		try {
			errorId =Integer.valueOf(e.getErrorID()).intValue();
		} catch (NumberFormatException nfe) {
			ESLog.debug("Incorrect SifException error Id " + e.getErrorID());
			errorId = -1;
		}
		
		if(errorId == PRIORITY_1_ID) {
			priority = PRIORITY_1_ID_VALUE;
		}else if(errorId == PRIORITY_2_ID){
			priority = PRIORITY_2_ID_VALUE;
		}else if(errorId == PRIORITY_3_ID){
			priority = PRIORITY_3_ID_VALUE;
		}else if(errorId == PRIORITY_4_ID){
			priority = PRIORITY_4_ID_VALUE;
		}else if(errorId == PRIORITY_5_ID){
			priority = PRIORITY_5_ID_VALUE;
		}else if(errorId == PRIORITY_6_ID){
			priority = PRIORITY_6_ID_VALUE;
		}else if(errorId == PRIORITY_7_ID){
			priority = PRIORITY_7_ID_VALUE;
		}else if(errorId == PRIORITY_8_ID){
			priority = PRIORITY_8_ID_VALUE;
		}else if(errorId == PRIORITY_9_ID){
			priority = PRIORITY_9_ID_VALUE;
		}
		ESLog.debug("Exit - The priority is: " + priority);
		return priority;
	}
	
	/*
	 * We will assign a priority to the SifException
	 */
	private int getRefinedIdForSifException(int  errorId) {
		ESLog.debug("Enter");

		int refinedId = errorId;
		
		if(errorId == PRIORITY_1_ID) {
			refinedId = PRIORITY_1_NID;
		}else if(errorId == PRIORITY_2_ID){
			refinedId = PRIORITY_2_NID;
		}else if(errorId == PRIORITY_3_ID){
			refinedId = PRIORITY_3_NID;
		}else if(errorId == PRIORITY_4_ID){
			refinedId = PRIORITY_4_NID;
		}else if(errorId == PRIORITY_5_ID){
			refinedId = PRIORITY_5_NID;
		}else if(errorId == PRIORITY_6_ID){
			refinedId = PRIORITY_6_NID;
		}else if(errorId == PRIORITY_7_ID){
			refinedId = PRIORITY_7_NID;
		}else if(errorId == PRIORITY_8_ID){
			refinedId = PRIORITY_8_NID;
		}else if(errorId == PRIORITY_9_ID){
			refinedId = PRIORITY_9_NID;
		}
		
		ESLog.debug("Exit - The RefinedId is: " + refinedId);
		return refinedId;
	}


	
}
