package com.hp.es.tm.service;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.TmTransaction;
import com.hp.es.tm.util.exception.TmException;
import com.hp.es.xml.service.AssociatedContractsRequest;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.ContractSummaryRequest;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.InstalledBaseUnitRequest;
import com.hp.es.xml.service.PrintAdvantageRequest;
import com.hp.es.xml.service.RoutingDetailsRequest;
import com.hp.es.xml.service.UnitEventHistoryRequest;
import com.hp.es.xml.service.WarrantyRequest;

final class TransactionRequestHelper {

	private TransactionRequestHelper() {
	}
	
	

	/*
	 * Process all Request fields
	 */

	static void processRequest(EIAMessage request, TmTransaction tmTrans) throws TmException {

		/*
		 * Just to protect the code, although this should never ever happen
		 */
		if (request == null || tmTrans == null 
				|| request.getMessageBody()== null
				|| request.getMessageBody().getEsRequest()== null 
				|| request.getMessageBody().getEsRequest().getEsRequestComplexTypeChoice() == null
				) {
			throw new TmException("Can't process a request when request is null!");
		}
		
		EsRequestComplexTypeChoice tmpChoice = request.getMessageBody().getEsRequest().getEsRequestComplexTypeChoice();
		if(tmpChoice.getAssociatedContractsRequest() != null) {
			processRequest(tmpChoice.getAssociatedContractsRequest(),tmTrans);
			
		}else if(tmpChoice.getContractRequest() != null) {
			processRequest(tmpChoice.getContractRequest(),tmTrans);
			
		}else if(tmpChoice.getContractSummaryRequest() != null) {
			processRequest(tmpChoice.getContractSummaryRequest(),tmTrans);
			
		}else if(tmpChoice.getEntitlementByPnRequest()!= null) {
			processRequest(tmpChoice.getEntitlementByPnRequest(),tmTrans);
			
		}else if(tmpChoice.getEntitlementBySnRequest()!= null) {
			processRequest(tmpChoice.getEntitlementBySnRequest(),tmTrans);
			
		}else if(tmpChoice.getInstalledBaseUnitRequest()!= null) {
			processRequest(tmpChoice.getInstalledBaseUnitRequest(),tmTrans);
			
		}else if(tmpChoice.getPrintAdvantageRequest()!= null) {
			processRequest(tmpChoice.getPrintAdvantageRequest(),tmTrans);
			
		}else if(tmpChoice.getRoutingDetailsRequest()!= null) {
			processRequest(tmpChoice.getRoutingDetailsRequest(),tmTrans);
			
		}else if(tmpChoice.getUnitEventHistoryRequest()!= null) {
			processRequest(tmpChoice.getUnitEventHistoryRequest(),tmTrans);
			
		}else if(tmpChoice.getWarrantyRequest()!= null) {
			processRequest(tmpChoice.getWarrantyRequest(),tmTrans);
		}else {
			throw new TmException("request is invalid!");
		}
			
	}
	
	
	
		private static void processRequest(WarrantyRequest warrantyRequest, TmTransaction tmTrans) {
			if (warrantyRequest.getEntitlementCheckDate() != null) {
				tmTrans.setReqEntitleCheckDate(warrantyRequest
						.getEntitlementCheckDate().toLong());
			}
			if ((warrantyRequest.getIsoCountryCd() != null)
					&& (!"".equals(warrantyRequest
							.getIsoCountryCd()))) {
				tmTrans.setReqCountryCode(warrantyRequest
						.getIsoCountryCd());
			}
			if (warrantyRequest.getSourceSystem() != null) {
				tmTrans.setReqSourceSystem(warrantyRequest
						.getSourceSystem());
			}
			if (warrantyRequest.getCarePackSerialNumber() != null) {
				tmTrans.setReqCarePackSn(warrantyRequest
						.getCarePackSerialNumber());
			}
			if (warrantyRequest.getCarePackProductNumber() != null) {
				tmTrans.setReqCarePackPn(warrantyRequest
						.getCarePackProductNumber());
			}
			if (warrantyRequest.getSerialNumber() != null) {
				tmTrans.setReqSn(warrantyRequest.getSerialNumber());
			}
			if (warrantyRequest.getProductID() != null) {
				tmTrans.setReqProductId(warrantyRequest.getProductID());
			}
			if (warrantyRequest.getProofPurchaseDate() != null) {
				tmTrans.setReqProofPurchaseDate(warrantyRequest.getProofPurchaseDate().toLong());
			}
			tmTrans.setReqSparepartNumber(warrantyRequest.getSparePartNumber());
			tmTrans.setReqDateCode(warrantyRequest.getDateCode());
			tmTrans.setReqServiceId(warrantyRequest.getServiceID());
			tmTrans.setReqMarketSegment(warrantyRequest.getMarketSegment());
				tmTrans.setReqGeoCode(warrantyRequest.getGeoCode());
			tmTrans.setReqIncludeServiceNote(warrantyRequest.getIncludeServiceNotes());
			tmTrans.setReqIncludeWorkings(warrantyRequest.getIncludeWorkings());
			tmTrans.setReqIncludeAddress(warrantyRequest.getIncludeAddresses());
			tmTrans.setReqConsumerBusinessLogicNeeded(warrantyRequest.getConsumerBusinessLogicNeeded());
			tmTrans.setReqIncludeCats(warrantyRequest.getIncludeCATS());

		
		}



		private static void processRequest(UnitEventHistoryRequest unitEventHistoryRequest, TmTransaction tmTrans) {
			tmTrans.setReqSn(unitEventHistoryRequest.getSerialNumber());
			tmTrans.setReqProductId(unitEventHistoryRequest.getProductNumber());		
		}



		private static void processRequest(RoutingDetailsRequest routingDetailsRequest, TmTransaction tmTrans) {
				tmTrans.setReqSvcAgreementId(routingDetailsRequest.getSvcAgreementID());		
		}



		private static void processRequest(PrintAdvantageRequest printAdvantageRequest, TmTransaction tmTrans) {
			if ((printAdvantageRequest.getContractIdentifier() != null)
					&& (!"".equals(printAdvantageRequest
							.getContractIdentifier()))) {
				tmTrans.setReqContractId(printAdvantageRequest.getContractIdentifier());
			}
			if (printAdvantageRequest.getContractIdentifierType() != null) {
				tmTrans.setReqContractIdType(printAdvantageRequest
						.getContractIdentifierType().toString());
			}
			if ((printAdvantageRequest.getIsoCountryCd() != null)
					&& (!"".equals(printAdvantageRequest
							.getIsoCountryCd()))) {
				tmTrans.setReqCountryCode(printAdvantageRequest
						.getIsoCountryCd());
			}
		}



		private static void processRequest(InstalledBaseUnitRequest installedBaseUnitRequest, TmTransaction tmTrans) {
			if (installedBaseUnitRequest.getInstalledBaseUnitRequestChoice() != null) {
				if (installedBaseUnitRequest.getInstalledBaseUnitRequestChoice().getSerialNumber() != null) {
					tmTrans.setReqSn(installedBaseUnitRequest.getInstalledBaseUnitRequestChoice().getSerialNumber());
				}
			}
			if (installedBaseUnitRequest.getProductID() != null) {
				tmTrans.setReqProductId(installedBaseUnitRequest.getProductID());
			}
			tmTrans.setReqTotalResultSize(installedBaseUnitRequest.getTotalResultSize());
			if (installedBaseUnitRequest.getSourceSystem() != null) {
				tmTrans.setReqSourceSystem(installedBaseUnitRequest.getSourceSystem());
			}
		
		}



		private static void processRequest(EntitlementBySnRequest entitlementBySnRequest, TmTransaction tmTrans) {
			if ((entitlementBySnRequest.getContractIdentifierType() != null)&& (entitlementBySnRequest.getContractIdentifierType().toString() != null)&& (!"".equals(entitlementBySnRequest.getContractIdentifierType().toString()))) {
				tmTrans.setReqContractIdType(entitlementBySnRequest.getContractIdentifierType().toString());
				}
				tmTrans.setReqDataEntrySite(entitlementBySnRequest.getDataEntrySite());
				tmTrans.setReqSourceCustomerId(entitlementBySnRequest.getSourceCustomerID());
				tmTrans.setReqRedAccessId(entitlementBySnRequest.getRedAccessID());
				tmTrans.setReqActiveContractsOnly(entitlementBySnRequest.getActiveContractsOnly());
				tmTrans.setReqActiveServicesOnly(entitlementBySnRequest.getActiveServicesOnly());
				tmTrans.setReqIncludeAddress(entitlementBySnRequest.getIncludeAddresses());
				tmTrans.setReqIncludeContacts(entitlementBySnRequest.getIncludeContacts());
				tmTrans.setReqIncludeOffers(entitlementBySnRequest.getIncludeOffers());
				tmTrans.setReqIncludeDeliverables(entitlementBySnRequest.getIncludeDeliverables());
				tmTrans.setReqIncludeModifiers(entitlementBySnRequest.getIncludeModifiers());
				tmTrans.setReqIncludeWorkings(entitlementBySnRequest.getIncludeWorkings());
				tmTrans.setReqActiveWarrantyOnly(entitlementBySnRequest.getActiveWarrantyOnly());
				tmTrans.setReqConsumerBusinessLogicNeeded(entitlementBySnRequest.getConsumerBusinessLogicNeeded());
				tmTrans.setReqIncludeWarranty(entitlementBySnRequest.getIncludeWarranty());
				tmTrans.setReqIncludeCats(entitlementBySnRequest.getIncludeCATS());
				tmTrans.setReqIncludeContracts(entitlementBySnRequest.getIncludeContracts());
				tmTrans.setReqIncludeServiceNote(entitlementBySnRequest.getIncludeServiceNotes());
				if (entitlementBySnRequest.getProofPurchaseDate() != null) 
					tmTrans.setReqProofPurchaseDate(entitlementBySnRequest.getProofPurchaseDate().toLong());

				if (entitlementBySnRequest.getEntitlementCheckDate() != null) 
					tmTrans.setReqEntitleCheckDate(entitlementBySnRequest.getEntitlementCheckDate().toLong());

				if ((entitlementBySnRequest.getIsoCountryCd() != null)&& (!"".equals(entitlementBySnRequest.getIsoCountryCd()))) 
					tmTrans.setReqCountryCode(entitlementBySnRequest.getIsoCountryCd());

				tmTrans.setReqMnContractSourceDoc(entitlementBySnRequest.getMNContractSourceDoc());
				tmTrans.setReqRedGroupSn(entitlementBySnRequest.getRedGroupSerialNo());
				tmTrans.setReqServiceId(entitlementBySnRequest.getServiceID());
				tmTrans.setReqMarketSegment(entitlementBySnRequest.getMarketSegment());
				tmTrans.setReqGeoCode(entitlementBySnRequest.getGeoCode());
				if ((entitlementBySnRequest.getContractIdentifier() != null)&& (!"".equals(entitlementBySnRequest.getContractIdentifier()))) 
					tmTrans.setReqContractId(entitlementBySnRequest.getContractIdentifier());
				
				tmTrans.setReqSn(entitlementBySnRequest.getSerialNumber());
				tmTrans.setReqProductId(entitlementBySnRequest.getProductID());

		
	}



		private static void processRequest(	EntitlementByPnRequest entitlementByPnRequest, TmTransaction tmTrans) {
			if ((entitlementByPnRequest.getContractIdentifierType() != null)&& (entitlementByPnRequest.getContractIdentifierType().toString() != null)&& (!"".equals(entitlementByPnRequest.getContractIdentifierType().toString().trim())))
				tmTrans.setReqContractIdType(entitlementByPnRequest.getContractIdentifierType().toString());

			 tmTrans.setReqDataEntrySite(entitlementByPnRequest.getDataEntrySite());
			 tmTrans.setReqSourceCustomerId(entitlementByPnRequest.getSourceCustomerID());
			 tmTrans.setReqRedAccessId(entitlementByPnRequest.getRedAccessID());
			 tmTrans.setReqActiveContractsOnly(entitlementByPnRequest.getActiveContractsOnly());
			 tmTrans.setReqActiveServicesOnly(entitlementByPnRequest.getActiveServicesOnly());
			 tmTrans.setReqIncludeAddress(entitlementByPnRequest.getIncludeAddresses());
			 tmTrans.setReqIncludeContracts(entitlementByPnRequest.getIncludeContracts());
			 tmTrans.setReqIncludeOffers(entitlementByPnRequest.getIncludeOffers());

			 tmTrans.setReqIncludeDeliverables(entitlementByPnRequest.getIncludeDeliverables());

			 tmTrans.setReqIncludeModifiers(entitlementByPnRequest.getIncludeModifiers());

			 tmTrans.setReqIncludeWorkings(entitlementByPnRequest.getIncludeWorkings());

			 tmTrans.setReqIncludeWarranty(entitlementByPnRequest.getIncludeWarranty());

			 tmTrans.setReqIncludeContacts(entitlementByPnRequest.getIncludeContacts());

			 tmTrans.setReqIncludeServiceNote(entitlementByPnRequest.getIncludeServiceNotes());

			 tmTrans.setReqIncludeUniqueOffers(entitlementByPnRequest.getIncludeUniqueOffers());

			 tmTrans.setReqIncludeUniqueDeliver(entitlementByPnRequest.getIncludeUniqueDeliverables());

			 tmTrans.setReqIncludeOoses(entitlementByPnRequest.getIncludeOOSes());

			 tmTrans.setReqStandaloneOffersOnly(entitlementByPnRequest.getStandAloneOffersOnly());

			 tmTrans.setReqIncludeSoftwareLevelCatrgory(entitlementByPnRequest.getIncludeSoftwareServiceLevelCategory());

			 tmTrans.setReqIncludeSpecialInstructions(entitlementByPnRequest.getIncludeSpecialInstructions());

			 tmTrans.setReqIncludeCustomerIndicator(entitlementByPnRequest.getIncludeCustomerIndicator());

			 tmTrans.setReqActiveWarrantyOnly(entitlementByPnRequest.getActiveWarrantyOnly());

			 tmTrans.setReqConsumerBusinessLogicNeeded(entitlementByPnRequest.getConsumerBusinessLogicNeeded());
			if (entitlementByPnRequest.getEntitlementCheckDate() != null) {
				 tmTrans.setReqEntitleCheckDate(entitlementByPnRequest.getEntitlementCheckDate().toLong());
			}
			if ((entitlementByPnRequest.getIsoCountryCd() != null)&& (!"".equals(entitlementByPnRequest.getIsoCountryCd()))) {
			 tmTrans.setReqCountryCode(entitlementByPnRequest.getIsoCountryCd());
			}
			 tmTrans.setReqMnContractSourceDoc(entitlementByPnRequest.getMNContractSourceDoc());
			 tmTrans.setReqRedGroupSn(entitlementByPnRequest.getRedGroupSerialNo());
			if (entitlementByPnRequest.getProofPurchaseDate() != null) {
			 tmTrans.setReqProofPurchaseDate(entitlementByPnRequest.getProofPurchaseDate().toLong());
			 tmTrans.setReqServiceId(entitlementByPnRequest.getServiceID());
			 tmTrans.setReqMarketSegment(entitlementByPnRequest.getMarketSegment());
			 tmTrans.setReqGeoCode(entitlementByPnRequest.getGeoCode());
			if ((entitlementByPnRequest.getContractIdentifier() != null)&& (!"".equals(entitlementByPnRequest.getContractIdentifier()))) {
			 tmTrans.setReqContractId(entitlementByPnRequest.getContractIdentifier());
			}
			 tmTrans.setReqProductId(entitlementByPnRequest.getProductID());
			}
			if ((entitlementByPnRequest.getCustomerDefinedID() != null)&& (!"".equals(entitlementByPnRequest.getCustomerDefinedID()))) {
			 tmTrans.setReqCustomerDefinedId(entitlementByPnRequest.getCustomerDefinedID());
			}
		
	}



		private static void processRequest(ContractSummaryRequest contractSummaryRequest, TmTransaction tmTrans) {
			tmTrans.setReqIncludeAddress(contractSummaryRequest
					.getIncludeAddresses());
			tmTrans.setReqIncludeContacts(contractSummaryRequest.getIncludeContacts());
			tmTrans.setReqIncludeOffers(contractSummaryRequest.getIncludeOffers());
			tmTrans.setReqIncludeDeliverables(contractSummaryRequest.getIncludeDeliverables());
			tmTrans
					.setReqIncludeSoftwareLevelCatrgory(contractSummaryRequest
							.getIncludeSoftwareServiceLevelCategory());
			tmTrans
					.setReqIncludeCustomerIndicator(contractSummaryRequest
							.getIncludeCustomerIndicator());
			tmTrans
					.setReqIncludeFounctionalLocation(contractSummaryRequest
							.getIncludeFunctionalLocation());
			tmTrans.setReqIncludeWorkings(contractSummaryRequest
					.getIncludeWorkings());
			tmTrans
					.setReqActiveContractsOnly(contractSummaryRequest
							.getActiveContractsOnly());
			tmTrans
					.setReqServiceAbleProductsOnly(contractSummaryRequest
							.getServiceableProductsOnly());
			tmTrans.setReqSvcAgreementId(contractSummaryRequest.getSvcAgreementID());
			if(contractSummaryRequest.getProductType() != null) {
				tmTrans.setReqProductType(contractSummaryRequest.getProductType().toString());
			}
			if (contractSummaryRequest.getEntitlementCheckDate() != null) {
				tmTrans
						.setReqEntitleCheckDate(contractSummaryRequest
								.getEntitlementCheckDate().toLong());
			}
			if (contractSummaryRequest
					.getServiceableProductsOfferList() != null) {
				if (contractSummaryRequest
						.getServiceableProductsOfferList()
						.getOfferCode().length > 0) {
					tmTrans.setReqOfferCode(contractSummaryRequest
							.getServiceableProductsOfferList()
							.getOfferCode(0));
				}
			}
				ESLog
						.debug("Processing request type getContractSummary end!");
		
	}



		private static void processRequest(ContractRequest contractRequest, TmTransaction tmTrans) {
			if ((contractRequest.getContractIdentifierType() != null)
					&& (contractRequest.getContractIdentifierType()
							.toString() != null)
					&& (!""
							.equals(contractRequest
									.getContractIdentifierType()
									.toString()))) {
		
				tmTrans.setReqContractIdType(contractRequest
						.getContractIdentifierType().toString());
			}

			tmTrans.setReqDataEntrySite(contractRequest.getDataEntrySite());
			tmTrans.setReqSourceCustomerId(contractRequest.getSourceCustomerID());
			tmTrans.setReqRedAccessId(contractRequest.getRedAccessID());
			tmTrans.setReqActiveContractsOnly(contractRequest.getActiveContractsOnly());
			tmTrans.setReqActiveServicesOnly(contractRequest.getActiveServicesOnly());
			tmTrans.setReqIncludeAddress(contractRequest.getIncludeAddresses());
			tmTrans.setReqIncludeContacts(contractRequest.getIncludeContacts());
			tmTrans.setReqIncludeOffers(contractRequest.getIncludeOffers());
			tmTrans.setReqIncludeDeliverables(contractRequest.getIncludeDeliverables());
			tmTrans.setReqIncludeModifiers(contractRequest.getIncludeModifiers());
			tmTrans.setReqIncludeWorkings(contractRequest.getIncludeWorkings());
			if (contractRequest.getEntitlementCheckDate() != null) {
				tmTrans.setReqEntitleCheckDate(contractRequest
						.getEntitlementCheckDate().toLong());
			}
			tmTrans.setReqCountryCode(contractRequest.getIsoCountryCd());
			tmTrans.setReqMnContractSourceDoc(contractRequest.getMNContractSourceDoc());
			tmTrans.setReqRedGroupSn(contractRequest.getRedGroupSerialNo());
			tmTrans.setReqContractId(contractRequest.getContractIdentifier());
			tmTrans.setReqProductId(contractRequest.getProductID());
			tmTrans.setReqIncludeUniqueOffers(contractRequest.getIncludeUniqueOffers());
			tmTrans.setReqIncludeUniqueDeliver(contractRequest.getIncludeUniqueDeliverables());
			tmTrans.setReqIncludeOoses(contractRequest.getIncludeOOSes());
			tmTrans.setReqIncludeSoftwareLevelCatrgory(contractRequest.getIncludeSoftwareServiceLevelCategory());
			tmTrans.setReqIncludeSpecialInstructions(contractRequest.getIncludeSpecialInstructions());
			tmTrans.setReqIncludeCustomerIndicator(contractRequest.getIncludeCustomerIndicator());
			tmTrans.setReqStandaloneOffersOnly(contractRequest.getStandAloneOffersOnly());
			tmTrans.setReqCustomerDefinedId(contractRequest.getCustomerDefinedID());
		
		}


	private static void processRequest(AssociatedContractsRequest associatedContractsRequest,TmTransaction tmTrans) {
		if ((associatedContractsRequest.getAssociatedContractIdentifierType() != null)
				&& (!"".equals(associatedContractsRequest.getAssociatedContractIdentifierType().toString()))) 
			tmTrans.setReqAssociateCidType(associatedContractsRequest.getAssociatedContractIdentifierType().toString());

		if ((associatedContractsRequest.getAssociatedContractIdentifier() != null)
				&& (!"".equals(associatedContractsRequest.getAssociatedContractIdentifier()))) 
				tmTrans.setReqAssociateCid(associatedContractsRequest.getAssociatedContractIdentifier());
		
		if ((associatedContractsRequest.getIsoCountryCd() != null)&& (!"".equals(associatedContractsRequest.getIsoCountryCd()))) 
				tmTrans.setReqCountryCode(associatedContractsRequest.getIsoCountryCd());
		
		if (associatedContractsRequest.getPersonID()!= null 
				&& associatedContractsRequest.getPersonID().length > 0) 
			tmTrans.setReqPersonId(associatedContractsRequest.getPersonID(0));
		
		tmTrans.setReqActiveContractsOnly(associatedContractsRequest.getActiveContractsOnly());
		tmTrans.setReqChunkSize(associatedContractsRequest.getChunkSize());
		tmTrans.setReqChunkPosition(associatedContractsRequest.getChunkPosition());
	}




	

}
