package com.spinhighq.skart.dao;

import java.util.List;

import com.spinhighq.skart.model.ParentTable;

public interface ParentTableDao {
	
	/**
     * Add an student
     * @param student 
     */
	public void addParent(ParentTable parentTable);
	
	/**
     * List all the student 
     * @param startIndex
     * @param pageSize
     * @return List of student
     */
	
	public List<ParentTable> listParents(int startIndex,int pageSize, String sortingOrder);
	
	/**
     * update student
     * @param student 
     */
	
	public void updateParent(ParentTable parentTable);
	
	/**
     * Remove an student with given id
     * @param id 
     */
	public void removeParent(Integer id);
	
	 /**
     * Get student based on its id
     * @param id
     * @return 
     */
	
	public ParentTable getParent(Integer id);
	
	/**
     * Get the student count
     * @return int
     */
	public int getParentCount();
	
	//get the list of data from dataBase
	public List<ParentTable> getParentData();


}
