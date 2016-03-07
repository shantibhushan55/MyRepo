/*
 * MapperException.java
 * Created on 3 déc. 2004
 *
 * Entitlement Service Project
 * This is a standard Inherited exception
 */
package com.hp.es.service.batchEntitlement;

/**
 * @author anvoi
 *

 */
class MapperException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3133868291904421070L;

	/**
     * Default Constructor
     */
    public MapperException() {
        super();
    }

    /**
     * @param s
     */
    public MapperException(String s) {
        super(s);
    }

}
