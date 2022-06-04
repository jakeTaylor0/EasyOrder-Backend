package com.dnd.eorderservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.eorderservices.dao.CustomerDAO;
import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public Customer addCustomer(Customer customer){
		return customerDAO.saveCustomer(customer);
	}
	
	@Override
	public List<Customer> findAllCustomers(){
		return customerDAO.findAllCustomers();
	}
	
	@Override
	public Customer getCustomerById(long id) {
		return customerDAO.getCustomerById(id);
	}
}
