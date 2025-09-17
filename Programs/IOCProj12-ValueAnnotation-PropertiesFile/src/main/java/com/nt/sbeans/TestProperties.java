package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("props")
public class TestProperties {
	@Autowired
	private Environment  env;
	
	public  String toString() {
		  return env.getProperty("os.name")+"  "+env.getProperty("per.id");
	}

}
