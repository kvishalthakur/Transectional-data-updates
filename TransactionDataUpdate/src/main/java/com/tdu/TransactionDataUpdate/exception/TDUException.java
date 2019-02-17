package com.tdu.TransactionDataUpdate.exception;

//TODO: Auto-generated Javadoc
/**
* The Class CustomerException.
*/
public class TDUException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error message. */
	private String errorMessage;
	
	private int errorCode;

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	

	public int getErrorCode() {
		return errorCode;
	}



	/**
	 * Instantiates a new customer exception.
	 *
	 * @param errorMessage the error message
	 */
	public TDUException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public TDUException(int errorCode ,String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode  = errorCode;
	}

	/**
	 * Instantiates a new customer exception.
	 */
	public TDUException() {
		super();
	}

	public TDUException(Exception e) {
		super(e);
	}
}