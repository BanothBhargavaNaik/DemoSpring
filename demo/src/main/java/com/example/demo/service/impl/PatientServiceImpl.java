package com.example.demo.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.PatientRepo;
import com.example.demo.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	private final static Logger logger = LoggerFactory.getLogger(IPatientService.class);

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public void savePatient(Patient patient) throws ValidationException {

		logger.trace("Enter Into Save Patient Impl..!");

		Patient patient2 = patientRepo.findByFirstNameAndPhone(patient.getFirstName(), patient.getPhone());
		if (patient2 == null || (patient2.getId() != null && (patient2.getId() == patient.getId()))) {

			logger.info("Patient::" + patient2);
			logger.info("Validation Pass , Saving The Data..!");

			patientRepo.save(patient);
		} else {

			logger.info("Validation Fail, Raising The Exception..!");
			throw new ValidationException("Patient Details Existed..!");
		}
		logger.info("Exited From Save Patient Impl..!");
	}

	/* This method used for Insert bulk data */

	@Override
	public void multiSavePatient(List<Patient> patient) {
		

		patientRepo.saveAll(patient);

	}

	/* Fetching Patient Data By Using Name */

	@Override
	public List<Patient> filtterPatientDetails(String firstName) {
		logger.info("Enter Into Save Patient Impl..!");
		
		logger.info("first Name::"+firstName);
		
		List<Patient> patients = getAllPatient();
		
		logger.info("patients::"+patients);

		return patients.stream().filter(p -> p.getFirstName().equals(firstName)).collect(Collectors.toList());

		/* return patientRepo.findByFirstName(firstName); */

	}
	
	@Override
	public List<Patient> filtterPatientDetails(String firstName, Long phone) {
		
          logger.info("Enter Into Save Patient Impl..!");
		
		logger.info("first Name::"+firstName);
		
		List<Patient> patients = getAllPatient();
		
		logger.info("patients::"+patients);

		return patients.stream().filter(p -> (p.getFirstName().equals(firstName)) && (p.getPhone() == phone)).collect(Collectors.toList());
	}

	@Override
	public List<Patient> filtterPatientDetails(String firstName, String lastName, Long phone) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	/* Fetching Patient Data By Using Id */

	@Override
	public Patient getPatientById(Long id) {
		
		logger.info("Enter Into Get Patient By Id Impl..!");

		return patientRepo.findById(id).get();

	}

	/* Fetching All Patient Data */

	@Override
	public List<Patient> getAllPatient() {
		
		logger.info("Enter Into Get Patient  Impl..!");

		return patientRepo.findAll();
	}





}
