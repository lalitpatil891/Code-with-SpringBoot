package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPoliticianMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {
	@Autowired
	private  IPoliticianMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			Politician  politician=new Politician("amit sha1",true,"gujarat");
			politician.setDob(LocalDate.of(1975, 12, 13));
			politician.setTob(LocalTime.of(10, 20, 10));  politician.setDoj(LocalDateTime.of(1990,10,21,10,10,34));
			String msg=service.registerPolitician(politician);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Politician politician=service.showPoliticianById(121);
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
		*/
		
		/*	try {
				String  msg=service.getPoliticianAgeById(1);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			List<Object[]>  list=service.showAllPoliticiansNameAgeDetails();
			list.forEach(row->System.out.println(Arrays.toString(row)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
