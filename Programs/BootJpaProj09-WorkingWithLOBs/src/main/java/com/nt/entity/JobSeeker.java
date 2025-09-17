//JobSeeker.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jsid;
	@NonNull
	@Column(length = 30)
	private  String jsname;
	@NonNull
	@Column(length = 30)
	private  String addrs;
	@NonNull
	@Column(length = 30)
	private  String qlfy;
	@NonNull
	private  Double expectedSalary;
	@Lob
	@NonNull
	private  byte[]   photo;
	@Lob
	@NonNull
	private  char[]  resume;

}
