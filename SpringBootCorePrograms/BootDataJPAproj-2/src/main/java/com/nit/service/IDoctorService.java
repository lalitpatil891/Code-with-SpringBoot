package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Doctor;

public interface IDoctorService {

	public String registerDoctor(Doctor doctor);
	
	public long showDoctorsCount();
	
	public boolean isDoctorAvailable(int id);
	
	public String registerDoctorsBatch(List<Doctor> list);
	
	public Iterable<Doctor> showAllDoctors();
	
	public Iterable<Doctor> findDoctorsById(Iterable<Integer> ids);
	
	public Doctor findDoctorById(int id);
	
	public Optional<Doctor> showDoctorById(int id);
	
	public String updateDoctorName(int id, String name);
	
	public String delateDoctorById(int id);
	
	public String deleteDoctorByEntity(Doctor doctor);

	public String removeAllDoctors();
	
	public String removeDoctorsByIds(Iterable<Integer> ids);
}
