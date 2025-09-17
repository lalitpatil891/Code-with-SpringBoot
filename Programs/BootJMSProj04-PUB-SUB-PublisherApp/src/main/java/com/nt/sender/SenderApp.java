package com.nt.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.nt.model.ActorDetails;

@Component("sender")
public class SenderApp {
	@Autowired
	private JmsTemplate template;
	
	public void  sendMessage() {
		ActorDetails actor=new ActorDetails(1001,"SRK","hyd","hero",5454545.0f);
		template.convertAndSend("tpc2",actor);
		System.out.println("Sender has  sent the message ");
		System.exit(0);
		
	        }
}
