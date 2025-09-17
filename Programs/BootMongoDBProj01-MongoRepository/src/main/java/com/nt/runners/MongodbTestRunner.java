package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Product;
import com.nt.service.IProductMgmtService;

@Component
public class MongodbTestRunner implements CommandLineRunner{
	@Autowired
	private  IProductMgmtService prodService;

	@Override
	public void run(String... args) throws Exception {
		Product prod=new Product();
		prod.setCategory("furniture");  prod.setQty(10.0);
		prodService.showAllProductsByGivenDataAsSorted(prod, false, "name").forEach(System.out::println);

	}

}
