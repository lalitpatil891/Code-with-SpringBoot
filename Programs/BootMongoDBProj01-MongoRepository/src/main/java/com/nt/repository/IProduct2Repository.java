package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Product2;

public interface IProduct2Repository extends MongoRepository<Product2, Integer> {

}
