package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Product;
import com.nt.repository.IProductRepository;

@Component
public class MongoDBCustomMethodsTestRunner implements CommandLineRunner{
	@Autowired
	private IProductRepository  prodRepo;

	@Override
	public void run(String... args) throws Exception {
		/*List<Product> list=prodRepo.findByNameEquals("table");
		list.forEach(System.out::println);*/
		
		 //prodRepo.getByPriceBetween(50000.0, 1000000.0).forEach(System.out::println);
		  //prodRepo.showProductDataByCategory("furniture").forEach(doc->System.out.println(Arrays.toString(doc)));
		//prodRepo.showProductsByCategory("furniture").forEach(System.out::println);
		   //prodRepo.showProductsByCategoryAndName("furniture", "table").forEach(System.out::println);
		//prodRepo.showProductsPriceRange(40000.0, 60000.0).forEach(System.out::println);
		//prodRepo.findByCategoryOrQty("appliances", 1.0f).forEach(System.out::println);
		    //prodRepo.findByNameRegexIgnoreCase("e").forEach(System.out::println);
		  prodRepo.findByCategoryAndPriceRangeOrQty("furniture", 50000.0, 5000000.0,10).forEach(System.out::println);
		
	}

}
