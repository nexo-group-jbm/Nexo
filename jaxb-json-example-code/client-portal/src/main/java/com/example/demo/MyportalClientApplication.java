package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class MyportalClientApplication {
	@GetMapping("/")
	public String  home() {
		return "NewFile";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyportalClientApplication.class, args);
	}

}
	