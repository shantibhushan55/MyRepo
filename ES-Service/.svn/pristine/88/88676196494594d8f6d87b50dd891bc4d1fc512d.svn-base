/**
 * 
 */
package com.hp.es.service.manufacturingHeaderInformation.integration.mapping;

import java.util.List;

import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ArrayOfBundleInformation;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ArrayOfProductShippingInformation;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.BundleInformation;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ProductBillOfMaterial;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ProductShippingInformation;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;

/**
 * @author ANVOI
 *
 */
public class  ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper {

	/**
	 * disable
	 */
	protected ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper() {
	}

	
	public static ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper getInstance() {
		return new ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper();
	}



	public ManufacturingInstalledBaseHeaderType map(ProductBillOfMaterial pBOM) throws MappingException {
		ManufacturingInstalledBaseHeaderType mIBHT = new ManufacturingInstalledBaseHeaderType();
		
		if(pBOM != null){
			/*getting the reply into temp variables */
			ProductShippingInformation productShippingInformation = null;
			BundleInformation bundleInformation = null;
			ArrayOfBundleInformation aBundleInformation = pBOM.getBundleInfo()!= null ?  pBOM.getBundleInfo().getValue():null;
			List<BundleInformation> lBundleInformation = aBundleInformation != null?aBundleInformation.getBundleInformation():null;
			
			
			String mfgDate = pBOM.getManufactureDate()!= null? pBOM.getManufactureDate().getValue():"";
			String pn  = pBOM.getProductNumber()!=null?pBOM.getProductNumber().getValue():"";
			String sn = pBOM.getSerialNumber()!= null?pBOM.getSerialNumber().getValue():"";
			
			ArrayOfProductShippingInformation aProductShippingInformation = pBOM.getShippingInfo()!=null ?pBOM.getShippingInfo().getValue():null;
			List<ProductShippingInformation> lProductShipInfo = aProductShippingInformation != null?aProductShippingInformation.getProductShippingInformation():null;
			
			if(lProductShipInfo != null && lProductShipInfo.size() >0 ){
				productShippingInformation = lProductShipInfo.get(0);				
			}
			if (lBundleInformation != null && lBundleInformation.size() > 0){
				bundleInformation = lBundleInformation.get(0);				
			}
			
			String shipmentDate = productShippingInformation != null?(productShippingInformation.getShipmentDate()!= null?productShippingInformation.getShipmentDate().getValue():""):"";			
			String returnDate = productShippingInformation != null ?(productShippingInformation.getReturnDate()!= null? productShippingInformation.getReturnDate().getValue():""):"";
			
			if((mfgDate != null && mfgDate.length() > 0) || (pn != null && pn.length() > 0) || (sn != null && sn.length() >0) || (shipmentDate!= null && shipmentDate.length() > 0) || (returnDate != null &&returnDate.length() > 0)){
				//mIBHT.setRefurbished(fasle);
				mIBHT.setRemarketed(pBOM.isIsRemarketed());		
				
				mIBHT.setManufacturingDate(DateHelper.mapJavaDate2Castor(DateHelper.mapIsoDate2JavaDate(mfgDate)));
				mIBHT.setReturnDate(DateHelper.mapJavaDate2Castor(DateHelper.mapIsoDate2JavaDate(returnDate)));
				mIBHT.setShipmentDate(DateHelper.mapJavaDate2Castor(DateHelper.mapIsoDate2JavaDate(shipmentDate)));		
		
				mIBHT.setParentBundleHpProductId(bundleInformation!=null?bundleInformation.getSystemProductNumber().getValue():null); 
				mIBHT.setParentBundleHpSerialNumber(bundleInformation!=null?bundleInformation.getSystemSerialNumber().getValue():null);
				mIBHT.setOutputHpProductId(pn);
				mIBHT.setOutputHpSerialNumber(sn);
				
				return mIBHT;				
			}
	
		}
		throw new MappingException("Invalid MIB reply");

		
		
	}



}
