package com.dnd.eorderservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer-services")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomers(){
		return this.customerRepo.findAll(); 
	}
}
