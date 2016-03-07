/*
 * Created on 25 nov. 2004
 *
 */
package com.hp.es.service.util.mail;

/*
 * This class requires javax.mail package
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.CommandInfo;
import javax.activation.DataHandler;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.hp.es.service.plumbing.SAPConnectivity;
import com.hp.es.service.util.ESLog;


/**
 * @author anvoi
 *
 */
public class EmailUtilities {
	// the email server name for example isoit621.bbn.hp.com or smtp.aol.com
	private String _mailServerAddress=null;


	// the mail cap command map used to override the default one
	private static MailcapCommandMap _map;

	// a static final variable used to initialized environment
	private final static int _initConstant= init();



	// Some Constants
	private final static String MIMETYPE_FOR_STREAM_ATTACHEMENT="application/octet-stream";
	private final static String MIMETYPE_FOR_MESSAGE_BODY="text/plain";
	private final static String DATA_HANDLER_FOR_STREAM_ATTACHEMENT="com.hp.sif.mail.application_octet_stream";
	private final static String MAIL_SERVER_HOST="mail.smtp.host";


	/*
	 * Init method
	 * Call once when the class is instantiated for the first time.
	 * @return an integer always set to 0.
	 */
	private synchronized static int init() {
		
		ESLog.info("EmailUtilities is entering init, this should only happen once");
		//we also initialize mime type support
		//map manually (javax.activation.MailcapCommandMap):
		_map = (MailcapCommandMap)MailcapCommandMap.getDefaultCommandMap();
		_map.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		_map.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		_map.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		_map.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		_map.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");

		_map.addMailcap(MIMETYPE_FOR_STREAM_ATTACHEMENT+";;x-java-content-handler="+DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
		MailcapCommandMap.setDefaultCommandMap(_map );
		ESLog.info("EmailUtilities finished init");

		return 0;
	}


	/**
	 * Default construction is forbidden
	 */
	private EmailUtilities(){	}


	/**
	 * @param serverAddress
	 * @param the printStream that will be used to log message
	 */
	public EmailUtilities(String serverAddress) throws EmailUtilitiesException {
		// This will have to be refactor
		ESLog.debug("Entering constructor with serverAdress"+serverAddress);
		if(serverAddress == null){
			ESLog.error("Mail Server Address is null, this is a major issue");
			throw new EmailUtilitiesException("serverAddress is null");
		}
		_mailServerAddress = serverAddress;
	}


	private void debugDataHandler(DataHandler dh) {
		try {
			if(ESLog.isDebugLogEnabled()) {
				ESLog.debug("Here is the debug for the data handler");
				ESLog.debug("dh classloader "+ dh.getClass().getClassLoader());
				
				ESLog.debug("dh package "+ dh.getClass().getPackage().getName());
				ESLog.debug("dh class name "+ dh.getClass().getName());
				ESLog.debug("dh name "+dh.getName());
				ESLog.debug("dh content type "+ dh.getContentType());
				
				ESLog.debug("dh content "+ dh.getContent().getClass().getName());
				
				
				ESLog.debug("getting all commands");
				
				for (int i=0;i < dh.getAllCommands().length;i++) {
					CommandInfo ci = dh.getAllCommands()[i];
					ESLog.debug("command info "+i +" is "+ci.getCommandName());
					ESLog.debug("command info class name"+i +" is "+ci.getCommandClass());
		
				}
				ESLog.debug("trying to load SAPConnectivity so that we can search logs" );
				Object test = new SAPConnectivity();
				ESLog.debug("end trying to load SAPConnectivity so that we can search logs" );
				
				try {
					ESLog.debug("Trying to load"+DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
					EmailUtilities.class.getClassLoader().loadClass(DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
					ESLog.debug("succesfully loaded "+DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
				} catch (ClassNotFoundException e) {
					ESLog.debug("failed to load"+DATA_HANDLER_FOR_STREAM_ATTACHEMENT, e);
					ESLog.debug("failed to load cause "+DATA_HANDLER_FOR_STREAM_ATTACHEMENT, e.getCause());
				}
			    
				try {
					ESLog.debug("Trying to load with forname"+DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
					EmailUtilities.class.forName(DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
					ESLog.debug("succesfully loaded "+DATA_HANDLER_FOR_STREAM_ATTACHEMENT);
					
				} catch (ClassNotFoundException e) {
					ESLog.debug("failed to load"+DATA_HANDLER_FOR_STREAM_ATTACHEMENT, e);
					ESLog.debug("failed to load cause "+DATA_HANDLER_FOR_STREAM_ATTACHEMENT, e.getCause());
				}			
				printResourceLocations("com/hp/sif/mail/application_octet_stream.class");
			    printResourceLocations("javax/activation/DataHandler.class");
			    printResourceLocations("javax/mail/Message.class");
				
	
				
				ClassLoader classLoader = getClass().getClassLoader();
			      // Implies that we're at the top of the hierarchy when null.
			      while (classLoader != null) {
			         ESLog.debug("EmailUtilities: parent classLoader == " +
			                            classLoader.toString());
			         // Note that getParent() may require opening up the
			         // security settings in the JVM.
			         classLoader = classLoader.getParent();
			      }
			      ESLog.debug("EmailUtilities: parent classLoader == null");
			}
			
			
		} catch (IOException e) {
			ESLog.debug("Exception",e);
			
		}

		
	}
	/*
	 * postMail send email to a list and recipients, with a subject a messageText and a from address
	 * @param recipients the list of recipient
	 * @param subject, the subject of this message
	 * @param messageText, the message content
	 * @param from, the sender address
	 */
	public void postMail( String toList[], String from, String subject, String messageText )
		throws EmailUtilitiesException	{

		try {
			ESLog.debug("An email with no attachement will be sent");
			if(toList == null || from == null || subject==null || messageText==null || toList.length == 0) {
				ESLog.debug("Some parameters are null.");
				
				throw new EmailUtilitiesException("incorrect usage; some parameters are null");
			}

		    Session session = openSession();

		    // create a message
		    Message msg = new MimeMessage(session);

		    // set the from and to address
		    InternetAddress addressFrom = new InternetAddress(from);
		    msg.setFrom(addressFrom);

		    msg.setRecipients(Message.RecipientType.TO, mapToAddressStringToInternetAddress(toList));

		    // Setting the Subject and Content Type
		    msg.setSubject(subject);
		    msg.setContent(messageText, MIMETYPE_FOR_MESSAGE_BODY);
		    msg.saveChanges();
		    
		    Transport.send(msg);
		    
		    ESLog.debug("An email with no attachement was sent");
		    
		}
        catch(AddressException e){
        	ESLog.error("Exception while sending Email", e);
			throw new EmailUtilitiesException("AddressException while sending email");
		}
        catch(MessagingException e) {
        	ESLog.error("Exception while sending Email", e);
			throw new EmailUtilitiesException("MessagingException while sending email"+ e.getMessage());
		}
	}

	/*
	 * @param recipients the list of recipient
	 * @param from, the sender address
	 * @param subject, the subject of this message
	 * @param messageText, the message content
	 * @param iAttachment: a ByteArrayOutputStream cpointing to a zip represented in a ByteArrayOutputStream
	 * @param streamFilename the name of the file that we are going to show in the email
	 */
	public void postMail( String toList[], String from, String subject, String messageText ,
				InputStream iAttachment, String streamFilename) throws EmailUtilitiesException	{
	    // create a message
		try {
			
			ESLog.debug("An email with an InputStream attachement will be sent");
			if(toList == null || from == null || subject==null || messageText==null ||iAttachment == null || toList.length == 0) {
				ESLog.debug("Some parameters are null.");
				
				throw new EmailUtilitiesException("Incorrect usage; some parameters are null");
			}

			Session session = openSession();
		    Message msg = new MimeMessage(session);

		    // set the from and to address
		    InternetAddress addressFrom = new InternetAddress(from);
		    msg.setFrom(addressFrom);
		    msg.setRecipients(Message.RecipientType.TO, mapToAddressStringToInternetAddress(toList));

		    // Setting the Subject
		    msg.setSubject(subject);


		    //create body
	        MimeBodyPart body = createMessageBody(messageText);
	        // fill the attachemnt
	        MimeBodyPart attachment = createMessageAttachement(iAttachment,streamFilename);

	        // create the Multipart and its parts to it
	        Multipart mp = new MimeMultipart();
	        mp.addBodyPart(body);
	        mp.addBodyPart(attachment);

	        // add the Multipart to the message
	        msg.setContent(mp);
	        msg.saveChanges();
		    //msg.setContent(message, "text/plain");
	        
	        Transport.send(msg);
		    
		    ESLog.debug("An email with an InputStream attachement was sent");
		    
		}catch(AddressException e){
			ESLog.error("Exception while sending Email", e);
			
			throw new EmailUtilitiesException("AddressException while sending email");
		}catch(MessagingException e) {
			ESLog.error("Exception while sending Email", e);
			
			throw new EmailUtilitiesException("MessagingException while sending email"+ e.getMessage());
		}
	}

	/*
	 * @param recipients the list of recipient
	 * @param from, the sender address
	 * @param subject, the subject of this message
	 * @param messageText, the message content
	 * @param iAttachment: a ByteArrayOutputStream cpointing to a zip represented in a ByteArrayOutputStream
	 * @param streamFilename the name of the file that we are going to show in the email
	 */
	public void postMail(String toList[], String from, String subject,
            String messageText, ByteArrayOutputStream baoAttachment,
            String streamFilename)
				throws EmailUtilitiesException{
		try {
			ESLog.debug("An email with an ByteArrayOutputStream attachement will be sent");
			ESLog.debug("from=" + from);
			ESLog.debug("subject=" + subject);
			ESLog.debug("messageText=" + messageText);
			ESLog.debug("streamFilename=" + streamFilename);
			if(toList == null || from == null || subject==null || messageText==null ||baoAttachment == null || toList.length == 0
					|| baoAttachment.size() == 0) {
				ESLog.error("Some parameters are null.");
				ESLog.error(" from=" + from
							+ ", subject=" + subject
							+ ", messageText=" + messageText);
				
				throw new EmailUtilitiesException("Incorrect usage; some parameters are null");
			}

		    Session session = openSession();


		    // create a message
		    Message msg = new MimeMessage(session);

		    // set the from and to address
		    InternetAddress addressFrom = new InternetAddress(from);
		    msg.setFrom(addressFrom);
		    msg.setRecipients(Message.RecipientType.TO, mapToAddressStringToInternetAddress(toList));

		    // Setting the Subject
		    msg.setSubject(subject);

		    //create and fill the body
		    MimeBodyPart body = createMessageBody(messageText);

	        // create and fill the message body
	        MimeBodyPart attachement = createMessageAttachement(baoAttachment, streamFilename);

	        // create the Multipart and its parts to it
	        Multipart mp = new MimeMultipart();
	        mp.addBodyPart(body);
	        mp.addBodyPart(attachement );

	        // add the Multipart to the message
	        msg.setContent(mp);
	        msg.saveChanges();
		    //msg.setContent(message, "text/plain");
	        
		    Transport.send(msg);

		    ESLog.debug("An email with an ByteArrayOutputStream attachement was sent");
		    
		}catch(AddressException e){
		    ESLog.error("Exception while sending Email",e);
		   
			throw new EmailUtilitiesException("AddressException while sending email");
		}catch(MessagingException e) {
			 ESLog.error("Exception while sending Email",e);
			throw new EmailUtilitiesException("MessagingException while sending email"+ e.getMessage());
		}
	}



	/**
	 * @return Returns the _mailServerAddress.
	 */
	public String getMailServerAddress() {
		return _mailServerAddress;
	}

	/*
	 * This method open a session with no authentification
	 */
	private Session openSession() {
		 //Set the host smtp address
		ESLog.debug("Session on mail server : "+MAIL_SERVER_HOST+":"+_mailServerAddress+" will be opened");
		 Properties props = new Properties();
		 props.put(MAIL_SERVER_HOST,_mailServerAddress );


		// create some properties and get the default Session (with no authentification)
		Session session = Session.getInstance(props);
		//session.setDebug(true);
		ESLog.debug("Session on mail server : "+MAIL_SERVER_HOST+":"+_mailServerAddress+" opened");
		return session;
	}

	/*
	 * This method open a session with no authentification
	 * @param array of recipients
	 * @throw AddressException
	 */
	private InternetAddress[] mapToAddressStringToInternetAddress(
            String[] arrayRecipients) throws AddressException {
		ESLog.debug("Transforming array of string into array of InterNetAddress");
        InternetAddress[] addressTo = new InternetAddress[arrayRecipients.length];
        for (int i = 0; i < arrayRecipients.length; i++) {
            addressTo[i] = new InternetAddress(arrayRecipients[i]);
        }
        ESLog.debug("Transforming array of string into array of InterNetAddress done");
        return addressTo;
    }

	/*
	 * This method create the body of the message and set the content with the requested body
	 * @param array of recipients
	 * @throw AddressException
	 */
	private MimeBodyPart createMessageBody(String messageText) throws MessagingException {
        /*
         *  create and fill the text content
         * This is the akas the body
         */
		ESLog.debug("Creating message body for text:"+messageText);
        MimeBodyPart mbp = new MimeBodyPart();
        mbp.setContent(messageText, MIMETYPE_FOR_MESSAGE_BODY);
        ESLog.debug("Creating message body finished");
        return mbp;
 	}

	/*
	 * This method create the body of the message and set the content with the requested body
	 * @param InputStream: the stream pointing to the zip content
	 * @param the file name given to that stream in the attached email
	 * @throw AddressException
	 */
	private MimeBodyPart createMessageAttachement(InputStream is, String streamFileName) throws MessagingException {
        /*
         *  create and fill the text content
         * This is the akas the body
         */
		ESLog.debug("Creating message attachement for Input Stream");
        MimeBodyPart attachement = new MimeBodyPart();


        DataHandler dh = new DataHandler(is, MIMETYPE_FOR_STREAM_ATTACHEMENT);
        dh.setCommandMap(_map);
        debugDataHandler(dh);
        attachement.setDataHandler(dh);
        //attachment.setContent(iAttachment,mimeType);
        addHeaderToAttachement(attachement,streamFileName);
        
        ESLog.debug("Creating message attachement for Input Stream finished");
        return attachement;
	}

	/*
	 * This method create the body of the message and set the content with the requested body
	 * @param ByteArrayOutputStream: the output stream pointing to the zip content
	 * @param the file name given to that stream in the attached email
	 * @throw AddressException
	 */
	private MimeBodyPart createMessageAttachement(ByteArrayOutputStream bos, String streamFileName) throws MessagingException {
        /*
         *  create and fill the text content
         * This is the akas the body
         */
		ESLog.debug("Creating message attachement for ByteArrayOutputStream");
        MimeBodyPart attachement = new MimeBodyPart();

        DataHandler dh = new DataHandler(bos, MIMETYPE_FOR_STREAM_ATTACHEMENT);
        dh.setCommandMap(_map);
        attachement.setDataHandler(dh);
        debugDataHandler(dh);
        //attachment.setContent(iAttachment,mimeType);
        addHeaderToAttachement(attachement,streamFileName);
        ESLog.debug("Creating message attachement for ByteArrayOutputStream finished");
        return attachement;

	}

	/*
	 * This method create the body of the message and set the content with the requested body
	 * @param InputStream: the stream pointing to the zip content
	 * @param the file name given to that stream in the attached email
	 * @throw AddressException
	 */
	private void addHeaderToAttachement(MimeBodyPart attachement, String streamFileName) throws MessagingException {
		ESLog.debug("Adding message header");
        attachement.setFileName(streamFileName);
        attachement.addHeader("Content-Type",MIMETYPE_FOR_STREAM_ATTACHEMENT+"; name=\""+streamFileName+"\"");
        attachement.addHeader("Content-Transfer-Encoding","base64");
        ESLog.debug( "Adding message header finished");
 	}
	
	
	   private  void printResourceLocations(String resourceName)
	      throws IOException
	   {
	      ClassLoader cld = EmailUtilities.class.getClassLoader();
	      
	      Enumeration en = cld.getResources(resourceName);
	      
	      
	      StringBuffer buf = new StringBuffer();
	      buf.append(resourceName);
	      buf.append(": ");
	      
	      if (en == null || (!en.hasMoreElements()))
	      {
	         buf.append("not found");
	      }
	      else
	      {
	         boolean firstLoc = true;
	         while (en.hasMoreElements())
	         {
	            if (!firstLoc)
	            {
	               buf.append(", ");
	            }
	            
	            URL url = (URL) (en.nextElement());
	            buf.append(url.toString());
	            firstLoc = false;
	         }
	      }
	      
	      ESLog.debug(resourceName +" loaction is " +buf.toString());
	   }	
}
//eof
