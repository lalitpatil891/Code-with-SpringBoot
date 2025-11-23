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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="JPA_JS_TAB")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JS_ID")
	private Integer jsid;
	
	@NonNull
	@Column(length=30, name="JS_NAME")
	private String jsname;
	
	@NonNull
	@Column(length=30, name="JS_ADDRS")
	private String jsaddrs;
	
	@NonNull
	@Column(length=30, name="JS_QLFY")
	private String qlfy;
	
	@NonNull
	@Column(name="JS_EXP_SALARY")
	private Float expectedSalary;
	
	@NonNull
	@Column(name="JS_EMAIL")
	private String email;
	
	@Column(name="JS_LOCATION")
	private String location;
	
}
