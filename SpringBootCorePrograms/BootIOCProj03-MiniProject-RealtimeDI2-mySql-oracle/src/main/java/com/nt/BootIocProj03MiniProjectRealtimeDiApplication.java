package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj03MiniProjectRealtimeDiApplication {

	public static void main(String[] args) {

		// get access to IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootIocProj03MiniProjectRealtimeDiApplication.class, args);

		try (Scanner sc = new Scanner(System.in)) {
			// get Controller
			PayrollMgmtOperationsController controller = ctx.getBean("payroll-controller", PayrollMgmtOperationsController.class);

			// Read inputs
			System.out.println("Enter Desg1:");
			String desg1 = sc.next();

			System.out.println("Enter Desg2:");
			String desg2 = sc.next();

			System.out.println("Enter Desg3:");
			String desg3 = sc.next();

			// Ask which DB to use
			System.out.println("Enter Database Type (oracle/mysql):");
			String dbType = sc.next().toLowerCase();

			// invoke controller
			List<Employee> list = controller.showEmployeesByDesgs(desg1, desg2, desg3, dbType);

			// display
			System.out.println("Employees Belonging to " + desg1 + ", " + desg2 + ", " + desg3 + " from " + dbType + " DB:");
			list.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println("Internal problem::" + e.getMessage());
			e.printStackTrace();
		}
	}
}

