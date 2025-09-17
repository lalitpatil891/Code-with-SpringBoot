package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.Product;
import com.nt.service.IProductMgmtService;

@SpringBootApplication
public class BootMongoDbProj01MongoRepositoryApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootMongoDbProj01MongoRepositoryApplication.class, args);){
			//get  Service class obj  ref
			IProductMgmtService  prodService=ctx.getBean("prodService",IProductMgmtService.class);
			/*			//invoke the b.method
						Product prod=new Product("chair","furniture");
						String msg=prodService.registerProduct(prod);
						System.out.println(msg);*/
			/*	   Product prod1=new Product("sofa", 90000.0, 10.0, "furniture");
				   Product prod2=new Product();
				   prod2.setName("dinining table"); prod2.setPrice(900000.0);
				   String[] ids=prodService.registerProducts(List.of(prod1,prod2));
				   System.out.println(ids.length+" products are saved having id values::"+Arrays.toString(ids));*/
			   
			/*Product1  prod=new Product1("table",89000.0,20.0,"furniture");
			String msg=prodService.registerProduct1(prod);
			System.out.println("Product is registered with id value ::"+msg);*/
			
			/*Product2 prod2=new Product2("TV",900000.0,10.0,"appliances");
			String msg=prodService.registerProduct2(prod2);
			System.out.println("Product is registered with id value ::"+msg);*/
			
			/*	List<Product>  list=prodService.showAllProducts();
				list.forEach(prod->{
					System.out.println(prod);
				});
			*/
			/*Optional<Product> opt=prodService.showProductById("689d85a4c67761ba644285ae1");
			if(opt.isPresent())
				 System.out.println("document is ::"+opt.get());
			else
				System.out.println("no document found");*/
			
			/*	Product prod=prodService.fetchProductById("689d85a4c67761ba644285ae");
				System.out.println("Document is ::"+prod);
			*/	
			
			/*	String msg=prodService.updateProductPrice("689d85a4c67761ba644285ae", 20.0f);
				System.out.println("updated prices is ::"+msg);
			*/
			
			/* String msg=prodService.deleteProductById("689d85a4c67761ba644285ae");
			 System.out.println(msg);
			*/
			
			/*	Product prod=new Product();
				prod.setCategory("furniture");  prod.setQty(10.0);
				prodService.showAllProductsByGivenDataAsSorted(prod, false, "name").forEach(System.out::println);
			*/	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
