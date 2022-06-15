package com.dnd.eorderservices.dao;

import java.util.List;

import com.dnd.eorderservices.model.Customer;

public interface CustomerDAO {
	
	Customer saveCustomer(Customer customer);
	
	List<Customer> findAllCustomers();
	
	Customer getCustomerById(long customerId);

	Customer getCustomerByPhone(String phone);

	void updateCustomer(Customer customer);
}
