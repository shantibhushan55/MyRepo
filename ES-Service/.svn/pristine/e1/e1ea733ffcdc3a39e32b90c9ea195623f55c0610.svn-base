package com.hp.es.service.catsAgreement.integration.mapping;

import com.hp.es.xml.service.EsRequestComplexType;

public abstract class CATSAgreementRequestMapper {

    protected CATSAgreementRequestMapper() {
        super();
    }

    public abstract Object map(EsRequestComplexType request, String clientType, String callOption, String swopProductId, String swopShipToCountry);

    public static CATSAgreementRequestMapper getInstance() {
            return new MetroCATSAgreementRequestMapper();
    }
}
