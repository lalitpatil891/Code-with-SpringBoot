package com.nt.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {

	@JmsListener(destination = "tpc1")
	public   void readMessage(String text) {
		System.out.println("Reciever :: recieved message ::"+text);
		
	}
}
