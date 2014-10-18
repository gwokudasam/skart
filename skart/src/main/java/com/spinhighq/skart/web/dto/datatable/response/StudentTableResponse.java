package com.spinhighq.skart.web.dto.datatable.response;

import org.codehaus.jackson.annotate.JsonProperty;

import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;

public class StudentTableResponse {
	
	private String Result;
	
	private StudentTableBean Records;
	
	private String Message;

	public StudentTableResponse() {
		
	}
	
	public StudentTableResponse(String Result){
		this.Result = Result;
	}
	
	public StudentTableResponse(String Result, String Message){
		this.Message = Message;
		this.Result = Result;
	}
	
	public StudentTableResponse(String Result, StudentTableBean Records){
		this.Result = Result;
		this.Records = Records;
	}

	@JsonProperty("Result")
	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	@JsonProperty("Record")
	public StudentTableBean getRecords() {
		return Records;
	}

	public void setRecords(StudentTableBean records) {
		Records = records;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
	

}
