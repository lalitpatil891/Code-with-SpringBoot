package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.nt.BootIocProj13MiniProjetProfiles;
import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@Component
public class MiniProjectTestRunner implements CommandLineRunner {
	@Autowired
	private EmployeeOperationsController controller;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MiniProjectTestRunner.run()");
		//read the desgs from the enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  Desg1::");
		String desg1=sc.next();
		System.out.println("Enter  Desg2::");
		String desg2=sc.next();
		System.out.println("Enter  Desg3::");
		String desg3=sc.next();
		
		try {
			List<Employee>  list=controller.processEmployeeByDesgs(desg1, desg2, desg3);
			list.forEach(emp->{
				System.out.println(emp);
			});
		
		System.out.println("=============Regisration Process========================");
		System.out.println( "Enter name::");
		String name=sc.next();
		System.out.println( "Enter desg::");
		String desg=sc.next();
		System.out.println( "Enter salary::");
		float salary=sc.nextFloat();
		
		try {
			Employee emp=new Employee();
			emp.setEnmae(name); emp.setDesg(desg); emp.setSalary(salary);
			String msg=controller.addEmployee(emp);
			System.out.println(msg);
			
		}//try2
		catch(Exception e) {
			e.printStackTrace();
		}
		  }//try1
		  catch(Exception  e) {
			e.printStackTrace();
		  }
		
	}

}
