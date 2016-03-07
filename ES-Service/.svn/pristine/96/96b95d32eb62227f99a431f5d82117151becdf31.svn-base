package com.hp.es.test.hpsetest;
import java.util.ArrayList;
import java.util.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.test.hpsetest.proxy.ServiceTesterProxy;

/*
* This class is the Service Test Utilities
* 
*/
public class ReportBuilder {
    private static volatile ReportBuilder _instance  = null;
    
    private String               _header    = null;
    private ArrayList<ReportElement>           _listOfTest = null;
    private StringBuffer        _error      = null;
    private StringBuffer        _failure    = null;    
    private String              _testTitle  = null;
    private StringBuffer        _perfData   = null;
    
    
    
    
    /*
    * Constructor
    */
    public ReportBuilder() {
        buildHeader();
        _listOfTest = new ArrayList<ReportElement>();
        _error      = new StringBuffer();
        _failure    = new StringBuffer();    
        _testTitle  = new String("");
        _perfData   = new StringBuffer();
    }
    
    
    public String getPerfData() {
        return _perfData.toString();    
    }
    
    
    /*
    * build header
    */    
    private void buildHeader() {
        StringBuffer sbTmp = new StringBuffer();
        
        String proxyUsed = "<unkown>";
        String serverUsed = "<unknown>";
        
        try {
            proxyUsed = ServiceTesterProxy.getServiceTesterProxy().getName()+EsConstants.ENDOFLINE;
        } catch (Throwable ex) {}
        
        try {
            serverUsed = ServiceTesterProxy.getServiceTesterProxy().getServerAddress() +EsConstants.ENDOFLINE;
        } catch (Throwable ex) {}
        
        sbTmp.append("--------------------------------------------------------------"+EsConstants.ENDOFLINE);
        sbTmp.append("Test Beginning at "+new Date() +EsConstants.ENDOFLINE);
        sbTmp.append("Test Use Proxy :"+ proxyUsed);
        sbTmp.append("Proxy use Server :"+ serverUsed);
        sbTmp.append("--------------------------------------------------------------"+EsConstants.ENDOFLINE);
        
        _header = sbTmp.toString();
    }
    
    
    /*
    * get The report header
    * @return the header
    */        
    public String getReportHeader() {
        return _header;
    }
    
    /*
    * Add a test in the list
    * @param the test name
    * @param the time taken for this test (in ms)
    */            
    public void addTest(String testName, long timeTaken) {
        ReportElement re = null;
        re = findReportElement(testName);
        re.addTestResult(timeTaken);
    }
    
    
    public void addPerformance(String testName, long timeTaken, boolean isSuccess) {
        if(Boolean.valueOf(TestConfigHolder.getInstance().getConfigParameter("hpse.test.gatherperformancedata", "true")).booleanValue()) {
            if(isSuccess) {
                
                _perfData.append(testName+";"+timeTaken+";"+"Yes"+"\n");
            }else {
                if(timeTaken >0)  {
                    _perfData.append(testName+";"+timeTaken+";"+"No"+"\n");
                }else {
                    _perfData.append(testName+";"+timeTaken+";"+"-1"+"\n");
                }
            }
        }
    }
    
    /*
    * Add a test in the list
    * @param the error or error list
    */            
    public void addError(String error) {
        _error.append(error);
        
    }
    
    
    /*
    * Add a test in the list
    * @param the error or error list
    */            
    public void addFailure(String failure) {
        _failure.append(failure);
    }    
    
    
    
    /*
    * Add a test in the list
    * @return the report as it would be shown
    */            
    public String getReport() {
        StringBuffer report = new StringBuffer();
        String strList = "";
        report.append(_header +EsConstants.ENDOFLINE);
        report.append(_testTitle +EsConstants.ENDOFLINE);
        report.append("List of Test ran is :" +EsConstants.ENDOFLINE);
        
        report.append(buildReportElementList());
        
        
        report.append(strList +EsConstants.ENDOFLINE);
        if(_error.length() == 0) {
            report.append("No Error seen" +EsConstants.ENDOFLINE);
        }else {
            report.append("List of Error Found is :" +EsConstants.ENDOFLINE);
            report.append(_error.toString() +EsConstants.ENDOFLINE);
        }

        if(_failure.length() == 0) {
            report.append("No Failure seen" +EsConstants.ENDOFLINE);
        }else {
            report.append("List of Failure Found is :" +EsConstants.ENDOFLINE);
            report.append(_failure.toString() +EsConstants.ENDOFLINE);
            
        }
        
        if ((_failure.length() == 0) && (_error.length() == 0)) {
            report.append("Test suite was successfull" +EsConstants.ENDOFLINE);
        }
        
        
        return report.toString();
    }        
       
        
    public static ReportBuilder getInstance() {
        if (_instance == null) {
            synchronized(ReportBuilder.class) {
                    _instance = new ReportBuilder();
            }
        }
        return _instance;        
        
    }
    
    
    private synchronized ReportElement findReportElement(String testName) {
        ReportElement re = null;
        if(_listOfTest.isEmpty()) {
            re = new ReportElement(testName);
            _listOfTest.add(re);
            return re;
        }else {
            for(int i =0;i< _listOfTest.size();i++) {
                if((_listOfTest.get(i)).getName().trim().equals(testName.trim())) {
                    re = _listOfTest.get(i);
                    return re;
                }
            }
            re = new ReportElement(testName);
            _listOfTest.add(re);
            return re;             
        }
    }
    
    private String buildReportElementList() {
        String res = "";
        for(int i =0;i< _listOfTest.size();i++) {
                res+=EsConstants.TAB+EsConstants.TAB +_listOfTest.get(i).toString() +EsConstants.ENDOFLINE;
        }
        return res;
    }

    
    public void setTestTitle(String title) {
        _testTitle = title;
    }
    
    public void init() {
        buildHeader();
        _listOfTest = new ArrayList<ReportElement>();
        _error      = new StringBuffer();
        _failure    = new StringBuffer();    
        _testTitle  = new String("");        
        
    }
    
    
    
    public boolean isSuccessfull() {
        if(_error.length() == 0 && _failure.length() == 0) {
            return true;
        }
        return false;
    }
    
}


class ReportElement {
    private String _name = null;
    private ArrayList<Long> _listOfResult = new ArrayList<Long>();
    
    
    public ReportElement(String name) {
        _name = name;
    }
    
    
    void addTestResult(long result) {
       _listOfResult.add(new Long(result));
    }
    
    String getName() {
        return _name;
    }
    
    
    public String toString() {
        StringBuffer tmp  = new StringBuffer();
        StringBuffer tmp2 = new StringBuffer();
        Long ltmp = null;
        long total = 0;
        
        tmp.append(getName());
        tmp.append(" ");
        tmp.append(_listOfResult.size());
        tmp.append(" time(s)");
        tmp2.append("(");
        
        for (int i=0;i< _listOfResult.size();i++) {
            ltmp = _listOfResult.get(i);
            if(i != 0) {
                tmp2.append(",");    
            }
            tmp2.append(ltmp.toString());
            total += ltmp.longValue();    
        }
        
        tmp2.append(")");
        if(total != 0) {
            float average = 0;
            average = total/_listOfResult.size();
            tmp.append(" in an average of : ");
            tmp.append(average);
            tmp.append(" ms ");
            tmp.append(tmp2);
        }
        return tmp.toString();
    }
    
}
//eof
