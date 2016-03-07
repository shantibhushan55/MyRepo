package com.hp.es.service.catsAgreement.integration.mapping;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTSUMMARYS;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.types.StatusType;

public class MetroCATSAgreementMapper extends CATSAgreementMapper {

    public MetroCATSAgreementMapper(CatsAgreementTransaction transaction, EsRequestComplexType request, WarrantyEntitlementComplexType swopWarranty) {
        super(transaction, request, swopWarranty);
    }

    public WarrantyEntitlementComplexType map() throws MappingException {
        ESLog.debug("Enter warranty mapping");
        // Warranty Mapping
        WarrantyMapper warrantyMapper = new MetroWarrantyMapper(_transaction, _entitlementCheckDate, _swopWarranty, _XMLIdGenerator);
        WarrantyComplexType catsWarranty = warrantyMapper.map();
        if (catsWarranty != null) {
            WarrantyEntitlementComplexType result = new WarrantyEntitlementComplexType();
            WarrantyComplexType warranty = warrantyMapper.map();
            result.addWarranty(warranty);

            if (warranty != null && warranty.getOffer(0) != null) {
                AppliesTo appliesTo = warranty.getOffer(0).getAppliesTo(0);

                // startDate:
                // first check start date in the AppliesTo sections of the response. If none
                // AppliesTo section exists, use ENTITLEMENT_START_DATE from Entitlement Summary.
                if (appliesTo != null && appliesTo.getStartDate() != null)
                    result.setOverallWarrantyStartDate(appliesTo.getStartDate());
                else if (_transaction.getFirstEntSummary() != null){
                    result.setOverallWarrantyStartDate(MappingUtils.mapToCastorDate(((ZA2AESENTSUMMARYS) _transaction.getFirstEntSummary()).getENTITLEMENTSTARTDATE()));
                }

                // endDate:
                // first check end date in the AppliesTo sections of the response. If none AppliesTo
                // section exists, use ENTITLEMENT_START_DATE from Entitlement Summary.

                if (appliesTo != null && appliesTo.getEndDate() != null)
                    result.setOverallWarrantyEndDate(appliesTo.getEndDate());
                else if (_transaction.getFirstEntSummary() != null){
                    result.setOverallWarrantyEndDate(MappingUtils.mapToCastorDate(((ZA2AESENTSUMMARYS) _transaction.getFirstEntSummary()).getENTITLEMENTENDDATE()));
                }

                // status:
                // First calculate the status of the appliesTos - If one is active, the Warranty is
                // active - If no Offer dates exist, use summary dates
                if (appliesTo != null && appliesTo.getStartDate() != null && appliesTo.getEndDate() != null)
                    result.setActiveWarrantyEntitlement(appliesTo.getStatus() == StatusType.A);
                else {
                    if (MappingUtils.getStatus(result.getOverallWarrantyStartDate(), result.getOverallWarrantyEndDate(), _entitlementCheckDate) == StatusType.A) {
                        result.setActiveWarrantyEntitlement(true);
                    } else {
                        result.setActiveWarrantyEntitlement(false);
                    }
                }
            }
            return result;
        }
        return null;
    }
}
