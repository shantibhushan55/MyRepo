package com.hp.es.service.routingDetails.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESCQSMESSAGE;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * 
 * @author Chunyang
 * @since 10.1.5
 */
public class MetroErrorMapper extends ErrorMapper {

    protected MetroErrorMapper(Collection cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {
        super(cqsErrors, request, sapRegionDisplayName);
    }

    /**
     * @throws MappingException
     */
    public ArrayList map() throws MappingException {
        if (_cqsErrors == null) {
            return null;
        }

        ESLog.debug("Mapping errors ...");
        ArrayList eiaErrors = new ArrayList();

        Iterator iterator = _cqsErrors.iterator();
        while (iterator.hasNext()) {
            SifException se = mapError((ZESCQSMESSAGE) iterator.next());
            if (se != null) {
                eiaErrors.add(se);
            }
        }
        return eiaErrors;
    }

    protected SifException mapError(Object cqsMessage) {
        return mapError((ZESCQSMESSAGE) cqsMessage);
    }

    private SifException mapError(ZESCQSMESSAGE cqsMessage) {
        String errorId = cqsMessage.getMSGNO().toString();

        String mappedId = (String) _errorIdMap.get(errorId);

        int sifErrorId = Integer.parseInt(mappedId);
        if ((mappedId != null) && (sifErrorId != ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE)) {
            String reason = (String) _parameterTypeMap.get(errorId);
            if (reason != null) {
                return ErrorFactory.getSifException(sifErrorId, reason);
            } else {
                return ErrorFactory.getSifException(sifErrorId);
            }
        }

        return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, _sapRegionDisplayName);
    }
}
