package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.JobSeeker;
import com.nit.service.IJobSeekerService;

@Component  // Add this annotation
public class Runner implements CommandLineRunner {

    @Autowired 
    IJobSeekerService service;
	
    @Override
    public void run(String... args) throws Exception {
        try {
            //create JobSeeker class Obj
            JobSeeker js = new JobSeeker();
			
            js.setName("Rahul");
            js.setAddress("Ranipur");
            js.setQlfy("B.tech");
            js.setExpSalary(9000.0);
			
            //invoke the service method
            String resultMsg = service.registerJobSeeker(js);
			
            System.out.println(resultMsg);
			
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
