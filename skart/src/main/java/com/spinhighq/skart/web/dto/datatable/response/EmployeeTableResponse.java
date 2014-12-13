package com.spinhighq.skart.web.dto.datatable.response;

import org.codehaus.jackson.annotate.JsonProperty;

import com.spinhighq.skart.web.dto.datatable.bean.EmployeeTableBean;

public class EmployeeTableResponse {
	
	private String Result;
	
	private EmployeeTableBean Records;
	
	private String Message;

	public EmployeeTableResponse() {
		
	}
	
	public EmployeeTableResponse(String Result){
		this.Result = Result;
	}
	
	public EmployeeTableResponse(String Result, String Message){
		this.Message = Message;
		this.Result = Result;
	}
	
	public EmployeeTableResponse(String Result, EmployeeTableBean Records){
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
	public EmployeeTableBean getRecords() {
		return Records;
	}

	public void setRecords(EmployeeTableBean records) {
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
