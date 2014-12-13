package com.spinhighq.skart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EmployeeTable")
public class EmployeeTable {
	
	
	private Integer id;
	
	private String name;;
	
	private String email;
	
	private String dateOfBirth;
	
	//private String className;
	//private ClassName className;
	
	private String dateOfJoning;
	
	private String bloadGroup;
	
	private String address;
	
	private String parentName;
	
	private Long mobilePhone;
	
	//private String section;
	//private Section section;
	
	private Float currentAttendance;
	
	private Float overalAttendance;
	
	private Float performanceRating;
	
	private String photo;
	
	
	private String gender;

	public EmployeeTable() {
		super();
		
	}

	public EmployeeTable(Integer id, String name, String email,
			String dateOfBirth, /*String className,*/ String dateOfJoning,
			String bloadGroup, String address, String parentName,
			Long mobilePhone, /*String section,*/ Float currentAttendance,
			Float overalAttendance, Float performanceRating, String photo, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		//this.className = className;
		this.dateOfJoning = dateOfJoning;
		this.bloadGroup = bloadGroup;
		this.address = address;
		this.parentName = parentName;
		this.mobilePhone = mobilePhone;
		//this.section = section;
		this.currentAttendance = currentAttendance;
		this.overalAttendance = overalAttendance;
		this.performanceRating = performanceRating;
		this.photo = photo;
		this.gender=gender;
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
	
	@Column(name="DateOfJoning")
	public String getDateOfJoning() {
		return dateOfJoning;
	}

	public void setDateOfJoning(String dateOfJoning) {
		this.dateOfJoning = dateOfJoning;
	}



	//@ManyToOne
    //@JoinColumn(name="class_id")
	/*@Column(name="className")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}*/

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

	//@ManyToOne
   // @JoinColumn(name="section_id")
	/*@Column(name="section")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
*/
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
	
	@Column(name="Gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
