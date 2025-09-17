package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ILoginMgmtService;

@Component
public class AuthenticationTestRunner implements CommandLineRunner {
	@Autowired
	private ILoginMgmtService  loginService;

	@Override
	public void run(String... args) throws Exception {
		String result=loginService.autheticate("raja", "rani1");
		System.out.println(result);
	}

}
