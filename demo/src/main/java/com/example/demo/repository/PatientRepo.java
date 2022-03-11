package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
	
	
	public Patient findByFirstNameAndPhone(String name, Long phone);
	
	public Patient findByFirstName(String name);
	
	List<Patient> findByFirstNameLike(String firstName);
	
	
	

}
