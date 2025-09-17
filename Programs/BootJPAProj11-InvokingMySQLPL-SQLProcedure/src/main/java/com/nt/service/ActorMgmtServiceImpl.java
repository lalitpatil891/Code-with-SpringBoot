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
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `p_get_actors_by_categories`(in cat1 varchar(10),in cat2 varchar(10), in cat3 varchar(10))
			BEGIN
			select *  from  jpa_actor_tab1  where actor_category in(cat1,cat2,cat3) order by actor_category;
	
			END*/
	
	@Override
	public List<Actor> showActorsByCategories(String cat1, String cat2, String cat3) {
		//create   StoredProcedureQuery  object
		StoredProcedureQuery  query=manager.createStoredProcedureQuery("p_get_actors_by_categories",Actor.class);
		//register  the params of  PL/SQL procedure 
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		//set Values to  IN Params
		query.setParameter(1, cat1);
		query.setParameter(2, cat2);
		query.setParameter(3, cat3);
		//execute the Query
		List<Actor>  list=query.getResultList();
		return list;
	}

}
