/*
 * Created on Mar 8, 2006
 */
package com.hp.es.service.util;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import org.exolab.castor.types.Date;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.types.StatusType;

/**
 * @author juhank
 */
public class MappingUtils {

	/**
	 * mapBoolean
	 * @param flag
	 * @return
	 */
    public static String mapBoolean(boolean flag) {
        return mapOptionalBoolean(true, flag);
    }

    /**
     * mapOptionalBoolean
     * @param present
     * @param flag
     * @return
     */
    public static String mapOptionalBoolean(boolean present, boolean flag) {
        if (present && flag) {
            return "X";
        } else {
            return "";
        }
    }

	/**
	 * mapToBoolean()
	 * @param input
	 * @return
	 */
    public static boolean mapToBoolean(String input) {
    	// Please note: CQS returns a X for the boolean TRUE
    	//              SWOP returns a Y for the boolean TRUE
    	//              For interal mapping from string true or string false to the boolean 
    	if(input != null) {
    		if("X".equalsIgnoreCase(input) || "Y".equalsIgnoreCase(input) || "true".equalsIgnoreCase(input)){
        		return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }

    /**
     * mapToCastorDate()
     * @param inputDate
     * @return
     */
    public static org.exolab.castor.types.Date mapToCastorDate(java.util.Date inputDate) {
    	return DateHelper.mapJavaDate2Castor(inputDate);
    }

    /**
     * mapToCastorDate()
     * @param inputDate
     * @return
     */
    public static org.exolab.castor.types.Date mapToCastorDate(String inputDate) {
        if ((inputDate != null) && !("".equals(inputDate))&& !("0000-00-00".equals(inputDate))) {
            try {
				return new org.exolab.castor.types.Date(inputDate);
			} catch (ParseException e) {
                ESLog.info("Caught a throwable ParseException while parsing inputDate=" + inputDate + ". " + e.getMessage());
				return null;
			}
        } else {
            return null;
        }
    }

    /**
     * mapCastorDateToString()
     * @param inputDate
     * @return
     */
    public static String mapCastorDateToString(org.exolab.castor.types.Date inputDate) {
    	if(inputDate != null) {
    		return mapJavaDateToString(inputDate.toDate());
    	}else {
    		return null;
    	}
    }

    /**
     * mapJavaDateToString()
     * @param inputDate
     * @return
     */
    public static String mapJavaDateToString(java.util.Date inputDate) {
    	if(inputDate != null) {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	return sdf.format(inputDate);
    	}else {
    		return null;
    	}
    }

    /**
     * mapToJavaDate()
     * @param inputDate
     * @return
     * @throws ParseException 
     */
    public static java.util.Date mapStringToJavaDate(String inputDate) {
        if (inputDate != null) {
            	return DateHelper.mapIsoDate2JavaDate(inputDate);
        } else {
            return null;
        }
    }
    
    /**
     * mapToJavaDate()
     * @param inputDate
     * @return
     * @throws ParseException 
     */
    public static java.util.Date mapCastorToJavaDate(org.exolab.castor.types.Date inputDate) {
        if (inputDate != null) {
            return inputDate.toDate();
        } else {
            return null;
        }
    }
    /**
     * stringToInt()
     * @param input
     * @return
     * @throws MappingException
     */
    public static int stringToInt(String input) throws MappingException {
    	if((input != null)  && (input.trim().length() > 0)) {
	    	try {
	    		return Integer.parseInt(input);
	    	} catch(NumberFormatException nfe) {
	    		throw new MappingException(nfe.toString());
	    	}
    	}
    	return 0;
    }

    /**
     * floatStringToInt() - converts a string containing a floating-point value into an integer
     * @param input
     * @return
     * @throws MappingException
     */
    public static int floatStringToInt(String input) throws MappingException {
    	if((input != null) && (input.trim().length() > 0)) {
	    	try {
	    		return (int) Float.parseFloat(input.trim());
	    	} catch(NumberFormatException nfe) {
	    		throw new MappingException(nfe.toString());
	    	}
    	}
    	return 0;
    }

    /**
     * nullString()
     * @param input
     * @return
     */
    public static String nullString(String input) {
        if (input != null) {
            if ("".equals(input.trim())) {
                return null;
            } else {
                return input;
            }
        }
        return input;
    }
    
    /**
     * stripLeadingZeroes
     * @param input
     * @return
     */
    public static String stripLeadingZeroes(String input) {
        // nothing to do for nulls
        if (input == null) return null;

        // if only spaces then return trimmed string
        input = input.trim();
        if ("".equals(input)) return input;

        // main case - remove any leading zeroes
        int index = 0;
        while ((index < input.length()) && (input.charAt(index) == '0')) index++;
        input = input.substring(index);

        // if we only had zeroes we should keep the last one
        if ("".equals(input)) input = "0";

        return input;
    }

    /**
     * stripLeadingZeroes
     * @param input
     * @return
     */
    public static String stripLeadingDigitsAndBlanks(String input) {
        // nothing to do for nulls
        if (input == null) return null;

        // if only spaces then return trimmed string
        input = input.trim();
        if ("".equals(input)) return input;

        // main case - remove any leading zeroes
        int index = 0;
        while ((index < input.length()) && ((input.charAt(index) == '0') || (input.charAt(index) == '1') || (input.charAt(index) == '2') || (input.charAt(index) == '3') || (input.charAt(index) == '4') || (input.charAt(index) == '5') || (input.charAt(index) == '6') || (input.charAt(index) == '6') || (input.charAt(index) == '7') || (input.charAt(index) == '8') || (input.charAt(index) == '9') || (input.charAt(index) == ' '))) index++;
        input = input.substring(index);


        return input;
    }
    private static String[] tests = {null,"","   ","0", "000", " 000 ", "0001", "  0002", " 000 03"};
    private static String[] tests2 = {null,"","   aBc","012 43 cvd", "", " 333a ", "20070620 012026 Special instructions field truncated (More than allowed 32k characters)", "  0002", " 000 03"};

    public static void main (String [] args) {

//        for (int i=0; i<tests.length; i++) {
//            System.out.println("<"+ tests[i] + ">   ====>   <" + stripLeadingZeroes(tests[i]) + ">");
//        }

        for (int i=0; i<tests2.length; i++) {
            System.out.println("<"+ tests2[i] + ">   ====>   <" + stripLeadingDigitsAndBlanks(tests2[i]) + ">");
        }
    }
    
    /**
     * getStatus
     * @param startDate
     * @param endDate
     * @param checkDate
     * @return
     */
    public static StatusType getStatus(Date startDate, Date endDate, Date checkDate) {
    	if(endDate == null || startDate == null || checkDate == null) {
    		ESLog.debug("One of the date is null endate: " + endDate + ", startdate: " + startDate + 
    				", checkDate: " + checkDate);
    		if(endDate == null && startDate == null ) {
        		ESLog.debug("StartDate and EndDate is null => No offer available"); 
    			return null;
    		}
    	}
    	// expired
    	if(checkDate.compareTo(endDate) == Date.GREATER_THAN) {
    		return StatusType.X;
    	}
    	// future
    	if(checkDate.compareTo(startDate) == Date.LESS_THAN) {
    		return StatusType.F;
    	}
    	
    	// all other cases should be active
    	return StatusType.A;
    }
    
    /**
     * Mapping a BigInteger value into a String
     * @param value
     * @return
     */
    public static String mapBigIntegerToString(BigInteger value) {
    	if(value == null) {
    		return null;
    	} else {
    		return value.toString();
    	}
    }
    
    /**
     * Mapping a BigInteger value into a int value. If the BigInteger 
     * value is null then a 0 is returned
     * @param value
     * @return
     */
    public static int mapBigIntegerToInt(BigInteger value) {
    	if(value == null) {
    		return 0;
    	} else {
    		return value.intValue();
    	}
    }
    
    /**
     * Mapping an int value to a BigInteger
     * @param value
     * @return
     */	
    public static BigInteger mapIntToBigInteger(int value) {
    	return new BigInteger("" + value);
    }

	public static String mapCastorToXMLDate(Date inputDate) {
		if(inputDate !=null) {
			
			
			return inputDate.toString();
		}
    	return null;

	}

	public static Collection castorEnumerationToCollection(Enumeration enumeration) {
		ArrayList list = null;
		if (enumeration != null) {
			list = new ArrayList();
			while(enumeration.hasMoreElements()) {
				list.add(enumeration.nextElement());
			}
		}
		
		
		return list;
	}

	/*
	 * If the string is having a hash that removing everything after
	 * @param the string
	 * @return a new string
	 */
    public static String removeContentAfterHash(String productNr){
        if(productNr == null){
            return null;
        }
        final int idx = productNr.indexOf('#');
        if(idx < 0){
            return productNr;
        } else if(idx == 0){
            return null;
        } else{
            return productNr.substring(0,idx);
        }
    }

}
