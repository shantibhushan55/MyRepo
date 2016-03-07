/*
 * Created on Jun 12, 2006
 */
package com.hp.es.service.warrantyEntitlement.orchestration;

import com.hp.es.xml.service.WarrantyRequest;

/**
 * @author JUHANK
 *
 */
public class WarrantyRoutingInformation {

	public static final int INVALID_ROUTING = -1;
	public static final int SINGLE_INSTANCE_ROUTING = 1;
	public static final int MULTIPLE_INSTANCE_ROUTING = 2;
	
	private WarrantyRoutingInformation() {
		super();
		// not needed
	}
	
	/*
	 * This method determines the routing based on the request
	 * It is assumed that the request is cleaned up
	 * SRS says:
	 *    SN available => MULTIPLE_INSTANCE_ROUTING
	 *    SN missing   => SINGLE_INSTANCE_ROUTING
	 */
	public static int determineWarrantyRouting(WarrantyRequest request) {
		
		// SN tag available and not empty
		if(request.getSerialNumber() != null && request.getSerialNumber().trim().length() > 0 ) {
			return MULTIPLE_INSTANCE_ROUTING;
		}
		
		// SN tag available and but empty
		if(request.getSerialNumber() != null && request.getSerialNumber().trim().length() == 0 ) {
			return SINGLE_INSTANCE_ROUTING;
		}

		// SN == null
		if(request.getSerialNumber() == null) {
			return SINGLE_INSTANCE_ROUTING;
		}
		
		// If we reach here we have an invalid request => invalid routing
		return INVALID_ROUTING;
	}
}

