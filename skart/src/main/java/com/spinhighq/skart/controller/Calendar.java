package com.spinhighq.skart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Calendar {
	
	@RequestMapping(value="/Calendar", method=RequestMethod.GET)
	public String getCalender(){
		
		return "Calendar";
		
	}

}
