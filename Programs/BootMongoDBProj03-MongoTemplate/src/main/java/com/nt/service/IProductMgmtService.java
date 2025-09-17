package com.nt.service;

import java.util.List;

import com.nt.document.Product;

public interface IProductMgmtService {
	public   String    registerProduct(Product prod);
	public  List<Product>   showProductsByCategory(String category);
	public   Product    showProductById(String id);
	public   String    updatePriceByPriceRange(double start,double end, double hikePercent);
	public  String   registerOrUpdateProduct(String name,double price);
	public   String  removeProductsByPriceRange(double  start,double end );
	
	
}
