package com.hp.es.service.catsAgreement.integration.mapping;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTHEADERV2S;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;

public class MetroErrorMapper extends ErrorMapper {

    protected MetroErrorMapper(CatsAgreementTransaction transaction) {
        super(transaction);
    }

    public EIAError map() throws MappingException {
        ZA2AESENTHEADERV2S header = (ZA2AESENTHEADERV2S) _transaction.getEntitlementHeader();
        return getError(header.getERRORCODE(), header.getERRORMESSAGE());
    }
}
