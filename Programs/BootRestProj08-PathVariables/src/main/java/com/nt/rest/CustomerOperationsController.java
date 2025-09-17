package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	
	/*@GetMapping("/report/{cno}/{cname}")
	public   ResponseEntity<String>  showReport(@PathVariable("cno") int no, 
			                                                                              @PathVariable String cname){
		System.out.println(no+"...."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}*/
	
	/*@GetMapping("/report/{cno}/{cname}")
	public   ResponseEntity<String>  showReport(@PathVariable(name="cno",required = false) int no, 
			                                                                              @PathVariable(required = false) String cname){
		System.out.println(no+"...."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}*/
	
	
	/*@GetMapping({"/report/{cno}/{cname}","/report","/report/{cno}"})
	public   ResponseEntity<String>  showReport(@PathVariable(name="cno",required = false) Integer no, 
			                                                                              @PathVariable(required = false) String cname){
		System.out.println(no+"...."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}*/
	

	@GetMapping("/report")
	public   ResponseEntity<String>  showReport(@PathVariable(required = false) Integer cno, 
			                                                                              @PathVariable(required = false) String cname){

		System.out.println(cno+"...."+cname);
		return new ResponseEntity<String>(cno+"..."+cname,HttpStatus.OK);

	}
}
