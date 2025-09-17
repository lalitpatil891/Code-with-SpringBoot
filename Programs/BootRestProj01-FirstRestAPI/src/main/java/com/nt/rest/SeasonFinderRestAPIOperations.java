package com.nt.rest;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderRestAPIOperations {
	
	/*@GetMapping("/display")
	public   ResponseEntity<String>  showSeasonName(){
		System.out.println("SeasonFinderRestAPIOperations.showSeasonName()");
		//find season name
		 String season=null;
		  LocalDate ld=LocalDate.now();
		  int month=ld.getMonthValue();
		  if(month>=7 &&  month<=10)
			    season="Rainy Season";
		  else if(month>=3 &&  month<=6)
			   season="Summer  season";
		  else
			    season="Winter Season";
		  
		//write  output to  consumer app
		  return new ResponseEntity<String>(season, HttpStatus.CREATED);
	}*/
	
	@GetMapping("/display")
	public   String  showSeasonName(){
		System.out.println("SeasonFinderRestAPIOperations.showSeasonName()");
		//find season name
		 String season=null;
		  LocalDate ld=LocalDate.now();
		  int month=ld.getMonthValue();
		  if(month>=7 &&  month<=10)
			    season="Rainy Season";
		  else if(month>=3 &&  month<=6)
			   season="Summer  season";
		  else
			    season="Winter Season";
		  
		//write  output to  consumer app
		  return season;
	}

}
