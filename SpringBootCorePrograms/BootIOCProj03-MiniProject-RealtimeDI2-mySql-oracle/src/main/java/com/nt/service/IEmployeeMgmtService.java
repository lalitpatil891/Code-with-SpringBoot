package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
    List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3, String dbType) throws Exception;
    String registerEmployee(Employee emp, String dbType) throws Exception;
}
