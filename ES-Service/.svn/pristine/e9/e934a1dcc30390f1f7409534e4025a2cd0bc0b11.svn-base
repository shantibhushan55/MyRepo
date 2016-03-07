/*
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/IndentText.java 1.8 2004-05-08 04:42:15+02 entitlem Exp $
 *
 * Copyright (c) 2000 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 */
package com.hp.es.service.util;

/**
 * This class provides convenience methods for text manipulations.
 *
 * @author Anders Persson
 * @since ES 3.0
 */
public class
IndentText
{
   private static final String INDENT_LENGTH = "   ";

   /**
    * Default constructor.
    */
   public
   IndentText()
   {
   }

//-----------------------------------------------------------------------------

   /**
    * Gets a String containing spaces matching the number of indent steps
    * times the number of spaces for each step. The number of spaces for
    * each step is defined by the constant IndentText.INDENT_LENGTH.
    *
    * @return a String containing spaces
    */
   public static String
   getIndentString(int inSteps)
   {
      StringBuffer buffer = new StringBuffer();
      for (int i = 0; i < inSteps; i++)
      {
         buffer.append(INDENT_LENGTH);
      }
      return buffer.toString();
   }
}
