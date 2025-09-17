package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.document.Product;
import com.nt.document.Product1;
import com.nt.document.Product2;

public interface IProductMgmtService {
    public  String  registerProduct(Product prod);
    public  String[] registerProducts(List<Product> prod);
    public   String   registerProduct1(Product1 prod);
    public   String   registerProduct2(Product2 prod);
    public   List<Product> showAllProducts();
    public   Optional<Product>  showProductById(String id);
    public   Product  fetchProductById(String id);
    public   String   updateProductPrice(String id , float hikePerecent);
    public  String   deleteProductById(String id);
    public  List<Product>  showAllProductsByGivenDataAsSorted(Product prod,boolean ascOrder ,String ...props);
    
    
}
