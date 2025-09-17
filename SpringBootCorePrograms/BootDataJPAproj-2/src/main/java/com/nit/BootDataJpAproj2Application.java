package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.entity.JobSeeker;
import com.nit.service.IJobSeekerService;

@SpringBootApplication
public class BootDataJpAproj2Application {

	public static void main(String[] args) {
		//Create IOC container
		ApplicationContext ctx = SpringApplication.run(BootDataJpAproj2Application.class, args);
		
		//get bean class
		IJobSeekerService service = ctx.getBean("jobSeekerService", IJobSeekerService.class);
		
		try {
			//create JobSeeker class Obj
			JobSeeker js = new JobSeeker();
			
			js.setName("Rahul");
			js.setAddress("Ranipur");
			js.setQlfy("B.tech");
			js.setExpSalary(9000.0);
			
			//invoke the b.method
			String resultMsg = service.registerJobSeeker(js);
			
			System.out.println(resultMsg);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext)ctx).close();
	
	}

}
