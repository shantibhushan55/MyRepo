/**
 * 
 */
package com.hp.es.service.unitEventHistory.integration.mapping;

import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.UnitEventHistoryComplexType;

/**
 * @author ANVOI
 *
 */
public abstract class  UnitEventHistoryComplexTypeMapper {

	protected UnitEventHistoryTransaction _transaction;

	/**
	 * 
	 */
	protected UnitEventHistoryComplexTypeMapper() {
	}

	protected UnitEventHistoryComplexTypeMapper(UnitEventHistoryTransaction transaction) {
		_transaction = transaction;
	}
	
	public static UnitEventHistoryComplexTypeMapper getInstance(
			UnitEventHistoryTransaction transaction) {
		/*
		 * The Metro implementation is to only mapper implementation
		 * for the UnitEventHistoryComplexType.
		 */ 
		return new MetroUnitEventHistoryComplexTypeMapper(transaction);
	}

	public UnitEventHistoryComplexType map() throws MappingException {
		
		/*
		 * Map 
		 * UnitEventHistoryComplexType
		 * then create list of UnitEvent
		 * then in UnitEvent create list of EventDetails
		 * in EventDetails, we'll have extra structure, documented in the mapper itself
		 */
		UnitEventHistoryComplexType uehCt= mapUnitEventHistoryComplexType();
		 
		uehCt = mapUnitEvent(uehCt);
		return uehCt;
	}

	protected abstract UnitEventHistoryComplexType mapUnitEventHistoryComplexType() throws MappingException;

	private UnitEventHistoryComplexType mapUnitEvent(
			UnitEventHistoryComplexType uehCt) throws MappingException {
				
		return uehCt;
	}

}
