//WeekDayFinder.java
package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("wdf")
@Component
public class WeekDayFinder {
	
	private   LocalDate  date;  //HAS- A property
	
	public WeekDayFinder() {
		System.out.println("WeekDayFinder:: 0-param constructor");
	}
	
	
	//setter method for setter Injection
	@Autowired
	public void  setDate(LocalDate date) {
		System.out.println("WeekDayFinder.setDate()");
		this.date=date;
	}
	
	// B.method
	public   String    showGreetingMessage(String user) {
		// get current weekday number
		int wno=date.getDayOfWeek().getValue();   //gives   1 (monday) to 7 (sunday) values
		//generate wish/greeting message
		if(wno>=1  &&  wno<=5)
			return  "Happy  Working  Days  Mr/Miss/Mrs."+user;
		else
			return  "Happy Weekend  , Enjoy  u  r days Mr/Miss/Mrs."+user;
	}

}
