package com.spinhighq.skart.web.dto.datatable.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.spinhighq.skart.model.ParentTable;
import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.web.dto.datatable.bean.ParentTableBean;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;

public class ParentTableListResponse {

private String Result;
	
	private String Message;
	
	private int TotalRecordCount;
	
	private List<ParentTableBean> Records;

	private List<ParentTable> parentTables;
	
	public ParentTableListResponse(String result, int totalRecordCount,
			List<ParentTableBean> records) {
		super();
		Result = result;
		TotalRecordCount = totalRecordCount;
		Records = records;
	}

	public ParentTableListResponse(String result, String message,
			int totalRecordCount,
			List<ParentTable> parentTables) {
		super();
		Result = result;
		Message = message;
		TotalRecordCount = totalRecordCount;
		this.parentTables = parentTables;
	}



	public ParentTableListResponse(String result, String message) {
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
	public List<ParentTableBean> getRecords() {
		return Records;
	}

	public void setRecords(List<ParentTableBean> records) {
		Records = records;
	}

	@JsonProperty("studentTables")
	public List<ParentTable> getParentTables() {
		return parentTables;
	}

	public void setParentTables(List<ParentTable> parentTables) {
		this.parentTables = parentTables;
	}
	

}
