package com.spinhighq.skart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spinhighq.skart.dao.StudentTableDao;
import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;

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
				.createQuery(" from StudentTable order by " + sortingOrder)
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
	public List<StudentTable> getStudentByClassName(String className) {
		List<StudentTable> studentTable = (List<StudentTable>) sessionFactory
				.getCurrentSession()
				.createQuery("from StudentTable where className=:className")
				.setParameter("className", className).list();
		return studentTable;

	}

}
