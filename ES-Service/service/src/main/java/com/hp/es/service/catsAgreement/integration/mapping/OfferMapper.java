package com.hp.es.service.catsAgreement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;

abstract class OfferMapper {
    protected CatsAgreementTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected Date _entitlementCheckDate;
    protected WarrantyEntitlementComplexType _swopWarranty;

    OfferMapper(CatsAgreementTransaction transaction, Date entitlementCheckDate, WarrantyEntitlementComplexType swopWarranty,
            XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _swopWarranty = swopWarranty;
        _entitlementCheckDate = entitlementCheckDate;
    }

    static OfferMapper getInstance(CatsAgreementTransaction transaction, Date entitlementCheckDate,
            WarrantyEntitlementComplexType swopWarranty, XMLIdGenerator XMLIdGenerator) {

            return new MetroOfferMapper(transaction, entitlementCheckDate, swopWarranty, XMLIdGenerator);
    }

    /**
     * 
     * map
     * 
     * @return
     * @throws MappingException
     * @throws MappingException
     */
    abstract OfferComplexType[] map() throws MappingException;

}
