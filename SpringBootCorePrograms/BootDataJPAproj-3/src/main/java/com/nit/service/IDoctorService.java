package com.nit.service;

import com.nit.entity.Doctor;

public interface IDoctorService {

	public String registerDoctor(Doctor doctor);
	
	public long showDoctorsCount();

}
