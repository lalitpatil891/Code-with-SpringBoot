//PersonalInfo.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pInfo")
public class PersonalInfo {
	// inject direct values
	@Value("454545")
	private  Integer regNo;
	//inject the values collected from the properties file
	@Value("${per.id}")
	private  Integer pid;
	@Value("${per.name}")
	private  String   name;
	@Value("${per.addrs}")
	private String  paddrs;
	@Value("${per.email}")
	private  String  mail;
	
	//inject  the values of System properties
	@Value("${os.name}")
	private  String  osname;
	
	@Value("${os.version}")
	private  String  osver;
	
	//inject the values of env .. variables
	@Value("${Path}")
	private  String pathData;

	
	//toStrng()  alt+shift+s,s
	@Override
	public String toString() {
		return "PersonalInfo [regNo=" + regNo + ", pid=" + pid + ", name=" + name + ", paddrs=" + paddrs+", mail=" + mail + ", osname="
				+ osname + ", osver=" + osver + ", pathData=" + pathData + "]";
	}
	


}
