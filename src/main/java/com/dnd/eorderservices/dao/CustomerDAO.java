package com.dnd.eorderservices.dao;

import java.util.List;

import com.dnd.eorderservices.model.Customer;

public interface CustomerDAO {
	
	public Customer saveCustomer(Customer customer);
	
	public List<Customer> findAllCustomers();
	
	public Customer getCustomerById(long id);
}
