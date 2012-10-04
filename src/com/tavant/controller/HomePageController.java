package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@RequestMapping({"/","/index"})
	public String goMaster(HttpServletRequest request){
//		System.out.println("In home controller");		

		return "master";
	}
	
	@RequestMapping("/home")
	public String goHome() {
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("currentUser");
		return goMaster(request);
	}
}
