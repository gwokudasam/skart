package com.spinhighq.skart.dao;

import java.util.List;

import com.spinhighq.skart.model.EmployeeTable;

public interface EmployeeTableDao {
	
	/**
     * Add an student
     * @param student 
     */
	public void addEmployee(EmployeeTable employeeTable);
	
	/**
     * List all the student 
     * @param startIndex
     * @param pageSize
     * @return List of student
     */
	
	public List<EmployeeTable> listEmployees(int startIndex,int pageSize, String sortingOrder);
	
	/**
     * update student
     * @param student 
     */
	
	public void updateEmployee(EmployeeTable employeeTable);
	
	/**
     * Remove an student with given id
     * @param id 
     */
	public void removeEmployee(Integer id);
	
	 /**
     * Get student based on its id
     * @param id
     * @return 
     */
	
	public EmployeeTable getEmployee(Integer id);
	
	/**
     * Get the student count
     * @return int
     */
	public int getEmployeeCount();
	
	//get the list of data from dataBase
	public List<EmployeeTable> getEmployeeData();

}
