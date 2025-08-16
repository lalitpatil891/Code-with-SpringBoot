package com.nit.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection="PRODUCT_COLLECTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	
	@Id
	private String id;
	@NonNull
	private String name;
	@NonNull
	private Double price;
	@NonNull
	private Double qty;
	
}
