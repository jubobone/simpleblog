package com.twpnn.demo.simpleblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.twpnn.demo.simpleblog.model.AvailabilityStatus;
import com.twpnn.demo.simpleblog.model.User;
import com.twpnn.demo.simpleblog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		return model;
	}

	@RequestMapping(value = "/save")
	public String save(User user) {
		try {
			userService.save(user);
			return "redirect:/login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/register/availability", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public AvailabilityStatus getEmailAvailability(@RequestParam String email) {
		boolean isAvailable = false; 
		try {
			isAvailable = userService.findByEmail(email).isEmpty();
			System.out.println("email " + email + " is available? " + isAvailable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new AvailabilityStatus("valid", isAvailable);
	}
	
}
