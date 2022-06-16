package com.dnd.eorderservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.model.Response;
import com.dnd.eorderservices.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer-services")
public class CustomerController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public ResponseEntity<Response> getAllCustomers(){
		LOGGER.info("Controller getting all customer details");
		List<Customer> customerList = customerService.findAllCustomers();
		return new ResponseEntity<Response>(new Response("200", "All customers within our db", customerList), HttpStatus.OK);
	}
	
	@PostMapping("/getCustomerById")
	public ResponseEntity<Response> getCustomerById(@PathVariable("id") String id) {
		LOGGER.info("Controller getting all customer details with id: {}", id);
		Customer customer = customerService.getCustomerById(id);
		try {
			return new ResponseEntity<Response>(new Response("200", "Customer was retrieved successfully with id:" + id, customer), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Response>(new Response("404", "No customer data found with id: " + id, customer), HttpStatus.OK);
		}
	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Response> saveCustomer(@RequestBody Customer customer) {
		try {
			LOGGER.info("Controller saving customer info: {}", customer);
			Customer c = customerService.addCustomer(customer);
			if(!c.getName().equals("") || !c.getPhone().equals("")
			 || c.getName() != null || c.getPhone() != null)
				return new ResponseEntity<Response>(new Response("200", "Customer info was saved successfully", c), HttpStatus.OK);
			
			else
				return new ResponseEntity<Response>(new Response("400", "Bad Request", customer), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Response>(new Response("200", "", customerService.addCustomer(customer)), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getCustomerByPhone")
	public ResponseEntity<Response> getCustomerByPhone(@RequestParam(name="phone") String phone){
		LOGGER.info("Controller geting customer details with phone: {}", phone);
		Customer c = customerService.getCustomerByPhone(phone);
		if(c != null)
			return new ResponseEntity<Response>(new Response("200", "Customer data found with phone: " + phone, c), HttpStatus.OK);
		else
			return new ResponseEntity<Response>(new Response("404", "Customer data not found with phone: " + phone, c), HttpStatus.OK);
	}
	/*
	@PostMapping("/updateCustomer")
	public ResponseEntity<Response> updateCustomerNameByPhone(@RequestBody Customer customer) {
		LOGGER.info("Controller updating customer details: {}", customer);
		customerService.updateCustomer(customer);
		return new ResponseEntity<Response>(new Response("200", "Customer information was udpated successfully", customerService.getCustomerById(customer.getCustomerId())), HttpStatus.OK);
	}*/
}
