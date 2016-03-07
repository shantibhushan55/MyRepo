/*
 * Created on Dec 21, 2004
 */
package com.hp.es.test.batchEntitlement;

import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.batchEntitlement.BatchCsvReader;

/**
 * @author stefsobe
 *
 */
public class BatchCsvReaderTest extends TestCase {

    /**
     * Standard constructor
     */
    public BatchCsvReaderTest() {
        super();
    }

    /**
     * Constructor with class name passed as String
     * @param arg0
     */
    public BatchCsvReaderTest(String arg0) {
        super(arg0);
    }

    /*
     * @return the test suite
     */
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(BatchReplyMapperTest.class);
    }

    public void test () {
        BatchCsvReader r = new BatchCsvReader(new StringReader(
                "DE,SN,PN\n" +					// 1
                " DE , SN , PN \n" +			// 2
                "DE,SN,\n" +					// 3
                "DE,,\n" +						// 4
                ",,\n" +						// 5
                "DE,\n" +						// 6
                "DE,SN,PN,xx\n" +				// 7
                "123, 123456789012345678901234567890123, 1234567890123456789\r\n" +	// 8
                "12, 123456789012345678901234567890123, 1234567890123456789\n" +	// 9
                "12, 12345678901234567890123456789012, 1234567890123456789\n" +		// 10
                "12, 12345678901234567890123456789012, 123456789012345678"			// 11
                ));
                
        check(r, "DE", "SN", "PN", true);		// 1
        check(r, "DE", "SN", "PN", true);		// 2
        check(r, "DE", "SN", "", true);			// 3
        check(r, "DE", "", "", true);			// 4
        check(r, "", "", "", false);			// 5
        check(r, "DE", "", "", false);			// 6
        check(r, "DE", "SN", "PN", false);		// 7
        check(r, "??", "??", "??", false);		// 8
        check(r, "12", "??", "??", false);		// 9
        check(r, "12", "12345678901234567890123456789012", "??", false);	// 10
        check(r, "12", "12345678901234567890123456789012", "123456789012345678", true);	//11
    }
    
    private void check(BatchCsvReader r, String s0, String s1, String s2, boolean valid) {
        try {
            String[] fields = r.getAllFieldsInLine();
            assertTrue("r.getAllFieldsInLine() must not return null", fields!=null);
            assertTrue("r.getAllFieldsInLine() must return array with 3 elements.", fields.length==3);
            assertTrue("fields[0] invalid", fields[0].equals(s0));
            assertTrue("fields[1] invalid", fields[1].equals(s1));
            assertTrue("fields[2] invalid", fields[2].equals(s2));
            assertTrue("r.lastRowWasValid() wrong", r.lastRowWasValid()==valid);
        }
        catch (EOFException e) {
            // If we reach EOF we have notjing to do
        }
        catch (IOException e) {
            fail("IOException");
        }
    }
    
    public static void main(String[] args) {
        BatchCsvReaderTest test = new BatchCsvReaderTest();
        test.test();
    }
}
