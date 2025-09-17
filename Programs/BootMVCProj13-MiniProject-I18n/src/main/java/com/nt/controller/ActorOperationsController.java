//Controller class
package com.nt.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class ActorOperationsController {
	@Autowired
	private IActorMgmtService  actorService;

	@GetMapping("/")  //for home page
	public  String  showHomePage() {
		System.out.println("ActorOperationsController.showHomePage444()");
		return "welcome";
	}
	
	@GetMapping("/report")  //G-Get
	public  String   showReport(Map<String,Object> map) {
		System.out.println("ActorOperationsController.showReport()");
		//use service
		List<ActorVO> list=actorService.showAllActors();
		//keep the resiult in shared memory
		map.put("listVO", list);
		map.put("sysDate",new Date());
		map.put("avg",0.45);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/page_report")  //G-Get
	public  String   showReport(@PageableDefault(page=0,size=3,sort="aname",direction = Direction.ASC) Pageable pageable,
			                                             Map<String,Object> map) {
		System.out.println("ActorOperationsController.showReport()");
		//use service
		Page<ActorVO> pageVO=actorService.showAllActorsByPagination(pageable);
		//keep the resiult in shared memory
		map.put("pageData", pageVO);
		//return LVN
		return "show_report_pagination";
	}

	
	@GetMapping("/register")
	public  String    showAddActorFormPage(@ModelAttribute("actor") ActorVO  vo) {
		System.out.println("ActorOperationsController.showAddActorFormPage()");
		return "register_actor_form";
	}
	
	/*@PostMapping("/register")  //P-POST
	public String    registerActor(Map<String,Object> map,
			                                                @ModelAttribute("actor") ActorVO vo) {
		System.out.println("ActorOperationsController.registerActor()");
		//use service
		String msg=actorService.registerActor(vo);
		//keep the results  in model attributes
		map.put("resultMsg",msg);
		//return LVN
		return "redirect:report";  // R-Rediret
	}*/
	
	/*	@PostMapping("/register")  //P-POST
		public String    registerActor(RedirectAttributes attrs,
				                                                @ModelAttribute("actor") ActorVO vo) {
			System.out.println("ActorOperationsController.registerActor()");
			//use service
			String msg=actorService.registerActor(vo);
			//keep the results  in model attributes
		    attrs.addFlashAttribute("resultMsg",msg);
			//return LVN
			return "redirect:report";  // R-Rediret
		}
	*/
	
	@PostMapping("/register")  //P-POST
	public String    registerActor(HttpSession ses,
			                                                @ModelAttribute("actor") ActorVO vo) {
		System.out.println("ActorOperationsController.registerActor()");
		//use service
		String msg=actorService.registerActor(vo);
		//keep the results  in model attributes
		ses.setAttribute("resultMsg",msg);
		//return LVN
		return "redirect:report";  // R-Rediret
	}
	
	@GetMapping("/edit")  // To show Edit Actor form page
	public  String  showEditActorFormPage(@RequestParam("no") int id,
			                                                                         @ModelAttribute("actor") ActorVO  vo) {
		//use service
		ActorVO vo1=actorService.showActorById(id);
		BeanUtils.copyProperties(vo1, vo);
		//return LVN
		return "edit_actor_form";
	}
	@PostMapping("/edit")
	public  String    editActor(@ModelAttribute("actor") ActorVO vo,RedirectAttributes  attrs) {
		//use service
		String msg=actorService.updateActor(vo);
		//keep the results in model attributes
		attrs.addFlashAttribute("resultMsg", msg);
		//redirect the request
		return "redirect:report";
	}
	
	@GetMapping("/remove")
	public  String  removeActorById(@RequestParam("no") int id,RedirectAttributes attrs) {
	   try {	
		//use service
		String msg=actorService.deleteActor(id);
		//keep result in  model attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect the request
		return "redirect:report";
	   }
	   catch(Exception e) {
		   //add error messages as the  flash attribute
		   attrs.addFlashAttribute("resultMsg",e.getMessage());
		   return "redirect:report";
	   }
	}
	
	
}
