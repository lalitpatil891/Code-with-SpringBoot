package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService") 
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

    @Autowired
    private IEmployeeDAO empDAO;

    @Override
    public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3, String dbType) throws Exception {
        // convert inputs to upper case
        desg1 = desg1.toUpperCase();
        desg2 = desg2.toUpperCase();
        desg3 = desg3.toUpperCase();

        // use DAO with dbType
        List<Employee> list = empDAO.showEmployeeByDesgs(desg1, desg2, desg3, dbType);

        // business logic: calculate gross and net salary
        list.forEach(emp -> {
            emp.setGrossSalary(emp.getSalary() + (emp.getSalary() * 0.4));
            emp.setNetSalary(emp.getGrossSalary() - (emp.getGrossSalary() * 0.15));
        });

        return list;
    }

    @Override
    public String registerEmployee(Employee emp, String dbType) throws Exception {
        // use DAO with dbType
        int count = empDAO.insertEmployee(emp, dbType);
        return count == 0 ? "Employee not registered" : "Employee is registered";
    }
}
