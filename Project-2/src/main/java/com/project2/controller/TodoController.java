package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project2.Service.LoginService;
import com.project2.Service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
@Autowired
TodoService todoservice;
@RequestMapping(value="list-todos")
public String showTodos(ModelMap model) {
	String name=(String) model.get("name");
	model.put("todos", todoservice.retrieveTodos(name));
	return"list-todos";
}}
