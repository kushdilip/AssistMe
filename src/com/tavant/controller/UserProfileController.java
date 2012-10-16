package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.domain.User;

@Controller
public class UserProfileController {

	@RequestMapping(value = "/profile")
	public ModelAndView showProfile(HttpServletRequest request, ModelMap model) {
		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("redirect:login.html");
		}
		
		return new ModelAndView("profilePage");

	}

}
