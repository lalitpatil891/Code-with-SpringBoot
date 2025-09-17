//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	//Endpoint1
	@GetMapping("/report")
	public  ResponseEntity<String>  showAllCustomers(){
		 System.out.println("CustomerOperationsController.showAllCustomers() (GET)");
		 return new ResponseEntity<String>("SELECT Operation",HttpStatus.OK);
	}
	
	//Endpoint2
	@PostMapping("/register")
	public  ResponseEntity<String>  registerCustomer(){
		 System.out.println("CustomerOperationsController.register (POST)");
		 return new ResponseEntity<String>("INSERT Operation",HttpStatus.OK);
	}
	
	//Endpoint3
	@PutMapping("/update")
	public  ResponseEntity<String>  updateCustomer(){
		 System.out.println("CustomerOperationsController.updateCustomer (PUT)");
		 return new ResponseEntity<String>("UPDATE Operation",HttpStatus.OK);
	}
	
	////Endpoint4
	@PatchMapping("/updateEmail")
	public  ResponseEntity<String>  updateCustomerEmail(){
		 System.out.println("CustomerOperationsController.updateCustomerEmail (PATCH)");
		 return new ResponseEntity<String>("Partial UPDATE Operation",HttpStatus.OK);
	}
	
	//Endpoint5
	@DeleteMapping("/delete")
	public  ResponseEntity<String>  deleteCustomer(){
		 System.out.println("CustomerOperationsController.deleteCustomer (DELETE)");
		 return new ResponseEntity<String>(" DELETE Operation",HttpStatus.OK);
	}
}
