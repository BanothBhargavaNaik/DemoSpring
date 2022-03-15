package com.example.demo.dto;

import java.util.Date;
import java.util.Set;

import com.example.demo.entity.MedicalInfo;

public class PatientDto {

	private String firstName;

	private String lastName;

	private Date dob;

	private Long phone;
	
	private Set<MedicalInfo> medicalInfo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Set<MedicalInfo> getMedicalInfo() {
		return medicalInfo;
	}

	public void setMedicalInfo(Set<MedicalInfo> medicalInfo) {
		this.medicalInfo = medicalInfo;
	}

	@Override
	public String toString() {
		return "PatientDto [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", phone=" + phone
				+ ", medicalInfo=" + medicalInfo + "]";
	}
	
	



}
