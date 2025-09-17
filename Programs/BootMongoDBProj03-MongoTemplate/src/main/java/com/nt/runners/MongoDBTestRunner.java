package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Product;
import com.nt.service.IProductMgmtService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {
	@Autowired
	private IProductMgmtService  prodService;

	@Override
	public void run(String... args) throws Exception {
		/*Product  prod=new Product("refrigirator", 90000.0, 10.0, "appliances");
		String msg=prodService.registerProduct(prod);
		System.out.println(msg);*/
		
		//prodService.showProductsByCategory("furniture").forEach(System.out::println);
		  //System.out.println("Product details are ::"+prodService.showProductById("689d870d72633678ce8b0719"));
		   //System.out.println(prodService.updatePriceByPriceRange(50000.0, 500000.0, 20.0));
		  //System.out.println(prodService.registerOrUpdateProduct("dressing-table", 2000000.0));
		System.out.println(prodService.removeProductsByPriceRange(20000.0, 500000.0));
		  
		 

	}

}
