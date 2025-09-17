//ActorEntity.java
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
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_ACTOR_TAB1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ActorEntity {
	//Data Properties
	@Id
	@Column(name="actor_id")
	@SequenceGenerator(name="gen1",sequenceName = "AID_SEQ",initialValue = 100,allocationSize = 1)
    @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer aid;
	
	@Column(length = 30,name = "ACTOR_NAME")
	@NonNull
	private  String  aname;
	
	@Column(length = 30,name = "ACTOR_ADDRS")
	@NonNull
	private String  addrs;
	
	@Column(length = 30,name = "ACTOR_CATEGORY")
	@NonNull
	private String  category;
	
	@Column(name = "ACTOR_FEE")
	@NonNull
	private Float  fee;
	
	//Meta data Properties
	@CreationTimestamp
	private LocalDateTime  createdOn;
	@UpdateTimestamp
	private LocalDateTime  updatedOn;
	@Version
	private  Integer   updateCount;
	@Column(length = 30)
	private  String createdBy;
	@Column(length = 30)
	private  String updatedBy;
	@Column(length = 30)
	private  String active_SW="active";
	

}
