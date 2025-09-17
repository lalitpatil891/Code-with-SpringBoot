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
@Table(name="JPA_JS_TAB")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer jobId;
	
	@Column(name="JS_NAME", length=30)
	private String name;
	@Column(name="JS_ADDRESS", length=100)
	private String address;
	@Column(name="JS_QLFY",length=20)
	private String qlfy; 
	@Column(name="JS_EXP_SALARY")
	private Double expSalary;
}
