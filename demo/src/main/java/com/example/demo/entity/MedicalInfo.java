package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medical_info")
public class MedicalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "problem")
	private String problem;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patients;

	@Override
	public String toString() {
		return "MedicalInfo [id=" + id + ", problem=" + problem + ", patient=" + patients + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Patient getPatient() {
		return patients;
	}

	public void setPatient(Patient patient) {
		this.patients = patient;
	}
}
