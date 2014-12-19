package com.spinhighq.skart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spinhighq.skart.dao.ParentTableDao;
import com.spinhighq.skart.model.ParentTable;

@Repository
public class ParentTableDaoImpl implements ParentTableDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addParent(ParentTable parentTable) {
		sessionFactory.getCurrentSession().save(parentTable);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ParentTable> listParents(int startIndex, int pageSize,
			String sortingOrder) {
		return (List<ParentTable>) sessionFactory.getCurrentSession().createQuery("from ParentTable order by "+ sortingOrder).setFirstResult(startIndex).setMaxResults(pageSize).list();
		
	}
	@Override
	public void updateParent(ParentTable parentTable) {
		sessionFactory.getCurrentSession().merge(parentTable);
		
	}
	@Override
	public void removeParent(Integer id) {
		ParentTable parentTable=(ParentTable) sessionFactory.getCurrentSession().load(ParentTable.class, id);
 		if(null!=parentTable){
 			sessionFactory.getCurrentSession().delete(parentTable);
 		}	
	}
	@Override
	public ParentTable getParent(Integer id) {
		ParentTable parentTable =(ParentTable) sessionFactory.getCurrentSession().load(ParentTable.class, id);
		if(parentTable!=null){
			return parentTable;
		}
		else{
			return null;
		}
	}
	@Override
	public int getParentCount() {
		int count = 0;
		try{
			count =((Long) sessionFactory.getCurrentSession().createQuery("select count(*) from ParentTable").uniqueResult()).intValue();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception is  "+e.getMessage());
		}
		return count;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<ParentTable> getParentData() {
		
		List<ParentTable> list=sessionFactory.getCurrentSession().createQuery("from ParentTable").list();
		
		return list;
	}

}
