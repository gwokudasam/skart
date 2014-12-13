package com.spinhighq.skart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spinhighq.skart.business.exception.EmployeeException;
import com.spinhighq.skart.dao.EmployeeTableDao;
import com.spinhighq.skart.model.EmployeeTable;
import com.spinhighq.skart.service.EmployeeTableService;
import com.spinhighq.skart.web.dto.datatable.bean.EmployeeTableBean;

@Service
public class EmployeeTableServiceImpl implements EmployeeTableService {
	
	@Autowired
	private EmployeeTableDao employeeTableDao;
	
	public EmployeeTableServiceImpl(){
		
	}
	
	public EmployeeTableServiceImpl(EmployeeTableDao employeeTableDao){
		this.employeeTableDao=employeeTableDao;
	}

	@Override
	@Transactional
	public void addEmployee(EmployeeTableBean bean) throws EmployeeException {
		try{
			EmployeeTable employeeTable=new EmployeeTable();
			employeeTable.setName(bean.getName());
			employeeTable.setEmail(bean.getEmail());
			employeeTable.setAddress(bean.getAddress());
			/*employeeTable.setClassName(bean.getClassName());
			employeeTable.setSection(bean.getSection());*/
			employeeTable.setDateOfBirth(bean.getDateOfBirth());
			employeeTable.setBloadGroup(bean.getBloadGroup());
			employeeTable.setDateOfJoning(bean.getDateOfJoning());
			employeeTable.setCurrentAttendance(new Float(bean.getCurrentAttendance()));
			employeeTable.setOveralAttendance(new Float(bean.getOveralAttendance()));
			employeeTable.setPerformanceRating(new Float(bean.getPerformanceRating()));
			employeeTable.setParentName(bean.getParentName());
			employeeTable.setMobilePhone(new Long(bean.getMobilePhone()));
			employeeTable.setPhoto(bean.getPhoto());
			employeeTable.setGender(bean.getGender());
			employeeTableDao.addEmployee(employeeTable);
		}
		catch(Exception e){
			//e.printStackTrace();
			//System.out.println(e);
			throw new EmployeeException("Exception while adding record - "+ e.getMessage());
		}
		
		
	}

	@Override
	@Transactional
	public List<EmployeeTableBean> listEmployees(int startIndex, int pageSize,
			String sortingOrder) throws EmployeeException {
		List<EmployeeTableBean> list=new ArrayList<EmployeeTableBean>();
		try{
			List<EmployeeTable> employeeTableList=employeeTableDao.listEmployees(startIndex, pageSize, sortingOrder);
			for(EmployeeTable employeeTable:employeeTableList){
				EmployeeTableBean bean=new EmployeeTableBean();
				bean.setEmployeeId(employeeTable.getId().toString());
				bean.setName(employeeTable.getName());
				bean.setAddress(employeeTable.getAddress());
				/*bean.setClassName(employeeTable.getClassName());
				bean.setSection(employeeTable.getSection());*/
				bean.setBloadGroup(employeeTable.getBloadGroup());
				bean.setDateOfBirth(employeeTable.getDateOfBirth());
				bean.setDateOfJoning(employeeTable.getDateOfJoning());
				bean.setEmail(employeeTable.getEmail());
				bean.setMobilePhone(employeeTable.getMobilePhone().toString());
				bean.setOveralAttendance(employeeTable.getOveralAttendance().floatValue());
				bean.setCurrentAttendance(employeeTable.getCurrentAttendance().floatValue());
				bean.setPerformanceRating(employeeTable.getPerformanceRating().floatValue());
				bean.setParentName(employeeTable.getParentName());
				bean.setPhoto(employeeTable.getPhoto());
				bean.setGender(employeeTable.getGender());
				list.add(bean);
			}
			
		}
		catch(Exception e){
			//e.printStackTrace();
			//System.out.println(e);
			throw new EmployeeException("Exception while listing expenses from - "+startIndex+" to "+pageSize+" - "+e.getMessage());
		}
		return list;
	}

	@Override
	@Transactional
	public void updateEmployee(EmployeeTableBean bean) throws EmployeeException {
		try{
			EmployeeTable employeeTable=employeeTableDao.getEmployee(new Integer(bean.getEmployeeId()));
			employeeTable.setName(bean.getName());
			employeeTable.setAddress(bean.getAddress());
			/*employeeTable.setClassName(bean.getClassName());
			employeeTable.setSection(bean.getSection());*/
			employeeTable.setBloadGroup(bean.getBloadGroup());
			employeeTable.setDateOfBirth(bean.getDateOfBirth());
			employeeTable.setDateOfJoning(bean.getDateOfJoning());
			employeeTable.setEmail(bean.getEmail());
			employeeTable.setMobilePhone(new Long(bean.getMobilePhone()));
			employeeTable.setParentName(bean.getParentName());
			employeeTable.setCurrentAttendance(new Float(bean.getCurrentAttendance()));
			employeeTable.setOveralAttendance(new Float(bean.getOveralAttendance()));
			employeeTable.setPerformanceRating(new Float(bean.getOveralAttendance()));
			employeeTable.setPhoto(bean.getPhoto());
			employeeTable.setGender(bean.getGender());
			
			employeeTableDao.updateEmployee(employeeTable);
			
		}
		catch(Exception e){
			//e.printStackTrace();
			//System.out.println(e);
			throw new EmployeeException("Exception while updating the record "+e.getMessage());
		}
	}

	@Override
	@Transactional
	public void removeEmployee(Integer id) throws EmployeeException {
		try{
			employeeTableDao.removeEmployee(id);
		}
		catch(Exception e){
			//e.printStackTrace();
			//System.out.println(e);
			throw new EmployeeException("Exception while delete the student record "+e.getMessage());
		}
	}

	@Override
	@Transactional
	public EmployeeTable getEmployee(Integer id) throws EmployeeException {
		try{
			return employeeTableDao.getEmployee(new Integer(id));
		}
		catch(Exception e){
			e.printStackTrace();System.out.println(e);
			throw new EmployeeException("Exception while getting Student with id-"+id+" "+e.getMessage());
		}
		 
	}

	@Override
	@Transactional
	public int getEmployeeCount() throws EmployeeException {
		try{
			return employeeTableDao.getEmployeeCount();
		}
		catch(Exception e){
			//e.printStackTrace();
			throw new EmployeeException("Exception thrown while getting stusents count  "+e.getMessage());
		}
		
	}

	@Override
	@Transactional
	public List<EmployeeTable> getEmployeeData() throws EmployeeException {
			try{
				List<EmployeeTable> employeeList=employeeTableDao.getEmployeeData();
				return employeeList;
			}
			catch(Exception e){
				//e.printStackTrace();
				throw new EmployeeException("Exception while get the no data in the dable"+e.getMessage());
			}

		
	}
	
	
}
