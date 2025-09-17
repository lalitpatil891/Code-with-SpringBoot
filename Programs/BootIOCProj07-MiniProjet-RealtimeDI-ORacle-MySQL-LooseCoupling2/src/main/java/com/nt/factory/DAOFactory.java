package com.nt.factory;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.dao.IEmployeeDAO;
import com.nt.dao.MySQLEmployeeDAOImpl;
import com.nt.dao.OracleEmployeeDAOImpl;

@Component
public class DAOFactory implements FactoryBean<IEmployeeDAO> {
	@Value("${choose.dao}")
	private  String  daoId;
	@Autowired
	private DataSource ds;
	

	@Override
	public IEmployeeDAO getObject() throws Exception {
		if(daoId.equalsIgnoreCase("mysqlDAO"))
		  return  new MySQLEmployeeDAOImpl(ds);
		else if(daoId.equalsIgnoreCase("oracleDAO"))
			return  new OracleEmployeeDAOImpl(ds);
		else
			throw new IllegalArgumentException("invalid  DAO");
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return IEmployeeDAO.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
				}

}
