package com.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nit.entity.Product;
import com.nit.repository.IProductRepository;
import com.nit.service.IProductMgmtService;

/** Implementation of Product management service with caching. Cache name:
 * "prods" (consistent across all methods). Keys use SpEL (e.g., #product.pid
 * for add/update, #pid for find/delete). */

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {

	@Autowired
	private IProductRepository prodRepo; // JPA Repository injection

	@Override
	@CachePut(value = "prods", key = "#product.pid") // Updates/puts the returned Product in cache with key = pid
	public Product addProduct(Product product) {
		// Save to DB and Return the saved entity(with generated ID)
		Product savedProduct = prodRepo.save(product);
		return savedProduct; // This will be cached
	}

	@Override
	@Cacheable(value = "prods")
	public List<Product> showAllProducts() {
		// Fetches all from DB; subsequent calls hit cache
		return prodRepo.findAll();
	}

	@Override
	@CacheEvict(value = "prods", key = "#pid")
	public String deleteProduct(int pid) {
		// Load and check if exists
		Optional<Product> opt = prodRepo.findById(pid);

		if (opt.isPresent()) {
			prodRepo.deleteById(pid); // Delete from DB
			return "Product is found and deleted"; // Eviction happens regardless of return value
		}
		return "Product is not found for deletion";
	}

	@Override
	@Cacheable(value = "prods", key = "#pid") // Caches the Product by pid; subsequent calls hit cache
	public Product findProductById(int pid) {
		// Fetches from DB; throws exception if not found
		return prodRepo.findById(pid).orElseThrow(() -> new IllegalArgumentException("Invalid Pid"));
	}

}
