package com.cors.Controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cors.Model.Greeting;

@RestController
public class GreetingController {
private static final String template= "Hello,%s!";
private final AtomicLong counter = new AtomicLong();

@GetMapping("/greeting")
@CrossOrigin(origins="http://localhost:9000")

public Greeting greeting(@RequestParam( defaultValue="") String name) {
	System.out.println("=========In Greeting=======");
	return new Greeting(counter.incrementAndGet(), String.format(template, name));
}
}
