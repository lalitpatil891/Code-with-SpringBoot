package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerationService {
	
	//@Scheduled(initialDelay = 4000,fixedDelay = 2000)
	@Scheduled(fixedDelay = 12000)
	//@Scheduled(fixedDelayString = "2000")
	//@Scheduled(fixedRate = 4000)
	
	//@Scheduled
	public  void  showSalesReport1() {
		System.out.println("Sales report1 on (start):"+new Date());

		try {
		Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Sales report1 on (end):"+new Date());
	}
	
	/*@Scheduled(fixedDelayString = "6000")
	public  void  showSalesReport2() {
		System.out.println("(report2)Thread name:"+Thread.currentThread());
		System.out.println("Sales report2 on:"+new Date());
	}
	*/

}
