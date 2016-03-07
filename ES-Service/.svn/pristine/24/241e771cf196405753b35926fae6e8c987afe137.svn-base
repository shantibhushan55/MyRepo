package com.hp.es.service.catsAgreement.integration.mapping;

import java.util.ArrayList;
import java.util.List;

import org.exolab.castor.types.Date;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESENTDETAILV3S;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESOFFERV3S;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.types.StatusType;

public class MetroOfferMapper extends OfferMapper {

    MetroOfferMapper(CatsAgreementTransaction transaction, Date entitlementCheckDate, WarrantyEntitlementComplexType swopWarranty,
            XMLIdGenerator XMLIdGenerator) {
        super(transaction, entitlementCheckDate, swopWarranty, XMLIdGenerator);
    }

    OfferComplexType[] map() throws MappingException {
        if (_transaction == null || _transaction.getFirstEntDetail() == null) {
            return new OfferComplexType[0];
        }
        ArrayList<OfferComplexType> offerList = new ArrayList<OfferComplexType>();
        ZA2AESENTDETAILV3S firstEntDetail=(ZA2AESENTDETAILV3S) _transaction.getFirstEntDetail();
        if (firstEntDetail.getOFFERS() != null) {
            List<ZA2AESOFFERV3S> offers = firstEntDetail.getOFFERS().getItem();
            for (ZA2AESOFFERV3S a2Offer : offers) {
                offerList.add(mapOffer(a2Offer));
            }
        }
        return offerList.toArray(new OfferComplexType[0]);
    }

    private OfferComplexType mapOffer(ZA2AESOFFERV3S a2Offer) throws MappingException {

        OfferComplexType offer = new OfferComplexType();
        offer.setId(_XMLIdGenerator.nextId());
        offer.setOfferCode(MappingUtils.nullString(a2Offer.getGISOFFERCODE()));
        offer.setOfferDescription(a2Offer.getOFFERDESCRIPTION());

        // Modifier Mapping
        ModifierMapper mm = new MetroModifierMapper(a2Offer.getMODIFIERDESCRIPTIONS().getItem());
        offer.setModifier(mm.map());

        // Deliverable
        DeliverableMapper dm = new MetroDeliverableMapper(a2Offer.getDELIVERABLENAMES().getItem());
        offer.setDeliverable(dm.map());

        // AppliesTo

        offer.setAppliesTo(mapAppliesTo(a2Offer));

        return offer;
    }

    private AppliesTo[] mapAppliesTo(ZA2AESOFFERV3S a2Offer) {

        ESLog.debug("Mapping appliesTo");

        AppliesTo appliesTo = new AppliesTo();
        appliesTo.setOOSRef(_swopWarranty.getOOS());
        appliesTo.setOOSKey(MappingUtils.stripLeadingZeroes(_swopWarranty.getOOS().getOOSKey()));
        appliesTo.setStartDate(MappingUtils.mapToCastorDate(a2Offer.getOFFERSTARTDATE()));
        appliesTo.setEndDate(MappingUtils.mapToCastorDate(a2Offer.getOFFERENDDATE()));
        appliesTo.setStatus(MappingUtils.getStatus(MappingUtils.mapToCastorDate(a2Offer.getOFFERSTARTDATE()), MappingUtils.mapToCastorDate(a2Offer
                .getOFFERENDDATE()), _entitlementCheckDate));
        if (appliesTo.getStatus() == StatusType.A) {
            appliesTo.setActiveAppliesTo(true);
        } else {
            appliesTo.setActiveAppliesTo(false);
        }
        AppliesTo[] appliesToList = new AppliesTo[1];
        appliesToList[0] = appliesTo;
        return appliesToList;
    }

}
