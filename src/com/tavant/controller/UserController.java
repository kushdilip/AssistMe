package com.tavant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.tavant.domain.Contact;
import com.tavant.domain.Transaction;
import com.tavant.domain.User;
import com.tavant.services.ContactService;
import com.tavant.services.TransactionService;
import com.tavant.services.UserService;
import com.tavant.validator.LoginValidator;
import com.tavant.validator.RegistrationValidator;

@Controller
@SessionAttributes({"currentUser","contactsList","transHashMap"})
public class UserController {
	private UserService userService;
	private ContactService contactService;
	private LoginValidator loginValidator;
	private RegistrationValidator regisValidator;
	private TransactionService transactionService;
	
	@Autowired
	public UserController(UserService userService,
			ContactService contactService, LoginValidator loginValidator,
			RegistrationValidator regisValidator,
			TransactionService transactionService) {
		super();
		this.userService = userService;
		this.contactService = contactService;
		this.loginValidator = loginValidator;
		this.regisValidator = regisValidator;
		this.transactionService = transactionService;
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String addContactForm(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		return "userRegistrationForm";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("user") User user,
			BindingResult result, SessionStatus status) {
		ModelMap model = new ModelMap();
		regisValidator.validate(user, result);
		
		if(result.hasErrors()){
			return new ModelAndView("userRegistrationForm");
		}
		
		userService.addUser(user);
		model.addAttribute(user);

		return new ModelAndView("userAddSuccess", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPageLoad(HttpServletRequest request) {
		User user = new User();
		ModelMap model = new ModelMap();
		model.addAttribute(user);

		return new ModelAndView("master", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView onLogin(@ModelAttribute("user") User user,
			BindingResult result, HttpServletRequest request) {

		loginValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("master");
		}

		//setting up session attribute currentUser
		User currentUser = loginValidator.getValidUser();
		request.getSession().setAttribute("currentUser", currentUser);

		//setting up session attribute contactList
		List<Contact> contactsList = contactService
				.selectAllContacts(currentUser.getUserId());
		request.getSession().setAttribute("contactsList", contactsList);
		
		//putting users transaction in a hashmap
		List<Transaction> transactions = transactionService.selectAll(currentUser.getUserId());
		HashMap<Integer, Transaction> transMap = new HashMap<Integer, Transaction>();
		for (Transaction transaction : transactions) {
			transMap.put(transaction.getContactId(),transaction);
		}
		request.getSession().setAttribute("transHashMap", transMap);
//		System.out.println(request.getSession().getAttribute("transHashMap"));
		
		return new ModelAndView("redirect:home.html");		
	}

	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("currentUser");
		return "redirect:login.html";
	}

}
