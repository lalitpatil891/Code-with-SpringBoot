package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IJobSeekerMgmtService;

@Component
public class PLSQLTestRunner implements CommandLineRunner {
	@Autowired
	private IJobSeekerMgmtService  jsService;

	@Override
	public void run(String... args) throws Exception {
		try {
		 String result=jsService.login("raja", "rani1");
		 System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
