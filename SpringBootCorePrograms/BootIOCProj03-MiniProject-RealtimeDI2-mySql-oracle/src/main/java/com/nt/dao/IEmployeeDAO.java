package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
    List<Employee> showEmployeeByDesgs(String desg1, String desg2, String desg3, String dbType) throws Exception;
    int insertEmployee(Employee emp, String dbType) throws Exception;
}
