package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project2.Service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
private static final Object passwod = null;
@Autowired
LoginService loginservice;
@RequestMapping(value="/login", method=RequestMethod.GET)
public String showLoginPage(ModelMap model) {
	return "login";
}
@RequestMapping(value="/login", method=RequestMethod.POST)
public String showWelcomePage(ModelMap model, @RequestParam String name,@RequestParam String password) {
	boolean isValidUser= loginservice.validateUser(name, password);
	if(!isValidUser) {
		System.out.println(model.put("error message", "invalid credentials"));
		return "login";
	}
	else
	model.put("name", name);
	model.put("password", passwod);
	return "welcome";
	
}
}
