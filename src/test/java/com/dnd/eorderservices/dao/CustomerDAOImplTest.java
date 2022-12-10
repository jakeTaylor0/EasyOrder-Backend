package com.dnd.eorderservices.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerDAOImplTest {
	@InjectMocks
	private CustomerDAOImpl customerDAO;
	
	@Mock
	private CustomerRepo customerRepo;
	
	@Test
	public void testSaveCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231231324");
		
		Mockito.when(customerRepo.save(c1)).thenReturn(c1);
		customerDAO.saveCustomer(c1);
	}
	
	@Test
	public void testFindAllCustomers() {
		List<Customer> allCustomers = new ArrayList<>();
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231231324");
		allCustomers.add(c1);
		Mockito.when(customerRepo.findAll()).thenReturn(allCustomers);
		customerDAO.findAllCustomers();
	}
	
	@Test
	public void testGetCustomerById() {
		Optional<Customer> c1 = Optional.ofNullable(new Customer());
		c1.get().setCustomerId(1L);
		c1.get().setName("John Doe");
		c1.get().setPhone("11231231324");
		
		Mockito.when(customerRepo.findById(1L)).thenReturn(c1);
		customerDAO.getCustomerById(1L);
	}
	
	@Test
	public void updateCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("Jane Doe");
		c1.setPhone("11231231324");
		Mockito.doNothing().when(customerRepo).updateCustomer(Mockito.anyString(), Mockito.anyString());
		customerDAO.updateCustomer(c1);
	}
	
	@Test
	public void testGetCustomerByPhone() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231231324");
		
		Mockito.when(customerRepo.findByPhone(Mockito.anyString())).thenReturn(c1);
		customerDAO.getCustomerByPhone("11231231324");
	}
}
