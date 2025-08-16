package com.lp.simpleWebApp.service;

import com.lp.simpleWebApp.model.Product;
import com.lp.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

        @Autowired
        private ProductRepo repo;

//      List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101,"Iphone",50000),
//            new Product(102, "Canan Camera", 70000),
//            new Product(103, "MiTv", 25000)));


    public List<Product> getProduct() {
        return repo.findAll();
    }


    public Product getProductById(int prodId) {
          return repo.findById(prodId).orElse(new Product());
        //return products.stream().filter(p -> p.getProdId() == prodId).findFirst().get();
    }

    //add product
    public void addProduct(Product prod) {
            repo.save(prod);
    }

    public void updateProductById(Product prod) {
           repo.save(prod);
    }

    public void deleteProductById(int prodId) {
        repo.deleteById(prodId);
    }
}
