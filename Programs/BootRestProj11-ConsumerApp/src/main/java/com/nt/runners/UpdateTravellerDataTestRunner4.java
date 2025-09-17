package com.nt.runners;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.vo.TravellerVO;

//@Component
public class UpdateTravellerDataTestRunner4 implements CommandLineRunner {
	@Autowired
	private  RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		
		
		//================= exchange(-,-,-) ===================
		
		   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/update/{currentLocation}/{headingTo}";
		   //register  the module
		   template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		   //invoke the method
		   ResponseEntity<String> resp=template.exchange(url, HttpMethod.PATCH, null,String.class, "hyderabad","Newyork");
		   //get respose body and other details
		   System.out.println("output::"+resp.getBody()); 
		
		//end the application
	   System.exit(0);
	 }

}
