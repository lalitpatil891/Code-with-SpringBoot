
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


	/*	CREATE DEFINER=`root`@`localhost` PROCEDURE `p_get_JS_Details_By_sal_range`( in start float , in end float)
				BEGIN
	
				  select * from  jpa_js_tab  where  js_exp_salary>=start and js_exp_salary<=end;
	
				END
	*/
	
	@Override
	public List<JobSeeker> showAllJobSeekersByExpSalaryRange(double start, double end) {
	    //create  StoredProcedureQuery objet
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("p_get_JS_Details_By_sal_range",
				                                                                                                                                         JobSeeker.class);
		//register the parmeters
           query.registerStoredProcedureParameter(1,Double.class, ParameterMode.IN);
           query.registerStoredProcedureParameter(2,Double.class, ParameterMode.IN);
           
         //set the values to IN params
           query.setParameter(1, start);
           query.setParameter(2, end);
           //execute the logics  by calling PL/SQL procedure
           List<JobSeeker> list=query.getResultList();
         return  list;	
	}

}
