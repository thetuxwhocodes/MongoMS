package com.girish.microservices.mongo.mongoms;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.girish.microservices.mongo.mongoms.bean.Customer;
import com.girish.microservices.mongo.mongoms.repository.CustomerRepository;


@RestController
@RequestMapping("/customer")
public class CustomerPersistenceController {

	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
	@GetMapping("/firstName")
	public List<Customer> getCustomerByFirstName(@RequestParam String firstName) {
		return repository.findByFirstName(firstName);
	}
	
	@GetMapping("/lastName")
	public List<Customer> getCustomerByLastName(@RequestParam String lastName) {
		return repository.findByLastName(lastName);
	}
	
	@PostMapping("/")
	public void createCustomer(@RequestBody Customer customer)
	{
		repository.save(customer);
	}

	@PutMapping("/")
	public void updateCustomer(@RequestBody Customer customer)
	{
		Objects.requireNonNull(customer.getId(), "Customer Id must be set for an Update operation.");
		repository.save(customer);
	}

	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable String customerId)
	{
		Customer customer = repository.findById(customerId).get();
		repository.delete(customer);
	}

}
