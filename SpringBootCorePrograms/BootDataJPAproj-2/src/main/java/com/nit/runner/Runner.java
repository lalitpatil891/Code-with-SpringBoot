package com.nit.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	IDoctorService service;

	@Override
	public void run(String... args) throws Exception {

		/*try { // create class Obj Doctor doctor = new Doctor();
		
			doctor.setDocName("Sunil");
			doctor.setSpecialization("ortho");
			doctor.setIncome(40000.0);
		
			// invoke the service method String resultMsg =
			service.registerDoctor(doctor);
		
			System.out.println(resultMsg);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

		/*//Count all doctors
		try {
			
			Long count = service.showDoctorsCount();
			Long countNew = count;
			
			System.out.println("Total Doctor Count is: "+count);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			//Is Doctor Available or not in table
			boolean isAvailable= service.isDoctorAvailable(13);
			
			if(isAvailable) {
				System.out.println("Doctor is Available");
			}
			else
			{
				System.out.println("doctor is not Available");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			
			List<Doctor> doctorList = new ArrayList<>();
			
			doctorList.add(new Doctor("Dr.Mayur Pawar", "Cardiologist", 40000.0));
			doctorList.add(new Doctor("Dr.Lalit Patil", "Cardiologist", 60000.0));
			doctorList.add(new Doctor("Dr.Rupesh modi", "Cardiologist", 80000.0));
			doctorList.add(new Doctor("Dr.Yogesh Mali", "Cardiologist", 70000.0));
			
			String msg = service.registerDoctorsBatch(doctorList);
			
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*Show all Doctors from the table*/
		/*try {
			Iterable<Doctor> doctorsList = service.showAllDoctors();
		//			
		//			List<Doctor> doctors = StreamSupport.stream(doctorsList.spliterator(), false)
		//											.collect(Collectors.toList());
			for(Doctor doctor : doctorsList) {
				System.out.println(doctor);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*Show Doctors by id*/
		/*	
			try {
				service.findDoctorsById(List.of(1,2,4)).forEach(System.out::println);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		*/

		/*find doctor by id(single Record)*/
		/*try {
			
			Doctor doctor = service.findDoctorById(2);
			System.out.println(doctor);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/

		/*find doctr by id(using Optional)*/
		/*try {
			Optional<Doctor> doctor = service.showDoctorById(2);
		
		//			List<Doctor> doct = doctor.stream().toList();
		//			System.out.println(doct);
			
			System.out.println(doctor.get());
			System.out.println(doctor.get().getDocName());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
//=================================Update Opereation ========================================
		
		/*Update name by using id*/
		/*try {
			String isUpdated=service.updateDoctorName(3, "Dr. Murlidar Patil");
			System.out.println(isUpdated);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
//================================= Delete Opereation =================================		
		
		/*delete by id*/
		/*try {
			String isDeleted = service.delateDoctorById(4);
			
			System.out.println(isDeleted);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*------------------delete Doctor by Entity---------------------*/
		/*try {
			Doctor dr = new Doctor();
			dr.setDocid(1);
			dr.setDocName("Dr.Mayur Pawar");
			dr.setSpecialization("Cardiologist");
			dr.setIncome(40000.0);
			
			System.out.println(service.deleteDoctorByEntity(dr));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*-----------------remove all doctors ------------------------*/
		
		/*try {
			System.out.println(service.removeAllDoctors());
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*-----------------remove all doctors by Ids ------------------------*/
		
		try {
			
			String msg = service.removeDoctorsByIds(List.of(6,7,8));			
			
			System.out.println(msg);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
