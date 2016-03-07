package com.hp.es.test.hpsetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.apache.oro.text.perl.Perl5Util;

/*
* This class is the XML File utilities
* It defines methods for manipulating XML files
 *
 * @author Antoine Voiry
 *
 * $Log: XMLFileUtil.java,v $
 * Revision 1.33  2004-05-08 04:41:13+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.32  2004-05-05 15:39:54+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.31  2004-01-29 18:05:32+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.30  2003-08-04 16:50:03+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.29  2003-07-01 11:02:08+02  THKOE
 * Author: THKOE@dhcp-15-197-230-195.bbn.hp.com ()
 * altered the resetXXX()-methods to set the day of time to 12 (see WITS issue 541)
 *
 * Revision 1.28  2003-05-20 16:18:41+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * added DATE_DIFF +/- days
 *
 * Revision 1.27  2003-05-12 01:58:24+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.26  2003-03-24 17:49:26+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * introduced "$TOMORROWPLUSONE$" for the day after
 * tomorrow
 *
 * Revision 1.25  2003-03-19 19:31:52+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * No support ignore lists, "default.ignore" or "testcase.ignore".
 * These lists carry regular expressions to ignore certain elements in the
 * XML path.
 *
 * Revision 1.24  2003-02-26 15:32:52+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.23  2003-01-22 15:27:06+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.22  2002-10-31 14:55:49+01  lbednari
 * Author: lbednari@dhcp-15-198-5-221.bbn.hp.com ()
 * - added sorting of file list
 *
 * Revision 1.21  2002-10-31 14:26:31+01  lbednari
 * Author: lbednari@dhcp-15-198-5-221.bbn.hp.com ()
 * - removed not needed Vector
 *
 * Revision 1.20  2002-10-11 17:11:50+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * commenting out the dump of the XML response;

 * it makes the regression report >500Kb;

 * should be used just for debug
 *
 * Revision 1.19  2002-08-23 15:24:23+02  bzimmerm
 * Author: bzimmerm@dhcp-15-198-4-138.bbn.hp.com ()
 * Added UTF-8 support for reading from and writing to files within Testware
 *
 * Revision 1.18  2002-07-03 13:50:59+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.17  2002-06-14 17:50:14+02  JUHANK
 * Author: JUHANK@dhcp-15-198-6-106.bbn.hp.com ()
 * added $TOMORROW$ and $YESTERDAY$ tag which will be
 * replaced in the method replaceTags()
 *
 * Revision 1.16  2002-05-22 08:50:12+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.15  2002-05-13 14:26:43+02  ANVOI
 * Author: ANVOI@dhcp-15-130-70-149.france.hp.com ()
 * Change filter
 *
 * Revision 1.14  2002-04-30 11:15:43+02  ANVOI
 * Author: ANVOI@dhcp-15-130-67-50.france.hp.com ()
 * no comment
 *
 * Revision 1.13  2002-04-11 17:23:14+02  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * no comment
 *
 * Revision 1.12  2002-04-05 00:46:29+02  ANVOI
 * Author: ANVOI@gvanaid365.gva.hp.com ()
 * REmove utf8 encoding when readin file
 *
 * Revision 1.11  2002-03-29 09:59:14+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change :

 *    - utf8 reading from file system

 *    - added javadoc

 *    - reformat file
 *
 * Revision 1.10  2002-03-27 11:33:27+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Adde some javadoc comments

 * Changed the name of the normalize date method
 *
*
*/
public class XMLFileUtil {

    /** The size of blocking to use */
    protected static final int BLKSIZ = 8192;
    /*
    * Default Constructor (disable)
    * This class is a utilitie class it is never instantiated
    */
    private XMLFileUtil() {
    }


    /*
    * Read a file (static method)
    * @param folder name (without the last rep separator)
    * @param file name
    * @return the file content as a string
    */
    public static String readFile(String folder, String fileName) {
        String repSeparator = System.getProperties().getProperty("file.separator");
        String encoding = TestConfigHolder.getInstance().getConfigParameter("hpse.test.encoding", "UTF-8");
        File   file    = new File(folder +  repSeparator + fileName);
        String ret     = null;
      //  char[] content = null;

        try {
            //Open the file
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader fileReader = new InputStreamReader( fis, encoding);
            ret = readerToString(fileReader);

//System.out.println(ret);
        }catch(Exception e) {
            return "Error "+e.toString() +" when reading file " + folder +  repSeparator + fileName;
        }

        return replaceTags(ret);
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
    * Load the list of xml request file
    * @return a sorted list of xml file names (request)
    */
    public static String[] loadListOfRequestFile() {
        String repSeparator = System.getProperties().getProperty("file.separator");

        File f = new File(TestConfigHolder.getInstance().getConfigParameter("hpse.test.requestdir")+ repSeparator);
        String   list[] = f.list(new XMLFileFilter());

        java.util.Arrays.sort(list);
        return list;

    }

    /**
     * ignoreList a list of Jakarta ORO regular expressions to ignore certain tree parts, i.e. \"/EsReply/EsHeader/TransactionID\" or \"/EsReply/EsHeader/InputRequest.*\"
     */
    public static String [] loadIgnoreList(String fileName) {
        String repSeparator = System.getProperties().getProperty("file.separator");
        LinkedList<String> result = new LinkedList<String>();
        File f = new File(TestConfigHolder.getInstance().getConfigParameter("hpse.test.requestdir") + repSeparator + fileName);
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String read;
            while ( (read = r.readLine()) != null) {
                result.add(read);
            }
        } catch (Exception ex) {
            // maybe we print the exception here, so somebody might notice in the log
            //ex.printStackTrace();
        }
        return result.toArray(new String[] {});
    }

}


/*
One inner class
*/
class XMLFileFilter implements java.io.FilenameFilter {

    public XMLFileFilter() {
    }

    public boolean accept(File dir, String name) {
        if(name != null) {
            if(name.endsWith(".xml")) {
                return true;
            }
        }
        return false;
    }

}



//eof