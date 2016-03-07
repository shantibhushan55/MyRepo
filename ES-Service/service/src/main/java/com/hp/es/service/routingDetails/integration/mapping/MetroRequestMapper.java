package com.hp.es.service.routingDetails.integration.mapping;

import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.RoutingDetailsRequest;

/**
 * 
 * @author Chunyang
 * @since 10.1.5
 */
public class MetroRequestMapper extends RequestMapper {

    protected MetroRequestMapper(EsRequestComplexType inputRequest) {
        super(inputRequest);
    }

    public Object map() {
        ESLog.debug("Mapping ES request to Metro RoutingDetails request");
        RoutingDetailsRequest esRoutingDetailsRequest = _inputRequest.getEsRequestComplexTypeChoice().getRoutingDetailsRequest();
        ZESROUTINGDETAILSES10 metroRoutingDetailsRequest=new ZESROUTINGDETAILSES10();
        metroRoutingDetailsRequest.setSVCAGREEMENTID(esRoutingDetailsRequest.getSvcAgreementID());
        return metroRoutingDetailsRequest;
    }

}
