//StudentOperationsController.java
package com.nt.contorller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentOperationsController {
	
	/*@GetMapping("/data")
	public  String   showData(@RequestParam("sno")int no,
			                                        @RequestParam("sname") String name) {
		System.out.println("request params ::"+no+"....."+name);
		
		//return LVN
		return "show_report";
		
	}*/
	
	
	/*@GetMapping("/data")
	public  String   showData(@RequestParam(required = false,defaultValue = "1001")  int sno,
			                                        @RequestParam(required = false,defaultValue = "raja") String sname) {
		System.out.println("request params ::"+sno+"....."+sname);
		
		//return LVN
		return "show_report";
		
	}*/
	
	
	/*@GetMapping("/data")
	public  String   showData(@RequestParam(defaultValue="444")  int sno,
			                                        @RequestParam String sname) {
		System.out.println("request params ::"+sno+"....."+sname);
		
		//return LVN
		return "show_report";
		
	}*/
	
	/*@GetMapping("/data")
	public  String   showData(@RequestParam(required = false)  Integer sno,
			                                        @RequestParam String sname) {
		System.out.println("request params ::"+sno+"....."+sname);
		
		//return LVN
		return "show_report";
		
	}*/
	
	/*@GetMapping("/data")
	public  String   showData(@RequestParam(required = false)  Integer sno,
			                                        @RequestParam String sname,
			                                        @RequestParam("sadd") String addrs[],
			                                        @RequestParam("sadd") List<String> listSadd,
			                                        @RequestParam("sadd") Set<String> setSadd
			                                        ) {
		System.out.println("request params ::"+sno+"....."+sname+"...."+Arrays.toString(addrs)+"...."+listSadd+"...."+setSadd);
		
		//return LVN
		return "show_report";
		
	}*/
	
	/*@GetMapping("/data")
	public  String   showData(@RequestParam(required = false)  Integer sno,
			                                        @RequestParam String sname,
			                                        @RequestParam String  addrs
			                                        ) {
		System.out.println("request params ::"+sno+"....."+sname+"...."+addrs);
		
		//return LVN
		return "show_report";
		
	}
	
	*/
	
	@Autowired
	private  ServletContext  sc;
	@Autowired
	private  ServletConfig cg;
	
	
	@GetMapping("/data1")
	public   String    showData1(HttpServletRequest req,HttpServletResponse res,HttpSession ses)throws Exception {
		
		//get PriterWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		pw.println("web application name::"+sc.getContextPath());
		pw.println("<br>request path::"+req.getServletPath());
		pw.println("<br> DS Logical name::"+cg.getServletName());
		pw.println("<br> SEssion id::"+ses.getId());
		
		return null;
		
		
	}
}
