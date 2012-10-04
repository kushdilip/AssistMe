package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.domain.User;
import com.tavant.services.UserService;


@Controller
@SessionAttributes("currentUser")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
		
	}
	
	@RequestMapping(value="/userRegistration", method = RequestMethod.GET)
	public String addContactForm(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		return "userRegistrationForm";
	}

	@RequestMapping(value="/userRegistration", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("user") User user,
			BindingResult result, SessionStatus status) {
		ModelMap model = new ModelMap();

		userService.addUser(user);
		model.addAttribute(user);

		return new ModelAndView("userAddSuccess", model);
	}
	
	@RequestMapping("/login")
	public ModelAndView onLogin(HttpServletRequest request, ModelMap model){
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		ModelAndView modelView = new ModelAndView();
		
		User currentUser = userService.selectByEmailId(emailId);
//		System.out.println(currentUser);
		
		if (currentUser.getPassword().equals(password) && currentUser != null) {
			
			request.getSession().setAttribute("currentUser", currentUser);
			
			model.addAttribute(currentUser);
			modelView.addAllObjects(model);
			modelView.setViewName("home");
		}
		else {
			modelView.setViewName("master");
		}
		
		return modelView;
		
		
	}
	
	
	
	
}
