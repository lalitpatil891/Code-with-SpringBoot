package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("custDetails")
@ConfigurationProperties(prefix ="org.hcl")
@Data
public class CustomerDetails {
		private  Integer id;
	private  String  name;
	private  String  addrs;
	//@Value("${cust.amt}")
	private  Float  billamt;
	
	private   String[]  favColors;
	private  List<String> friends;
	private   Set<String> phoneNumbers;
	private   Map<String,Object> idDetails;
	private   Properties    academics; 
	private    Company company;  

}
