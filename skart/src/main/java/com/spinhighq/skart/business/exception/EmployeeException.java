package com.spinhighq.skart.business.exception;

public class EmployeeException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeException(){
		super("Employee Exception occured due to the business logic failure");
	}
	
	public EmployeeException(String message){
		super(message);
	}
	
	public EmployeeException(String message, Exception exception){
		super(message, exception);
	}
	

}
