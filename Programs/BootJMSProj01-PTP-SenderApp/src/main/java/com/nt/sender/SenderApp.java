package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

@Component("sender")
public class SenderApp {
	@Autowired
	private JmsTemplate template;
	
	public void  sendMessage() {
		
		/*	template.send("mq1",new MessageCreator() {
			            	@Override
				                public Message createMessage(Session ses) throws JMSException {
					                          Message  message=ses.createTextMessage(" report generated at ::"+new Date());
							                     return  message;
				                          }
			                          });
		*/
		/*	   template.send("mq1", (ses)->{
				    return  ses.createTextMessage("(Sender App) Report generated at:"+new Date());
			   });*/
		
		template.send("mq1", ses-> ses.createTextMessage("(Sender App) Report generated at:"+new Date()));
		System.out.println("Sender has  sent the message ");
		System.exit(0);
		
	        }
}
