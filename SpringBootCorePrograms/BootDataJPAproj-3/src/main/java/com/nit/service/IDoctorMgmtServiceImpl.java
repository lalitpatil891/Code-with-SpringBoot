package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

@Service("doctorService")
public class IDoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		return "Doctor obj is saved with id value " + doctorRepo.save(doctor).getDocid();
	}
	
	public long showDoctorsCount() {
		long count = doctorRepo.count();
		return 	count;
		
	}
	
}
