package com.twpnn.demo.simpleblog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.twpnn.demo.simpleblog.form.GreetingForm;
import com.twpnn.demo.simpleblog.model.Color;
import com.twpnn.demo.simpleblog.model.Greeting;
import com.twpnn.demo.simpleblog.model.User;
import com.twpnn.demo.simpleblog.service.GreetingService;

@Controller
//@RequestMapping("/")
public class GreetingController {

	protected static Logger logger = Logger.getLogger("GreetingController");

	@Autowired
	private GreetingService greetingService;

	//public GreetingController() {}
	
	// note there is no actual greetings.html file!!
	@RequestMapping(value = "/addgreeting", method = RequestMethod.GET)
	public String showAddGreetingPage(
			@ModelAttribute("greetingform") GreetingForm greetingForm) {

		logger.info("entering showAddGreetingPage()");

		// no need to add colorlist to the model anymore since it is defined at
		// method level below
		// no need to have the model object in this method either

		// resolves to /WEB-INF/jsp/addgreeting.jsp
		return "addgreeting";
	}

	@ModelAttribute("colorlist")
	public List<Color> populateColorList() {
		// color list is hardcoded for now...
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(new Color("Indian Red", "F75D59"));
		colorList.add(new Color("Red", "FF0000"));
		colorList.add(new Color("Salmon", "F9966B"));
		colorList.add(new Color("Lemon Chiffon", "FFF8C6"));
		colorList.add(new Color("Olive Green", "BCE954"));
		colorList.add(new Color("Steel Blue", "C6DEFF"));
		colorList.add(new Color("Medium Purple", "9E7BFF"));
		return colorList;
	}

	//@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/greetings", method = RequestMethod.POST)
	public String addGreetingAndShowAll(
			@ModelAttribute("greetingform") GreetingForm greetingForm,
			Map<String, Object> model) {

		logger.info("entering addGreetingAndShowAll()");
		 
		Greeting greeting = greetingForm.getGreeting();
		greeting.setGreetingDate(new Date());
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		greeting.setUsername(user.getUsername());
		greetingService.addGreeting(greeting);  
 
		List<Greeting> greetings = greetingService.getAllGreetings();
		model.put("greetinglist", greetings);
 
	    	String selectedColorCode=greetingForm.getColor().getColorCode(); 
	    	if(selectedColorCode.equals("")) //if no color selected, then make default white
	    		selectedColorCode="FFFFFF";
	    	model.put("colorcode", selectedColorCode);
 
	    	// This will resolve to /WEB-INF/jsp/greetings.jsp
	    	return "greetings";
	}

	// define the same url with GET so users can skip to the greetings page
	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public String showAllGreetings(Map<String, Object> model) {

		logger.info("entering showAllGreetings");

		List<Greeting> greetings = greetingService.getAllGreetings();
		model.put("greetinglist", greetings);		
		model.put("colorcode", "FFFFFF");

		return "show"; // use tile definition instead of jsp page name
	}
}
