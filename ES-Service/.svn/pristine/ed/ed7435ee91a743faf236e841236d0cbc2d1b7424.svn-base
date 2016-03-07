package com.hp.es.service.ibSearch.integration.mapping;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.InstalledBaseUnitListComplexType;
import com.hp.sif.SifException;

public class MetroUnitListMapper extends UnitListMapper {

	public MetroUnitListMapper(IBSearchTransaction transaction) {
		super(transaction);
	}

	public InstalledBaseUnitListComplexType map() throws MappingException,
			SifException {
    	ESLog.debug("Enter unit list mapping");
    	InstalledBaseUnitListComplexType ibUnitList = new InstalledBaseUnitListComplexType();
    	// OOS
    	OosMapper  om = new MetroOosMapper(_transaction, _XMLIdGenerator);
    	ibUnitList.setOOS(om.map());
        return ibUnitList;
	}

}
