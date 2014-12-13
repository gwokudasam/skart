package com.spinhighq.skart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spinhighq.skart.dao.EmployeeTableDao;
import com.spinhighq.skart.model.EmployeeTable;


@Repository
public class EmployeeTableDaoImpl implements EmployeeTableDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(EmployeeTable employeeTable) {
		sessionFactory.getCurrentSession().save(employeeTable);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeTable> listEmployees(int startIndex, int pageSize,
			String sortingOrder) {
		// TODO Auto-generated method stub
		return (List<EmployeeTable>) sessionFactory.getCurrentSession().createQuery("from EmployeeTable order by "+ sortingOrder).setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	@Override
	public void updateEmployee(EmployeeTable employeeTable) {
	
		sessionFactory.getCurrentSession().merge(employeeTable);
	}

	@Override
	public void removeEmployee(Integer id) {
		// TODO Auto-generated method stub
		
		EmployeeTable employeeTable=(EmployeeTable) sessionFactory.getCurrentSession().load(EmployeeTable.class, id);
 		if(null!=employeeTable){
 			sessionFactory.getCurrentSession().delete(employeeTable);
 		}
	}

	@Override
	public EmployeeTable getEmployee(Integer id) {
		
		EmployeeTable employeeTable=(EmployeeTable) sessionFactory.getCurrentSession().load(EmployeeTable.class, id);
				if(employeeTable !=null){
					return employeeTable;
		}
				else{
					return null;
				}
	}

	@Override
	public int getEmployeeCount() {
		int count = 0;
		try{
			count =((Long) sessionFactory.getCurrentSession().createQuery("select count(*) from EmployeeTable").uniqueResult()).intValue();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception is  "+e.getMessage());
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeTable> getEmployeeData() {
		// TODO Auto-generated method stub
		
		List<EmployeeTable> list=sessionFactory.getCurrentSession().createQuery("from EmployeeTable").list();
		
		return list;
	}

}
