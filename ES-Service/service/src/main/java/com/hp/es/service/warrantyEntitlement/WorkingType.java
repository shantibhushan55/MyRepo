/**
 * Project: Entitlement Service
 *
 *
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * @author Thorsten Koevi
 *
 */
package com.hp.es.service.warrantyEntitlement;


public class WorkingType {
    String workingName = null;

    public static final WorkingType pmHP_BASE_WARRANTY_SOURCE = new WorkingType("pmHP Base Warranty Source");
    public static final WorkingType pmHP_BASE_WARRANTY_CODE = new WorkingType("pmHP Base Warranty Code");
    public static final WorkingType KNIGHT_BASE_WARRANTY_TIER = new WorkingType("KNIGHT Base Warranty Tier");
    public static final WorkingType KNIGHT_WARRANTY_START_DATE = new WorkingType("KNIGHT Warranty Start Date");
    public static final WorkingType KNIGHT_WARRANTY_END_DATE = new WorkingType("KNIGHT Warranty End Date");
    public static final WorkingType pmHP_WARRANTY_START_DATE = new WorkingType("pmHP Warranty Start Date");
    public static final WorkingType pmHP_WARRANTY_END_DATE = new WorkingType("pmHP Warranty End Date");
    public static final WorkingType KNIGHT_START_DATE_TYPE = new WorkingType("KNIGHT Start Date Type");
    public static final WorkingType pmHP_START_DATE_TYPE = new WorkingType("pmHP Start Date Type");
    public static final WorkingType KNIGHT_POP_DATE = new WorkingType("KNIGHT pop_date");
    public static final WorkingType SWAT_FACTORY_RESTART_DATE = new WorkingType("SWAT Factory Restart Date");
    public static final WorkingType SWAT_INSTALL_DATE = new WorkingType("SWAT Install Date");
    public static final WorkingType SWAT_BORN_ON_DATE = new WorkingType("SWAT Born On Date");
    public static final WorkingType SWAT_POP_DATE = new WorkingType("SWAT POP Date");
    public static final WorkingType SWAT_DEALER_SOLD_DATE = new WorkingType("SWAT Dealer Sold Date");
    public static final WorkingType SWAT_REGISTRATION_DATE = new WorkingType("SWAT Registration Date");
    public static final WorkingType SWAT_ORIGINAL_SHIP_DATE = new WorkingType("SWAT Original Ship Date");
    public static final WorkingType pmHP_GRACE_PERIOD = new WorkingType("pmHP Grace Period");
    public static final WorkingType KNIGHT_GRACE_PERIOD = new WorkingType("KNIGHT Grace Period");
    public static final WorkingType SWAT_STATUS = new WorkingType("SWAT Status");
    public static final WorkingType KNIGHT_STATUS = new WorkingType("KNIGHT Status");
    public static final WorkingType pmHP_STATUS = new WorkingType("pmHP Status");
    public static final WorkingType SWAT_UNIT_LIST_RETURNED = new WorkingType("SWAT Unit List Returned");
    public static final WorkingType KNIGHT_UNIT_LIST_RETURNED = new WorkingType("KNIGHT Unit List Returned");
    public static final WorkingType pmHP_UNIT_LIST_RETURNED = new WorkingType("pmHP Unit List Returned");
    public static final WorkingType pmHP_ORIGINAL_PRODUCT = new WorkingType("pmHP Original Product");
    public static final WorkingType pmHP_PRODUCT_ALIAS = new WorkingType("pmHP Product Alias");
    public static final WorkingType SWOP_Warranty_ID = new WorkingType("SWOP Warranty ID");
    public static final WorkingType SWOP_Warranty_Start_Date = new WorkingType("SWOP Warranty Start Date");
    public static final WorkingType SWOP_Grace_Period = new WorkingType("SWOP Grace Period");
    public static final WorkingType SWOP_Proof_Of_Purchase_Date = new WorkingType("SWOP Proof Of Purchase Date");
    public static final WorkingType SWOP_Shipment_Date = new WorkingType("SWOP Shipment Date");
    public static final WorkingType SWOP_Dealer_Sold_Date = new WorkingType("SWOP Dealer Sold Date");
    public static final WorkingType SWOP_Installation_Date = new WorkingType("SWOP Installation Date");
    public static final WorkingType SWOP_Registration_Date = new WorkingType("SWOP Registration Date");
    public static final WorkingType SWOP_Born_On_Date = new WorkingType("SWOP Born On Date");
    public static final WorkingType SWOP_Factory_Restart_Date = new WorkingType("SWOP Factory Restart Date");
    public static final WorkingType SWOP_Start_Date_Type = new WorkingType("SWOP Start Date Type");
    public static final WorkingType SWOP_Status = new WorkingType("SWOP Status");
    public static final WorkingType SWOP_Original_Product = new WorkingType("SWOP Original Product");
    public static final WorkingType SWOP_Product_Alias = new WorkingType("SWOP Product Alias");
    public static final WorkingType SWOP_Unit_List_Returned = new WorkingType("SWOP Unit List Returned");
    public static final WorkingType SWOP_Product_Base_Warranty = new WorkingType("SWOP Product Base Warranty");
    public WorkingType(String workingName) {
        this.workingName = workingName;
    }

    public String toString() {
        return workingName;
    }


}
