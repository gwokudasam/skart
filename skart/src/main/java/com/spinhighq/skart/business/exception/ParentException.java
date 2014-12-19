package com.spinhighq.skart.business.exception;

public class ParentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ParentException() {
		super("Parent Exception occured due to the business logic failure");
		
	}
	
	public ParentException(String message){
		super(message);
	}
	
	public ParentException(String message, Exception exception){
		super(message, exception);
	}


}
