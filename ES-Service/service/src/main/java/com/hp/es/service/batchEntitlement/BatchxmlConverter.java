/*
 * BatchxmlcONVERTER.java
 * Created on 11 janv. 2005
 *
 * Entitlement Service Project
 *
 * Thios class provide method to convert a XML created for a subrequest by the batch into csv lines
 */
package com.hp.es.service.batchEntitlement;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.xml.batchEntitlement.EntitlementItem;
import com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType;
import com.hp.es.xml.batchEntitlement.OfferSummaryComplexType;
import com.hp.sif.SifException;


public class BatchxmlConverter {
    // The singleton
    private static BatchxmlConverter _instance = new BatchxmlConverter();

    private final static String LINESEP = "\r\n";
    private final static String FIELDSEP = ",";
    private final static String DOUBLEQUOTE = "\"";
    // Since ES 8.2.4, FactoryWarrantyStartDate, FactoryWarrantyEndDate, ContractIDCarepareSN, COVWINDOW and
    // ResponseCommitment are added into batch reply.
    final static String FIRSTLINE = "IsoCountryCd,SerialNumberInput,ProductIDInput,CheckDateInput,EntitlementStatus," +
                                    "PartialResultFlag,SerialNumber,ProductID,ProductDescription," +
                                    "ActiveWarrantyEntitlement,OverallWarrantyStartDate," +
                                    "OverallWarrantyEndDate,ActiveContractEntitlement," +
                                    "OverallContractStartDate,OverallContractEndDate," +
                                    "SalesOrderNumber,WarrantyComment,ShipmentDate," +
                                    "WarrantyDeterminationDescription,GracePeriod," +
                                    "WarrantyExtension,FactoryWarrantyPortfolioFlag," +
                                    "FactoryWarrantyTermCode,BundledWarrantyPortfolioFlag," +
                                    "BundledWarrantyTermCode,ShipToCountry,FactoryWarrantyStartDate," +
                                    "FactoryWarrantyEndDate,OfferCode,OfferDescription," +
                                    "PortfolioFlag,ObligationType,WarrantyTermCode," +
                                    "PackageCode,PackageDescription,StartDate,EndDate,Status," +
                                    "ContractIDCarepackSN,COVWINDOW,ResponseCommitment" + LINESEP;

    private static final String BLANKSTRING = "";

    /*
     * Default constructor
     */
    private BatchxmlConverter() {
    }

    /*
     * the getInstance Method
     * @return the instance of this class
     */
    public static BatchxmlConverter getInstance() {
        return _instance;
    }
    
    public String marshalToCSV(EntitlementItem item)
			throws SifException {
		if (item==null){
			 throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Cannot marshal a null-object to csv");
		}
		StringBuffer sbTmp = new StringBuffer();
       sbTmp.append(fixString(item.getInputParameter().getIsoCountryCd()));
       sbTmp.append(FIELDSEP);
       sbTmp.append(fixString(item.getInputParameter().getSerialNumber()));
       sbTmp.append(FIELDSEP);
       sbTmp.append(fixString(item.getInputParameter().getProductID()));
       sbTmp.append(FIELDSEP);
       sbTmp.append(convertNullObjectInBlanckString(item.getInputParameter().getCheckDate()));
       sbTmp.append(FIELDSEP);

       //Then ststus
       //EntitlementStatus,PartialResultFlag,
       sbTmp.append(item.getEntitlementStatus());
       sbTmp.append(FIELDSEP);
       sbTmp.append(item.getPartialResultFlag());
       sbTmp.append(FIELDSEP);


       //Entitlement Summary (Since ES 8.2.4, FactoryWarrantyStartDat and FactoryWarrantyEndDate are added into EntitlementSummary)
       //SerialNumber ,ProductID ,ProductDescription,ActiveWarrantyEntitlement,OverallWarrantyStartDate,OverallWarrantyEndDate,
       //ActiveContractEntitlement,OverallContractStartDate,OverallContractEndDate,WarrantyDeterminationDescription,
       //GracePeriod,WarrantyExtension,FactoryWarrantyPortfolioFlag,FactoryWarrantyTermCode,
       //BundledWarrantyPortfolioFlag,BundledWarrantyTermCode,ShipToCountry,FactoryWarrantyStartDate,FactoryWarrantyEndDate,
       EntitlementSummaryComplexType summary = item.getEntitlementSummary();
       if(summary == null) {
           //We add 32 commas to fill blanck
           for(int i=0;i<31;i++) {
               sbTmp.append(FIELDSEP);
           }
       }else {
	       sbTmp.append(fixString(summary.getSerialNumber()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getProductId()));
	       sbTmp.append(FIELDSEP);


	       sbTmp.append(fixString(summary.getProductDescription()));
	       sbTmp.append(FIELDSEP);

	       //Castor will map it to false if it does not exist so we need to put some extra code
	       if(summary.hasActiveWarrantyEntitlement()){
		       sbTmp.append(summary.getActiveWarrantyEntitlement());
	       }
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(convertNullObjectInBlanckString(summary.getOverallWarrantyStartDate()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(convertNullObjectInBlanckString(summary.getOverallWarrantyEndDate()));
	       sbTmp.append(FIELDSEP);

	       if(summary.hasActiveContractEntitlement()) {
		       sbTmp.append(summary.getActiveContractEntitlement());
	       }
	       sbTmp.append(FIELDSEP);

           sbTmp.append(convertNullObjectInBlanckString(summary.getOverallContractStartDate()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(convertNullObjectInBlanckString(summary.getOverallContractEndDate()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getSalesOrderNumber()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getWarrantyComment()));
	       sbTmp.append(FIELDSEP);
	       
	       sbTmp.append(convertNullObjectInBlanckString(summary.getShipmentDate()));
	       sbTmp.append(FIELDSEP);
	       
	       sbTmp.append(fixString(summary.getWarrantyDeterminationDescription()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(String.valueOf(summary.getGracePeriod()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getWarrantyExtension()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(convertNullObjectInBlanckString(summary.getFactoryWarrantyPortfolioFlag()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getFactoryWarrantyTermCode()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(convertNullObjectInBlanckString(summary.getBundledWarrantyPortfolioFlag()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getBundledWarrantyTermCode()));
	       sbTmp.append(FIELDSEP);

	       sbTmp.append(fixString(summary.getShipToCountry()));
	       sbTmp.append(FIELDSEP);

           // New elements are added at the end of its section.
           sbTmp.append(convertNullObjectInBlanckString(summary.getFactoryWarrantyStartDate()));
           sbTmp.append(FIELDSEP);

           sbTmp.append(convertNullObjectInBlanckString(summary.getFactoryWarrantyEndDate()));
           sbTmp.append(FIELDSEP);

	       //Offer, 1 line per offer (Since ES 8.2.4 ContractIDCarepackSN, COVWINDOW and ResponseCommitment are added into OfferSummary)
	       //OfferCode,OfferDescription ,PortfolioFlag,ObligationType,WarrantyTermCode,PackageCode,
           //PackageDescription,StartDate,EndDate,Status,ContractIDCarepackSN,COVWINDOW,ResponseCommitment,";
	       if(summary.getOfferSummaryCount() == 0) {
	           //We add 13 commas
	           for(int i=0;i<12;i++) {
	               sbTmp.append(FIELDSEP);
	           }
	       }
           else {
	           //we first save sbTmp in another string so that we can use it for each line
	           String lineTemplate = sbTmp.toString();
	           for(int cptOffer=0; cptOffer < summary.getOfferSummaryCount();cptOffer++ ) {
	               if(cptOffer != 0) {
	                   sbTmp.append(LINESEP);
	                   sbTmp.append(lineTemplate);
	               }
	               OfferSummaryComplexType offer= summary.getOfferSummary(cptOffer);

	               sbTmp.append(fixString(offer.getOfferCode()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(fixString(offer.getOfferDescription()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(convertNullObjectInBlanckString(offer.getPortfolioFlag()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(convertNullObjectInBlanckString(offer.getObligationType()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(fixString(offer.getWarrantyTermCode()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(fixString(offer.getPackageCode()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(fixString(offer.getPackageDescription()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(convertNullObjectInBlanckString(offer.getStartDate()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(convertNullObjectInBlanckString(offer.getEndDate()));
	               sbTmp.append(FIELDSEP);

	               sbTmp.append(convertNullObjectInBlanckString(offer.getStatus()));
                   sbTmp.append(FIELDSEP);

                   // New elements are added at the end of its section.
                   sbTmp.append(fixString(offer.getContractIDCarepackSN()));
                   sbTmp.append(FIELDSEP);

                   sbTmp.append(fixString(offer.getCOVWINDOW()));
                   sbTmp.append(FIELDSEP);

                   sbTmp.append(fixString(offer.getResponseCommitment()));

	           }
	       }
       }
       sbTmp.append(LINESEP);
       String csvString= sbTmp.toString();
	   return csvString;
	}


    /*
     * This is the public interface of this class
     * This create a CSV String out of an XML
     * @param the xml. This xml must be an EntitlementItem
     * @return a csv line as defined in the JUpiter SRS
     * @throws SifException (should never ever happen)
     */
    public String XMLToCSV(String batchXml) throws SifException {
       long startUnMarshallXML=System.currentTimeMillis();
       EntitlementItem item = unMarshallXML(batchXml);
       long endUnMarshallXML=System.currentTimeMillis();
       ESLog.debug("Time of unMar Shall XML:"+(endUnMarshallXML-startUnMarshallXML));
       String csvString=marshalToCSV(item);
       return csvString;
    }

    /*
     * This create an EntitlementItem from the XML
     * @param the xml. This xml must be an EntitlementItem
     * @return an EntitlementItem object
     * @throws TBD
     */
    EntitlementItem unMarshallXML(String batchXml) throws SifException {
       EntitlementItem item = null;
       // We need to make object out of the String we have
       // this must not generate any error as the XML was already generated with the same method

       item = (EntitlementItem)MarshalHelper.unmarshal(batchXml,null,EntitlementItem.class);
       return item;
    }

    /*
     * map a blank string if an object is null
     */
    private Object convertNullObjectInBlanckString(Object obj) {
        if(obj == null) {
            return BLANKSTRING;
        }
        return obj;
    }


    /*
     * escape doublequote
     */
    String fixString(String str) {
        String nonNullString = (String) convertNullObjectInBlanckString(str);

        nonNullString = nonNullString.trim();
        int indexDoublequote = nonNullString.indexOf(DOUBLEQUOTE);

        if(indexDoublequote < 0) {
            if(!nonNullString.equals("")) {
                return DOUBLEQUOTE+nonNullString+DOUBLEQUOTE;
            }
            return nonNullString;
        }

        //we need to escape it
        StringBuffer escapedStringBuffer = new StringBuffer();
        int lastIndexPosition=0;
        do{
            indexDoublequote = nonNullString.indexOf(DOUBLEQUOTE,lastIndexPosition);
            if(indexDoublequote >= 0) {
	            escapedStringBuffer.append(nonNullString.substring(lastIndexPosition,indexDoublequote+1));
	            escapedStringBuffer.append(DOUBLEQUOTE);
	            lastIndexPosition= indexDoublequote+1;
            }else {
                escapedStringBuffer.append(nonNullString.substring(lastIndexPosition,nonNullString.length()));
            }
        } while( indexDoublequote >= 0);
        return DOUBLEQUOTE+escapedStringBuffer.toString()+DOUBLEQUOTE;
    }
}
//eof
