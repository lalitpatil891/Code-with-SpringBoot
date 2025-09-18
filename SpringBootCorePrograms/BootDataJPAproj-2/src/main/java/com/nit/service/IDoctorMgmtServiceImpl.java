package com.nit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

import jakarta.transaction.Transactional;

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
		return count;
	}

	/*	Check doctor is available in the table by id*/
	@Override
	public boolean isDoctorAvailable(int id) {

		boolean isAvailable = doctorRepo.existsById(id);
		return isAvailable;
	}

	/*Register new Doctors batch in the table*/
	@Override
	@Transactional
	public String registerDoctorsBatch(List<Doctor> list) {
		String msg = null;
	
		if (list == null || list.isEmpty()) {
			return "No doctors to register!";
		}
	
		try {
			Iterable<Doctor> savedIterable = doctorRepo.saveAll(list);
			List<Doctor> savedList = StreamSupport.stream(savedIterable.spliterator(), false)
					.collect(Collectors.toList());
			msg = savedList.size() + "doctors registered successfully!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/*Show all Doctors from the table*/
	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	/*Show Doctors by id*/
	@Override
	public Iterable<Doctor> findDoctorsById(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}

	/*find doctor by id(single Record)*/
	@Override
	public Doctor findDoctorById(int id) {

		Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Doctor ID"));
		return doctor;
	}

	/*find doctr by id(using Optional)*/
	@Override
	public Optional<Doctor> showDoctorById(int id) {
		
//		Optional<Doctor> doctor = doctorRepo.findById(id);
		return doctorRepo.findById(id);
		
//		return doctor;
	}

//----------------------------Update Opereation -----------------------------------------
	/*Update name by using id*/
	@Override
	public String updateDoctorName(int id, String name) {

		Optional<Doctor> doc = doctorRepo.findById(id);
		String beforeName = doc.get().getDocName();
		if(doc.isPresent())
		{
			 doc.get().setDocName(name);
			 doctorRepo.save(doc.get());
			 return "Doctor name is Updated "+beforeName+" -> "+name;
		}
		else
		{
			return "Invalid id";
		}
	}
	
//----------------------------Delete Opereation -----------------------------------------
	
	/*deleteById()*/
	@Override
	public String delateDoctorById(int id) {
		
		Optional<Doctor> doctor = doctorRepo.findById(id);
		
		if(doctor.isPresent()) {
			
			doctorRepo.deleteById(id);
			return "Doctor Deleted Successfully.";
		}
		else
		{
			return "Invalid Id";
		}
		
	}

	/*delete Doctor by Entity*/
	@Override
	public String deleteDoctorByEntity(Doctor doctor) {
		int docId = doctor.getDocid();
		
		Optional<Doctor> dr = doctorRepo.findById(docId);
		
		if(dr.isPresent()) {
			
			doctorRepo.delete(doctor);
			return "Doctor deleted Successfully.";	
		}
		else
		{
			return "Doctor not found!";
		}
	}

	
	/*remove all doctors */
	public String removeAllDoctors() {
		
//		Iterator<Doctor> doctors= (Iterator<Doctor>) doctorRepo.findAll();
	
		if(doctorRepo.count() != 0) {
			doctorRepo.deleteAll();
			return "All Doctor Records are Deleted.";
		}
		else
		{
			return "No record found for Delation!";
		}
	}

	
	
	/*remove Multipule records by ids*/
	@Override
	public String removeDoctorsByIds(Iterable<Integer> ids) {

		//load the object by ids
		Iterable<Doctor> doctors = doctorRepo.findAllById(ids);
		
		long count = StreamSupport.stream(doctors.spliterator(),false).count();
		
		if(count != 0) {
		
			doctorRepo.deleteAllById(ids);
			return count+" doctor records Deleted Successfully!";
		}
		else
		{
			return "No doctors record found for delation!";
		}
	}
	
	

	
	

	
}
