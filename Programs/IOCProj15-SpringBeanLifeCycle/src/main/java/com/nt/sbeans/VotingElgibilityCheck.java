//VotingElgibilityCheck.java
package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("vec")
public class VotingElgibilityCheck {
	//@Value("${voter.name}")
	private  String  name;
	//@Value("${voter.age}")
	private   float age;
	private    LocalDate dov;
	
	static {
		System.out.println("VotingElgibilityCheck:: static block");
	}
	
	public VotingElgibilityCheck() {
		System.out.println("VotingElgibilityCheck: 0-param constructor");
	}
	
	@Value("${voter.name}")
	public  void setName(String name) {
		System.out.println("VotingElgibilityCheck.setName()");
		this.name=name;
	}
	
	@Value("${voter.age}")
	public  void setAge(float age) {
		System.out.println("VotingElgibilityCheck.setAge()");
		this.age=age;
	}
	
	
	@PostConstruct
	public void  myInit() {
		System.out.println("VotingElgibilityCheck.myInit()");
		 //initialize the  left  over properties
		dov=LocalDate.now();
		// validate important properties based values injection
		if(age<=0  || name==null)
			throw new IllegalArgumentException("invalid values for  name, age ");
		
	}
	
	public   String  findVotingElgibilty() {
		System.out.println("VotingElgibilityCheck.findVotingElgibilty() (B.method)");
		if(age<18)
			return  "Mr/Miss/Mrs "+name+ "  u  r not elgible for voting :: verified on :"+dov;
		else
			return  "Mr/Miss/Mrs "+name+ "  u  r  elgible for voting :: verified on:"+dov;
				
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("VotingElgibilityCheck.myDestroy()");
		//nullify the bean properties
		age=0;
		name=null;
		dov=null;
	}

}
