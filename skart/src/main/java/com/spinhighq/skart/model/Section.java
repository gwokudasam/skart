/*package com.spinhighq.skart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Section")

public class Section {
	
	private int id;
	private String section;
	private Set<StudentTable> student; 
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="section")
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@OneToMany(mappedBy="section")
		public Set<StudentTable> getStudent(){
			return student;
	}
	public void setStudent(Set<StudentTable> student){
		this.student=student;
	}
}
*/