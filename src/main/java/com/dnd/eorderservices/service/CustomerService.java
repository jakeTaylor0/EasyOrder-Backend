package com.dnd.eorderservices.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.dnd.eorderservices.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	List<Customer> findAllCustomers();

	Customer getCustomerById(long customerId);

	Customer getCustomerByPhone(String phone);

	void updateCustomer(Customer customer);
}
