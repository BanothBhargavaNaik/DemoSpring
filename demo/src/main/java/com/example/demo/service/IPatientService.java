package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ValidationException;

@Service
public interface IPatientService {
	
	public void savePatient(Patient patient ) throws ValidationException;

}
