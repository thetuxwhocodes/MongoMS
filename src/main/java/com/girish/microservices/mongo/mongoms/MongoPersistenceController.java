package com.girish.microservices.mongo.mongoms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.girish.microservices.mongo.mongoms.bean.Customer;
import com.girish.microservices.mongo.mongoms.repository.CustomerRepository;


@RestController
public class MongoPersistenceController {

	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Let's do some Mongo Persistence!!";
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
	@GetMapping("/customerByName")
	public List<Customer> getCustomerByName(@RequestParam String firstName) {
		return repository.findByFirstName(firstName);
	}

}
