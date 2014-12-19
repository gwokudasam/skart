package com.spinhighq.skart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ParentTable")
public class ParentTable {
	
	private Integer id;
	
	private String name;
	
	private String dateOfBirth;
	
	private String relation;
	
	private String education;
	
	private String occupation;
	
	private Double income;
	
	private String presentAddress;
	
	private String permanentAddress;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String email;
	
	private Long mobilePhone;
	
	private String bloadGroup;

	public ParentTable() {
		super();
		
	}

	public ParentTable(Integer id, String name, String dateOfBirth,
			String relation, String education, String occupation,
			Double income, String presentAddress, String permanentAddress,
			String city, String state, String country, String email,
			Long mobilePhone, String bloadGroup) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.relation = relation;
		this.education = education;
		this.occupation = occupation;
		this.income = income;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.bloadGroup = bloadGroup;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="dateOfBirth")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name="relation")
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Column(name="education")
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name="occupation")
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name="income")
	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Column(name="presentAddress")
	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	@Column(name="permanentAddress")
	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="mobilePhone")
	public Long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name="bloadGroup")
	public String getBloadGroup() {
		return bloadGroup;
	}

	public void setBloadGroup(String bloadGroup) {
		this.bloadGroup = bloadGroup;
	}
	
	
	

}
