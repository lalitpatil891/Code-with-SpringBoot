package com.nt.controller;


import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerOperationsController {
	
	/*//@RequestMapping("/home")
	@RequestMapping("/")
	public  String  showHomePage(BindingAwareModelMap map) {
		System.out.println("CustomerOperationsController.showHomePage()");
		// add data  to shared memory   as  model attributes
		map.addAttribute("sysDate", new Date());
		map.addAttribute("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return "welcome";
	}*/
	
	/*@RequestMapping("/")
	public  String  showHomePage(Map<String,Object> map) {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+map.getClass());
		// add data  to shared memory   as  model attributes
		map.put("sysDate", new Date());
		map.put("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return "welcome";
	}*/
	
	/*	@RequestMapping("/")
		public  String  showHomePage(Model model) {
			System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+model.getClass());
			// add data  to shared memory   as  model attributes
		    model.addAttribute("sysDate", new Date());
			model.addAttribute("age",new Random().nextInt(40));
			//return LVN (Logical View Name)
			return "welcome";
			
		}
	*/		
	
	/*@RequestMapping("/")
	public  String  showHomePage(ModelMap map) {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+map.getClass());
		// add data  to shared memory   as  model attributes
	    map.put("sysDate", new Date());
		map.put("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return "welcome";
	}
	*/
	
	/*	@RequestMapping("/home")
		public  void  showHomePage(ModelMap map) {
			System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+map.getClass());
			// add data  to shared memory   as  model attributes
		    map.put("sysDate", new Date());
			map.put("age",new Random().nextInt(40));
			//return LVN (Logical View Name)
			//return "welcome";
		}
	*/
	
	/*@RequestMapping("/home")
	public  String  showHomePage(ModelMap map) {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+map.getClass());
		// add data  to shared memory   as  model attributes
	    map.put("sysDate", new Date());
		map.put("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return null;
	}*/
	
	/*@RequestMapping("/home")
	public  Map<String,Object>  showHomePage() {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name");
		//create  shared memory manually
		Map<String,Object>  map=new HashMap<String, Object>();
		// add data  to shared memory   as  model attributes
	    map.put("sysDate", new Date());
		map.put("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return map;
	}
	*/
	
	/*@RequestMapping("/home")
	public  Model  showHomePage() {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name");
		//create  shared memory manually
		Model model=new BindingAwareModelMap();
		// add data  to shared memory   as  model attributes
	    model.addAttribute("sysDate", new Date());
		model.addAttribute("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return model;
	}*/
	
	/*@RequestMapping("/home")
	public  ModelAndView  showHomePage() {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name");
		//create  shared memory manually
		  ModelAndView mav=new ModelAndView();
		// add data  to shared memory   as  model attributes
		  mav.addObject("sysDate",new Date());
		  mav.addObject("age", new Random().nextInt());
		  // add LVN  to  MAV
		  mav.setViewName("welcome");
			return mav;
	}*/
	
	/*@RequestMapping("/home")
	public  String  showHomePage(Map<String,Object> map) {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+map.getClass());
		// add data  to shared memory   as  model attributes
		map.put("sysDate", new Date());
		map.put("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		//return "forward:report";
		return "redirect:report?sno=101&sname=raja";
	}	
	
	@RequestMapping("/report")
	public   String   showReport() {
		System.out.println("CustomerOperationsController.showReport()");
		//return  LVN
		return "show_report";
	}*/
	@Autowired
	private  ServletContext sc;
	@Autowired
	private  ServletConfig cg;
	
	/*@RequestMapping("/home")
	public  String  showHomePage(Map<String,Object> map,HttpServletRequest req,HttpServletResponse res,HttpSession ses) {
		System.out.println("CustomerOperationsController.showHomePage()::Shared Memory class name::"+map.getClass());
		System.out.println("Session obj id::"+ses.getId());
		
		System.out.println("req obj class name::"+req.getClass()+"...."+"res obj class name::"+res.getClass());
		System.out.println("web application name:"+sc.getContextPath()+".... Servlet logical name"+cg.getServletName());
		// add data  to shared memory   as  model attributes
		map.put("sysDate", new Date());
		map.put("age",new Random().nextInt(40));
		//return LVN (Logical View Name)
		return  "welcome";
	}*/
	
	@RequestMapping("/home")
	public  void showHomePage(HttpServletResponse res) throws Exception{
		//get Print Writer object
		res.addHeader("content-disposition", "attachment;filename=abc.html");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<b> hello, how are u  </b>");
	}
	
}
