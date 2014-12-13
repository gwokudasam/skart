/*package com.spinhighq.skart.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="className")
public class ClassName {
	
	private int id;
	private String className;
	private Set<StudentTable> student;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="className")
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@OneToMany(mappedBy="className")
		public Set<StudentTable> getStudent(){
			return student;
	}
	public void setStudent(Set<StudentTable> student){
		this.student=student;
	}

	

}
*/