package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.TravellerVO;

//@Component
public class FindAllTestRunner2 implements CommandLineRunner {
	@Autowired
	private  RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		
		  //================= exchange(-,-,-) ===================
			/*	//Base url
			   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/findAll";
			   //invoke the method
			   ResponseEntity<String> resp=template.exchange(url, HttpMethod.GET, null, String.class);
			   //get respose body and other details
			   System.out.println("output::"+resp.getBody());
			  //convert  STring json content to  Model class object
			  ObjectMapper  mapper=new  ObjectMapper();
			  mapper.registerModule(new JavaTimeModule());
			  List<TravellerVO> listVO=mapper.readValue(resp.getBody(),new TypeReference<List<TravellerVO>>() {	} );
			  System.out.println("Listvo object data ::"+listVO);*/
		
		//================= exchange(-,-,-) ===================
		   String url="http://localhost:7799/BootRestProj09-MiniProject-TravellerAPI/traveller-api/findAll";
		   //invoke the method
		   ResponseEntity<List<TravellerVO>> resp=template.exchange(url, HttpMethod.GET, null,
				                                                                                 new ParameterizedTypeReference<List<TravellerVO>>() {});
		   //get respose body and other details
		   System.out.println("output::"+resp.getBody()); 
		
		//end the application
	   System.exit(0);
	 }

}
