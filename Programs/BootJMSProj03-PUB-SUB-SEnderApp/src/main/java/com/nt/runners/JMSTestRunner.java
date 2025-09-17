package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sender.SenderApp;

@Component
public class JMSTestRunner implements CommandLineRunner {
	@Autowired
	private  SenderApp  sender;

	@Override
	public void run(String... args) throws Exception {
		   sender.sendMessage();
	}

}
