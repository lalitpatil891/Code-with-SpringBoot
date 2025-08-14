package com.nit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.document.Product;
import com.nit.repository.IProductRepository;

@Service("prodService")
public class ProductMgmtServiceImpl implements IProductMgmtService {
	
	@Autowired
	private IProductRepository prodRepo;
	
	public String registerProduct(Product prod) {
		
		System.out.println("ProductMgmtServiceImpl.registerProduct()::repo obj class nama: "+prodRepo.getClass()+"..."+Arrays.toString(prodRepo.getClass().getInterfaces()));
		
		//use Repo
		Product savedProd=prodRepo.save(prod);
		
		return "Document is saved have";
	}

	@Override
	public String[] registerProducts(List<Product> prods) {
		
		List<Product> savedProds = prodRepo.saveAll(prods);
		
		String[] ids = new String[savedProds.size()];
		for(int i=0; i<savedProds.size(); i++){
			
		}
		
		
		return null;
	}

	
	
}
