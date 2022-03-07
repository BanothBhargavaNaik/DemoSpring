package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.impl.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@PostMapping
	public ResponseEntity<Patient> savePatient(Patient patient) throws ValidationException {

		LOGGER.trace("Enter Into Patient Controller");

		patientServiceImpl.savePatient(patient);

		ResponseEntity<Patient> re = ResponseEntity.ok().body(patient);

		LOGGER.trace("Exit From Patient Controller");
		return re;

	}

}
