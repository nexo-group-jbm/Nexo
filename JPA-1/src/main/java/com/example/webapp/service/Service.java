package com.example.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.webapp.database.Db;
import com.example.webapp.model.Jpamodel;

@org.springframework.stereotype.Service
public class Service {
@Autowired
 Db db;
public String addDetail(Jpamodel model) {
	return db.save(model).toString();
}
public ModelAndView getDetail(@RequestParam int id) {
	ModelAndView mv=new ModelAndView("show");
	Jpamodel model=db.findById(id).orElse(new Jpamodel());
	return mv.addObject("obj",model);
}
}
