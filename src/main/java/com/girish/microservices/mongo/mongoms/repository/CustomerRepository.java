package com.girish.microservices.mongo.mongoms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.girish.microservices.mongo.mongoms.bean.Customer;


public interface CustomerRepository extends MongoRepository<com.girish.microservices.mongo.mongoms.bean.Customer, String> {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}