package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.service.IpurchaseOrder;

@SpringBootApplication
public class SpringBootMail01SendMailApplication {

	public static void main(String[] args) {
	
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(SpringBootMail01SendMailApplication.class, args);
	
		//get Service class ref
		
		IpurchaseOrder order = ctx.getBean("purchaseService", IpurchaseOrder.class);
	
		//invokr method
		
		try {
			String msg = order.purchase(new String[] {"shirt","trouser","watch"},
					new double[] {5000,6000,7000},
					new String[] {"sunilbhoi606@gmail.com","lp613408@gmail.com"});
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext)ctx).close();
	
	}

}
