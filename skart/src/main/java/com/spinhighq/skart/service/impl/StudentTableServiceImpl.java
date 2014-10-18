package com.spinhighq.skart.service.impl;

import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spinhighq.skart.business.exception.StudentException;
import com.spinhighq.skart.dao.StudentTableDao;
import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.service.StudentTableService;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;


@Service
public class StudentTableServiceImpl implements StudentTableService {
	@Autowired
	private StudentTableDao tableDao;
	public StudentTableServiceImpl() {}
	
	public StudentTableServiceImpl(StudentTableDao tableDao) {
		
		this.tableDao = tableDao;
	}

	@Transactional
	public void addStudent(StudentTableBean bean) throws StudentException {
		
		try{
			StudentTable studentTable=new StudentTable();
			studentTable.setName(bean.getName());
			studentTable.setEmail(bean.getEmail());
			studentTable.setDateOfBirth(bean.getDateOfBirth().toString());
			//System.out.println("get dob"+bean.getDateOfBirth());
			studentTable.setClassName(bean.getClassName());
			studentTable.setBloadGroup(bean.getBloadGroup());
			studentTable.setAddress(bean.getAddress());
			studentTable.setParentName(bean.getParentName());
			studentTable.setMobilePhone(new Long(bean.getMobilePhone()));
			studentTable.setSection(bean.getSection());
			studentTable.setCurrentAttendance(new Float(bean.getCurrentAttendance()));
			studentTable.setOveralAttendance(new Float(bean.getOveralAttendance()));
			studentTable.setPerformanceRating(new Float(bean.getPerformanceRating()));
			studentTable.setPhoto(bean.getPhoto());
			tableDao.addStudent(studentTable);
		}
		catch(Exception e){
			throw new StudentException("Exception while adding record - "+ e.getMessage());
		}		
	}

	@Transactional
	public StudentTable getStudent(String id) throws StudentException {
		try{
			return tableDao.getStudent(new Integer(id));
		}
		catch(Exception e){
			throw new StudentException("Exception while getting Student with id-"+id+" "+e.getMessage());
		}
		
	}

	@Transactional
	public List<StudentTableBean> listStudents(int startIndex, int pageSize, String sortingOrder)
			throws StudentException {
		 List<StudentTableBean> list = new ArrayList<StudentTableBean>();
		 try{
			 List<StudentTable> studentTableList = tableDao.listStudents(startIndex, pageSize, sortingOrder);
			 for(StudentTable studentTable : studentTableList){
				 StudentTableBean bean = new StudentTableBean();
				 bean.setStudentId(studentTable.getId().toString());
				 bean.setName(studentTable.getName());
				 bean.setEmail(studentTable.getEmail());
				 bean.setDateOfBirth(studentTable.getDateOfBirth());
				 bean.setClassName(studentTable.getClassName());
				 bean.setBloadGroup(studentTable.getBloadGroup());
				 bean.setAddress(studentTable.getAddress());
				 bean.setParentName(studentTable.getParentName());
				 bean.setMobilePhone(studentTable.getMobilePhone().toString());
				 bean.setSection(studentTable.getSection());
				 bean.setCurrentAttendance(studentTable.getCurrentAttendance().floatValue());
				 bean.setOveralAttendance(studentTable.getOveralAttendance().floatValue());
				 bean.setPerformanceRating(studentTable.getPerformanceRating().floatValue());
				 bean.setPhoto(studentTable.getPhoto());
				 list.add(bean);				 
			 }
			
		 }
		 catch(Exception e){
			 throw new StudentException("Exception while listing expenses from - "+startIndex+" to "+pageSize+" - "+e.getMessage());
		 }
		return list;
	}

	@Transactional
	public void updateStudent(StudentTableBean bean) throws StudentException {
		try{
			StudentTable studentTable=tableDao.getStudent(new Integer(bean.getStudentId()));
			studentTable.setName(bean.getName());
			studentTable.setEmail(bean.getEmail());
			studentTable.setDateOfBirth(bean.getDateOfBirth());
			studentTable.setClassName(bean.getClassName());
			studentTable.setBloadGroup(bean.getBloadGroup());
			studentTable.setAddress(bean.getAddress());
			studentTable.setMobilePhone(new Long(bean.getMobilePhone()));
			studentTable.setParentName(bean.getParentName());
			studentTable.setSection(bean.getSection());
			studentTable.setCurrentAttendance(new Float(bean.getCurrentAttendance()));
			studentTable.setOveralAttendance(new Float(bean.getOveralAttendance()));
			studentTable.setPerformanceRating(new Float(bean.getPerformanceRating()));
			studentTable.setPhoto(bean.getPhoto());
			tableDao.updateStudent(studentTable);
			//System.out.println(tableDao);
		}
		catch(Exception e){
			throw new StudentException("Exception while updating the record "+e.getMessage());
		}	
	}

	@Transactional
	public void removeStudent(Integer id) throws StudentException {
		try{
			tableDao.removeStudent(id);
		}
		catch(Exception e){
			throw new StudentException("Exception while delete the student record "+e.getMessage());
		}
		
	}

	@Transactional
	public int getStudentCount() throws StudentException {
		try{
		return tableDao.getStudentCount();
		}
		catch(Exception e){
			throw new StudentException("Exception thrown while getting stusents count  "+e.getMessage());
		}
	}

	@Transactional
	public List<StudentTable> getStudentByClassNmae(String className) throws StudentException{
		try{
			return tableDao.getStudentByClassName(className);
		}
		catch(Exception e){
			throw new StudentException("Exception while get the ClassName"+e.getMessage());
			
		}
	}

}
