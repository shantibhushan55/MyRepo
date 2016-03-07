/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.catsAgreement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;

/**
 * @author yesilyur
 * 
 */
public abstract class CATSAgreementMapper {

    protected CatsAgreementTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected Date _entitlementCheckDate;
    protected WarrantyEntitlementComplexType _swopWarranty;
    protected EsRequestComplexType _request;

    public CATSAgreementMapper(CatsAgreementTransaction transaction, EsRequestComplexType request, WarrantyEntitlementComplexType swopWarranty) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
        _request = request;
        _swopWarranty = swopWarranty;
        _entitlementCheckDate = request.getEsRequestComplexTypeChoice().getWarrantyRequest().getEntitlementCheckDate();
    }

    /**
     * This is the entry point for mapping a complete warranty reply
     * 
     * @return
     * @throws MappingException
     */
    public abstract WarrantyEntitlementComplexType map() throws MappingException;

    public static CATSAgreementMapper getInstance(CatsAgreementTransaction transaction, EsRequestComplexType request, WarrantyEntitlementComplexType swopWarranty) {
            return new MetroCATSAgreementMapper(transaction, request, swopWarranty);
    }


}
