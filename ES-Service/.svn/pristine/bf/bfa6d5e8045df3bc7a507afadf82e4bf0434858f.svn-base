package com.hp.es.service.catsAgreement.integration.mapping;

import org.exolab.castor.types.Date;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTDETAILV3S;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTSUMMARYS;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTWEBSERVICEV3S;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESOFFERV3S;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WSResponse;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.types.PortfolioFlagType;
import com.hp.es.xml.service.types.WarrantyTypeType;

/**
 * This section is optional. It will be created if CATS Agreement information had been requested and
 * the information had been retrieved
 * 
 * @author wangwchu
 * 
 */
public class MetroWarrantyMapper extends WarrantyMapper {

    MetroWarrantyMapper(CatsAgreementTransaction transaction, Date entitlementCheckDate, WarrantyEntitlementComplexType swopWarranty,
            XMLIdGenerator XMLIdGenerator) {
        super(transaction, entitlementCheckDate, swopWarranty, XMLIdGenerator);
    }

    public WarrantyComplexType map() throws MappingException {
        if (_transaction == null || _transaction.getFirstEntDetail() == null) {
            return null;
        }
        ZA2FMAESGETENTV3WSResponse response=(ZA2FMAESGETENTV3WSResponse) _transaction.getSourceSystemStandardReply();
        ZA2AESENTWEBSERVICEV3S a2Ent = response.getENTITLEMENT();
        return mapWarranty(a2Ent);
    }

    private WarrantyComplexType mapWarranty(ZA2AESENTWEBSERVICEV3S a2Ent) throws MappingException {
        ESLog.debug("Mapping warranty object");
        WarrantyComplexType warranty = new WarrantyComplexType();

        warranty.setWarrantyType(WarrantyTypeType.BW);
        warranty.setPortfolioFlag(PortfolioFlagType.G);

        if (_transaction.getFirstOffer() != null) {
            ZA2AESOFFERV3S firstOffer=(ZA2AESOFFERV3S) _transaction.getFirstOffer();
            warranty.setTermCode(MappingUtils.nullString(firstOffer.getOFFERCODE()));
            String startDateType = firstOffer.getSTARTDATETYPE();
            warranty.setWarrantyDeterminationCode(WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode(startDateType));
            warranty.setWarrantyDeterminationDescription(WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription(startDateType));

        }

        if (_transaction.getFirstEntDetail() != null) {
            ZA2AESENTDETAILV3S detail=(ZA2AESENTDETAILV3S) _transaction.getFirstEntDetail();
            warranty.setWarrantyComment(MappingUtils.nullString(detail.getCAREPACKSERIALNUMBER()));
            warranty.setGracePeriod(MappingUtils.stringToInt(detail.getGRACEPERIOD()));
        }

        if (_transaction.getFirstEntSummary() != null){
            ZA2AESENTSUMMARYS firstEntSummary=(ZA2AESENTSUMMARYS) _transaction.getFirstEntSummary();
            warranty.setWarrantyStartDate(MappingUtils.mapToCastorDate(firstEntSummary.getENTITLEMENTSTARTDATE()));
        }
         
        // Offer Mapping
        OfferMapper om = OfferMapper.getInstance(_transaction, _entitlementCheckDate, _swopWarranty, _XMLIdGenerator);
        warranty.setOffer(om.map());
        return warranty;
    }
}
