//Doctor.javas
package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Column(name="DOC_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer docid;
	
	@Column(name="DOC_NAME", length=30)
	private String docName;
	

	public User() {
		
	};
	
	public User( String docName, String specialization, double income) {
		super();
//		.this.docid = docid;
		this.docName = docName;
	}	
	
}
