package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.IPatientService;

@RestController
@RequestMapping("/patient-v1")
public class PatientController {

	private final static Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	IPatientService patientService;

	@PostMapping()
	public ResponseEntity<Patient> savePatient(Patient patient) throws ValidationException {

		logger.info("Enter Into Patient Controller");

		patientService.savePatient(patient);

		ResponseEntity<Patient> re = ResponseEntity.ok().body(patient);

		logger.info("Exit From Patient Controller");
		return re;

	}

	@PostMapping("/bulk")
	public ResponseEntity<List<Patient>> multiSavePatient(@RequestBody List<Patient> patient) {

		logger.info("Enter Into Patient Controller");

		patientService.multiSavePatient(patient);

		ResponseEntity<List<Patient>> re = ResponseEntity.ok().body(patient);

		logger.info("Exit From Patient Controller");

		return re;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {

		logger.info("Enter Into Patient Controller");

		Patient p = patientService.getPatientById(id);

		ResponseEntity<Patient> re = ResponseEntity.ok().body(p);

		logger.info("Exit From Patient Controller");

		return re;
	}

	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(Patient patient) {

		logger.info("Enter Into Patient Controller");

		List<Patient> p = patientService.getAllPatient();

		ResponseEntity<List<Patient>> re = ResponseEntity.ok().body(p);

		logger.info("Exit From Patient Controller");

		return re;
	}

	@GetMapping("details/{firstName}")
	public ResponseEntity<List<Patient>> patientDetailsByName(@PathVariable String firstName) {

		logger.info("Enter Into Patient Controller");

		List<Patient> p = patientService.filtterPatientDetails(firstName);

		ResponseEntity<List<Patient>> re = ResponseEntity.ok().body(p);

		logger.info("Exit From Patient Controller");

		return re;
	}

}
