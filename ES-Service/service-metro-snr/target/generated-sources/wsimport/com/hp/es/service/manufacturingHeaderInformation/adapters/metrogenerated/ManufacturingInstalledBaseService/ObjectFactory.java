
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _PartToProductValidationRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartToProductValidationRequest");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _ProductShippingInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductShippingInformation");
    private final static QName _ComponentValidationRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentValidationRequest");
    private final static QName _BomAdditionalInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BomAdditionalInformation");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _ArrayOfProductBillOfMaterial_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfProductBillOfMaterial");
    private final static QName _PLConfidenceLevelRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PLConfidenceLevelRequest");
    private final static QName _ProductComponent_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductComponent");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _ProductShoppingBasket_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductShoppingBasket");
    private final static QName _SerialNumberExistsRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SerialNumberExistsRequest");
    private final static QName _ArrayOfProductShippingInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfProductShippingInformation");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _SparePart_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "spare_part");
    private final static QName _ProductBillOfMaterial_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductBillOfMaterial");
    private final static QName _TibcoMsg_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "TibcoMsg");
    private final static QName _ArrayOfProductShoppingBasket_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfProductShoppingBasket");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _ManufacturingBillOfMaterialResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ManufacturingBillOfMaterialResponse");
    private final static QName _ArrayOfsparePart_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfspare_part");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _WWSNRSPrimaryInput_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WWSNRSPrimaryInput");
    private final static QName _ValidSparePart_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ValidSparePart");
    private final static QName _ArrayOfProductComponent_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfProductComponent");
    private final static QName _ProductLifeCycleEventsRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductLifeCycleEventsRequest");
    private final static QName _PLConfidenceLevelResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PLConfidenceLevelResponse");
    private final static QName _ComponentValidationResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentValidationResponse");
    private final static QName _ArrayOfunitConfiguration_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfunit_configuration");
    private final static QName _ArrayOfBundleChildProduct_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfBundleChildProduct");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _ArrayOfValidSparePart_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfValidSparePart");
    private final static QName _WwsnrsTracePrimaryReturn_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WwsnrsTracePrimaryReturn");
    private final static QName _SerialNumberValidationResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SerialNumberValidationResponse");
    private final static QName _ArrayOfshoppingBasket_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfshopping_basket");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _SerialNumberExistsResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SerialNumberExistsResponse");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _ProductLifeCycleEventsResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductLifeCycleEventsResponse");
    private final static QName _SerialNumberValidationRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SerialNumberValidationRequest");
    private final static QName _BundleUnit_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BundleUnit");
    private final static QName _PartSearchInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartSearchInformation");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _ArrayOfBundleUnit_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfBundleUnit");
    private final static QName _ManufacturingBillOfMaterialRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ManufacturingBillOfMaterialRequest");
    private final static QName _ProductHierarchyInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductHierarchyInformation");
    private final static QName _UnitConfiguration_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "unit_configuration");
    private final static QName _WWSNRSHeader_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WWSNRSHeader");
    private final static QName _ComponentEvent_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentEvent");
    private final static QName _PartToProductValidationResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartToProductValidationResponse");
    private final static QName _RohsStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RohsStatus");
    private final static QName _ProductEvent_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductEvent");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _ArrayOfProductEvent_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfProductEvent");
    private final static QName _ArrayOfBundleInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfBundleInformation");
    private final static QName _BundleChildProduct_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BundleChildProduct");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _ArrayOfstring_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
    private final static QName _BundleInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BundleInformation");
    private final static QName _ArrayOfComponentEvent_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ArrayOfComponentEvent");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _PLConfidenceLevelInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PLConfidenceLevelInfo");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _ShoppingBasket_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "shopping_basket");
    private final static QName _RoHSUnitStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RoHS_unit_status");
    private final static QName _ArrayOfKeyValueOfstringstring_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfKeyValueOfstringstring");
    private final static QName _ProductShoppingBasketQuantity_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Quantity");
    private final static QName _ProductShoppingBasketLocationOptionDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "LocationOptionDescription");
    private final static QName _ProductShoppingBasketSBElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SB_Element1");
    private final static QName _ProductShoppingBasketSBElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SB_Element2");
    private final static QName _ProductShoppingBasketSBElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SB_Element3");
    private final static QName _ProductShoppingBasketPartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartNumber");
    private final static QName _ProductShoppingBasketPartDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartDescription");
    private final static QName _SerialNumberValidationResponseOriginalRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "OriginalRequest");
    private final static QName _SerialNumberValidationResponseErrorDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ErrorDescription");
    private final static QName _SerialNumberValidationResponseReasonWhyItsNotValid_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReasonWhyItsNotValid");
    private final static QName _SerialNumberValidationResponseReasonCodeWhyItsNotValid_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReasonCodeWhyItsNotValid");
    private final static QName _SerialNumberValidationResponseErrorCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ErrorCode");
    private final static QName _ComponentValidationResponseProductLineConfidenceLevelInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductLineConfidenceLevelInfo");
    private final static QName _ComponentValidationResponsePartToProductSearchResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartToProductSearchResponse");
    private final static QName _WWSNRSPrimaryInputUserName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "user_name");
    private final static QName _WWSNRSPrimaryInputRequestedDeliveryTs_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "requested_delivery_ts");
    private final static QName _WWSNRSPrimaryInputClientType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "client_type");
    private final static QName _WWSNRSPrimaryInputCountrySubdivisionCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "country_subdivision_code");
    private final static QName _WWSNRSPrimaryInputProductNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "product_no");
    private final static QName _WWSNRSPrimaryInputCountryCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "country_code");
    private final static QName _WWSNRSPrimaryInputPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "password");
    private final static QName _WWSNRSPrimaryInputSerialNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "serial_no");
    private final static QName _GetProductLifeCycleEventsInputParams_QNAME = new QName("http://tempuri.org/", "inputParams");
    private final static QName _ValidatePartToProductResponseValidatePartToProductResult_QNAME = new QName("http://tempuri.org/", "ValidatePartToProductResult");
    private final static QName _SerialNumberValidationRequestSerialNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SerialNumber");
    private final static QName _SerialNumberValidationRequestPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Password");
    private final static QName _SerialNumberValidationRequestUserName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UserName");
    private final static QName _SerialNumberValidationRequestProductNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductNumber");
    private final static QName _GetProductLifeCycleEventsResponseGetProductLifeCycleEventsResult_QNAME = new QName("http://tempuri.org/", "GetProductLifeCycleEventsResult");
    private final static QName _ShoppingBasketLocOptionDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "loc_option_description");
    private final static QName _ShoppingBasketSbElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sb_element2");
    private final static QName _ShoppingBasketPartDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "part_description");
    private final static QName _ShoppingBasketSbElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sb_element3");
    private final static QName _ShoppingBasketPartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "part_number");
    private final static QName _ShoppingBasketSbElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sb_element1");
    private final static QName _ShoppingBasketSbkQuantity_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sbk_quantity");
    private final static QName _ShoppingBasketSbModuleid_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sb_moduleid");
    private final static QName _ComponentValidationRequestProductLine_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductLine");
    private final static QName _ComponentValidationRequestReturnBillOfMaterialLevel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReturnBillOfMaterialLevel");
    private final static QName _RohsStatusRohsComplianceCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RohsComplianceCode");
    private final static QName _RohsStatusRohsComplianceDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RohsComplianceDescription");
    private final static QName _ProductLifeCycleEventsRequestCutOffDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "CutOffDate");
    private final static QName _ProductShippingInformationDeliveryTypeCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "DeliveryTypeCode");
    private final static QName _ProductShippingInformationShipToCountry_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShipToCountry");
    private final static QName _ProductShippingInformationDistributionChannel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "DistributionChannel");
    private final static QName _ProductShippingInformationOrderLineNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "OrderLineNumber");
    private final static QName _ProductShippingInformationCustNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "CustNumber");
    private final static QName _ProductShippingInformationSourceSystem_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SourceSystem");
    private final static QName _ProductShippingInformationInterCompFlag_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "InterCompFlag");
    private final static QName _ProductShippingInformationResellerAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ResellerAddress");
    private final static QName _ProductShippingInformationSalesOrderNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SalesOrderNumber");
    private final static QName _ProductShippingInformationShipmentDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShipmentDate");
    private final static QName _ProductShippingInformationReturnDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReturnDate");
    private final static QName _ProductShippingInformationResellerNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ResellerNumber");
    private final static QName _ProductShippingInformationQuantityShipped_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "QuantityShipped");
    private final static QName _ProductShippingInformationShipmentIdentifier_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShipmentIdentifier");
    private final static QName _ProductShippingInformationResellerCity_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ResellerCity");
    private final static QName _ProductShippingInformationMaterialNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "MaterialNumber");
    private final static QName _ProductShippingInformationResellerName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ResellerName");
    private final static QName _ProductShippingInformationResellerPostalCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ResellerPostalCode");
    private final static QName _ProductShippingInformationShipToLocationCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShipToLocationCode");
    private final static QName _ProductShippingInformationCustShipToId_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "CustShipToId");
    private final static QName _ProductShippingInformationUSElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "US_Element1");
    private final static QName _ProductShippingInformationUSElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "US_Element2");
    private final static QName _ProductShippingInformationShipFromLocationCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShipFromLocationCode");
    private final static QName _ProductShippingInformationSalesOrganizationCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SalesOrganizationCode");
    private final static QName _ProductShippingInformationUSElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "US_Element3");
    private final static QName _PLConfidenceLevelInfoManufacturingBillOfMaterialConfidence_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ManufacturingBillOfMaterialConfidence");
    private final static QName _PLConfidenceLevelInfoUnitConfidence_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UnitConfidence");
    private final static QName _PLConfidenceLevelInfoSupportBillOfMaterialConfidence_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SupportBillOfMaterialConfidence");
    private final static QName _BundleInformationModifiedDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ModifiedDate");
    private final static QName _BundleInformationCreatedDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "CreatedDate");
    private final static QName _BundleInformationSystemProductNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SystemProductNumber");
    private final static QName _BundleInformationSubFAOriginaId_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SubFAOriginaId");
    private final static QName _BundleInformationShippingDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShippingDate");
    private final static QName _BundleInformationDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Description");
    private final static QName _BundleInformationLocalizationOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "LocalizationOption");
    private final static QName _BundleInformationProductsInBundle_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductsInBundle");
    private final static QName _BundleInformationRecordOriginId_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RecordOriginId");
    private final static QName _BundleInformationOtherOptions_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "OtherOptions");
    private final static QName _BundleInformationWarrantyOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WarrantyOption");
    private final static QName _BundleInformationSystemSerialNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SystemSerialNumber");
    private final static QName _BundleInformationAssetTag_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "AssetTag");
    private final static QName _IsSerialNumberValidInputParams_QNAME = new QName("http://tempuri.org/", "InputParams");
    private final static QName _PartToProductValidationRequestReturnBOMLevel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReturnBOMLevel");
    private final static QName _BundleChildProductUnitSerialNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UnitSerialNumber");
    private final static QName _BundleChildProductUnitProductNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UnitProductNumber");
    private final static QName _ProductHierarchyInformationProductBrandName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductBrandName");
    private final static QName _ProductHierarchyInformationItemName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ItemName");
    private final static QName _ProductHierarchyInformationProductDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductDescription");
    private final static QName _ProductHierarchyInformationPIN_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PIN");
    private final static QName _ProductHierarchyInformationParentPIN_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ParentPIN");
    private final static QName _ProductHierarchyInformationLevelCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "LevelCode");
    private final static QName _ProductHierarchyInformationPricingDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PricingDescription");
    private final static QName _WWSNRSHeaderCOMBOMCount_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "COMBOMCount");
    private final static QName _WWSNRSHeaderBOMType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BOMType");
    private final static QName _WWSNRSHeaderDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "description");
    private final static QName _WWSNRSHeaderTibcomsg_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "tibcomsg");
    private final static QName _WWSNRSHeaderSPBOMCount_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SPBOMCount");
    private final static QName _WWSNRSHeaderCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "code");
    private final static QName _ProductComponentParentPartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ParentPartNumber");
    private final static QName _ProductComponentSupplierPartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SupplierPartNumber");
    private final static QName _ProductComponentBomLevel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BomLevel");
    private final static QName _ProductComponentComponentMaterialNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentMaterialNumber");
    private final static QName _ProductComponentManufactureDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ManufactureDate");
    private final static QName _ProductComponentSupplierID_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SupplierID");
    private final static QName _ProductComponentUCElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UC_Element1");
    private final static QName _ProductComponentUCElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UC_Element2");
    private final static QName _ProductComponentPartCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartCategory");
    private final static QName _ProductComponentComponentSerialNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentSerialNumber");
    private final static QName _ProductComponentUCElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UC_Element3");
    private final static QName _IsSerialNumberExistingResponseIsSerialNumberExistingResult_QNAME = new QName("http://tempuri.org/", "IsSerialNumberExistingResult");
    private final static QName _GetSerialInfoResponseGetSerialInfoResult_QNAME = new QName("http://tempuri.org/", "GetSerialInfoResult");
    private final static QName _IsSerialNumberValidResponseIsSerialNumberValidResult_QNAME = new QName("http://tempuri.org/", "IsSerialNumberValidResult");
    private final static QName _ProductEventChangeList_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ChangeList");
    private final static QName _ProductEventRecordCreationDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RecordCreationDate");
    private final static QName _ProductEventSequenceNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SequenceNumber");
    private final static QName _ProductEventLoaderName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "LoaderName");
    private final static QName _ProductEventChangeType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ChangeType");
    private final static QName _GetSerialInfoInputparams_QNAME = new QName("http://tempuri.org/", "inputparams");
    private final static QName _WwsnrsTracePrimaryReturnBundleUnits_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BundleUnits");
    private final static QName _WwsnrsTracePrimaryReturnHeader_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "header");
    private final static QName _WwsnrsTracePrimaryReturnWwsnrsinput_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "wwsnrsinput");
    private final static QName _RoHSUnitStatusRohsStatusCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "rohs_status_code");
    private final static QName _RoHSUnitStatusHasMinimumRohsException_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "has_minimum_rohs_exception");
    private final static QName _RoHSUnitStatusProductFamily_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Product_family");
    private final static QName _BundleUnitOrigUnitProductNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Orig_UnitProductNo");
    private final static QName _BundleUnitOrigSystemProductNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Orig_SystemProductNo");
    private final static QName _BundleUnitUnitProductNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UnitProductNo");
    private final static QName _BundleUnitFAOriginId_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "fAOriginId");
    private final static QName _BundleUnitOrigSystemSerialNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Orig_SystemSerialNo");
    private final static QName _BundleUnitShipDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShipDate");
    private final static QName _BundleUnitSystemProductNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SystemProductNo");
    private final static QName _BundleUnitSystemSerialNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SystemSerialNo");
    private final static QName _BundleUnitUnitSerialNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UnitSerialNo");
    private final static QName _BundleUnitWarranty_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Warranty");
    private final static QName _BundleUnitOrigUnitSerialNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Orig_UnitSerialNo");
    private final static QName _BundleUnitOther_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Other");
    private final static QName _BundleUnitLocalization_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Localization");
    private final static QName _BundleUnitChildren_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Children");
    private final static QName _UnitConfigurationUcElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_element3");
    private final static QName _UnitConfigurationUcHasMinimumRohsException_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_has_minimum_rohs_exception");
    private final static QName _UnitConfigurationUcOrderinstr_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_orderinstr");
    private final static QName _UnitConfigurationParentPartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "parent_part_number");
    private final static QName _UnitConfigurationUcRohsStatusCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_rohs_status_code");
    private final static QName _UnitConfigurationUcMaterialgrp_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_materialgrp");
    private final static QName _UnitConfigurationUcCsrflag_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_csrflag");
    private final static QName _UnitConfigurationUcUsagepercentage_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_usagepercentage");
    private final static QName _UnitConfigurationUcElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_element2");
    private final static QName _UnitConfigurationUcElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_element1");
    private final static QName _UnitConfigurationUcReturnableflag_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_returnableflag");
    private final static QName _UnitConfigurationUcModuleid_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_moduleid");
    private final static QName _UnitConfigurationUcUnitofmeasure_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_unitofmeasure");
    private final static QName _UnitConfigurationUcHazardous_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_hazardous");
    private final static QName _UnitConfigurationPartSerialno_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "part_serialno");
    private final static QName _UnitConfigurationPartQuantity_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "part_quantity");
    private final static QName _UnitConfigurationUcMaterialgrptxt_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_materialgrptxt");
    private final static QName _UnitConfigurationUcTechcourier_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "uc_techcourier");
    private final static QName _ManufacturingComponentValidationResponseManufacturingComponentValidationResult_QNAME = new QName("http://tempuri.org/", "ManufacturingComponentValidationResult");
    private final static QName _ManufacturingBillOfMaterialResponseProductBillOfMaterialSearchResults_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductBillOfMaterialSearchResults");
    private final static QName _GetProductLineConfidenceLevelResponseGetProductLineConfidenceLevelResult_QNAME = new QName("http://tempuri.org/", "GetProductLineConfidenceLevelResult");
    private final static QName _SparePartSpUsagepercentage_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_usagepercentage");
    private final static QName _SparePartSpareEnhanceDesc_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "spare_enhance_desc");
    private final static QName _SparePartSparePartDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "spare_part_description");
    private final static QName _SparePartSpIsWholeUnit_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_is_whole_unit");
    private final static QName _SparePartSpMaterialgrptxt_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_materialgrptxt");
    private final static QName _SparePartSpKeyword_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_keyword");
    private final static QName _SparePartSpOrderinstr_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_orderinstr");
    private final static QName _SparePartSpRequestedDeliveryTs_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_requested_delivery_ts");
    private final static QName _SparePartSpHazardous_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_hazardous");
    private final static QName _SparePartSpCsrflag_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_csrflag");
    private final static QName _SparePartSpTechcourier_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_techcourier");
    private final static QName _SparePartSpMaterialgrp_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_materialgrp");
    private final static QName _SparePartSpUnitofmeasure_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_unitofmeasure");
    private final static QName _SparePartSpElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_element2");
    private final static QName _SparePartSpElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_element3");
    private final static QName _SparePartSparePartNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "spare_part_no");
    private final static QName _SparePartSpStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_status");
    private final static QName _SparePartSpElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_element1");
    private final static QName _SparePartSpCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_category");
    private final static QName _SparePartSpIsCompliantWithProduct_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_is_compliant_with_product");
    private final static QName _SparePartSpIsCompliantWithRohsJurisdiction_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_is_compliant_with_rohs_jurisdiction");
    private final static QName _SparePartSpRohsStatusCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_rohs_status_code");
    private final static QName _SparePartSpReturnableflag_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "sp_returnableflag");
    private final static QName _ManufacturingBillOfMaterialRequestReturnInfoModifier_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReturnInfoModifier");
    private final static QName _ManufacturingBillOfMaterialRequestCommodityTrackingNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "CommodityTrackingNumber");
    private final static QName _ManufacturingBillOfMaterialRequestMACAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "MACAddress");
    private final static QName _ManufacturingBillOfMaterialRequestReturnInfoLevel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ReturnInfoLevel");
    private final static QName _ManufacturingBillOfMaterialRequestUUID_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UUID");
    private final static QName _ManufacturingBillOfMaterialRequestServiceAgreementID_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ServiceAgreementID");
    private final static QName _ManufacturingBillOfMaterialRequestSecurityLabel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SecurityLabel");
    private final static QName _ComponentEventComponentProductNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentProductNumber");
    private final static QName _ProductLifeCycleEventsResponseProductEvents_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductEvents");
    private final static QName _ProductLifeCycleEventsResponseComponentEvents_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ComponentEvents");
    private final static QName _TibcoMsgTibcoCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "tibco_code");
    private final static QName _TibcoMsgTibcoDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "tibco_description");
    private final static QName _ValidSparePartPartRelationType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartRelationType");
    private final static QName _ValidSparePartRoHSSpareComplianceCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RoHS_spare_compliance_code");
    private final static QName _ValidSparePartUnitOfMeasure_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UnitOfMeasure");
    private final static QName _ValidSparePartRohsStatusInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RohsStatusInfo");
    private final static QName _ValidSparePartSparePartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SparePartNumber");
    private final static QName _ValidSparePartExchangePartNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ExchangePartNumber");
    private final static QName _ValidSparePartSparePartDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SparePartDescription");
    private final static QName _ValidSparePartSpElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Sp_Element1");
    private final static QName _ValidSparePartPartProductType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartProductType");
    private final static QName _ValidSparePartProductOdmCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductOdmCode");
    private final static QName _ValidSparePartSpElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Sp_Element2");
    private final static QName _ValidSparePartSpElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Sp_Element3");
    private final static QName _ValidSparePartProductId_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductId");
    private final static QName _GetManufacturingBillOfMaterialResponseGetManufacturingBillOfMaterialResult_QNAME = new QName("http://tempuri.org/", "GetManufacturingBillOfMaterialResult");
    private final static QName _ProductBillOfMaterialProgramType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProgramType");
    private final static QName _ProductBillOfMaterialDivision_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Division");
    private final static QName _ProductBillOfMaterialRecordLastUpdateDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "RecordLastUpdateDate");
    private final static QName _ProductBillOfMaterialFamily_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Family");
    private final static QName _ProductBillOfMaterialCurrentLifeCycleStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "CurrentLifeCycleStatus");
    private final static QName _ProductBillOfMaterialLine_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Line");
    private final static QName _ProductBillOfMaterialPlant_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Plant");
    private final static QName _ProductBillOfMaterialSite_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Site");
    private final static QName _ProductBillOfMaterialWarrantyCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WarrantyCode");
    private final static QName _ProductBillOfMaterialProduct_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Product");
    private final static QName _ProductBillOfMaterialComponents_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Components");
    private final static QName _ProductBillOfMaterialSku_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Sku");
    private final static QName _ProductBillOfMaterialPlantCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PlantCode");
    private final static QName _ProductBillOfMaterialBOMAdditionalInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BOMAdditionalInformation");
    private final static QName _ProductBillOfMaterialValidSparePartsInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ValidSparePartsInfo");
    private final static QName _ProductBillOfMaterialProgramName_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProgramName");
    private final static QName _ProductBillOfMaterialSiteCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "SiteCode");
    private final static QName _ProductBillOfMaterialProductHierarchyInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductHierarchyInfo");
    private final static QName _ProductBillOfMaterialDataSourceInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "DataSourceInfo");
    private final static QName _ProductBillOfMaterialUIElement3_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UI_Element3");
    private final static QName _ProductBillOfMaterialShippingInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShippingInfo");
    private final static QName _ProductBillOfMaterialPartnerType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "PartnerType");
    private final static QName _ProductBillOfMaterialUIElement1_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UI_Element1");
    private final static QName _ProductBillOfMaterialBundleInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "BundleInfo");
    private final static QName _ProductBillOfMaterialUIElement2_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "UI_Element2");
    private final static QName _ProductBillOfMaterialModel_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Model");
    private final static QName _ProductBillOfMaterialOdmCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "OdmCode");
    private final static QName _ProductBillOfMaterialType_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Type");
    private final static QName _ProductBillOfMaterialWarrantyDuration_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WarrantyDuration");
    private final static QName _ProductBillOfMaterialEOLStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "EOL_Status");
    private final static QName _ProductBillOfMaterialProductCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ProductCategory");
    private final static QName _ProductBillOfMaterialShoppingBaskets_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "ShoppingBaskets");
    private final static QName _ProductBillOfMaterialWarrantyStart_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "WarrantyStart");
    private final static QName _ProductBillOfMaterialGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", "Group");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductShoppingBasket }
     * 
     */
    public ProductShoppingBasket createProductShoppingBasket() {
        return new ProductShoppingBasket();
    }

    /**
     * Create an instance of {@link SerialNumberValidationResponse }
     * 
     */
    public SerialNumberValidationResponse createSerialNumberValidationResponse() {
        return new SerialNumberValidationResponse();
    }

    /**
     * Create an instance of {@link ComponentValidationResponse }
     * 
     */
    public ComponentValidationResponse createComponentValidationResponse() {
        return new ComponentValidationResponse();
    }

    /**
     * Create an instance of {@link ArrayOfsparePart }
     * 
     */
    public ArrayOfsparePart createArrayOfsparePart() {
        return new ArrayOfsparePart();
    }

    /**
     * Create an instance of {@link WWSNRSPrimaryInput }
     * 
     */
    public WWSNRSPrimaryInput createWWSNRSPrimaryInput() {
        return new WWSNRSPrimaryInput();
    }

    /**
     * Create an instance of {@link ArrayOfValidSparePart }
     * 
     */
    public ArrayOfValidSparePart createArrayOfValidSparePart() {
        return new ArrayOfValidSparePart();
    }

    /**
     * Create an instance of {@link GetProductLifeCycleEvents }
     * 
     */
    public GetProductLifeCycleEvents createGetProductLifeCycleEvents() {
        return new GetProductLifeCycleEvents();
    }

    /**
     * Create an instance of {@link ValidatePartToProductResponse }
     * 
     */
    public ValidatePartToProductResponse createValidatePartToProductResponse() {
        return new ValidatePartToProductResponse();
    }

    /**
     * Create an instance of {@link SerialNumberValidationRequest }
     * 
     */
    public SerialNumberValidationRequest createSerialNumberValidationRequest() {
        return new SerialNumberValidationRequest();
    }

    /**
     * Create an instance of {@link GetProductLifeCycleEventsResponse }
     * 
     */
    public GetProductLifeCycleEventsResponse createGetProductLifeCycleEventsResponse() {
        return new GetProductLifeCycleEventsResponse();
    }

    /**
     * Create an instance of {@link ShoppingBasket }
     * 
     */
    public ShoppingBasket createShoppingBasket() {
        return new ShoppingBasket();
    }

    /**
     * Create an instance of {@link ComponentValidationRequest }
     * 
     */
    public ComponentValidationRequest createComponentValidationRequest() {
        return new ComponentValidationRequest();
    }

    /**
     * Create an instance of {@link RohsStatus }
     * 
     */
    public RohsStatus createRohsStatus() {
        return new RohsStatus();
    }

    /**
     * Create an instance of {@link ArrayOfunitConfiguration }
     * 
     */
    public ArrayOfunitConfiguration createArrayOfunitConfiguration() {
        return new ArrayOfunitConfiguration();
    }

    /**
     * Create an instance of {@link ProductLifeCycleEventsRequest }
     * 
     */
    public ProductLifeCycleEventsRequest createProductLifeCycleEventsRequest() {
        return new ProductLifeCycleEventsRequest();
    }

    /**
     * Create an instance of {@link ProductShippingInformation }
     * 
     */
    public ProductShippingInformation createProductShippingInformation() {
        return new ProductShippingInformation();
    }

    /**
     * Create an instance of {@link ArrayOfProductShippingInformation }
     * 
     */
    public ArrayOfProductShippingInformation createArrayOfProductShippingInformation() {
        return new ArrayOfProductShippingInformation();
    }

    /**
     * Create an instance of {@link PLConfidenceLevelResponse }
     * 
     */
    public PLConfidenceLevelResponse createPLConfidenceLevelResponse() {
        return new PLConfidenceLevelResponse();
    }

    /**
     * Create an instance of {@link SerialNumberExistsRequest }
     * 
     */
    public SerialNumberExistsRequest createSerialNumberExistsRequest() {
        return new SerialNumberExistsRequest();
    }

    /**
     * Create an instance of {@link PLConfidenceLevelInfo }
     * 
     */
    public PLConfidenceLevelInfo createPLConfidenceLevelInfo() {
        return new PLConfidenceLevelInfo();
    }

    /**
     * Create an instance of {@link ArrayOfKeyValueOfstringstring }
     * 
     */
    public ArrayOfKeyValueOfstringstring createArrayOfKeyValueOfstringstring() {
        return new ArrayOfKeyValueOfstringstring();
    }

    /**
     * Create an instance of {@link BundleInformation }
     * 
     */
    public BundleInformation createBundleInformation() {
        return new BundleInformation();
    }

    /**
     * Create an instance of {@link IsSerialNumberValid }
     * 
     */
    public IsSerialNumberValid createIsSerialNumberValid() {
        return new IsSerialNumberValid();
    }

    /**
     * Create an instance of {@link PartToProductValidationRequest }
     * 
     */
    public PartToProductValidationRequest createPartToProductValidationRequest() {
        return new PartToProductValidationRequest();
    }

    /**
     * Create an instance of {@link ManufacturingComponentValidation }
     * 
     */
    public ManufacturingComponentValidation createManufacturingComponentValidation() {
        return new ManufacturingComponentValidation();
    }

    /**
     * Create an instance of {@link ProductHierarchyInformation }
     * 
     */
    public ProductHierarchyInformation createProductHierarchyInformation() {
        return new ProductHierarchyInformation();
    }

    /**
     * Create an instance of {@link BundleChildProduct }
     * 
     */
    public BundleChildProduct createBundleChildProduct() {
        return new BundleChildProduct();
    }

    /**
     * Create an instance of {@link WWSNRSHeader }
     * 
     */
    public WWSNRSHeader createWWSNRSHeader() {
        return new WWSNRSHeader();
    }

    /**
     * Create an instance of {@link SerialNumberExistsResponse }
     * 
     */
    public SerialNumberExistsResponse createSerialNumberExistsResponse() {
        return new SerialNumberExistsResponse();
    }

    /**
     * Create an instance of {@link ProductComponent }
     * 
     */
    public ProductComponent createProductComponent() {
        return new ProductComponent();
    }

    /**
     * Create an instance of {@link PLConfidenceLevelRequest }
     * 
     */
    public PLConfidenceLevelRequest createPLConfidenceLevelRequest() {
        return new PLConfidenceLevelRequest();
    }

    /**
     * Create an instance of {@link IsSerialNumberExistingResponse }
     * 
     */
    public IsSerialNumberExistingResponse createIsSerialNumberExistingResponse() {
        return new IsSerialNumberExistingResponse();
    }

    /**
     * Create an instance of {@link ArrayOfstring }
     * 
     */
    public ArrayOfstring createArrayOfstring() {
        return new ArrayOfstring();
    }

    /**
     * Create an instance of {@link BomAdditionalInformation }
     * 
     */
    public BomAdditionalInformation createBomAdditionalInformation() {
        return new BomAdditionalInformation();
    }

    /**
     * Create an instance of {@link ArrayOfProductShoppingBasket }
     * 
     */
    public ArrayOfProductShoppingBasket createArrayOfProductShoppingBasket() {
        return new ArrayOfProductShoppingBasket();
    }

    /**
     * Create an instance of {@link ArrayOfProductBillOfMaterial }
     * 
     */
    public ArrayOfProductBillOfMaterial createArrayOfProductBillOfMaterial() {
        return new ArrayOfProductBillOfMaterial();
    }

    /**
     * Create an instance of {@link GetSerialInfoResponse }
     * 
     */
    public GetSerialInfoResponse createGetSerialInfoResponse() {
        return new GetSerialInfoResponse();
    }

    /**
     * Create an instance of {@link IsSerialNumberValidResponse }
     * 
     */
    public IsSerialNumberValidResponse createIsSerialNumberValidResponse() {
        return new IsSerialNumberValidResponse();
    }

    /**
     * Create an instance of {@link PartToProductValidationResponse }
     * 
     */
    public PartToProductValidationResponse createPartToProductValidationResponse() {
        return new PartToProductValidationResponse();
    }

    /**
     * Create an instance of {@link ProductEvent }
     * 
     */
    public ProductEvent createProductEvent() {
        return new ProductEvent();
    }

    /**
     * Create an instance of {@link GetSerialInfo }
     * 
     */
    public GetSerialInfo createGetSerialInfo() {
        return new GetSerialInfo();
    }

    /**
     * Create an instance of {@link WwsnrsTracePrimaryReturn }
     * 
     */
    public WwsnrsTracePrimaryReturn createWwsnrsTracePrimaryReturn() {
        return new WwsnrsTracePrimaryReturn();
    }

    /**
     * Create an instance of {@link GetManufacturingBillOfMaterial }
     * 
     */
    public GetManufacturingBillOfMaterial createGetManufacturingBillOfMaterial() {
        return new GetManufacturingBillOfMaterial();
    }

    /**
     * Create an instance of {@link ArrayOfBundleInformation }
     * 
     */
    public ArrayOfBundleInformation createArrayOfBundleInformation() {
        return new ArrayOfBundleInformation();
    }

    /**
     * Create an instance of {@link RoHSUnitStatus }
     * 
     */
    public RoHSUnitStatus createRoHSUnitStatus() {
        return new RoHSUnitStatus();
    }

    /**
     * Create an instance of {@link BundleUnit }
     * 
     */
    public BundleUnit createBundleUnit() {
        return new BundleUnit();
    }

    /**
     * Create an instance of {@link ArrayOfProductEvent }
     * 
     */
    public ArrayOfProductEvent createArrayOfProductEvent() {
        return new ArrayOfProductEvent();
    }

    /**
     * Create an instance of {@link ArrayOfKeyValueOfstringstring.KeyValueOfstringstring }
     * 
     */
    public ArrayOfKeyValueOfstringstring.KeyValueOfstringstring createArrayOfKeyValueOfstringstringKeyValueOfstringstring() {
        return new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();
    }

    /**
     * Create an instance of {@link UnitConfiguration }
     * 
     */
    public UnitConfiguration createUnitConfiguration() {
        return new UnitConfiguration();
    }

    /**
     * Create an instance of {@link ValidatePartToProduct }
     * 
     */
    public ValidatePartToProduct createValidatePartToProduct() {
        return new ValidatePartToProduct();
    }

    /**
     * Create an instance of {@link PartSearchInformation }
     * 
     */
    public PartSearchInformation createPartSearchInformation() {
        return new PartSearchInformation();
    }

    /**
     * Create an instance of {@link ArrayOfBundleUnit }
     * 
     */
    public ArrayOfBundleUnit createArrayOfBundleUnit() {
        return new ArrayOfBundleUnit();
    }

    /**
     * Create an instance of {@link ManufacturingComponentValidationResponse }
     * 
     */
    public ManufacturingComponentValidationResponse createManufacturingComponentValidationResponse() {
        return new ManufacturingComponentValidationResponse();
    }

    /**
     * Create an instance of {@link ManufacturingBillOfMaterialResponse }
     * 
     */
    public ManufacturingBillOfMaterialResponse createManufacturingBillOfMaterialResponse() {
        return new ManufacturingBillOfMaterialResponse();
    }

    /**
     * Create an instance of {@link ArrayOfshoppingBasket }
     * 
     */
    public ArrayOfshoppingBasket createArrayOfshoppingBasket() {
        return new ArrayOfshoppingBasket();
    }

    /**
     * Create an instance of {@link GetProductLineConfidenceLevelResponse }
     * 
     */
    public GetProductLineConfidenceLevelResponse createGetProductLineConfidenceLevelResponse() {
        return new GetProductLineConfidenceLevelResponse();
    }

    /**
     * Create an instance of {@link ManufacturingBillOfMaterialRequest }
     * 
     */
    public ManufacturingBillOfMaterialRequest createManufacturingBillOfMaterialRequest() {
        return new ManufacturingBillOfMaterialRequest();
    }

    /**
     * Create an instance of {@link SparePart }
     * 
     */
    public SparePart createSparePart() {
        return new SparePart();
    }

    /**
     * Create an instance of {@link ComponentEvent }
     * 
     */
    public ComponentEvent createComponentEvent() {
        return new ComponentEvent();
    }

    /**
     * Create an instance of {@link ArrayOfProductComponent }
     * 
     */
    public ArrayOfProductComponent createArrayOfProductComponent() {
        return new ArrayOfProductComponent();
    }

    /**
     * Create an instance of {@link ArrayOfBundleChildProduct }
     * 
     */
    public ArrayOfBundleChildProduct createArrayOfBundleChildProduct() {
        return new ArrayOfBundleChildProduct();
    }

    /**
     * Create an instance of {@link ProductLifeCycleEventsResponse }
     * 
     */
    public ProductLifeCycleEventsResponse createProductLifeCycleEventsResponse() {
        return new ProductLifeCycleEventsResponse();
    }

    /**
     * Create an instance of {@link ValidSparePart }
     * 
     */
    public ValidSparePart createValidSparePart() {
        return new ValidSparePart();
    }

    /**
     * Create an instance of {@link TibcoMsg }
     * 
     */
    public TibcoMsg createTibcoMsg() {
        return new TibcoMsg();
    }

    /**
     * Create an instance of {@link GetProductLineConfidenceLevel }
     * 
     */
    public GetProductLineConfidenceLevel createGetProductLineConfidenceLevel() {
        return new GetProductLineConfidenceLevel();
    }

    /**
     * Create an instance of {@link IsSerialNumberExisting }
     * 
     */
    public IsSerialNumberExisting createIsSerialNumberExisting() {
        return new IsSerialNumberExisting();
    }

    /**
     * Create an instance of {@link GetManufacturingBillOfMaterialResponse }
     * 
     */
    public GetManufacturingBillOfMaterialResponse createGetManufacturingBillOfMaterialResponse() {
        return new GetManufacturingBillOfMaterialResponse();
    }

    /**
     * Create an instance of {@link ArrayOfComponentEvent }
     * 
     */
    public ArrayOfComponentEvent createArrayOfComponentEvent() {
        return new ArrayOfComponentEvent();
    }

    /**
     * Create an instance of {@link ProductBillOfMaterial }
     * 
     */
    public ProductBillOfMaterial createProductBillOfMaterial() {
        return new ProductBillOfMaterial();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartToProductValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartToProductValidationRequest")
    public JAXBElement<PartToProductValidationRequest> createPartToProductValidationRequest(PartToProductValidationRequest value) {
        return new JAXBElement<PartToProductValidationRequest>(_PartToProductValidationRequest_QNAME, PartToProductValidationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductShippingInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductShippingInformation")
    public JAXBElement<ProductShippingInformation> createProductShippingInformation(ProductShippingInformation value) {
        return new JAXBElement<ProductShippingInformation>(_ProductShippingInformation_QNAME, ProductShippingInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentValidationRequest")
    public JAXBElement<ComponentValidationRequest> createComponentValidationRequest(ComponentValidationRequest value) {
        return new JAXBElement<ComponentValidationRequest>(_ComponentValidationRequest_QNAME, ComponentValidationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BomAdditionalInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BomAdditionalInformation")
    public JAXBElement<BomAdditionalInformation> createBomAdditionalInformation(BomAdditionalInformation value) {
        return new JAXBElement<BomAdditionalInformation>(_BomAdditionalInformation_QNAME, BomAdditionalInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductBillOfMaterial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfProductBillOfMaterial")
    public JAXBElement<ArrayOfProductBillOfMaterial> createArrayOfProductBillOfMaterial(ArrayOfProductBillOfMaterial value) {
        return new JAXBElement<ArrayOfProductBillOfMaterial>(_ArrayOfProductBillOfMaterial_QNAME, ArrayOfProductBillOfMaterial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PLConfidenceLevelRequest")
    public JAXBElement<PLConfidenceLevelRequest> createPLConfidenceLevelRequest(PLConfidenceLevelRequest value) {
        return new JAXBElement<PLConfidenceLevelRequest>(_PLConfidenceLevelRequest_QNAME, PLConfidenceLevelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductComponent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductComponent")
    public JAXBElement<ProductComponent> createProductComponent(ProductComponent value) {
        return new JAXBElement<ProductComponent>(_ProductComponent_QNAME, ProductComponent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductShoppingBasket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductShoppingBasket")
    public JAXBElement<ProductShoppingBasket> createProductShoppingBasket(ProductShoppingBasket value) {
        return new JAXBElement<ProductShoppingBasket>(_ProductShoppingBasket_QNAME, ProductShoppingBasket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberExistsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumberExistsRequest")
    public JAXBElement<SerialNumberExistsRequest> createSerialNumberExistsRequest(SerialNumberExistsRequest value) {
        return new JAXBElement<SerialNumberExistsRequest>(_SerialNumberExistsRequest_QNAME, SerialNumberExistsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductShippingInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfProductShippingInformation")
    public JAXBElement<ArrayOfProductShippingInformation> createArrayOfProductShippingInformation(ArrayOfProductShippingInformation value) {
        return new JAXBElement<ArrayOfProductShippingInformation>(_ArrayOfProductShippingInformation_QNAME, ArrayOfProductShippingInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SparePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "spare_part")
    public JAXBElement<SparePart> createSparePart(SparePart value) {
        return new JAXBElement<SparePart>(_SparePart_QNAME, SparePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductBillOfMaterial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductBillOfMaterial")
    public JAXBElement<ProductBillOfMaterial> createProductBillOfMaterial(ProductBillOfMaterial value) {
        return new JAXBElement<ProductBillOfMaterial>(_ProductBillOfMaterial_QNAME, ProductBillOfMaterial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TibcoMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "TibcoMsg")
    public JAXBElement<TibcoMsg> createTibcoMsg(TibcoMsg value) {
        return new JAXBElement<TibcoMsg>(_TibcoMsg_QNAME, TibcoMsg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductShoppingBasket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfProductShoppingBasket")
    public JAXBElement<ArrayOfProductShoppingBasket> createArrayOfProductShoppingBasket(ArrayOfProductShoppingBasket value) {
        return new JAXBElement<ArrayOfProductShoppingBasket>(_ArrayOfProductShoppingBasket_QNAME, ArrayOfProductShoppingBasket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ManufacturingBillOfMaterialResponse")
    public JAXBElement<ManufacturingBillOfMaterialResponse> createManufacturingBillOfMaterialResponse(ManufacturingBillOfMaterialResponse value) {
        return new JAXBElement<ManufacturingBillOfMaterialResponse>(_ManufacturingBillOfMaterialResponse_QNAME, ManufacturingBillOfMaterialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfsparePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfspare_part")
    public JAXBElement<ArrayOfsparePart> createArrayOfsparePart(ArrayOfsparePart value) {
        return new JAXBElement<ArrayOfsparePart>(_ArrayOfsparePart_QNAME, ArrayOfsparePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WWSNRSPrimaryInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WWSNRSPrimaryInput")
    public JAXBElement<WWSNRSPrimaryInput> createWWSNRSPrimaryInput(WWSNRSPrimaryInput value) {
        return new JAXBElement<WWSNRSPrimaryInput>(_WWSNRSPrimaryInput_QNAME, WWSNRSPrimaryInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidSparePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ValidSparePart")
    public JAXBElement<ValidSparePart> createValidSparePart(ValidSparePart value) {
        return new JAXBElement<ValidSparePart>(_ValidSparePart_QNAME, ValidSparePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductComponent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfProductComponent")
    public JAXBElement<ArrayOfProductComponent> createArrayOfProductComponent(ArrayOfProductComponent value) {
        return new JAXBElement<ArrayOfProductComponent>(_ArrayOfProductComponent_QNAME, ArrayOfProductComponent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductLifeCycleEventsRequest")
    public JAXBElement<ProductLifeCycleEventsRequest> createProductLifeCycleEventsRequest(ProductLifeCycleEventsRequest value) {
        return new JAXBElement<ProductLifeCycleEventsRequest>(_ProductLifeCycleEventsRequest_QNAME, ProductLifeCycleEventsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PLConfidenceLevelResponse")
    public JAXBElement<PLConfidenceLevelResponse> createPLConfidenceLevelResponse(PLConfidenceLevelResponse value) {
        return new JAXBElement<PLConfidenceLevelResponse>(_PLConfidenceLevelResponse_QNAME, PLConfidenceLevelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentValidationResponse")
    public JAXBElement<ComponentValidationResponse> createComponentValidationResponse(ComponentValidationResponse value) {
        return new JAXBElement<ComponentValidationResponse>(_ComponentValidationResponse_QNAME, ComponentValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunitConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfunit_configuration")
    public JAXBElement<ArrayOfunitConfiguration> createArrayOfunitConfiguration(ArrayOfunitConfiguration value) {
        return new JAXBElement<ArrayOfunitConfiguration>(_ArrayOfunitConfiguration_QNAME, ArrayOfunitConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleChildProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfBundleChildProduct")
    public JAXBElement<ArrayOfBundleChildProduct> createArrayOfBundleChildProduct(ArrayOfBundleChildProduct value) {
        return new JAXBElement<ArrayOfBundleChildProduct>(_ArrayOfBundleChildProduct_QNAME, ArrayOfBundleChildProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfValidSparePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfValidSparePart")
    public JAXBElement<ArrayOfValidSparePart> createArrayOfValidSparePart(ArrayOfValidSparePart value) {
        return new JAXBElement<ArrayOfValidSparePart>(_ArrayOfValidSparePart_QNAME, ArrayOfValidSparePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WwsnrsTracePrimaryReturn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WwsnrsTracePrimaryReturn")
    public JAXBElement<WwsnrsTracePrimaryReturn> createWwsnrsTracePrimaryReturn(WwsnrsTracePrimaryReturn value) {
        return new JAXBElement<WwsnrsTracePrimaryReturn>(_WwsnrsTracePrimaryReturn_QNAME, WwsnrsTracePrimaryReturn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumberValidationResponse")
    public JAXBElement<SerialNumberValidationResponse> createSerialNumberValidationResponse(SerialNumberValidationResponse value) {
        return new JAXBElement<SerialNumberValidationResponse>(_SerialNumberValidationResponse_QNAME, SerialNumberValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfshoppingBasket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfshopping_basket")
    public JAXBElement<ArrayOfshoppingBasket> createArrayOfshoppingBasket(ArrayOfshoppingBasket value) {
        return new JAXBElement<ArrayOfshoppingBasket>(_ArrayOfshoppingBasket_QNAME, ArrayOfshoppingBasket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumberExistsResponse")
    public JAXBElement<SerialNumberExistsResponse> createSerialNumberExistsResponse(SerialNumberExistsResponse value) {
        return new JAXBElement<SerialNumberExistsResponse>(_SerialNumberExistsResponse_QNAME, SerialNumberExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductLifeCycleEventsResponse")
    public JAXBElement<ProductLifeCycleEventsResponse> createProductLifeCycleEventsResponse(ProductLifeCycleEventsResponse value) {
        return new JAXBElement<ProductLifeCycleEventsResponse>(_ProductLifeCycleEventsResponse_QNAME, ProductLifeCycleEventsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumberValidationRequest")
    public JAXBElement<SerialNumberValidationRequest> createSerialNumberValidationRequest(SerialNumberValidationRequest value) {
        return new JAXBElement<SerialNumberValidationRequest>(_SerialNumberValidationRequest_QNAME, SerialNumberValidationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BundleUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BundleUnit")
    public JAXBElement<BundleUnit> createBundleUnit(BundleUnit value) {
        return new JAXBElement<BundleUnit>(_BundleUnit_QNAME, BundleUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartSearchInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartSearchInformation")
    public JAXBElement<PartSearchInformation> createPartSearchInformation(PartSearchInformation value) {
        return new JAXBElement<PartSearchInformation>(_PartSearchInformation_QNAME, PartSearchInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfBundleUnit")
    public JAXBElement<ArrayOfBundleUnit> createArrayOfBundleUnit(ArrayOfBundleUnit value) {
        return new JAXBElement<ArrayOfBundleUnit>(_ArrayOfBundleUnit_QNAME, ArrayOfBundleUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ManufacturingBillOfMaterialRequest")
    public JAXBElement<ManufacturingBillOfMaterialRequest> createManufacturingBillOfMaterialRequest(ManufacturingBillOfMaterialRequest value) {
        return new JAXBElement<ManufacturingBillOfMaterialRequest>(_ManufacturingBillOfMaterialRequest_QNAME, ManufacturingBillOfMaterialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductHierarchyInformation")
    public JAXBElement<ProductHierarchyInformation> createProductHierarchyInformation(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductHierarchyInformation_QNAME, ProductHierarchyInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnitConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "unit_configuration")
    public JAXBElement<UnitConfiguration> createUnitConfiguration(UnitConfiguration value) {
        return new JAXBElement<UnitConfiguration>(_UnitConfiguration_QNAME, UnitConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WWSNRSHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WWSNRSHeader")
    public JAXBElement<WWSNRSHeader> createWWSNRSHeader(WWSNRSHeader value) {
        return new JAXBElement<WWSNRSHeader>(_WWSNRSHeader_QNAME, WWSNRSHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentEvent")
    public JAXBElement<ComponentEvent> createComponentEvent(ComponentEvent value) {
        return new JAXBElement<ComponentEvent>(_ComponentEvent_QNAME, ComponentEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartToProductValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartToProductValidationResponse")
    public JAXBElement<PartToProductValidationResponse> createPartToProductValidationResponse(PartToProductValidationResponse value) {
        return new JAXBElement<PartToProductValidationResponse>(_PartToProductValidationResponse_QNAME, PartToProductValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RohsStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RohsStatus")
    public JAXBElement<RohsStatus> createRohsStatus(RohsStatus value) {
        return new JAXBElement<RohsStatus>(_RohsStatus_QNAME, RohsStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductEvent")
    public JAXBElement<ProductEvent> createProductEvent(ProductEvent value) {
        return new JAXBElement<ProductEvent>(_ProductEvent_QNAME, ProductEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfProductEvent")
    public JAXBElement<ArrayOfProductEvent> createArrayOfProductEvent(ArrayOfProductEvent value) {
        return new JAXBElement<ArrayOfProductEvent>(_ArrayOfProductEvent_QNAME, ArrayOfProductEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfBundleInformation")
    public JAXBElement<ArrayOfBundleInformation> createArrayOfBundleInformation(ArrayOfBundleInformation value) {
        return new JAXBElement<ArrayOfBundleInformation>(_ArrayOfBundleInformation_QNAME, ArrayOfBundleInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BundleChildProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BundleChildProduct")
    public JAXBElement<BundleChildProduct> createBundleChildProduct(BundleChildProduct value) {
        return new JAXBElement<BundleChildProduct>(_BundleChildProduct_QNAME, BundleChildProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfstring")
    public JAXBElement<ArrayOfstring> createArrayOfstring(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ArrayOfstring_QNAME, ArrayOfstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BundleInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BundleInformation")
    public JAXBElement<BundleInformation> createBundleInformation(BundleInformation value) {
        return new JAXBElement<BundleInformation>(_BundleInformation_QNAME, BundleInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfComponentEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ArrayOfComponentEvent")
    public JAXBElement<ArrayOfComponentEvent> createArrayOfComponentEvent(ArrayOfComponentEvent value) {
        return new JAXBElement<ArrayOfComponentEvent>(_ArrayOfComponentEvent_QNAME, ArrayOfComponentEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PLConfidenceLevelInfo")
    public JAXBElement<PLConfidenceLevelInfo> createPLConfidenceLevelInfo(PLConfidenceLevelInfo value) {
        return new JAXBElement<PLConfidenceLevelInfo>(_PLConfidenceLevelInfo_QNAME, PLConfidenceLevelInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShoppingBasket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "shopping_basket")
    public JAXBElement<ShoppingBasket> createShoppingBasket(ShoppingBasket value) {
        return new JAXBElement<ShoppingBasket>(_ShoppingBasket_QNAME, ShoppingBasket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoHSUnitStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RoHS_unit_status")
    public JAXBElement<RoHSUnitStatus> createRoHSUnitStatus(RoHSUnitStatus value) {
        return new JAXBElement<RoHSUnitStatus>(_RoHSUnitStatus_QNAME, RoHSUnitStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfKeyValueOfstringstring")
    public JAXBElement<ArrayOfKeyValueOfstringstring> createArrayOfKeyValueOfstringstring(ArrayOfKeyValueOfstringstring value) {
        return new JAXBElement<ArrayOfKeyValueOfstringstring>(_ArrayOfKeyValueOfstringstring_QNAME, ArrayOfKeyValueOfstringstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Quantity", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketQuantity(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketQuantity_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "LocationOptionDescription", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketLocationOptionDescription(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketLocationOptionDescription_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SB_Element1", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketSBElement1(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketSBElement1_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SB_Element2", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketSBElement2(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketSBElement2_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SB_Element3", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketSBElement3(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketSBElement3_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartNumber", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketPartNumber(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartNumber_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartDescription", scope = ProductShoppingBasket.class)
    public JAXBElement<String> createProductShoppingBasketPartDescription(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartDescription_QNAME, String.class, ProductShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = SerialNumberValidationResponse.class)
    public JAXBElement<SerialNumberValidationRequest> createSerialNumberValidationResponseOriginalRequest(SerialNumberValidationRequest value) {
        return new JAXBElement<SerialNumberValidationRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, SerialNumberValidationRequest.class, SerialNumberValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = SerialNumberValidationResponse.class)
    public JAXBElement<String> createSerialNumberValidationResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, SerialNumberValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReasonWhyItsNotValid", scope = SerialNumberValidationResponse.class)
    public JAXBElement<String> createSerialNumberValidationResponseReasonWhyItsNotValid(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseReasonWhyItsNotValid_QNAME, String.class, SerialNumberValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReasonCodeWhyItsNotValid", scope = SerialNumberValidationResponse.class)
    public JAXBElement<String> createSerialNumberValidationResponseReasonCodeWhyItsNotValid(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseReasonCodeWhyItsNotValid_QNAME, String.class, SerialNumberValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = SerialNumberValidationResponse.class)
    public JAXBElement<String> createSerialNumberValidationResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, SerialNumberValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = ComponentValidationResponse.class)
    public JAXBElement<ComponentValidationRequest> createComponentValidationResponseOriginalRequest(ComponentValidationRequest value) {
        return new JAXBElement<ComponentValidationRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, ComponentValidationRequest.class, ComponentValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductLineConfidenceLevelInfo", scope = ComponentValidationResponse.class)
    public JAXBElement<PLConfidenceLevelInfo> createComponentValidationResponseProductLineConfidenceLevelInfo(PLConfidenceLevelInfo value) {
        return new JAXBElement<PLConfidenceLevelInfo>(_ComponentValidationResponseProductLineConfidenceLevelInfo_QNAME, PLConfidenceLevelInfo.class, ComponentValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartSearchInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartToProductSearchResponse", scope = ComponentValidationResponse.class)
    public JAXBElement<PartSearchInformation> createComponentValidationResponsePartToProductSearchResponse(PartSearchInformation value) {
        return new JAXBElement<PartSearchInformation>(_ComponentValidationResponsePartToProductSearchResponse_QNAME, PartSearchInformation.class, ComponentValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = ComponentValidationResponse.class)
    public JAXBElement<String> createComponentValidationResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, ComponentValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = ComponentValidationResponse.class)
    public JAXBElement<String> createComponentValidationResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, ComponentValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "user_name", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputUserName(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputUserName_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "requested_delivery_ts", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputRequestedDeliveryTs(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputRequestedDeliveryTs_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "client_type", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputClientType(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputClientType_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "country_subdivision_code", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputCountrySubdivisionCode(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputCountrySubdivisionCode_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "product_no", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputProductNo(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputProductNo_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "country_code", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputCountryCode(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputCountryCode_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "password", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputPassword(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputPassword_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "serial_no", scope = WWSNRSPrimaryInput.class)
    public JAXBElement<String> createWWSNRSPrimaryInputSerialNo(String value) {
        return new JAXBElement<String>(_WWSNRSPrimaryInputSerialNo_QNAME, String.class, WWSNRSPrimaryInput.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParams", scope = GetProductLifeCycleEvents.class)
    public JAXBElement<ProductLifeCycleEventsRequest> createGetProductLifeCycleEventsInputParams(ProductLifeCycleEventsRequest value) {
        return new JAXBElement<ProductLifeCycleEventsRequest>(_GetProductLifeCycleEventsInputParams_QNAME, ProductLifeCycleEventsRequest.class, GetProductLifeCycleEvents.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartToProductValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ValidatePartToProductResult", scope = ValidatePartToProductResponse.class)
    public JAXBElement<PartToProductValidationResponse> createValidatePartToProductResponseValidatePartToProductResult(PartToProductValidationResponse value) {
        return new JAXBElement<PartToProductValidationResponse>(_ValidatePartToProductResponseValidatePartToProductResult_QNAME, PartToProductValidationResponse.class, ValidatePartToProductResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = SerialNumberValidationRequest.class)
    public JAXBElement<String> createSerialNumberValidationRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, SerialNumberValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = SerialNumberValidationRequest.class)
    public JAXBElement<String> createSerialNumberValidationRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, SerialNumberValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = SerialNumberValidationRequest.class)
    public JAXBElement<String> createSerialNumberValidationRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, SerialNumberValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = SerialNumberValidationRequest.class)
    public JAXBElement<String> createSerialNumberValidationRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, SerialNumberValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetProductLifeCycleEventsResult", scope = GetProductLifeCycleEventsResponse.class)
    public JAXBElement<ProductLifeCycleEventsResponse> createGetProductLifeCycleEventsResponseGetProductLifeCycleEventsResult(ProductLifeCycleEventsResponse value) {
        return new JAXBElement<ProductLifeCycleEventsResponse>(_GetProductLifeCycleEventsResponseGetProductLifeCycleEventsResult_QNAME, ProductLifeCycleEventsResponse.class, GetProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "loc_option_description", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketLocOptionDescription(String value) {
        return new JAXBElement<String>(_ShoppingBasketLocOptionDescription_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sb_element2", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketSbElement2(String value) {
        return new JAXBElement<String>(_ShoppingBasketSbElement2_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_description", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketPartDescription(String value) {
        return new JAXBElement<String>(_ShoppingBasketPartDescription_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sb_element3", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketSbElement3(String value) {
        return new JAXBElement<String>(_ShoppingBasketSbElement3_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_number", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketPartNumber(String value) {
        return new JAXBElement<String>(_ShoppingBasketPartNumber_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sb_element1", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketSbElement1(String value) {
        return new JAXBElement<String>(_ShoppingBasketSbElement1_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sbk_quantity", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketSbkQuantity(String value) {
        return new JAXBElement<String>(_ShoppingBasketSbkQuantity_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sb_moduleid", scope = ShoppingBasket.class)
    public JAXBElement<String> createShoppingBasketSbModuleid(String value) {
        return new JAXBElement<String>(_ShoppingBasketSbModuleid_QNAME, String.class, ShoppingBasket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductLine", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestProductLine(String value) {
        return new JAXBElement<String>(_ComponentValidationRequestProductLine_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReturnBillOfMaterialLevel", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestReturnBillOfMaterialLevel(String value) {
        return new JAXBElement<String>(_ComponentValidationRequestReturnBillOfMaterialLevel_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartNumber", scope = ComponentValidationRequest.class)
    public JAXBElement<String> createComponentValidationRequestPartNumber(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartNumber_QNAME, String.class, ComponentValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RohsComplianceCode", scope = RohsStatus.class)
    public JAXBElement<String> createRohsStatusRohsComplianceCode(String value) {
        return new JAXBElement<String>(_RohsStatusRohsComplianceCode_QNAME, String.class, RohsStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RohsComplianceDescription", scope = RohsStatus.class)
    public JAXBElement<String> createRohsStatusRohsComplianceDescription(String value) {
        return new JAXBElement<String>(_RohsStatusRohsComplianceDescription_QNAME, String.class, RohsStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = ProductLifeCycleEventsRequest.class)
    public JAXBElement<String> createProductLifeCycleEventsRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, ProductLifeCycleEventsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = ProductLifeCycleEventsRequest.class)
    public JAXBElement<String> createProductLifeCycleEventsRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, ProductLifeCycleEventsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = ProductLifeCycleEventsRequest.class)
    public JAXBElement<String> createProductLifeCycleEventsRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, ProductLifeCycleEventsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = ProductLifeCycleEventsRequest.class)
    public JAXBElement<String> createProductLifeCycleEventsRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, ProductLifeCycleEventsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CutOffDate", scope = ProductLifeCycleEventsRequest.class)
    public JAXBElement<String> createProductLifeCycleEventsRequestCutOffDate(String value) {
        return new JAXBElement<String>(_ProductLifeCycleEventsRequestCutOffDate_QNAME, String.class, ProductLifeCycleEventsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "DeliveryTypeCode", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationDeliveryTypeCode(String value) {
        return new JAXBElement<String>(_ProductShippingInformationDeliveryTypeCode_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShipToCountry", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationShipToCountry(String value) {
        return new JAXBElement<String>(_ProductShippingInformationShipToCountry_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "DistributionChannel", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationDistributionChannel(String value) {
        return new JAXBElement<String>(_ProductShippingInformationDistributionChannel_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OrderLineNumber", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationOrderLineNumber(String value) {
        return new JAXBElement<String>(_ProductShippingInformationOrderLineNumber_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CustNumber", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationCustNumber(String value) {
        return new JAXBElement<String>(_ProductShippingInformationCustNumber_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SourceSystem", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationSourceSystem(String value) {
        return new JAXBElement<String>(_ProductShippingInformationSourceSystem_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "InterCompFlag", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationInterCompFlag(String value) {
        return new JAXBElement<String>(_ProductShippingInformationInterCompFlag_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ResellerAddress", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationResellerAddress(String value) {
        return new JAXBElement<String>(_ProductShippingInformationResellerAddress_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SalesOrderNumber", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationSalesOrderNumber(String value) {
        return new JAXBElement<String>(_ProductShippingInformationSalesOrderNumber_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShipmentDate", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationShipmentDate(String value) {
        return new JAXBElement<String>(_ProductShippingInformationShipmentDate_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReturnDate", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationReturnDate(String value) {
        return new JAXBElement<String>(_ProductShippingInformationReturnDate_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ResellerNumber", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationResellerNumber(String value) {
        return new JAXBElement<String>(_ProductShippingInformationResellerNumber_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "QuantityShipped", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationQuantityShipped(String value) {
        return new JAXBElement<String>(_ProductShippingInformationQuantityShipped_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShipmentIdentifier", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationShipmentIdentifier(String value) {
        return new JAXBElement<String>(_ProductShippingInformationShipmentIdentifier_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ResellerCity", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationResellerCity(String value) {
        return new JAXBElement<String>(_ProductShippingInformationResellerCity_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "MaterialNumber", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationMaterialNumber(String value) {
        return new JAXBElement<String>(_ProductShippingInformationMaterialNumber_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ResellerName", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationResellerName(String value) {
        return new JAXBElement<String>(_ProductShippingInformationResellerName_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ResellerPostalCode", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationResellerPostalCode(String value) {
        return new JAXBElement<String>(_ProductShippingInformationResellerPostalCode_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShipToLocationCode", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationShipToLocationCode(String value) {
        return new JAXBElement<String>(_ProductShippingInformationShipToLocationCode_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CustShipToId", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationCustShipToId(String value) {
        return new JAXBElement<String>(_ProductShippingInformationCustShipToId_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "US_Element1", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationUSElement1(String value) {
        return new JAXBElement<String>(_ProductShippingInformationUSElement1_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "US_Element2", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationUSElement2(String value) {
        return new JAXBElement<String>(_ProductShippingInformationUSElement2_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShipFromLocationCode", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationShipFromLocationCode(String value) {
        return new JAXBElement<String>(_ProductShippingInformationShipFromLocationCode_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SalesOrganizationCode", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationSalesOrganizationCode(String value) {
        return new JAXBElement<String>(_ProductShippingInformationSalesOrganizationCode_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "US_Element3", scope = ProductShippingInformation.class)
    public JAXBElement<String> createProductShippingInformationUSElement3(String value) {
        return new JAXBElement<String>(_ProductShippingInformationUSElement3_QNAME, String.class, ProductShippingInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = PLConfidenceLevelResponse.class)
    public JAXBElement<PLConfidenceLevelRequest> createPLConfidenceLevelResponseOriginalRequest(PLConfidenceLevelRequest value) {
        return new JAXBElement<PLConfidenceLevelRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, PLConfidenceLevelRequest.class, PLConfidenceLevelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductLineConfidenceLevelInfo", scope = PLConfidenceLevelResponse.class)
    public JAXBElement<PLConfidenceLevelInfo> createPLConfidenceLevelResponseProductLineConfidenceLevelInfo(PLConfidenceLevelInfo value) {
        return new JAXBElement<PLConfidenceLevelInfo>(_ComponentValidationResponseProductLineConfidenceLevelInfo_QNAME, PLConfidenceLevelInfo.class, PLConfidenceLevelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = PLConfidenceLevelResponse.class)
    public JAXBElement<String> createPLConfidenceLevelResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, PLConfidenceLevelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = PLConfidenceLevelResponse.class)
    public JAXBElement<String> createPLConfidenceLevelResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, PLConfidenceLevelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = SerialNumberExistsRequest.class)
    public JAXBElement<String> createSerialNumberExistsRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, SerialNumberExistsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = SerialNumberExistsRequest.class)
    public JAXBElement<String> createSerialNumberExistsRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, SerialNumberExistsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = SerialNumberExistsRequest.class)
    public JAXBElement<String> createSerialNumberExistsRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, SerialNumberExistsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = SerialNumberExistsRequest.class)
    public JAXBElement<String> createSerialNumberExistsRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, SerialNumberExistsRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ManufacturingBillOfMaterialConfidence", scope = PLConfidenceLevelInfo.class)
    public JAXBElement<String> createPLConfidenceLevelInfoManufacturingBillOfMaterialConfidence(String value) {
        return new JAXBElement<String>(_PLConfidenceLevelInfoManufacturingBillOfMaterialConfidence_QNAME, String.class, PLConfidenceLevelInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UnitConfidence", scope = PLConfidenceLevelInfo.class)
    public JAXBElement<String> createPLConfidenceLevelInfoUnitConfidence(String value) {
        return new JAXBElement<String>(_PLConfidenceLevelInfoUnitConfidence_QNAME, String.class, PLConfidenceLevelInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SupportBillOfMaterialConfidence", scope = PLConfidenceLevelInfo.class)
    public JAXBElement<String> createPLConfidenceLevelInfoSupportBillOfMaterialConfidence(String value) {
        return new JAXBElement<String>(_PLConfidenceLevelInfoSupportBillOfMaterialConfidence_QNAME, String.class, PLConfidenceLevelInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ModifiedDate", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationModifiedDate(String value) {
        return new JAXBElement<String>(_BundleInformationModifiedDate_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CreatedDate", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationCreatedDate(String value) {
        return new JAXBElement<String>(_BundleInformationCreatedDate_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SystemProductNumber", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationSystemProductNumber(String value) {
        return new JAXBElement<String>(_BundleInformationSystemProductNumber_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SubFAOriginaId", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationSubFAOriginaId(String value) {
        return new JAXBElement<String>(_BundleInformationSubFAOriginaId_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShippingDate", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationShippingDate(String value) {
        return new JAXBElement<String>(_BundleInformationShippingDate_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Description", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationDescription(String value) {
        return new JAXBElement<String>(_BundleInformationDescription_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "LocalizationOption", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationLocalizationOption(String value) {
        return new JAXBElement<String>(_BundleInformationLocalizationOption_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleChildProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductsInBundle", scope = BundleInformation.class)
    public JAXBElement<ArrayOfBundleChildProduct> createBundleInformationProductsInBundle(ArrayOfBundleChildProduct value) {
        return new JAXBElement<ArrayOfBundleChildProduct>(_BundleInformationProductsInBundle_QNAME, ArrayOfBundleChildProduct.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RecordOriginId", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationRecordOriginId(String value) {
        return new JAXBElement<String>(_BundleInformationRecordOriginId_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OtherOptions", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationOtherOptions(String value) {
        return new JAXBElement<String>(_BundleInformationOtherOptions_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WarrantyOption", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationWarrantyOption(String value) {
        return new JAXBElement<String>(_BundleInformationWarrantyOption_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SystemSerialNumber", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationSystemSerialNumber(String value) {
        return new JAXBElement<String>(_BundleInformationSystemSerialNumber_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "AssetTag", scope = BundleInformation.class)
    public JAXBElement<String> createBundleInformationAssetTag(String value) {
        return new JAXBElement<String>(_BundleInformationAssetTag_QNAME, String.class, BundleInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "InputParams", scope = IsSerialNumberValid.class)
    public JAXBElement<SerialNumberValidationRequest> createIsSerialNumberValidInputParams(SerialNumberValidationRequest value) {
        return new JAXBElement<SerialNumberValidationRequest>(_IsSerialNumberValidInputParams_QNAME, SerialNumberValidationRequest.class, IsSerialNumberValid.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = PartToProductValidationRequest.class)
    public JAXBElement<String> createPartToProductValidationRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, PartToProductValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = PartToProductValidationRequest.class)
    public JAXBElement<String> createPartToProductValidationRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, PartToProductValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = PartToProductValidationRequest.class)
    public JAXBElement<String> createPartToProductValidationRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, PartToProductValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReturnBOMLevel", scope = PartToProductValidationRequest.class)
    public JAXBElement<String> createPartToProductValidationRequestReturnBOMLevel(String value) {
        return new JAXBElement<String>(_PartToProductValidationRequestReturnBOMLevel_QNAME, String.class, PartToProductValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = PartToProductValidationRequest.class)
    public JAXBElement<String> createPartToProductValidationRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, PartToProductValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartNumber", scope = PartToProductValidationRequest.class)
    public JAXBElement<String> createPartToProductValidationRequestPartNumber(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartNumber_QNAME, String.class, PartToProductValidationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParams", scope = ManufacturingComponentValidation.class)
    public JAXBElement<ComponentValidationRequest> createManufacturingComponentValidationInputParams(ComponentValidationRequest value) {
        return new JAXBElement<ComponentValidationRequest>(_GetProductLifeCycleEventsInputParams_QNAME, ComponentValidationRequest.class, ManufacturingComponentValidation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "LocalizationOption", scope = BundleChildProduct.class)
    public JAXBElement<String> createBundleChildProductLocalizationOption(String value) {
        return new JAXBElement<String>(_BundleInformationLocalizationOption_QNAME, String.class, BundleChildProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UnitSerialNumber", scope = BundleChildProduct.class)
    public JAXBElement<String> createBundleChildProductUnitSerialNumber(String value) {
        return new JAXBElement<String>(_BundleChildProductUnitSerialNumber_QNAME, String.class, BundleChildProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UnitProductNumber", scope = BundleChildProduct.class)
    public JAXBElement<String> createBundleChildProductUnitProductNumber(String value) {
        return new JAXBElement<String>(_BundleChildProductUnitProductNumber_QNAME, String.class, BundleChildProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CreatedDate", scope = BundleChildProduct.class)
    public JAXBElement<String> createBundleChildProductCreatedDate(String value) {
        return new JAXBElement<String>(_BundleInformationCreatedDate_QNAME, String.class, BundleChildProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WarrantyOption", scope = BundleChildProduct.class)
    public JAXBElement<String> createBundleChildProductWarrantyOption(String value) {
        return new JAXBElement<String>(_BundleInformationWarrantyOption_QNAME, String.class, BundleChildProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OtherOptions", scope = BundleChildProduct.class)
    public JAXBElement<String> createBundleChildProductOtherOptions(String value) {
        return new JAXBElement<String>(_BundleInformationOtherOptions_QNAME, String.class, BundleChildProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductBrandName", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationProductBrandName(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationProductBrandName_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ItemName", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationItemName(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationItemName_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductDescription", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationProductDescription(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationProductDescription_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PIN", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationPIN(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationPIN_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ParentPIN", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationParentPIN(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationParentPIN_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "LevelCode", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationLevelCode(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationLevelCode_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PricingDescription", scope = ProductHierarchyInformation.class)
    public JAXBElement<String> createProductHierarchyInformationPricingDescription(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationPricingDescription_QNAME, String.class, ProductHierarchyInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "COMBOMCount", scope = WWSNRSHeader.class)
    public JAXBElement<String> createWWSNRSHeaderCOMBOMCount(String value) {
        return new JAXBElement<String>(_WWSNRSHeaderCOMBOMCount_QNAME, String.class, WWSNRSHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BOMType", scope = WWSNRSHeader.class)
    public JAXBElement<String> createWWSNRSHeaderBOMType(String value) {
        return new JAXBElement<String>(_WWSNRSHeaderBOMType_QNAME, String.class, WWSNRSHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "description", scope = WWSNRSHeader.class)
    public JAXBElement<String> createWWSNRSHeaderDescription(String value) {
        return new JAXBElement<String>(_WWSNRSHeaderDescription_QNAME, String.class, WWSNRSHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TibcoMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "tibcomsg", scope = WWSNRSHeader.class)
    public JAXBElement<TibcoMsg> createWWSNRSHeaderTibcomsg(TibcoMsg value) {
        return new JAXBElement<TibcoMsg>(_WWSNRSHeaderTibcomsg_QNAME, TibcoMsg.class, WWSNRSHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SPBOMCount", scope = WWSNRSHeader.class)
    public JAXBElement<String> createWWSNRSHeaderSPBOMCount(String value) {
        return new JAXBElement<String>(_WWSNRSHeaderSPBOMCount_QNAME, String.class, WWSNRSHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "code", scope = WWSNRSHeader.class)
    public JAXBElement<String> createWWSNRSHeaderCode(String value) {
        return new JAXBElement<String>(_WWSNRSHeaderCode_QNAME, String.class, WWSNRSHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberExistsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = SerialNumberExistsResponse.class)
    public JAXBElement<SerialNumberExistsRequest> createSerialNumberExistsResponseOriginalRequest(SerialNumberExistsRequest value) {
        return new JAXBElement<SerialNumberExistsRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, SerialNumberExistsRequest.class, SerialNumberExistsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = SerialNumberExistsResponse.class)
    public JAXBElement<String> createSerialNumberExistsResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, SerialNumberExistsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = SerialNumberExistsResponse.class)
    public JAXBElement<String> createSerialNumberExistsResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, SerialNumberExistsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ParentPartNumber", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentParentPartNumber(String value) {
        return new JAXBElement<String>(_ProductComponentParentPartNumber_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SupplierPartNumber", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentSupplierPartNumber(String value) {
        return new JAXBElement<String>(_ProductComponentSupplierPartNumber_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BomLevel", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentBomLevel(String value) {
        return new JAXBElement<String>(_ProductComponentBomLevel_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentMaterialNumber", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentComponentMaterialNumber(String value) {
        return new JAXBElement<String>(_ProductComponentComponentMaterialNumber_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ManufactureDate", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentManufactureDate(String value) {
        return new JAXBElement<String>(_ProductComponentManufactureDate_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SupplierID", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentSupplierID(String value) {
        return new JAXBElement<String>(_ProductComponentSupplierID_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UC_Element1", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentUCElement1(String value) {
        return new JAXBElement<String>(_ProductComponentUCElement1_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Quantity", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentQuantity(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketQuantity_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UC_Element2", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentUCElement2(String value) {
        return new JAXBElement<String>(_ProductComponentUCElement2_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartCategory", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentPartCategory(String value) {
        return new JAXBElement<String>(_ProductComponentPartCategory_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentSerialNumber", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentComponentSerialNumber(String value) {
        return new JAXBElement<String>(_ProductComponentComponentSerialNumber_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartNumber", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentPartNumber(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartNumber_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UC_Element3", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentUCElement3(String value) {
        return new JAXBElement<String>(_ProductComponentUCElement3_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartDescription", scope = ProductComponent.class)
    public JAXBElement<String> createProductComponentPartDescription(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartDescription_QNAME, String.class, ProductComponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = PLConfidenceLevelRequest.class)
    public JAXBElement<String> createPLConfidenceLevelRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, PLConfidenceLevelRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductLine", scope = PLConfidenceLevelRequest.class)
    public JAXBElement<String> createPLConfidenceLevelRequestProductLine(String value) {
        return new JAXBElement<String>(_ComponentValidationRequestProductLine_QNAME, String.class, PLConfidenceLevelRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = PLConfidenceLevelRequest.class)
    public JAXBElement<String> createPLConfidenceLevelRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, PLConfidenceLevelRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = PLConfidenceLevelRequest.class)
    public JAXBElement<String> createPLConfidenceLevelRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, PLConfidenceLevelRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = PLConfidenceLevelRequest.class)
    public JAXBElement<String> createPLConfidenceLevelRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, PLConfidenceLevelRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartNumber", scope = PLConfidenceLevelRequest.class)
    public JAXBElement<String> createPLConfidenceLevelRequestPartNumber(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartNumber_QNAME, String.class, PLConfidenceLevelRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "IsSerialNumberExistingResult", scope = IsSerialNumberExistingResponse.class)
    public JAXBElement<SerialNumberExistsResponse> createIsSerialNumberExistingResponseIsSerialNumberExistingResult(SerialNumberExistsResponse value) {
        return new JAXBElement<SerialNumberExistsResponse>(_IsSerialNumberExistingResponseIsSerialNumberExistingResult_QNAME, SerialNumberExistsResponse.class, IsSerialNumberExistingResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WwsnrsTracePrimaryReturn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSerialInfoResult", scope = GetSerialInfoResponse.class)
    public JAXBElement<WwsnrsTracePrimaryReturn> createGetSerialInfoResponseGetSerialInfoResult(WwsnrsTracePrimaryReturn value) {
        return new JAXBElement<WwsnrsTracePrimaryReturn>(_GetSerialInfoResponseGetSerialInfoResult_QNAME, WwsnrsTracePrimaryReturn.class, GetSerialInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "IsSerialNumberValidResult", scope = IsSerialNumberValidResponse.class)
    public JAXBElement<SerialNumberValidationResponse> createIsSerialNumberValidResponseIsSerialNumberValidResult(SerialNumberValidationResponse value) {
        return new JAXBElement<SerialNumberValidationResponse>(_IsSerialNumberValidResponseIsSerialNumberValidResult_QNAME, SerialNumberValidationResponse.class, IsSerialNumberValidResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartToProductValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = PartToProductValidationResponse.class)
    public JAXBElement<PartToProductValidationRequest> createPartToProductValidationResponseOriginalRequest(PartToProductValidationRequest value) {
        return new JAXBElement<PartToProductValidationRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, PartToProductValidationRequest.class, PartToProductValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartSearchInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartToProductSearchResponse", scope = PartToProductValidationResponse.class)
    public JAXBElement<PartSearchInformation> createPartToProductValidationResponsePartToProductSearchResponse(PartSearchInformation value) {
        return new JAXBElement<PartSearchInformation>(_ComponentValidationResponsePartToProductSearchResponse_QNAME, PartSearchInformation.class, PartToProductValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = PartToProductValidationResponse.class)
    public JAXBElement<String> createPartToProductValidationResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, PartToProductValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = PartToProductValidationResponse.class)
    public JAXBElement<String> createPartToProductValidationResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, PartToProductValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ChangeList", scope = ProductEvent.class)
    public JAXBElement<ArrayOfKeyValueOfstringstring> createProductEventChangeList(ArrayOfKeyValueOfstringstring value) {
        return new JAXBElement<ArrayOfKeyValueOfstringstring>(_ProductEventChangeList_QNAME, ArrayOfKeyValueOfstringstring.class, ProductEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RecordCreationDate", scope = ProductEvent.class)
    public JAXBElement<String> createProductEventRecordCreationDate(String value) {
        return new JAXBElement<String>(_ProductEventRecordCreationDate_QNAME, String.class, ProductEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SequenceNumber", scope = ProductEvent.class)
    public JAXBElement<String> createProductEventSequenceNumber(String value) {
        return new JAXBElement<String>(_ProductEventSequenceNumber_QNAME, String.class, ProductEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "LoaderName", scope = ProductEvent.class)
    public JAXBElement<String> createProductEventLoaderName(String value) {
        return new JAXBElement<String>(_ProductEventLoaderName_QNAME, String.class, ProductEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ChangeType", scope = ProductEvent.class)
    public JAXBElement<String> createProductEventChangeType(String value) {
        return new JAXBElement<String>(_ProductEventChangeType_QNAME, String.class, ProductEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WWSNRSPrimaryInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputparams", scope = GetSerialInfo.class)
    public JAXBElement<WWSNRSPrimaryInput> createGetSerialInfoInputparams(WWSNRSPrimaryInput value) {
        return new JAXBElement<WWSNRSPrimaryInput>(_GetSerialInfoInputparams_QNAME, WWSNRSPrimaryInput.class, GetSerialInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BundleUnits", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<ArrayOfBundleUnit> createWwsnrsTracePrimaryReturnBundleUnits(ArrayOfBundleUnit value) {
        return new JAXBElement<ArrayOfBundleUnit>(_WwsnrsTracePrimaryReturnBundleUnits_QNAME, ArrayOfBundleUnit.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfshoppingBasket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "shopping_basket", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<ArrayOfshoppingBasket> createWwsnrsTracePrimaryReturnShoppingBasket(ArrayOfshoppingBasket value) {
        return new JAXBElement<ArrayOfshoppingBasket>(_ShoppingBasket_QNAME, ArrayOfshoppingBasket.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfsparePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "spare_part", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<ArrayOfsparePart> createWwsnrsTracePrimaryReturnSparePart(ArrayOfsparePart value) {
        return new JAXBElement<ArrayOfsparePart>(_SparePart_QNAME, ArrayOfsparePart.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoHSUnitStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RoHS_unit_status", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<RoHSUnitStatus> createWwsnrsTracePrimaryReturnRoHSUnitStatus(RoHSUnitStatus value) {
        return new JAXBElement<RoHSUnitStatus>(_RoHSUnitStatus_QNAME, RoHSUnitStatus.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunitConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "unit_configuration", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<ArrayOfunitConfiguration> createWwsnrsTracePrimaryReturnUnitConfiguration(ArrayOfunitConfiguration value) {
        return new JAXBElement<ArrayOfunitConfiguration>(_UnitConfiguration_QNAME, ArrayOfunitConfiguration.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WWSNRSHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "header", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<WWSNRSHeader> createWwsnrsTracePrimaryReturnHeader(WWSNRSHeader value) {
        return new JAXBElement<WWSNRSHeader>(_WwsnrsTracePrimaryReturnHeader_QNAME, WWSNRSHeader.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WWSNRSPrimaryInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "wwsnrsinput", scope = WwsnrsTracePrimaryReturn.class)
    public JAXBElement<WWSNRSPrimaryInput> createWwsnrsTracePrimaryReturnWwsnrsinput(WWSNRSPrimaryInput value) {
        return new JAXBElement<WWSNRSPrimaryInput>(_WwsnrsTracePrimaryReturnWwsnrsinput_QNAME, WWSNRSPrimaryInput.class, WwsnrsTracePrimaryReturn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParams", scope = GetManufacturingBillOfMaterial.class)
    public JAXBElement<ManufacturingBillOfMaterialRequest> createGetManufacturingBillOfMaterialInputParams(ManufacturingBillOfMaterialRequest value) {
        return new JAXBElement<ManufacturingBillOfMaterialRequest>(_GetProductLifeCycleEventsInputParams_QNAME, ManufacturingBillOfMaterialRequest.class, GetManufacturingBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "rohs_status_code", scope = RoHSUnitStatus.class)
    public JAXBElement<String> createRoHSUnitStatusRohsStatusCode(String value) {
        return new JAXBElement<String>(_RoHSUnitStatusRohsStatusCode_QNAME, String.class, RoHSUnitStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "has_minimum_rohs_exception", scope = RoHSUnitStatus.class)
    public JAXBElement<String> createRoHSUnitStatusHasMinimumRohsException(String value) {
        return new JAXBElement<String>(_RoHSUnitStatusHasMinimumRohsException_QNAME, String.class, RoHSUnitStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Product_family", scope = RoHSUnitStatus.class)
    public JAXBElement<String> createRoHSUnitStatusProductFamily(String value) {
        return new JAXBElement<String>(_RoHSUnitStatusProductFamily_QNAME, String.class, RoHSUnitStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Orig_UnitProductNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitOrigUnitProductNo(String value) {
        return new JAXBElement<String>(_BundleUnitOrigUnitProductNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Orig_SystemProductNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitOrigSystemProductNo(String value) {
        return new JAXBElement<String>(_BundleUnitOrigSystemProductNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UnitProductNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitUnitProductNo(String value) {
        return new JAXBElement<String>(_BundleUnitUnitProductNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "fAOriginId", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitFAOriginId(String value) {
        return new JAXBElement<String>(_BundleUnitFAOriginId_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Orig_SystemSerialNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitOrigSystemSerialNo(String value) {
        return new JAXBElement<String>(_BundleUnitOrigSystemSerialNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShipDate", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitShipDate(String value) {
        return new JAXBElement<String>(_BundleUnitShipDate_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SystemProductNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitSystemProductNo(String value) {
        return new JAXBElement<String>(_BundleUnitSystemProductNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SystemSerialNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitSystemSerialNo(String value) {
        return new JAXBElement<String>(_BundleUnitSystemSerialNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UnitSerialNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitUnitSerialNo(String value) {
        return new JAXBElement<String>(_BundleUnitUnitSerialNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Description", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitDescription(String value) {
        return new JAXBElement<String>(_BundleInformationDescription_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RecordOriginId", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitRecordOriginId(String value) {
        return new JAXBElement<String>(_BundleInformationRecordOriginId_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Warranty", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitWarranty(String value) {
        return new JAXBElement<String>(_BundleUnitWarranty_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Orig_UnitSerialNo", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitOrigUnitSerialNo(String value) {
        return new JAXBElement<String>(_BundleUnitOrigUnitSerialNo_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Other", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitOther(String value) {
        return new JAXBElement<String>(_BundleUnitOther_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Localization", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitLocalization(String value) {
        return new JAXBElement<String>(_BundleUnitLocalization_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Children", scope = BundleUnit.class)
    public JAXBElement<ArrayOfBundleUnit> createBundleUnitChildren(ArrayOfBundleUnit value) {
        return new JAXBElement<ArrayOfBundleUnit>(_BundleUnitChildren_QNAME, ArrayOfBundleUnit.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "AssetTag", scope = BundleUnit.class)
    public JAXBElement<String> createBundleUnitAssetTag(String value) {
        return new JAXBElement<String>(_BundleInformationAssetTag_QNAME, String.class, BundleUnit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_element3", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcElement3(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcElement3_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_has_minimum_rohs_exception", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcHasMinimumRohsException(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcHasMinimumRohsException_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_orderinstr", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcOrderinstr(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcOrderinstr_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "parent_part_number", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationParentPartNumber(String value) {
        return new JAXBElement<String>(_UnitConfigurationParentPartNumber_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_description", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationPartDescription(String value) {
        return new JAXBElement<String>(_ShoppingBasketPartDescription_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_rohs_status_code", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcRohsStatusCode(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcRohsStatusCode_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_materialgrp", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcMaterialgrp(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcMaterialgrp_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_csrflag", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcCsrflag(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcCsrflag_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_usagepercentage", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcUsagepercentage(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcUsagepercentage_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_element2", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcElement2(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcElement2_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_element1", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcElement1(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcElement1_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_returnableflag", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcReturnableflag(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcReturnableflag_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_moduleid", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcModuleid(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcModuleid_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_unitofmeasure", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcUnitofmeasure(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcUnitofmeasure_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_hazardous", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcHazardous(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcHazardous_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_serialno", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationPartSerialno(String value) {
        return new JAXBElement<String>(_UnitConfigurationPartSerialno_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_quantity", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationPartQuantity(String value) {
        return new JAXBElement<String>(_UnitConfigurationPartQuantity_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_number", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationPartNumber(String value) {
        return new JAXBElement<String>(_ShoppingBasketPartNumber_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_materialgrptxt", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcMaterialgrptxt(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcMaterialgrptxt_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "uc_techcourier", scope = UnitConfiguration.class)
    public JAXBElement<String> createUnitConfigurationUcTechcourier(String value) {
        return new JAXBElement<String>(_UnitConfigurationUcTechcourier_QNAME, String.class, UnitConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartToProductValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParams", scope = ValidatePartToProduct.class)
    public JAXBElement<PartToProductValidationRequest> createValidatePartToProductInputParams(PartToProductValidationRequest value) {
        return new JAXBElement<PartToProductValidationRequest>(_GetProductLifeCycleEventsInputParams_QNAME, PartToProductValidationRequest.class, ValidatePartToProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ManufacturingComponentValidationResult", scope = ManufacturingComponentValidationResponse.class)
    public JAXBElement<ComponentValidationResponse> createManufacturingComponentValidationResponseManufacturingComponentValidationResult(ComponentValidationResponse value) {
        return new JAXBElement<ComponentValidationResponse>(_ManufacturingComponentValidationResponseManufacturingComponentValidationResult_QNAME, ComponentValidationResponse.class, ManufacturingComponentValidationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = ManufacturingBillOfMaterialResponse.class)
    public JAXBElement<ManufacturingBillOfMaterialRequest> createManufacturingBillOfMaterialResponseOriginalRequest(ManufacturingBillOfMaterialRequest value) {
        return new JAXBElement<ManufacturingBillOfMaterialRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, ManufacturingBillOfMaterialRequest.class, ManufacturingBillOfMaterialResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = ManufacturingBillOfMaterialResponse.class)
    public JAXBElement<String> createManufacturingBillOfMaterialResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, ManufacturingBillOfMaterialResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = ManufacturingBillOfMaterialResponse.class)
    public JAXBElement<String> createManufacturingBillOfMaterialResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, ManufacturingBillOfMaterialResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductBillOfMaterial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductBillOfMaterialSearchResults", scope = ManufacturingBillOfMaterialResponse.class)
    public JAXBElement<ArrayOfProductBillOfMaterial> createManufacturingBillOfMaterialResponseProductBillOfMaterialSearchResults(ArrayOfProductBillOfMaterial value) {
        return new JAXBElement<ArrayOfProductBillOfMaterial>(_ManufacturingBillOfMaterialResponseProductBillOfMaterialSearchResults_QNAME, ArrayOfProductBillOfMaterial.class, ManufacturingBillOfMaterialResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetProductLineConfidenceLevelResult", scope = GetProductLineConfidenceLevelResponse.class)
    public JAXBElement<PLConfidenceLevelResponse> createGetProductLineConfidenceLevelResponseGetProductLineConfidenceLevelResult(PLConfidenceLevelResponse value) {
        return new JAXBElement<PLConfidenceLevelResponse>(_GetProductLineConfidenceLevelResponseGetProductLineConfidenceLevelResult_QNAME, PLConfidenceLevelResponse.class, GetProductLineConfidenceLevelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_usagepercentage", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpUsagepercentage(String value) {
        return new JAXBElement<String>(_SparePartSpUsagepercentage_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "spare_enhance_desc", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpareEnhanceDesc(String value) {
        return new JAXBElement<String>(_SparePartSpareEnhanceDesc_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "spare_part_description", scope = SparePart.class)
    public JAXBElement<String> createSparePartSparePartDescription(String value) {
        return new JAXBElement<String>(_SparePartSparePartDescription_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_is_whole_unit", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpIsWholeUnit(String value) {
        return new JAXBElement<String>(_SparePartSpIsWholeUnit_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_materialgrptxt", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpMaterialgrptxt(String value) {
        return new JAXBElement<String>(_SparePartSpMaterialgrptxt_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_keyword", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpKeyword(String value) {
        return new JAXBElement<String>(_SparePartSpKeyword_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_orderinstr", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpOrderinstr(String value) {
        return new JAXBElement<String>(_SparePartSpOrderinstr_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_requested_delivery_ts", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpRequestedDeliveryTs(String value) {
        return new JAXBElement<String>(_SparePartSpRequestedDeliveryTs_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_hazardous", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpHazardous(String value) {
        return new JAXBElement<String>(_SparePartSpHazardous_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_csrflag", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpCsrflag(String value) {
        return new JAXBElement<String>(_SparePartSpCsrflag_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_techcourier", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpTechcourier(String value) {
        return new JAXBElement<String>(_SparePartSpTechcourier_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_materialgrp", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpMaterialgrp(String value) {
        return new JAXBElement<String>(_SparePartSpMaterialgrp_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_unitofmeasure", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpUnitofmeasure(String value) {
        return new JAXBElement<String>(_SparePartSpUnitofmeasure_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_element2", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpElement2(String value) {
        return new JAXBElement<String>(_SparePartSpElement2_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_element3", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpElement3(String value) {
        return new JAXBElement<String>(_SparePartSpElement3_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "spare_part_no", scope = SparePart.class)
    public JAXBElement<String> createSparePartSparePartNo(String value) {
        return new JAXBElement<String>(_SparePartSparePartNo_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_status", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpStatus(String value) {
        return new JAXBElement<String>(_SparePartSpStatus_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_element1", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpElement1(String value) {
        return new JAXBElement<String>(_SparePartSpElement1_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "part_number", scope = SparePart.class)
    public JAXBElement<String> createSparePartPartNumber(String value) {
        return new JAXBElement<String>(_ShoppingBasketPartNumber_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_category", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpCategory(String value) {
        return new JAXBElement<String>(_SparePartSpCategory_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_is_compliant_with_product", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpIsCompliantWithProduct(String value) {
        return new JAXBElement<String>(_SparePartSpIsCompliantWithProduct_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_is_compliant_with_rohs_jurisdiction", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpIsCompliantWithRohsJurisdiction(String value) {
        return new JAXBElement<String>(_SparePartSpIsCompliantWithRohsJurisdiction_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_rohs_status_code", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpRohsStatusCode(String value) {
        return new JAXBElement<String>(_SparePartSpRohsStatusCode_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "sp_returnableflag", scope = SparePart.class)
    public JAXBElement<String> createSparePartSpReturnableflag(String value) {
        return new JAXBElement<String>(_SparePartSpReturnableflag_QNAME, String.class, SparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReturnInfoModifier", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestReturnInfoModifier(String value) {
        return new JAXBElement<String>(_ManufacturingBillOfMaterialRequestReturnInfoModifier_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CommodityTrackingNumber", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestCommodityTrackingNumber(String value) {
        return new JAXBElement<String>(_ManufacturingBillOfMaterialRequestCommodityTrackingNumber_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "MACAddress", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<ArrayOfstring> createManufacturingBillOfMaterialRequestMACAddress(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ManufacturingBillOfMaterialRequestMACAddress_QNAME, ArrayOfstring.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ReturnInfoLevel", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestReturnInfoLevel(String value) {
        return new JAXBElement<String>(_ManufacturingBillOfMaterialRequestReturnInfoLevel_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Password", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestPassword(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestPassword_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UUID", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<ArrayOfstring> createManufacturingBillOfMaterialRequestUUID(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ManufacturingBillOfMaterialRequestUUID_QNAME, ArrayOfstring.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UserName", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestUserName(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestUserName_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ServiceAgreementID", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestServiceAgreementID(String value) {
        return new JAXBElement<String>(_ManufacturingBillOfMaterialRequestServiceAgreementID_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "AssetTag", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<ArrayOfstring> createManufacturingBillOfMaterialRequestAssetTag(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_BundleInformationAssetTag_QNAME, ArrayOfstring.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SecurityLabel", scope = ManufacturingBillOfMaterialRequest.class)
    public JAXBElement<String> createManufacturingBillOfMaterialRequestSecurityLabel(String value) {
        return new JAXBElement<String>(_ManufacturingBillOfMaterialRequestSecurityLabel_QNAME, String.class, ManufacturingBillOfMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentProductNumber", scope = ComponentEvent.class)
    public JAXBElement<String> createComponentEventComponentProductNumber(String value) {
        return new JAXBElement<String>(_ComponentEventComponentProductNumber_QNAME, String.class, ComponentEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ChangeList", scope = ComponentEvent.class)
    public JAXBElement<ArrayOfKeyValueOfstringstring> createComponentEventChangeList(ArrayOfKeyValueOfstringstring value) {
        return new JAXBElement<ArrayOfKeyValueOfstringstring>(_ProductEventChangeList_QNAME, ArrayOfKeyValueOfstringstring.class, ComponentEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RecordCreationDate", scope = ComponentEvent.class)
    public JAXBElement<String> createComponentEventRecordCreationDate(String value) {
        return new JAXBElement<String>(_ProductEventRecordCreationDate_QNAME, String.class, ComponentEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentSerialNumber", scope = ComponentEvent.class)
    public JAXBElement<String> createComponentEventComponentSerialNumber(String value) {
        return new JAXBElement<String>(_ProductComponentComponentSerialNumber_QNAME, String.class, ComponentEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SequenceNumber", scope = ComponentEvent.class)
    public JAXBElement<String> createComponentEventSequenceNumber(String value) {
        return new JAXBElement<String>(_ProductEventSequenceNumber_QNAME, String.class, ComponentEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ChangeType", scope = ComponentEvent.class)
    public JAXBElement<String> createComponentEventChangeType(String value) {
        return new JAXBElement<String>(_ProductEventChangeType_QNAME, String.class, ComponentEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<String> createProductLifeCycleEventsResponseSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OriginalRequest", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<ProductLifeCycleEventsRequest> createProductLifeCycleEventsResponseOriginalRequest(ProductLifeCycleEventsRequest value) {
        return new JAXBElement<ProductLifeCycleEventsRequest>(_SerialNumberValidationResponseOriginalRequest_QNAME, ProductLifeCycleEventsRequest.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorDescription", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<String> createProductLifeCycleEventsResponseErrorDescription(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorDescription_QNAME, String.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<String> createProductLifeCycleEventsResponseProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ErrorCode", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<String> createProductLifeCycleEventsResponseErrorCode(String value) {
        return new JAXBElement<String>(_SerialNumberValidationResponseErrorCode_QNAME, String.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductEvents", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<ArrayOfProductEvent> createProductLifeCycleEventsResponseProductEvents(ArrayOfProductEvent value) {
        return new JAXBElement<ArrayOfProductEvent>(_ProductLifeCycleEventsResponseProductEvents_QNAME, ArrayOfProductEvent.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfComponentEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ComponentEvents", scope = ProductLifeCycleEventsResponse.class)
    public JAXBElement<ArrayOfComponentEvent> createProductLifeCycleEventsResponseComponentEvents(ArrayOfComponentEvent value) {
        return new JAXBElement<ArrayOfComponentEvent>(_ProductLifeCycleEventsResponseComponentEvents_QNAME, ArrayOfComponentEvent.class, ProductLifeCycleEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "tibco_code", scope = TibcoMsg.class)
    public JAXBElement<String> createTibcoMsgTibcoCode(String value) {
        return new JAXBElement<String>(_TibcoMsgTibcoCode_QNAME, String.class, TibcoMsg.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "tibco_description", scope = TibcoMsg.class)
    public JAXBElement<String> createTibcoMsgTibcoDescription(String value) {
        return new JAXBElement<String>(_TibcoMsgTibcoDescription_QNAME, String.class, TibcoMsg.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartRelationType", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartPartRelationType(String value) {
        return new JAXBElement<String>(_ValidSparePartPartRelationType_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RoHS_spare_compliance_code", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartRoHSSpareComplianceCode(String value) {
        return new JAXBElement<String>(_ValidSparePartRoHSSpareComplianceCode_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UnitOfMeasure", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartUnitOfMeasure(String value) {
        return new JAXBElement<String>(_ValidSparePartUnitOfMeasure_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RohsStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RohsStatusInfo", scope = ValidSparePart.class)
    public JAXBElement<RohsStatus> createValidSparePartRohsStatusInfo(RohsStatus value) {
        return new JAXBElement<RohsStatus>(_ValidSparePartRohsStatusInfo_QNAME, RohsStatus.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SparePartNumber", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartSparePartNumber(String value) {
        return new JAXBElement<String>(_ValidSparePartSparePartNumber_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ExchangePartNumber", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartExchangePartNumber(String value) {
        return new JAXBElement<String>(_ValidSparePartExchangePartNumber_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SparePartDescription", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartSparePartDescription(String value) {
        return new JAXBElement<String>(_ValidSparePartSparePartDescription_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Sp_Element1", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartSpElement1(String value) {
        return new JAXBElement<String>(_ValidSparePartSpElement1_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartCategory", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartPartCategory(String value) {
        return new JAXBElement<String>(_ProductComponentPartCategory_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartProductType", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartPartProductType(String value) {
        return new JAXBElement<String>(_ValidSparePartPartProductType_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductOdmCode", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartProductOdmCode(String value) {
        return new JAXBElement<String>(_ValidSparePartProductOdmCode_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartNumber", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartPartNumber(String value) {
        return new JAXBElement<String>(_ProductShoppingBasketPartNumber_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Sp_Element2", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartSpElement2(String value) {
        return new JAXBElement<String>(_ValidSparePartSpElement2_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Sp_Element3", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartSpElement3(String value) {
        return new JAXBElement<String>(_ValidSparePartSpElement3_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductId", scope = ValidSparePart.class)
    public JAXBElement<String> createValidSparePartProductId(String value) {
        return new JAXBElement<String>(_ValidSparePartProductId_QNAME, String.class, ValidSparePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialNumberExistsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParams", scope = IsSerialNumberExisting.class)
    public JAXBElement<SerialNumberExistsRequest> createIsSerialNumberExistingInputParams(SerialNumberExistsRequest value) {
        return new JAXBElement<SerialNumberExistsRequest>(_GetProductLifeCycleEventsInputParams_QNAME, SerialNumberExistsRequest.class, IsSerialNumberExisting.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PLConfidenceLevelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParams", scope = GetProductLineConfidenceLevel.class)
    public JAXBElement<PLConfidenceLevelRequest> createGetProductLineConfidenceLevelInputParams(PLConfidenceLevelRequest value) {
        return new JAXBElement<PLConfidenceLevelRequest>(_GetProductLifeCycleEventsInputParams_QNAME, PLConfidenceLevelRequest.class, GetProductLineConfidenceLevel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetManufacturingBillOfMaterialResult", scope = GetManufacturingBillOfMaterialResponse.class)
    public JAXBElement<ManufacturingBillOfMaterialResponse> createGetManufacturingBillOfMaterialResponseGetManufacturingBillOfMaterialResult(ManufacturingBillOfMaterialResponse value) {
        return new JAXBElement<ManufacturingBillOfMaterialResponse>(_GetManufacturingBillOfMaterialResponseGetManufacturingBillOfMaterialResult_QNAME, ManufacturingBillOfMaterialResponse.class, GetManufacturingBillOfMaterialResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProgramType", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialProgramType(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialProgramType_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Division", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialDivision(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialDivision_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RohsStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RohsStatusInfo", scope = ProductBillOfMaterial.class)
    public JAXBElement<RohsStatus> createProductBillOfMaterialRohsStatusInfo(RohsStatus value) {
        return new JAXBElement<RohsStatus>(_ValidSparePartRohsStatusInfo_QNAME, RohsStatus.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RecordLastUpdateDate", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialRecordLastUpdateDate(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialRecordLastUpdateDate_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Family", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialFamily(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialFamily_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "CurrentLifeCycleStatus", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialCurrentLifeCycleStatus(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialCurrentLifeCycleStatus_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Line", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialLine(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialLine_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Plant", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialPlant(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialPlant_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Site", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfstring> createProductBillOfMaterialSite(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ProductBillOfMaterialSite_QNAME, ArrayOfstring.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WarrantyCode", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialWarrantyCode(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialWarrantyCode_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Product", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialProduct(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialProduct_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductComponent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Components", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfProductComponent> createProductBillOfMaterialComponents(ArrayOfProductComponent value) {
        return new JAXBElement<ArrayOfProductComponent>(_ProductBillOfMaterialComponents_QNAME, ArrayOfProductComponent.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductNumber", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialProductNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestProductNumber_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Sku", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialSku(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialSku_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PlantCode", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialPlantCode(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialPlantCode_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SerialNumber", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialSerialNumber(String value) {
        return new JAXBElement<String>(_SerialNumberValidationRequestSerialNumber_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BomAdditionalInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BOMAdditionalInformation", scope = ProductBillOfMaterial.class)
    public JAXBElement<BomAdditionalInformation> createProductBillOfMaterialBOMAdditionalInformation(BomAdditionalInformation value) {
        return new JAXBElement<BomAdditionalInformation>(_ProductBillOfMaterialBOMAdditionalInformation_QNAME, BomAdditionalInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfValidSparePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ValidSparePartsInfo", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfValidSparePart> createProductBillOfMaterialValidSparePartsInfo(ArrayOfValidSparePart value) {
        return new JAXBElement<ArrayOfValidSparePart>(_ProductBillOfMaterialValidSparePartsInfo_QNAME, ArrayOfValidSparePart.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProgramName", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialProgramName(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialProgramName_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "SiteCode", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfstring> createProductBillOfMaterialSiteCode(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ProductBillOfMaterialSiteCode_QNAME, ArrayOfstring.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductHierarchyInfo", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialProductHierarchyInfo(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialProductHierarchyInfo_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductDescription", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialProductDescription(String value) {
        return new JAXBElement<String>(_ProductHierarchyInformationProductDescription_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "DataSourceInfo", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfstring> createProductBillOfMaterialDataSourceInfo(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ProductBillOfMaterialDataSourceInfo_QNAME, ArrayOfstring.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ManufactureDate", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialManufactureDate(String value) {
        return new JAXBElement<String>(_ProductComponentManufactureDate_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UI_Element3", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialUIElement3(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialUIElement3_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductShippingInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShippingInfo", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfProductShippingInformation> createProductBillOfMaterialShippingInfo(ArrayOfProductShippingInformation value) {
        return new JAXBElement<ArrayOfProductShippingInformation>(_ProductBillOfMaterialShippingInfo_QNAME, ArrayOfProductShippingInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "PartnerType", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialPartnerType(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialPartnerType_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UI_Element1", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialUIElement1(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialUIElement1_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBundleInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "BundleInfo", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfBundleInformation> createProductBillOfMaterialBundleInfo(ArrayOfBundleInformation value) {
        return new JAXBElement<ArrayOfBundleInformation>(_ProductBillOfMaterialBundleInfo_QNAME, ArrayOfBundleInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "UI_Element2", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialUIElement2(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialUIElement2_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Model", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialModel(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialModel_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "OdmCode", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialOdmCode(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialOdmCode_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Type", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialType(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialType_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WarrantyDuration", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialWarrantyDuration(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialWarrantyDuration_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "EOL_Status", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialEOLStatus(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialEOLStatus_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ProductCategory", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialProductCategory(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialProductCategory_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProductShoppingBasket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "ShoppingBaskets", scope = ProductBillOfMaterial.class)
    public JAXBElement<ArrayOfProductShoppingBasket> createProductBillOfMaterialShoppingBaskets(ArrayOfProductShoppingBasket value) {
        return new JAXBElement<ArrayOfProductShoppingBasket>(_ProductBillOfMaterialShoppingBaskets_QNAME, ArrayOfProductShoppingBasket.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "RecordCreationDate", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialRecordCreationDate(String value) {
        return new JAXBElement<String>(_ProductEventRecordCreationDate_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "WarrantyStart", scope = ProductBillOfMaterial.class)
    public JAXBElement<String> createProductBillOfMaterialWarrantyStart(String value) {
        return new JAXBElement<String>(_ProductBillOfMaterialWarrantyStart_QNAME, String.class, ProductBillOfMaterial.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", name = "Group", scope = ProductBillOfMaterial.class)
    public JAXBElement<ProductHierarchyInformation> createProductBillOfMaterialGroup(ProductHierarchyInformation value) {
        return new JAXBElement<ProductHierarchyInformation>(_ProductBillOfMaterialGroup_QNAME, ProductHierarchyInformation.class, ProductBillOfMaterial.class, value);
    }

}
