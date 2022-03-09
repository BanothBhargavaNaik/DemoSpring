package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ValidationException;

public interface IPatientService {

	public void savePatient(Patient patient) throws ValidationException;

	public void multiSavePatient( List<Patient> patient);

	public List<Patient> filtterPatientDetails(String firstName);
	
	public List<Patient> filtterPatientDetails(String firstName, Long phone);
	
	public List<Patient> filtterPatientDetails(String firstName,String lastName, Long phone);
	
	

	
	public Patient getPatientById(Long id) ;
	
	List<Patient> getAllPatient();
	
	
	
	

	

}
