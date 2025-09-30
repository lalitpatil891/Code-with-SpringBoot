package com.nit.service;

import java.util.List;

import com.nit.entity.Product;

/**
 * Service interface for Product management operations.
 * Defines contract for CRUD with caching.
 */

public interface IProductMgmtService {
	
	//Adds a new Product to the database and updates cache.
	Product addProduct(Product product);
	
	//Retrieves all Products from database/cache.
	List<Product> showAllProducts();
	
	//Deletes a product by ID and evicts from cache.
	String deleteProduct(int pid);
	
	//Finds a product by ID from database/cache.
	Product findProductById(int pid);
}
