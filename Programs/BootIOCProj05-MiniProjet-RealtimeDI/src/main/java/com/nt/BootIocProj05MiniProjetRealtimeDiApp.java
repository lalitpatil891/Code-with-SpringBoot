package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj05MiniProjetRealtimeDiApp {

	public static void main(String[] args) {
		System.out.println("BootIocProj05MiniProjetRealtimeDiApp.main()");
		//read the desgs from the enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  Desg1::");
		String desg1=sc.next();
		System.out.println("Enter  Desg2::");
		String desg2=sc.next();
		System.out.println("Enter  Desg3::");
		String desg3=sc.next();
		
		//get IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj05MiniProjetRealtimeDiApp.class, args);
		//  get Controller class obj ref
		EmployeeOperationsController controller=ctx.getBean("empController",EmployeeOperationsController.class);
		try {
			List<Employee>  list=controller.processEmployeeByDesgs(desg1, desg2, desg3);
			list.forEach(emp->{
				System.out.println(emp);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close  IOC container 
		ctx.close();
	}

}
