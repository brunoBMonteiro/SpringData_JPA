package com.example.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

import java.util.List;


@RestController
@RequestMapping("/data")
public class CustomerController {
	@Autowired
	CustomerRepository crepository;

	@GetMapping("/")
	public Iterable<Customer>getIterable() {
		return crepository.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Customer> getIterable(@PathVariable Long id) {
		return crepository.findById(id);
	}
	@GetMapping("/name/{lastName}")
	public List<Customer> findByLastName(@PathVariable String lastName){
		List<Customer> list = crepository.findByLastName(lastName);
		return list;
	}
	
	
}