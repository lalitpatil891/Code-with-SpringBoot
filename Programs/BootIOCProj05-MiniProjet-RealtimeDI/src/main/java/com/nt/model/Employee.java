package com.nt.model;

import lombok.Data;

@Data  //Gives setters,getters,toString(),hashCode(),equals()and etc.. methods
public class Employee {
	private Integer  eno;
	private  String   enmae;
	private  String  desg;
	private   Float  salary;
	private   Float grossSalary;
	private   Float  netSalary;

}
