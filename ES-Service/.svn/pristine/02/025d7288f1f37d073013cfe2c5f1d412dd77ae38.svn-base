/**
 * 
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYERROR;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYINFO;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author anvoi
 *
 */
class MetroWarningMapper extends WarningMapper {

	/**
	 * @param request
	 * @param transaction
	 */
	protected MetroWarningMapper(EsRequestComplexType request,
			WarrantyTransaction transaction) {
		super(request, transaction);
	}

	protected EIAError mapWarning(Object swopWarning) {
		return mapWarning((ZWTYERROR)swopWarning);
	}

	/**
	 * @param zwtyerrortab
	 * @return
	 */
	protected EIAError mapWarning(ZWTYERROR swopWarning) {
	   	ESLog.debug("::mapWarning: swopWarning code=" + swopWarning.getID() +" ::Message="+swopWarning.getMESSAGE());

		// 1000
		if(swopWarning.getID().equals("1000")) {
            return ErrorFactory.getEIAError(ErrorFactory.id429_WARRANTY_REDETERMINED_BASED_INPUT_COUNTRY, "SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1001
		if(swopWarning.getID().equals("1001")) {
			return ErrorFactory.getEIAError(ErrorFactory.id418_INACCURATE_START_DATE, "SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1005
		if(swopWarning.getID().equals("1005")) {
			ZWTYWTYENT sourceReply = (ZWTYWTYENT)_transaction.getSourceSystemStandardReply();
			String productAlias = null;
			if(sourceReply.getPRODUCTINFO() != null) {
				productAlias = sourceReply.getPRODUCTINFO().getPRODUCTNUM();
			} else {
				productAlias = "";
			}
			return ErrorFactory.getEIAError(ErrorFactory.id405_USING_PRODUCT_SYNONYM,  
									_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProductID(), 
									productAlias, "SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1006
		if(swopWarning.getID().equals("1006")) {
			ZWTYWTYENT sourceReply = (ZWTYWTYENT)_transaction.getSourceSystemStandardReply();
			String popDate="-";
			if(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProofPurchaseDate()==null) {
				if(sourceReply.getOOSINFO() != null && sourceReply.getOOSINFO().getPROOFOFPURCHASEDATE() != null&& sourceReply.getOOSINFO().getPROOFOFPURCHASEDATE().trim().length()>0)
					popDate=sourceReply.getOOSINFO().getPROOFOFPURCHASEDATE();
			}else {
				popDate= MappingUtils.mapCastorDateToString(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProofPurchaseDate());
			}
			String shipDate="-";
			if(sourceReply.getOOSINFO().getSHIPMENTDATE() != null && sourceReply.getOOSINFO().getSHIPMENTDATE().trim().length()>0) {
				shipDate=sourceReply.getOOSINFO().getSHIPMENTDATE();
			}
			return ErrorFactory.getEIAError(ErrorFactory.id413_REG_PURCHASE_DATE_TOO_LATE, popDate,
					shipDate, "SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE());	
		}
		// 1007
		if(swopWarning.getID().equals("1007")) {
		    ZWTYWTYENT sourceReply = (ZWTYWTYENT)_transaction.getSourceSystemStandardReply();
			return ErrorFactory.getEIAError(ErrorFactory.id412_REG_PURCHASE_DATE_TOO_EARLY, 
					MappingUtils.mapCastorDateToString(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProofPurchaseDate()),
					sourceReply.getOOSINFO().getSHIPMENTDATE(), "SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE());	
		}
		// 1008
		if(swopWarning.getID().equals("1008")) {
			return ErrorFactory.getEIAError(ErrorFactory.id416_SERIAL_NR_DECODE_FAILED,
					"SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1009
		if(swopWarning.getID().equals("1009")) {
			return ErrorFactory.getEIAError(ErrorFactory.id402_UNIT_NOT_FOUND,
					"SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1010
		if(swopWarning.getID().equals("1010")) {
			return ErrorFactory.getEIAError(ErrorFactory.id411_SERVICE_ID_DECODE_FAILED, 
					_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getServiceID(),
					"SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1011
		if(swopWarning.getID().equals("1011")) {
			return ErrorFactory.getEIAError(ErrorFactory.id432_WARRANTY_CALCULATED_BASED_SPAREPARTNUMBER,
					"SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1013
		if(swopWarning.getID().equals("1013")) {
			return ErrorFactory.getEIAError(ErrorFactory.id408_UNIT_LIST_TRUNCATED,
					"SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1014
		if(swopWarning.getID().equals("1014")) {
			return ErrorFactory.getEIAError(ErrorFactory.id433_INPUT_POP_DATE_NOT_USED, "SWOP " + swopWarning.getID() + ": " + swopWarning.getMESSAGE()); 
		}
		// 1XXX
		if(swopWarning.getID().startsWith("1")) {
			return ErrorFactory.getEIAError(ErrorFactory.id426_SOURCESYSTEM_RETURNED_WARNING, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}
		
		// 3G Warnings (450 thru 457)
		/*
		 * 3001 'Product Ownership type on the unit is commercial. Warranty dates do not reflect 3G warranty',
		 		+> ignored.
			3002 'Product Ownership type on the unit is consumer. Entitlement request parameter is ignored',
		 		+> ignored.			
			3003 'This product is subject to warranty 3G regulation, please request a POP date',
			>>450
			3004 'Warranty extension includes 3G regulation for China; Warranty extension does not apply to customer',
			>>IGNORED
			3005 'var1 have a 3G extended warranty of var2 days',
			>>452
			3006 'Whole Unit is within 3G regulation',
			>>451
			3007 '3G Unit was repaired var1 times. Part warranty could be different than product warranty coverage',
			>>452
			3008 '3G Unit was repaired var1 times'.
			>>453

		 */
		/*
		if(swopWarning.getID().equals("3001")) {
			return ErrorFactory.getEIAError(ErrorFactory.id450_3G_OWNERTYPE_COMM_NOT_3G_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}
		if(swopWarning.getID().equals("3002")) {
			return ErrorFactory.getEIAError(ErrorFactory.id451_3G_OWNERTYPE_CONSUMER_ENTITL_PARM_IGNORED_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}*/
		if(swopWarning.getID().equals("3003")) {
			return ErrorFactory.getEIAError(ErrorFactory.id450_3G_UNIT_REQUEST_POP_AND_OWNER_TYPE_INFO_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}
		if(swopWarning.getID().equals("3005")) {
			return ErrorFactory.getEIAError(ErrorFactory.id452_3G_UNIT_PART_WARRANTY_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}

		if(swopWarning.getID().equals("3006")) {
			return ErrorFactory.getEIAError(ErrorFactory.id451_3G_UNIT_WITHIN_WARRENTY_REGULATION_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}
/*		if(swopWarning.getID().equals("3004")) {
			return ErrorFactory.getEIAError(ErrorFactory.id453_3G_WARR_EXT_INCLUDE_3G_FOR_CHINA_NOT_CUST_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}
*/		
		
		if(swopWarning.getID().equals("3007")) {
			return ErrorFactory.getEIAError(ErrorFactory.id452_3G_UNIT_PART_WARRANTY_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}
		if(swopWarning.getID().equals("3008")) {
			return ErrorFactory.getEIAError(ErrorFactory.id453_3G_UNIT_HAS_PART_HISTORY_SWOP, swopWarning.getID(), swopWarning.getMESSAGE()); 
		}

	
		// not a warning, will not be mapped
		return null; 
	}
	
	EIAError getWarning420() {
		EIAError error = null;
		//add warning 420:  product is consumer product. 
		//This is trigger by: WarrantyInfo.SupportProductLine equal �R6� or �MK� or is empty
		if(_transaction.getSourceSystemStandardReply() != null) {
			ZWTYWTYINFO wty = ((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getWARRANTYINFO();
			String productline = MappingUtils.nullString(wty.getSUPPORTPRODUCTLINE());
			if("".equals(productline) || "R6".equalsIgnoreCase(productline) || "MK".equalsIgnoreCase(productline)) {
				error = ErrorFactory.getEIAError(ErrorFactory.id420_CONSUMER_PRODUCT);
			}
		}
		return error;
	}	
	
	/*
	 * Mapping of SNR
	 */
	EIAError getWarning441() {
		return ErrorFactory.getEIAError(ErrorFactory.id441_UNIT_SNR_PARENT_BUNDLE);
	}

	EIAError getWarning440(String parentBundleHpSerialNumber,
			String parentBundleHpProductId) {
		return ErrorFactory.getEIAError(ErrorFactory.id440_UNIT_SNR_PARENT_BUNDLE_IDENTIFIED,parentBundleHpSerialNumber,parentBundleHpProductId);
	}


	@Override
	EIAError getWarning434(SifException se) {

		return ErrorFactory.convertSifException(se);
	}
}
