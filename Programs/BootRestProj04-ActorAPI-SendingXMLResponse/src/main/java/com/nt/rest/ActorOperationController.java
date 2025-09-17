//ActorOperationsController.java
package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.model.Vehicle;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationController {
	
	@GetMapping("/actor-report")
	public  ResponseEntity<Actor>   showActorData(){
		System.out.println("ActorOperationController.showActorData()");
		Actor actor=new Actor(1001,"raja","hyd",899000.0f, "hero");
		return  new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	
	@GetMapping("/actor-more-report")
	public  ResponseEntity<Actor>   showMoreActorData(){
		System.out.println("ActorOperationController.showActorData()");
		Actor actor=new Actor(1001,"mahesh","hyd",8991000.0f, "hero");
		actor.setFavColors(new String[] {"red","green","blue"});
		actor.setFriends(List.of("rajesh","suresh","ramesh"));
		actor.setPhones(Set.of(9999999L,88888888L,77777777L));
		actor.setIdDetails(Map.of("aadhar",5454545, "pan", 455454));
		Vehicle vehicle=new Vehicle("TS09EN5466","fortuner","toyota",5700000.0);
		actor.setVehicle(vehicle);
		
		return  new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/show-vehicles")
	public   ResponseEntity<List<Vehicle>>   showAllVehicles(){
		List<Vehicle>  list=List.of(new Vehicle("TS09EE7878", "EVE9","mahindra",3300000.0),
				                                        new Vehicle("TS09EE7171", "fortuner","toyota",5500000.0),
				                                        new Vehicle("TS09EE7272", "X9","Audi",15000000.0),
				                                        new Vehicle("TS09EE5566", "may back","Mercdez",16000000.0));
				   return  new  ResponseEntity<List<Vehicle>>(list,HttpStatus.OK);                                     
				                                        
	}
	

}
