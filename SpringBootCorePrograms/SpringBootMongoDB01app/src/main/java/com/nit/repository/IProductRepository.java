package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Product;

public interface IProductRepository extends MongoRepository<Product, String> {
	
	
}
