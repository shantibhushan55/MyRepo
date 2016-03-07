/*
 * Created on 29 nov. 2004
 *
 * Class EmailUtilitiesTest
 * This class is a testbed classes that is only used to test the emailing functions.
 */
package com.hp.es.test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringBufferInputStream;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.zip.ZipOutputStream;

import com.hp.es.service.util.mail.EmailUtilities;
import com.hp.ruc.io.zip.StreamCompress;



@SuppressWarnings("deprecation")
public class EmailUtilitiesTest {

	private final static String EMAILDELIMITER= new String(";");
	/*
	 * Main Method used to test the EmailUtilities and other related classes
	 * @param String[] args : the list of argument, this program expect the mail server
	 * 				   and the mail address to send to
	 */
	public static void main(String[] args) throws Exception{
		/*
		 * Local variable declaration.
		 */
		String serverName=null;
		String strToAdressList = null;
		

		String[] arrayToAdressList =null;
		//1 - we check parameters
		if(args.length <2) {
			System.out.println("please specify server address and the email list to send to (separated by ;).");
			System.exit(-1);
		}
		// We store the parameters
		serverName= args[0];
		strToAdressList= args[1];
		StringTokenizer stEmail = new StringTokenizer(strToAdressList,EMAILDELIMITER);

		arrayToAdressList = new String[stEmail.countTokens()];
		int cptEmail=0;
		while(stEmail.hasMoreTokens()) {
			arrayToAdressList[cptEmail]=stEmail.nextToken();
		}

		//we set the from to tghe first address
		String fromAdress=arrayToAdressList[0];

		// We create the email utilities class
		EmailUtilities eu= new EmailUtilities(serverName);

		//System.out.println("Three emails will be sent to "+strToAdressList+" from "+fromAdress+" using mail server "+eu.getMailServerAddress() );
		long timeTaken=0;
		try {

			timeTaken=System.currentTimeMillis();
			eu.postMail(arrayToAdressList,fromAdress, "Batch file Id 1","Email with no attchement sent at"+ new Date());
			timeTaken=System.currentTimeMillis() - timeTaken;
			System.out.println("Batch 1  email was sent in  "+timeTaken+"ms");
		}catch(Exception e) {
			System.out.println("Batch file Id 1 failed");
			e.printStackTrace();

		}

		FileInputStream attachmentStream = null;
		// sending an already existing zip
		try {
			attachmentStream = new FileInputStream("C:\\list.zip");

			timeTaken=System.currentTimeMillis();
			eu.postMail(arrayToAdressList,fromAdress,"Batch file with an existing ZIP","The batch file result with attachment"+new Date(),attachmentStream,"tmp.zip");

			timeTaken=System.currentTimeMillis() - timeTaken;
			System.out.println("Batch 2 email was sent in  "+timeTaken+"ms");
		}catch(Exception e) {
			System.out.println("Batch file Id 2 failed");
			e.printStackTrace();

		}finally {
			if( attachmentStream != null) {
				try {
					attachmentStream.close();
				}catch( Exception e) {};
			}
		}


/*
		InputStream xmlFileStream = null;
		ByteArrayOutputStream zipFileStream= null;
		ZipOutputStream zos= null;
		try {
			xmlFileStream = new BufferedInputStream(new FileInputStream("C:\\176699.xml"));
			zipFileStream = new ByteArrayOutputStream();
			zos= StreamCompress.compressStreamContent(xmlFileStream,zipFileStream,"176699.xml");


			// At this point we have a ZipOutputStream that contain  data from xmlFileStream, zipFileStream is used to represennt the data in memory


			timeTaken=System.currentTimeMillis();
			eu.postMail(arrayToAdressList,fromAdress,"Batch file with a non existing ZIP","The batch file result with attachment"+new Date(),zipFileStream,"tmp.zip");
			timeTaken=System.currentTimeMillis() - timeTaken;
			System.out.println("Batch 3 email was sent in  "+timeTaken+"ms");
		}catch(Exception e) {
			System.out.println("Batch file Id 3 failed");
			e.printStackTrace();

		}finally {
			if( xmlFileStream != null) {
				try {
					xmlFileStream.close();
				}catch( Exception e) {};
			}

			if( zos != null) {
				try {
					zos.close();
				}catch( Exception e) {};
			}else if (zipFileStream != null) {
				try {
					zipFileStream.close();
				}catch( Exception e) {};
			}
		}



		xmlFileStream = null;
		ByteArrayOutputStream os= null;
		try {
			System.out.println("Dumping memory usage information just before calling batch that concat multiple stream "+ " Total Memory "+ ": "+": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			xmlFileStream = new BufferedInputStream(new FileInputStream("C:\\176699.xml"));
			System.out.println("Dumping memory usage information just after opening stream 1 "+ " Total Memory "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			StreamCompress sc = new  StreamCompress();
			sc.addEntry("176699.xml");
			sc.addStreamContentToCurrentEntry(xmlFileStream);
			System.out.println("Dumping memory usage information just after adding stream 1 to zip"+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			xmlFileStream.close();
			System.out.println("Dumping memory usage information just after closing stream 1 "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			xmlFileStream = new BufferedInputStream(new FileInputStream("C:\\tody_005.xml"));
			System.out.println("Dumping memory usage information just after opening stream 2 "+ " Total Memory "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			sc.addStreamContentToCurrentEntry(xmlFileStream);
			System.out.println("Dumping memory usage information just after adding stream 2 to zip"+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			xmlFileStream.close();
			System.out.println("Dumping memory usage information just after closing stream 2 "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			os= sc.getFinishedZipSreamCompressed();
			System.out.println("Dumping memory usage information just after finishing zip "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			// At this point we have a ZipOutputStream that contain  data from xmlFileStream, zipFileStream is used to represennt the data in memory


			timeTaken=System.currentTimeMillis();
			eu.postMail(arrayToAdressList,fromAdress,"Batch file with a non existing ZIP","The batch file result with attachment"+new Date(),os,"tmp.zip");
			timeTaken=System.currentTimeMillis() - timeTaken;
			System.out.println("Dumping memory usage information just after posting mail "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
			System.out.println("Batch 3 email was sent in  "+timeTaken+"ms");
		}catch(Exception e) {
			System.out.println("Batch file Id 3 failed");
			e.printStackTrace();

		}finally {
			if( xmlFileStream != null) {
				try {
					xmlFileStream.close();
				}catch( Exception e) {};
			}

			if( os != null) {
				try {
					zos.close();
				}catch( Exception e) {};
			}
		}
		System.out.println("Dumping memory usage information just after closing everything "+ ": "+Runtime.getRuntime().totalMemory() + " Free Memory "+Runtime.getRuntime().freeMemory());
	*/
		System.out.println("Dumping memory usage information at programm startup "+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
		for(int i=0;i<1;i++) {
			concatXMLDirAndSend(eu,fromAdress, arrayToAdressList,"A big zip for trying memory consumption", "See attachement", "c:\\test\\");
		}
		System.gc();
		System.out.println("Dumping memory usage information at programm quit after System.gc "+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
		testOnEIAenvironment();
	}

	@SuppressWarnings("unused")
	private static void concatXMLDirAndSend(EmailUtilities eu,String  fromAdress, String[] arrayToAdressList,String messageSubject, String messageText, String dirName) {
		long timeTaken;
		BufferedInputStream xmlFileStream = null;
		ByteArrayOutputStream os= null;
		ZipOutputStream zos = null;
		StreamCompress sc = null;

		try {
			// We are first listing the directory
	        File f = new File(dirName);
	        String   list[] = f.list(new InnerXMLFileFilter());

	        if(list.length ==0) {
				System.exit(0);
			}
	        System.out.println("Dumping memory usage information after reading the list of XML file "+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
			sc = new  StreamCompress();
			sc.addEntry("batch.xml");
			 System.out.println("Dumping memory usage information after creating the zip entry "+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
			// Now we are going to play with the content of the directory
	        for(int i= 0;i < list.length; i++) {
	        	//we are going to open the stream, then we will copy it into the zipoutputstream and close it
	        	xmlFileStream = new BufferedInputStream(new FileInputStream(dirName+list[i]));
				sc.addStreamContentToCurrentEntry(xmlFileStream);
				System.out.println("Dumping memory usage information just after adding stream "+ i +" to zip"+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
				xmlFileStream.close();
				System.out.println("Dumping memory usage information just after closing stream "+ i +" "+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
	        }
			os= sc.getFinishedZipSreamCompressed();
			System.out.println("Dumping memory usage information just after finishing zip "+ ": "+Runtime.getRuntime().totalMemory() + " /"+Runtime.getRuntime().freeMemory());


			timeTaken=System.currentTimeMillis();
			eu.postMail(arrayToAdressList,fromAdress,"Batch file with a ZIP file created with" +list.length+ "xml files","The batch file result with attachment"+new Date(),os,"tmp.zip");
			timeTaken=System.currentTimeMillis() - timeTaken;
			System.out.println("Dumping memory usage information just after posting mail "+ ": "+Runtime.getRuntime().totalMemory() + " /"+Runtime.getRuntime().freeMemory());
			//System.out.println("Batch 3 email was sent in  "+timeTaken+"ms");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(sc != null) {
			sc.close();
			}
			if( xmlFileStream != null) {
				try {
					xmlFileStream.close();
				}catch( Exception e) {};
			}

			if( os != null) {
				if(zos != null) {
					try {
						zos.close();
					}catch( Exception e) {};
				}else {
					try {
						os.close();
					}catch( Exception e) {};
				}
			}
		}

	}

	public static void testOnEIAenvironment() {
		BufferedInputStream xmlFileStream = null;
		ByteArrayOutputStream os= null;
		ZipOutputStream zos = null;
		StreamCompress sc = null;
		String[] arrayToAdressList = new String[1];
		arrayToAdressList[0]="antoine.voiry@hp.com";
		String fromAdress= "antoine.voiry@hp.com";


		try {
		    EmailUtilities eu= new EmailUtilities("localhost");
			// We are first listing the directory
			sc = new  StreamCompress();
			sc.addEntry("batch.xml");
			 System.out.println("Dumping memory usage information after creating the zip entry "+ ": "+Runtime.getRuntime().totalMemory() + " / "+Runtime.getRuntime().freeMemory());
			// Now we are going to play with the content of the directory
	        	//we are going to open the stream, then we will copy it into the zipoutputstream and close it
        	xmlFileStream = new BufferedInputStream(new StringBufferInputStream("<XML batch> toto<XML BATCH>"));
			sc.addStreamContentToCurrentEntry(xmlFileStream);
			xmlFileStream = new BufferedInputStream(new StringBufferInputStream("<XML batch> tata<XML BATCH>"));
			sc.addStreamContentToCurrentEntry(xmlFileStream);
			xmlFileStream.close();
			os= sc.getFinishedZipSreamCompressed();


			eu.postMail(arrayToAdressList,fromAdress,"Batch result","Batch file sent from EIA environment",os,"tmp.zip");

			System.out.println("Test email was sent.");
		}catch(Exception e) {
		    System.out.println("ERROR");
			e.printStackTrace();
		}finally {
			if(sc != null) {
				sc.close();
			}
			
			if( xmlFileStream != null) {
				try {
					xmlFileStream.close();
				}catch( Exception e) {};
			}

			if( os != null) {
				if(zos != null) {
					try {
						zos.close();
					}catch( Exception e) {};
				}else {
					try {
						os.close();
					}catch( Exception e) {};
				}
			}
		}

	}
}

/*
One inner class
*/
class InnerXMLFileFilter implements java.io.FilenameFilter {

    public InnerXMLFileFilter() {
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

//EOF