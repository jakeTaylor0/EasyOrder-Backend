package com.dnd.eorderservices.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.eorderservices.dao.CustomerDAO;
import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
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
	public Customer getCustomerById(long customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	public Customer getCustomerByPhone(String phone) {
		return customerDAO.getCustomerByPhone(phone);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}
}
