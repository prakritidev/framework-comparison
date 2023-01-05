package com.prakritidev.verma.javasever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JavaseverApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaseverApplication.class, args);
	}

}

@RestController
@RequestMapping
class Controller {

	@GetMapping(path = "/")
	public String helloWorld(@RequestParam String input) {
		var hash = 0; 
		var i = 0;
		char chr;
  		if (input.length() == 0) return "0";
		for (i = 0; i < input.length(); i++) {
			chr = input.charAt(i);
			hash = ((hash << 5) - hash) + chr;
			hash |= 0; // Convert to 32bit integer
		}
		

		return String.valueOf(hash);
	}

}
