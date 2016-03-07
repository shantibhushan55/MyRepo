package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.xml.service.WorkingComplexType;

/*
 * This class is mapping working for CQS or ODS
 */
public final class WorkingMapper {

	protected String _sourceSystemStatus;
	protected String _regionDisplayName;

	public WorkingMapper(String sourceSystemStatus, String regionDisplayName) {
		super();
		_sourceSystemStatus = sourceSystemStatus;
		_regionDisplayName = regionDisplayName;
	}

	public WorkingComplexType map() {
		WorkingComplexType working = new WorkingComplexType();
		working.setWorkingName(_regionDisplayName);
		working.setWorkingValue(_sourceSystemStatus);
		return working;
	}
	
	
	
	
	
	
	
	

}
