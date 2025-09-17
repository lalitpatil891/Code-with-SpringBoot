package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.model.Vehicle;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {

	@PostMapping("/register")
	public   ResponseEntity<String>  registerVehicle(@RequestBody  Vehicle vehicle){
		System.out.println("ActorOperationsController.registerVehicle():::"+vehicle);
		
		return new ResponseEntity<String>(vehicle.toString(),HttpStatus.OK);
		
		
		
	}
	
	@PostMapping("/register-actor")
	public   ResponseEntity<String>  registerActor(@RequestBody  Actor actor){
		System.out.println("ActorOperationsController.registerVehicle():::"+actor);
		
		return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
		
	}
	
	@PostMapping("/register-vehicles")
	public   ResponseEntity<String>  registerVehicles(@RequestBody  List<Vehicle> list){
		System.out.println("ActorOperationsController.registerVehicle():::"+list);
		
		return new ResponseEntity<String>(list.toString(),HttpStatus.OK);
		
	}

}
