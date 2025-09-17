package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.document.Product;
import com.nit.service.IProductMgmtService;

@SpringBootApplication
public class SpringBootMongoDb01appApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootMongoDb01appApplication.class, args);){
			
			IProductMgmtService prodService = ctx.getBean("prodService",IProductMgmtService.class);
			
			
			Product prod = new Product("table",89999.0, 10.0, "furniture");
			String msg =prodService.registerProduct(prod);
			System.out.println(msg);
			
			Product prod = new Product("table",89999.0, 10.0, fru);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
