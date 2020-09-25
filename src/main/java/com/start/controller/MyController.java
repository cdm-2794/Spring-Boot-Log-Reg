package com.start.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.start.model.User;
import com.start.services.UserService;

@Controller
@RequestMapping("/all")
public class MyController {
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping ("/welcome")
	public String Welcome(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute ("User") User user , BindingResult bindingResult, HttpServletRequest request) {
		UserService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		System.out.println( "Information" + user.getFirstname());
		return "welcomepage" ;	
	}

	@GetMapping("/show-users")
	public String ShowAlusers(HttpServletRequest request)
	{
		request.setAttribute("user", UserService.showallUser());
		request.setAttribute("mode", "ALL_USERS"); 
		return "welcomepage" ;
		
	}
	
}
