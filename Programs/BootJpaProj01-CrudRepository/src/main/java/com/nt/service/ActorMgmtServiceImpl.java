package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.error.ActorNotFoundException;
import com.nt.repository.IActorRepository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private   IActorRepository  actorRepo;

	@Override
	public String registerActor(Actor actor) {
		System.out.println("actorRepo obj class name::"+actorRepo.getClass()+" .....\r\n  "
	                                           +Arrays.toString(actorRepo.getClass().getInterfaces())+"....."+Arrays.toString(actorRepo.getClass().getDeclaredMethods()));
		
		//save the object
		Actor savedActor=actorRepo.save(actor);
		//get  the generated id value
		int idVal=savedActor.getAid();
		return "Actor is registered with the id value ::"+idVal;
	}

	@Override
	public long showActorsCount() {
		// use repo
		long count=actorRepo.count();
		return count;
	}
	
	/*@Override
	public String registerActors(List<Actor> list) {
		//use  repo
		Iterable<Actor>  actorsList=actorRepo.saveAll(list);
		List<Integer> ids=new ArrayList();
		actorsList.forEach(actor->{
			ids.add(actor.getAid());
		});
		
		return ids.size()+"  no.of  actors are saved with the id Values:: "+ids;
	}*/
	
	@Override
	public String registerActors(List<Actor> list) {
		//use  repo
		Iterable<Actor>  actorsList=actorRepo.saveAll(list);
		//get  id values  of the saved objects
		List<Integer> ids=StreamSupport.stream(actorsList.spliterator(), false).map(Actor::getAid).collect(Collectors.toList());
		return ids.size()+"  no.of  actors are saved with the id Values:: "+ids;
   }
	
	@Override
	public String isActorExistById(int id) {
		//use repo
		boolean  flag=actorRepo.existsById(id);
		return flag==true?id+" id Actor is available": id+" id Actor is not found";
	}
	
	@Override
	public Iterable<Actor> showAllActors() {
		//use repo
		Iterable<Actor>  list=actorRepo.findAll();
		List<Actor> list1=StreamSupport.stream(list.spliterator(), false).sorted((a1,a2)->a1.getAname().compareTo(a2.getAname())).collect(Collectors.toList());
		return list1;
	}
	
	@Override
	public Iterable<Actor> showActorsByIds(Iterable<Integer> ids) {
	   //use repo
		return actorRepo.findAllById(ids);
	}
	
	@Override
	public Optional<Actor> showActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		return opt;
	}
	
	/*@Override
	public Actor findActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			Actor actor=opt.get();
			return actor;
		}
		else {
		   //throw  new IllegalArgumentException("Invalid  id");	
			throw new ActorNotFoundException("invalid  ");
		}
	}
	*/
	
	@Override
	public Actor findActorById(int id) {
	  return actorRepo.findById(id).orElseThrow(()->new ActorNotFoundException("Invalid Id"));
	}
	
	@Override
	public Actor fetchActorById(int id) {
	  return actorRepo.findById(id).orElse(new Actor(1,"Local Actor","hyd","artist",5000.0));
	}

	@Override
	public String updateActorFee(int aid, float hikePercent) {
		//load  object
		Optional<Actor>  opt=actorRepo.findById(aid);
		if(opt.isPresent()) {
			Actor  actor=opt.get();
			//calculte the new few
			double newFee=actor.getFee()+(actor.getFee()*hikePercent/100.0);
			actor.setFee(newFee);
			//update the fee
			actorRepo.save(actor);
			return  aid +" Actor Fee is  updated to  "+newFee;
		}
		return aid+" Actor is not found for updation";
	}
	
	@Override
	public String registerOrUpdateActor(Actor actor) {
		//use Repo
		boolean flag=actorRepo.existsById(actor.getAid());
		actorRepo.save(actor);
		return flag?"Actor Details are updated":"Actor Details are saved/registered";
	}
	
	@Override
	public String removeActorById(int aid) {
		//Load the object
		Optional<Actor>  opt=actorRepo.findById(aid);
		if(opt.isPresent()) {
			Actor actor=opt.get();
			actorRepo.deleteById(aid);
			return  aid+" Actor is found  and deleted";
		}
		return aid+"Actor  is not found for deletion";
	}
	
	@Override
	public String removeActor(Actor actor) {
		//check  object
		boolean flag=actorRepo.existsById(actor.getAid());
		if(flag) {
			actorRepo.delete(actor);
			return "Actor found and deleted";
		}
		return "Actor not found for deletion";
	}
	
	@Override
	public String removeActorsByIds(List<Integer> ids) {
		//Load objs
		 Iterable<Actor>  it=actorRepo.findAllById(ids);
		 long count=StreamSupport.stream(it.spliterator(), false).count();
		 actorRepo.deleteAllById(ids);
		return count==0?"No Records found":count+" no.of records are deleted";
	}
	
	@Override
	public String removeAllActors() {
		long count=actorRepo.count();
		actorRepo.deleteAll();
		return count==0?"No Records found":count+" no.of records are deleted";
	}
	
	
}
