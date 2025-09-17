package com.nt.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.BootMongoDbProj01MongoRepositoryApplication;
import com.nt.document.Product;
import com.nt.document.Product1;
import com.nt.document.Product2;
import com.nt.repository.IProduct1Repository;
import com.nt.repository.IProduct2Repository;
import com.nt.repository.IProductRepository;

@Service("prodService")
public class ProductMgmtServiceImpl implements IProductMgmtService {

    private final BootMongoDbProj01MongoRepositoryApplication bootMongoDbProj01MongoRepositoryApplication;
	@Autowired
	private  IProductRepository  prodRepo;
	@Autowired
	private  IProduct1Repository  prod1Repo;
	@Autowired
	private  IProduct2Repository  prod2Repo;


    ProductMgmtServiceImpl(BootMongoDbProj01MongoRepositoryApplication bootMongoDbProj01MongoRepositoryApplication) {
        this.bootMongoDbProj01MongoRepositoryApplication = bootMongoDbProj01MongoRepositoryApplication;
    }
	

	@Override
	public String registerProduct(Product prod) {
		System.out.println("ProductMgmtServiceImpl.registerProduct() :: repo obj class name::"+prodRepo.getClass()+"....."+Arrays.toString(prodRepo.getClass().getInterfaces()));
		//use repo
		Product savedProd=prodRepo.save(prod);
		return "Doucment is saved having id value ::"+savedProd.getId();
	}
	
	@Override
	public String[] registerProducts(List<Product> prods) {
		//use repo
		List<Product> savedProds=prodRepo.saveAll(prods);
		// gather only id values
		String [] ids=new String[savedProds.size()];
		for(int i=0;i<savedProds.size();++i) {
			  ids[i]=savedProds.get(i).getId();
		}
		return ids;
	}
	
	@Override
	public String registerProduct1(Product1 prod) {
		System.out.println("ProductMgmtServiceImpl.registerProduct1() ");
		//use repo
		prod.setPid(UUID.randomUUID().toString());
		Product1 savedProd=prod1Repo.save(prod);
		return "Doucment is saved having id value ::"+savedProd.getPid();
	}
	
	@Override
	public String registerProduct2(Product2 prod) {
		System.out.println("ProductMgmtServiceImpl.registerProduct1() ");
		//use repo
		prod.setPid(new Random().nextInt(10000));
		Product2 savedProd=prod2Repo.save(prod);
		return "Doucment is saved having id value ::"+savedProd.getPid();
	}
	
	@Override
	public List<Product> showAllProducts() {
		List<Product> list=prodRepo.findAll();
		return list;
	}
	
	@Override
	public Optional<Product> showProductById(String id) {
		Optional<Product> opt=prodRepo.findById(id);
		return opt;
	}
	
	@Override
	public Product fetchProductById(String id) {
		return  prodRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id"));
		/*Optional<Product> opt=prodRepo.findById(id);
		if(opt.isEmpty())
			throw new IllegalArgumentException("Invalid id");
		else
			return opt.get();*/
	}
	
	@Override
	public String updateProductPrice(String id, float hikePerecent) {
		 Product prod=prodRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id"));
		 //update the price
		 if(prod.getPrice()!=null) {
		         prod.setPrice(prod.getPrice()+ (prod.getPrice()* hikePerecent/100.0));
		         prodRepo.save(prod);
		         return  id+" Produt is updated";
		 }
		 return id+" prodcut does not have price";
	
	}
	
	@Override
	public String deleteProductById(String id) {
		 Product prod=prodRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id"));
		//delete the document
		  prodRepo.deleteById(id);
		return  id+" Document is deleted";
	}
	
	@Override
	public List<Product> showAllProductsByGivenDataAsSorted(Product prod, boolean ascOrder, String... props) {
		//prepare Example object
		Example<Product> example=Example.of(prod);
		//prepare Sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//call the method
		  List<Product> list=prodRepo.findAll(example,sort);
		
		return list;
	}

}
