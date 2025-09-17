//WishMessageServiceImpl.java
package com.nt.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService {
	

	@Override
	public String showWishMessage() {
	    //get curent hour of the day
		LocalTime time=LocalTime.now();
		int hour=time.getHour();
		if(hour<12)
			return  "Good Morning:";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good evening";
		else
			return "Good Night";
	}

}
