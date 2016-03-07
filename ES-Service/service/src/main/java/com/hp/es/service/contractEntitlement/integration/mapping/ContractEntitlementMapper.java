package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.TreeMap;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.Deliverable;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.UniqueDeliverable;
import com.hp.es.xml.service.UniqueOffer;
import com.hp.sif.SifException;

public abstract class ContractEntitlementMapper {

    protected ContractTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
	protected EsRequestComplexType _request;
    protected EsReplyContext _ctx;

	public ContractEntitlementMapper(ContractTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
    	_transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
        _request = request;
        _ctx = ctx;
    }	
    
	public abstract ContractEntitlementComplexType map() throws MappingException, SifException;
    
//  The following methods were coppied from EsReplyContext() and adapted for CQS
    
    /**
     * Assign UniqueDeliverables and/or uniqueOffers to the Contracts.
     * This method uses the mapped contract in order to generate the unique offers / deliverables
     * 
     */
    protected void createUniqueOffersAndDeliverables(boolean calculateUniqueDeliverables, 
    		ContractEntitlementComplexType result ) {
    	org.exolab.castor.types.Date date = null;
        // iterate over all contracts that already have the offers assigned
    	for (int itContract=0; itContract < result.getContractCount(); itContract++ ) {
    		ESLog.debug("Map Unique Offers for Contract " + result.getContract(itContract).getSvcAgreementID());
            ContractComplexType contract = (ContractComplexType)result.getContract(itContract);
            Enumeration allOffersEnum = contract.enumerateOffer(); 
            if (allOffersEnum!=null) {
            	ESLog.debug("Created enumeration for offers");
                TreeMap uniqueOffers = new TreeMap();
                TreeMap uniqueDeliverablesForOfferCode = new TreeMap();

                while (allOffersEnum.hasMoreElements()) {
                	OfferComplexType offer = (OfferComplexType)allOffersEnum.nextElement();
                    ESLog.debug("... check offer code " + offer.getOfferCode());
                    UniqueOffer tmp = (UniqueOffer)uniqueOffers.get(offer.getOfferCode());
                    if (tmp==null) {
                        // it is the first offer for that offer code
                    	ESLog.debug("... Unique Offer " + offer.getOfferCode());
                        tmp = new UniqueOffer();
                        tmp.setOfferCode(offer.getOfferCode());
                        tmp.setOfferDescription(offer.getOfferDescription());
                        tmp.setSvcProductType(offer.getSvcProductType());
                        tmp.setServiceStartDate(getServiceStartDate(null, offer));
                        tmp.setServiceEndDate(getServiceEndDate(null, offer));
                        uniqueOffers.put(offer.getOfferCode(), tmp);
                    }
                    else {
                        // take the existin unique offer and update the dates
                        tmp.setServiceStartDate(getServiceStartDate(tmp, offer));
                        tmp.setServiceEndDate(getServiceEndDate(tmp, offer));
                    }

                    // now create the unique deliverables for the offer code
                    if (calculateUniqueDeliverables) {
                        TreeMap uniqueDeliverables = (TreeMap)
                            uniqueDeliverablesForOfferCode.get(offer.getOfferCode());
                        if (uniqueDeliverables==null) {
                        	uniqueDeliverables = new TreeMap();
                            uniqueDeliverablesForOfferCode.put(offer.getOfferCode(),
                                                               uniqueDeliverables);
                        }

                        Enumeration delivEnum = offer.enumerateDeliverable();
                        while (delivEnum.hasMoreElements()) {
                            Deliverable deliv = (Deliverable)delivEnum.nextElement();
                            UniqueDeliverable ud = (UniqueDeliverable)
                                        uniqueDeliverables.get(deliv.getDelivCode());
                            if (ud==null) {
                            	ESLog.debug("... Unique Deliverable " + deliv.getDelivCode());
                                ud = new UniqueDeliverable();
                                // not set according to definition in SRS
                                // ud.setAvailableQuantity(d.getAvailableQuantity());
                                ud.setDelivCode(deliv.getDelivCode());
                                ud.setDelivName(deliv.getDelivName());
                                ud.setDelivValue(deliv.getDelivValue());
                                uniqueDeliverables.put(ud.getDelivCode(), ud);
                            }
                        }
                    }
                }

                // now put the unique offeres and deliverables into the contract
                for (Iterator itUo=uniqueOffers.values().iterator(); itUo.hasNext();) {
                    UniqueOffer uniqueOffer = (UniqueOffer)itUo.next();
                    TreeMap uniqueDeliverables = (TreeMap)
                            uniqueDeliverablesForOfferCode.get(uniqueOffer.getOfferCode());
                    if (uniqueDeliverables!=null) {
                        for (Iterator itUd=uniqueDeliverables.values().iterator(); itUd.hasNext();) {
                        	uniqueOffer.addUniqueDeliverable((UniqueDeliverable)itUd.next());
                        }
                    }
                    contract.addUniqueOffer(uniqueOffer);
                }
            }
        }
    }
    
    /**
     * @return the earlies service start date from all AppliesTo from the
     * offer or from the given unique offer object
     */
    private org.exolab.castor.types.Date getServiceStartDate(
                        UniqueOffer uniqueOffer, OfferComplexType offer) {
        org.exolab.castor.types.Date date = null;
        // find the earlies start date from all appliesTo of this offer
        if (offer!=null && offer.enumerateAppliesTo()!=null) {
            Enumeration enumeration = offer.enumerateAppliesTo();
            while (enumeration.hasMoreElements()) {
                AppliesTo a = (AppliesTo)enumeration.nextElement();
                if (a.getStartDate()!=null) {
                    if (date==null || date.compareTo(a.getStartDate())==
                                    org.exolab.castor.types.DateTimeBase.GREATER_THAN) {
                        date = a.getStartDate();
                    }
                }
            }
        }

        if (uniqueOffer!=null) {
            return minDate(date, uniqueOffer.getServiceStartDate());
        }
        return date;
    }
    
    /**
     * @return the latest service end date from all AppliesTo from the
     * offer or from the given unique offer object
     */
    private org.exolab.castor.types.Date getServiceEndDate(
                        UniqueOffer uniqueOffer, OfferComplexType offer) {
        org.exolab.castor.types.Date date = null;
        // find the earlies end date from all appliesTo of this offer
        if (offer!=null && offer.enumerateAppliesTo()!=null) {
            Enumeration enumeration = offer.enumerateAppliesTo();
            while (enumeration.hasMoreElements()) {
                AppliesTo a = (AppliesTo)enumeration.nextElement();
                if (a.getEndDate()!=null) {
                    if (date==null || date.compareTo(a.getEndDate())==
                                    org.exolab.castor.types.DateTimeBase.LESS_THAN) {
                        date = a.getEndDate();
                    }
                }
            }
        }

        if (uniqueOffer!=null) {
            return maxDate(date, uniqueOffer.getServiceEndDate());
        }
        return date;
    }
    private org.exolab.castor.types.Date minDate(
            org.exolab.castor.types.Date date1, org.exolab.castor.types.Date date2) {
       if (date1==null) {
       		return date2;
       }
       if (date2==null) {
       		return date1;
       }
       if (date1.compareTo(date2)==org.exolab.castor.types.DateTimeBase.LESS_THAN) {
       	   return date1;
       }
       return date2;
    }
    /**
    *
    * @param date1
    * @param date2
    * @return null if date1 or date2 is null; otherwise return the max
    *               of both dates
    */
   private org.exolab.castor.types.Date maxDate(
       org.exolab.castor.types.Date date1, org.exolab.castor.types.Date date2) {
       if (date1==null || date2==null) {
           return null;
       }
       if (date1.compareTo(date2)==org.exolab.castor.types.DateTimeBase.GREATER_THAN) {
           return date1;
       }
       return date2;
   }

    static public ContractEntitlementMapper getInstance(ContractTransaction transaction, EsRequestComplexType request) {

            return new MetroContractEntitlementMapper(transaction, request, null);

        
    }    
}
