package com.spinhighq.skart.business.exception;

public class StudentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentException() {
		super("Student Exception occured due to the business logic failure");
		
	}
	
	public StudentException(String message){
		super(message);
	}
	
	public StudentException(String message, Exception exception){
		super(message, exception);
	}

}
