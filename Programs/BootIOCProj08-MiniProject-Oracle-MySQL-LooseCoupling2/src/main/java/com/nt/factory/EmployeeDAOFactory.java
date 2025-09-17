package com.nt.factory;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.BootIocProj08LayeredAppMiniProjectRealtimeDIApplication;
import com.nt.dao.EmployeeMySQLDAOImpl;
import com.nt.dao.EmployeeOracleDAOImpl;
import com.nt.dao.IEmployeeDAO;


@Component("daoFactory")
public class EmployeeDAOFactory implements FactoryBean<IEmployeeDAO> {

   @Value("${dao.db}")
	private  String  db;
   
	@Autowired
	private   DataSource ds;

    
	@Override
	public IEmployeeDAO getObject() throws Exception {
		System.out.println("ds object class name::"+ds.getClass());
		switch(db) {
		 case "oracle":
			   return  new EmployeeOracleDAOImpl(ds);
		 case "mysql":
			   return  new  EmployeeMySQLDAOImpl(ds);
		  default:
			   throw  new IllegalArgumentException("Invalid dao");
		}
	
	}

	@Override
	public Class<?> getObjectType() {
		return IEmployeeDAO.class;
	}

}
