package com.nit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity

@Data
public class Employee {

		
	@Id
	private Integer eno;
	
	private String ename;
	
	private String eadd;
	
	private double salary;
	
}
