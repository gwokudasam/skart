package com.spinhighq.skart.web.dto.datatable.bean;

import org.codehaus.jackson.annotate.JsonProperty;

/*import com.spinhighq.skart.model.ClassName;
import com.spinhighq.skart.model.Section;*/

public class StudentTableBean {
	
	private String studentId;
	
	private String name;
	
	private String email;
	
	private String  dateOfBirth;
	
	private String className;
	
	private String bloadGroup;
	
	private String address;
	
	private String parentName;
	
	private String mobilePhone;
		
	private String section;
	
	private Float currentAttendance;
	
	private Float overalAttendance;
	
	private Float performanceRating;
	
	private String dateOfJoning;
	
	private String photo;
	
	@JsonProperty("StudentId")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	@JsonProperty("ParentName")
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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
	
	

	
}
