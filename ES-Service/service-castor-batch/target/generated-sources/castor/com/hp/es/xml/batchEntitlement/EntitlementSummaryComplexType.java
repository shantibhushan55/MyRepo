/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement;

/**
 * Class EntitlementSummaryComplexType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EntitlementSummaryComplexType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _serialNumber.
     */
    private java.lang.String _serialNumber;

    /**
     * Field _productId.
     */
    private java.lang.String _productId;

    /**
     * Field _productDescription.
     */
    private java.lang.String _productDescription;

    /**
     * Field _activeWarrantyEntitlement.
     */
    private boolean _activeWarrantyEntitlement;

    /**
     * keeps track of state for field: _activeWarrantyEntitlement
     */
    private boolean _has_activeWarrantyEntitlement;

    /**
     * Field _overallWarrantyStartDate.
     */
    private org.exolab.castor.types.Date _overallWarrantyStartDate;

    /**
     * Field _overallWarrantyEndDate.
     */
    private org.exolab.castor.types.Date _overallWarrantyEndDate;

    /**
     * Field _activeContractEntitlement.
     */
    private boolean _activeContractEntitlement;

    /**
     * keeps track of state for field: _activeContractEntitlement
     */
    private boolean _has_activeContractEntitlement;

    /**
     * Field _overallContractStartDate.
     */
    private org.exolab.castor.types.Date _overallContractStartDate;

    /**
     * Field _overallContractEndDate.
     */
    private org.exolab.castor.types.Date _overallContractEndDate;

    /**
     * Field _warrantyDeterminationDescription.
     */
    private java.lang.String _warrantyDeterminationDescription;

    /**
     * Field _warrantyComment.
     */
    private java.lang.String _warrantyComment;

    /**
     * Field _salesOrderNumber.
     */
    private java.lang.String _salesOrderNumber;

    /**
     * Field _shipmentDate.
     */
    private org.exolab.castor.types.Date _shipmentDate;

    /**
     * Field _gracePeriod.
     */
    private int _gracePeriod;

    /**
     * keeps track of state for field: _gracePeriod
     */
    private boolean _has_gracePeriod;

    /**
     * Field _warrantyExtension.
     */
    private java.lang.String _warrantyExtension;

    /**
     * Field _factoryWarrantyPortfolioFlag.
     */
    private com.hp.es.xml.batchEntitlement.types.FactoryWarrantyPortfolioFlagType _factoryWarrantyPortfolioFlag;

    /**
     * Field _factoryWarrantyTermCode.
     */
    private java.lang.String _factoryWarrantyTermCode;

    /**
     * Field _bundledWarrantyPortfolioFlag.
     */
    private com.hp.es.xml.batchEntitlement.types.BundledWarrantyPortfolioFlagType _bundledWarrantyPortfolioFlag;

    /**
     * Field _bundledWarrantyTermCode.
     */
    private java.lang.String _bundledWarrantyTermCode;

    /**
     * Field _shipToCountry.
     */
    private java.lang.String _shipToCountry;

    /**
     * Field _factoryWarrantyStartDate.
     */
    private org.exolab.castor.types.Date _factoryWarrantyStartDate;

    /**
     * Field _factoryWarrantyEndDate.
     */
    private org.exolab.castor.types.Date _factoryWarrantyEndDate;

    /**
     * Field _offerSummaryList.
     */
    private java.util.List<com.hp.es.xml.batchEntitlement.OfferSummaryComplexType> _offerSummaryList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EntitlementSummaryComplexType() {
        super();
        this._offerSummaryList = new java.util.ArrayList<com.hp.es.xml.batchEntitlement.OfferSummaryComplexType>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOfferSummary
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOfferSummary(
            final com.hp.es.xml.batchEntitlement.OfferSummaryComplexType vOfferSummary)
    throws java.lang.IndexOutOfBoundsException {
        this._offerSummaryList.add(vOfferSummary);
    }

    /**
     * 
     * 
     * @param index
     * @param vOfferSummary
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOfferSummary(
            final int index,
            final com.hp.es.xml.batchEntitlement.OfferSummaryComplexType vOfferSummary)
    throws java.lang.IndexOutOfBoundsException {
        this._offerSummaryList.add(index, vOfferSummary);
    }

    /**
     */
    public void deleteActiveContractEntitlement(
    ) {
        this._has_activeContractEntitlement= false;
    }

    /**
     */
    public void deleteActiveWarrantyEntitlement(
    ) {
        this._has_activeWarrantyEntitlement= false;
    }

    /**
     */
    public void deleteGracePeriod(
    ) {
        this._has_gracePeriod= false;
    }

    /**
     * Method enumerateOfferSummary.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.hp.es.xml.batchEntitlement.OfferSummaryComplexType> enumerateOfferSummary(
    ) {
        return java.util.Collections.enumeration(this._offerSummaryList);
    }

    /**
     * Overrides the java.lang.Object.equals method.
     * 
     * @param obj
     * @return true if the objects are equal.
     */
    @Override()
    public boolean equals(
            final java.lang.Object obj) {
        if ( this == obj )
            return true;

        if (obj instanceof EntitlementSummaryComplexType) {

            EntitlementSummaryComplexType temp = (EntitlementSummaryComplexType)obj;
            boolean thcycle;
            boolean tmcycle;
            if (this._serialNumber != null) {
                if (temp._serialNumber == null) return false;
                if (this._serialNumber != temp._serialNumber) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._serialNumber);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._serialNumber);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._serialNumber); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._serialNumber); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._serialNumber.equals(temp._serialNumber)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._serialNumber);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._serialNumber);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._serialNumber);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._serialNumber);
                    }
                }
            } else if (temp._serialNumber != null)
                return false;
            if (this._productId != null) {
                if (temp._productId == null) return false;
                if (this._productId != temp._productId) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._productId);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._productId);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productId); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productId); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._productId.equals(temp._productId)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productId);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productId);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productId);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productId);
                    }
                }
            } else if (temp._productId != null)
                return false;
            if (this._productDescription != null) {
                if (temp._productDescription == null) return false;
                if (this._productDescription != temp._productDescription) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._productDescription);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._productDescription);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productDescription); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productDescription); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._productDescription.equals(temp._productDescription)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productDescription);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productDescription);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productDescription);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productDescription);
                    }
                }
            } else if (temp._productDescription != null)
                return false;
            if (this._activeWarrantyEntitlement != temp._activeWarrantyEntitlement)
                return false;
            if (this._has_activeWarrantyEntitlement != temp._has_activeWarrantyEntitlement)
                return false;
            if (this._overallWarrantyStartDate != null) {
                if (temp._overallWarrantyStartDate == null) return false;
                if (this._overallWarrantyStartDate != temp._overallWarrantyStartDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._overallWarrantyStartDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._overallWarrantyStartDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallWarrantyStartDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallWarrantyStartDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._overallWarrantyStartDate.equals(temp._overallWarrantyStartDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallWarrantyStartDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallWarrantyStartDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallWarrantyStartDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallWarrantyStartDate);
                    }
                }
            } else if (temp._overallWarrantyStartDate != null)
                return false;
            if (this._overallWarrantyEndDate != null) {
                if (temp._overallWarrantyEndDate == null) return false;
                if (this._overallWarrantyEndDate != temp._overallWarrantyEndDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._overallWarrantyEndDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._overallWarrantyEndDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallWarrantyEndDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallWarrantyEndDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._overallWarrantyEndDate.equals(temp._overallWarrantyEndDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallWarrantyEndDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallWarrantyEndDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallWarrantyEndDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallWarrantyEndDate);
                    }
                }
            } else if (temp._overallWarrantyEndDate != null)
                return false;
            if (this._activeContractEntitlement != temp._activeContractEntitlement)
                return false;
            if (this._has_activeContractEntitlement != temp._has_activeContractEntitlement)
                return false;
            if (this._overallContractStartDate != null) {
                if (temp._overallContractStartDate == null) return false;
                if (this._overallContractStartDate != temp._overallContractStartDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._overallContractStartDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._overallContractStartDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallContractStartDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallContractStartDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._overallContractStartDate.equals(temp._overallContractStartDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallContractStartDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallContractStartDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallContractStartDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallContractStartDate);
                    }
                }
            } else if (temp._overallContractStartDate != null)
                return false;
            if (this._overallContractEndDate != null) {
                if (temp._overallContractEndDate == null) return false;
                if (this._overallContractEndDate != temp._overallContractEndDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._overallContractEndDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._overallContractEndDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallContractEndDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallContractEndDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._overallContractEndDate.equals(temp._overallContractEndDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallContractEndDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallContractEndDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._overallContractEndDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._overallContractEndDate);
                    }
                }
            } else if (temp._overallContractEndDate != null)
                return false;
            if (this._warrantyDeterminationDescription != null) {
                if (temp._warrantyDeterminationDescription == null) return false;
                if (this._warrantyDeterminationDescription != temp._warrantyDeterminationDescription) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._warrantyDeterminationDescription);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._warrantyDeterminationDescription);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyDeterminationDescription); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyDeterminationDescription); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._warrantyDeterminationDescription.equals(temp._warrantyDeterminationDescription)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyDeterminationDescription);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyDeterminationDescription);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyDeterminationDescription);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyDeterminationDescription);
                    }
                }
            } else if (temp._warrantyDeterminationDescription != null)
                return false;
            if (this._warrantyComment != null) {
                if (temp._warrantyComment == null) return false;
                if (this._warrantyComment != temp._warrantyComment) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._warrantyComment);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._warrantyComment);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyComment); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyComment); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._warrantyComment.equals(temp._warrantyComment)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyComment);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyComment);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyComment);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyComment);
                    }
                }
            } else if (temp._warrantyComment != null)
                return false;
            if (this._salesOrderNumber != null) {
                if (temp._salesOrderNumber == null) return false;
                if (this._salesOrderNumber != temp._salesOrderNumber) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._salesOrderNumber);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._salesOrderNumber);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._salesOrderNumber); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._salesOrderNumber); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._salesOrderNumber.equals(temp._salesOrderNumber)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._salesOrderNumber);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._salesOrderNumber);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._salesOrderNumber);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._salesOrderNumber);
                    }
                }
            } else if (temp._salesOrderNumber != null)
                return false;
            if (this._shipmentDate != null) {
                if (temp._shipmentDate == null) return false;
                if (this._shipmentDate != temp._shipmentDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._shipmentDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._shipmentDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._shipmentDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._shipmentDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._shipmentDate.equals(temp._shipmentDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._shipmentDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._shipmentDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._shipmentDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._shipmentDate);
                    }
                }
            } else if (temp._shipmentDate != null)
                return false;
            if (this._gracePeriod != temp._gracePeriod)
                return false;
            if (this._has_gracePeriod != temp._has_gracePeriod)
                return false;
            if (this._warrantyExtension != null) {
                if (temp._warrantyExtension == null) return false;
                if (this._warrantyExtension != temp._warrantyExtension) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._warrantyExtension);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._warrantyExtension);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyExtension); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyExtension); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._warrantyExtension.equals(temp._warrantyExtension)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyExtension);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyExtension);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyExtension);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyExtension);
                    }
                }
            } else if (temp._warrantyExtension != null)
                return false;
            if (this._factoryWarrantyPortfolioFlag != null) {
                if (temp._factoryWarrantyPortfolioFlag == null) return false;
                if (this._factoryWarrantyPortfolioFlag != temp._factoryWarrantyPortfolioFlag) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._factoryWarrantyPortfolioFlag);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._factoryWarrantyPortfolioFlag);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyPortfolioFlag); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyPortfolioFlag); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._factoryWarrantyPortfolioFlag.equals(temp._factoryWarrantyPortfolioFlag)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyPortfolioFlag);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyPortfolioFlag);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyPortfolioFlag);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyPortfolioFlag);
                    }
                }
            } else if (temp._factoryWarrantyPortfolioFlag != null)
                return false;
            if (this._factoryWarrantyTermCode != null) {
                if (temp._factoryWarrantyTermCode == null) return false;
                if (this._factoryWarrantyTermCode != temp._factoryWarrantyTermCode) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._factoryWarrantyTermCode);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._factoryWarrantyTermCode);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyTermCode); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyTermCode); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._factoryWarrantyTermCode.equals(temp._factoryWarrantyTermCode)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyTermCode);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyTermCode);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyTermCode);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyTermCode);
                    }
                }
            } else if (temp._factoryWarrantyTermCode != null)
                return false;
            if (this._bundledWarrantyPortfolioFlag != null) {
                if (temp._bundledWarrantyPortfolioFlag == null) return false;
                if (this._bundledWarrantyPortfolioFlag != temp._bundledWarrantyPortfolioFlag) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._bundledWarrantyPortfolioFlag);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._bundledWarrantyPortfolioFlag);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._bundledWarrantyPortfolioFlag); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._bundledWarrantyPortfolioFlag); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._bundledWarrantyPortfolioFlag.equals(temp._bundledWarrantyPortfolioFlag)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._bundledWarrantyPortfolioFlag);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._bundledWarrantyPortfolioFlag);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._bundledWarrantyPortfolioFlag);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._bundledWarrantyPortfolioFlag);
                    }
                }
            } else if (temp._bundledWarrantyPortfolioFlag != null)
                return false;
            if (this._bundledWarrantyTermCode != null) {
                if (temp._bundledWarrantyTermCode == null) return false;
                if (this._bundledWarrantyTermCode != temp._bundledWarrantyTermCode) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._bundledWarrantyTermCode);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._bundledWarrantyTermCode);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._bundledWarrantyTermCode); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._bundledWarrantyTermCode); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._bundledWarrantyTermCode.equals(temp._bundledWarrantyTermCode)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._bundledWarrantyTermCode);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._bundledWarrantyTermCode);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._bundledWarrantyTermCode);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._bundledWarrantyTermCode);
                    }
                }
            } else if (temp._bundledWarrantyTermCode != null)
                return false;
            if (this._shipToCountry != null) {
                if (temp._shipToCountry == null) return false;
                if (this._shipToCountry != temp._shipToCountry) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._shipToCountry);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._shipToCountry);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._shipToCountry); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._shipToCountry); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._shipToCountry.equals(temp._shipToCountry)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._shipToCountry);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._shipToCountry);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._shipToCountry);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._shipToCountry);
                    }
                }
            } else if (temp._shipToCountry != null)
                return false;
            if (this._factoryWarrantyStartDate != null) {
                if (temp._factoryWarrantyStartDate == null) return false;
                if (this._factoryWarrantyStartDate != temp._factoryWarrantyStartDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._factoryWarrantyStartDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._factoryWarrantyStartDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyStartDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyStartDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._factoryWarrantyStartDate.equals(temp._factoryWarrantyStartDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyStartDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyStartDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyStartDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyStartDate);
                    }
                }
            } else if (temp._factoryWarrantyStartDate != null)
                return false;
            if (this._factoryWarrantyEndDate != null) {
                if (temp._factoryWarrantyEndDate == null) return false;
                if (this._factoryWarrantyEndDate != temp._factoryWarrantyEndDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._factoryWarrantyEndDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._factoryWarrantyEndDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyEndDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyEndDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._factoryWarrantyEndDate.equals(temp._factoryWarrantyEndDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyEndDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyEndDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._factoryWarrantyEndDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._factoryWarrantyEndDate);
                    }
                }
            } else if (temp._factoryWarrantyEndDate != null)
                return false;
            if (this._offerSummaryList != null) {
                if (temp._offerSummaryList == null) return false;
                if (this._offerSummaryList != temp._offerSummaryList) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._offerSummaryList);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._offerSummaryList);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerSummaryList); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerSummaryList); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._offerSummaryList.equals(temp._offerSummaryList)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerSummaryList);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerSummaryList);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerSummaryList);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerSummaryList);
                    }
                }
            } else if (temp._offerSummaryList != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'activeContractEntitlement'.
     * 
     * @return the value of field 'ActiveContractEntitlement'.
     */
    public boolean getActiveContractEntitlement(
    ) {
        return this._activeContractEntitlement;
    }

    /**
     * Returns the value of field 'activeWarrantyEntitlement'.
     * 
     * @return the value of field 'ActiveWarrantyEntitlement'.
     */
    public boolean getActiveWarrantyEntitlement(
    ) {
        return this._activeWarrantyEntitlement;
    }

    /**
     * Returns the value of field 'bundledWarrantyPortfolioFlag'.
     * 
     * @return the value of field 'BundledWarrantyPortfolioFlag'.
     */
    public com.hp.es.xml.batchEntitlement.types.BundledWarrantyPortfolioFlagType getBundledWarrantyPortfolioFlag(
    ) {
        return this._bundledWarrantyPortfolioFlag;
    }

    /**
     * Returns the value of field 'bundledWarrantyTermCode'.
     * 
     * @return the value of field 'BundledWarrantyTermCode'.
     */
    public java.lang.String getBundledWarrantyTermCode(
    ) {
        return this._bundledWarrantyTermCode;
    }

    /**
     * Returns the value of field 'factoryWarrantyEndDate'.
     * 
     * @return the value of field 'FactoryWarrantyEndDate'.
     */
    public org.exolab.castor.types.Date getFactoryWarrantyEndDate(
    ) {
        return this._factoryWarrantyEndDate;
    }

    /**
     * Returns the value of field 'factoryWarrantyPortfolioFlag'.
     * 
     * @return the value of field 'FactoryWarrantyPortfolioFlag'.
     */
    public com.hp.es.xml.batchEntitlement.types.FactoryWarrantyPortfolioFlagType getFactoryWarrantyPortfolioFlag(
    ) {
        return this._factoryWarrantyPortfolioFlag;
    }

    /**
     * Returns the value of field 'factoryWarrantyStartDate'.
     * 
     * @return the value of field 'FactoryWarrantyStartDate'.
     */
    public org.exolab.castor.types.Date getFactoryWarrantyStartDate(
    ) {
        return this._factoryWarrantyStartDate;
    }

    /**
     * Returns the value of field 'factoryWarrantyTermCode'.
     * 
     * @return the value of field 'FactoryWarrantyTermCode'.
     */
    public java.lang.String getFactoryWarrantyTermCode(
    ) {
        return this._factoryWarrantyTermCode;
    }

    /**
     * Returns the value of field 'gracePeriod'.
     * 
     * @return the value of field 'GracePeriod'.
     */
    public int getGracePeriod(
    ) {
        return this._gracePeriod;
    }

    /**
     * Method getOfferSummary.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.hp.es.xml.batchEntitlement.OfferSummaryComplexType at
     * the given index
     */
    public com.hp.es.xml.batchEntitlement.OfferSummaryComplexType getOfferSummary(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._offerSummaryList.size()) {
            throw new IndexOutOfBoundsException("getOfferSummary: Index value '" + index + "' not in range [0.." + (this._offerSummaryList.size() - 1) + "]");
        }

        return (com.hp.es.xml.batchEntitlement.OfferSummaryComplexType) _offerSummaryList.get(index);
    }

    /**
     * Method getOfferSummary.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.hp.es.xml.batchEntitlement.OfferSummaryComplexType[] getOfferSummary(
    ) {
        com.hp.es.xml.batchEntitlement.OfferSummaryComplexType[] array = new com.hp.es.xml.batchEntitlement.OfferSummaryComplexType[0];
        return (com.hp.es.xml.batchEntitlement.OfferSummaryComplexType[]) this._offerSummaryList.toArray(array);
    }

    /**
     * Method getOfferSummaryCount.
     * 
     * @return the size of this collection
     */
    public int getOfferSummaryCount(
    ) {
        return this._offerSummaryList.size();
    }

    /**
     * Returns the value of field 'overallContractEndDate'.
     * 
     * @return the value of field 'OverallContractEndDate'.
     */
    public org.exolab.castor.types.Date getOverallContractEndDate(
    ) {
        return this._overallContractEndDate;
    }

    /**
     * Returns the value of field 'overallContractStartDate'.
     * 
     * @return the value of field 'OverallContractStartDate'.
     */
    public org.exolab.castor.types.Date getOverallContractStartDate(
    ) {
        return this._overallContractStartDate;
    }

    /**
     * Returns the value of field 'overallWarrantyEndDate'.
     * 
     * @return the value of field 'OverallWarrantyEndDate'.
     */
    public org.exolab.castor.types.Date getOverallWarrantyEndDate(
    ) {
        return this._overallWarrantyEndDate;
    }

    /**
     * Returns the value of field 'overallWarrantyStartDate'.
     * 
     * @return the value of field 'OverallWarrantyStartDate'.
     */
    public org.exolab.castor.types.Date getOverallWarrantyStartDate(
    ) {
        return this._overallWarrantyStartDate;
    }

    /**
     * Returns the value of field 'productDescription'.
     * 
     * @return the value of field 'ProductDescription'.
     */
    public java.lang.String getProductDescription(
    ) {
        return this._productDescription;
    }

    /**
     * Returns the value of field 'productId'.
     * 
     * @return the value of field 'ProductId'.
     */
    public java.lang.String getProductId(
    ) {
        return this._productId;
    }

    /**
     * Returns the value of field 'salesOrderNumber'.
     * 
     * @return the value of field 'SalesOrderNumber'.
     */
    public java.lang.String getSalesOrderNumber(
    ) {
        return this._salesOrderNumber;
    }

    /**
     * Returns the value of field 'serialNumber'.
     * 
     * @return the value of field 'SerialNumber'.
     */
    public java.lang.String getSerialNumber(
    ) {
        return this._serialNumber;
    }

    /**
     * Returns the value of field 'shipToCountry'.
     * 
     * @return the value of field 'ShipToCountry'.
     */
    public java.lang.String getShipToCountry(
    ) {
        return this._shipToCountry;
    }

    /**
     * Returns the value of field 'shipmentDate'.
     * 
     * @return the value of field 'ShipmentDate'.
     */
    public org.exolab.castor.types.Date getShipmentDate(
    ) {
        return this._shipmentDate;
    }

    /**
     * Returns the value of field 'warrantyComment'.
     * 
     * @return the value of field 'WarrantyComment'.
     */
    public java.lang.String getWarrantyComment(
    ) {
        return this._warrantyComment;
    }

    /**
     * Returns the value of field
     * 'warrantyDeterminationDescription'.
     * 
     * @return the value of field 'WarrantyDeterminationDescription'
     */
    public java.lang.String getWarrantyDeterminationDescription(
    ) {
        return this._warrantyDeterminationDescription;
    }

    /**
     * Returns the value of field 'warrantyExtension'.
     * 
     * @return the value of field 'WarrantyExtension'.
     */
    public java.lang.String getWarrantyExtension(
    ) {
        return this._warrantyExtension;
    }

    /**
     * Method hasActiveContractEntitlement.
     * 
     * @return true if at least one ActiveContractEntitlement has
     * been added
     */
    public boolean hasActiveContractEntitlement(
    ) {
        return this._has_activeContractEntitlement;
    }

    /**
     * Method hasActiveWarrantyEntitlement.
     * 
     * @return true if at least one ActiveWarrantyEntitlement has
     * been added
     */
    public boolean hasActiveWarrantyEntitlement(
    ) {
        return this._has_activeWarrantyEntitlement;
    }

    /**
     * Method hasGracePeriod.
     * 
     * @return true if at least one GracePeriod has been added
     */
    public boolean hasGracePeriod(
    ) {
        return this._has_gracePeriod;
    }

    /**
     * Overrides the java.lang.Object.hashCode method.
     * <p>
     * The following steps came from <b>Effective Java Programming
     * Language Guide</b> by Joshua Bloch, Chapter 3
     * 
     * @return a hash code value for the object.
     */
    public int hashCode(
    ) {
        int result = 17;

        long tmp;
        if (_serialNumber != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_serialNumber)) {
           result = 37 * result + _serialNumber.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_serialNumber);
        }
        if (_productId != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_productId)) {
           result = 37 * result + _productId.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_productId);
        }
        if (_productDescription != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_productDescription)) {
           result = 37 * result + _productDescription.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_productDescription);
        }
        result = 37 * result + (_activeWarrantyEntitlement?0:1);
        if (_overallWarrantyStartDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_overallWarrantyStartDate)) {
           result = 37 * result + _overallWarrantyStartDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_overallWarrantyStartDate);
        }
        if (_overallWarrantyEndDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_overallWarrantyEndDate)) {
           result = 37 * result + _overallWarrantyEndDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_overallWarrantyEndDate);
        }
        result = 37 * result + (_activeContractEntitlement?0:1);
        if (_overallContractStartDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_overallContractStartDate)) {
           result = 37 * result + _overallContractStartDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_overallContractStartDate);
        }
        if (_overallContractEndDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_overallContractEndDate)) {
           result = 37 * result + _overallContractEndDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_overallContractEndDate);
        }
        if (_warrantyDeterminationDescription != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_warrantyDeterminationDescription)) {
           result = 37 * result + _warrantyDeterminationDescription.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_warrantyDeterminationDescription);
        }
        if (_warrantyComment != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_warrantyComment)) {
           result = 37 * result + _warrantyComment.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_warrantyComment);
        }
        if (_salesOrderNumber != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_salesOrderNumber)) {
           result = 37 * result + _salesOrderNumber.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_salesOrderNumber);
        }
        if (_shipmentDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_shipmentDate)) {
           result = 37 * result + _shipmentDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_shipmentDate);
        }
        result = 37 * result + _gracePeriod;
        if (_warrantyExtension != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_warrantyExtension)) {
           result = 37 * result + _warrantyExtension.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_warrantyExtension);
        }
        if (_factoryWarrantyPortfolioFlag != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_factoryWarrantyPortfolioFlag)) {
           result = 37 * result + _factoryWarrantyPortfolioFlag.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_factoryWarrantyPortfolioFlag);
        }
        if (_factoryWarrantyTermCode != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_factoryWarrantyTermCode)) {
           result = 37 * result + _factoryWarrantyTermCode.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_factoryWarrantyTermCode);
        }
        if (_bundledWarrantyPortfolioFlag != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_bundledWarrantyPortfolioFlag)) {
           result = 37 * result + _bundledWarrantyPortfolioFlag.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_bundledWarrantyPortfolioFlag);
        }
        if (_bundledWarrantyTermCode != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_bundledWarrantyTermCode)) {
           result = 37 * result + _bundledWarrantyTermCode.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_bundledWarrantyTermCode);
        }
        if (_shipToCountry != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_shipToCountry)) {
           result = 37 * result + _shipToCountry.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_shipToCountry);
        }
        if (_factoryWarrantyStartDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_factoryWarrantyStartDate)) {
           result = 37 * result + _factoryWarrantyStartDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_factoryWarrantyStartDate);
        }
        if (_factoryWarrantyEndDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_factoryWarrantyEndDate)) {
           result = 37 * result + _factoryWarrantyEndDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_factoryWarrantyEndDate);
        }
        if (_offerSummaryList != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_offerSummaryList)) {
           result = 37 * result + _offerSummaryList.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_offerSummaryList);
        }

        return result;
    }

    /**
     * Returns the value of field 'activeContractEntitlement'.
     * 
     * @return the value of field 'ActiveContractEntitlement'.
     */
    public boolean isActiveContractEntitlement(
    ) {
        return this._activeContractEntitlement;
    }

    /**
     * Returns the value of field 'activeWarrantyEntitlement'.
     * 
     * @return the value of field 'ActiveWarrantyEntitlement'.
     */
    public boolean isActiveWarrantyEntitlement(
    ) {
        return this._activeWarrantyEntitlement;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Method iterateOfferSummary.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.hp.es.xml.batchEntitlement.OfferSummaryComplexType> iterateOfferSummary(
    ) {
        return this._offerSummaryList.iterator();
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllOfferSummary(
    ) {
        this._offerSummaryList.clear();
    }

    /**
     * Method removeOfferSummary.
     * 
     * @param vOfferSummary
     * @return true if the object was removed from the collection.
     */
    public boolean removeOfferSummary(
            final com.hp.es.xml.batchEntitlement.OfferSummaryComplexType vOfferSummary) {
        boolean removed = _offerSummaryList.remove(vOfferSummary);
        return removed;
    }

    /**
     * Method removeOfferSummaryAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.hp.es.xml.batchEntitlement.OfferSummaryComplexType removeOfferSummaryAt(
            final int index) {
        java.lang.Object obj = this._offerSummaryList.remove(index);
        return (com.hp.es.xml.batchEntitlement.OfferSummaryComplexType) obj;
    }

    /**
     * Sets the value of field 'activeContractEntitlement'.
     * 
     * @param activeContractEntitlement the value of field
     * 'activeContractEntitlement'.
     */
    public void setActiveContractEntitlement(
            final boolean activeContractEntitlement) {
        this._activeContractEntitlement = activeContractEntitlement;
        this._has_activeContractEntitlement = true;
    }

    /**
     * Sets the value of field 'activeWarrantyEntitlement'.
     * 
     * @param activeWarrantyEntitlement the value of field
     * 'activeWarrantyEntitlement'.
     */
    public void setActiveWarrantyEntitlement(
            final boolean activeWarrantyEntitlement) {
        this._activeWarrantyEntitlement = activeWarrantyEntitlement;
        this._has_activeWarrantyEntitlement = true;
    }

    /**
     * Sets the value of field 'bundledWarrantyPortfolioFlag'.
     * 
     * @param bundledWarrantyPortfolioFlag the value of field
     * 'bundledWarrantyPortfolioFlag'.
     */
    public void setBundledWarrantyPortfolioFlag(
            final com.hp.es.xml.batchEntitlement.types.BundledWarrantyPortfolioFlagType bundledWarrantyPortfolioFlag) {
        this._bundledWarrantyPortfolioFlag = bundledWarrantyPortfolioFlag;
    }

    /**
     * Sets the value of field 'bundledWarrantyTermCode'.
     * 
     * @param bundledWarrantyTermCode the value of field
     * 'bundledWarrantyTermCode'.
     */
    public void setBundledWarrantyTermCode(
            final java.lang.String bundledWarrantyTermCode) {
        this._bundledWarrantyTermCode = bundledWarrantyTermCode;
    }

    /**
     * Sets the value of field 'factoryWarrantyEndDate'.
     * 
     * @param factoryWarrantyEndDate the value of field
     * 'factoryWarrantyEndDate'.
     */
    public void setFactoryWarrantyEndDate(
            final org.exolab.castor.types.Date factoryWarrantyEndDate) {
        this._factoryWarrantyEndDate = factoryWarrantyEndDate;
    }

    /**
     * Sets the value of field 'factoryWarrantyPortfolioFlag'.
     * 
     * @param factoryWarrantyPortfolioFlag the value of field
     * 'factoryWarrantyPortfolioFlag'.
     */
    public void setFactoryWarrantyPortfolioFlag(
            final com.hp.es.xml.batchEntitlement.types.FactoryWarrantyPortfolioFlagType factoryWarrantyPortfolioFlag) {
        this._factoryWarrantyPortfolioFlag = factoryWarrantyPortfolioFlag;
    }

    /**
     * Sets the value of field 'factoryWarrantyStartDate'.
     * 
     * @param factoryWarrantyStartDate the value of field
     * 'factoryWarrantyStartDate'.
     */
    public void setFactoryWarrantyStartDate(
            final org.exolab.castor.types.Date factoryWarrantyStartDate) {
        this._factoryWarrantyStartDate = factoryWarrantyStartDate;
    }

    /**
     * Sets the value of field 'factoryWarrantyTermCode'.
     * 
     * @param factoryWarrantyTermCode the value of field
     * 'factoryWarrantyTermCode'.
     */
    public void setFactoryWarrantyTermCode(
            final java.lang.String factoryWarrantyTermCode) {
        this._factoryWarrantyTermCode = factoryWarrantyTermCode;
    }

    /**
     * Sets the value of field 'gracePeriod'.
     * 
     * @param gracePeriod the value of field 'gracePeriod'.
     */
    public void setGracePeriod(
            final int gracePeriod) {
        this._gracePeriod = gracePeriod;
        this._has_gracePeriod = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vOfferSummary
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOfferSummary(
            final int index,
            final com.hp.es.xml.batchEntitlement.OfferSummaryComplexType vOfferSummary)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._offerSummaryList.size()) {
            throw new IndexOutOfBoundsException("setOfferSummary: Index value '" + index + "' not in range [0.." + (this._offerSummaryList.size() - 1) + "]");
        }

        this._offerSummaryList.set(index, vOfferSummary);
    }

    /**
     * 
     * 
     * @param vOfferSummaryArray
     */
    public void setOfferSummary(
            final com.hp.es.xml.batchEntitlement.OfferSummaryComplexType[] vOfferSummaryArray) {
        //-- copy array
        _offerSummaryList.clear();

        for (int i = 0; i < vOfferSummaryArray.length; i++) {
                this._offerSummaryList.add(vOfferSummaryArray[i]);
        }
    }

    /**
     * Sets the value of field 'overallContractEndDate'.
     * 
     * @param overallContractEndDate the value of field
     * 'overallContractEndDate'.
     */
    public void setOverallContractEndDate(
            final org.exolab.castor.types.Date overallContractEndDate) {
        this._overallContractEndDate = overallContractEndDate;
    }

    /**
     * Sets the value of field 'overallContractStartDate'.
     * 
     * @param overallContractStartDate the value of field
     * 'overallContractStartDate'.
     */
    public void setOverallContractStartDate(
            final org.exolab.castor.types.Date overallContractStartDate) {
        this._overallContractStartDate = overallContractStartDate;
    }

    /**
     * Sets the value of field 'overallWarrantyEndDate'.
     * 
     * @param overallWarrantyEndDate the value of field
     * 'overallWarrantyEndDate'.
     */
    public void setOverallWarrantyEndDate(
            final org.exolab.castor.types.Date overallWarrantyEndDate) {
        this._overallWarrantyEndDate = overallWarrantyEndDate;
    }

    /**
     * Sets the value of field 'overallWarrantyStartDate'.
     * 
     * @param overallWarrantyStartDate the value of field
     * 'overallWarrantyStartDate'.
     */
    public void setOverallWarrantyStartDate(
            final org.exolab.castor.types.Date overallWarrantyStartDate) {
        this._overallWarrantyStartDate = overallWarrantyStartDate;
    }

    /**
     * Sets the value of field 'productDescription'.
     * 
     * @param productDescription the value of field
     * 'productDescription'.
     */
    public void setProductDescription(
            final java.lang.String productDescription) {
        this._productDescription = productDescription;
    }

    /**
     * Sets the value of field 'productId'.
     * 
     * @param productId the value of field 'productId'.
     */
    public void setProductId(
            final java.lang.String productId) {
        this._productId = productId;
    }

    /**
     * Sets the value of field 'salesOrderNumber'.
     * 
     * @param salesOrderNumber the value of field 'salesOrderNumber'
     */
    public void setSalesOrderNumber(
            final java.lang.String salesOrderNumber) {
        this._salesOrderNumber = salesOrderNumber;
    }

    /**
     * Sets the value of field 'serialNumber'.
     * 
     * @param serialNumber the value of field 'serialNumber'.
     */
    public void setSerialNumber(
            final java.lang.String serialNumber) {
        this._serialNumber = serialNumber;
    }

    /**
     * Sets the value of field 'shipToCountry'.
     * 
     * @param shipToCountry the value of field 'shipToCountry'.
     */
    public void setShipToCountry(
            final java.lang.String shipToCountry) {
        this._shipToCountry = shipToCountry;
    }

    /**
     * Sets the value of field 'shipmentDate'.
     * 
     * @param shipmentDate the value of field 'shipmentDate'.
     */
    public void setShipmentDate(
            final org.exolab.castor.types.Date shipmentDate) {
        this._shipmentDate = shipmentDate;
    }

    /**
     * Sets the value of field 'warrantyComment'.
     * 
     * @param warrantyComment the value of field 'warrantyComment'.
     */
    public void setWarrantyComment(
            final java.lang.String warrantyComment) {
        this._warrantyComment = warrantyComment;
    }

    /**
     * Sets the value of field 'warrantyDeterminationDescription'.
     * 
     * @param warrantyDeterminationDescription the value of field
     * 'warrantyDeterminationDescription'.
     */
    public void setWarrantyDeterminationDescription(
            final java.lang.String warrantyDeterminationDescription) {
        this._warrantyDeterminationDescription = warrantyDeterminationDescription;
    }

    /**
     * Sets the value of field 'warrantyExtension'.
     * 
     * @param warrantyExtension the value of field
     * 'warrantyExtension'.
     */
    public void setWarrantyExtension(
            final java.lang.String warrantyExtension) {
        this._warrantyExtension = warrantyExtension;
    }

    /**
     * Method unmarshalEntitlementSummaryComplexType.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType
     */
    public static com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType unmarshalEntitlementSummaryComplexType(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
