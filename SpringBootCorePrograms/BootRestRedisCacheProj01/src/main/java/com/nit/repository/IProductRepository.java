package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.Product;

/**
 * JPA Repository interface for Product entity.
 * Extends JpaRepository for built-in CRUD operations (save, findAll, findById, deleteById, etc.).
 */

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	//No custom methods needed; JpaRepository provides all basics
}
