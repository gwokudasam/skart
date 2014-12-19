package com.spinhighq.skart.web.dto.datatable.bean;

import org.codehaus.jackson.annotate.JsonProperty;

/*import com.spinhighq.skart.model.ClassName;
import com.spinhighq.skart.model.Section;*/

public class EmployeeTableBean {
	
	private String employeeId;
	
	private String name;
	
	private String email;
	
	private String  dateOfBirth;
	
	private String className;
	
	private String bloadGroup;
	
	private String address;
	
	private String fatherName;
	
	private String mobilePhone;
		
	private String section;
	
	private Float currentAttendance;
	
	private Float overalAttendance;
	
	private Float performanceRating;
	
	private String dateOfJoning;
	
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
	
	@JsonProperty("EmployeeId")
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("DateOfBirth")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@JsonProperty("ClassName")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@JsonProperty("BloadGroup")
	public String getBloadGroup() {
		return bloadGroup;
	}

	public void setBloadGroup(String bloadGroup) {
		this.bloadGroup = bloadGroup;
	}

	@JsonProperty("Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("MobilePhone")
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@JsonProperty("FatherName")
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@JsonProperty("Section")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@JsonProperty("CurrentAttendance")
	public Float getCurrentAttendance() {
		return currentAttendance;
	}

	public void setCurrentAttendance(Float currentAttendance) {
		this.currentAttendance = currentAttendance;
	}

	@JsonProperty("OveralAttendance")
	public Float getOveralAttendance() {
		return overalAttendance;
	}

	public void setOveralAttendance(Float overalAttendance) {
		this.overalAttendance = overalAttendance;
	}

	@JsonProperty("PerformanceRating")
	public Float getPerformanceRating() {
		return performanceRating;
	}

	public void setPerformanceRating(Float performanceRating) {
		this.performanceRating = performanceRating;
	}
	
	@JsonProperty("DateOfJoning")	
	public String getDateOfJoning() {
		return dateOfJoning;
	}

	public void setDateOfJoning(String dateOfJoning) {
		this.dateOfJoning = dateOfJoning;
	}

	@JsonProperty("Photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@JsonProperty("Gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@JsonProperty("Department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@JsonProperty("Category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@JsonProperty("Position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@JsonProperty("Grade")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@JsonProperty("JobTitle")
	public String getJobTitle() {
		return jobTitle;
	}
	
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@JsonProperty("Qualification")
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@JsonProperty("MotherName")
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	
	@JsonProperty("ExperienceInfo")
	public String getExperienceInfo() {
		return experienceInfo;
	}

	public void setExperienceInfo(String experienceInfo) {
		this.experienceInfo = experienceInfo;
	}
	
	@JsonProperty("TotalExperience")
	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	@JsonProperty("MaritalStatus")
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	@JsonProperty("Nationality")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
	
	
	

	
}
