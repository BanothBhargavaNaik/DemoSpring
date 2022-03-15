package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Patient;
import com.example.demo.service.IPatientService;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

	private final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	IPatientService patientService;
	
	
	
	@PostMapping("/postpatient")
	public ResponseEntity<Patient> postPatient(@RequestBody  Patient patient) {
        
		patientService.savePatient(patient);

		return ResponseEntity.ok().body(patient);

	}
	
	
	
	

	@PostMapping("/patient")
	public ResponseEntity<PatientDto> savePatient(@RequestBody  PatientDto patientDto) {
        
        // convert DTO to entity
		Patient patientRequest = modelMapper.map(patientDto, Patient.class);

       Patient patient = patientService.savePatient(patientRequest);

       // convert entity to DTO
		PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);

		return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);

	}


	@PostMapping("/bulk")
	public ResponseEntity<List<Patient>> multiSavePatient(@RequestBody List<Patient> patient) {

		
		
		patientService.multiSavePatient(patient);

		return ResponseEntity.ok().body(patient);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {

		Patient p = patientService.getPatientById(id);

		return ResponseEntity.ok().body(p);
	}

	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(Patient patient) {

		List<Patient> p = patientService.getAllPatient();

		return ResponseEntity.ok().body(p);

	}

	@GetMapping("/details/{firstName}")
	public ResponseEntity<List<Patient>> patientDetailsByName(@PathVariable String firstName) {

		List<Patient> p = patientService.filtterPatientDetails(firstName);

		return ResponseEntity.ok().body(p);
	}

	@PostMapping("/all")
	public ResponseEntity<List<Patient>> getData(@RequestBody Patient patient) {

		logger.info("Enter Into Patient Controller");

		List<Patient> p = patientService.getData(patient);

		ResponseEntity<List<Patient>> re = ResponseEntity.ok().body(p);

		logger.info("Exit From Patient Controller");

		return re;
	}

	@PostMapping("/recordPatient")
	public ResponseEntity<List<Patient>> getByField(@RequestBody Patient patient) {

		logger.info("Enter Into Patient Controller");

		List<Patient> p = patientService.featchingAllPatient(patient);

		ResponseEntity<List<Patient>> re = ResponseEntity.ok().body(p);

		logger.info("Exit From Patient Controller");

		return re;
	}
}
