package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj05MiniProjetRealtimeDIApp1 {

	public static void main(String[] args) {
	
		EmployeeOperationsController controller=null;
		//read the desgs from the enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  Desg1::");
		String desg1=sc.next();
		System.out.println("Enter  Desg2::");
		String desg2=sc.next();
		System.out.println("Enter  Desg3::");
		String desg3=sc.next();
		
		//get IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj05MiniProjetRealtimeDiApp.class, args)){
		//  get Controller class obj ref
		 controller=ctx.getBean("empController",EmployeeOperationsController.class);
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
		}//try3
		catch(Exception e) {
			e.printStackTrace();
		}
		  }//try2
		  catch(Exception  e) {
			e.printStackTrace();
		  }
		}//try1
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}//main

}//class
