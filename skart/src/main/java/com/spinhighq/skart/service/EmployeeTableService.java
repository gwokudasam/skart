package com.spinhighq.skart.service;

import java.util.List;

import com.spinhighq.skart.business.exception.EmployeeException;
import com.spinhighq.skart.model.EmployeeTable;
import com.spinhighq.skart.web.dto.datatable.bean.EmployeeTableBean;

public interface EmployeeTableService {
	
	public void addEmployee(EmployeeTableBean bean)throws EmployeeException;
	
	public List<EmployeeTableBean> listEmployees(int startIndex,int pageSize, String sortingOrder)throws EmployeeException;
	
	public void updateEmployee(EmployeeTableBean bean)throws EmployeeException;
	
	public void removeEmployee(Integer id)throws EmployeeException;
	
	public EmployeeTable getEmployee(Integer id)throws EmployeeException;
	
	public int getEmployeeCount()throws EmployeeException;
	
	public List<EmployeeTable> getEmployeeData()throws EmployeeException;

}
