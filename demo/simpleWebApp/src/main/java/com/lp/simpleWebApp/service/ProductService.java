package com.lp.simpleWebApp.service;

import com.lp.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101,"Iphone",50000),
            new Product(102, "Canan Camera", 70000),
            new Product(103, "MiTv", 25000)));


    public List<Product> getProduct() {
        return products;
    }


    public Product getProductById(int prodId) {
        return products.stream().filter(p -> p.getProdId() == prodId).findFirst().get();
    }

    //add product
    public void addProduct(Product prod) {
        products.add(prod);
    }

    public void updateProductById(Product prod) {
            int index = 0;

            for(int i = 0; i<products.size(); i++){
                if(products.get(i).getProdId() == prod.getProdId()){
                    index = i;
                }
            }

            products.set(index, prod);
    }

    public void deleteProductById(int prodId) {
        int index = 0;

        for(int i=0; i< products.size(); i++)
            if(products.get(i).getProdId() == prodId)
                index = i;

        products.remove(index);
    }
}
