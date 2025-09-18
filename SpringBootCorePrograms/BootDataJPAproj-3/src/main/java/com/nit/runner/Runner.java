package com.nit.runner;

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
		
		try {
			
			Long count = service.showDoctorsCount();
			Long countNew = count -1;
			
			System.out.println("Total Doctor Count is: "+countNew);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
