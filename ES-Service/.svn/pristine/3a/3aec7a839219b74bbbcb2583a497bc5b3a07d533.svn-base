package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYLOCATIONMASTER;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYOOSINFO;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYWTYENT;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.LocationComplexType;

class MetroLocationMasterMapper extends LocationMasterMapper {

	MetroLocationMasterMapper(WarrantyTransaction transaction,
			XMLIdGenerator XMLIdGenerator) {
		super(transaction, XMLIdGenerator);

	}

	LocationComplexType[] map() throws MappingException {

    	if(_transaction == null) {
    		return new LocationComplexType[0];
    	}
    	// map 1 location
     	LocationComplexType location = mapLocation(((ZWTYWTYENT)_transaction.getSourceSystemStandardReply()).getLOCATIONMASTER());

     	// check if there was a location
     	if(location == null) {
         	ESLog.debug("No location found");
     		return new LocationComplexType[0];
     	} else {
         	ESLog.debug("We have a location");
            if(location.getSourceCustomerID()==null){
                location.setSourceCustomerID(generateSoucreCustomerID());
            }
            LocationComplexType[] locations = new LocationComplexType[1];
         	locations[0] = location;
     		return locations;
     	}
    }

    /**
     * mapLocation
     * @param locationmaster
     * @return
     * @throws MappingException
     */
    private LocationComplexType mapLocation(ZWTYLOCATIONMASTER input) throws MappingException {
    	// in case the input is null, we return null again
    	if(input == null) {
    		return null;
    	}

    	// map the SWOP location to the ES location
     	ESLog.debug("Mapping location: " + input.getSOURCECUSTOMERID());
        LocationComplexType location = new LocationComplexType();
        location.setSourceCustomerID(MappingUtils.nullString(input.getSOURCECUSTOMERID()));
        location.setId(_XMLIdGenerator.nextId());
        location.setCity(MappingUtils.nullString(input.getADDRESS().getCITY()));
        location.setFmtAddrLine1(MappingUtils.nullString(input.getADDRESS().getFMTADDRLINE1()));
        location.setFmtAddrLine2(MappingUtils.nullString(input.getADDRESS().getFMTADDRLINE2()));
        location.setFmtAddrLine3(MappingUtils.nullString(input.getADDRESS().getFMTADDRLINE3()));
        location.setFmtAddrLine4(MappingUtils.nullString(input.getADDRESS().getFMTADDRLINE4()));
        location.setFmtAddrLine5(MappingUtils.nullString(input.getADDRESS().getFMTADDRLINE5()));
        location.setGeographicArea(MappingUtils.nullString(input.getADDRESS().getGEOGRAPHICAREA()));
        location.setIsoCountryCd(MappingUtils.nullString(input.getADDRESS().getISOCTRYCD()));
        location.setPostalCode(MappingUtils.nullString(input.getADDRESS().getPOSTALCODE()));
        location.setSiteBusinessName1(MappingUtils.nullString(input.getSITEBUSNAME1()));
        location.setSiteBusinessName2(MappingUtils.nullString(input.getSITEBUSNAME2()));
        location.setSiteBusinessName3(MappingUtils.nullString(input.getSITEBUSNAME3()));
        location.setSiteBusinessName4(MappingUtils.nullString(input.getSITEBUSNAME4()));
        location.setStreetAddr1(MappingUtils.nullString(input.getADDRESS().getSTREETADDR1()));
        location.setStreetAddr2(MappingUtils.nullString(input.getADDRESS().getSTREETADDR2()));

        // check if we have data in the location, if not, we return a null so that we don't have an entry
        if(isLoactionNull(location)) {
        	return null;
        }
        return location;
    }

    /**
     * The SourceCustomerID must be generated within ES when the SourceCustomerID is not available from SWOP. The
     * following rule must be used: SourceCustomerID = 'W-' + (last 14 chars from OOSKEY of the warranty OOS)
     *
     * @return
     */
    protected String generateSoucreCustomerID() {
        String result = "W-";
        String oosKey = null;
        ZWTYOOSINFO oos = ((ZWTYWTYENT) _transaction.getSourceSystemStandardReply()).getOOSINFO();
        if (oos != null) {
            oosKey = oos.getOOSKEY();
            if (oosKey != null) {
                if (oosKey.length() <= 14)
                    result += oosKey;
                else
                    result += oosKey.substring(oosKey.length() - 14, oosKey.length());
            }
        }
        return result;
    }
}
