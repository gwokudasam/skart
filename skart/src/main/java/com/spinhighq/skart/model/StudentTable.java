package com.spinhighq.skart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "studentTable")
public class StudentTable {
	
	
	private Integer id;
	
	private String name;;
	
	private String email;
	
	private String dateOfBirth;
	
	private String className;
	
	private String bloadGroup;
	
	private String address;
	
	private String parentName;
	
	private Long mobilePhone;
	
	private String section;
	
	private Float currentAttendance;
	
	private Float overalAttendance;
	
	private Float performanceRating;
	
	private byte[] photo;
	

	public StudentTable() {
		super();
		
	}
	
	public StudentTable(Integer id, String name, String email,
			String dateOfBirth, String className, String bloadGroup,
			String address, String parentName, Long mobilePhone,
			String section, Float currentAttendance, Float overalAttendance,
			Float performanceRating, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.className = className;
		this.bloadGroup = bloadGroup;
		this.address = address;
		this.parentName = parentName;
		this.mobilePhone = mobilePhone;
		this.section = section;
		this.currentAttendance = currentAttendance;
		this.overalAttendance = overalAttendance;
		this.performanceRating = performanceRating;
		this.photo = photo;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="DateOfBirth ")
	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	@Column(name="ClassName")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name="BloadGroup")
	public String getBloadGroup() {
		return bloadGroup;
	}

	public void setBloadGroup(String bloadGroup) {
		this.bloadGroup = bloadGroup;
	}

	@Column(name="Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="MobilePhone")
	public Long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name="ParentName")
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name="Section")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Column(name="CurrentAttendance")
	public Float getCurrentAttendance() {
		return currentAttendance;
	}

	public void setCurrentAttendance(Float currentAttendance) {
		this.currentAttendance = currentAttendance;
	}

	@Column(name="OveralAttendance")
	public Float getOveralAttendance() {
		return overalAttendance;
	}

	public void setOveralAttendance(Float overalAttendance) {
		this.overalAttendance = overalAttendance;
	}

	@Column(name="PerformanceRating")
	public Float getPerformanceRating() {
		return performanceRating;
	}

	public void setPerformanceRating(Float performanceRating) {
		this.performanceRating = performanceRating;
	}
	
	@Column(name="photo")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	
	
	

}
