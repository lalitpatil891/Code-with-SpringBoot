//Actor.java 
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_ACTOR_TAB1")
@Data
//@NoArgsConstructor
@AllArgsConstructor
public  class Actor {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="gen1",sequenceName = "ACTOR_ID_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name="ACTOR_ID")
	private   Integer aid;
	
	//@NonNull
	@Column(name = "ACTOR_NAME",length = 30)
	private  String  aname;
    //@NonNull
	@Column(name = "ACTOR_ADDRS",length = 30)
	private  String  addrs;
    //@NonNull
	@Column(name = "ACTOR_CATEGORY",length = 30)
    //@Transient
	private   String  category;
    
    //@NonNull
	@Column(name = "ACTOR_FEE")
	private   Double  fee;
	
	public  Actor() {
		System.out.println("Actor:: 0-param constructor::"+this.getClass());
	}

}
