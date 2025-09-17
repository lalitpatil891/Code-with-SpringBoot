package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Politician;
import com.nt.service.IPoliticianMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {
	@Autowired
	private  IPoliticianMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			Politician  politician=new Politician("amit sha1",true,"gujarat");
			politician.setDob(LocalDate.of(1975, 12, 13));
			politician.setTob(LocalTime.of(10, 20, 10));  politician.setDoj(LocalDateTime.of(1990,10,21,10,10,34));
			String msg=service.registerPolitician(politician);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("==================================");
		
		try {
			Politician politician=service.showPoliticianById(1);
			System.out.println(politician);
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		System.out.println("================");
		try {
			service.showAllPoliticians().forEach(System.out::println);;
			
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		
		System.out.println("Press any key  to end the app");
		System.in.read();

	}

}
