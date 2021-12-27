package com.dnd.eorderservices.dao;

import java.util.List;

import com.dnd.eorderservices.model.Customer;

public interface CustomerDAO {
	
	public void saveCustomer(Customer customer);
	
	public List<Customer> findAllCustomers();
}
