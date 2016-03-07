/**
 * 
 */
package com.hp.es.service.manufacturingHeaderInformation.integration.mapping;

import java.util.List;
import java.util.TreeMap;

import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ProductBillOfMaterial;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;

/**
 * @author ANVOI
 *
 */
public class ManufacturingInstalledBaseServiceUnitListComplexTypeMapper {
	private ManufacturingInstalledBaseServiceUnitListComplexTypeMapper() {
	}
			

	
	/*
	 * Map a MIB unit list to a es unit list
	 */
	public UnitListComplexType map(List<ProductBillOfMaterial> listProductBillOfMaterial ) throws MappingException {
		UnitListComplexType ulct= new UnitListComplexType();
		if(listProductBillOfMaterial != null) {
			
			TreeMap<String ,String> serialNumberMap = new TreeMap<String ,String>();
			for (ProductBillOfMaterial productBillOfMaterial : listProductBillOfMaterial) {
				ulct.addProduct(mapProduct(productBillOfMaterial));
				String sn = productBillOfMaterial.getSerialNumber()!= null ? (productBillOfMaterial.getSerialNumber()!=null ?productBillOfMaterial.getSerialNumber().getValue():""):"";
				
				
				serialNumberMap.put(sn, sn);
			}
			// set the serial number, which should be the same for all returned products
			if(serialNumberMap.size() != 1) {
				ESLog.error("More than 1 serial number returned from SNR in the Unit List! It can be only 1 (Highlander)");
	        	throw new MappingException( "More than 1 serial number returned from SNR in the Unit List!");
			}
			ulct.setSerialNumber((String)serialNumberMap.firstKey());
		    
		}
		
		return ulct;
	}


	
	public static ManufacturingInstalledBaseServiceUnitListComplexTypeMapper getInstance() {
		return new ManufacturingInstalledBaseServiceUnitListComplexTypeMapper();
	}
	
	
	private ProductComplexType mapProduct(ProductBillOfMaterial productBillOfMaterial) {
		ESLog.debug("Map product '" + productBillOfMaterial.getProductNumber() + "' for unit list");
		ProductComplexType product = new ProductComplexType();
		String productID = productBillOfMaterial.getProductNumber()!= null? (productBillOfMaterial.getProductNumber() != null ? productBillOfMaterial.getProductNumber().getValue(): "") : "";
		product.setProductID(productID);
		String productDesc =productBillOfMaterial.getProductDescription()!= null? (productBillOfMaterial.getProductDescription() != null ? productBillOfMaterial.getProductDescription().getValue(): "") : "";  
		
		product.setProductDescription(productDesc);
		

		return product;
	}

}
