/**
 * 
 */
package com.hp.es.service.manufacturingHeaderInformation.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ArrayOfProductBillOfMaterial;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ArrayOfProductShippingInformation;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingBillOfMaterialResponse;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ObjectFactory;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ProductBillOfMaterial;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ProductShippingInformation;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;

/**
 * @author ANVOI
 * 
 */
public class ManufacturingInstalledBaseServiceTransaction extends Transaction {
	

    /**
     * @param config
     * @param failoverMode
     * @param sourceReply
     * @param functionName
     */
    public ManufacturingInstalledBaseServiceTransaction(RegionConfiguration config, boolean failoverMode, Object sourceReply, String functionName,
            String displayName, boolean isLocal) {
        super(config, failoverMode, sourceReply, functionName, displayName, isLocal);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemUnitList()
     */
    public boolean isSourceSystemUnitList() {
        ESLog.debug("Getting for SourceSystemStandardReply");
        List<ProductBillOfMaterial> listBom= getSourceSystemUnitList();
        if (listBom.size()>1) {
        	return true;
        }
    	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemUnitList()
     */
    public List<ProductBillOfMaterial> getSourceSystemUnitList() {
        ESLog.debug("Getting for SourceSystemStandardReply");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ManufacturingBillOfMaterialResponse out = (ManufacturingBillOfMaterialResponse) reply.getSoapCastorReply();
        
        JAXBElement <ArrayOfProductBillOfMaterial> lists = out.getProductBillOfMaterialSearchResults();
        ArrayOfProductBillOfMaterial aopBM = lists.getValue();
        List<ProductBillOfMaterial> listBom= aopBM.getProductBillOfMaterial();
        /*
         * Parse the listBom for pn and find if there is the same product
         * 
         */
        List<ProductBillOfMaterial> listBom2=cleanupDuplicate(listBom);
        
        return listBom2;
    }

    /*
     * Clean the duplicate product, get the product information with latest date
     */
    
    private List<ProductBillOfMaterial> cleanupDuplicate(
			List<ProductBillOfMaterial> listBom) {
    	List<ProductBillOfMaterial> listBom2= null;
		if(listBom != null && listBom.size()>0) {
			listBom2=new ArrayList<ProductBillOfMaterial>();
			java.util.Iterator<ProductBillOfMaterial> it = listBom.iterator();
			HashMap <String,ProductBillOfMaterial> hashPn = new HashMap <String,ProductBillOfMaterial>();
			while(it.hasNext()) {
				ProductBillOfMaterial pbm = it.next();
				/*
				 * Clean the Pn
				 */
				String cleanPn= MappingUtils.removeContentAfterHash(pbm.getProductNumber().getValue());
				
				if(cleanPn !=null && cleanPn.length()>0) {
					//store the PN in pbm
					ObjectFactory objectFactory = new ObjectFactory();
					pbm.setProductNumber(objectFactory.createProductBillOfMaterialProductNumber(cleanPn));
					if(!hashPn.containsKey(cleanPn)) {
						hashPn.put(cleanPn, pbm);
					}else {
						// find which one we keep
						//we keep the earliest one
						ProductBillOfMaterial pbmFromHash = hashPn.get(cleanPn);
						
						Date manufacturingFromList =  MappingUtils.mapStringToJavaDate(pbm.getManufactureDate()!= null? pbm.getManufactureDate().getValue():"");
						Date manufacturingDateFromHash= MappingUtils.mapStringToJavaDate(pbmFromHash.getManufactureDate()!= null? pbmFromHash.getManufactureDate().getValue():"");
						
						Date shipdateFromList = null;
						Date returnDateFromList=null;
						ArrayOfProductShippingInformation aProductShippingInformation = pbm.getShippingInfo()!=null ?pbm.getShippingInfo().getValue():null;
						List<ProductShippingInformation> lProductShipInfo = aProductShippingInformation != null?aProductShippingInformation.getProductShippingInformation():null;
						if(lProductShipInfo != null && lProductShipInfo.size() >0 ){
							ProductShippingInformation productShippingInformation = lProductShipInfo.get(0);	
							shipdateFromList =  MappingUtils.mapStringToJavaDate(productShippingInformation.getShipmentDate()!= null? productShippingInformation.getShipmentDate().getValue():"");
							returnDateFromList= MappingUtils.mapStringToJavaDate(productShippingInformation.getReturnDate()!= null? productShippingInformation.getReturnDate().getValue():"");							
						}
						
						
						Date shipdateFromHash= null;
						Date returnDateFromHash= null;
						
						aProductShippingInformation = pbmFromHash.getShippingInfo()!=null ?pbmFromHash.getShippingInfo().getValue():null;
						lProductShipInfo = aProductShippingInformation != null?aProductShippingInformation.getProductShippingInformation():null;
						if(lProductShipInfo != null && lProductShipInfo.size() >0 ){
							ProductShippingInformation productShippingInformation = lProductShipInfo.get(0);	
							shipdateFromHash =  MappingUtils.mapStringToJavaDate(productShippingInformation.getShipmentDate()!= null? productShippingInformation.getShipmentDate().getValue():"");
							returnDateFromHash= MappingUtils.mapStringToJavaDate(productShippingInformation.getReturnDate()!= null? productShippingInformation.getReturnDate().getValue():"");							
						}
						
						/* Find the latest from each records
						 * 
						 */
						Date latestDateFromList = DateHelper.findLatestJavaDate(manufacturingFromList,shipdateFromList,returnDateFromList);
						Date latestDateFromHash = DateHelper.findLatestJavaDate(manufacturingDateFromHash,shipdateFromHash,returnDateFromHash);
						
						/* If the latest is in the list
						 * replace what's in the Hashmap 
						 */
						if(DateHelper.isGreater(latestDateFromList, latestDateFromHash)) {
							hashPn.remove(cleanPn);
							hashPn.put(cleanPn, pbm);
						}
					}
				}
			}
			
			Iterator<ProductBillOfMaterial> itTmp = hashPn.values().iterator();
			while(itTmp.hasNext()) {
				listBom2.add(itTmp.next());
			}
			
		}
		return listBom2;
	}

	/*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemStandardReply()
     */
    public boolean isSourceSystemStandardReply() {
    	if(getSourceSystemStandardReply() != null) {
    		return true;
    	}
    	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemStandardReply()
     */
    public ProductBillOfMaterial getSourceSystemStandardReply() {
        ESLog.debug("Getting for SourceSystemStandardReply");
        List<ProductBillOfMaterial> listPBom = getSourceSystemUnitList();
        
        
        return listPBom.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemError()
     */
    public boolean isSourceSystemError() {
        ESLog.debug("Checking for SourceSystemError");
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            ManufacturingBillOfMaterialResponse out = (ManufacturingBillOfMaterialResponse) reply.getSoapCastorReply();
            /*
             * If we have a valid reply with at least a PN and SN and no WTY message
             */
            JAXBElement<ArrayOfProductBillOfMaterial> tmp = out.getProductBillOfMaterialSearchResults();
            
            if ((tmp != null && tmp.getValue() != null
            		&&  tmp.getValue().getProductBillOfMaterial()!= null) 
            		&& out.getErrorCode().getValue() != null 
            		&& out.getErrorCode().getValue().equalsIgnoreCase(EsConstants.SNR_SUCCESS)) {
                    return false;
            }
            return true;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemError()
     */
    public Collection getSourceSystemErrors() {
        ESLog.debug("Getting for SourceSystemError");
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        ManufacturingBillOfMaterialResponse out = (ManufacturingBillOfMaterialResponse) reply.getSoapCastorReply();
        ArrayList <ManufacturingInstalledBaseServiceError> list = null;
        
        /*
         * SNR can only get one error
         */
        if (isSourceSystemError() ) {
        	ManufacturingInstalledBaseServiceError mibError   = new  ManufacturingInstalledBaseServiceError(out.getErrorCode().getValue(), out.getErrorDescription().getValue());
        	list = new ArrayList<ManufacturingInstalledBaseServiceError>();
        	list.add(mibError);
        } 
        return list;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#isSourceSystemWarnings()
     */
    public boolean isSourceSystemWarnings() {
    	//no warning for SNR
        return false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hp.es.service.orchestration.Transaction#getSourceSystemWarnings()
     */
    public Collection getSourceSystemWarnings() {
    	//no warning for SNR
        return null;
    }

	@Override
	public void destroy() {
		// 
		super.destroy();
	}

}
