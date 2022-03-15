package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepo;
import com.example.demo.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	private final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	private PatientRepo patientRepo;

	/* Saving and updating patient data */

	@Override
	public Patient savePatient(Patient patient) {

		return patientRepo.save(patient);

	}

	/* This method used for Insert bulk data */

	@Override
	public List<Patient> multiSavePatient(List<Patient> patient) {

		return patientRepo.saveAll(patient);

	}

	/* Fetching Patient Data By Using Name */

	@Override
	public List<Patient> filtterPatientDetails(String firstName) {

		List<Patient> patients = getAllPatient();

		return patients.stream().filter(p -> p.getFirstName().equals(firstName)).collect(Collectors.toList());

	}

	/* Fetching Patient Data By Using Id */

	@Override
	public Patient getPatientById(Long id) {

		logger.info("Enter Into Get Patient By Id Impl..!");

		Optional<Patient> pa = patientRepo.findById(id);
		if (pa.isPresent()) {
			return pa.get();
		} else {

			logger.info("Validation Fail, Raising The Exception..!");
			return null;
		}

	}

	/* Fetching All Patient Data */

	@Override
	public List<Patient> getAllPatient() {

		logger.info("Enter Into Get Patient  Impl..!");

		return patientRepo.findAll();
	}

	@Override
	public List<Patient> getData(Patient patient) {

		List<Patient> pa = getAllPatient();

		if (Objects.nonNull(patient.getFirstName()) && Objects.nonNull(patient.getLastName())
				&& Objects.nonNull(patient.getPhone())) {

			pa = pa.stream()
					.filter(p -> p.getFirstName().equalsIgnoreCase(patient.getFirstName())
							&& p.getLastName().equals(patient.getLastName())
							&& p.getDob().toString().equals(patient.getDob().toString()))
					.collect(Collectors.toList());

		}
		


		return pa;
	}

	@Override
	public List<Patient> featchingAllPatient(Patient patient) {

		List<Patient> pa = getAllPatient();

		if (Objects.nonNull(patient.getFirstName()) || Objects.nonNull(patient.getLastName())
				|| Objects.nonNull(patient.getPhone())) {

			pa = pa.stream().filter(p -> p.getFirstName().equalsIgnoreCase(patient.getFirstName())

					|| p.getLastName().equals(patient.getLastName())
					|| p.getPhone().longValue() == patient.getPhone().longValue()).distinct()
					.collect(Collectors.toList());

		}

		return pa;

	}

}
