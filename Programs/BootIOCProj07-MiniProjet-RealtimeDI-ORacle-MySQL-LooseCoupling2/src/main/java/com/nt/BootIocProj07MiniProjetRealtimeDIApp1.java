package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class})
public class BootIocProj07MiniProjetRealtimeDIApp1 {
	@Autowired
	private Environment  env;
	
	
	@Bean(name="cds")
	public    ComboPooledDataSource  createC3PODs()throws Exception {
		ComboPooledDataSource  cds=new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		return cds;
	}

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
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj07MiniProjetRealtimeDIApp1.class, args)){
		//  get Controller class obj ref
		 controller=ctx.getBean("empController",EmployeeOperationsController.class);
		try {
			List<Employee>  list=controller.processEmployeeByDesgs(desg1, desg2, desg3);
			list.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println("=========================");
			System.out.println("The Bean ids are ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
		
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
