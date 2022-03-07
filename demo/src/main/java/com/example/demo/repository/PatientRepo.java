package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
	
	public Patient FindByNameAndPhone(String name, Long phone);

}