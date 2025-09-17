package com.nit.ms;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderOperationsMs {
	
	@Value("${spring.application.instance-id}")
	private String instance_id;
	
	//Rest operation/endpoint	
	@GetMapping("/show-season")
	public ResponseEntity<String> findSeason(){
		//get Local date and time
		LocalDateTime ldt=LocalDateTime.now();
			
		//get current month
		int month = ldt.getMonthValue();
		
		String seasonName= null;
		
		if(month>=7 && month<=10)
			seasonName="Rainy Season";
		else if(month>=3 && month <=6)
			seasonName="Summer Season";
		else
			seasonName="Winter Season";
		
		//improve the output
		seasonName=seasonName+"---"+instance_id;
		
		//return the ResponceEntity Object
		return new ResponseEntity<String>(seasonName,HttpStatus.OK);
	}
}
