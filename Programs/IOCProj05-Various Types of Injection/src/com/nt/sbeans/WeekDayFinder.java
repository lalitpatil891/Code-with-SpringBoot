//WeekDayFinder.java
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wdf")
public class WeekDayFinder {
	@Autowired
	@Qualifier("ldate2")
	private   LocalDate  date;  //HAS- A property
	@Autowired
	private   LocalTime  ltime;  // HAS -A property
	
	
	// B.method
	public   String    showGreetingMessage(String user) {
		 System.out.println("ldate::"+date+"..... ltime::"+ltime);
		// get current weekday number
		int wno=date.getDayOfWeek().getValue();   //gives   1 (monday) to 7 (sunday) values
		//generate wish/greeting message
		if(wno>=1  &&  wno<=5)
			return  "Happy  Working  Days  Mr/Miss/Mrs."+user;
		else
			return  "Happy Weekend  , Enjoy  u  r days Mr/Miss/Mrs."+user;
	}

}
