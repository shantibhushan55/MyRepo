package com.hp.es.service.operations;

import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.sif.SifException;

/**
 * This class provides a set of methods to access the context info for combining es operations.
 * 
 * @author Chunyang Wang
 */
public class OperationContext {
    // This variable needs to be set in EsInterface layer.
    // Why this variable is introduced? - We use this variable to indicates which operation is the
    // original one requested by es client. For example, the operation getEntitlementBySn will
    // invoke getWarrantyEntitlement by creating a new warranty request.
    private String originalOperationName = null;

    // This variable needs to be set in WarrantyOrchestration layer.
    // We use this variable to hold the value of support line returned from SWOP. So that ES can
    // determine whether ES will call ASTRO2 to get CATS agreement inforamtion.
    private String supportLineFromSwop = null;

    // This variable should be set after es reply of SWOP is returned.
    // Usage:
    // - use the WarrantyEntitlement.OOS to map CATS warranty.
    // - filter warning 420 from esReply mapped from swop.
    private EsReply esReplyOfSwop = null;

    // This variable should be set after contract entitlement is returned.
    // Usage:
    // - use contract.HPCarePackSerialNumber to check duplicate data for CarePackSerialNumber when
    // merge CATS agreement.
    private ContractComplexType[] contract = null;

    // The WarrantyEntitlement returned from CATS.
    private WarrantyEntitlementComplexType _catsWarrantyEntitlement = null;

    private RegionConfiguration _regionConfiguration=null;

    private EsReply _manufacturingInstalledBaseServicEsReply = null;
    private SifException _manufacturingInstalledBaseServiceSifException= null;
    
    

	/**
	 * @return the manufacturingInstalledBaseServicEsReply
	 */
	public EsReply getManufacturingInstalledBaseServicEsReply() {
		return _manufacturingInstalledBaseServicEsReply;
	}

	/**
	 * @param manufacturingInstalledBaseServicEsReply the manufacturingInstalledBaseServicEsReply to set
	 */
	public void setManufacturingInstalledBaseServicEsReply(
			EsReply manufacturingInstalledBaseServicEsReply) {
		_manufacturingInstalledBaseServicEsReply = manufacturingInstalledBaseServicEsReply;
	}

	/**
	 * @return the manufacturingInstalledBaseServiceSifException
	 */
	public SifException getManufacturingInstalledBaseServiceSifException() {
		return _manufacturingInstalledBaseServiceSifException;
	}

	/**
	 * @param manufacturingInstalledBaseServiceSifException the manufacturingInstalledBaseServiceSifException to set
	 */
	public void setManufacturingInstalledBaseServiceSifException(
			SifException manufacturingInstalledBaseServiceSifException) {
		_manufacturingInstalledBaseServiceSifException = manufacturingInstalledBaseServiceSifException;
	}

	public String getOriginalOperationName() {
        return originalOperationName;
    }

    public void setOriginalOperationName(String originalOperationName) {
        this.originalOperationName = originalOperationName;
    }

    public String getSupportLineFromSwop() {
        return supportLineFromSwop;
    }

    public void setSupportLineFromSwop(String supportLineFromSwop) {
        this.supportLineFromSwop = supportLineFromSwop;
    }

    public EsReply getEsReplyOfSwop() {
        return esReplyOfSwop;
    }

    public void setEsReplyOfSwop(EsReply esReplyOfSwop) {
        this.esReplyOfSwop = esReplyOfSwop;
    }

    public void setContract(ContractComplexType[] contract) {
        this.contract = contract;
    }

    public ContractComplexType[] getContract() {
        return contract;
    }

    public void setCatsWarrantyEntitlement(WarrantyEntitlementComplexType catsWarrantyEntitlementE) {
        _catsWarrantyEntitlement = catsWarrantyEntitlementE;
    }

    public WarrantyEntitlementComplexType getCatsWarrantyEntitlement() {
        return _catsWarrantyEntitlement;
    }

    /**
     * 
     * @param we
     * @param catsWE
     */
    public void calculateOverallWarrantyEntitlementForCATS(WarrantyEntitlementComplexType we) {
        if (_catsWarrantyEntitlement == null)
            return;
        // Check whether only CATS warranty is in es reply. Maybe a inactive swop warranty is
        // removed because of ActiveWarrantyOnly=true in request.
        if ((we.getWarrantyCount() == 1) && (we.getWarranty(0) == _catsWarrantyEntitlement.getWarranty(0))) {
            we.setActiveWarrantyEntitlement(_catsWarrantyEntitlement.getActiveWarrantyEntitlement());
            we.setOverallWarrantyStartDate(_catsWarrantyEntitlement.getOverallWarrantyStartDate());
            we.setOverallWarrantyEndDate(_catsWarrantyEntitlement.getOverallWarrantyEndDate());
        }
        // ActiveWarrantyEntitlement ->
        // Set to true if either ActiveWarrantyEntitlement from SWOP or CATS is true
        // Warranty.
        if (_catsWarrantyEntitlement.getActiveWarrantyEntitlement() == true) {
            ESLog.debug("ActiveWarrantyEntitlement from CATS is true.");
            we.setActiveWarrantyEntitlement(true);
        }

        // OverallWarrantyStartDate ->
        // The smallest OverallWarrantyStartDate from either SWOP or CATS Warranty.

        if (_catsWarrantyEntitlement.getOverallWarrantyStartDate().compareTo(we.getOverallWarrantyStartDate()) == 0) {
            // LESS_THAN (0): this < dateTime
            ESLog.debug("Use the OverallWarrantyStartDate from CATS because it is earlier than the one from SWOP.");
            we.setOverallWarrantyStartDate(_catsWarrantyEntitlement.getOverallWarrantyStartDate());
        }

        // OverallWarrantyEndDate ->
        // The largest OverallWarrantyEndDate from either SWOP or CATS
        if (_catsWarrantyEntitlement.getOverallWarrantyEndDate().compareTo(we.getOverallWarrantyEndDate()) == 2) {
            // GREATER_THAN (2): this > dateTime
            ESLog.debug("Use the OverallWarrantyEndDate from CATS because it is later than the one from SWOP.");
            we.setOverallWarrantyEndDate(_catsWarrantyEntitlement.getOverallWarrantyEndDate());
        }
    }

    public String getSwopShipToCountry() {
        if (esReplyOfSwop != null) {
            WarrantyEntitlementComplexType swopWarranty = esReplyOfSwop.getEsReplyChoice().getWarrantyEntitlement();
            if (swopWarranty != null && swopWarranty.getOOS() != null)
                return swopWarranty.getOOS().getShipToCountry();
        }
        return null;
    }

    public void setRegionConfiguration(RegionConfiguration regionConfiguration) {
        this._regionConfiguration=regionConfiguration;
    }

    public RegionConfiguration getRegionConfiguration() {
        return _regionConfiguration;
    }



}
