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
	
	private String fatherName;
	
	private Long mobilePhone;
	
	//private String section;
	//private Section section;
	
	private Float currentAttendance;
	
	private Float overalAttendance;
	
	private Float performanceRating;
	
	private String photo;
	
	private String gender;
	
	private String department;
	
	private String category;
	
	private String position;
	
	private String grade;
	
	private String jobTitle;
	
	private String qualification;
	
	private String motherName;
	
	private String experienceInfo;
	
	private String totalExperience;
	
	private String maritalStatus;
	
	private String nationality;

	public EmployeeTable() {
		super();
		
	}

	
	public EmployeeTable(Integer id, String name, String email,
			String dateOfBirth, String dateOfJoning, String bloadGroup,
			String address, String fatherName, Long mobilePhone,
			Float currentAttendance, Float overalAttendance,
			Float performanceRating, String photo, String gender,
			String department, String category, String position, String grade,
			String jobTitle, String qualification, String motherName,
			String experienceInfo, String totalExperience,
			String maritalStatus, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoning = dateOfJoning;
		this.bloadGroup = bloadGroup;
		this.address = address;
		this.fatherName = fatherName;
		this.mobilePhone = mobilePhone;
		this.currentAttendance = currentAttendance;
		this.overalAttendance = overalAttendance;
		this.performanceRating = performanceRating;
		this.photo = photo;
		this.gender = gender;
		this.department = department;
		this.category = category;
		this.position = position;
		this.grade = grade;
		this.jobTitle = jobTitle;
		this.qualification = qualification;
		this.motherName = motherName;
		this.experienceInfo = experienceInfo;
		this.totalExperience = totalExperience;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
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

	@Column(name="FathertName")
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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

	@Column(name="Department")
	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name="Category")
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="Position")
	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name="Grade")
	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Column(name="JobTitle")
	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name="Qualification")
	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name="MotherName")
	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Column(name="ExperienceInfo")
	public String getExperienceInfo() {
		return experienceInfo;
	}


	public void setExperienceInfo(String experienceInfo) {
		this.experienceInfo = experienceInfo;
	}

	@Column(name="TotalExperience")
	public String getTotalExperience() {
		return totalExperience;
	}


	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}
	
	@Column(name="MaritalStatus")
	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name="Nationality")
	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
}
