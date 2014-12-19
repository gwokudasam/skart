package com.spinhighq.skart.service;

import java.util.List;

import com.spinhighq.skart.business.exception.ParentException;
import com.spinhighq.skart.model.ParentTable;
import com.spinhighq.skart.web.dto.datatable.bean.ParentTableBean;

public interface ParentTableService {
	
	public void addParent(ParentTableBean parentTableBean) throws ParentException;
	
	public List<ParentTableBean> listParents(int startIndex,int pageSize, String sortingOrder)throws ParentException;
	
	public void updateParent(ParentTableBean parentTableBean)throws ParentException;
	
	public void removeParent(Integer id)throws ParentException;
	
	public ParentTable getParent(Integer id)throws ParentException;
	
	public int getParentCount()throws ParentException;
	
	public List<ParentTable> getParentData()throws ParentException;

}
