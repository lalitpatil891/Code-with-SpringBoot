package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IShoppingService;

@SpringBootApplication
public class BootMailProj01SEndingMailApplication {

	public static void main(String[] args) {
		//get IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootMailProj01SEndingMailApplication.class, args)){
		 //get Spring bean class obj ref
		IShoppingService  service=ctx.getBean("sms",IShoppingService.class);
		//invoke the b.method
		try {
			String  resultMsg=service.purchase(new String[] {"shirt","trouser","hat"},
					                                                          new double[] {2000.0,3000.0,1000.0},  
					                                                          new String[] {"nataraz@gmail.com","abhaymauryajnp1@gmail.com",
					                                                        		  "omdhanve30@gmail.com",  "ymewada23@gmail.com","mtsindia130@gmail.com"});
			System.out.println(resultMsg);		                                                       	
		
	     }//try2
		catch(Exception  e) {
			e.printStackTrace();
		}
		}//try1
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
