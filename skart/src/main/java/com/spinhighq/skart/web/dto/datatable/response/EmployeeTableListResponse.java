package com.spinhighq.skart.web.dto.datatable.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.spinhighq.skart.model.EmployeeTable;
import com.spinhighq.skart.web.dto.datatable.bean.EmployeeTableBean;

public class EmployeeTableListResponse {
	
	private String Result;
	
	private String Message;
	
	private int TotalRecordCount;
	
	private List<EmployeeTableBean> Records;

	private List<EmployeeTable> employeeTables;
	
	public EmployeeTableListResponse(String result, int totalRecordCount,
			List<EmployeeTableBean> records) {
		super();
		Result = result;
		TotalRecordCount = totalRecordCount;
		Records = records;
	}

	public EmployeeTableListResponse(String result, String message,
			int totalRecordCount,
			List<EmployeeTable> employeeTables) {
		super();
		Result = result;
		Message = message;
		TotalRecordCount = totalRecordCount;
		this.employeeTables = employeeTables;
	}



	public EmployeeTableListResponse(String result, String message) {
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
	public List<EmployeeTableBean> getRecords() {
		return Records;
	}

	public void setRecords(List<EmployeeTableBean> records) {
		Records = records;
	}

	@JsonProperty("employeeTables")
	public List<EmployeeTable> getEmployeeTables() {
		return employeeTables;
	}

	public void setEmployeeTables(List<EmployeeTable> employeeTables) {
		this.employeeTables = employeeTables;
	}
	
	

	
	
}
