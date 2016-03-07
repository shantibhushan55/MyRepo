package com.hp.es.service.catsAgreement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;

abstract class WarrantyMapper {
    protected CatsAgreementTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected Date _entitlementCheckDate;
    protected WarrantyEntitlementComplexType _swopWarranty;

    WarrantyMapper(CatsAgreementTransaction transaction, Date entitlementCheckDate, WarrantyEntitlementComplexType swopWarranty,
            XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _entitlementCheckDate = entitlementCheckDate;
        _swopWarranty = swopWarranty;
    }

    static WarrantyMapper getInstance(CatsAgreementTransaction transaction, Date entitlementCheckDate,
            WarrantyEntitlementComplexType swopWarranty, XMLIdGenerator XMLIdGenerator) {
            return new MetroWarrantyMapper(transaction, entitlementCheckDate, swopWarranty, XMLIdGenerator);
    }

    /**
     * 
     * map
     * 
     * @return
     * @throws MappingException
     * @throws MappingException
     */
    abstract WarrantyComplexType map() throws MappingException;

}
