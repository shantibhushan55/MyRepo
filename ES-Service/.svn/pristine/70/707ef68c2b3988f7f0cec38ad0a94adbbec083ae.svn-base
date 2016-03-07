/*
 * Created on Mar 8, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.Warnings;
import com.hp.sif.SifException;

/**
 * @author juhank
 */
public class WarrantyHeaderMapper {
	
    protected EsRequestComplexType _request;
    protected WarrantyTransaction _transaction;
	private ManufacturingInstalledBaseHeaderType _manufacturingInstalledBaseServiceReply;
	protected SifException _manufacturingInstalledBaseServiceSifException;

    public WarrantyHeaderMapper(EsRequestComplexType request, WarrantyTransaction transaction, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply,SifException manufacturingInstalledBaseServiceSifException) {
        _request = request;
        _transaction = transaction;
        _manufacturingInstalledBaseServiceReply =manufacturingInstalledBaseServiceReply;
        _manufacturingInstalledBaseServiceSifException=manufacturingInstalledBaseServiceSifException;
    }

    /**
     * map
     * @return
     * @throws MappingException 
     */
    public EsHeader map() throws MappingException {
    	ESLog.debug("Mapping ES header");		
    	EsHeader result = new EsHeader();
    

    	WarningMapper wm = WarningMapper.getInstance(_request, _transaction);
        result.setWarnings(wm.map());
        
		
        // add warning 420:  product is consumer product. This is trigger by: WarrantyInfo.SupportProductLine equal “R6” or “MK” or is empty
		if(_transaction.getSourceSystemResponse() != null) {
			EIAError eiaError = wm.getWarning420();
			if(eiaError != null) {
				Warnings warn = null;
				if(result.getWarnings() == null) {
					warn = new Warnings();
					result.setWarnings(warn);
				}else {
					warn = result.getWarnings();
				}
				warn.addEIAError(eiaError);
			}
		}    
		
		/*
		 * 
		 * Add the SNR warnings
		 */
		if(_manufacturingInstalledBaseServiceReply != null || _manufacturingInstalledBaseServiceSifException != null) {
			Warnings warn = null;
			EIAError eiaError =null;
			if(result.getWarnings() == null) {
				warn = new Warnings();
			} else{
				warn = result.getWarnings();
			}
			if(_manufacturingInstalledBaseServiceReply != null&& _manufacturingInstalledBaseServiceReply.getParentBundleHpProductId() != null && _manufacturingInstalledBaseServiceReply.getParentBundleHpSerialNumber() !=null) {
	
				if(_manufacturingInstalledBaseServiceReply.getOutputHpSerialNumber().equalsIgnoreCase(_manufacturingInstalledBaseServiceReply.getParentBundleHpSerialNumber()) 
						&& _manufacturingInstalledBaseServiceReply.getOutputHpProductId().equalsIgnoreCase(_manufacturingInstalledBaseServiceReply.getParentBundleHpProductId())) {
	
					eiaError = wm.getWarning441();
				}else {
					eiaError = wm.getWarning440(_manufacturingInstalledBaseServiceReply.getParentBundleHpSerialNumber(),_manufacturingInstalledBaseServiceReply.getParentBundleHpProductId());
				}
				warn.addEIAError(eiaError);
			}else if(_manufacturingInstalledBaseServiceSifException != null && Integer.parseInt(_manufacturingInstalledBaseServiceSifException.getErrorID()) ==ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE) {
				eiaError = wm.getWarning434(_manufacturingInstalledBaseServiceSifException);
				
				warn.addEIAError(eiaError);
				
			}
			 result.setWarnings(warn);
		}
        result.setInputRequest(_request);
        return result;
    }



}
