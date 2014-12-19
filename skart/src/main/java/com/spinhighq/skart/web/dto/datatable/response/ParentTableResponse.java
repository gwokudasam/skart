package com.spinhighq.skart.web.dto.datatable.response;

import org.codehaus.jackson.annotate.JsonProperty;

import com.spinhighq.skart.web.dto.datatable.bean.ParentTableBean;

public class ParentTableResponse {
	
private String Result;
	
	private ParentTableBean Records;
	
	private String Message;

	public ParentTableResponse() {
		
	}
	
	public ParentTableResponse(String Result){
		this.Result = Result;
	}
	
	public ParentTableResponse(String Result, String Message){
		this.Message = Message;
		this.Result = Result;
	}
	
	public ParentTableResponse(String Result, ParentTableBean Records){
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
	public ParentTableBean getRecords() {
		return Records;
	}

	public void setRecords(ParentTableBean records) {
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
