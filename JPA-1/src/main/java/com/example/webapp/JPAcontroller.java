package com.example.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.webapp.database.Db;
import com.example.webapp.model.Jpamodel;
import com.example.webapp.service.Service;

@Controller
public class JPAcontroller {
	
	@Autowired
	Service service;
	@Autowired
	 Db db;
	@RequestMapping("/")
	public String page() {
		return "form";
		
	}
	@PostMapping("/loginform")
	public ModelAndView additem( Jpamodel robo) {
		service.addDetail(robo);
		ModelAndView mv=new ModelAndView("show");
		mv.addObject("obj", db);
		return mv;
		}
@RequestMapping("/getFetch")
public ModelAndView getDetial(@RequestParam int id,Jpamodel model) {
	return service.getDetail(id);	
}
}
