package com.dnd.eorderservices.service;

import java.util.List;

import com.dnd.eorderservices.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> findAllCustomers();

	public Customer getCustomerById(long id);
}
