//BankAccount.java
package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class BankAccount {
	//Data properties
	@SequenceGenerator(name = "gen1",sequenceName = "acno_seq",initialValue = 100000000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Long acno;
	@NonNull
	@Column(length = 30)
	private  String owner;
	@NonNull
	@Column(length = 30)
	private  String type;
	@NonNull
	private  Double balance;
	
	//MetaData properties
	@Version
	private  Integer  updateCount;
	@CreationTimestamp
	@Column(updatable = false,insertable = true)
	private  LocalDateTime  createdOn;
	@UpdateTimestamp
	@Column(insertable =false ,updatable = true)
	private   LocalDateTime  lastUpdatedOn;
	@Column(length = 10)
	private  String  activeSW="active";
	@Column(length = 20,updatable = false,insertable = true)
	private String createdBy;
	@Column(length = 20,insertable = false,updatable = true)
	private  String  updatedBy;
	

}
