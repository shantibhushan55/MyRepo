/*
 * Created on Mar 1, 2006
 *
 */
package com.hp.es.service.orchestration;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceTransaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.routingDetails.orchestration.RoutingDetailsTransaction;
import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsReply;
import com.hp.sif.SifException;

/**
 * @author juhank
 *
 * Wrapper object of the actual reply. This wrapper can contain the exception or
 * the reply. It provides several methods to check what has been received. It
 * contains also the region name, from which the reply or exception was received
 * and to which SAP client (main or failover) the request was sent.
 * If the reply is empty (no reply nor throwable), then the request timed out.
 */
abstract public class Transaction {
	private RegionConfiguration _config = null;
	private boolean   _fromFailover = false;
	private boolean   _isLocal = false;
	private final static String NO_CONFIG = "NOT_CONFIGURED";
	private String    _functionName = null;
	protected String  _displayName;

	// source system response
	private Object    _sourceSystemResponse = null;
	private Throwable _sourceSystemThrowable = null;
	
	// mapped replies
	protected EsReply _mappedReply = null;
	protected Collection _mappedErrors = null;
	
	/**
	 * Constructor
	 * @param config
	 * @param failoverMode
	 * @param sourceReply
	 * @param functionName
	 */
	protected Transaction(RegionConfiguration config, boolean failoverMode, Object sourceReply, String functionName, String displayName, boolean isLocal) {
		_config = config;
        _fromFailover = failoverMode;
        _sourceSystemResponse = sourceReply;
        _functionName = functionName;
        _displayName = displayName;
        _isLocal = isLocal;
        ESLog.debug("Creating Transaction for function  name " + _functionName + " display name " +_displayName);
	}

	/**
	 * getInstance
	 * @param config
	 * @param failoverMode
	 * @param sourceReply
	 * @param sapFunctionName
	 * @return
	 * @throws SifException 
	 */
	public static Transaction getInstance(RegionConfiguration config, boolean failoverMode, Object sourceReply, String sapFunctionName, String displayName, boolean isLocal) throws SifException {
		// check which sap function name has been used and create a specific reply for it
		// WarrantyReply
		if(EsConstants.SAP_FUNCTION_NAME_SWOP.equalsIgnoreCase(sapFunctionName)) {
			return new WarrantyTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName, isLocal);
		}
		// Contract reply
		
		if(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT.equalsIgnoreCase(sapFunctionName)) {
			return new ContractTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName,isLocal);
		}		
		// Contract by SN reply
		if(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT_BYSN.equalsIgnoreCase(sapFunctionName)) {
			return new ContractTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName,isLocal);
		}		
		
		// IB search reply
		if(EsConstants.SAP_FUNCTION_NAME_IBSEARCH.equalsIgnoreCase(sapFunctionName)) {
			return new IBSearchTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName,isLocal);
		}		
        
		// Routing details reply
        if (EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS.equalsIgnoreCase(sapFunctionName)) {
            return new RoutingDetailsTransaction(config, failoverMode, sourceReply, sapFunctionName, displayName, isLocal);
        }

		// ContractSummary reply
		
		if(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM.equalsIgnoreCase(sapFunctionName)) {
			return new ContractSummaryTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName,isLocal);
		}		

		//CATS Agreement
		if(EsConstants.SAP_FUNCTION_NAME_ASTRO2.equalsIgnoreCase(sapFunctionName)) {
			return new CatsAgreementTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName, isLocal);
		}
		
		
		//UNIT EVENT HISTORY
		if(EsConstants.SAP_FUNCTION_NAME_UNITEVENTHISTORY.equalsIgnoreCase(sapFunctionName)) {
			return new UnitEventHistoryTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName, isLocal);
		}
		
		
		//MIB SERVICE
		if(EsConstants.FUNCTION_NAME_SNR_MFG.equalsIgnoreCase(sapFunctionName)) {
			return new ManufacturingInstalledBaseServiceTransaction(config, failoverMode, sourceReply, sapFunctionName,displayName, isLocal);
		}

		throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"No Reply type for this type of operation");
	}
	
	
	

	/**
	 * Abstract methods
	 */
	abstract public boolean isSourceSystemUnitList();
    abstract public Object getSourceSystemUnitList();

    abstract public boolean isSourceSystemStandardReply();
    abstract public Object getSourceSystemStandardReply();	

    abstract public boolean isSourceSystemError();
    abstract public Collection getSourceSystemErrors();	
    
    abstract public boolean isSourceSystemWarnings();
    abstract public Collection getSourceSystemWarnings();	

    
	/**
	 * @return Returns the URL.
	 */
	public String getUrl() {
		if(_config == null) {
			return NO_CONFIG;
		}
        if(_fromFailover == true) {
        	return _config.getFailoverUrl();
        } else {
        	return _config.getMainUrl();
        }
	}
	
	/**
	 * @return Returns the Host.
	 */
	public String getSourceSystemHost() {
		if(_config == null) {
			return NO_CONFIG;
		}
        if(_fromFailover == true) {
        	return _config.getFailoverHost();
        } else {
        	return _config.getMainHost();
        }
	}

	/**
	 * returns the information whether a local region has been
	 * used to retrieve the information
	 */
    public boolean isLocal() {
    	return _isLocal;
    }
    public void setLocal(boolean local) {
    	_isLocal = local;
    }

    /**
     * Source System Response: it is the overall response from
     * an source system. It could contain a unit list, a normal reply or 
     * an error
     */
    public void setSourceSystemResponse(Object sourceSystemResponse) {
		_sourceSystemResponse = sourceSystemResponse;
	}
	public Object getSourceSystemResponse() {
		return _sourceSystemResponse;
	}

	
    /**
     * Source System Throwable: This is set if an exception occurred 
     * during the access to a source system
     */
	public void setSourceSystemThrowable(Throwable sourceSystemThrowable) {
		_sourceSystemThrowable = sourceSystemThrowable;
	}

	public Throwable getSourceSystemThrowable() {
		return _sourceSystemThrowable;
	}


    /**
     * EsReply
     */
    public EsReply getMappedReply() {
    	return _mappedReply;
    }
    public void setMappedReply(EsReply esReply) {
    	_mappedReply = esReply;
    }
	
    /**
     * Errors in the ES format
     * a list of SifExceptions
     */
    public Collection getMappedErrors() {
    	return _mappedErrors;
    }
    public void setMappedErrors(Collection mappedErrors) {
    	_mappedErrors = mappedErrors;
    }
    
	/**
	 * isSourceSystemUnavailable
	 */
	public boolean isSourceSystemUnavailable() {
		return (
	            ( _sourceSystemThrowable != null ) &&
	            ( _sourceSystemThrowable instanceof SifException ) &&
	            ( ((SifException)_sourceSystemThrowable).getErrorID().equals(ErrorFactory.id8000_TIMEOUT_OCCURRED+"") ||
	              ((SifException)_sourceSystemThrowable).getErrorID().equals(ErrorFactory.id224_ALL_SOURCE_SYSTEMS_TIMED_OUT+"") ||
	              ((SifException)_sourceSystemThrowable).getErrorID().equals(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE+"") )
	        );
	}
	
	/**
	 * isUnavailable
	 */
	public boolean isUnavailable() {
		return isSourceSystemUnavailable() || isUnavailableMappedError();
	}	

	
	protected boolean isUnavailableMappedError() {
		Collection c = getMappedErrors();
		if(c!= null) {
			Iterator it = c.iterator();
			while(it.hasNext()) {
				SifException e = (SifException)it.next();
				if (e.getErrorID().equals(ErrorFactory.id8000_TIMEOUT_OCCURRED+"") ||
	              e.getErrorID().equals(ErrorFactory.id224_ALL_SOURCE_SYSTEMS_TIMED_OUT+"") ||
	              e.getErrorID().equals(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE+""))  {
					return true;
	              }
			}
		}
		return false;
	}

	/**
	 * getRegionName
	 */
	public String getRegionName() {
		if(_config == null) {
			return NO_CONFIG;
		}
		return _config.getRegionName();
	}

	
	/**
	 * getRegionName
	 */
	
	public String getRegionDisplayName() {
		return _displayName;
	}
	
	
	/**
	 * isFromFailover
	 */
	public boolean isFromFailover() {
		return _fromFailover;
	}
    
	/**
	 * prints out the information of the reply
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Region: ");
		sb.append(getRegionDisplayName());
		sb.append(", Mode: ");
		if(this.isFromFailover()) {
			sb.append("FAILOVER");
		} else {
			sb.append("MAIN");
		}

		if(this.isUnavailable()) {
			if(_sourceSystemThrowable != null &&_sourceSystemThrowable instanceof SifException && ((SifException)_sourceSystemThrowable).getErrorID().equals(ErrorFactory.id8000_TIMEOUT_OCCURRED+"") ) { 
				sb.append(", Source System  TIMEOUT  No reply, source system error returned"+_sourceSystemThrowable.toString());
			}else {
				if(_sourceSystemThrowable != null &&_sourceSystemThrowable instanceof SifException) {
					sb.append(", Source System  Unavailable: Got Exception : Id"+((SifException)_sourceSystemThrowable).getErrorID()+ " Message"+((SifException)_sourceSystemThrowable).getMessage());
				}else {
					sb.append(", Source System  Unavailable: No reply");
				}
			}
		} else if(isSourceSystemError() || (this.getMappedErrors() != null &&  this.getMappedErrors().size() > 0)) {
			
			
			if(isSourceSystemError()&& getSourceSystemThrowable()!=null) {
				sb.append(" Source System returns Error ");
				sb.append(getSourceSystemThrowable().toString());
			}else if (this.getMappedErrors() != null && this.getMappedErrors().size()>0){
				sb.append(" Mapped Error From Source System ");
				SifException ex=(SifException) getMappedErrors().iterator().next();
				sb.append(ex.getMessage());
				
			}
		} else if(isSourceSystemStandardReply() || getMappedReply() != null) {
			sb.append(" Source System return Standard reply ");
			//sb.append(getSourceSystemResponse().toString());
		} else {
			sb.append(" UNKNOWN");
		}
		return sb.toString(); 
	}


	public RegionConfiguration get_config() {
		return _config;
	}
	
	public  void destroy()
	{
		ESLog.debug("Destroy all, we finished using Tranaaction");
		if(_config != null) {
			_config = null;
		}
		if(_sourceSystemResponse !=null) {
			_sourceSystemResponse= null;
		}

		
		if(_sourceSystemThrowable !=null) {
			_sourceSystemThrowable= null;
		}
		
		
		if(_mappedReply !=null) {
			_mappedReply= null;
		}
		if(_mappedErrors !=null) {
			_mappedErrors.clear();
			_mappedErrors= null;
		}
		

		_functionName = null;
		_displayName = null;

	}
}



