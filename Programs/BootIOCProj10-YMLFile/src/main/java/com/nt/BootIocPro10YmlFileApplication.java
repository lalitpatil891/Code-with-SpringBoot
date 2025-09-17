package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;
import com.nt.sbeans.CustomerDetails;

@SpringBootApplication
public class BootIocPro10YmlFileApplication {

   
	public static void main(String[] args) {
		//get  access to IOCcontainer
		ApplicationContext ctx=SpringApplication.run(BootIocPro10YmlFileApplication.class, args);
		//get Spring bean class obj ref
		CustomerDetails  details=ctx.getBean("custDetails",CustomerDetails.class);
		System.out.println(details);
		
		//close the IOC container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
