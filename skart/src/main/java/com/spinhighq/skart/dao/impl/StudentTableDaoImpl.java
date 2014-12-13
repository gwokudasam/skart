package com.spinhighq.skart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spinhighq.skart.dao.StudentTableDao;
import com.spinhighq.skart.model.StudentTable;

@Repository
public class StudentTableDaoImpl implements StudentTableDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addStudent(StudentTable studentTable) {

		sessionFactory.getCurrentSession().save(studentTable);

	}

	@SuppressWarnings("unchecked")
	public List<StudentTable> listStudents(int startIndex, int pageSize,
			String sortingOrder) {

		return (List<StudentTable>) sessionFactory.getCurrentSession()
				.createQuery(" from StudentTable order by className,section, " + sortingOrder)
				.setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public void updateStudent(StudentTable studentTable) {
		sessionFactory.getCurrentSession().merge(studentTable);

	}

	public void removeStudent(Integer id) {
		StudentTable studentTable = (StudentTable) sessionFactory
				.getCurrentSession().load(StudentTable.class, id);
		if (null != studentTable) {
			sessionFactory.getCurrentSession().delete(studentTable);
		}

	}

	public int getStudentCount() {
		int count = 0;
		try {
			count = ((Long) sessionFactory.getCurrentSession()
					.createQuery("select count(*) from StudentTable")
					.uniqueResult()).intValue();
			// count = (Integer)
			// sessionFactory.getCurrentSession().createQuery("select count(*) from studentTable").uniqueResult();
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		return count;
	}

	public StudentTable getStudent(Integer id) {
		StudentTable studentTable = (StudentTable) sessionFactory
				.getCurrentSession().load(StudentTable.class, id);
		if (studentTable != null) {
			return studentTable;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getStudentByClassName(String className) {
		return sessionFactory.getCurrentSession().createQuery("select section from StudentTable where className=:className").setParameter("className", className).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	// get the list of student data from database table
	public List<StudentTable> getStudentData() {
		List<StudentTable> list=sessionFactory.getCurrentSession().createQuery("from StudentTable").list();
		return list;
				
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentTable> getStudentTableData(String className, String section) {
		return sessionFactory.getCurrentSession().createQuery("from StudentTable where className=:className and section=:section").setParameter("className",className).setParameter("section",section).list();
		
		 
	}

	

}
