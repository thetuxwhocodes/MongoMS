package com.girish.microservices.mongo.mongoms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SimpleHelloController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Let's do some Mongo Persistence!!!";
	}
}
