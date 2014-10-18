package com.spinhighq.skart.business.exception;

public class StudentException extends Exception{

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
