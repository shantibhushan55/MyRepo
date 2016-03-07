/*
 * BatchReplyMapper
 * Created on 2 dec. 2004
 *
 * Entitlement Service Project
 * This the batch reply mapping calss
 */
package com.hp.es.service.batchEntitlement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exolab.castor.types.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.xml.batchEntitlement.EntitlementItem;
import com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType;
import com.hp.es.xml.batchEntitlement.InputParameter;
import com.hp.es.xml.batchEntitlement.OfferSummaryComplexType;
import com.hp.es.xml.batchEntitlement.types.EntitlementStatusType;
import com.hp.es.xml.batchEntitlement.types.PartialResultFlagType;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.ModifierComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ServiceItem;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.es.xml.service.types.WarrantyTypeType;
import com.hp.sif.SifException;
/**
 * @author anvoi
 * The batch reply mapper, map reply from ES service into the batch schema. Only EntitlementItemComplexType is being mapped as else it will take too much time
 *
 */
public class BatchReplyMapper {
    
    private static BatchReplyMapper _instance = new BatchReplyMapper();
    
    /*
     * Constructor
     */
    private BatchReplyMapper() {
        
    }
    
    /*
     * singleton method
     * @return singleton for this class
     */
    public static BatchReplyMapper getInstance() {

        return _instance;
    }
  
    
    /*
     * mapEsReplytoEntitlementItem for an EsReply
     */    
    public String createReplyForInternalError() {
       String xmlReply=null;
       xmlReply= "<EntitlementItem>\n" + 
			       "    <InputParameter>\n" + 
			       "        <IsoCountryCd>??</IsoCountryCd>\n" + 
			       "        <SerialNumber>??</SerialNumber>\n" + 
			       "        <ProductID>??</ProductID>\n" + 
			       "        <CheckDate>??</CheckDate>\n" + 
			       "    </InputParameter>\n" + 
			       "    <EntitlementStatus>E</EntitlementStatus>\n" + 
			       "    <PartialResultFlag></PartialResultFlag>\n" + 
			       "    <EntitlementSummary/>\n" + 
			       "</EntitlementItem>\n";
       return xmlReply;
    }
    
    public String createCsvReplyForInternalError(){
    	return "\"??\",\"??\",\"??\",\"??\",E,null,,,,,,,,,,,,,,0,,,,,,,,,,,,,,,,,,,,,";
    }

    /*
     * mapEsReplytoEntitlementItem for an EsReply
     * @param SubRequest
     */    
    public void createReplyForInternalError(SubRequest sr,String xmlReply,String csvReply) {
        String isoCountryCode = sr.getIsoCountryCode();
        String serialNumber = sr.getSerialNumber();
        String productId = sr.getProductId();
        String checkDate = sr.getCheckDate();

        EntitlementItem batchReply = new EntitlementItem();

        ESLog.debug("Enter - SubRequest=" + sr.toString());

        /*
         * We are going to replace mandatory paramaters by ??
         */
	    if(isoCountryCode == null || isoCountryCode.trim().length()==0 ) {
	        isoCountryCode="??";
	    }
        
	    if( serialNumber == null || serialNumber.trim().length()==0){
	        serialNumber="??";
	        
	    }
	    
        batchReply.setInputParameter(createInputParameter(isoCountryCode,
                serialNumber, productId, checkDate));
        batchReply.setEntitlementStatus(EntitlementStatusType.E);
        batchReply.setEntitlementSummary(null);

        /*
         * We need to map the error id
         */
        batchReply.setPartialResultFlag(PartialResultFlagType.N);
        try {
            xmlReply = MarshalHelper.marshal(batchReply, null);
            csvReply=BatchxmlConverter.getInstance().marshalToCSV(batchReply);
        } catch (SifException e) {
            ESLog.error("SifException raise while createReplyForInternalError",e);
            xmlReply = createReplyForInternalError();
            csvReply=createCsvReplyForInternalError();
        }
        ESLog.debug("Exit");
        //return xmlReply;
    }    
    
    
    /*
     * mapEsReplytoEntitlementItem for an EsReply
     * @param reply the reply
     * @param the SubRequest Object
     */
    EntitlementItem mapEsReplytoEntitlementItem(EsReply reply, SubRequest sr) throws MapperException{
        if((reply == null) || (sr==null)||(!reply.getEsHeader().getInputRequest().getOperation().equalsIgnoreCase("getEntitlementBySn"))) {
            ESLog.info("Some parameters used are null or Mapper is used with incorrect reply type, cannot continue, an exception will be generated");
            throw new MapperException("BatchReplyMapper should be used with getEntitlementBySn reply only.");
        }
        ESLog.debug("Enter - SubRequest="+ sr.toString());
        EntitlementItem batchReply=  new EntitlementItem();
        String isoCountryCode=sr.getIsoCountryCode();
		String serialNumber=sr.getSerialNumber();
		String productId= sr.getProductId();
		String checkDate = sr.getCheckDate();
		boolean includeOffer =sr.isIncludeOffers();
		boolean includeContract = sr.isIncludeContracts();
        
        batchReply.setInputParameter(createInputParameter(isoCountryCode,serialNumber,productId,checkDate));
        batchReply.setEntitlementStatus(createEntitlementStatus(reply));
        batchReply.setPartialResultFlag(createEntitlementPartialResultFlag(reply));
        
        //we are now going to map EnitlementSummary and OfferSummary
        //Id this is a UNIT list, we can end here.
        
        if(reply.getEsReplyChoice().getUnitList() == null && reply.getEsReplyChoice().getCombinedUnitEntitlement()!=null) {
            ESLog.debug("This reply is containg a CombinedUnitEntitlement structure, we ill generate EntitlementSummary");
            batchReply.setEntitlementSummary(createEntitlementSummary(reply.getEsReplyChoice().getCombinedUnitEntitlement(),includeOffer,includeContract));
        }
        
        ESLog.debug("Mapping is finished, returning EntitlementItem object");
        return batchReply;
    }
    
    /*
     * mapEsReplytoEntitlementItem for an SifException
     * @param SifException received
     * @param a SubRequest object
     */    
    EntitlementItem mapEsReplytoEntitlementItem(SifException eReply,SubRequest sr) throws MapperException{

        
        if (eReply==null || sr == null) {
            ESLog.info("This reply is containg a CombinedUnitEntitlement structure, we ill generate EntitlementSummary");
            throw new MapperException("reply cannot be a null object");
        }
		String isoCountryCode=sr.getIsoCountryCode();
		String serialNumber=sr.getSerialNumber();
		String productId= sr.getProductId();
		String checkDate = sr.getCheckDate();

        
        EntitlementItem batchReply =  new EntitlementItem();
        
        ESLog.debug("Entering mapEsReplytoEntitlementItem with an SifException"+ eReply.getMessage()+" for SubRequest"+ sr.toString());        
        
        batchReply.setInputParameter(createInputParameter(isoCountryCode,serialNumber,productId,checkDate));
        batchReply.setEntitlementStatus(EntitlementStatusType.E);
        batchReply.setEntitlementSummary(null);
        
        /*
         * We need to map the error id
         */
        batchReply.setPartialResultFlag(getPartialResultFlagType(eReply.getErrorID()));
        ESLog.debug("Mapping is finished, returning EntitlementItem object");
        
        return batchReply;
    }   

    
    
    /*
     * create The inputParameters object from the input parameters
     * @param isoCountryCode
     * @param serialNumber
     * @param productId
     */
    private InputParameter createInputParameter(String isoCountryCode,String serialNumber, String productId, String checkDate) {
        InputParameter ip = new InputParameter();
        ip.setIsoCountryCd(isoCountryCode);
        ip.setSerialNumber(serialNumber);
        ip.setProductID(productId);
        if(checkDate != null && !"".equals(checkDate.trim())) {
        	try {
        		ip.setCheckDate(new Date(new SimpleDateFormat("dd-MM-yyyy").parse(checkDate)));
        	} catch (ParseException e) {
        		ESLog.error("Wrong date format of Check Date in SubRequest");
        	}
        }
        return ip;
    }
    
    /*
     * create The EntitlementStatus from ES
     * @param EsReply reply
     */
    private EntitlementStatusType createEntitlementStatus(EsReply reply) {
        EntitlementStatusType iStatusType = null;
        if(reply.getEsReplyChoice().getUnitList() != null) { //If we get a Unit List, so we return "m"
            iStatusType=EntitlementStatusType.M;
        }else {//If we get a valid reply, we return "S", error is handle in a separate function
            iStatusType=EntitlementStatusType.S;
        }
        return iStatusType;
    }

    /*
     * create The EntitlementStatus from ES
     * @param EsReply reply
     * @throws MapperException if a problem occur when mapping.
     */
    private PartialResultFlagType createEntitlementPartialResultFlag(EsReply reply) throws MapperException{
        PartialResultFlagType partialResultFlagType = null;
        ESLog.debug("Enter");
        if(reply.getEsHeader().getWarnings() == null) {
            ESLog.debug("There is no warning, so partialResultFlag will be set to N");
            //No Warning, so that's N
            partialResultFlagType= PartialResultFlagType.N;
        }else {
            ESLog.debug("It will navigate through the warning and ");
            Enumeration<?> e = reply.getEsHeader().getWarnings().enumerateEIAError();
            while(e.hasMoreElements()) {
                EIAError error= (EIAError) e.nextElement();
                partialResultFlagType= getPartialResultFlagType(error.getErrorID());
                if(partialResultFlagType.equals(PartialResultFlagType.Y)) {
                    ESLog.debug("There was a warning with an error Id generating partial result flag");
                    break;
                }
            }
           
            if(partialResultFlagType== null) {
                ESLog.debug("There was no warning with an error Id generating partial result flag");
                partialResultFlagType= PartialResultFlagType.N;
            }
        }
        
        return partialResultFlagType;
    }
    
    /*
     * @param CombinedUnitEntitlementComplexType the combined unit entitlement
     * @param boolean set to true if offers are included
     * @return EntitlementSummaryComplexType 
     * @throws MapperException
     */
    private EntitlementSummaryComplexType createEntitlementSummary(CombinedUnitEntitlementComplexType reply, boolean includeOffer, boolean includeContract) throws MapperException {
        EntitlementSummaryComplexType eSummary = new EntitlementSummaryComplexType();

        ESLog.debug("Enter");
        /*
         * We first have to check if the reply was including OOS
         */
        if(reply.getOOS() != null) {
            ESLog.debug("This Combined unit Entitlement Object is including OOS, OOS information will be mapped");
            // We are assuming we will have only one serial Number and one product number
            // This was said by Philippe
            eSummary.setSerialNumber(reply.getOOS().getSerialNumber(0));
            eSummary.setSalesOrderNumber(reply.getOOS().getSalesOrderNumber());
            
            if(reply.getOOS().getProduct() != null) {               
                eSummary.setProductId(reply.getOOS().getProduct().getProductID());
                eSummary.setProductDescription(reply.getOOS().getProduct().getProductDescription());
                eSummary.setShipToCountry(reply.getOOS().getShipToCountry());
            }
            
            
        }
        
        /*
         * Mapping other information
         */
        
        /*
         * Contract is only mapped if contract is included
         */
        if(includeContract) {
	        eSummary.setActiveContractEntitlement(reply.getActiveContractEntitlement());
	        eSummary.setOverallContractStartDate(reply.getOverallContractStartDate());
	        eSummary.setOverallContractEndDate(reply.getOverallContractEndDate());
        }
        
        eSummary.setActiveWarrantyEntitlement(reply.getActiveWarrantyEntitlement());
        eSummary.setOverallWarrantyStartDate(reply.getOverallWarrantyStartDate());
        eSummary.setOverallWarrantyEndDate(reply.getOverallWarrantyEndDate());
        
        /*
         * We map warranty information
         * If warranty is not null
         */
        if(reply.getWarranty() != null) {
            ESLog.debug("This Combined unit Entitlement Object is having warranty");
            for(int cptWarranty=0;cptWarranty<reply.getWarrantyCount();cptWarranty++) {
                WarrantyComplexType war= reply.getWarranty(cptWarranty);
                if(war.getWarrantyType().equals(WarrantyTypeType.FR)) {
                    ESLog.debug("Mapping FR warranty information");
                    eSummary.setWarrantyDeterminationDescription(war.getWarrantyDeterminationDescription());
                    eSummary.setGracePeriod(war.getGracePeriod());
                    eSummary.setWarrantyExtension(war.getWarrantyExtension());
                    eSummary.setFactoryWarrantyPortfolioFlag(com.hp.es.xml.batchEntitlement.types.FactoryWarrantyPortfolioFlagType.valueOf(war.getPortfolioFlag().toString()));
                    eSummary.setFactoryWarrantyTermCode(war.getTermCode());
                    eSummary.setWarrantyComment(war.getWarrantyComment());

                    //Since ES 8.2.4, elements FactoryWarrantyStartDate and FactoryWarrantyEndDate are added into EntitlementSummary.
                    //They will be mapped when the request was including offers and WarrantyType is "FR".
                    if (includeOffer) {
                        Date earliestStartDate = null;
                        Date latestEndDate = null;
                        for (int cptOffer = 0; cptOffer < war.getOfferCount(); cptOffer++) {
                            OfferComplexType offer = war.getOffer(cptOffer);
                            for (int cptAppliesTo = 0; cptAppliesTo < offer.getAppliesToCount(); cptAppliesTo++) {
                                AppliesTo appliesTo = offer.getAppliesTo(cptAppliesTo);
                                //get earliestStartDate
                                if (earliestStartDate == null)
                                    earliestStartDate = appliesTo.getStartDate();
                                else if (appliesTo.getStartDate() != null
                                        && appliesTo.getStartDate().compareTo(earliestStartDate) == Date.LESS_THAN)
                                    earliestStartDate = appliesTo.getStartDate();
                                //get latestEndDate
                                if (latestEndDate == null)
                                    latestEndDate = appliesTo.getEndDate();
                                else if (appliesTo.getEndDate() != null
                                        && appliesTo.getEndDate().compareTo(latestEndDate) == Date.GREATER_THAN)
                                    latestEndDate = appliesTo.getEndDate();
                            }
                        }

                        if (earliestStartDate != null)
                            eSummary.setFactoryWarrantyStartDate(earliestStartDate);
                        if (latestEndDate != null)
                            eSummary.setFactoryWarrantyEndDate(latestEndDate);
                    }

                }
                if(war.getWarrantyType().equals(WarrantyTypeType.BW)) {
                    ESLog.debug("Mapping BW warranty information");
                    eSummary.setBundledWarrantyPortfolioFlag(com.hp.es.xml.batchEntitlement.types.BundledWarrantyPortfolioFlagType.valueOf(war.getPortfolioFlag().toString()));
                    eSummary.setBundledWarrantyTermCode(war.getTermCode());
                }                
            }
        }
        
        
        /*
         * We now need to map offer summary
         * only if offer is included
         */
        if(includeOffer) {
            /*
             * We create this local variable for smooth debugging
             */
            ESLog.debug("The request was including offers, they will be mapped");
            OfferSummaryComplexType[] summary= createOfferSummaryComplexTypeArray(reply,includeContract);
            if (summary != null)
                ESLog.debug("There is "+ summary.length + " OfferSummaty to add");

            eSummary.setOfferSummary(summary);
        }        
        
        // Map Shipment Date For Batch Output Request
        WorkingComplexType[] workings = reply.getWorking();
        if(workings != null && workings.length > 1) {
        	for(WorkingComplexType working : workings) {
        		if(working.getWorkingName().equalsIgnoreCase(EsConstants.WORKING_NAME_SWOP_SHIPMENT_DATE)) {
        			if(working.getWorkingValue() != null && !working.getWorkingValue().equals("")) {
        				try {
        					eSummary.setShipmentDate(new Date(working.getWorkingValue()));
        				} catch (ParseException e) {
        					ESLog.error("Invalid date format for Shipment date : " + working.getWorkingValue() + ". The valid format should be yyyy-MM-dd");
        				}
        			}
        			break;
        		}
        	}
        }
        
        return eSummary;
    }
    
    
    /*
     * This method creates an array of OfferSummaryComplexType
     * @param CombinedUnitEntitlementComplexType
     * @return OfferSummaryComplexType[]
     * @throws MapperException
     */
    private OfferSummaryComplexType[] createOfferSummaryComplexTypeArray(CombinedUnitEntitlementComplexType reply, boolean includeContract) throws MapperException{
        OfferSummaryComplexType[] osct = null;
        ArrayList<OfferSummaryComplexType> offerList = new ArrayList<OfferSummaryComplexType>();
        ESLog.debug("Enter");
        /*
         * Based on SRS, we create OfferSummary when 
         * 1.	Contract offers which do not describe a package support.
           2.	All bundled warranty offers.
           3.	All factory warranty offers.
         */
        
        /*
         * If there is no Contract and no warranty, we can stop here
         */
        if(reply.getContract()== null && reply.getWarranty()== null) {
            ESLog.info("There is no Contract and no warranty, cannot continue.");
            //we return NULL in that case
            throw new MapperException("Cannot create OfferSummary if warranty and contract are null");
        }
        
        
        /*
         * we will parse contract first
         * only if contract are requested
         */
        if((includeContract )&& (reply.getContract() != null)) {
            // The first thing that we do is that we build a HashMap that contains associated offer
            // and a hashmap that give the contract header for an offer
            // we will use it after to search onbligation header
            ESLog.debug("This CombinedUnitEntitlementComplexType contains contract, let's map contract offer");

            HashMap<OfferComplexType, ObligationHeader> mapContractHeader= buildContractHeaderHashMap(reply);
            
            for(int cptContract=0;cptContract<reply.getContractCount();cptContract++) {
                ContractComplexType contract = reply.getContract(cptContract);
                //If the offer is not having any contract, there is no need to continue
                
                
                if(contract.getOffer() != null) {
                    ESLog.debug("Contract " +cptContract + "contains "+contract.getOfferCount()+"offers");
                    for(int cptOffer=0;cptOffer<contract.getOfferCount();cptOffer++) {
                        
                        OfferComplexType offer = contract.getOffer(cptOffer);
                        
                        OfferSummaryComplexType tmpOffer =createOfferSummary(contract, offer, mapContractHeader);
                        //We only add non null offer
                        if(tmpOffer !=null) {
                            offerList.add(tmpOffer);
                        }
                    }
                }
            }
        } //end of if((includeContract )&& (reply.getContract() != null))
        
        
        
        /*
         * Now that contract is mapped
         * Warranty needs to be mapped
         * Mapping only take all BW and FR
         */
        if(reply.getWarranty() != null) {
            
            ESLog.debug("This CombinedUnitEntitlementComplexType contains warranty, let's map warranty offer");
            //WE ONLY TAKE BW AND fr WARRANTY
            for(int cptWarranty=0;cptWarranty<reply.getWarrantyCount();cptWarranty++) {
                WarrantyComplexType war= reply.getWarranty(cptWarranty);
                
                /*
                 * Checking warranty type
                 */
                if(war.getWarrantyType().equals(WarrantyTypeType.BW) || 
                        war.getWarrantyType().equals(WarrantyTypeType.FR)) {
                    
                    //We then look if there is offer
                    // If there is no offer, no mapping
                    if(war.getOffer() != null) {
                        ESLog.debug("Warranty " +cptWarranty + " of type "+war.getWarrantyType().toString()+" contains "+war.getOfferCount()+" offers");    
                        
                        for(int cptOffer=0;cptOffer<war.getOfferCount();cptOffer++) {
                            OfferComplexType offer = war.getOffer(cptOffer);
                            
                            OfferSummaryComplexType  tmpOffer = createOfferSummary(war, offer);
                            if(tmpOffer !=null) {
                                offerList.add(tmpOffer);
                            }                            
                        }
                    }
                    
                }
            }
            
            
        }// end of if(reply.getWarranty() != null) {
        
        /*
         * Castor need an array of object not an array list
         *  So we need to do an array from the array list
         */
        
        osct = createArrayFromArrayList(offerList); 
        return osct;
    }
    
    
    /*
     * get PartialResultFlagType for a defined error Id
     * @param errorId an integer
     * @return PartialResultFlagType 
     */
    private PartialResultFlagType getPartialResultFlagType(String  strId) throws MapperException {
    	int errorId=0;
    	try {
	        errorId= Integer.parseInt(strId);
	    }catch(NumberFormatException ne) {
	        throw new MapperException("Error Id is not a valid Id.");
	    }
	        	
	    
        return getPartialResultFlagType(errorId);
    }
    /*
     * get PartialResultFlagType for a defined error Id
     * @param errorId an integer
     * @return PartialResultFlagType 
     */
    private PartialResultFlagType getPartialResultFlagType(int errorId) {
	    
        if((errorId== 224) || (errorId== 232) ||(errorId== 233) ||(errorId== 234) ||(errorId== 235) ||(errorId== 400)) {
            return PartialResultFlagType.Y;
            //we found the answer, but we will go until the end of the Enumeration
        }
        return PartialResultFlagType.N;
    }
    
  
    
    /*
     * @param obligation header
     * @return an associated offer
     */
    private OfferComplexType findAssociatedOffer(ObligationHeader header,OfferComplexType offer) {
        //Navigation through header
        // We try to find the offer once we find it we get the associated Item ref 
        // once we have it we search for the associated offer
        //ESLog.debug("Entering findAssociatedOffer with header and offer");
        OfferComplexType associatedOffer=null;
        String associatedItem = null;
        for(int cptServiceItem=0;cptServiceItem < header.getServiceItemCount();cptServiceItem++) {
            
            ServiceItem item = header.getServiceItem(cptServiceItem);
            OfferComplexType offerTmp = (OfferComplexType)item.getOfferRef();
            if(offer.equals(offerTmp)) {
                associatedItem = item.getAssociatedPkgItem();
                //ESLog.debug("Find searched offer in service Item "+ cptServiceItem +" with associated item  "+associatedItem);
                break; //we break 
            }
        }
        if(associatedItem != null) {
            associatedOffer= findAssociatedOfferWithItemId(header,associatedItem);
        }
        
        return associatedOffer;
    }
    
    /*
     * @param obligation header
     * @param associatedItem Id
     * @return an associated offer
     */
    private OfferComplexType findAssociatedOfferWithItemId(ObligationHeader header,String associatedItemId) {
        OfferComplexType associatedOffer = null;
        //ESLog.debug("Entering findAssociatedOffer with header and offer");
        for(int cptServiceItem=0;cptServiceItem < header.getServiceItemCount();cptServiceItem++) {
            
            ServiceItem item = header.getServiceItem(cptServiceItem);
            if(item.getItem().equals(associatedItemId)) {
                //ESLog.debug("Associated item is found, we are getting the offer now");
                associatedOffer = (OfferComplexType)item.getOfferRef();
                break;
            }
        }
        return associatedOffer;
    }
    
    /*
     * 
     * @param reply a reply that contain contract offer
     * @return a Hashmap of header related to an offer
     */
    private HashMap<OfferComplexType, ObligationHeader> buildContractHeaderHashMap(CombinedUnitEntitlementComplexType reply) {
        //Local variables
        ESLog.debug("Enter");
        HashMap<OfferComplexType, ObligationHeader> mapHeader= new HashMap<OfferComplexType, ObligationHeader>();
        
        
        //Navigation through reply
        // Note that reply.getContract is consider not null
        for(int cptContract=0; cptContract< reply.getContractCount(); cptContract++) {
            ContractComplexType contract = reply.getContract(cptContract);
            
            for(int cptHeader =0; cptHeader < contract.getObligationHeaderCount(); cptHeader++) {
                ObligationHeader header = contract.getObligationHeader(cptHeader);
                for(int cptServiceItem=0;cptServiceItem < header.getServiceItemCount();cptServiceItem++) {
                    ServiceItem item = header.getServiceItem(cptServiceItem);
                    OfferComplexType offer = (OfferComplexType)item.getOfferRef();
                    mapHeader.put(offer, header);
                }
            }
        }
        ESLog.debug("Exit");
        return mapHeader;        
    }    
    

    /*
     * create an array of offerSummaryComplexType from an ArrayList Object
     * @param the array list containing OfferSummaryComplexType
     * @return the array of OfferSummaryComplexType
     */
    private OfferSummaryComplexType[]  createArrayFromArrayList(ArrayList<OfferSummaryComplexType> list) {
        OfferSummaryComplexType[] offerArray  = null;
        if(list != null ) {
            offerArray = new OfferSummaryComplexType [list.size()];
	        
	        for(int i=0;i < list.size(); i++) {
	            offerArray[i]=list.get(i); 
	        }
        }
        return offerArray;
        
    }
    
    /*
     * create OfferSummary from an offer
     * @param the contract linked to that offer
     * @param the offer
     * @param the hash map of obligation header
     * @return a OfferSummaryComplexType (that can be null)
     */
    private OfferSummaryComplexType createOfferSummary(ContractComplexType contract, OfferComplexType offer, HashMap<OfferComplexType, ObligationHeader> mapContractHeader ) {
        OfferSummaryComplexType tmpOffer = null;
        
        /*
         * We only map not PS offer
         */
        if(!offer.getSvcProductType().equalsIgnoreCase("PS")) {
            tmpOffer = new OfferSummaryComplexType();
            tmpOffer.setOfferCode(offer.getOfferCode());
            tmpOffer.setOfferDescription(offer.getOfferDescription());
            tmpOffer.setPortfolioFlag(contract.getPortfolioFlag());
            //We need to find the service item with the offer ref that we have here.
            
            //We get the obligation header associated to this offer
            ObligationHeader header= mapContractHeader.get(offer);
            //We assume that all offer are having an obligation header, Schema is enforcing that
            tmpOffer.setObligationType(header.getObligationType());
            tmpOffer.setWarrantyTermCode(null);
            /**
             * 1. The batch entitlement ResponseCommitment element summarizes the response commitment modifiers of the
             * current offer (modifiers below Offer and Offer/Deliverables).
             * 2. The batch entitlement CovWindow element summarizes the COV_WINDOW<X> and COV_WINDOW_ADJUST<X> modifiers
             * of the current offer (modifiers below Offer and Offer/Deliverables).
             */
            List<ModifierComplexType> modifierList = buildModifierList(offer);
            // If there is no modifier, no mapping
            if (modifierList.size() > 0) {
                // Map ResponseCommitment element
                tmpOffer.setResponseCommitment(createResponseCommitment(modifierList));
                // Map COVWINDOW element
                tmpOffer.setCOVWINDOW(createCovWindow(modifierList));
            }
            /*
             * Then the associated offer needs to be found
             */
            OfferComplexType associatedOffer=findAssociatedOffer(header,offer);
            if (associatedOffer != null) {
                tmpOffer.setPackageCode(associatedOffer.getOfferCode());
                tmpOffer.setPackageDescription(associatedOffer.getOfferDescription());
            }
            /*
             * AppliesTo
             * We only take the first one
             */

            if (offer.getAppliesTo(0) != null) {
                tmpOffer.setStartDate(offer.getAppliesTo(0).getStartDate());
                tmpOffer.setEndDate(offer.getAppliesTo(0).getEndDate());
                tmpOffer.setStatus(com.hp.es.xml.batchEntitlement.types.StatusType.valueOf(offer.getAppliesTo(0).getStatus().toString()));
                
            }

            //Since ES 8.2.4, element ContractIDCarepackSN is added into OfferSummary
            String contractIDCareparckSN = createContractIDCarepackSN(contract);
            if (contractIDCareparckSN != null)
                tmpOffer.setContractIDCarepackSN(contractIDCareparckSN);
        }
        return tmpOffer;
    }

    /**
     * Element ContractIDCarepareSN reflects the HP Care Pack Serial Number or the Contract Identifier associated with
     * the offer. Take the first non empty contractCarePack ID in the following order:
     * ContractComplexType.SvcAgreementID | ContractComplexType.HPCarePackSerialNumber |
     * ContractComplexType.RedContractID | ContractComplexType.OOSGroupID | ContractComplexType.CCRN
     *
     * @param contract
     * @param tmpOffer
     * @since ES 8.2.4
     */
    private String createContractIDCarepackSN(ContractComplexType contract) {
        if (contract.getSvcAgreementID() != null)
            return contract.getSvcAgreementID();
        if (contract.getHPCarePackSerialNumber() != null)
            return contract.getHPCarePackSerialNumber();
        if (contract.getRedContractID() != null)
            return contract.getRedContractID();
        if (contract.getOOSGroupID() != null)
            return contract.getOOSGroupID();
        if (contract.getCCRN() != null)
            return contract.getCCRN();
        return null;
    }

    /*
     * create OfferSummary from a warranty offer
     * @param the warranty linked to that offer
     * @param the offer
     * @return a OfferSummaryComplexType (that can be null)
     */
    private OfferSummaryComplexType createOfferSummary(WarrantyComplexType war, OfferComplexType offer) {
        OfferSummaryComplexType tmpOffer = new OfferSummaryComplexType();
        tmpOffer.setOfferCode(offer.getOfferCode());
        tmpOffer.setOfferDescription(offer.getOfferDescription());
        tmpOffer.setPortfolioFlag(war.getPortfolioFlag().toString());
        if(war.getWarrantyType().equals(WarrantyTypeType.FR)) {
            tmpOffer.setObligationType("W");
        }else if(war.getWarrantyType().equals(WarrantyTypeType.BW)) {
            tmpOffer.setObligationType("B");
        }
        tmpOffer.setWarrantyTermCode(war.getTermCode());


        /**
         * 1. The batch entitlement ResponseCommitment element summarizes the response commitment modifiers of the
         * current offer (modifiers below Offer and Offer/Deliverables).
         * 2. The batch entitlement CovWindow element summarizes the COV_WINDOW<X> and COV_WINDOW_ADJUST<X> modifiers
         * of the current offer (modifiers below Offer and Offer/Deliverables).
         */
        List<ModifierComplexType> modifierList = buildModifierList(offer);
        // If there is no modifier, no mapping
        if (modifierList.size() > 0) {
            // Map ResponseCommitment element
            tmpOffer.setResponseCommitment(createResponseCommitment(modifierList));
            // Map COVWINDOW element
            tmpOffer.setCOVWINDOW(createCovWindow(modifierList));
        }


        /*
         * No Package code and package description for warranty
         */
        tmpOffer.setPackageCode(null);
        tmpOffer.setPackageDescription(null);
        
        
        /*
         * AppliesTo
         * We only take the first one
         */
        if (offer.getAppliesTo(0) != null) {
            tmpOffer.setStartDate(offer.getAppliesTo(0).getStartDate());
            tmpOffer.setEndDate(offer.getAppliesTo(0).getEndDate());
            tmpOffer.setStatus(com.hp.es.xml.batchEntitlement.types.StatusType.valueOf(offer.getAppliesTo(0).getStatus().toString()));
        }
        return tmpOffer;
    }

    /**
     * We put all modifiers below Offer and Offer/Deliverables into one List modifierList. It will be used to map both
     * elements.
     *
     * @param offer
     * @return
     */
    private List<ModifierComplexType> buildModifierList(OfferComplexType offer) {
        List<ModifierComplexType> modifierList = new ArrayList<ModifierComplexType>();

        // Add modifiers below Offer into modifierList
        if (offer.getModifier() != null) {
            modifierList.addAll(Arrays.asList(offer.getModifier()));
        }

        // Add modifiers below Offer/Deliverables into modifierList
        if (offer.getDeliverable() != null) {
            for (int cptDeliverable = 0; cptDeliverable < offer.getDeliverableCount(); cptDeliverable++) {
                if (offer.getDeliverable(cptDeliverable).getDelivModifier() != null) {
                    modifierList.addAll(Arrays.asList(offer.getDeliverable(cptDeliverable).getDelivModifier()));
                }
            }
        }
        return modifierList;
    }


    /**
     * Create element ResponseCommitment for OfferSummary.
     * The following type of modifiers are response time commitment modifiers:
     * REPAIR_TIME
     * RESTORATION_TIME
     * RESPONSE_TIME
     * SCH_RESPONSE_TIME
     *
     * @param modifierList composed with ModifierComplexType
     * @return
     * @since ES 8.2.4
     */
    private String createResponseCommitment(List<ModifierComplexType> modifierList) {

        StringBuffer responseCommitment=new StringBuffer();

        for (int i = 0; i < modifierList.size(); i++) {
            ModifierComplexType modifier = modifierList.get(i);
            String modName = modifier.getModName().toUpperCase();
            if (modName.equals("REPAIR_TIME") || modName.equals("RESTORATION_TIME")
                    || modName.equals("RESPONSE_TIME") || modName.equals("SCH_RESPONSE_TIME")) {
                // Multiple responseCommitment is separated by a semicolon.
                if (responseCommitment.length() > 0)
                    responseCommitment.append(";");
                responseCommitment.append(modName).append("-").append(modifier.getModValue());
            }
        }
        return responseCommitment.toString();
    }
    /**
     * Create element COVWINDOW for OfferSummary
     * @param modifierList composed with ModifierComplexType
     * @return
     * @since ES 8.2.4
     */
    private String createCovWindow(List<ModifierComplexType> modifierList) {
        StringBuffer covWindow = new StringBuffer();
        String[] suffixs = { "5", "7", "6D", "7D", "HOL", "SCH" };
        // Put the modifiers started with "COV_WINDOW" into a Map modifiersMap.
        Map<String, String> modifiersMap = new HashMap<String, String>();

        for (int i = 0; i < modifierList.size(); i++) {
            ModifierComplexType modifier = modifierList.get(i);
            String modName = modifier.getModName().toUpperCase();
            if (modName.startsWith("COV_WINDOW"))
                modifiersMap.put(modName, modifier.getModValue());
        }

        for (int i = 0; i < suffixs.length; i++) {
            if (modifiersMap.containsKey("COV_WINDOW" + suffixs[i])) {
                // Multiple COVWINDOW is separated by a semicolon.
                if (covWindow.length() > 0)
                    covWindow.append(";");

                covWindow.append(suffixs[i]).append("-").append(modifiersMap.get("COV_WINDOW" + suffixs[i]));

                //COV_WINDOW_ADJUST<X> modifier is taking in account only if a corresponding COV_WINDOW<X> modifier exists
                if (modifiersMap.containsKey("COV_WINDOW_ADJUST" + suffixs[i]))
                    covWindow.append("-").append(modifiersMap.get("COV_WINDOW_ADJUST" + suffixs[i]));
            }
        }
        return covWindow.toString();
    }
}
