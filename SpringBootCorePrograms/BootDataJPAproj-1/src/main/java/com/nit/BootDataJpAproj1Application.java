package com.nit;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

@SpringBootApplication
public class BootDataJpAproj1Application {

	public static void main(String[] args) {

		//get IOC container
		ApplicationContext ctx= SpringApplication.run(BootDataJpAproj1Application.class, args);
	
		//get Service class obj
		IDoctorService service = ctx.getBean("doctorService",IDoctorService.class);
		
		try {
			//create Doctor class obeject
//			Doctor doctor = new Doctor();
//			doctor.setDocName("Mayur");
//			doctor.setSpecialization("MD-cardio");
//			doctor.setIncome(900000.0);
			
			Doctor doctor1 = new Doctor("Mahesh","cardio",70000.0);
			Doctor doctor2 = new Doctor("Gopal","cardio",60000.0);
			Doctor doctor3 = new Doctor("Sopan","cardio",50000.0);
			
			List<Doctor> list = List.of(doctor1, doctor2, doctor3);
			
			//invoke the b.method
//			String resultMsg= service.registerDoctor(doctor);
			
			String resultMsg = service.registerDoctorBatch(list);
			
			System.out.println(resultMsg);
			
			System.out.println("3 Id doctor exists?::"+service.cheakDoctorAvailbility(4));
			System.out.println("Doctors count is ::"+service.fetchDoctorsCount());
			
			
			//findAll
			Iterable<Doctor> it = service.showAllDoctors();
			it.forEach(doc -> System.out.println(doc));   //java 8 forEach() method
			//--------------------
			it.forEach(System.out::println);     //java 8 forEach() + Static method reference[BEST PRACTICE]
			//--------------------
			for(Doctor doc:it) {
				System.out.println(doc);    //java 5 endhanced fro loop
			}  
			//------------------------------
			StreamSupport.stream(it.spliterator(), false)
            .forEach(System.out::println);

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		//close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	
	}

}
