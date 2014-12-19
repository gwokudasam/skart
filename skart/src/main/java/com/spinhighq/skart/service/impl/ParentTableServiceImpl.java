package com.spinhighq.skart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spinhighq.skart.business.exception.ParentException;
import com.spinhighq.skart.dao.ParentTableDao;
import com.spinhighq.skart.model.ParentTable;
import com.spinhighq.skart.service.ParentTableService;
import com.spinhighq.skart.web.dto.datatable.bean.ParentTableBean;

@Service
public class ParentTableServiceImpl implements ParentTableService{
	
	@Autowired
	private ParentTableDao parentTableDao;
	
	public ParentTableServiceImpl() {
		
	}
	
	
	public ParentTableServiceImpl(ParentTableDao parentTableDao) {
		super();
		this.parentTableDao = parentTableDao;
	}


	@Override
	@Transactional
	public void addParent(ParentTableBean parentTableBean) throws ParentException {
		try{
			ParentTable parentTable=new ParentTable();
			parentTable.setName(parentTableBean.getName());
			parentTable.setDateOfBirth(parentTableBean.getDateOfBirth());
			parentTable.setBloadGroup(parentTableBean.getBloadGroup());
			parentTable.setRelation(parentTableBean.getRelation());
			parentTable.setEducation(parentTableBean.getEducation());
			parentTable.setOccupation(parentTableBean.getOccupation());
			parentTable.setIncome(new Double(parentTableBean.getIncome()));
			parentTable.setPresentAddress(parentTableBean.getPresentAddress());
			parentTable.setPermanentAddress(parentTableBean.getPermanentAddress());
			parentTable.setCity(parentTableBean.getCity());
			parentTable.setState(parentTableBean.getState());
			parentTable.setCountry(parentTableBean.getCountry());
			parentTable.setMobilePhone(new Long(parentTableBean.getMobilePhone()));
			parentTable.setEmail(parentTableBean.getEmail());
			
			parentTableDao.addParent(parentTable);
		}
		catch(Exception e){
			throw new ParentException("Exception while adding record - "+ e.getMessage());
		}
		
	}


	@Override
	@Transactional
	public List<ParentTableBean> listParents(int startIndex, int pageSize,
			String sortingOrder) throws ParentException {
		List<ParentTableBean> list = new ArrayList<ParentTableBean>();
		try{
			List<ParentTable> parentTableList = parentTableDao.listParents(startIndex, pageSize, sortingOrder);
			for(ParentTable parentTable:parentTableList){
				ParentTableBean parentTableBean=new ParentTableBean();
				parentTableBean.setParentId(parentTable.getId().toString());
				parentTableBean.setName(parentTable.getName());
				parentTableBean.setDateOfBirth(parentTable.getDateOfBirth());
				parentTableBean.setBloadGroup(parentTable.getBloadGroup());
				parentTableBean.setRelation(parentTable.getRelation());
				parentTableBean.setEducation(parentTable.getEducation());
				parentTableBean.setOccupation(parentTable.getOccupation());
				parentTableBean.setIncome(parentTable.getIncome().doubleValue());
				parentTableBean.setPresentAddress(parentTable.getPresentAddress());
				parentTableBean.setPermanentAddress(parentTable.getPermanentAddress());
				parentTableBean.setCity(parentTable.getCity());
				parentTableBean.setState(parentTable.getState());
				parentTableBean.setCountry(parentTable.getCountry());
				parentTableBean.setMobilePhone(parentTable.getMobilePhone().toString());
				parentTableBean.setEmail(parentTable.getEmail());
				
				list.add(parentTableBean);
				
			}
			
		}
		catch(Exception e){
			throw new ParentException("Exception while listing expenses from - "+startIndex+" to "+pageSize+" - "+e.getMessage());
		}
		return list;
	}


	@Override
	@Transactional
	public void updateParent(ParentTableBean parentTableBean)
			throws ParentException {
		try{
			ParentTable parentTable = parentTableDao.getParent(new Integer(parentTableBean.getParentId()));
			parentTable.setName(parentTableBean.getName());
			parentTable.setDateOfBirth(parentTableBean.getDateOfBirth());
			parentTable.setBloadGroup(parentTableBean.getBloadGroup());
			parentTable.setRelation(parentTableBean.getRelation());
			parentTable.setEducation(parentTableBean.getEducation());
			parentTable.setOccupation(parentTableBean.getOccupation());
			parentTable.setIncome(new Double(parentTableBean.getIncome()));
			parentTable.setPresentAddress(parentTableBean.getPresentAddress());
			parentTable.setPermanentAddress(parentTableBean.getPermanentAddress());
			parentTable.setCity(parentTableBean.getCity());
			parentTable.setState(parentTableBean.getState());
			parentTable.setCountry(parentTableBean.getCountry());
			parentTable.setMobilePhone(new Long(parentTableBean.getMobilePhone()));
			parentTable.setEmail(parentTableBean.getEmail());
			
			parentTableDao.updateParent(parentTable);
		}
		catch(Exception e){
			throw new ParentException("Exception while updating the record - "+ e.getMessage());
		}
		
	}


	@Override
	@Transactional
	public void removeParent(Integer id) throws ParentException {
		try{
			parentTableDao.removeParent(id);
			
		}
		catch(Exception e){
			throw new ParentException("Exception while removing the record - "+ e.getMessage());
		}
		
	}


	@Override
	@Transactional
	public ParentTable getParent(Integer id) throws ParentException {
		try{
			return parentTableDao.getParent(new Integer(id));
		}
		catch(Exception e){
			throw new ParentException("Exception while  getting Parent with id  record - "+ e.getMessage());
		}		
	}


	@Override
	@Transactional
	public int getParentCount() throws ParentException {
		try{
		return parentTableDao.getParentCount();
		}
		catch(Exception e){
			throw new ParentException("Exception thrown while getting parent count - "+ e.getMessage());
		}
	}


	@Override
	@Transactional
	public List<ParentTable> getParentData() throws ParentException {
		try{
			List<ParentTable> parentTableList=parentTableDao.getParentData();
			return parentTableList;
		}
		catch(Exception e){
			throw new ParentException("Exception thrown while getting parent data - "+ e.getMessage());
		}
		
	}

}
