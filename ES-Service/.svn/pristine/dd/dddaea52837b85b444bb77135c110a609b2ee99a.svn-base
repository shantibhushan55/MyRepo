package com.hp.es.tm.util.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

/**
 * @author Wade He <wei.he6@hp.com>
 *
 */
public class TmException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4343343957232876617L;

	private Throwable cause = null;

	private String clientMessage = null;

	private Object additionalInformation = null;

	private int errorCode = 0;

	private boolean firstTimeToString = true;

	/*
	 * Constructs an empty TmException
	 */
	public TmException() {
		super();
	}

	/**
	 * Constructs a TmException with the specified chained exception
	 * @param inCause a Throwable that should be chained
	 */
	public TmException(Throwable inCause) {
		super(inCause == null ? null : inCause.toString());
		this.cause = inCause;
	}

	/**
	 * Constructs a TmException with the specified detail message.
	 * @param inMessage a String stating the detailed message
	 */
	public TmException(String inMessage) {
		super(inMessage);
	}

	/**
	 * Constructs a TmException with the specified detail message
	 * and the chained exception.
	 *
	 * @param inMessage a String stating the detailed message
	 * @param inCause a Throwable that should be chained
	 */
	public TmException(String inMessage, Throwable inCause) {
		this(inMessage);
		this.cause = inCause;
	}

	/**
	 * Gets any additional information that may be supplied.
	 * @return an Object being the additional information or <code>null</code>
	 * if no additional information is provided
	 */
	public Object getAdditionalInformation() {
		return this.additionalInformation;
	}

	/**
	 * Gets the chained Throwable. If no chained exception is available
	 * <code>null</code> is returned.
	 * @return the Throwable object being chained to this Throwable
	 *  or <code>null</code> if no Throwable was defined
	 */
	public Throwable getCause() {
		return this.cause;
	}

	/**
	 * Gets the client message. This is a message that would be dedicated
	 * for the client of the application.
	 * @return a String containing the client message or <code>null</code>
	 *  if no message was defined
	 */
	public String getClientMessage() {
		return this.clientMessage;
	}

	/**
	 * Gets the application specific error code for this exception.
	 * @return inErrorCode an int indicating what went wrong
	 */
	public int getErrorCode() {
		return this.errorCode;
	}

	public synchronized Throwable initCause(Throwable inCause) {
		if (this == inCause) {
			throw new IllegalArgumentException(
					"The casue cannot be the same as this object.");
		}
		if (this.cause != null) {
			throw new IllegalStateException("Casue already defined.");
		}
		this.cause = inCause;
		return this;
	}

	public void printStackTrace() {
		super.printStackTrace();
		if (this.cause != null) {
			//System.err.println("chained exception:");
			cause.printStackTrace();
		}
	}

	//	-----------------------------------------------------------------------------

	public void printStackTrace(PrintStream inStream) {
		synchronized (inStream) {
			super.printStackTrace(inStream);
			if (this.cause != null) {
				inStream.println("chained exception:");
				cause.printStackTrace(inStream);
			}
		}
	}

	//	-----------------------------------------------------------------------------

	public void printStackTrace(PrintWriter inWriter) {
		synchronized (inWriter) {
			super.printStackTrace(inWriter);
			if (this.cause != null) {
				inWriter.println("chained exception:");
				cause.printStackTrace(inWriter);
			}
		}
	}

	//	-----------------------------------------------------------------------------

	/**
	 * Sets additional information about the exception.
	 *
	 * @param inInfo an Object being the additional information
	 */
	public void setAdditionalInformation(Object inInfo) {
		this.additionalInformation = inInfo;
	}

	//	-----------------------------------------------------------------------------

	/**
	 * Sets the client message. This is a message that would be dedicated
	 * for the client of the application.
	 *
	 * @param inMessage a String containing the client message
	 */
	public void setClientMessage(String inMessage) {
		this.clientMessage = inMessage;
	}

	//	-----------------------------------------------------------------------------

	/**
	 * Sets the application specific error code for this exception.
	 *
	 * @param inErrorCode an int indicating what went wrong
	 */
	public void setErrorCode(int inErrorCode) {
		this.errorCode = inErrorCode;
	}

	//	-----------------------------------------------------------------------------

	public String toString() {

		StringBuffer buffer = new StringBuffer();

		if (this.firstTimeToString) {
			// This flag is necessary since printStackTrace() below calls
			// toString() also. Without this flag there would be a neverending
			// loop.
			firstTimeToString = false;

			buffer.append("message: [");
			buffer.append(getMessage());
			buffer.append("]\n");

			buffer.append("stack trace: [");
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			super.printStackTrace(printWriter);
			String stackTrace = stringWriter.toString();
			buffer.append(stackTrace.substring(stackTrace.indexOf("\n") + 1));
			buffer.append("]\n");

			buffer.append("clientMessage: [");
			buffer.append(clientMessage);
			buffer.append("]\n");

			buffer.append("additionalInformation: [");
			buffer.append(additionalInformation);
			buffer.append("]\n");

			buffer.append("errorCode: [");
			buffer.append(errorCode);
			buffer.append("]\n");

			Throwable throwable = cause;
			while (throwable != null) {
				buffer.append("chained exception (cause): [");
				stringWriter = new StringWriter();
				printWriter = new PrintWriter(stringWriter);
				throwable.printStackTrace(printWriter);
				stackTrace = stringWriter.toString();
				buffer.append(stackTrace);
				buffer.append("]\n");

				if (throwable instanceof SQLException) {
					throwable = ((SQLException) throwable).getNextException();
				} else if (throwable instanceof Exception) {
					throwable = ((Exception) throwable).getCause();
				}
			}

			this.firstTimeToString = true;
		}

		return buffer.toString();
	}

}
