package com.dnd.eorderservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getCustomerById")
	public ResponseEntity<Object> getCustomerById(@RequestParam(name="id") long id) {
		try {
			Customer customer = customerService.getCustomerById(id);
			return new ResponseEntity<Object>(customer, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>("ID NOT FOUND", HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
		try {
			Customer c = customerService.addCustomer(customer);
			
			if(c != null)
				return new ResponseEntity<Object>(c, HttpStatus.OK);
			else
				return new ResponseEntity<Object>("Missing name/phone", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>("Failed to process request", HttpStatus.BAD_REQUEST);
		}
	}
}
