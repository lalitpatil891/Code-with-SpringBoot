package com.nit.service;

import java.util.List;

import com.nit.entity.Doctor;

public interface IDoctorService {

	String registerDoctor(Doctor doctor);
	public boolean cheakDoctorAvailbility(Integer id);
	public long fetchDoctorsCount();
	public String registerDoctorBatch(List<Doctor> list);
	
	public Iterable<Doctor> showAllDoctors();
	
	
	
	
}
