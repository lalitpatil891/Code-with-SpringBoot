package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.beans.MyBean;

public class AppTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		MyBean bean = context.getBean(MyBean.class);
		bean.sayHello();
	}
}


/*Output -> 

Hello from MyBean(ClassPathXmlApplicationContext)!  */