package com.hp.es.test.hpsetest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* This class is the Service Test Utilities
* It handles the report and the error file
*/
public class ServiceTesterUtil {


    //An instance variable
	private String _nameOfTestSuite = null;
    private static ServiceTesterUtil _instance = null;
    private String _errorFileName = "";
    private String _reportFileName = "";
    private String _performanceFileName = "";




    private ServiceTesterUtil(String nameOfTestSuite) {
    	_nameOfTestSuite = nameOfTestSuite;
    }


    /*
    * Dump the actual message and the expected into a file
    * @param actual message
    * @param expected message
    * @return void
    */
    public static void dump(String actual ,String expected,String testName) {
        StringBuffer toWrite = new StringBuffer("\n************************************************************************************************\n");
        toWrite.append("Test Case "+testName +"\n");
        toWrite.append("Expected result \n "+expected +"\n");
        toWrite.append("************************************************************************************************\n");
        toWrite.append("actual result \n  "+actual+"\n");
        toWrite.append("************************************************************************************************\n");

        _instance.dumpInFile(toWrite.toString());
    }


    /*
    * Dump an error
    * @param a Throwable object
    * @return void
    */
    public static void dump(Throwable e) {
        StringWriter sr = new StringWriter();
        PrintWriter pw = new PrintWriter(sr);

        e.printStackTrace(pw);
        String toWrite = "Exception :\n"+sr.toString();
        pw.close();

        _instance.dumpInFile(toWrite);
    }


    /*
    * Dump a String
    * @param a String
    * @return void
    */
    public static void dump(String toDump) {
    	if(null == _instance){
    		initReportFileAndDumpFile(getNameOfTestSuite());
    	}
        _instance.dumpInFile(toDump);
    }



    /*
    * Write the report into a file
    * @param a String (the report)
    * @return void
    */
    public static void writeReportToAFile(String strReport) {
        try {

            FileWriter fw = new FileWriter(_instance._reportFileName,false);
            fw.write(strReport,0,strReport.length());
            fw.close();

            if(Boolean.valueOf(TestConfigHolder.getInstance().getConfigParameter("hpse.test.gatherperformancedata", "true")).booleanValue()) {
                fw = new FileWriter(_instance._performanceFileName,false);
                fw.write(ReportBuilder.getInstance().getPerfData(),0,ReportBuilder.getInstance().getPerfData().length());
                fw.close();
            }
        }catch(Exception ex) {
            System.out.println("We got an issue while trying to dump to file");
            ex.printStackTrace();
        }
    }


    
    /*
     * Write the report into a file
     * @param a String (the report)
     * @return void
     */
     public static void appendReportToAFile(String strReport) {
         try {

             FileWriter fw = new FileWriter(_instance._reportFileName,true);
             fw.write(strReport,0,strReport.length());
             fw.close();

             if(Boolean.valueOf(TestConfigHolder.getInstance().getConfigParameter("hpse.test.gatherperformancedata", "true")).booleanValue()) {
                 fw = new FileWriter(_instance._performanceFileName,true);
                 fw.write(ReportBuilder.getInstance().getPerfData(),0,ReportBuilder.getInstance().getPerfData().length());
                 fw.close();
             }
         }catch(Exception ex) {
             System.out.println("We got an issue while trying to dump to file");
             ex.printStackTrace();
         }
     }
    
    /*
    * Init the report file
    * @param a String (the name of the test Suite)
    * @return void
    */
    public static void initReportFileAndDumpFile(String nameOfTestSuite) {
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date d = new Date();
        String repSeparator = System.getProperties().getProperty("file.separator");
        
        _instance = new ServiceTesterUtil(nameOfTestSuite);

        try {
            _instance._errorFileName=TestConfigHolder.getInstance().getConfigParameter("hpse.test.reportdir")+repSeparator+"error_detail_" + nameOfTestSuite +"_"+ df.format(d) +".txt";
            _instance._reportFileName=TestConfigHolder.getInstance().getConfigParameter("hpse.test.reportdir")+repSeparator + "report_" + nameOfTestSuite +"_"+ df.format(d) +".txt";
            _instance._performanceFileName=TestConfigHolder.getInstance().getConfigParameter("hpse.test.reportdir")+repSeparator + "perf_" + nameOfTestSuite +"_"+ df.format(d) +".csv";

            FileOutputStream fos = new FileOutputStream(_instance._errorFileName, false);
            OutputStreamWriter errorFileWriter = new OutputStreamWriter( fos, "UTF-8");
            errorFileWriter.close();
        }catch(Exception e) {
        	System.out.println("We got an issue while trying to dump to file");
            e.printStackTrace();
        }
    }


    /*
    * Dump a String into a file
    * @param a String (the String to Dump)
    * @return void
    */
    private synchronized void  dumpInFile(String toDump) {
        try {
            FileOutputStream fos = new FileOutputStream(_instance._errorFileName, true);
            OutputStreamWriter errorFileWriter = new OutputStreamWriter( fos, "UTF-8");
            errorFileWriter.write(toDump,0,toDump.length());
            errorFileWriter.flush();
            errorFileWriter.close();
        }catch(Exception e) {
        	System.out.println("We got an issue while trying to dump to file");
            e.printStackTrace();
        }
    }


	public static String getNameOfTestSuite() {
		if(_instance != null) {
			return _instance._nameOfTestSuite;
		}else {
			return "";
		}
	}

}
//eof