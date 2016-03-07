package com.hp.es.service.routingDetails.integration.mapping;

import java.util.List;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZGISROUTINGDETAILS;
import com.hp.es.service.routingDetails.orchestration.RoutingDetailsTransaction;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.RoutingDetailsComplexType;
import com.hp.es.xml.service.types.ContractTypeType;
import com.hp.sif.SifException;

/**
 *
 * @author Chunyang
 * @since 10.1.5
 */
public class MetroRoutingDetailsMapper extends RoutingDetailsMapper {

    public MetroRoutingDetailsMapper(RoutingDetailsTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
        super(transaction, request, ctx);
    }

    public RoutingDetailsComplexType map() throws MappingException, SifException {
        RoutingDetailsComplexType result = new RoutingDetailsComplexType();
        ZGISROUTINGDETAILS sapRoutingDetails = (ZGISROUTINGDETAILS) (_transaction.getSourceSystemStandardReply());
        if (sapRoutingDetails != null) {

            // Map BusinessCode
            List<String> sapBusinessCodes = sapRoutingDetails.getBUSINESSCODES().getItem();
            if (sapRoutingDetails != null) {
                for (String sapBusinessCode : sapBusinessCodes) {
                    result.addBusinessCode(sapBusinessCode);                    
                }
            }

            // Map RepairTimeValue
            List<String> sapRepairTimeValues = sapRoutingDetails.getREPAIRTIMEVALUES().getItem();
            if (sapRepairTimeValues != null) {
                for (String sapRepairTimeValue : sapRepairTimeValues) {
                    result.addRepairTimeValue(sapRepairTimeValue);
                }
            }
            
            // Map ResponseTimeValue
            List<String> sapResponseTimeValues = sapRoutingDetails.getRESPONSETIMEVALUES().getItem();
            if (sapResponseTimeValues != null) {
                for (String sapResponseTimeValue : sapResponseTimeValues) {
                    result.addResponseTimeValue(sapResponseTimeValue);
                }
            }
            // Map RestorationTimeValue
            List<String> sapRestorationTimeValues = sapRoutingDetails.getRESTORATIONTIMEVALUES().getItem();
            if (sapRestorationTimeValues != null) {
                for (String sapRestorationTimeValue : sapRestorationTimeValues) {
                    result.addRestorationTimeValue(sapRestorationTimeValue);
                }
            }
            // Map ContractType
            String ct = sapRoutingDetails.getCONTRACTTYPE();
            if (ct != null)
                result.setContractType(ContractTypeType.valueOf(ct));
            // Map CustomerSegment
            result.setCustomerSegment(sapRoutingDetails.getCUSTOMERSEGMENT());
            // Map SoldToCompany
            result.setSoldToCompany(sapRoutingDetails.getSOLDTOCOMPANY());
            // Map SpecailHandling
            result.setSpecialHandling(MappingUtils.mapToBoolean(sapRoutingDetails.getSPECIALHANDLING()));
        }
        return result;
    }

}
