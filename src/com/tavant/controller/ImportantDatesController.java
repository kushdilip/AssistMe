package com.tavant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.domain.Anniversary;
import com.tavant.domain.User;
import com.tavant.services.AnniversaryService;

@Controller
public class ImportantDatesController {
	private AnniversaryService anniversaryService;

	@Autowired
	public void setAnniversaryService(AnniversaryService anniversaryService) {
		this.anniversaryService = anniversaryService;
	}
	
	@RequestMapping("/importantDates")
	public ModelAndView showImportantDates(HttpServletRequest request, ModelMap model){
		
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("master");
		}
		
		int currentUserId = ((User)request.getSession().getAttribute("currentUser")).getUserId();
		
		List<Anniversary> anniversaryList = anniversaryService.selectAllAnniversaries(currentUserId);
		model.addAttribute(anniversaryList);
		return new ModelAndView("myImportantDates",model);
		
	}
	
	@RequestMapping("/deleteAnniversary")
	public ModelAndView deleteAnniversary(HttpServletRequest request, ModelMap model)
			throws Exception {
		
		// if user session is empty, return to master page
		if (request.getSession().getAttribute("currentUser") == null) {
			return new ModelAndView("master");
		}

		
		int anniversaryId = Integer.parseInt(request.getParameter("anniversaryId"));
		int userId = ((User)request.getSession().getAttribute("currentUser")).getUserId();
		
		System.out.println(anniversaryId + " " + userId);
		anniversaryService.deleteAnniversary(anniversaryId, userId);
		
		System.out.println("Deleted Anniversary: "
				+ request.getParameter("anniversaryTitle"));
		return showImportantDates(request, model);
	}
	
	
	
	
}
