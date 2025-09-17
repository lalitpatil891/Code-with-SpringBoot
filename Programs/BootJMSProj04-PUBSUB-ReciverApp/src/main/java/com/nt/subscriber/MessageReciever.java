package com.nt.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.ActorDetails;

@Component
public class MessageReciever {

	@JmsListener(destination = "tpc2")
	public   void readMessage( ActorDetails  actor) {
		System.out.println("Reciever :: recieved message ::"+actor);
		
	}
}
