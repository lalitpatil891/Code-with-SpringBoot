//Product.java
package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product1 {
	@Id
	private String pid;
	@NonNull
	private  String name;
	@NonNull
	private  Double price;
	@NonNull
	private  Double qty; 
	@NonNull
	private  String category;
	
	

}
