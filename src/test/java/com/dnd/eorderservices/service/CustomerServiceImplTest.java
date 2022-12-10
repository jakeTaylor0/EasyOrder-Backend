package com.dnd.eorderservices.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dnd.eorderservices.dao.CustomerDAO;
import com.dnd.eorderservices.model.Customer;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceImplTest {
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Mock
	private CustomerDAO customerDAO;
	
	@Test
	public void testAddCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231234");
		
		Mockito.when(customerDAO.saveCustomer(c1)).thenReturn(c1);
		customerService.addCustomer(c1);
	}
	
	@Test
	public void testFindAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231234");
		customerList.add(c1);
		Mockito.when(customerDAO.findAllCustomers()).thenReturn(customerList);
		customerService.findAllCustomers();
	}
	
	@Test
	public void testGetCustomerByCustomerId() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231234");
		String customerId = String.valueOf(c1.getCustomerId());
		Mockito.when(customerDAO.getCustomerById(Mockito.anyLong())).thenReturn(c1);
		customerService.getCustomerById(customerId);
	}
	
	@Test
	public void testGetCustomerByCustomerPhone() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("John Doe");
		c1.setPhone("11231234");

		Mockito.when(customerDAO.getCustomerByPhone(Mockito.anyString())).thenReturn(c1);
		customerService.getCustomerByPhone(Mockito.anyString());
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		c1.setName("Jane Doe");
		c1.setPhone("11231234");
		Mockito.doNothing().when(customerDAO).updateCustomer(c1);
		customerService.updateCustomer(Mockito.any());
	}
}
