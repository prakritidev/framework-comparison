package com.prakritidev.verma.javasever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String helloWorld() {
		return "Hello World!";
	}

}
