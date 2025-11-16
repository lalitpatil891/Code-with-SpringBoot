
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
	private  EntityManager  manager;

	/*CREATE OR REPLACE PROCEDURE P_GET_JS_DETAILS_BY_SAL_RANGE 
	(
	  STARTSALARY IN NUMBER 
	, ENDSALARY IN NUMBER 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  OPEN DETAILS FOR
	  SELECT * FROM JPA_JS_TAB  WHERE JS_EXP_SALARY>=STARTSALARY AND JS_EXP_SALARY<=ENDSALARY;
	
	END P_GET_JS_DETAILS_BY_SAL_RANGE; */
	
	
	@Override
	public List<JobSeeker> showAllJobSeekersByExpSalaryRange(double start, double end) {
	    //create  StoredProcedureQuery objet
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("P_GET_JS_DETAILS_BY_SAL_RANGE",
				                                                                                                                                         JobSeeker.class);
		//register the parmeters
           query.registerStoredProcedureParameter(1,Double.class, ParameterMode.IN);
           query.registerStoredProcedureParameter(2,Double.class, ParameterMode.IN);
           query.registerStoredProcedureParameter(3,Object.class, ParameterMode.REF_CURSOR);
           
         //set the values to IN params
           query.setParameter(1, start);
           query.setParameter(2, end);
           //execute the logics  by calling PL/SQL procedure
           List<JobSeeker> list=query.getResultList();
         return  list;	
	}

}
