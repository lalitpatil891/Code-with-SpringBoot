package com.nt.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private  IActorRepository  actorRepo;

	@Override
	public String removeActorsByIdsInBatch(List<Integer> ids) {
		//Load  objs by ids
		Iterable<Actor>  list=actorRepo.findAllById(ids);
		//get the count of loaded objs
		long count=StreamSupport.stream(list.spliterator(),false).count();
		if(count!=0) {
			actorRepo.deleteAllByIdInBatch(ids);
			return count+ "no.of Actors are found and deleted";
		}
		else {
			 return "Actors not found for deletion";
		}
	}
	
	@Override
	public List<Actor> showActorsByData(Actor actor,boolean ascOrder,String ...props) {
		//create Sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//create  Example object
		 Example<Actor> example=Example.of(actor);
		//use repo
		 List<Actor> list=actorRepo.findAll(example,sort);
		 return list;
		
	}
	
	@Override
	public Actor showActorById(int id) {
      return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid  id"));
	}
	
	@Override
	public Actor fetchActorById(int id) {
		Actor actor=actorRepo.getReferenceById(id);
		return actor;
	}

}
