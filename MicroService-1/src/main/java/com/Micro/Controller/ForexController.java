package com.Micro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.Model.ExchangeValue;
import com.Micro.Repo.ExchangeValueRepo;

@RestController
public class ForexController {
	@Autowired
	private Environment environment;
@Autowired
private ExchangeValueRepo exchangeValueRepo;

@GetMapping("/current/form/{from}/to/{to}")
public ExchangeValue retrieveValue(@PathVariable String from, @PathVariable String to) {
	ExchangeValue exchangeValue =exchangeValueRepo.findByFromAndTo(from, to);
	exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	return exchangeValue;
	
	
}



}
