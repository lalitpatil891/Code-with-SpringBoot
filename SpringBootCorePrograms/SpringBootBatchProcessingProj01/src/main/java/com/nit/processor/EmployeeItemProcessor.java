package com.nit.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nit.entity.Employee;

@Component
public interface EmployeeItemProcessor extends ItemProcessor<Employee, Employee> {

	public Employee process(Employee emp) throws Exception {
		
		if(emp.getSalary()>=50000) {
			//calc gross and net salary
			emp.setGrossSalary(emp.getSalary()+emp.getSalary()*0.4);
			emp.setNetSalary(emp.getGrossSalary()-emp.getGrossSalary()*0.2);
		}
	}
}
