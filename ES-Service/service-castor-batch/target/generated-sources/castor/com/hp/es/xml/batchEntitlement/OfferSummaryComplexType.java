/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement;

/**
 * Class OfferSummaryComplexType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OfferSummaryComplexType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _offerCode.
     */
    private java.lang.String _offerCode;

    /**
     * Field _offerDescription.
     */
    private java.lang.String _offerDescription;

    /**
     * Field _portfolioFlag.
     */
    private java.lang.String _portfolioFlag;

    /**
     * Field _obligationType.
     */
    private java.lang.String _obligationType;

    /**
     * Field _warrantyTermCode.
     */
    private java.lang.String _warrantyTermCode;

    /**
     * Field _packageCode.
     */
    private java.lang.String _packageCode;

    /**
     * Field _packageDescription.
     */
    private java.lang.String _packageDescription;

    /**
     * Field _startDate.
     */
    private org.exolab.castor.types.Date _startDate;

    /**
     * Field _endDate.
     */
    private org.exolab.castor.types.Date _endDate;

    /**
     * Field _status.
     */
    private com.hp.es.xml.batchEntitlement.types.StatusType _status;

    /**
     * Field _contractIDCarepackSN.
     */
    private java.lang.String _contractIDCarepackSN;

    /**
     * Field _COVWINDOW.
     */
    private java.lang.String _COVWINDOW;

    /**
     * Field _responseCommitment.
     */
    private java.lang.String _responseCommitment;


      //----------------/
     //- Constructors -/
    //----------------/

    public OfferSummaryComplexType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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

        if (obj instanceof OfferSummaryComplexType) {

            OfferSummaryComplexType temp = (OfferSummaryComplexType)obj;
            boolean thcycle;
            boolean tmcycle;
            if (this._offerCode != null) {
                if (temp._offerCode == null) return false;
                if (this._offerCode != temp._offerCode) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._offerCode);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._offerCode);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerCode); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerCode); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._offerCode.equals(temp._offerCode)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerCode);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerCode);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerCode);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerCode);
                    }
                }
            } else if (temp._offerCode != null)
                return false;
            if (this._offerDescription != null) {
                if (temp._offerDescription == null) return false;
                if (this._offerDescription != temp._offerDescription) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._offerDescription);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._offerDescription);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerDescription); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerDescription); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._offerDescription.equals(temp._offerDescription)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerDescription);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerDescription);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._offerDescription);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._offerDescription);
                    }
                }
            } else if (temp._offerDescription != null)
                return false;
            if (this._portfolioFlag != null) {
                if (temp._portfolioFlag == null) return false;
                if (this._portfolioFlag != temp._portfolioFlag) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._portfolioFlag);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._portfolioFlag);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._portfolioFlag); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._portfolioFlag); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._portfolioFlag.equals(temp._portfolioFlag)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._portfolioFlag);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._portfolioFlag);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._portfolioFlag);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._portfolioFlag);
                    }
                }
            } else if (temp._portfolioFlag != null)
                return false;
            if (this._obligationType != null) {
                if (temp._obligationType == null) return false;
                if (this._obligationType != temp._obligationType) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._obligationType);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._obligationType);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._obligationType); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._obligationType); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._obligationType.equals(temp._obligationType)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._obligationType);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._obligationType);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._obligationType);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._obligationType);
                    }
                }
            } else if (temp._obligationType != null)
                return false;
            if (this._warrantyTermCode != null) {
                if (temp._warrantyTermCode == null) return false;
                if (this._warrantyTermCode != temp._warrantyTermCode) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._warrantyTermCode);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._warrantyTermCode);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyTermCode); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyTermCode); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._warrantyTermCode.equals(temp._warrantyTermCode)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyTermCode);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyTermCode);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._warrantyTermCode);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._warrantyTermCode);
                    }
                }
            } else if (temp._warrantyTermCode != null)
                return false;
            if (this._packageCode != null) {
                if (temp._packageCode == null) return false;
                if (this._packageCode != temp._packageCode) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._packageCode);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._packageCode);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._packageCode); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._packageCode); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._packageCode.equals(temp._packageCode)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._packageCode);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._packageCode);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._packageCode);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._packageCode);
                    }
                }
            } else if (temp._packageCode != null)
                return false;
            if (this._packageDescription != null) {
                if (temp._packageDescription == null) return false;
                if (this._packageDescription != temp._packageDescription) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._packageDescription);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._packageDescription);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._packageDescription); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._packageDescription); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._packageDescription.equals(temp._packageDescription)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._packageDescription);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._packageDescription);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._packageDescription);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._packageDescription);
                    }
                }
            } else if (temp._packageDescription != null)
                return false;
            if (this._startDate != null) {
                if (temp._startDate == null) return false;
                if (this._startDate != temp._startDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._startDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._startDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._startDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._startDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._startDate.equals(temp._startDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._startDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._startDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._startDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._startDate);
                    }
                }
            } else if (temp._startDate != null)
                return false;
            if (this._endDate != null) {
                if (temp._endDate == null) return false;
                if (this._endDate != temp._endDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._endDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._endDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._endDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._endDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._endDate.equals(temp._endDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._endDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._endDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._endDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._endDate);
                    }
                }
            } else if (temp._endDate != null)
                return false;
            if (this._status != null) {
                if (temp._status == null) return false;
                if (this._status != temp._status) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._status);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._status);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._status); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._status); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._status.equals(temp._status)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._status);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._status);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._status);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._status);
                    }
                }
            } else if (temp._status != null)
                return false;
            if (this._contractIDCarepackSN != null) {
                if (temp._contractIDCarepackSN == null) return false;
                if (this._contractIDCarepackSN != temp._contractIDCarepackSN) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._contractIDCarepackSN);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._contractIDCarepackSN);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._contractIDCarepackSN); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._contractIDCarepackSN); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._contractIDCarepackSN.equals(temp._contractIDCarepackSN)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._contractIDCarepackSN);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._contractIDCarepackSN);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._contractIDCarepackSN);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._contractIDCarepackSN);
                    }
                }
            } else if (temp._contractIDCarepackSN != null)
                return false;
            if (this._COVWINDOW != null) {
                if (temp._COVWINDOW == null) return false;
                if (this._COVWINDOW != temp._COVWINDOW) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._COVWINDOW);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._COVWINDOW);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._COVWINDOW); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._COVWINDOW); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._COVWINDOW.equals(temp._COVWINDOW)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._COVWINDOW);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._COVWINDOW);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._COVWINDOW);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._COVWINDOW);
                    }
                }
            } else if (temp._COVWINDOW != null)
                return false;
            if (this._responseCommitment != null) {
                if (temp._responseCommitment == null) return false;
                if (this._responseCommitment != temp._responseCommitment) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._responseCommitment);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._responseCommitment);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._responseCommitment); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._responseCommitment); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._responseCommitment.equals(temp._responseCommitment)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._responseCommitment);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._responseCommitment);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._responseCommitment);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._responseCommitment);
                    }
                }
            } else if (temp._responseCommitment != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'COVWINDOW'.
     * 
     * @return the value of field 'COVWINDOW'.
     */
    public java.lang.String getCOVWINDOW(
    ) {
        return this._COVWINDOW;
    }

    /**
     * Returns the value of field 'contractIDCarepackSN'.
     * 
     * @return the value of field 'ContractIDCarepackSN'.
     */
    public java.lang.String getContractIDCarepackSN(
    ) {
        return this._contractIDCarepackSN;
    }

    /**
     * Returns the value of field 'endDate'.
     * 
     * @return the value of field 'EndDate'.
     */
    public org.exolab.castor.types.Date getEndDate(
    ) {
        return this._endDate;
    }

    /**
     * Returns the value of field 'obligationType'.
     * 
     * @return the value of field 'ObligationType'.
     */
    public java.lang.String getObligationType(
    ) {
        return this._obligationType;
    }

    /**
     * Returns the value of field 'offerCode'.
     * 
     * @return the value of field 'OfferCode'.
     */
    public java.lang.String getOfferCode(
    ) {
        return this._offerCode;
    }

    /**
     * Returns the value of field 'offerDescription'.
     * 
     * @return the value of field 'OfferDescription'.
     */
    public java.lang.String getOfferDescription(
    ) {
        return this._offerDescription;
    }

    /**
     * Returns the value of field 'packageCode'.
     * 
     * @return the value of field 'PackageCode'.
     */
    public java.lang.String getPackageCode(
    ) {
        return this._packageCode;
    }

    /**
     * Returns the value of field 'packageDescription'.
     * 
     * @return the value of field 'PackageDescription'.
     */
    public java.lang.String getPackageDescription(
    ) {
        return this._packageDescription;
    }

    /**
     * Returns the value of field 'portfolioFlag'.
     * 
     * @return the value of field 'PortfolioFlag'.
     */
    public java.lang.String getPortfolioFlag(
    ) {
        return this._portfolioFlag;
    }

    /**
     * Returns the value of field 'responseCommitment'.
     * 
     * @return the value of field 'ResponseCommitment'.
     */
    public java.lang.String getResponseCommitment(
    ) {
        return this._responseCommitment;
    }

    /**
     * Returns the value of field 'startDate'.
     * 
     * @return the value of field 'StartDate'.
     */
    public org.exolab.castor.types.Date getStartDate(
    ) {
        return this._startDate;
    }

    /**
     * Returns the value of field 'status'.
     * 
     * @return the value of field 'Status'.
     */
    public com.hp.es.xml.batchEntitlement.types.StatusType getStatus(
    ) {
        return this._status;
    }

    /**
     * Returns the value of field 'warrantyTermCode'.
     * 
     * @return the value of field 'WarrantyTermCode'.
     */
    public java.lang.String getWarrantyTermCode(
    ) {
        return this._warrantyTermCode;
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
        if (_offerCode != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_offerCode)) {
           result = 37 * result + _offerCode.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_offerCode);
        }
        if (_offerDescription != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_offerDescription)) {
           result = 37 * result + _offerDescription.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_offerDescription);
        }
        if (_portfolioFlag != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_portfolioFlag)) {
           result = 37 * result + _portfolioFlag.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_portfolioFlag);
        }
        if (_obligationType != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_obligationType)) {
           result = 37 * result + _obligationType.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_obligationType);
        }
        if (_warrantyTermCode != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_warrantyTermCode)) {
           result = 37 * result + _warrantyTermCode.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_warrantyTermCode);
        }
        if (_packageCode != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_packageCode)) {
           result = 37 * result + _packageCode.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_packageCode);
        }
        if (_packageDescription != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_packageDescription)) {
           result = 37 * result + _packageDescription.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_packageDescription);
        }
        if (_startDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_startDate)) {
           result = 37 * result + _startDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_startDate);
        }
        if (_endDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_endDate)) {
           result = 37 * result + _endDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_endDate);
        }
        if (_status != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_status)) {
           result = 37 * result + _status.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_status);
        }
        if (_contractIDCarepackSN != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_contractIDCarepackSN)) {
           result = 37 * result + _contractIDCarepackSN.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_contractIDCarepackSN);
        }
        if (_COVWINDOW != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_COVWINDOW)) {
           result = 37 * result + _COVWINDOW.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_COVWINDOW);
        }
        if (_responseCommitment != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_responseCommitment)) {
           result = 37 * result + _responseCommitment.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_responseCommitment);
        }

        return result;
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
     * Sets the value of field 'COVWINDOW'.
     * 
     * @param COVWINDOW the value of field 'COVWINDOW'.
     */
    public void setCOVWINDOW(
            final java.lang.String COVWINDOW) {
        this._COVWINDOW = COVWINDOW;
    }

    /**
     * Sets the value of field 'contractIDCarepackSN'.
     * 
     * @param contractIDCarepackSN the value of field
     * 'contractIDCarepackSN'.
     */
    public void setContractIDCarepackSN(
            final java.lang.String contractIDCarepackSN) {
        this._contractIDCarepackSN = contractIDCarepackSN;
    }

    /**
     * Sets the value of field 'endDate'.
     * 
     * @param endDate the value of field 'endDate'.
     */
    public void setEndDate(
            final org.exolab.castor.types.Date endDate) {
        this._endDate = endDate;
    }

    /**
     * Sets the value of field 'obligationType'.
     * 
     * @param obligationType the value of field 'obligationType'.
     */
    public void setObligationType(
            final java.lang.String obligationType) {
        this._obligationType = obligationType;
    }

    /**
     * Sets the value of field 'offerCode'.
     * 
     * @param offerCode the value of field 'offerCode'.
     */
    public void setOfferCode(
            final java.lang.String offerCode) {
        this._offerCode = offerCode;
    }

    /**
     * Sets the value of field 'offerDescription'.
     * 
     * @param offerDescription the value of field 'offerDescription'
     */
    public void setOfferDescription(
            final java.lang.String offerDescription) {
        this._offerDescription = offerDescription;
    }

    /**
     * Sets the value of field 'packageCode'.
     * 
     * @param packageCode the value of field 'packageCode'.
     */
    public void setPackageCode(
            final java.lang.String packageCode) {
        this._packageCode = packageCode;
    }

    /**
     * Sets the value of field 'packageDescription'.
     * 
     * @param packageDescription the value of field
     * 'packageDescription'.
     */
    public void setPackageDescription(
            final java.lang.String packageDescription) {
        this._packageDescription = packageDescription;
    }

    /**
     * Sets the value of field 'portfolioFlag'.
     * 
     * @param portfolioFlag the value of field 'portfolioFlag'.
     */
    public void setPortfolioFlag(
            final java.lang.String portfolioFlag) {
        this._portfolioFlag = portfolioFlag;
    }

    /**
     * Sets the value of field 'responseCommitment'.
     * 
     * @param responseCommitment the value of field
     * 'responseCommitment'.
     */
    public void setResponseCommitment(
            final java.lang.String responseCommitment) {
        this._responseCommitment = responseCommitment;
    }

    /**
     * Sets the value of field 'startDate'.
     * 
     * @param startDate the value of field 'startDate'.
     */
    public void setStartDate(
            final org.exolab.castor.types.Date startDate) {
        this._startDate = startDate;
    }

    /**
     * Sets the value of field 'status'.
     * 
     * @param status the value of field 'status'.
     */
    public void setStatus(
            final com.hp.es.xml.batchEntitlement.types.StatusType status) {
        this._status = status;
    }

    /**
     * Sets the value of field 'warrantyTermCode'.
     * 
     * @param warrantyTermCode the value of field 'warrantyTermCode'
     */
    public void setWarrantyTermCode(
            final java.lang.String warrantyTermCode) {
        this._warrantyTermCode = warrantyTermCode;
    }

    /**
     * Method unmarshalOfferSummaryComplexType.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.hp.es.xml.batchEntitlement.OfferSummaryComplexType
     */
    public static com.hp.es.xml.batchEntitlement.OfferSummaryComplexType unmarshalOfferSummaryComplexType(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.hp.es.xml.batchEntitlement.OfferSummaryComplexType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.hp.es.xml.batchEntitlement.OfferSummaryComplexType.class, reader);
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
