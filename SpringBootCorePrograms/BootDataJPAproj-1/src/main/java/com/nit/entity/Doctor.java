//Doctor.java
package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity		//Marks class as entity.
@Table(name="JPA_DOCTOR_INFO")     //Map class → DB table (optional if names match).
@Data		//lombok api anotation
public class Doctor {
	
	@Column(name="DOC_ID")
	@Id				//primary key property.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docid;
	
	@Column(name="DOC_NAME",length=25)    //Map field → DB column (optional if names match).
	private String docName;
	@Column(name="SPECIALIZATION",length=20)
	private String specialization;
	@Column(name="INCOME")
	private double income;
	
	public Doctor() {
		
	};
	
	public Doctor(String docName, String specialization, double income) {
		super();
		this.docName = docName;
		this.specialization = specialization;
		this.income = income;
	}
	
	
}
