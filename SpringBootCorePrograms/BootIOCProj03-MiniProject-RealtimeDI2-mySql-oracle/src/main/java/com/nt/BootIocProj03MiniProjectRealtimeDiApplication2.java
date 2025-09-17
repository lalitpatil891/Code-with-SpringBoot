package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj03MiniProjectRealtimeDiApplication2 {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx =
				SpringApplication.run(BootIocProj03MiniProjectRealtimeDiApplication2.class, args);
		     Scanner sc = new Scanner(System.in)) {

			// get Controller
			PayrollMgmtOperationsController controller = ctx.getBean("payroll-controller", PayrollMgmtOperationsController.class);

			// Read inputs
			System.out.println("Enter ename:");
			String name = sc.next();

			System.out.println("Enter Desg:");
			String desg = sc.next();

			System.out.println("Enter salary:");
			Double salary = sc.nextDouble();

			System.out.println("Enter deptno (10,20,30,40):");
			Integer deptno = sc.nextInt();

			// Ask DB type
			System.out.println("Enter Database Type (oracle/mysql):");
			String dbType = sc.next().toLowerCase();

			// create employee obj
			Employee emp = new Employee();
			emp.setEname(name);
			emp.setJob(desg.toUpperCase());
			emp.setSalary(salary);
			emp.setDeptno(deptno);

			// call controller
			String msg = controller.appointEmployee(emp, dbType);

			// display
			System.out.println(msg);

		} catch (Exception e) {
			System.out.println("Internal problem::" + e.getMessage());
			e.printStackTrace();
		}
	}
}
