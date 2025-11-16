
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
	private  EntityManager  manager;

	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `p_authenticate`(in uid varchar(20),
	        in  pass  varchar(20),
	        out result varchar(20))
	BEGIN
	declare cnt int;
	select count(*) into  cnt where uname=uid and password=pass;
	if(cnt<>0) then
	set result='Valid Credentails';
	else 
	set result='Invalid Credentials';
	end if; 
	END*/

	
	
	@Override
	public String login(String user, String pwd) {
	    //create  StroreProcedureQury obj
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("p_authenticate");
		//register the  params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//set values to  IN params
		query.setParameter(1, user);
		query.setParameter(2, pwd);
		//call the PL/SQL procedure
		String result=(String) query.getOutputParameterValue(3);
		return result;
	}

}
