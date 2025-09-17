package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.Product;

@Service("prodService")
public class ProductMgmtServiceImpl  implements IProductMgmtService{
	@Autowired
	private  MongoTemplate  template;
	
	public   String    registerProduct(Product prod) {
		Product savedProd=template.insert(prod,"PRODUCT_COLLECTION");
		return savedProd.getId()+" Document is  saved";
	}
	
	public  List<Product>   showProductsByCategory(String category){
		//prepare Query object
		 Query query=new Query();
		 query.addCriteria(Criteria.where("category").is(category));
		 //execute the logics
		 List<Product> list=template.find(query,Product.class,"PRODUCT_COLLECTION");
		 return list;
	}
	
	@Override
	public Product showProductById(String id) {
		return template.findById(id, Product.class, "PRODUCT_COLLECTION");
	}
	
	@Override
	public String updatePriceByPriceRange(double start, double end, double hikePercent) {
		//prepare Query object
		 Query query=new Query();
		 query.addCriteria(Criteria.where("price").gte(start).lte(end));
		 //create Update object
		 Update  update=new Update();
		 double multiplier=1+ (hikePercent/100.0);
		  update.multiply("price",multiplier);
		  //execute logic
		  UpdateResult result=template.updateMulti(query, update, Product.class,"PRODUCT_COLLECTION");
		return result.getModifiedCount()+" no.of  docs are updated";
	}
	
	@Override
	public String registerOrUpdateProduct(String name, double price) {
		//prepare Query object
		Query query=new Query();
		query.addCriteria(Criteria.where("name").is(name));
		
		//update or insert the data
		Update update=new Update();
		update.set("price", price);
		update.setOnInsert("category", "misc");
		update.setOnInsert("qty", 1.0);
		//invoke the logic
		UpdateResult  result=template.upsert(query, update, Product.class,"PRODUCT_COLLECTION");
		return result.getUpsertedId()!=null?"document inserted with id "+result.getUpsertedId(): "document updated";
	}
	
	@Override
	public String removeProductsByPriceRange(double start, double end) {
		//prepare Query object
				Query query=new Query();
				query.addCriteria(Criteria.where("price").gt(start).lte(end));
		//execute the logic
			int count=template.findAllAndRemove(query, Product.class, "PRODUCT_COLLECTION").size();
		return count+"  no.of docs deleted";
	}

}
