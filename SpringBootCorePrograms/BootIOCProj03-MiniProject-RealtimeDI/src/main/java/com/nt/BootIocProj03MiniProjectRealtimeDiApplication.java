package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj03MiniProjectRealtimeDiApplication {

	public static void main(String[] args) {

		//get access to IOC container
		ApplicationContext ctx = SpringApplication.run(BootIocProj03MiniProjectRealtimeDiApplication.class, args);
		
		//get Controller Spring class obj ref
		PayrollMgmtOperationsController controller = ctx.getBean("payroll-controller", PayrollMgmtOperationsController.class);
		
		//Read inputs from the enduser
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Desg1:");
		String desg1 = sc.next();
		
		System.out.println("Enter Desg2:");
		String desg2 = sc.next();
		
		System.out.println("Enter Desg3:");
		String desg3 = sc.next();
		
		
		//invoke the b.methods
		try {
			
			List<Employee> list = controller.showEmployeesByDesgs(desg1, desg2, desg3);
		
			//Display result
			System.out.println("Employees Belonging to "+desg1+", "+desg2+","+ desg3+" are:");
			
			list.forEach(emp ->{
				System.out.println(emp);
			});
			
		} catch (Exception e) {
			System.out.println("Internal problem::"+e.getMessage());
			e.printStackTrace();
		}
		
		//close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	}

}
