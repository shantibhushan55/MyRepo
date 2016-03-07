/*
 * Created on 05.06.2003
 *
 * To change this generated comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.hp.es.service.warrantyEntitlement;

import java.util.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.SerialNumberValidator;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.Operation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.es.xml.service.types.StatusType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Calls the <code>GetWarrantyEntitlementOperation</code> and filters out the inactive warranties
 * from the reply of this operation.
 * @author Thorsten Koevi
 *
 */
public class GetActiveOnlyWarrantyEntitlementOperation extends EsOperation {

    /**
     * @see com.hp.es.serviceHandler.Operation#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
     */
    protected EsReply execute(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler)
        throws SifException {
        Operation _weOperation = getOperationManager().getPublicOperation("getWarrantyEntitlement");

        EsReply esReply = null;
        try { 
            esReply = (EsReply)_weOperation.processRequest(request, context,metricsHandler);
        }
        catch (ClassCastException e) {
            SifException ex = ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR, 
                "The Operation '" + _weOperation.toString() + "'" +
                " didn't return an EsReply as expected");
            throw ex;
        }

        // If the reply contains a unit list simply return the EsReply, no further
        // processing necessary.
        UnitListComplexType unitList = esReply.getEsReplyChoice().getUnitList();
        if(unitList != null) {
            return esReply;
        }

        WarrantyEntitlementComplexType weComplexType = esReply.getEsReplyChoice().getWarrantyEntitlement();
        WarrantyComplexType[] warranties = weComplexType.getWarranty();
        WarrantyComplexType warranty = null;
        // Iterate over all warranties
        for(int i = 0; i < warranties.length; i++) {
            warranty = warranties[i];
             // Iterate over all offers of this warranty to find out which one is active
            OfferComplexType[] offers = warranty.getOffer();
            OfferComplexType offer = null;
            for(int j=0; j<offers.length; j++) {
                offer = offers[j];
                StatusType status = offer.getAppliesTo(0).getStatus();
                if(!status.equals(StatusType.A)) {
                    // Delete offer if it is not active
                    warranty.removeOffer(offer);
                }
            }
            // check if all offers were removed, if yes remove also the warranty
            if (warranty.getOffer().length == 0) {
                weComplexType.removeWarranty(warranty);
                if ((context.getCatsWarrantyEntitlement() != null) && (context.getCatsWarrantyEntitlement().getWarranty() != null)
                        && (warranty == context.getCatsWarrantyEntitlement().getWarranty(0))) {
                    //Cats Warranty is removed because of inactive warranty
                    ESLog.debug("Cats Warranty is removed because of inactive warranty.");
                    context.setCatsWarrantyEntitlement(null);
                }
            }
        }

        return esReply;
    }

    /**
     * @see com.hp.es.serviceHandler.Operation#init()
     */
    protected void init() {
    }

    /**
     * @see com.hp.es.serviceHandler.Operation#verifyRequest(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
     */
    protected void verifyRequest(EsRequestComplexType request, MetricsHandler metricsHandler)
        throws SifException {
		// This cannot be working well as the request need to be cleanup
		WarrantyRequest wr = request.getEsRequestComplexTypeChoice()
				.getWarrantyRequest();
		
		if (wr == null) {
			throw ErrorFactory
					.getSifException(ErrorFactory.id120_INVALID_REQUEST,
							"The GetWarrantyEntitlement operation requires a Warranty request.");
		}
		// We first check ISO country code
		checkMandatoryParameter(wr.getIsoCountryCd(), "IsoCountryCd()",
				"The parameter IsoCountryCd is missing in GetWarrantyEntitlementOperation");

		// If there is a proof of purchase date. It needs to be NOT in future.
		if (wr.getProofPurchaseDate() != null) {
			Date d = wr.getProofPurchaseDate().toDate();
			if (d.after(new Date())) {
				throw ErrorFactory
						.getSifException(
								ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
								"The parameter ProofOfPurchaseDate must NOT be a date in future.");
			}

		}

		// If we have a spare part number we must have ProofPurchaseDate, unit
		// Serial Number or DateCode is required
		if (wr.getSparePartNumber() != null
				&& wr.getSparePartNumber().trim().length() > 0) {
			if (wr.getProofPurchaseDate() == null
					&& (wr.getSerialNumber() == null || wr.getSerialNumber()
							.trim().length() == 0)
					&& (wr.getDateCode() == null || wr.getDateCode().trim()
							.length() == 0)) {
				throw ErrorFactory
						.getSifException(ErrorFactory.id200_MISSING_PARAMETER,
								"SparePartNumber requires proof of Purchase Date or serial number or date code");
			}
		}

		// If we have a spare part number we must have ProofPurchaseDate, unit
		// Serial Number or DateCode is required
		if ((wr.getSparePartNumber() == null || wr.getSparePartNumber().trim()
				.length() == 0)
				&& (wr.getSerialNumber() == null || wr.getSerialNumber().trim()
						.length() == 0)
				&& (wr.getProductID() == null || wr.getProductID().trim()
						.length() == 0)) {
			throw ErrorFactory
					.getSifException(
							ErrorFactory.id200_MISSING_PARAMETER,
							"Warranty entitlement requires SparePartNumber, proof Of Purchase Date or serial number or date code");
		}
		int minLength = Configuration.getInstance().getProperties()
				.getIntegerProperty(EsConstants.ES_SN_MINLENGTH);
		SerialNumberValidator.verifySerialNumberLessThan(wr.getSerialNumber(),
				minLength);
		SerialNumberValidator.verifyInvalidSerialNumber(wr
				.getSerialNumber());
		SerialNumberValidator.verifyInvalidSerialNumberPrefix(wr
				.getSerialNumber());
		SerialNumberValidator.verifyInvalidSerialNumberSuffix(wr.getSerialNumber());
		
		if( (wr.getProductID()!=null) && (wr.getProductID().trim().length()!=0)){
			int maximum=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
			ProductNumberValidator.verifyProductNumberGreaterThan(wr.getProductID(), maximum);
		}
    }

	

}
