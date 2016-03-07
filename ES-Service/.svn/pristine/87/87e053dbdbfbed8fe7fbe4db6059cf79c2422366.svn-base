package com.hp.es.service.catsAgreement.integration.mapping;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WS;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsRequestComplexType;

public class MetroCATSAgreementRequestMapper extends CATSAgreementRequestMapper {

    /**
     * 
     */
    public MetroCATSAgreementRequestMapper() {
        super();
    }

    public Object map(EsRequestComplexType request, String clientType, String callOption, String swopProductId, String swopShipToCountry) {

        ZA2FMAESGETENTV3WS astro2Request = new ZA2FMAESGETENTV3WS();
        if (clientType != null) {
            ESLog.debug("Set ClientType with " + clientType);
            astro2Request.setCLIENTTYPE(clientType.trim().toUpperCase());
        }
        if (callOption != null) {
            ESLog.debug("Set callOption with " + callOption);
            astro2Request.setOPTION(callOption.trim().toUpperCase());
        }
        // The country code used for the ASTRO2 request must be taken from the ship-to Country code
        // in the swop warranty reply. (WarrantyEntitlement.OOS[0].ShipToCountry )
        if (swopShipToCountry != null && (swopShipToCountry.trim().length() > 0)) {
            ESLog.debug("Set countryCode with ship-to country from SWOP: " + swopShipToCountry);
            astro2Request.setCOUNTRY(swopShipToCountry);
        } else {
            ESLog.debug("Set countryCode with IsoCountryCd in request.");
            astro2Request.setCOUNTRY(request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd());
        }
        // If the ProductID is not specified in the ES request, the ProductID from the Warranty
        // reply must be used to retrieve CATS.
        String pnInRequest = request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProductID();
        if (pnInRequest == null || "".equals(pnInRequest.trim())) {
            ESLog.debug("PN is not specified in the ES request. The ProductID " + swopProductId
                    + " from the Warranty reply is used to retrieve CATS.");
            astro2Request.setPRODUCTNUMBER(swopProductId);
        } else
            astro2Request.setPRODUCTNUMBER(pnInRequest);

        astro2Request.setSERIALNUMBER(request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber());
        return astro2Request;
    }
}
