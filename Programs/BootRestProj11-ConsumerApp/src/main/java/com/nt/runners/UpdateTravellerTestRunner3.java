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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.vo.TravellerVO;

//@Component
public class UpdateTravellerTestRunner3 implements CommandLineRunner {
	@Autowired
	private  RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		
		
		//================= exchange(-,-,-) ===================
		   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/update";
		    TravellerVO  vo=new TravellerVO(23,"rajesh", "india", 999001145L, LocalDate.of(1996, 10,20), "mumbai", "maldives", List.of("Nepal","singapore","India"));
		    ObjectMapper mapper=new ObjectMapper();
		    mapper.registerModule(new JavaTimeModule());
		    String traveller_json=mapper.writeValueAsString(vo);
		    System.out.println("Json content ::"+traveller_json);
		    //prepare  http headers
		   HttpHeaders  headers=new HttpHeaders();
		   headers.setContentType(MediaType.APPLICATION_JSON);
		   //prepare  HttpEntity object having  headers and body
		   HttpEntity<String> entity=new HttpEntity<String>(traveller_json, headers);

		   //invoke the method
		   ResponseEntity<String> resp=template.exchange(url, HttpMethod.PUT, entity,String.class);
		   //get respose body and other details
		   System.out.println("output::"+resp.getBody()); 
		
		//end the application
	   System.exit(0);
	 }

}
