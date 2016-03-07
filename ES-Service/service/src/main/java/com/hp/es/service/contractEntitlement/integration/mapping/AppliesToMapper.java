/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.xml.service.OOSComplexType;

/**
 * @author anvoi
 *
 */
abstract class AppliesToMapper {

	protected Object _appl;
	protected Map _oosMapbyOOSKey;
	protected Map _oosKeyListMapbyOOSGroupId;
	protected EsReplyContext _ctx;
	protected static final String OOS_TYPE = "OOS";

	/**
	 * @param oosMap 
	 * @param _generator 
	 * @param appl 
	 * 
	 */
	AppliesToMapper(Object appl, XMLIdGenerator _generator, Map oosMapbyOOSKey, Map oosKeyListMapbyOOSGroupId, EsReplyContext ctx) {
		super();
		_appl=appl;
		_oosMapbyOOSKey = oosMapbyOOSKey;
		_oosKeyListMapbyOOSGroupId = oosKeyListMapbyOOSGroupId;
		_ctx = ctx;
	}

	/*
	 * Mapping applies to
	 */
	abstract Collection map(String sourceObligationId, String item);

	protected final AbstractList getOOSKeyListForOOSGroupId(String object_ref_key) {
		return (ArrayList) _oosKeyListMapbyOOSGroupId.get(object_ref_key);
	}


	/*
	 * Get an OOSComplexType from the list of OOS by oos key
	 */
	protected final OOSComplexType getOOS(String object_ref_key) {
		return (OOSComplexType)_oosMapbyOOSKey.get(object_ref_key);
	}


}
