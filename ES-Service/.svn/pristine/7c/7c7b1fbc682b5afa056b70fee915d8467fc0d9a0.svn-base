/*
 * Created on Mar 14, 2006
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMESSAGE;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * 101	Incorrect Contract Identifier Type provided => 201
 * 102	Incorrect Check Date provided - Allowed range: -90 days/+1day around current date => 201
 * 103	Mandatory Serial Number has not  been provided	=> 200
 * 104	Mandatory Contract Identifier has not  been provided => 200
 * 105	Invalid ISO Country Code provided	=> 201
 * 106	Invalid MaxOOSesNo provided. Allowed range: 0 - 9999, or empty for no limitation => 201
 * 108	Mandatory Service Agreement ID  has not  been provided	=> 201
 * 201	No entries found	=> 300
 * 202	Found Contract XXXXX  is invalid - No ISO Country Code for ProductShipTo Location exists => 237
 * 899	Internal error - Any unanticipated error occurred during the processing of the request	=> 434
 */
class MetroErrorMapper  extends ErrorMapper{




    protected MetroErrorMapper(Collection<?> cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {
    	super(cqsErrors, request, sapRegionDisplayName);
    }




    /**
     * map
     * @return
     * @throws MappingException
     */
    public ArrayList<SifException> map() throws MappingException {
    	if(_cqsErrors == null) {
    		return null;
    	}

     	ESLog.debug("Mapping errors ...");
     	ArrayList<SifException> eiaErrors = new ArrayList<SifException>();

    	Iterator<?> iterator = _cqsErrors.iterator();
    	while(iterator.hasNext()) {
    		SifException se = mapError((ZESCQSMESSAGE) iterator.next());
    		if(se != null) {
    			eiaErrors.add(se);
    		}
    	}
        return eiaErrors;
    }


    protected  SifException mapError(Object cqsMessage) {

    	return mapError((ZESCQSMESSAGE) cqsMessage);
    }

	/**
	 * @param Zes_cqs_messages_t
	 * @return
	 */
	protected SifException mapError(ZESCQSMESSAGE cqsMessage) {
		String errorId =cqsMessage.getMSGNO().toString();

		String mappedId =(String) _errorIdMap.get(errorId);



		int sifErrorId = Integer.parseInt(mappedId);
		if((mappedId != null) && (sifErrorId != ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE)) {
            ESLog.debug("CQS errorId: " + errorId + ". CQS errorMessage: " + cqsMessage.getMESSAGE() + ". It is mapped to ES errorId " + mappedId);
			String reason = (String) _parameterTypeMap.get(errorId);
			if(reason != null) {
				return ErrorFactory.getSifException(sifErrorId,reason);
			}else {
				return ErrorFactory.getSifException(sifErrorId);
			}
		}


		return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,_sapRegionDisplayName);

	}
}
