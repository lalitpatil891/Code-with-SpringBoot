package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	/*@GetMapping("/report")
	public   ResponseEntity<String>  showReport(@RequestParam("cno") int no, @RequestParam String cname){
		System.out.println(no+"...."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}*/
	
	/*@GetMapping("/report")
	public   ResponseEntity<String>  showReport(@RequestParam(required=false,name="cno") int no, @RequestParam(required=false) String cname){
		System.out.println(no+"...."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}*/
	
	@GetMapping("/report")
	public   ResponseEntity<String>  showReport(@RequestParam(required=false, defaultValue="1111",name="cno") int no, 
			                                                                              @RequestParam(required=false,defaultValue = "lion") String cname){
		System.out.println(no+"...."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}
	

}
