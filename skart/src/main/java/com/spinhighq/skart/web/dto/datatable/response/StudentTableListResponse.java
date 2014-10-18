package com.spinhighq.skart.web.dto.datatable.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;

public class StudentTableListResponse {
	
	private String Result;
	
	private String Message;
	
	private int TotalRecordCount;
	
	private List<StudentTableBean> Records;

	private List<StudentTable> studentTables;
	
	public StudentTableListResponse(String result, int totalRecordCount,
			List<StudentTableBean> records) {
		super();
		Result = result;
		TotalRecordCount = totalRecordCount;
		Records = records;
	}

	public StudentTableListResponse(String result, String message,
			int totalRecordCount,
			List<StudentTable> studentTables) {
		super();
		Result = result;
		Message = message;
		TotalRecordCount = totalRecordCount;
		this.studentTables = studentTables;
	}



	public StudentTableListResponse(String result, String message) {
		super();
		Result = result;
		Message = message;
	}

	@JsonProperty("Result")
	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}
	
	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	@JsonProperty("TotalRecordCount")
	public int getTotalRecordCount() {
		return TotalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		TotalRecordCount = totalRecordCount;
	}

	@JsonProperty("Records")
	public List<StudentTableBean> getRecords() {
		return Records;
	}

	public void setRecords(List<StudentTableBean> records) {
		Records = records;
	}

	@JsonProperty("studentTables")
	public List<StudentTable> getStudentTables() {
		return studentTables;
	}

	public void setStudentTables(List<StudentTable> studentTables) {
		this.studentTables = studentTables;
	}
	
	

	
	
}
