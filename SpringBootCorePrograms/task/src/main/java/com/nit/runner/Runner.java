package com.nit.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.User;
import com.nit.service.IUserService;

/**
 * Runner class to test various CRUD operations 
 * provided by the IDoctorService using CrudRepository.
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IUserService service;

    @Override
    public void run(String... args) throws Exception {

       

        // Register a single doctor
        
        try {
            Doctor doctor = new Doctor();
            doctor.setDocName("Sunil");
            doctor.setSpecialization("Ortho");
            doctor.setIncome(40000.0);

            String resultMsg = service.registerDoctor(doctor);
            System.out.println(resultMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

       
    }
}
