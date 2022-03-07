package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.PatientRepo;
import com.example.demo.service.IPatientService;

public class PatientServiceImpl implements IPatientService  {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(IPatientService.class);

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public void savePatient(Patient patient) throws ValidationException {
		
		LOGGER.trace("Enter Into Save Patient Impl..!");

		Patient patient2 = patientRepo.FindByNameAndPhone(patient.getName(), patient.getPhone());
		if (patient2 == null || (patient2.getId() != null && (patient2.getId() == patient.getId()))) {
			
			LOGGER.debug("Patient::"+patient2);
			LOGGER.info("Validation Pass , Saving The Data..!");

			patientRepo.save(patient);
		} else {
			
			LOGGER.warn("Validation Fail, Raising The Exception..!");
			throw new ValidationException("Patient Details Existed..!");
		}
		LOGGER.trace("Exited From Save Patient Impl..!");
	}

}