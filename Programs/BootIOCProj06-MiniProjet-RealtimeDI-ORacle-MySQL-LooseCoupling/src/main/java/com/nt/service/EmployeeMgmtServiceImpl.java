package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	@Qualifier("dao")
	private  IEmployeeDAO  empDAO;

	@Override
	public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.fetchEmployeesByDesgs()");
		//  convert  given desgs to  uppercase letters
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		//use DAO
		List<Employee>  list=empDAO.showEmployessByDesgs(desg1, desg2, desg3);
		// calculate  grossSalary and netSalary of the employee
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+ (emp.getSalary()*0.5f));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2f));
		});
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		//use DAO
		int result=empDAO.insert(emp);
		return result==0?"Employee not Inserted":"Employee is inserted";
	}
	
	

}
