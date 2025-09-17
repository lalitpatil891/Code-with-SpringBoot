package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerationService {
	
	//@Scheduled(cron="15 * * * * * ")
	//@Scheduled(cron="0 * * * * * ")
	//@Scheduled(cron="* * * * * * ")
	//@Scheduled(cron="30 45 10 * * * ")
	//@Scheduled(cron="30  10 11 1 1 SUN ")
	//@Scheduled(cron="10  10  19 20 10 *")
	//@Scheduled(cron="0 30 10,13 * * *")
	//@Scheduled(cron="0 40 10-14 * * *")
	//@Scheduled(cron="0 40 10-14 * * FRI-SUN")
		//@Scheduled(cron="0 0  11 1-10 * ?")
		//@Scheduled(cron="0 0 10 15 8 * ")
		//@Scheduled(cron="0 0 * * 11,12,1,2 ?")
	
	//@Scheduled(cron="10/20 *  *  * * * ")
	//@Scheduled(cron="10/20  23-25  *  * * * ")
	//@Scheduled(cron="0  0/5  10   * * * ")
	
	//@Scheduled(cron="0/5  0/5  10/5   * * * ")
	//@Scheduled(cron="0  0  10   1/2 1 * ")
	//@Scheduled(cron="0/10 42/2  *  * * *")
	
	//@Scheduled(cron="@hourly")
	//@Scheduled(cron="0 52 11 L-29  *  *")
	@Scheduled(cron="30 56 11 ?  *  6#1")
	public  void  showSalesReport1() {
		System.out.println("Sales report1 on "+new Date());
	}
	
	
}
