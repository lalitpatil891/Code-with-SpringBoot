package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Product;

public interface IProductRepository extends MongoRepository<Product, String> {
	   //Examples on  findBy methods
     public List<Product>  findByNameEquals(String name);
     public  List<Product>  getByPriceBetween(double start,double end);
     //Examples on  Query methods
     @Query(fields="{id:0,name:1,category:1}",value="{category:?0}")
     public List<Object[]>  showProductDataByCategory(String cat);
     
     @Query(value="{category:?0}")
     public List<Product>  showProductsByCategory(String cat);
     
     
     @Query(value="{category:?0,name:?1}",fields="{ }")
     public List<Product>  showProductsByCategoryAndName(String cat,String name);
     
     @Query("{ price: { $gte: ?0, $lte: ?1 } }")
     public List<Product>  showProductsPriceRange(double  start,double end);
     
  // OR condition between category and qty
     @Query("{ '$or': [ { category: ?0 }, { qty: ?1 } ] }")
     List<Product> findByCategoryOrQty(String category, float qty);
     
  // Regex match on name (case-insensitive)
     //@Query("{ 'name': { $regex: '^?0', $options: 'i' } }")
     //@Query("{ 'name': { $regex: '^?0' } }")
     @Query("{ 'name': { $regex: '?0$' } }")
     List<Product> findByNameRegexIgnoreCase(String regex);
     
     @Query("{ '$or': [  { $and: [ { 'category': ?0 }, { 'price': { $gte: ?1, $lte: ?2 } } ] },  { 'qty': { $gte: ?3 } } ] }")
      List<Product> findByCategoryAndPriceRangeOrQty(   String category,
                                                                                                           Double minPrice,
                                                                                                            Double maxPrice,
                                                                                                            Integer minQty);
  
     
     
     
     
     
     
     
     
     
     
}
