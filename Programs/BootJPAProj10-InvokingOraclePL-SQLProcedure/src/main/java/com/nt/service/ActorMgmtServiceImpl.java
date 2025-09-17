package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private  EntityManager   manager;
	
	/*create or replace PROCEDURE P_GET_ACTORS_BY_CATEGORIES 
	(
	  CAT1 IN VARCHAR2 
	, CAT2 IN VARCHAR2 
	, CAT3 IN VARCHAR2 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  OPEN DETAILS FOR
	     SELECT * FROM jpa_actor_tab1  where  actor_category in(cat1,cat2,cat3) order by  actor_category;
	  
	END P_GET_ACTORS_BY_CATEGORIES;
	*/
	@Override
	public List<Actor> showActorsByCategories(String cat1, String cat2, String cat3) {
		//create   StoredProcedureQuery  object
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("P_GET_ACTORS_BY_CATEGORIES",Actor.class);
		//register  the params of  PL/SQL procedure 
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, Object.class, ParameterMode.REF_CURSOR);
		//set Values to  IN Params
		query.setParameter(1, cat1);
		query.setParameter(2, cat2);
		query.setParameter(3, cat3);
		//execute the Query
		List<Actor>  list=query.getResultList();
		return list;
	}

}
