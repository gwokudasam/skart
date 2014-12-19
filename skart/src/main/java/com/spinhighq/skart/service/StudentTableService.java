package com.spinhighq.skart.service;

import java.util.List;

import com.spinhighq.skart.business.exception.StudentException;
import com.spinhighq.skart.model.ClassName;
import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;

public interface StudentTableService {
	
	public void addStudent(StudentTableBean bean) throws StudentException;
	
	public StudentTable getStudent(String id) throws StudentException;
	
	public List<StudentTableBean> listStudents(int startIndex, int pageSize, String sortingOrder) throws StudentException;
	
	public void updateStudent(StudentTableBean bean)throws StudentException;
	
	public void removeStudent(Integer id)throws StudentException;
	
	public int getStudentCount()throws StudentException;

	public List<String> getStudentByClassName(String className) throws StudentException;
	
	//get the list of student data from dataBase  
	public List<StudentTable> getStudentData()throws StudentException;
	
	public List<StudentTableBean> getStudentTableData(String className,String section)throws StudentException;
	
	public List<String> getClassNameData(String className)throws StudentException;
	
	
	

}
