//Politician.java
package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Politician {
	@SequenceGenerator(name="gen1",sequenceName = "PID_SEQ",allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private   Integer pid;
	
	@NonNull
	@Column(length = 30)
	private  String  pname;
	
	@NonNull
	private  Boolean  indian;
	@NonNull
	@Column(length = 40)
	private  String  addrs;
	
	private   LocalDate  dob;
	private  LocalTime   tob;
	private   LocalDateTime  doj;
	
	// MetaData Properties
	
	

}
