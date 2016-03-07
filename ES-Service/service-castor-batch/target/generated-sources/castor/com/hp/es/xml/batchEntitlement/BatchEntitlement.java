/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement;

/**
 * Class BatchEntitlement.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BatchEntitlement implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _entitlementItemList.
     */
    private java.util.List<com.hp.es.xml.batchEntitlement.EntitlementItem> _entitlementItemList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BatchEntitlement() {
        super();
        this._entitlementItemList = new java.util.ArrayList<com.hp.es.xml.batchEntitlement.EntitlementItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vEntitlementItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEntitlementItem(
            final com.hp.es.xml.batchEntitlement.EntitlementItem vEntitlementItem)
    throws java.lang.IndexOutOfBoundsException {
        this._entitlementItemList.add(vEntitlementItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vEntitlementItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEntitlementItem(
            final int index,
            final com.hp.es.xml.batchEntitlement.EntitlementItem vEntitlementItem)
    throws java.lang.IndexOutOfBoundsException {
        this._entitlementItemList.add(index, vEntitlementItem);
    }

    /**
     * Method enumerateEntitlementItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.hp.es.xml.batchEntitlement.EntitlementItem> enumerateEntitlementItem(
    ) {
        return java.util.Collections.enumeration(this._entitlementItemList);
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

        if (obj instanceof BatchEntitlement) {

            BatchEntitlement temp = (BatchEntitlement)obj;
            boolean thcycle;
            boolean tmcycle;
            if (this._entitlementItemList != null) {
                if (temp._entitlementItemList == null) return false;
                if (this._entitlementItemList != temp._entitlementItemList) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._entitlementItemList);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._entitlementItemList);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementItemList); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementItemList); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._entitlementItemList.equals(temp._entitlementItemList)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementItemList);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementItemList);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementItemList);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementItemList);
                    }
                }
            } else if (temp._entitlementItemList != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Method getEntitlementItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.hp.es.xml.batchEntitlement.EntitlementItem at the given
     * index
     */
    public com.hp.es.xml.batchEntitlement.EntitlementItem getEntitlementItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._entitlementItemList.size()) {
            throw new IndexOutOfBoundsException("getEntitlementItem: Index value '" + index + "' not in range [0.." + (this._entitlementItemList.size() - 1) + "]");
        }

        return (com.hp.es.xml.batchEntitlement.EntitlementItem) _entitlementItemList.get(index);
    }

    /**
     * Method getEntitlementItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.hp.es.xml.batchEntitlement.EntitlementItem[] getEntitlementItem(
    ) {
        com.hp.es.xml.batchEntitlement.EntitlementItem[] array = new com.hp.es.xml.batchEntitlement.EntitlementItem[0];
        return (com.hp.es.xml.batchEntitlement.EntitlementItem[]) this._entitlementItemList.toArray(array);
    }

    /**
     * Method getEntitlementItemCount.
     * 
     * @return the size of this collection
     */
    public int getEntitlementItemCount(
    ) {
        return this._entitlementItemList.size();
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
        if (_entitlementItemList != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_entitlementItemList)) {
           result = 37 * result + _entitlementItemList.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_entitlementItemList);
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
     * Method iterateEntitlementItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.hp.es.xml.batchEntitlement.EntitlementItem> iterateEntitlementItem(
    ) {
        return this._entitlementItemList.iterator();
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
    public void removeAllEntitlementItem(
    ) {
        this._entitlementItemList.clear();
    }

    /**
     * Method removeEntitlementItem.
     * 
     * @param vEntitlementItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeEntitlementItem(
            final com.hp.es.xml.batchEntitlement.EntitlementItem vEntitlementItem) {
        boolean removed = _entitlementItemList.remove(vEntitlementItem);
        return removed;
    }

    /**
     * Method removeEntitlementItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.hp.es.xml.batchEntitlement.EntitlementItem removeEntitlementItemAt(
            final int index) {
        java.lang.Object obj = this._entitlementItemList.remove(index);
        return (com.hp.es.xml.batchEntitlement.EntitlementItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vEntitlementItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEntitlementItem(
            final int index,
            final com.hp.es.xml.batchEntitlement.EntitlementItem vEntitlementItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._entitlementItemList.size()) {
            throw new IndexOutOfBoundsException("setEntitlementItem: Index value '" + index + "' not in range [0.." + (this._entitlementItemList.size() - 1) + "]");
        }

        this._entitlementItemList.set(index, vEntitlementItem);
    }

    /**
     * 
     * 
     * @param vEntitlementItemArray
     */
    public void setEntitlementItem(
            final com.hp.es.xml.batchEntitlement.EntitlementItem[] vEntitlementItemArray) {
        //-- copy array
        _entitlementItemList.clear();

        for (int i = 0; i < vEntitlementItemArray.length; i++) {
                this._entitlementItemList.add(vEntitlementItemArray[i]);
        }
    }

    /**
     * Method unmarshalBatchEntitlement.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.hp.es.xml.batchEntitlement.BatchEntitlement
     */
    public static com.hp.es.xml.batchEntitlement.BatchEntitlement unmarshalBatchEntitlement(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.hp.es.xml.batchEntitlement.BatchEntitlement) org.exolab.castor.xml.Unmarshaller.unmarshal(com.hp.es.xml.batchEntitlement.BatchEntitlement.class, reader);
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
