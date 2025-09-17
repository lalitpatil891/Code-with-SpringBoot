//LoginMgmtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class LoginMgmtServiceImpl implements ILoginMgmtService {
	@Autowired
	private   EntityManager  manager;
	
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `p_authentication`(in uid varchar(20),in pass varchar(20), out result varchar(20))
			BEGIN
			declare cnt  int(10);
			   select  count(*) into cnt from  users_list  where uname=uid and  pwd=pass;
			   if (cnt<>0) then
			      set result="VALID CREDENTIALS";
			    else
			       set result="INVALID CREDENTIALS";
				end if;
			      
			END
	*/
	
	@Override
	public String autheticate(String username, String password) {
		
		//create StroredProcedureQuery object having PL/SQL procedure name
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("p_authentication");
	
		//register  the params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//set values  to query params
		query.setParameter(1, username);
		query.setParameter(2, password);
		//call the PL/SQL  Procedure
		String result= (String) query.getOutputParameterValue(3);
		return result;
	}

}
