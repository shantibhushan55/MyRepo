/**
 * 
 */
package com.hp.es.service.warrantyEntitlement.integration;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.integration.mapping.ErrorMapper;
import com.hp.es.service.warrantyEntitlement.integration.mapping.RequestMapper;
import com.hp.es.service.warrantyEntitlement.integration.mapping.UnitListMapper;
import com.hp.es.service.warrantyEntitlement.integration.mapping.WarrantyEntitlementMapper;
import com.hp.es.service.warrantyEntitlement.integration.mapping.WarrantyHeaderMapper;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public abstract class WarrantyIntegration implements IntegrationInterface {

	protected boolean _isLocal = false;
	protected Region _region = null;
	protected ManufacturingInstalledBaseHeaderType _manufacturingInstalledBaseServiceReply = null;
	SifException _manufacturingInstalledBaseServiceSE;
	
	/**
	 * @return the manufacturingInstalledBaseServiceReply
	 */
	public ManufacturingInstalledBaseHeaderType getManufacturingInstalledBaseServiceReply() {
		return _manufacturingInstalledBaseServiceReply;
	}

	/**
	 * @param manufacturingInstalledBaseServiceReply the manufacturingInstalledBaseServiceReply to set
	 */
	public void setManufacturingInstalledBaseServiceReply(
			ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply) {
		_manufacturingInstalledBaseServiceReply = manufacturingInstalledBaseServiceReply;
	}

	/**
	 * constructor WarrantyIntegration
	 */
	public WarrantyIntegration() {
		super();
		
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType)
	 */
	public abstract Transaction execute(EsRequestComplexType request, MetricsHandler handler) throws SifException;

	

	
	public boolean isRegionInFailoverMode() {
		return _region.inFailoverMode();
	}
	
	public String getRegionName() {
		return _region.getConfiguration().getRegionName();
	}
	
	public RegionConfiguration getRegionConfiguration() {
		return _region.getConfiguration();
	}
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */
	public String getName() {
		return this.getClass().toString() + "-" + _region.getConfiguration().getRegionName();
	}	
	
	public String getRegionDisplayName() {
		return EsConstants.SWOP_SYSTEM_NAME +" "+ getRegionName();
	}
	
	/** 
	 * callRegion 
	 * @param request
	 * @param metricsHandler
	 * @return
	 * @throws SifException
	 */
	public Transaction callRegion(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		
		ESLog.debug("Mapping ES request to SWOP request");
		// map ES request to SWOP request
		Object swopRequest = mapEsRequest2SwopRequest(request, _manufacturingInstalledBaseServiceReply);
		
		// pass request to the region and get the result
		Transaction transaction = null;
		try {
			ESLog.debug("Send request to SWOP using Region: " + _region.getConfiguration().getRegionName());
			transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_SWOP, 
									swopRequest, getRegionDisplayName(), isLocal(), metricsHandler);
		} catch (Exception e) {

			if( e instanceof SifException) {
				throw (SifException) e;
			}else {
				// No need to print something that was printed twice already
				ESLog.error("Exception while connecting to SWOP"+ e.getMessage());
				ESLog.debug("Exception while connecting to SWOP, stack trace", e);				
			}
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Exception while connecting to SWOP", e.toString());
		}
				
		// Check which reply we have error, unit list, or normal reply
		if(transaction.isSourceSystemError()) {
			ESLog.debug("We have SWOP errors ...");
			// SWOP ERRORS
			mapSwopError2EsErrors((WarrantyTransaction)transaction, request);
		} else if (transaction instanceof ErrorTransaction) {
			ESLog.debug("We have an throwable ...");
			// THROWABLE
			// There is no need to do anything here, it will be done in the composition layer
			// so we simply return the transaction
			mapThrowable2EsErrors((ErrorTransaction)transaction);
		} else if(transaction.isSourceSystemUnitList()) {
			ESLog.debug("We have a unit list ...");
			// UNIT LIST
			mapSwopReply2UnitList((WarrantyTransaction)transaction, request );
		} else {
			ESLog.debug("We have a reply ...");
			// NORMAL REPLY
			mapSwopReply2EsReply((WarrantyTransaction)transaction, request);
		}
		return transaction;
	}

	/**
	 * mapThrowable2EsErrors maps the received throwable into a SIF exception
	 * @param transaction

	private void mapThrowable2EsErrors(WarrantyTransaction transaction) {
		ESLog.debug("Mapping a throwable to a ES error (SifException)");
		// getting the throwable
		Throwable throwable = transaction.getSourceSystemThrowable();
		ArrayList errorList = new ArrayList();
		// checking which type it is
		if(throwable instanceof SifException) {
			// convert the throwable into a SifException
			ESLog.debug("We have a SifException");
			errorList.add((SifException) throwable);
		} else {
			// create a new SifException because an unknown error occured
			ESLog.debug("We have another Exception, create an internal SifException");
			errorList.add(ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, throwable.toString()));
		}
		// adding it to the mappedErrors collection
		ESLog.debug("Add the SifException to the mapped errors list");
		transaction.setMappedErrors(errorList);
	}	 */
	
	
	/**
	 * mapThrowable2EsErrors maps the received throwable into a SIF exception
	 * @param transaction
	 */
	private void mapThrowable2EsErrors(ErrorTransaction transaction) {
		ESLog.debug("Mapping a throwable to a ES error (SifException)");
		// getting the throwable
		Throwable throwable = transaction.getSourceSystemThrowable();
		ArrayList errorList = new ArrayList();
		// checking which type it is
		if(throwable instanceof SifException) {
			// convert the throwable into a SifException
			ESLog.debug("We have a SifException");
			errorList.add((SifException) throwable);
		} else {
			// create a new SifException because an unknown error occured
			ESLog.debug("We have another Exception, create an internal SifException");
			errorList.add(ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, throwable.toString()));
		}
		// adding it to the mappedErrors collection
		ESLog.debug("Add the SifException to the mapped errors list");
		transaction.setMappedErrors(errorList);
	}

	/**
	 * mapSwopError2EsErrors maps all the received errors from SWOP into a list of SIF exceptions
	 * @param request 
	 * @param transaction 
	 * @throws SifException 
	 */
	private void mapSwopError2EsErrors(WarrantyTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating ES Error List ...");
		ArrayList esErrors = null;
		try {
			ErrorMapper em = ErrorMapper.getInstance(transaction.getSourceSystemErrors(), request);
			esErrors = em.map();
			
			if(esErrors.isEmpty()  && transaction.isSwopEmptyReply()) {
				esErrors = new ArrayList();
				esErrors.add(ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, "SWOP Empty reply" ));
			}
		} catch (MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		
		ESLog.debug("Setting the ES errors in the transaction ...");
		transaction.setMappedErrors(esErrors);
	}

	/**
	 * mapSwopReply2UnitList maps the SWOP reply (product list) into a ES Unit List
	 * @param reply
	 * @param request
	 * @throws SifException 
	 */
	private void mapSwopReply2UnitList(WarrantyTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating EsReply for a Unit List ...");
		EsReply esReply = new EsReply();
		try {
			// setting header
			ESLog.debug("Setting the header in the EsReply ...");
			//TODO: add the _manufacturingInstalledBaseServiceReply so that we can add the SNR warnings
			WarrantyHeaderMapper headerMapper = new WarrantyHeaderMapper(request, transaction,_manufacturingInstalledBaseServiceReply,_manufacturingInstalledBaseServiceSE);
			esReply.setEsHeader(headerMapper.map());
			
			// get the swop reply
			ESLog.debug("Mapping the SWOP reply into the Unit List ...");
			UnitListMapper unitListMapper =  UnitListMapper.getInstance(transaction);
			esReply.setEsReplyChoice(new EsReplyChoice());
			esReply.getEsReplyChoice().setUnitList(unitListMapper.map());
		} catch (com.hp.es.service.util.exception.MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		// add EsReply to reply
		ESLog.debug("Setting the EsReply (which is containing the UnitList) in the transaction ...");
		transaction.setMappedReply(esReply);
	}
	
	/**
	 * mapEsRequest2SwopRequest maps the ES request to the SWOP request and
	 * setting the flag if we need a product/spare part calculation
	 * @param request
	 * @param manufacturingInstalledBaseServiceReply 
	 * @return
	 */
	private Object mapEsRequest2SwopRequest(EsRequestComplexType request, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply) {
		ESLog.debug("Mapping ES request to SWOP request");
		RequestMapper requestMapper = null;
		// Check if we need to perform a spare part calulcatio in the region
		if(_isLocal || doWeHaveASparePartNumberAndSerialNumber(request)) {
			ESLog.debug("Setting flag to perform product/spare part calculation in the request");
			requestMapper = RequestMapper.getInstance(request, "X",manufacturingInstalledBaseServiceReply);
		} else {
			ESLog.debug("NO product/spare part calculation is required in the request");
			requestMapper = RequestMapper.getInstance(request, null,manufacturingInstalledBaseServiceReply);
		}
		return requestMapper.map();
	}

	/**
	 * Due to a SWOP issue we have to do a product/spare part calculation
	 * in each region when we have a SN + Spare Part Number in the request.
	 * This is checked in this method  
	 * See also WITS 1501.
	 * @param request
	 * @return
	 */
	private boolean doWeHaveASparePartNumberAndSerialNumber(EsRequestComplexType request) {
		WarrantyRequest warrantyRequest = request.getEsRequestComplexTypeChoice().getWarrantyRequest();
		// Do we have a Serial Number (SN)?
		if(warrantyRequest.getSerialNumber() != null && warrantyRequest.getSerialNumber().trim().length() > 0 ) {
			// Do we have a Spare Part Number (SPN) ?
			if(warrantyRequest.getSparePartNumber() != null && warrantyRequest.getSparePartNumber().trim().length() > 0 ) {
				// SN and SPN available 
				return true; 
			} else {
				// SPN is not available
				return false;
			}
		} else {
			// SN is not available
			return false;
		}
	}
	
	/**
	 * mapSwopReply2EsReply maps the SWOP reply into an ES reply
	 * @param transaction
	 * @throws SifException 
	 */
	private void mapSwopReply2EsReply(WarrantyTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating EsReply ...");
		EsReply esReply = new EsReply();
		try {
			// setting header
			ESLog.debug("Setting the header in the EsReply ...");
			WarrantyHeaderMapper headerMapper = new WarrantyHeaderMapper(request, transaction,_manufacturingInstalledBaseServiceReply,_manufacturingInstalledBaseServiceSE);
			//TODO: add the _manufacturingInstalledBaseServiceReply so that we can add the SNR warnings
			esReply.setEsHeader(headerMapper.map());
			
			// get the swop reply
			ESLog.debug("Mapping the SWOP reply into the EsReply ...");
			WarrantyEntitlementMapper warrantyEntitlementMapper = WarrantyEntitlementMapper.getInstance(transaction, request, _manufacturingInstalledBaseServiceReply,_manufacturingInstalledBaseServiceSE);
			esReply.setEsReplyChoice(new EsReplyChoice());
			esReply.getEsReplyChoice().setWarrantyEntitlement(warrantyEntitlementMapper.map());
		} catch (com.hp.es.service.util.exception.MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		// add EsReply to reply
		ESLog.debug("Setting the EsReply in the transaction ...");
		transaction.setMappedReply(esReply);
	}
	
	/**
	 * Returns the flag whether this is a local instance or not
	 */
	public boolean isLocal() {
		return _isLocal;
	}
	
}
