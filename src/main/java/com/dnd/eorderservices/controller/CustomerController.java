package com.dnd.eorderservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;
import com.dnd.eorderservices.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer-services")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomers(){
		return this.customerService.findAllCustomers();
	}
	
	@PostMapping("/saveCustomer")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
}
