package com.hp.es.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.oro.text.perl.Perl5Util;
import org.exolab.castor.xml.Unmarshaller;

import com.hp.es.xml.util.CastorUtil;

/*
 * This program requires a special castor.properties


org.exolab.castor.parser=org.apache.xerces.parsers.SAXParser
org.exolab.castor.serializer=org.apache.xml.serialize.XMLSerializer
org.exolab.castor.regexp=org.exolab.castor.util.JakartaOroEvaluator
org.exolab.castor.indent=false
org.exolab.castor.parser.validation=true
org.exolab.castor.parser.namespaces=false
org.exolab.castor.marshalling.validation=true
org.exolab.castor.debug=false
org.exolab.castor.mapping.collections=\
  org.exolab.castor.mapping.loader.J1CollectionHandlers,\
  org.exolab.castor.mapping.loader.J2CollectionHandlers

 */
public class CastorValidation {
    /** The size of blocking to use */
    protected static final int BLKSIZ = 8192;
    
	public CastorValidation() {
		super();
	}
	
	public static void main (String[] argc) {
		//request();
		reply();
		
	}
	
	static void request() {
        File f = new File("C:\\work\\entitlement_project\\entitlement_svn\\branches\\service\\9_0_0_C3_main\\test\\functional\\request");
        String   list[] = f.list(new XMLFileFilter());

        java.util.Arrays.sort(list);
        
        for (int i=0; i<list.length; i++) {
        	String fileName = list[i];
        	
            try {
                //Open the file
                FileInputStream fis = new FileInputStream("C:\\work\\entitlement_project\\entitlement_svn\\branches\\service\\9_0_0_C3_main\\test\\functional\\request\\"+fileName);
                InputStreamReader fileReader = new InputStreamReader( fis, "UTF-8");
                String retXml = readerToString( fileReader);
                retXml = replaceTags(retXml);

                
                Unmarshaller uma = CastorUtil.getUnmarshallerUsingEIAMessageMappingFile();
                
                StringReader reader = new StringReader(retXml);
                uma.unmarshal(reader);
                
                //we null it for now
                //reply = null;
                /* we know are going to marshall it
                StringWriter writer = new StringWriter();
                Marshaller ma = CastorUtil.getMarshaller(writer);

                ma.marshal(reply);
                
                String output = writer.toString();
                */
                //System.out.println(fileName + "/ OK");
            }catch(Exception e) {
            	System.out.println("request "+fileName + "/ Problem \n Class"+e.getClass()+"Message "+e.getMessage());
                
            }        	
        }
		
	}
	
	static void reply() {
        File f = new File("C:\\work\\entitlement_project\\entitlement_svn\\branches\\service\\9_0_0_C3_main\\test\\functional\\reply");
        String   list[] = f.list(new XMLFileFilter());

        java.util.Arrays.sort(list);
        
        for (int i=0; i<list.length; i++) {
        	String fileName = list[i];
        	
            try {
                //Open the file
                FileInputStream fis = new FileInputStream("C:\\work\\entitlement_project\\entitlement_svn\\branches\\service\\9_0_0_C3_main\\test\\functional\\reply\\"+fileName);
                InputStreamReader fileReader = new InputStreamReader( fis, "UTF-8");
                String retXml = readerToString( fileReader);
                retXml = replaceTags(retXml);

                
                Unmarshaller uma = CastorUtil.getUnmarshallerUsingEIAMessageMappingFile();
                
                StringReader reader = new StringReader(retXml);
                //EIAMessage reply = (EIAMessage) 
                uma.unmarshal(reader);
                
                //we null it for now
               // reply = null;
                /* we know are going to marshall it
                StringWriter writer = new StringWriter();
                Marshaller ma = CastorUtil.getMarshaller(writer);

                ma.marshal(reply);
                
                String output = writer.toString();
                */
                //System.out.println(fileName + "/ OK");
            }catch(Exception e) {
            	System.out.println("reply "+fileName + "/ Problem \n"+e.getMessage());
                
            }        	
        }
		
	}
	
    /**
     * Read the entire content of a Reader into a String
     *
     * @param a Reader object
     * @return String containing the content of the Reader
     * @throws IOException
     */
    public static String readerToString(Reader is) throws IOException{
       StringBuffer sb = new StringBuffer();
       char [] b = new char[BLKSIZ];
       int n;
       //Read a block. If it gets any chars, append them.
       while((n = is.read(b)) > 0 ) {
        sb.append(b, 0, n);
        }
        //Only construct the String object once, here.
        return sb.toString();
    }	
    
    /*
     * Replace some tags in an input string
     * @param input string
     * @return the date
     */
     private static String replaceTags(String input) {

         Perl5Util perl = new Perl5Util();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

         Date currentDate = resetDateTime(new Date());
         Date yesterdayDate = resetYesterdayDateTime(new Date());
         Date tomorrowDate = resetTomorrowDateTime(new Date());
         Date tomorrowPlusOneDate = resetTomorrowPlusOneDateTime(new Date());

         String currentDateString  = formatter.format(currentDate);
         String yesterdayDateString  = formatter.format(yesterdayDate);
         String tomorrowDateString  = formatter.format(tomorrowDate);
         String tomorrowPlusOneDateString  = formatter.format(tomorrowPlusOneDate);

         String temp = perl.substitute("s/\\$TODAY\\$/" + currentDateString + "/g", input);
         temp = perl.substitute("s/\\$YESTERDAY\\$/" + yesterdayDateString + "/g", temp);
         temp = perl.substitute("s/\\$TOMORROW\\$/" + tomorrowDateString + "/g", temp);
         temp = perl.substitute("s/\\$TOMORROWPLUSONE\\$/" + tomorrowPlusOneDateString + "/g", temp);

         long currentDateLong = currentDate.getTime();

         while (perl.match("m/\\$DATE_DIFF\\(([0-9\\-]*)\\)\\$/",temp)) {
             String endDateDiffString = perl.group(1); //gets first parenthesized subgroup
             String replacementString = "";
             try {
                 int daysOffset = Integer.parseInt(endDateDiffString);
                 currentDateLong = currentDateLong + ( (long)(daysOffset) * 24 * 60 * 60 * 1000);
                 replacementString = formatter.format(new java.util.Date(currentDateLong));
             }
             catch (Exception e) {
                 replacementString = "\\$TESTWARE_ERROR:" + e.toString() + "\\$";
             }
             temp = perl.substitute("s/\\$DATE_DIFF\\(" + endDateDiffString + "\\)\\$/" + replacementString + "/g", temp);
         }

         return temp;

     }    
     
     /*
      * Set the hours, minutes, seconds and milliseconds of a Date to 0
      * @param Date d
      * @return the date
      */
      private static Date resetDateTime(Date d) {
          if ( d != null ) {
              Calendar aux = Calendar.getInstance();
              aux.setTime(d);
              // Set time to 12:00 (see Wits issue 541). Setting it to 00:00 causes trouble when
              // calculating a date diff from this date that passes the date for setting/unsetting
              // daylight savings time.
              aux.set(Calendar.HOUR_OF_DAY,12);
              aux.set(Calendar.MINUTE,0);
              aux.set(Calendar.SECOND,0);
              aux.set(Calendar.MILLISECOND,0);
              return aux.getTime();
          } else {
              return d;
          }
      }

      /**
      * Set the hours, minutes, seconds and milliseconds of a Date to 0 and
      * subtracts 1 day to have yesterdays date
      * @param Date d
      * @return the date
      */
      private static Date resetYesterdayDateTime(Date d) {
          if ( d != null ) {
              Calendar aux = Calendar.getInstance();
              aux.setTime(d);
              aux.set(Calendar.HOUR_OF_DAY,12);
              aux.set(Calendar.MINUTE,0);
              aux.set(Calendar.SECOND,0);
              aux.set(Calendar.MILLISECOND,0);
              aux.add(Calendar.DAY_OF_YEAR, -1);
              return aux.getTime();
          } else {
              return d;
          }
      }

      /*
      * Set the hours, minutes, seconds and milliseconds of a Date to 0 and
      * adds 1 day to have tomorrows date
      * @param Date d
      * @return the date
      */
      private static Date resetTomorrowDateTime(Date d) {
          if ( d != null ) {
              Calendar aux = Calendar.getInstance();
              aux.setTime(d);
              aux.set(Calendar.HOUR_OF_DAY,12);
              aux.set(Calendar.MINUTE,0);
              aux.set(Calendar.SECOND,0);
              aux.set(Calendar.MILLISECOND,0);
              aux.add(Calendar.DAY_OF_YEAR, 1);
              return aux.getTime();
          } else {
              return d;
          }
      }

      /*
      * Set the hours, minutes, seconds and milliseconds of a Date to 0 and
      * adds 1 day to have tomorrows date
      * @param Date d
      * @return the date
      */
      private static Date resetTomorrowPlusOneDateTime(Date d) {
          if ( d != null ) {
              Calendar aux = Calendar.getInstance();
              aux.setTime(d);
              aux.set(Calendar.HOUR_OF_DAY,12);
              aux.set(Calendar.MINUTE,0);
              aux.set(Calendar.SECOND,0);
              aux.set(Calendar.MILLISECOND,0);
              aux.add(Calendar.DAY_OF_YEAR, 2);
              return aux.getTime();
          } else {
              return d;
          }
      }     

}

class XMLFileFilter implements java.io.FilenameFilter {

    public XMLFileFilter() {
    }

    public boolean accept(File dir, String name) {
        if(name != null) {
            if(name.endsWith("getContract*.xml")) {
                return true;
            }
        }
        return false;
    }
}