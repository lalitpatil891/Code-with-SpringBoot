package com.nit.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;   // ✅ Now valid

    @Override
    public String registerDoctor(Doctor doctor) {
        System.out.println("doc id(before save)::" + doctor.getDocName());

        Doctor doc = doctorRepo.save(doctor);  // save into DB
        
        return "Doctor obj is saved with id value " + doc.getDocid();
    }
    

	public boolean cheakDoctorAvailbility(Integer id) {
		return doctorRepo.existsById(id);
	}
	
	public long fetchDoctorsCount() {
		
		return doctorRepo.count();
	}


	@Override
	public String registerDoctorBatch(List<Doctor> list) {
	    // Save all doctors
	    Iterable<Doctor> savedList = doctorRepo.saveAll(list);

	    // Collect generated IDs
	    List<Integer> ids = StreamSupport.stream(savedList.spliterator(), false)
	                                     .map(Doctor::getDocid)
	                                     .collect(Collectors.toList());

	    return ids.size() + " doctors registered with IDs " + ids;
	}


	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	
	
	
	
}
