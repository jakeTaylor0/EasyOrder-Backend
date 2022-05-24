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
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer addCustomer(Customer customer){
		
		if(customer.getName().length() > 0 || customer.getPhone().length() > 0)
			return customerDAO.saveCustomer(customer);
		else
			return null;
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
