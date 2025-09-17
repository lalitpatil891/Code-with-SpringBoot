package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.vo.TravellerVO;

//@Component
public class FindByIdTestRunner1 implements CommandLineRunner {
	@Autowired
	private  RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		  //================= getForEntity(-,-,-) ===================
			/*	//Base url
			   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/find/{id}";
			   //invoke the method
			   ResponseEntity<String>  resp=template.getForEntity(url,String.class,16);
			   //get respose body and other details
			   System.out.println("output::"+resp.getBody());
			   System.out.println("Header values ::"+resp.getHeaders());
			   System.out.println("Response status code ::"+resp.getStatusCode());
			//convert  STring json content to  Model class object
			  ObjectMapper  mapper=new  ObjectMapper();
			  mapper.registerModule(new JavaTimeModule());
			  TravellerVO vo=mapper.readValue(resp.getBody(), TravellerVO.class);
			  System.out.println("vo object data ::"+vo);
			*/
		
			/*  //================= getForObject(-,-,-) ===================
				//Base url
			   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/find/{id}";
			   //invoke the method
			   String  resp=template.getForObject(url,String.class,16);
			   //get respose body and other details
			   System.out.println("output::"+resp);
			  //convert  STring json content to  Model class object
			  ObjectMapper  mapper=new  ObjectMapper();
			  mapper.registerModule(new JavaTimeModule());
			  TravellerVO vo=mapper.readValue(resp, TravellerVO.class);
			  System.out.println("vo object data ::"+vo);
			*/
		
		  //================= exchange(-,-,-) ===================
			/*	//Base url
			   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/find/{id}";
			   //invoke the method
			   ResponseEntity<String> resp=template.exchange(url, HttpMethod.GET, null, String.class,15);
			   //get respose body and other details
			   System.out.println("output::"+resp.getBody());
			  //convert  STring json content to  Model class object
			  ObjectMapper  mapper=new  ObjectMapper();
			  mapper.registerModule(new JavaTimeModule());
			  TravellerVO vo=mapper.readValue(resp.getBody(), TravellerVO.class);
			  System.out.println("vo object data ::"+vo);
			*/
		//================= exchange(-,-,-) ===================
		   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/find/{id}";
		   //invoke the method
		   ResponseEntity<TravellerVO> resp=template.exchange(url, HttpMethod.GET, null,TravellerVO.class,15);
		   //get respose body and other details
		   System.out.println("output::"+resp.getBody());
		
		//end the application
	   System.exit(0);
	 }

}
