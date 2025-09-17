package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Product1;

public interface IProduct1Repository extends MongoRepository<Product1, String> {

}
