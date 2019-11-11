package com.example.webapp.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.model.Model2;
import com.example.webapp.model.Repo.Repo;





@CrossOrigin(origins = "*")
@RestController
public class Controller {

    private static Logger logger = LoggerFactory.getLogger(Controller.class);
	
    @Autowired
    private Repo repo;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public HttpEntity<String> sanityCheck() {
    	
    	logger.info("SanityCheck entered...");
    	
		// Return some HTML
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_PLAIN);
    	
    	String msg = "It's alive! It's alive!";
    	
    	return new HttpEntity<String>(msg, headers);	
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{id:[\\d]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Model2 getUser(@PathVariable("id") String id) {

    	logger.info("getUser entered: id= " + id);
    	
    	return repo.findOne(id);   	
    }
    
	@RequestMapping(value="/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<Model2> getUsers() {
    	
    	logger.info("findAll entered...");
    	
		return repo.findAll();
	}

	@RequestMapping(value="/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Model2 saveUser(@RequestBody Model2 u) {
    	
    	logger.info("saveUser entered...");
    	
		Model2 newUser = new Model2();
		newUser = repo.save(u);
		return newUser;
	}
}