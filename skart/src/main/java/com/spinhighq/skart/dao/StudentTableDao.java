package com.spinhighq.skart.dao;

import java.util.List;



import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;

public interface StudentTableDao {
	
	/**
     * Add an student
     * @param student 
     */
	public void addStudent(StudentTable studentTable);
	
	/**
     * List all the student 
     * @param startIndex
     * @param pageSize
     * @return List of student
     */
	
	public List<StudentTable> listStudents(int startIndex,int pageSize, String sortingOrder);
	
	/**
     * update student
     * @param student 
     */
	
	public void updateStudent(StudentTable studentTable);
	
	/**
     * Remove an student with given id
     * @param id 
     */
	public void removeStudent(Integer id);
	
	 /**
     * Get student based on its id
     * @param id
     * @return 
     */
	
	public StudentTable getStudent(Integer id);
	
	/**
     * Get the student count
     * @return int
     */
	public int getStudentCount();
	
	//get the list of data from dataBase
	public List<StudentTable> getStudentData();
	
	public List<String> getStudentByClassName(String className);
	
	public List<StudentTable> getStudentTableData(String className,String section);
	

}
