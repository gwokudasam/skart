package com.spinhighq.skart.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spinhighq.skart.model.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String doLogin() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(required = false) String authfailed,String logout,String denied) {
		
		
		String message = "";
		System.out.println("Error message:"+authfailed+","+logout+","+denied);
		if (authfailed != null) {
			message = "Invalid username or password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		
		
		System.out.println("Error message:"+message);
		
		return new ModelAndView("login", "message", message);

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String doIndex(Model model, Principal principal) {
		/*User user=null;
		if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
		{
			user =  service.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
		}
		if(user!=null)
		{
			if(user.get)
		}*/
		//String userName = principal.getName();
		model.addAttribute("msg", "u r login success");
		return "index";
	}
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String doDashBoard(Model model, Principal principal) {
		/*User user=null;
		if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
		{
			user =  service.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
		}
		if(user!=null)
		{
			if(user.get)
		}*/
		//String userName = principal.getName();
		//model.addAttribute("msg", "u r login success");
		return "dashboard";
	}
	/*@RequestMapping(value="/student")
	public String studentHome(){
		
		return "student";
	}*/
	/*@RequestMapping(value="/Student_Table")
	public String studentDetails(){
		
		return "index";
	}*/
	/*@RequestMapping(value="/Student_Table")
	public String studentTableHome(){
		
		return "Student_Table";
	
	}*/
	@RequestMapping("403page")
	 public String ge403denied() {
	  return "redirect:login?denied";
	 }
}
