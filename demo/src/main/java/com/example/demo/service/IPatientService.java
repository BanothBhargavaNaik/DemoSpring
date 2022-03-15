package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Patient;

public interface IPatientService {

	public Patient savePatient(Patient patient) ;

	List<Patient> multiSavePatient(List<Patient> patient);

	public List<Patient> filtterPatientDetails(String firstName);
	
	
	List<Patient> getData(Patient patient);
	
	
    List<Patient> featchingAllPatient(Patient patient);
	

	
	
	public Patient getPatientById(Long id) ;
	
	List<Patient> getAllPatient();


	
	
	
	

	

}
