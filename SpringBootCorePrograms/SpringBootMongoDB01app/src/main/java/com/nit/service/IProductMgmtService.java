package com.nit.service;

import java.util.List;

import com.nit.document.Product;

public interface IProductMgmtService {
	
	public String registerProduct(Product prod);
	public String[] registerProducts(List<Product> prods);
}
