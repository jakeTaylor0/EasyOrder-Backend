package com.dnd.eorderservices.service;

import java.util.List;

import com.dnd.eorderservices.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	List<Customer> findAllCustomers();

	Customer getCustomerById(long id);

	void updateCustomer(Customer customer);

	Customer getCustomerByPhone(String phone);
}
